/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business;

import java.util.Random;

import fr.s2re.bigdata.business.util.UtilAleatoire;
import fr.s2re.bigdata.entity.Produit;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ProduitBusiness {

    private static Produit[] lesProduits = new Produit[20];

    private static String[] referenceProduits = { "Tap1254", "Tap1255", "Tap25892", "Tap25895",
            "Tap25896", "Tap12475", "Tap12478", "Tap12545", "Tap12546", "Tap12547", "Tap1256",
            "M1524", "M12548", "H25698", "L254789", "C06456", "L254789", "H265987", "C05487",
            "L25478" };

    /**
     * Constructeur.
     */
    private ProduitBusiness() {
    }

    private static void remplirProduit() {
        for (int localI = 0; localI < lesProduits.length; localI++) {
            Produit produit = new Produit(localI, referenceProduits[localI],
                    FournisseurBusiness.getFournisseur(localI), UtilAleatoire.getDoubleAlea(20,
                            3000));
            lesProduits[localI] = produit;
        }
    }

    public static Produit getProduitAleatoire() {
        remplirProduit();
        Random r = new Random();
        int low = 0;
        int high = lesProduits.length;
        int result = r.nextInt(high - low) + low;
        return lesProduits[result];
    }

    public static Produit getProduit(int positionTableau) {
        remplirProduit();
        return lesProduits[positionTableau];
    }

}
