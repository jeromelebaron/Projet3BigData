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

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoProduit implements IDaoProduit {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getDixMeilleuresVentes() {
        final List<String> meilleuresVentes = new ArrayList<>();
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("connexion");

        Document group = Document.parse("{$group:{_id:'$produit.idProduit',qte:{$sum:1}}}");
        Document sort = Document.parse("{$sort:{qte:-1}}");
        Document limit = Document.parse("{$limit:10}");

        List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);
        operations.add(limit);

        AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                String refProduit = document.getString("_id");
                meilleuresVentes.add(refProduit);
            }
        });
        client.close();
        return meilleuresVentes;
    }

}
