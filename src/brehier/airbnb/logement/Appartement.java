package brehier.airbnb.logement;

import brehier.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {
    //Attribut spécifique à appartement
    private final int numeroEtage;
    private final int superficieBalcon;

    //Constructeur
    public Appartement(String name, Hote paramHote, int paramTarifParNuit, String paramAdresse, int paramSuperficie, int paramNbVoyageursMax, int paramNumeroEtage, int paramSuperficieBalcon){
        super(name, paramHote, paramTarifParNuit, paramAdresse, paramSuperficie, paramNbVoyageursMax);
        numeroEtage = paramNumeroEtage;
        superficieBalcon = paramSuperficieBalcon;
    }

    //Methode

    @Override
//    public void afficher() {
//        super.afficher();
//        System.out.println("Etage : "+numeroEtage);
//        System.out.println("Balcon : "+superficieBalcon);
//    }
    public void afficher(){
        super.afficher();
        System.out.println("Numéro d'étage : " + numeroEtage);
        System.out.println("Superficie du balcon : " + superficieBalcon + " m²");
    }
}
