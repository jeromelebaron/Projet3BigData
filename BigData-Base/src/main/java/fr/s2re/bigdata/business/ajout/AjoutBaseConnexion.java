/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business.ajout;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.business.ConnexionBusiness;
import fr.s2re.bigdata.business.elasticsearch.ElasticPost;
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
        ElasticPost elasticPost = new ElasticPost();
        MongoCollection<Document> collection = dataBase.getCollection("connexion");
        for (int localI = 0; localI < 100; localI++) {
            int idRegion = 1;
            String jourSemaine = "Lundi";
            if (localI > 10) {
                idRegion = 2;
                jourSemaine = "Mercredi";
            }
            if (localI > 12) {
                idRegion = 3;
            }
            if (localI > 15) {
                idRegion = 4;
                jourSemaine = "Dimanche";
            }
            if (localI > 18) {
                idRegion = 5;
            }
            if (localI > 27) {
                idRegion = 6;
                jourSemaine = "Samedi";
            }
            if (localI > 42) {
                idRegion = 7;
                jourSemaine = "Mardi";
            }
            if (localI > 48) {
                idRegion = 8;
                jourSemaine = "Jeudi";
            }
            if (localI > 60) {
                idRegion = 9;
                jourSemaine = "Vendredi";
            }
            if (localI > 76) {
                idRegion = 10;
                jourSemaine = "Mardi";
            }
            if (localI > 80) {
                idRegion = 11;
                jourSemaine = "Samedi";
            }
            if (localI > 90) {
                idRegion = 12;
                jourSemaine = "Dimanche";
            }
            if (localI > 95) {
                idRegion = 13;
            }
            Connexion connexion = ConnexionBusiness.getUneConnexion(
                    UtilAleatoire.getIntAlea(1, 1000), idRegion);
            connexion.setJourSemaine(jourSemaine);
            Document documentConnexion = new Document();
            documentConnexion.append("idClient", connexion.getIdClient());
            documentConnexion.append("dureeConnexion", connexion.getDuree());
            documentConnexion.append("jourSemaine", connexion.getJourSemaine());
            Document documentRegion = new Document();
            documentRegion.append("idRegion", connexion.getRegion().getId());
            documentRegion.append("nomRegion", connexion.getRegion().getNom());
            documentConnexion.append("region", documentRegion);
            collection.insertOne(documentConnexion);
            try {
                elasticPost.postToElastic(documentConnexion, "connexion", "uneConnexion",
                        String.valueOf(localI));
            } catch (UnsupportedEncodingException e) {
                LOGGER.error(e);
            }
        }
        LOGGER.info("Fini");
        client.close();
    }
}
