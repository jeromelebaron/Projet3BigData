/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.backend.mongo.idao;

import java.util.List;

import fr.s2re.bigdata.backend.wrapper.ProduitWrapper;

/**
 * Pour récupérer des produits dans la base Mongo.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public interface IDaoProduit {

    List<ProduitWrapper> getMeilleuresVentes(int nbVentes);

}
