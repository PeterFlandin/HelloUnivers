package objetsastro;

public class PlaneteTellurique extends Planet implements Habitable {

    Vaisseau[][] vaisseauxAccostes;
    int totalVisiteurs;

    public PlaneteTellurique(String nom, int nbPlacesParCategorie) {
        super(nom);
        vaisseauxAccostes = new Vaisseau[2][nbPlacesParCategorie];
    }

    boolean restePlaceDisponible(TypeVaisseau typeVaisseau) {
        int indexCategorie = 0;
        switch (typeVaisseau) {
            case TypeVaisseau.CARGO:
            case TypeVaisseau.VAISSEAUMONDE:
                indexCategorie = 1;
        }

        for (int i = 0; i < vaisseauxAccostes[indexCategorie].length; i++) {
            if (vaisseauxAccostes[indexCategorie][i] == null) {
                return true;
            }
        }
        return false;
    }

    public void accueillirVaisseaux(Vaisseau... nouveauVaisseaux) {

        for (int j = 0; j < nouveauVaisseaux.length; j++) {
            if (nouveauVaisseaux[j] instanceof VaisseauDeGuerre) {
                ((VaisseauDeGuerre) nouveauVaisseaux[j]).desctiverArmes();
            }

            totalVisiteurs += nouveauVaisseaux[j].nbPassagers;

            int indexCategorie = 0;
            switch (nouveauVaisseaux[j].type) {
                case TypeVaisseau.CARGO:
                case TypeVaisseau.VAISSEAUMONDE:
                    indexCategorie = 1;
            }

            for (int i = 0; i < vaisseauxAccostes[indexCategorie].length; i++) {
                if (vaisseauxAccostes[indexCategorie][i] == null) {
                    vaisseauxAccostes[indexCategorie][i] = nouveauVaisseaux[j];
                    break;
                }
            }
        }

    }
}