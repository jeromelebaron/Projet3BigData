package fr.s2re.bigdata.mongo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.dao.AbstractDAO;
import fr.s2re.bigdata.mongo.idao.IDaoFournisseur;

public class DaoFournisseur extends AbstractDAO implements IDaoFournisseur {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    @Override
    public List<String> getTroisBestFournisseur() {
        final List<String> meilleuresFournisseurs = new ArrayList<>();
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("connexion");

        Document group = Document.parse("{$group:{_id:'$produit.fournisseur.nom',qte:{$sum:1}}}");
        Document sort = Document.parse("{$sort:{qte:-1}}");
        Document limit = Document.parse("{$limit:3}");

        List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);
        operations.add(limit);

        AggregateIterable<Document> iterable = collection.aggregate(operations);
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
