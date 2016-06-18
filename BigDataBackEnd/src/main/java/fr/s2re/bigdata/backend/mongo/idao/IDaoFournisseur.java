package fr.s2re.bigdata.backend.mongo.idao;

import java.util.List;

import fr.s2re.bigdata.backend.wrapper.FournisseurWrapper;

public interface IDaoFournisseur {
	
	public List<FournisseurWrapper> getTroisBestFournisseur(int nbMax);

}
