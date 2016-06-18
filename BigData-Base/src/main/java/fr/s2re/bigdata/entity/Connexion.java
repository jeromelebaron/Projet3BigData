package fr.s2re.bigdata.entity;

public class Connexion {

    private int idClient;

    private Region region;

    private double duree;

    public Connexion() {
        super();
    }

    public Connexion(int paramIdClient, Region paramRegion, double paramDuree) {
        super();
        idClient = paramIdClient;
        region = paramRegion;
        duree = paramDuree;
    }

    /**
     * Accesseur en lecture du champ <code>client</code>.
     * @return le champ <code>client</code>.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Accesseur en écriture du champ <code>client</code>.
     * @param paramClient la valeur à écrire dans <code>client</code>.
     */
    public void setIdClient(int paramClient) {
        idClient = paramClient;
    }

    /**
     * Accesseur en lecture du champ <code>region</code>.
     * @return le champ <code>region</code>.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Accesseur en écriture du champ <code>region</code>.
     * @param paramRegion la valeur à écrire dans <code>region</code>.
     */
    public void setRegion(Region paramRegion) {
        region = paramRegion;
    }

    /**
     * Accesseur en lecture du champ <code>duree</code>.
     * @return le champ <code>duree</code>.
     */
    public double getDuree() {
        return duree;
    }

    /**
     * Accesseur en écriture du champ <code>duree</code>.
     * @param paramDuree la valeur à écrire dans <code>duree</code>.
     */
    public void setDuree(double paramDuree) {
        duree = paramDuree;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Connexion [idClient=" + idClient + ", region=" + region + ", duree=" + duree + "]";
    }

}
