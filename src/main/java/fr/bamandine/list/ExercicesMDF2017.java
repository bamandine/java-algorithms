package fr.bamandine.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExercicesMDF2017 {

    /*
    Format des données
    Entrée

    Ligne 1 : un entier L compris entre 5 et 100 représentant le nombre de places que vous devez remplir sur chaque étage.
    Ligne 2 : un entier N compris entre 10 et 500 représentant le nombre d'équipes qui peuvent être potentiellement installées dans l'immeuble.
    Lignes 3 à N+2 : un entier compris entre 1 et 50 représentant le nombre de collaborateurs d'une équipe.

    Sortie
    Un entier représentant le nombre d'étages que vous pouvez intégralement remplir avec L collaborateurs en respectant les contraintes exprimées dans l'énoncé : pas plus de deux équipes par étage et impossibilité d'installer seulement une partie d'une équipe sur un étage.
     */
    public static void salesforce() throws Exception {
        String line;
        Scanner sc = new Scanner(System.in);
        int ligne = 0;
        int nbPlaceLigne = 0;
        int maxLigne = 0;
        ArrayList<Elt> equipes = new ArrayList<>();

        while(sc.hasNextLine() && (maxLigne == 0 || ligne < maxLigne)) {
            line = sc.nextLine();
            if (nbPlaceLigne == 0) {
                nbPlaceLigne = Integer.parseInt(line);
            }
            else if (maxLigne == 0) {
                maxLigne = Integer.parseInt(line);
            }
            else {
                ligne++;
                Elt elt = new Elt(Integer.parseInt(line), ligne);
                equipes.add(elt);

            }
            /* Lisez les données et effectuez votre traitement */
        }
        int trouve = 0;

        for (Elt elt : equipes) {
            if (elt.getVal() == nbPlaceLigne) {
                trouve++;
                elt.setPris(true);
            }
        }

        for (Elt elt : equipes) {
            if (!elt.isPris()) {
                for (Elt complt : equipes) {
                    if (!elt.isPris() & !complt.isPris() && elt.getId() != complt.getId()) {
                        if (elt.getVal() + complt.getVal() == nbPlaceLigne) {
                            trouve++;
                            elt.setPris(true);
                            complt.setPris(true);
                        }
                    }
                }
            }
        }

        System.out.println(trouve);
    }

    public static class Elt {
        int val;
        int id;
        boolean pris;

        Elt(int val, int id) {
            this.id = id;
            this.val = val;
            this.pris = false;
        }
        public int getVal() {
            return val;
        }
        public int getId() {
            return id;
        }
        public boolean isPris() {
            return pris;
        }
        public void setPris(boolean pris ) {
            this.pris = pris;
        }
    }

    public static void montagnesRusses() {
        String  line;
        int nbPoteaux = 0;
        List<Integer> poteaux = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(nbPoteaux == 0) {
                nbPoteaux = Integer.parseInt(line);
            } else {
                poteaux.add(Integer.parseInt(line));
            }
            /* Lisez les données et effectuez votre traitement */
        }

        Collections.sort(poteaux);

        StringBuffer sb = new StringBuffer();

        int nbPoteauxDispo = nbPoteaux;
        int index = 0;
        while(nbPoteauxDispo > 0) {
            sb.append(poteaux.get(index));
            sb.append(" ");
            sb.append(poteaux.get(poteaux.size() - (index+1)));
            sb.append(" ");
            nbPoteauxDispo-=2;
            index++;
        }

        System.out.println(sb.toString().trim());
    }
}
