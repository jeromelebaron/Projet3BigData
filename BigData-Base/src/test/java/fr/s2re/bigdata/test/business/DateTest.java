/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.s2re.bigdata.business.util.UtilAleatoire;

/**
 * Pour tester la génération d'une date.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DateTest {

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        int jour = UtilAleatoire.getIntAlea(1, 30);
        int annee = UtilAleatoire.getIntAlea(2010, 2015);
        int mois = UtilAleatoire.getIntAlea(1, 12);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateGeneree = jour + "/" + mois + "/" + annee;
        Date dateOk = sdf.parse(dateGeneree);
        System.out.println(dateOk);
    }

}
