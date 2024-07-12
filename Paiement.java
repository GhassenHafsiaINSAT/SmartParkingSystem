package parking;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Paiement {
	private int numEtage;
	private double prix;
	private int numPlace;
    //Sauvegarde des données requis pour le paiement dans un objet de type Paiement
    public Paiement(int numEtage, int numPlace, double prix) {
    	this.numEtage = numEtage;
    	this.prix = prix;
    	this.numPlace = numPlace;     	
    }

    //fonction pour generer le ticket contenant les données nécéssaires pour le paiement
    public void genererTicket() {
    	
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        System.out.println("\n\n****** Votre ticket ****");
        System.out.println("Date : " + dtf.format(now)); 
        System.out.println("Votre etage : " + this.numEtage);
        System.out.println("Votre place : " + this.numPlace);
        System.out.println("Montant a payer : " + this.prix);
        System.out.println("*** Merci pour votre visite ******\n\n");
    }
}