package fr.bamandine.main;

import fr.bamandine.list.ExercicesEntrainement;
import fr.bamandine.list.ExercicesSelection;

import java.io.File;
import java.io.FileInputStream;

/**
 * Main class for launch algorithms
 */
public class Main {

    private File getSampleFile() {

        String filename = "input3.txt";

        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource("inventaire/"+ filename).getFile());
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        System.setIn(new FileInputStream(main.getSampleFile()));

        ExercicesSelection.inventaire();
//        ExercicesEntrainement.rectangleRecouvrant();
//        ExercicesEntrainement.blockchain();
//        ExercicesEntrainement.minDivideByNList();
    }
}
