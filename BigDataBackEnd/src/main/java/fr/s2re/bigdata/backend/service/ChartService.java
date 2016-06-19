package fr.s2re.bigdata.backend.service;

import fr.s2re.bigdata.entity.Connexion;
import fr.s2re.bigdata.entity.Fournisseur;

public interface ChartService {

    public Connexion getConnexionByUtilisateur();

    public Fournisseur getBestFournisseur();

}
