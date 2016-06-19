/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.backend.mongo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.backend.mongo.idao.IDaoProduit;
import fr.s2re.bigdata.backend.wrapper.ProduitWrapper;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoProduit implements IDaoProduit {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProduitWrapper> getMeilleuresVentes(int nbMaxVentes) {
        final List<ProduitWrapper> meilleuresVentes = new ArrayList<>();
        MongoConnexion localMongoConnexion = new MongoConnexion();
        MongoClient client = localMongoConnexion.getMongoClient();
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("lignesCommande");

        Document group = Document.parse("{$group:{_id:'$produit',qte:{$sum:1}}}");
        Document sort = Document.parse("{$sort:{qte:-1}}");
        Document limit = Document.parse("{$limit:" + nbMaxVentes + "}");

        List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);
        operations.add(limit);

        AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                ProduitWrapper produitWrapper = new ProduitWrapper();
                produitWrapper.setReference(document.getString("_id"));
                meilleuresVentes.add(produitWrapper);
            }
        });
        client.close();
        return meilleuresVentes;
    }

}
