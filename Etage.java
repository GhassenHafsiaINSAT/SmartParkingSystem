package parking;

public class Etage {
	private int numEtage;
	private int capacite; 
	private int nbPlaceDispo;
	private int prix;
	int[] tab;
	public Etage(int numEtage, int capacite,int prix) {
		this.numEtage = numEtage;
		this.capacite = capacite;
		this.prix = prix;
		this.nbPlaceDispo = capacite;
		this.tab = new int[capacite];
		for(int p : this.tab) {
			p = 0;
		}
	}
	public int getNumEtage() {
		return this.numEtage;
	}
	
	public int getCapacite() {
		return this.capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getNbPlaceDispo() {
		return this.nbPlaceDispo;
	}
	public int getPrix() {
		return this.prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public void reserverPlace(int numPlace) {
		this.nbPlaceDispo = this.nbPlaceDispo - 1;
		this.tab[numPlace] = 1;
	}
	public void libererPlace(int numPlace) {
		this.nbPlaceDispo = this.nbPlaceDispo + 1;
		this.tab[numPlace] = 0;
	}
	
	

}
