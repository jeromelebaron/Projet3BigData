/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.mongo.idao;

import java.util.List;

/**
 * Pour récupérer des produits dans la base Mongo.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public interface IDaoProduit {

    List<String> getDixMeilleuresVentes();

}
