package brehier.airbnb.reservations;

import brehier.airbnb.logement.Logement;

import java.util.Date;

public class SejourFactory {
    //Méthodes
    public static Sejour getSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs){
        if(nbNuits <= 5){
            return new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else {
            return new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
        }
    }
}
