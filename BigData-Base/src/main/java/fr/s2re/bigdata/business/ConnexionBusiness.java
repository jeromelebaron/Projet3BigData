package fr.s2re.bigdata.business;

import fr.s2re.bigdata.business.util.UtilAleatoire;
import fr.s2re.bigdata.entity.Connexion;
import fr.s2re.bigdata.entity.Region;

public class ConnexionBusiness {

    private static final String[] REGIONS = { "Vide", "Languedoc-Roussillon-Midi-Pyrenees",
            "Alsace-Champagne-Ardenne-Lorraine", "Aquitaine-Poitou-Charentes-Limousin",
            "Auvergne-Rhone-Alpes", "Bourgogne-Franche-Comte", "Bretagne", "Centre-Val-de-Loire",
            "Corse", "Ile-de-France", "Nord-Pas-de-Calais-Picardie", "Normandie",
            "Pays de la Loire", "Provence-Alpes-Cote d'Azur" };

    /**
     * Constructeur.
     */
    private ConnexionBusiness() {
    }

    public static Connexion getUneConnexion(int idClient, int idRegion) {
        Connexion localConnexion = new Connexion();
        localConnexion.setIdClient(idClient);
        int numRegion = idRegion;
        Region region = new Region(numRegion, REGIONS[numRegion]);
        localConnexion.setRegion(region);
        localConnexion.setDuree(UtilAleatoire.getDoubleAlea(0.5, 30));
        return localConnexion;
    }

}
