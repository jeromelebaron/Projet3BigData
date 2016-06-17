/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business;

import java.util.Random;

import fr.s2re.bigdata.entity.Fournisseur;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class FournisseurBusiness {

    private static int[] idFournisseur = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20 };

    private static String[] nomFournisseur = { "ATECH SAS", "SILKOLOR", "SINEU GRAFF", "VALMONT",
            "BOURASSEAU", "MOBILIER DE VILLE.COM", "SORA", "BOXTER", "TECHNILIUM", "ABD", "AUA",
            "ACE MOBILIER", "URBAN-NT", "EUROSIGN", "BOSQUET", "METALCOLUX", "FREPAt", "CLEAN",
            "EMMANUEL CAIRO", "ABSOLUTE", "BUYNZEEL" };

    public static Fournisseur getFournisseur() {
        Fournisseur localFournisseur = new Fournisseur();
        Random r = new Random();
        int low = 0;
        int high = idFournisseur.length;
        int result = r.nextInt(high - low) + low;
        localFournisseur.setId(idFournisseur[result]);
        localFournisseur.setNom(nomFournisseur[result]);
        return localFournisseur;
    }

}
