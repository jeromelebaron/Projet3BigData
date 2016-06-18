/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.dao;

import java.util.List;

import org.apache.log4j.Logger;

import fr.s2re.bigdata.backend.mongo.dao.impl.DaoFournisseur;
import fr.s2re.bigdata.backend.mongo.idao.IDaoFournisseur;
import fr.s2re.bigdata.backend.wrapper.FournisseurWrapper;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoFournisseurTest {

    private static final Logger LOGGER = Logger.getLogger(DaoFournisseurTest.class);

    public static void main(String[] args) {
        IDaoFournisseur daoFournisseur = new DaoFournisseur();
        List<FournisseurWrapper> lesFournisseur = daoFournisseur.getBestFournisseur(3);
        for (FournisseurWrapper localFournisseurWrapper : lesFournisseur) {
            LOGGER.info(localFournisseurWrapper);
        }
    }

}
