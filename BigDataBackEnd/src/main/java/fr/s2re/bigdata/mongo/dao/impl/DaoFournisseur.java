package fr.s2re.bigdata.mongo.dao.impl;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.s2re.bigdata.dao.AbstractDAO;
import fr.s2re.bigdata.mongo.idao.IDaoFournisseur;

public class DaoFournisseur extends AbstractDAO implements IDaoFournisseur {
    public DaoFournisseur() {
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		MongoCollection<Document> coll = db.getCollection("products");
		setDbCollection(coll);
	}
	
	
	public fr.s2re.bigdata.entity.Fournisseur getBestFournisseur() {
		// TODO Auto-generated method stub
		return null;
	}

}
