/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.business;

import fr.s2re.bigdata.business.FournisseurBusiness;
import fr.s2re.bigdata.entity.Fournisseur;

/**
 * Pour tester les méthodes de {@link FournisseurBusiness}.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class FournisseurBusinessTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        for (int localI = 0; localI < 50; localI++) {
            Fournisseur localFournisseur = FournisseurBusiness.getFournisseur();
            System.out.println(localFournisseur.getId());
        }

    }

}
