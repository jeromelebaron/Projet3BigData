/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.dao;

import java.util.List;

import fr.s2re.bigdata.backend.mongo.dao.impl.DaoProduit;
import fr.s2re.bigdata.backend.mongo.idao.IDaoProduit;
import fr.s2re.bigdata.backend.wrapper.ProduitWrapper;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoProduitTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        IDaoProduit daoProduit = new DaoProduit();
        List<ProduitWrapper> lesMeilleursVentes = daoProduit.getMeilleuresVentes(10);
        for (ProduitWrapper localProduitWrapper : lesMeilleursVentes) {
            System.out.println(localProduitWrapper);
        }
    }

}
