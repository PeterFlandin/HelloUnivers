import objetsastro.*;

import java.util.*;

public class HelloWorld {

    public static void main(String... args) {

        Galaxie SystèmeSolaire = new Galaxie();
         SystèmeSolaire.nom="Systeme Solaire";




        PlaneteTellurique mercure = new PlaneteTellurique("mercure",1);
        mercure.diametre = 4880;
        SystèmeSolaire.planetes.add(mercure);
        mercure.distanceEtoile=2.9f;

        PlaneteTellurique venus = new PlaneteTellurique("venus",3);
        venus.diametre = 12001;
        SystèmeSolaire.planetes.add(venus);
        venus.distanceEtoile=1.21f;

        PlaneteTellurique terre = new PlaneteTellurique("terre",2);
        terre.diametre = 12756;
        SystèmeSolaire.planetes.add(terre);
        terre.distanceEtoile=140.6f;

        PlaneteTellurique mars = new PlaneteTellurique("mars",0);
        mars.diametre = 6792;
SystèmeSolaire.planetes.add(mars);
mars.distanceEtoile=227.9f;
        PlaneteGazeuse jupiter=new PlaneteGazeuse("jupiter");
        jupiter.diametre = 142984;
SystèmeSolaire.planetes.add(jupiter);
jupiter.distanceEtoile=1427f;
        PlaneteGazeuse saturne = new PlaneteGazeuse("saturne");
        saturne.diametre = 120536;
SystèmeSolaire.planetes.add(saturne);
saturne.distanceEtoile=2877.38f;
        PlaneteGazeuse uranus = new PlaneteGazeuse("uranus");
        uranus.diametre = 51118;
        SystèmeSolaire.planetes.add(uranus);
        uranus.distanceEtoile=149.6f;
        System.out.println("Le nombre de planètes découvertes est actuellement de "+ Planet.nbPlanetesDecouvertes);

        for (Planet planet : SystèmeSolaire.planetes
             ) {
            System.out.println(planet.nom);
        }
        
        
        
        
        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo.nbPassagers = 10000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;


        Vaisseau chasseur2 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur2.nbPassagers = 4;
        chasseur2.blindage = 156;
        chasseur2.resistanceDuBouclier = 2;
        Vaisseau chasseur3 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur3.nbPassagers = 5;
        chasseur3.blindage = 156;
        chasseur3.resistanceDuBouclier = 2;
        Vaisseau cargo2 = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo2.nbPassagers = 10001;
        cargo2.blindage = 1520;
        cargo2.resistanceDuBouclier = 20;
        terre.accueillirVaisseaux(chasseur2,chasseur3,cargo2);

    Scanner scanner=new Scanner(System.in);
        boolean recommencer = true;
        System.out.println("Quel vaisseau souhaitez vous manipuler : "+TypeVaisseau.CHASSEUR.name()+", "+TypeVaisseau.FREGATE.name()+", "+TypeVaisseau.CROISEUR.name()+", "+TypeVaisseau.CARGO.name()+" ou "+TypeVaisseau.VAISSEAUMONDE.name()+" ?");
       String typeVaisseauString= scanner.nextLine();
        TypeVaisseau typeVaisseau=TypeVaisseau.valueOf(typeVaisseauString);
       Vaisseau vaisseauSelectionne=null;
        switch (typeVaisseau) {
            case CHASSEUR:
                vaisseauSelectionne = chasseur;
                break;
            case FREGATE:
                vaisseauSelectionne = fregate;
                break;
            case CROISEUR:
                vaisseauSelectionne = croiseur;
                break;
            case CARGO:
                vaisseauSelectionne = cargo;
                break;
            case VAISSEAUMONDE:
                vaisseauSelectionne = vaisseauMonde;
                break;
        }



        System.out.println("Sur quelle planète tellurique en partant du soleil du systeme solaire voulez-vous vous poser : 1, 2, 3 ou 4 ?");
      int nomPlanete= scanner.nextInt();
      scanner.nextLine();
        Planet planeteSelectionneeDansGalaxie = null;
        for (Planet planetsuivante : SystèmeSolaire.planetes
             ) {
            if (planetsuivante.nom.equals(nomPlanete)){
                planeteSelectionneeDansGalaxie = planetsuivante;
                break;
            }

        }
if(planeteSelectionneeDansGalaxie instanceof PlaneteGazeuse){
    System.out.println("Il ne s'agit pas d'une planète Tellurique !");
}
        System.out.println("Le vaisseau souhaite se poser sur la planète "+planeteSelectionneeDansGalaxie.nom);
PlaneteTellurique planeteSelectionnee=(PlaneteTellurique)planeteSelectionneeDansGalaxie;



        System.out.println("Quelle tonnage de cargaison il souhaite embarquer");
        int tonnageSouhaite = scanner.nextInt();

        System.out.println(vaisseauSelectionne.emporterCargaison(tonnageSouhaite));

if (planeteSelectionnee.restePlaceDisponible(vaisseauSelectionne.type)){
    planeteSelectionnee.accueillirVaisseaux(vaisseauSelectionne);
    System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
} else {
    System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
}

scanner.nextLine();
        System.out.println("voulez vous recommencer ?");
        recommencer= scanner.nextLine().equals("oui");


        Atmosphere atmosphereMars = new Atmosphere();
        atmosphereMars.constituants.put("CO2", 95f);
        atmosphereMars.constituants.put("N2", 3f);
        atmosphereMars.constituants.put("AR", 1.5f);
        atmosphereMars.constituants.put("NO", 0.013f);
        mars.atmosphere = atmosphereMars;

        System.out.println("L'atmosphère de Mars est composée de :");
        for (String key : mars.atmosphere.constituants.keySet()) {
            System.out.println("A " + mars.atmosphere.constituants + "% d'hydrogène.");
        }
        


        }







    }
