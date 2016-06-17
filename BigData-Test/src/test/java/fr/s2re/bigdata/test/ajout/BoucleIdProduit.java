/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.ajout;

import java.util.Random;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class BoucleIdProduit {

    /**
     * @param args
     */
    public static void main(String[] args) {
    
        for (int localI = 0; localI < 100; localI++) {
            int idProduit = (int) (Math.random() * 21);
            Random r = new Random();
            int low = 1;
            int high = 20;
            int result = r.nextInt(high-low) + low;
            String[] fournisseur = {"IKEA", "Brico", "Inter"};
            Random r2 = new Random();
            int low2 = 0;
            int high2 = 3;
            int result2 = r2.nextInt(high2-low2) + low2;
            String fourniChoisi = fournisseur[result2];
            System.out.println(idProduit);
            System.out.println(result);
            System.out.println(fourniChoisi);
        }

    }

}
