/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.util;

import fr.s2re.bigdata.business.util.UtilAleatoire;

/**
 * Description de la classe
 * 
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class AleaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int localI = 0; localI < 20; localI++) {
            System.out.println(UtilAleatoire.getIntAlea(1, 10));
            System.out.println(UtilAleatoire.getDoubleAlea(1, 10));
        }
        
    }

}

