package brehier.airbnb.outils;
import brehier.airbnb.outils.CompareInterface;

// la classe générique ne concerne que les élément <T> qui sont AU MOINS des éléments qui ont le contrat CompareInterface
public class CompareGeneric<T extends CompareInterface> {

    //Attributs de type T = générique
    private T obj1;
    private T obj2;

    //Constructeur
    public CompareGeneric (T obj1, T obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    //Méthodes
    public T getHigher(){
        if (obj1.getElementToCompare() > obj2.getElementToCompare()){
            System.out.println("L'objet le plus haut est : obj1");
            return obj1;
        } else {
            System.out.println("L'objet le plus haut est : obj2");
            return obj2;
        }
    }
}
