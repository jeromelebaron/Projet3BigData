/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business.ajout;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.business.ConnexionBusiness;
import fr.s2re.bigdata.business.util.UtilAleatoire;
import fr.s2re.bigdata.entity.Connexion;

/**
 * Pour remplir la base connexion.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class AjoutBaseConnexion {

    private static final Logger LOGGER = Logger.getLogger(AjoutBaseConnexion.class);
    /**
     * URL de la base mongo.
     */
    private static final String HOST = "localhost";
    /**
     * Port de la base mongo.
     */
    private static final int PORT = 27017;

    private AjoutBaseConnexion() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("connexion");
        for (int localI = 0; localI < 500000; localI++) {
            int idRegion = 1;
            if (localI > 11458) {
                idRegion = 2;
            }
            if (localI > 44859) {
                idRegion = 3;
            }
            if (localI > 92519) {
                idRegion = 4;
            }
            if (localI > 98759) {
                idRegion = 5;
            }
            if (localI > 118318) {
                idRegion = 6;
            }
            if (localI > 158732) {
                idRegion = 7;
            }
            if (localI > 228758) {
                idRegion = 8;
            }
            if (localI > 241975) {
                idRegion = 9;
            }
            if (localI > 341862) {
                idRegion = 10;
            }
            if (localI > 355842) {
                idRegion = 11;
            }
            if (localI > 382654) {
                idRegion = 12;
            }
            if (localI > 420912) {
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
        LOGGER.info("Fini");
        client.close();
    }

}
