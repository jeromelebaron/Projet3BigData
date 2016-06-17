/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.business;

import fr.s2re.bigdata.business.ConnexionBusiness;
import fr.s2re.bigdata.entity.Connexion;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ConnexionBusinessTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int localI = 0; localI < 20; localI++) {
            Connexion localConnexion = ConnexionBusiness.getUneConnexion(localI);
            System.out.println(localConnexion);
        }
        
    }

}
