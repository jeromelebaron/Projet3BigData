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
import fr.s2re.bigdata.backend.mongo.idao.IDaoConnexion;
import fr.s2re.bigdata.backend.wrapper.ConnexionRegionWrapper;

public class DaoConnexion extends AbstractDAO implements IDaoConnexion {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ConnexionRegionWrapper> getConnexionQteConnexionByRegion() {
        final List<ConnexionRegionWrapper> resultats = new ArrayList<>();
        final MongoConnexion localMongoConnexion = new MongoConnexion();
        final MongoClient client = localMongoConnexion.getMongoClient();
        final MongoDatabase dataBase = client.getDatabase("client");
        final MongoCollection<Document> collection = dataBase.getCollection("connexion");

        final Document group = Document.parse("{$group:{_id:'$region.nomRegion',qte:{$sum:1}}}");

        final List<Document> operations = new ArrayList<>();
        operations.add(group);

        final AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                final ConnexionRegionWrapper localConnexionRegionWrapper = new ConnexionRegionWrapper();
                localConnexionRegionWrapper.setNomRegion(document.getString("_id"));
                localConnexionRegionWrapper.setQteConnexion(document.getInteger("qte"));
                resultats.add(localConnexionRegionWrapper);
            }
        });
        client.close();
        return resultats;
    }

}
