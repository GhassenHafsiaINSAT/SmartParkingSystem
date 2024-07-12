package parking;
import java.util.Scanner;


public class Gestion {
	static Etage[] etages = new Etage[10];
	public static void main(String[] args) {
		etages[0] = new Etage(1, 10, 2); //un etage crée par defaut pour tester la partie du client
		Scanner sc = new Scanner(System.in);
		int choix;
        
        int indiceEtageCourant = 1; //car 0 est déja pris par l'etage par défaut
        int numEtage, capacite, prix, choixA, choixC, quitter, numPlace;

        //Choix du role de l'utilisateur
		System.out.println("1 - Administrateur");
		System.out.println("2 - Client");
		do {
			choix = sc.nextInt();
		} while(choix != 1 && choix != 2 );
        if(choix == 1){
            //traitement pour l'adminitrateur du parking
            quitter = 0;
            do{
                System.out.println("1- Afficher la liste des etages");
                System.out.println("2- Ajouter un etage");
                System.out.println("3- Quitter");
                choixA = sc.nextInt();
                switch(choixA){
                    case 1: {
                        for(int i = 0; i < indiceEtageCourant ; i++){
                            System.out.println("Numéro : " + etages[i].getNumEtage());
                            System.out.println("Capactié : " + etages[i].getCapacite());
                            System.out.println("---------");
                        }
                    }  break;
                    case 2: {
                        System.out.print("Donner le numero de l'etage a ajouter : ");
                        numEtage = sc.nextInt();
                        System.out.print("Donner la capacité de l'etage a ajouter : ");
                        capacite = sc.nextInt();
                        System.out.print("Donner le prix d'une place dans l'etage a ajouter : ");
                        prix = sc.nextInt();
                        Etage e = new Etage(numEtage, capacite, prix); //creation d'un nouveau objet etage dans le tab etages
                        etages[indiceEtageCourant] = e;
                        indiceEtageCourant++; //nombre des etages crees
                    } break;
                    case 3: quitter = 1; break;
                    default: System.out.println("Choix invalide !"); break;
                }
            }while(quitter == 0);
        }
        else {
            //traitement pour le client
            do{
                System.out.println("1- Reserver place");
                System.out.println("2- Quitter");
                choixC = sc.nextInt();
                if(choixC == 1){
                    System.out.println("Donner le numero de l'etage : ");
                    numEtage = sc.nextInt();
                    System.out.println("Donner le numéro de la place : ");
                    numPlace = sc.nextInt();
                    for(Etage e : etages){
                        if(e.getNumEtage() == numEtage){
                            e.reserverPlace(numPlace);
                            Paiement p = new Paiement(numEtage, numPlace, e.getPrix()); //creation d'un objet paiement pour generer le ticket apres
                            p.genererTicket(); break;
                        }
                    }
                    System.out.println("Place reservee");
                }
            }while(choixC != 2);
        }
	}
}