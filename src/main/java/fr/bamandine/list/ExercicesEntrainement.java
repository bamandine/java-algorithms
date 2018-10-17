package fr.bamandine.list;

import java.util.*;

public class ExercicesEntrainement {

    public static void minDivideByNList() throws Exception {
        String  line;
        int nbLigne = 1;
        int compteur = 0;
        ArrayList<Integer> datas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine();

            if(0 == compteur) {
                nbLigne = Integer.parseInt(line);
                compteur++;
            } else {
                datas.add(Integer.parseInt(line));
            }
        }

        int min = datas.stream().mapToInt(v -> v).min().orElse(1);

        System.out.println(min / nbLigne);
    }

    public static void blockchain() {
        String  line;
        Scanner sc = new Scanner(System.in);
        int cptLigne = 0;
        int nbStockeurs = 0;
        int nbDemandeEcritures = 0;
        int moitie = 0;
        StringBuffer sb = new StringBuffer();
        while(sc.hasNextLine()) {
            line = sc.nextLine();

            if(cptLigne == 0) {
                nbStockeurs = Integer.parseInt(line);
                moitie = nbStockeurs / 2;
            } else if (cptLigne == 1) {
                nbDemandeEcritures = Integer.parseInt(line);
            } else {
                String[] chains = line.split(" ");
                if(Integer.parseInt(chains[1]) >= moitie) {
                    sb.append(chains[0]);
                }
            }
            cptLigne++;
        }

        System.out.println(sb.toString());
    }

    public static void rectangleRecouvrant() {
        String  line;
        Scanner sc = new Scanner(System.in);
        int cpteur = 0;
        int nbreRectangles = 0;
        List<Integer> valuesX = new ArrayList<>();
        List<Integer> valuesY = new ArrayList<>();
        while(sc.hasNextLine()) {
            line = sc.nextLine().trim();

            if(cpteur == 0) {
                nbreRectangles = Integer.parseInt(line);
            } else {
                String[] coords = line.split(" ");
                valuesX.addAll(Arrays.asList(Integer.valueOf(coords[0]), Integer.valueOf(coords[2])));
                valuesY.addAll(Arrays.asList(Integer.valueOf(coords[1]), Integer.valueOf(coords[3])));
            }
            cpteur++;
        }

        System.out.println(valuesX.stream().mapToInt(v -> v).min().orElse(0)+" "+
                valuesY.stream().mapToInt(v -> v).min().orElse(0)+" "+
                valuesX.stream().mapToInt(v -> v).min().orElse(0)+" "+
                valuesY.stream().mapToInt(v -> v).max().orElse(0)+" "+
                valuesX.stream().mapToInt(v -> v).max().orElse(0)+" "+
                valuesY.stream().mapToInt(v -> v).min().orElse(0)+" "+
                valuesX.stream().mapToInt(v -> v).max().orElse(0)+" "+
                valuesY.stream().mapToInt(v -> v).max().orElse(0));
    }
}
