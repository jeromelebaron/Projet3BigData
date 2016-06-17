package fr.s2re.bigdata.service;

import fr.s2re.bigdata.entity.Connexion;
import fr.s2re.bigdata.entity.Fournisseur;

public interface ChartService {
	
	public Connexion getConnexionByUtilisateur();
	public Fournisseur getBestFournisseur();

}
