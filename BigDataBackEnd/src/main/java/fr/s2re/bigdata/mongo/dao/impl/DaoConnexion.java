package fr.s2re.bigdata.mongo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.dao.AbstractDAO;
import fr.s2re.bigdata.mongo.idao.IDaoConnexion;

public class DaoConnexion extends AbstractDAO implements IDaoConnexion {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    @Override
    public Map<String, Integer> getConnexionQteConnexionByRegion() {
        final Map<String, Integer> resultats = new HashMap<>();
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("connexion");

        Document group = Document.parse("{$group:{_id:'$region.nomRegion',qte:{$sum:1}}}");
        Document sort = Document.parse("{$sort:{qte:-1}}");

        List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);

        AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                String nomRegion = document.getString("_id");
                int qte = document.getInteger("qte");
                resultats.put(nomRegion, qte);
            }
        });
        client.close();
        return resultats;
    }

}
