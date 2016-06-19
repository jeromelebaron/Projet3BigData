/*
 * Créé le 18 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.backend.wrapper;

import java.io.Serializable;

/**
 * Objet pour remonter des produits de la base Mongodb.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class ProduitWrapper implements Serializable {

    /**
     * Sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * La référence du produit.
     */
    private String reference;
    
    /**
     * Le nom du produit.
     */
    private String nom;

    /**
     * Constructeur.
     */
    public ProduitWrapper() {
        // EMPTY
    }

    /**
     * Constructeur.
     * @param paramReference
     */
    public ProduitWrapper(String paramReference) {
        super();
        reference = paramReference;
    }

    /**
     * Accesseur en lecture du champ <code>reference</code>.
     * @return le champ <code>reference</code>.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Accesseur en écriture du champ <code>reference</code>.
     * @param paramReference la valeur à écrire dans <code>reference</code>.
     */
    public void setReference(String paramReference) {
        reference = paramReference;
    }

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "ProduitWrapper [reference=" + reference + ", nom=" + nom + "]";
	}

	
   

}
