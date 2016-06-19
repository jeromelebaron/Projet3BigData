package fr.s2re.bigdata.business;

import java.util.Random;

import fr.s2re.bigdata.entity.Categorie;

public class CategorieBusiness {

    private static int[] id = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    private static String[] nom = { "Cuisine", "SDB", "Sejour", "Rideau", "Luminaire",
            "Horloge", "Tapis", "Miroir", "Jardin", "Bricolage" };

    /**
     * Constructeur.
     */
    private CategorieBusiness() {
    }

    public static Categorie getCategorie() {
        Categorie categorie = new Categorie();
        Random r = new Random();
        int low = 1;
        int high = id.length;
        int result = r.nextInt(high - low) + low;
        categorie.setId(id[result]);
        categorie.setNom(nom[result]);
        return categorie;

    }

    public static Categorie getCategorieSansRand(int identifiant) {
        Categorie categorie = new Categorie();
        categorie.setId(id[identifiant]);
        categorie.setNom(nom[identifiant]);
        return categorie;
    }
}
