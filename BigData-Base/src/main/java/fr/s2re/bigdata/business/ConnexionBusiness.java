package fr.s2re.bigdata.business;

import fr.s2re.bigdata.business.util.UtilAleatoire;
import fr.s2re.bigdata.entity.Connexion;
import fr.s2re.bigdata.entity.Region;

public class ConnexionBusiness {

    private static String[] regions = { "Vide", "Languedoc-Roussillon-Midi-Pyrénées",
            "Alsace-Champagne-Ardenne-Lorraine", "Aquitaine-Poitou-Charentes-Limousin",
            "Auvergne-Rhône-Alpes", "Bourgogne-Franche-Comté", "Bretagne", "Centre-Val-de-Loire",
            "Corse", "Ile-de-France", "Nord-Pas-de-Calais-Picardie", "Normandie",
            "Pays de la Loire", "Provence-Alpes-Côte d'Azur" };

    public static Connexion getUneConnexion(int idClient) {
        Connexion localConnexion = new Connexion();
        localConnexion.setIdClient(idClient);
        int numRegion = UtilAleatoire.getIntAlea(1, 13);
        Region region = new Region(numRegion, regions[numRegion]);
        localConnexion.setRegion(region);
        localConnexion.setDuree(UtilAleatoire.getDoubleAlea(0.5, 30));
        return localConnexion;
    }

}
