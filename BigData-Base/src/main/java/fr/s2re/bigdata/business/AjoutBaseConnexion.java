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
        for (int localI = 0; localI < 500000; localI++) {
            int idRegion = 1;
            if (localI > 10000) {
                idRegion = 2;
            }   
            if (localI > 40000) {
                idRegion = 3;
            }
            if (localI > 90000) {
                idRegion = 4;
            }
            if (localI > 98000) {
                idRegion = 5;
            }
            if (localI > 118000) {
                idRegion = 6;
            }
            if (localI > 158000) {
                idRegion = 7;
            }
            if (localI > 228000) {
                idRegion = 8;
            }
            if (localI > 240000) {
                idRegion = 9;
            }
            if (localI > 300000) {
                idRegion = 10;
            }
            if (localI > 355000) {
                idRegion = 11;
            }
            if (localI > 380000) {
                idRegion = 12;
            }
            if (localI > 420000) {
                idRegion = 13;
            }
            Connexion connexion = ConnexionBusiness.getUneConnexion(
                    UtilAleatoire.getIntAlea(1, 1000), idRegion);
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
