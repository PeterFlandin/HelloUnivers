import java.lang.reflect.Type;

public enum TypeVaisseau {

    CHASSEUR("chasseur"),
    FREGATE("fregate"),

    CROISEUR("croiseur"),
    CARGO("cargo"),

    VAISSEAUMONDE("vaisseau-monde");


    String nomTypesDeVaisseau;

     TypeVaisseau(String nomTypesDeVaisseau){
        this.nomTypesDeVaisseau=nomTypesDeVaisseau;
    }

}
