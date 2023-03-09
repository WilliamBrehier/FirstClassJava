package brehier.airbnb.reservations;

import brehier.airbnb.logement.Logement;

import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface{

    SejourCourt(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        super(paramDateArrivee, paramNbNuits, paramLogement, paramNbVoyageurs);
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Il s'agit d'un séjour court sans promotion dont le tarif est de " + tarif + "€");
        System.out.println(verificationNombreDeNuits() ? "Le nombre de nuits est valide" : "le nombre de nuits n'est pas valide ta mère la moldue");
    }

    @Override
    public boolean beneficiePromotion() {
        return false;
    }

    @Override
    public int getTarif() {
        return tarif;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return nbNuits < 6;
    }

    @Override
    public void miseAJourDuTarif() {
        tarif = nbNuits * logement.getTarifParNuit();
    }
}
