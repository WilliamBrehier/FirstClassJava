package brehier.airbnb.outils;

import java.util.ArrayList;

public class CompareGenericMultiple <T extends CompareInterface> {
    //Attributs
    private ArrayList<T> array;

    //Constructeur
    public CompareGenericMultiple (ArrayList<T> array){
        this.array = array;
    }

    //Méthodes
    public void add(T element){
        array.add(element);
    }

    public void remove(T element){
        array.remove(element);
    }

    public T getHigher(){
        T higher = array.get(0);
        for (T element : array){
            if (element.getElementToCompare() > higher.getElementToCompare()){
                higher = element;
            }
        }
        System.out.println("L'objet le plus haut des choix multiples est : " + higher);
        return higher;
    }
}
