/*
 * Créé le 16 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.ajout;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class AjoutDonnees {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            MongoClient client = new MongoClient(HOST, PORT);
            MongoDatabase dataBase = client.getDatabase("client");
            System.out.println("connexion réussie");
            client.close();
        } catch (Exception e) {
            System.out.println("Erreur de connexion");
            e.printStackTrace();
        }
    }

}
