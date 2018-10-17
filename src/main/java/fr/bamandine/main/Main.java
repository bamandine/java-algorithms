package fr.bamandine.main;

import fr.bamandine.list.ListExamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main class for launch algorithms
 */
public class Main {

    private File getSampleFile() {

        String filename = "input3.txt";

        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource("samples/"+ filename).getFile());
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        System.setIn(new FileInputStream(main.getSampleFile()));

        ListExamples.minDivideByNList();
    }
}
