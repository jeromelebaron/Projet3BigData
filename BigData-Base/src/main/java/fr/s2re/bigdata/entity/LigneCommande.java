/*
 * Créé le 17 juin 2016 par Jérome LE BARON
 */
package fr.s2re.bigdata.entity;

import java.util.Date;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class LigneCommande {

    private Long numCommande;

    private Produit produit;

    private int quantite;

    private Categorie categorie;

    private Date dateCommande;

    private Client client;

    public LigneCommande() {
        // EMPTY
    }

    public LigneCommande(Long paramNumCommande, Produit paramProduit, int paramQuantite,
            Categorie paramCategorie, Date paramDateCommande, Client paramClient) {
        super();
        numCommande = paramNumCommande;
        produit = paramProduit;
        quantite = paramQuantite;
        categorie = paramCategorie;
        dateCommande = paramDateCommande;
        client = paramClient;
    }

    /**
     * Accesseur en lecture du champ <code>numCommande</code>.
     * @return le champ <code>numCommande</code>.
     */
    public Long getNumCommande() {
        return numCommande;
    }

    /**
     * Accesseur en écriture du champ <code>numCommande</code>.
     * @param paramNumCommande la valeur à écrire dans <code>numCommande</code>.
     */
    public void setNumCommande(Long paramNumCommande) {
        numCommande = paramNumCommande;
    }

    /**
     * Accesseur en lecture du champ <code>produit</code>.
     * @return le champ <code>produit</code>.
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * Accesseur en écriture du champ <code>produit</code>.
     * @param paramProduit la valeur à écrire dans <code>produit</code>.
     */
    public void setProduit(Produit paramProduit) {
        produit = paramProduit;
    }

    /**
     * Accesseur en lecture du champ <code>quantite</code>.
     * @return le champ <code>quantite</code>.
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Accesseur en écriture du champ <code>quantite</code>.
     * @param paramQuantite la valeur à écrire dans <code>quantite</code>.
     */
    public void setQuantite(int paramQuantite) {
        quantite = paramQuantite;
    }

    /**
     * Accesseur en lecture du champ <code>categorie</code>.
     * @return le champ <code>categorie</code>.
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Accesseur en écriture du champ <code>categorie</code>.
     * @param paramCategorie la valeur à écrire dans <code>categorie</code>.
     */
    public void setCategorie(Categorie paramCategorie) {
        categorie = paramCategorie;
    }

    /**
     * Accesseur en lecture du champ <code>dateCommande</code>.
     * @return le champ <code>dateCommande</code>.
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Accesseur en écriture du champ <code>dateCommande</code>.
     * @param paramDateCommande la valeur à écrire dans <code>dateCommande</code>.
     */
    public void setDateCommande(Date paramDateCommande) {
        dateCommande = paramDateCommande;
    }

    /**
     * Accesseur en lecture du champ <code>client</code>.
     * @return le champ <code>client</code>.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Accesseur en écriture du champ <code>client</code>.
     * @param paramClient la valeur à écrire dans <code>client</code>.
     */
    public void setClient(Client paramClient) {
        client = paramClient;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "LigneCommande [numCommande=" + numCommande + ", produit=" + produit + ", quantite="
                + quantite + ", categorie=" + categorie + ", dateCommande=" + dateCommande
                + ", client=" + client + "]";
    }

}
