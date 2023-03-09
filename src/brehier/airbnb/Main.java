package brehier.airbnb;

import brehier.airbnb.logement.Appartement;
import brehier.airbnb.logement.Logement;
import brehier.airbnb.logement.Maison;
import brehier.airbnb.outils.AirBnBData;
import brehier.airbnb.outils.CreateSejour;
import brehier.airbnb.outils.MaDate;
import brehier.airbnb.outils.Utile;
import brehier.airbnb.reservations.*;
import brehier.airbnb.utilisateurs.Hote;
import brehier.airbnb.utilisateurs.Personne;
import brehier.airbnb.utilisateurs.Voyageur;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Personne maPersonne1 = new Personne("Willou ", "LaCartouche ", 30);
        Personne maPersonne2 = new Personne("Jean ", "LaPomme ", 40);

        //Singleton utilisation
        AirBnBData maData = AirBnBData.getInstance();
        maData.getLogement().afficher();

        Hote monHote1 = new Hote("Willou", "LaCartouche", 30, 2);

        Voyageur monVoyageur1 = new Voyageur("Victor", "LeBasque", 18);

        Maison maMaison1 = new Maison("maison 1",monHote1, 100, "1 rue de la maison", 200, 10, 500, true);

        //Appartement monAppartement1 = new Appartement(monHote1, 50, "1 rue de lappartement", 50, 2, 4, 0);

        //Logement monLogement1 = new Logement(maPersonne2, 50, "1 rue de la paix, 37000 Tours", 140, 2);
        //Logement monLogement2 = new Logement(monHote1, 50, "1 rue de la paix, 37000 Tours", 140, 2);

        //Date maDate1 = new Date(123, 05, 11);
        //Date maDate1 = Utile.createDate(11,6,2023);

        //Critères
        int nbNuits = 2;
        int nbVoyageurs = 8;

        Date maDate2 = new MaDate(14,2,2023);


        //Sejour sejour;
        PrintWriter writer;

        //Factory => même package que les filles concernées
        Sejour sejour = SejourFactory.getSejour(maDate2, nbNuits, maMaison1,nbVoyageurs);


        //Conditions
        //sejour = CreateSejour.getSejour(maMaison1, nbNuits, nbVoyageurs, maDate2);

        Reservation maReservation5 ;
//        try {
//            maReservation5 = new Reservation(sejour, monVoyageur1);
//            maReservation5.afficher();
//
//            writer = new PrintWriter("Reservation.txt");
//            writer.println("Nom du voyageur : " + monVoyageur1.getNom());
//            writer.println("Numéro du logement : " + sejour.getLogement());
//            writer.println("Date d'arrivée : " + sejour.getDateArrivee());
//            writer.println("Nombre de nuits : " + sejour.getNbNuits());
//            writer.println("Nombre de voyageurs : " + sejour.getNbVoyageurs());
//            writer.close();
//
//        } catch (Exception e) {
//            System.out.println("l'erreur : " + e.getMessage());
//        }





        //Sejour monSejour1 = new Sejour(maDate1, 4, monLogement2, 2);
//        Sejour monSejour1 = new Sejour(maDate1, 4, maMaison1, 2);
//        Sejour monSejour2 = new Sejour(maDate1, 3, monAppartement1, 2);
        //Sejour monSejour3 = new Sejour(maDate2, 32, monAppartement1, 2);




        //Reservation maReservation1 = new Reservation(monSejour1, maPersonne1);
        //Reservation maReservation2 = new Reservation(monSejour1, maPersonne1);
//        Reservation maReservation3 = new Reservation(monSejour1, monVoyageur1);
//        Reservation maReservation4 = new Reservation(monSejour2, monVoyageur1);




        //maPersonne1.afficher();
        //monLogement1.afficher();
        //monSejour1.afficher();
        //maReservation1.afficher();
        //maReservation2.afficher();
        //monHote1.afficher();
        //monLogement2.afficher();
//        maReservation3.afficher();
//        maReservation4.afficher();


    }

}
