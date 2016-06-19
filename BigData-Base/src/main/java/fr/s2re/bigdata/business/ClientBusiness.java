package fr.s2re.bigdata.business;

import java.util.Random;

import fr.s2re.bigdata.entity.Client;

public class ClientBusiness {

    private static int id;

    /**
     * Constructeur.
     */
    private ClientBusiness() {
    }

    public static Client getClient() {
        Client client = new Client();
        Random r = new Random();
        int low = 1;
        int high = 1000;
        id = r.nextInt(high - low) + low;
        client.setId(id);
        return client;

    }

}
