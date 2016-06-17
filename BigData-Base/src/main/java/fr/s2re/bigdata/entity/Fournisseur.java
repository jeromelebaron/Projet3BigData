/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.entity;

/**
 * Le fournisseur d'un {@link Produit}.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class Fournisseur {

    /**
     * Identifiant unique.
     */
    private int id;
    /**
     * Nom de la référence.
     */
    private String nom;

    /**
     * Constructeur.
     */
    public Fournisseur() {
        super();
    }

    /**
     * Constructeur plein.
     * @param paramId
     * @param paramNom
     */
    public Fournisseur(int paramId, String paramNom) {
        super();
        id = paramId;
        nom = paramNom;
    }

    /**
     * Accesseur en lecture du champ <code>id</code>.
     * @return le champ <code>id</code>.
     */
    public int getId() {
        return id;
    }

    /**
     * Accesseur en écriture du champ <code>id</code>.
     * @param paramId la valeur à écrire dans <code>id</code>.
     */
    public void setId(int paramId) {
        id = paramId;
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
        return "Fournisseur [id=" + id + ", nom=" + nom + "]";
    }

}
