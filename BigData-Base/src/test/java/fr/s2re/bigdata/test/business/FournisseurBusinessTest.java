/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.business;

import fr.s2re.bigdata.business.CategorieBusiness;
import fr.s2re.bigdata.business.ClientBusiness;
import fr.s2re.bigdata.business.FournisseurBusiness;
import fr.s2re.bigdata.entity.Categorie;
import fr.s2re.bigdata.entity.Client;
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

		/*for (int localI = 0; localI < 50; localI++) {
            Fournisseur localFournisseur = FournisseurBusiness.getFournisseur();
            System.out.println(localFournisseur.getId());
        }*/

		/*	for (int localI = 0; localI < 50; localI++) {
            Client client = ClientBusiness.getClient();
            System.out.println(client.getId());
    	}*/
		for (int localI = 0; localI < 50; localI++) {
			Categorie cat = CategorieBusiness.getCategorie();
			System.out.println(cat.getId());
		}
	}

}
