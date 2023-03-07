package brehier.airbnb.logement;

import brehier.airbnb.outils.CompareGeneric;
import brehier.airbnb.utilisateurs.Hote;
import brehier.airbnb.utilisateurs.Personne;
import brehier.airbnb.menu.Menu;
import brehier.airbnb.outils.CompareInterface;

public abstract class Logement implements CompareInterface{

    //Attributs
    //private Personne hote;
    private String name;
    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;


    //Constructeur
    public Logement(String name, Hote paramHote, int paramTarifParNuit, String paramAdresse, int paramSuperficie, int paramNbVoyageursMax){
        super();
        this.name = name;
        hote = paramHote;
        tarifParNuit = paramTarifParNuit;
        adresse = paramAdresse;
        superficie = paramSuperficie;
        nbVoyageursMax = paramNbVoyageursMax;
    }

    //Méthode
    public void afficher(){
        hote.afficher();
        System.out.println("\nLe logement est situé au " + adresse);
        System.out.println("Superficie : " + superficie + " m²");
    }

    public int getElementToCompare(){
        return tarifParNuit;
    }

    //Méthode => Getters + Setters
    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public int getNbVoyageursMax(){
        return nbVoyageursMax;
    }

    public String getName(){
        return name;
    }
}
