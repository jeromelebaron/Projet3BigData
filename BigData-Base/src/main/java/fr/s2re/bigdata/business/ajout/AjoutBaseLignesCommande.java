/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business.ajout;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import fr.s2re.bigdata.business.CategorieBusiness;
import fr.s2re.bigdata.business.ClientBusiness;
import fr.s2re.bigdata.business.ProduitBusiness;
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
     * Constructeur.
     */
    private AjoutBaseLignesCommande() {
    }

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
        for (Long iterateurCommande = 1L; iterateurCommande < 210; iterateurCommande++) {
            LigneCommande localLigneCommande = new LigneCommande();
            localLigneCommande.setNumCommande(iterateurCommande);
            LOGGER.debug("==========Commande " + iterateurCommande + "=============");
            try {
                localLigneCommande.setDateCommande(UtilAleatoire.genereDate(2010, 2015));
            } catch (ParseException e) {
                LOGGER.error(e);
            }
            localLigneCommande.setClient(ClientBusiness.getClient());
            int nbLigne = UtilAleatoire.getIntAlea(1, 6);
            for (int iterateurQuantite = 0; iterateurQuantite < nbLigne; iterateurQuantite++) {
                nbLigneCommande++;
                int numProduitCat = 0;
                int numCat = 1;
                if (iterateurCommande > 10) {
                    numProduitCat = 2;
                    numCat = 1;
                }
                if (iterateurCommande > 33) {
                    numProduitCat = 3;
                    numCat = 2;
                }
                if (iterateurCommande > 43) {
                    numProduitCat = 4;
                    numCat = 3;
                }
                if (iterateurCommande > 51) {
                    numProduitCat = 5;
                    numCat = 4;
                }
                if (iterateurCommande > 63) {
                    numProduitCat = 6;
                    numCat = 5;
                }
                if (iterateurCommande > 88) {
                    numProduitCat = 7;
                    numCat = 6;
                }
                if (iterateurCommande > 118) {
                    numProduitCat = 8;
                    numCat = 7;
                }
                if (iterateurCommande > 140) {
                    numProduitCat = 9;
                    numCat = 8;
                }
                if (iterateurCommande > 172) {
                    numProduitCat = 10;
                    numCat = 9;
                }
                localLigneCommande.setProduit(ProduitBusiness.getProduit(numProduitCat));

                localLigneCommande.setCategorie(CategorieBusiness.getCategorieSansRand(numCat));
                int qte = UtilAleatoire.getIntAlea(1, 5);
                localLigneCommande.setQuantite(qte);
                localLigneCommande.setTrimestre(String.format("%02d",
                        UtilAleatoire.getIntAlea(1, 13)));
                Document ligneComDocument = new Document();
                ligneComDocument.append("numCommande", localLigneCommande.getNumCommande());
                ligneComDocument.append("quantite", qte);
                ligneComDocument.append("dateCommande", localLigneCommande.getDateCommande()
                        .getTime());
                ligneComDocument.append("trimestre", localLigneCommande.getTrimestre());
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
                LOGGER.info(localLigneCommande);
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
