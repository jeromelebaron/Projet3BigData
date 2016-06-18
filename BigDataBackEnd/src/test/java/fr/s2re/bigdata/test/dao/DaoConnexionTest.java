/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.dao;

import java.util.List;

import fr.s2re.bigdata.backend.mongo.dao.impl.DaoConnexion;
import fr.s2re.bigdata.backend.mongo.idao.IDaoConnexion;
import fr.s2re.bigdata.backend.wrapper.ConnexionRegionWrapper;

/**
 * Pour tester
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoConnexionTest {

    public static void main(String[] args) {

        IDaoConnexion daoConnexion = new DaoConnexion();
        List<ConnexionRegionWrapper> connexionRegion = daoConnexion
                .getConnexionQteConnexionByRegion();
        for (ConnexionRegionWrapper localConnexionRegionWrapper : connexionRegion) {
            System.out.println(localConnexionRegionWrapper);
        }
    }
}
