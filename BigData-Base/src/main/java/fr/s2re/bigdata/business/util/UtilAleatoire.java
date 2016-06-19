/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.business.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class UtilAleatoire {

    /**
     * Constructeur.
     */
    private UtilAleatoire() {
    }

    public static int getIntAlea(int debut, int fin) {
        Random r2 = new Random();
        int low2 = debut;
        int high2 = fin;
        return r2.nextInt(high2 - low2) + low2;
    }

    public static double getDoubleAlea(double debut, double fin) {
        Random r2 = new Random();
        return debut + (fin - debut) * r2.nextDouble();
    }

    public static Date genereDate(int anneDebut, int anneeFin) throws ParseException {
        int jour = UtilAleatoire.getIntAlea(1, 30);
        int mois = UtilAleatoire.getIntAlea(1, 12);
        int annee = UtilAleatoire.getIntAlea(anneDebut, anneeFin);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateGeneree = jour + "/" + mois + "/" + annee;
        return sdf.parse(dateGeneree);
    }

}
