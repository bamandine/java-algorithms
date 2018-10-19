package fr.bamandine.main;

import fr.bamandine.list.ExercicesSelection;

import java.io.File;
import java.io.FileInputStream;

/**
 * Main class for launch algorithms
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        System.setIn(new FileInputStream(main.getSampleFile()));

        ExercicesSelection.numTelephone();
//        ExercicesSelection.inventaire();
//        ExercicesEntrainement.rectangleRecouvrant();
//        ExercicesEntrainement.blockchain();
//        ExercicesEntrainement.minDivideByNList();
    }

    private File getSampleFile() {

        String filename = "input2.txt";

        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource("numTelephones/" + filename).getFile());
    }
}
