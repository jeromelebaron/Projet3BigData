/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.test.dao;

import java.util.Map;
import java.util.Map.Entry;

import fr.s2re.bigdata.backend.mongo.dao.impl.DaoConnexion;
import fr.s2re.bigdata.backend.mongo.idao.IDaoConnexion;

/**
 * Pour tester
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoConnexionTest {

    public static void main(String[] args) {

        IDaoConnexion daoConnexion = new DaoConnexion();
        Map<String, Integer> connexionRegion = daoConnexion.getConnexionQteConnexionByRegion();
        for (Entry<String, Integer> entry : connexionRegion.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
