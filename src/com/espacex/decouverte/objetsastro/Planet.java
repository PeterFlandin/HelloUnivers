package objetsastro;

public abstract class Planet implements Comparable{
    String nom;
    int diametre;
    Atmosphere atmosphere;

    float distanceEtoile;

    static String forme="Sphérique";
    static int nbPlanetesDecouvertes;

    Planet(String nom){
        this.nom=nom;
        nbPlanetesDecouvertes++;
    }

    @Override
    public int compareTo(Object o) {
        Planet autrePlanet=(Planet)o;
        return ((Float)distanceEtoile).compareTo((Float)autrePlanet.distanceEtoile);
    }

    int revolution(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile de "+degres+" degrés.");
        return degres/360;
    }

    int rotation(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne sur moi-même de "+degres+" degrés.");
        return degres/360;
    }



    static String expansion (double milliardsDAnneesLumiere){
        if (milliardsDAnneesLumiere < 14){
            return "Oh la la mais c'est super rapide !";
        }
        else {
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }
}