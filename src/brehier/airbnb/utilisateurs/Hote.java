package brehier.airbnb.utilisateurs;

import java.util.Objects;

public class Hote extends Personne{
    //Attributs spécifiques à hôte
    private int delaiDeReponse;

    //Constructeur
    public Hote(String paramPrenom, String paramNom , int paramAge, int paramDelaiDeReponse){
        super(paramPrenom, paramNom, paramAge);
        delaiDeReponse = paramDelaiDeReponse;
    }

    //Méthode


    public int getDelaiDeReponse() {
        return delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("qui s'engage à répondre dans les " + delaiDeReponse + "heures");
    }

    @Override
    public String toString(){
        return "Nom : " + getNom() + " Prénom : " + getPrenom() + " âge : " + getAge() + " qui s'engage à répondre dans les " + delaiDeReponse + "heures";
    }

    @Override
    public int getElementToCompare() {
        return delaiDeReponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        Hote hote = (Hote) o;
        return delaiDeReponse == hote.delaiDeReponse;
    }
}
