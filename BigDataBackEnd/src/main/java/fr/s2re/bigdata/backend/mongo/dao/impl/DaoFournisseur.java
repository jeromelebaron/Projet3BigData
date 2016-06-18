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

public class DaoFournisseur extends AbstractDAO implements IDaoFournisseur {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getTroisBestFournisseur() {
        final List<String> meilleuresFournisseurs = new ArrayList<>();
        final MongoConnexion localMongoConnexion = new MongoConnexion();
        final MongoClient client = localMongoConnexion.getMongoClient();
        final MongoDatabase dataBase = client.getDatabase("client");
        final MongoCollection<Document> collection = dataBase.getCollection("connexion");

        final Document group = Document
                .parse("{$group:{_id:'$produit.fournisseur.nom',qte:{$sum:1}}}");
        final Document sort = Document.parse("{$sort:{qte:-1}}");
        final Document limit = Document.parse("{$limit:3}");

        final List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);
        operations.add(limit);

        final AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                String nomFournisseur = document.getString("_id");
                meilleuresFournisseurs.add(nomFournisseur);
            }
        });
        client.close();
        return meilleuresFournisseurs;
    }

}
