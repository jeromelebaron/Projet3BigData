/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.requete;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class RequeteTest {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    /**
     * @param args
     */
    public static void main(String[] args) {
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("connexion");

        Document group = Document.parse("{$group:{_id:'$region.nomRegion',qte:{$sum:1}}}");
        Document sort = Document.parse("{$sort:{qte:-1}}");

        List<Document> operations = new ArrayList<>();
        operations.add(group);
        operations.add(sort);

        AggregateIterable<Document> iterable = collection.aggregate(operations);
        iterable.forEach(new Block<Document>() {

            @Override
            public void apply(Document document) {
                String nomRegion = document.getString("_id");
                int qte = document.getInteger("qte");
                System.out.println("Région : " + nomRegion + " - Quantité : " + qte + ".");
            }
        });

        client.close();
    }

}
