public class VaisseauDeGuerre extends Vaisseau {

boolean armesDesactive;


    public VaisseauDeGuerre(TypeVaisseau type){
        this.type=type;
        if (type==TypeVaisseau.CHASSEUR){
            tonnageMax=0;
        }
        else if (type==TypeVaisseau.FREGATE){
            tonnageMax=50;
        }
        else if (type==TypeVaisseau.CROISEUR){
            tonnageMax=100;
        }

    }

    void attaque(Vaisseau vaisseaucible,String armeutilise, int duree){

if (armesDesactive){
    System.out.println("Attaque impossible, l'armement est désactivé");
} else {
    System.out.println( "Un vaisseau de type "+type+" attaque un vaisseau de type "+type+" en utilisant l'arme" +armeutilise +" pendant "+duree+"minutes.");
    vaisseaucible.resistanceDuBouclier=0;
    vaisseaucible.blindage=vaisseaucible.blindage/2;

}

    }

    void desctiverArmes(){
        System.out.println("Désactivation des armes d'un vaisseau de type "+type);
        armesDesactive=true;

    }


    void activerBouclier(){
        super.activerBouclier();
        desctiverArmes();
    }

    @Override
    int emporterCargaison(int tonnage) {
        if (type.equals("chasseur")){
            return tonnage;
        }
        else {
            if (nbPassagers<12){
                return tonnage;
            }
            else {
                int tonnagePassagers=nbPassagers*2;
                int tonnageRestant=tonnageMax-tonnageActuel;
                int tonnageAConsiderer=(tonnagePassagers<tonnageRestant ? tonnagePassagers : tonnageRestant);
                if (tonnage>tonnageAConsiderer){
                    tonnageActuel=tonnageMax;
                    return tonnage-tonnageAConsiderer;
                }
                tonnageActuel+=tonnage;
                return 0;
            }
        }

    }
}
