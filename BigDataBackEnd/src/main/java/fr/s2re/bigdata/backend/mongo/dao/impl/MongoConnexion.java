/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.backend.mongo.dao.impl;

import com.mongodb.MongoClient;

/**
 * Pour les différents utilitaires liés à MongoDb
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class MongoConnexion {

    /**
     * L'hote de la base.
     */
    private static final String HOST = "localhost";
    /**
     * Le port de la bdd mongo.
     */
    private static final int PORT = 27017;

    /**
     * Pour récupérer une connexion à MongoDb.
     * @return une connexion à Mongo.
     */
    public MongoClient getMongoClient() {
        return new MongoClient(HOST, PORT);
    }

}
