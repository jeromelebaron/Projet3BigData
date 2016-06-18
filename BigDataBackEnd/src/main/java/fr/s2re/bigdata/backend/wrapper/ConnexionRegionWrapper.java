/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.backend.wrapper;

import java.io.Serializable;

/**
 * Pour ramener les éléments concernant la connexion.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ConnexionRegionWrapper implements Serializable {

    /**
     * Sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Le nom de la région
     */
    private String nomRegion;
    /**
     * La quantité de connexion de cette région.
     */
    private int qteConnexion;

    /**
     * Constructeur.
     */
    public ConnexionRegionWrapper() {
        // EMPTY
    }

    /**
     * Constructeur.
     * @param paramNomRegion
     * @param paramQteConnexion
     */
    public ConnexionRegionWrapper(String paramNomRegion, int paramQteConnexion) {
        super();
        nomRegion = paramNomRegion;
        qteConnexion = paramQteConnexion;
    }

    /**
     * Accesseur en lecture du champ <code>nomRegion</code>.
     * @return le champ <code>nomRegion</code>.
     */
    public String getNomRegion() {
        return nomRegion;
    }

    /**
     * Accesseur en écriture du champ <code>nomRegion</code>.
     * @param paramNomRegion la valeur à écrire dans <code>nomRegion</code>.
     */
    public void setNomRegion(String paramNomRegion) {
        nomRegion = paramNomRegion;
    }

    /**
     * Accesseur en lecture du champ <code>qteConnexion</code>.
     * @return le champ <code>qteConnexion</code>.
     */
    public int getQteConnexion() {
        return qteConnexion;
    }

    /**
     * Accesseur en écriture du champ <code>qteConnexion</code>.
     * @param paramQteConnexion la valeur à écrire dans <code>qteConnexion</code>.
     */
    public void setQteConnexion(int paramQteConnexion) {
        qteConnexion = paramQteConnexion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ConnexionRegionWrapper [nomRegion=" + nomRegion + ", qteConnexion=" + qteConnexion
                + "]";
    }

}
