package brehier.airbnb.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import brehier.airbnb.logement.Appartement;
import brehier.airbnb.logement.Logement;
import brehier.airbnb.logement.Maison;
import brehier.airbnb.outils.CompareGeneric;
import brehier.airbnb.outils.CompareGenericMultiple;
import brehier.airbnb.outils.LireFichierXML;
import brehier.airbnb.reservations.Reservation;
import brehier.airbnb.reservations.Sejour;
import brehier.airbnb.utilisateurs.Hote;
import brehier.airbnb.utilisateurs.Personne;
import brehier.airbnb.utilisateurs.Voyageur;


public class Menu {

	static Scanner scanner;

	static ArrayList<Hote> listHotes;
	public static ArrayList<Logement> listLogements;
	static ArrayList<Voyageur> listVoyageurs;
	static ArrayList<Reservation> listReservations;

	public static void main(String[] args) {

		//System.out.println("Bienvenue chez AirBnB");

		scanner = new Scanner(System.in);
	
		init();

		LireXMLDOM.read();

//	1.1° - Première méthode (pas de généricité)
//		Maison maison = findMaisonByName("Maison 1");
//		System.out.println(maison.getName());
		//Appartement appartement = findAppartementByName("Appartement 12");

// 1.2° - Deuxième méthode (pas de généricité)
		Maison maison1 = (Maison) findLogementByName("Maison 1");
		Appartement appartement1 = (Appartement) findLogementByName("Appartement 1");

// 1.3° - Troisième méthode , l'objectif est d'éviter de caster l'object (Maison) dans l'appel de la fonction (généricité)
		Maison maison2 = findLogementByNameWithGenericity("Maison 2");
		Appartement appartement2 = findLogementByNameWithGenericity("Appartement 2");

		//listerMenu();

		// 2.1 classe générique pour Logement tarif par nuit
		CompareGeneric<Logement> logementCompareGeneric = new CompareGeneric<>(maison1, maison2);
		Logement logementHigher = logementCompareGeneric.getHigher();

		// 2.2 classe générique pour Personne age
		Personne personne1 = new Personne("Jean", "Dupont", 25);
		Personne personne2 = new Personne("Jeanne", "Dupont", 30);

		CompareGeneric<Personne> personneCompareGeneric = new CompareGeneric<>(personne1, personne2);
		Personne personneHigher = personneCompareGeneric.getHigher();

		// 2.3 classe générique pour Hote delaiReponse
		Hote hote1 = new Hote("Jean", "Dupont", 25, 1);
		Hote hote2 = new Hote("Jeanne", "Dupont", 30, 7);
		Hote hote3 = new Hote("Jean", "Dupont", 25, 3);
		Hote hote4 = new Hote("Jeanne", "Dupont", 30, 4);

		CompareGeneric<Hote> hoteCompareGeneric = new CompareGeneric<>(hote1, hote2);
		Hote hoteHigher = hoteCompareGeneric.getHigher();

		// 3 classe générique pour des choix d'objects multiples
		ArrayList<Hote> hoteArrayList = new ArrayList<>();


		CompareGenericMultiple<Hote> hoteCompareGenericMultiple = new CompareGenericMultiple<>(hoteArrayList);
		hoteCompareGenericMultiple.add(hote1);
		hoteCompareGenericMultiple.add(hote2);
		hoteCompareGenericMultiple.add(hote3);
		hoteCompareGenericMultiple.add(hote4);
		Hote hoteHigherMultiple = hoteCompareGenericMultiple.getHigher();


		scanner.close();
	}

	static void listerMenu() {

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Liste des hôtes");
		System.out.println("2 : Liste des logements");
		System.out.println("3 : Liste des voyageurs");
		System.out.println("4 : Liste des réservations");
		System.out.println("5 : Fermer le programme");

		switch (choix(5)) {
		case 1:
			GestionHotes.listerHotes();
			break;
		case 2:
			//GestionLogements.listerLogements();
			break;
		case 3:
			//GestionVoyageurs.listerVoyageurs();
			break;
		case 4:
			//GestionReservations.listerReservations();
			break;
		case 5:
			System.out.println("A bientôt");
			break;
		}
	}

	static int choix(int maxValue) {
		// TODO Ne pas faire planter cette méthode choix !!!!
		int choixUtilisateur = 0;

		while (choixUtilisateur < 1 || choixUtilisateur > maxValue){
			System.out.println("Veuillez rentrer un chiffre entre 1 et " + maxValue);
			try{
				choixUtilisateur = scanner.nextInt();
			} catch (InputMismatchException e){
				System.out.println("Erreur : " + e.getMessage());
				//Sert à vider le buffer du scanner pour éviter une boucle infinie
				String str = scanner.next();
				System.out.println("Attention, la valeur " + str + " n'est pas un chiffre");
			}
		}
		return choixUtilisateur;
	}

	private static Maison findMaisonByName(String name) {

		for (Logement logement: listLogements) {
			if(logement != null && Objects.equals(logement.getName(), name)) {
				if (logement instanceof Maison) {
					return (Maison) logement;
				}
			}
		}
		return null;
	}

	public static Logement findLogementByName(String name){
		for (Logement logement : Menu.listLogements) {
			if(logement.getName().equals(name)){
				System.out.println("un logement existe déjà avec ce nom " + name);
				logement.afficher();
				return logement;
			}
		}
		System.out.println("pas de logement avec ce nom : " + name);
		return null;
	}

	//On cherche un logement, T représente tous les enfants de logement, et on veut retourner T ou null si pas de logement correspondant
	public static <T extends Logement> T findLogementByNameWithGenericity(String name){
		for (Logement logement : Menu.listLogements) {
			if(logement.getName().equals(name)){
				System.out.println("un logement existe déjà avec ce nom " + name);
				logement.afficher();
				return (T) logement;
			}
		}
		System.out.println("pas de logement avec ce nom : " + name);
		return null;
	}


	private static void init() {

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();


		// Création des Hotes
//		Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
//		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
//		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
//		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);
//
//		listHotes.add(hote1);
//		listHotes.add(hote2);
//		listHotes.add(hote3);
//		listHotes.add(hote4);

		//Récupération des hôtes depuis le fichier XML
//		for (Hote hote : LireFichierXML.main(characters)) {
//			listHotes.add(hote);
//		}





		// Création de Logement
//		Maison maison1 = new Maison(hote1, 40, "18 rue De Tours, 37000 Tours", 140, 2, 500, true);
//		Maison maison2 = new Maison(hote1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
//		Maison maison3 = new Maison(hote1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
//		Appartement appartement1 = new Appartement(hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
//		Appartement appartement2 = new Appartement(hote1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);
//
//		listLogements.add(maison1);
//		listLogements.add(maison2);
//		listLogements.add(maison3);
//		listLogements.add(appartement1);
//		listLogements.add(appartement2);


		//Récupération des logements depuis le fichier XML
//		for (Logement logement : LireFichierXML.main(characters)) {
//			listLogements.add(logement);
//		}




		// Création de voyageurs
		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);

		listVoyageurs.add(voyageur1);
		listVoyageurs.add(voyageur2);
	}

}
