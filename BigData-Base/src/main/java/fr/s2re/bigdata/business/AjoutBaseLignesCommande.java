/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.business.elasticsearch.ElasticPost;
import fr.s2re.bigdata.business.util.UtilAleatoire;
import fr.s2re.bigdata.entity.LigneCommande;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class AjoutBaseLignesCommande {

    /**
     * POur faire du log.
     */
    private static final Logger LOGGER = Logger.getLogger(AjoutBaseLignesCommande.class);
    /**
     * URL du mongoDB.
     */
    private static final String HOST = "localhost";
    /**
     * Port du MongoDB.
     */
    private static final int PORT = 27017;

    /**
     * @param args
     */
    public static void main(String[] args) {
        ElasticPost localElasticPost = new ElasticPost();
        MongoClient client = new MongoClient(HOST, PORT);
        MongoDatabase dataBase = client.getDatabase("client");
        MongoCollection<Document> collection = dataBase.getCollection("lignesCommande");
        LOGGER.debug("connexion réussie");
        int nbLigneCommande = 0;
        for (Long localI = 1L; localI < 21; localI++) {
            LigneCommande localLigneCommande = new LigneCommande();
            localLigneCommande.setNumCommande(localI);
            try {
                localLigneCommande.setDateCommande(UtilAleatoire.genereDate(2010, 2015));
            } catch (ParseException e) {
                LOGGER.error(e);
            }
            localLigneCommande.setClient(ClientBusiness.getClient());
            int nbLigne = UtilAleatoire.getIntAlea(1, 6);
            for (int localI2 = 0; localI2 < nbLigne; localI2++) {
                nbLigneCommande++;
                int numProduitCat = UtilAleatoire.getIntAlea(1, 20);
                localLigneCommande.setProduit(ProduitBusiness.getProduit(numProduitCat));
                localLigneCommande.setCategorie(CategorieBusiness
                        .getCategorieSansRand(numProduitCat % 2));
                int qte = UtilAleatoire.getIntAlea(1, 5);
                localLigneCommande.setQuantite(qte);
                Document ligneComDocument = new Document();
                ligneComDocument.append("numCommande", localLigneCommande.getNumCommande());
                ligneComDocument.append("quantite", qte);
                ligneComDocument.append("dateCommande", localLigneCommande.getDateCommande());

                Document produitDocument = new Document();
                produitDocument.append("idProduit", localLigneCommande.getProduit().getId());
                produitDocument.append("nomProduit", localLigneCommande.getProduit().getNom());

                Document fournDocument = new Document();
                fournDocument.append("idFournisseur", localLigneCommande.getProduit()
                        .getFournisseur().getId());
                fournDocument.append("nomFournisseur", localLigneCommande.getProduit()
                        .getFournisseur().getNom());

                produitDocument.append("fournisseur", fournDocument);
                produitDocument.append("prix", localLigneCommande.getProduit().getPrix());

                ligneComDocument.append("produit", produitDocument);

                Document catDocument = new Document();
                catDocument.append("idCategorie", localLigneCommande.getCategorie().getId());
                catDocument.append("nomCategorie", localLigneCommande.getCategorie().getNom());

                ligneComDocument.append("categorie", catDocument);

                Document clientDocument = new Document();
                clientDocument.append("idClient", localLigneCommande.getClient().getId());

                ligneComDocument.append("client", clientDocument);

                collection.insertOne(ligneComDocument);

                LOGGER.debug(ligneComDocument.toJson());
                try {
                    localElasticPost.postToElastic(ligneComDocument, "commande", "ligneCommande",
                            String.valueOf(nbLigneCommande));
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error(e);
                }
            }
        }
        LOGGER.info(nbLigneCommande);
        client.close();
    }

}
