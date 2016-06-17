package fr.s2re.bigdata.entity;

public class Region {
	private int id;
	private String nom;
	
	/**
	 * Contructeurs
	 */
	
	public Region() {
		super();
	}
	public Region(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	/**
	 * getters setters
	 * @return
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
