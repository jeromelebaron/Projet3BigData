package fr.s2re.bigdata.backend.mongo.dao.impl;

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

import fr.s2re.bigdata.backend.dao.AbstractDAO;
import fr.s2re.bigdata.backend.mongo.idao.IDaoConnexion;

public class DaoConnexion extends AbstractDAO implements IDaoConnexion {

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Integer> getConnexionQteConnexionByRegion() {
        final Map<String, Integer> resultats = new HashMap<>();
        final MongoConnexion localMongoConnexion = new MongoConnexion();
        final MongoClient client = localMongoConnexion.getMongoClient();
        final MongoDatabase dataBase = client.getDatabase("client");
        final MongoCollection<Document> collection = dataBase.getCollection("connexion");

        final Document group = Document.parse("{$group:{_id:'$region.nomRegion',qte:{$sum:1}}}");
        final Document sort = Document.parse("{$sort:{qte:-1}}");

        final List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);

        final AggregateIterable<Document> iterable = collection.aggregate(operations);
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
