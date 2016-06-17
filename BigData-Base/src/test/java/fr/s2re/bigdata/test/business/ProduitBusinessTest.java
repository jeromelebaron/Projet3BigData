/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.business;

import fr.s2re.bigdata.business.ProduitBusiness;
import fr.s2re.bigdata.entity.Produit;

/**
 * Pour tester les méthodes de {@link ProduitBusiness}
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ProduitBusinessTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int localI = 0; localI < 50; localI++) {
            Produit produit = ProduitBusiness.getProduitAleatoire();
            System.out.println(produit);
        }
    }

}
