package fr.s2re.bigdata.mongo.dao.impl;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.dao.AbstractDAO;
import fr.s2re.bigdata.entity.Connexion;
import fr.s2re.bigdata.mongo.idao.IDaoConnexion;

public class DaoConnexion extends AbstractDAO implements IDaoConnexion {

    public DaoConnexion() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> coll = db.getCollection("products");
        setDbCollection(coll);
    }

    public Connexion getConnexionByUtilisateur() {
        return null;
    }

}
