package fr.bamandine.main;

import fr.bamandine.list.ExercicesMDF2016;
import fr.bamandine.list.ExercicesMDF2017;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for launch algorithms
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        System.setIn(new FileInputStream(main.getSampleFile()));

        ExercicesMDF2016.renduMonnaie();
//        ExercicesMDF2016.snake();
//        ExercicesMDF2016.productionVoiture();
//        ExercicesMDF2017.montagnesRusses();
//        ExercicesSelection.numTelephone();
//        ExercicesSelection.inventaire();
//        ExercicesEntrainement.rectangleRecouvrant();
//        ExercicesEntrainement.blockchain();
//        ExercicesEntrainement.minDivideByNList();
    }

    private File getSampleFile() {

        String filename = "input3.txt";

        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource("monnaie/" + filename).getFile());
    }

    public static void template() {
        String  line;
        int infoPremiereLigne = 0;
        int infoDeuxiemeLigne = 0;
        int infoTroisiemeLigne = 0;
        List<Integer> values = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if(infoPremiereLigne == 0) {
                infoPremiereLigne = Integer.parseInt(line);
            } else if (infoDeuxiemeLigne == 0) {
                infoDeuxiemeLigne = Integer.parseInt(line);
            } else if (infoTroisiemeLigne == 0) {
                infoTroisiemeLigne = Integer.parseInt(line);
            } else {
                values.add(Integer.parseInt(line));
            }
            /* Lisez les données et effectuez votre traitement */
        }

        StringBuffer sb = new StringBuffer();
        //TODO

        System.out.println(sb.toString());
    }
}
