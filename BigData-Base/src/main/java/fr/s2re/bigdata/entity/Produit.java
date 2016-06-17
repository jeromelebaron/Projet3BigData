/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.entity;

/**
 * Représente un produit qui sera ajouté dans la base Mongo
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class Produit {

    private int id;

    private String nom;

    private Fournisseur fournisseur;

    public Produit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructeur.
     * @param paramId
     * @param paramNom
     * @param paramFournisseur
     */
    public Produit(int paramId, String paramNom, Fournisseur paramFournisseur) {
        super();
        id = paramId;
        nom = paramNom;
        fournisseur = paramFournisseur;
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
     * Accesseur en lecture du champ <code>fournisseur</code>.
     * @return le champ <code>fournisseur</code>.
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     * Accesseur en écriture du champ <code>fournisseur</code>.
     * @param paramFournisseur la valeur à écrire dans <code>fournisseur</code>.
     */
    public void setFournisseur(Fournisseur paramFournisseur) {
        fournisseur = paramFournisseur;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", fournisseur=" + fournisseur + "]";
    }

}
