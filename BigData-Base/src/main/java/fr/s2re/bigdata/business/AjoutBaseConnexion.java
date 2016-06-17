/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.business.util.UtilAleatoire;
import fr.s2re.bigdata.entity.Connexion;

/**
 * Description de la classe
 * 
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class AjoutBaseConnexion {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("connexion");
        for (int localI = 0; localI < 50; localI++) {
            Connexion connexion = ConnexionBusiness.getUneConnexion(UtilAleatoire.getIntAlea(1, 1000));
            Document documentConnexion = new Document();
            documentConnexion.append("idClient", connexion.getIdClient());
            documentConnexion.append("dureeConnexion", connexion.getDuree());
            Document documentRegion = new Document();
            documentRegion.append("idRegion", connexion.getRegion().getId());
            documentRegion.append("nomRegion", connexion.getRegion().getNom());
            documentConnexion.append("region", documentRegion);
            collection.insertOne(documentConnexion);
        }
        System.out.println("Fini");
        client.close();
    }

}

