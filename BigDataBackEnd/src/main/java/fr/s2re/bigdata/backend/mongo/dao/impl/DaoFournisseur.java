package fr.s2re.bigdata.backend.mongo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.backend.dao.AbstractDAO;
import fr.s2re.bigdata.backend.mongo.idao.IDaoFournisseur;
import fr.s2re.bigdata.backend.wrapper.FournisseurWrapper;

public class DaoFournisseur extends AbstractDAO implements IDaoFournisseur {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FournisseurWrapper> getBestFournisseur(int nbMax) {
        final List<FournisseurWrapper> meilleuresFournisseurs = new ArrayList<>();
        final MongoConnexion localMongoConnexion = new MongoConnexion();
        final MongoClient client = localMongoConnexion.getMongoClient();
        final MongoDatabase dataBase = client.getDatabase("client");
        final MongoCollection<Document> collection = dataBase.getCollection("lignesCommande");

        final Document group = Document
                .parse("{$group:{_id:'$produit.fournisseur.nomFournisseur',qte:{$sum:1}}}");
        final Document sort = Document.parse("{$sort:{qte:-1}}");
        final Document limit = Document.parse("{$limit:" + nbMax + "}");

        final List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);
        operations.add(limit);

        final AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                final FournisseurWrapper fournisseurWrapper = new FournisseurWrapper();
                fournisseurWrapper.setNom(document.getString("_id"));
                 meilleuresFournisseurs.add(fournisseurWrapper);
            }
        });
        client.close();
        return meilleuresFournisseurs;
    }

}
