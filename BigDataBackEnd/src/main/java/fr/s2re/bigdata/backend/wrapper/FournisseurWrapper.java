/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.backend.wrapper;

import java.io.Serializable;

/**
 * Pour la fournisseurs ramenés de Mongodb.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class FournisseurWrapper implements Serializable {

    /**
     * Sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Le nom du fournisseur.
     */
    private String nom;

    /**
     * Constructeur.
     */
    public FournisseurWrapper() {
        // EMPTY
    }

    /**
     * Constructeur.
     * @param paramNom
     */
    public FournisseurWrapper(String paramNom) {
        nom = paramNom;
    }

    /**
     * Accesseur en lecture du champ <code>nom</code>.
     * @return le champ <code>nom</code>.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Accesseur en écriture du champ <code>nom</code>.
     * @param paramNom la valeur à écrire dans <code>nom</code>.
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "FournisseurWrapper [nom=" + nom + "]";
    }
    
    

}
