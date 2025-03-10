package src.main.java.fr.bamandine.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Main class for launch algorithms
 */
public class Main {

    public static void algo() {
        /*
        ** ENONCE DE L'EXERCICE **
        Vous devez écrire un programme qui permet de résoudre le problème suivant :
        
        

         */
        String  line;
        int infoPremiereLigne = 0;
        int infoDeuxiemeLigne = 0;
        int infoTroisiemeLigne = 0;
        List<Integer> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
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
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(values.size());               
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        System.setIn(new FileInputStream(main.getSampleFile()));

        algo();

//        ExercicesMDF2016.renduMonnaie();
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
        String filename = "input.txt";
        ClassLoader classLoader = this.getClass().getClassLoader();
        java.net.URL resource = classLoader.getResource("mdf/" + filename);
        if (resource == null) {
            throw new IllegalArgumentException("File not found: " + filename);
        }
        return new File(resource.getFile());
    }
    
    public static void template() {
        String  line;
        int infoPremiereLigne = 0;
        int infoDeuxiemeLigne = 0;
        int infoTroisiemeLigne = 0;
        List<Integer> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
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
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();

        System.out.println(sb.toString());
    }

    @SuppressWarnings("unused")
    private void nbrePartEgale() {
        String  line;
        int longueurTablette = 0;
        int largeurTablette = 0;
        int nbParts = 0;
        List<Integer> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                longueurTablette= Integer.parseInt(line.split(" ")[0]);
                largeurTablette = Integer.parseInt(line.split(" ")[1]);
                nbParts = Integer.parseInt(line.split(" ")[2]);

                if (longueurTablette * largeurTablette % nbParts == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

                /* Lisez les données et effectuez votre traitement */
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }    
    }

    @SuppressWarnings("unused")
    private void compareElementsKeyValue() {
        String  line;
        int nbPoubelle = 0;
        Map<Integer,Integer> poubelles = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                if(nbPoubelle == 0) {
                    nbPoubelle = Integer.parseInt(line);
                } else {
                    int volume = Integer.parseInt(line.split(" ")[0]);
                    int beaute = Integer.parseInt(line.split(" ")[1]);
                    if (poubelles.get(volume) == null || poubelles.get(volume) < beaute) {
                        poubelles.put(volume, beaute);
                    }
                }
                /* Lisez les données et effectuez votre traitement */
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int maxBeaute = 0;
        for (Map.Entry<Integer, Integer> entry : poubelles.entrySet()) {
            if (entry.getKey() >= 20 && entry.getValue() > maxBeaute) {
                maxBeaute = entry.getValue();
            }
        }

        System.out.println(maxBeaute);
    }

    @SuppressWarnings("unused")
    private void diffModulo() {
        String line;
        try (Scanner scanner = new Scanner(System.in)) {
            line = scanner.nextLine().trim();
        }
        String[] elements = line.split("-");
            int firstScore = Integer.parseInt(elements[0]);
            int secondScore = Integer.parseInt(elements[1]);

            if (firstScore > secondScore) {
                System.out.println("0");
            } else {
                int diff = secondScore - firstScore;
                if (diff % 3 == 0) {
                    System.out.println((diff / 3)+1);
                }
                else {
                    int nbPaniersTroisPoints = diff / 3;
                    if (nbPaniersTroisPoints % 1 == 0) {
                        nbPaniersTroisPoints = (int) nbPaniersTroisPoints + 1;
                    }
                    System.out.println(nbPaniersTroisPoints);
                }
            }
    }

    @SuppressWarnings("unused")
    private void nbreElementsDistinct(){
        String line;
        try (Scanner scanner = new Scanner(System.in)) {
            int nbRecette=0;
            ArrayList<String> maListe = new ArrayList<String>(nbRecette);
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                if(nbRecette == 0) {
                    nbRecette = Integer.parseInt(line);
                } else {
                    String[] ingredients = line.split(" ");
                    for (String ingredient : ingredients) {
                        maListe.add(ingredient);
                    }
                }
                
                /* Lisez les données et effectuez votre traitement */
            }
            int nbDistinct = maListe.stream().distinct().toList().size();
            
            System.out.println(nbDistinct);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private void parcoursElementDeuxParDeux() {

        // Pierre Feuille Ciseaux
        String line;
        try (Scanner scanner = new Scanner(System.in)) {
            line = scanner.nextLine();
        }
        int nbrElement = line.length();
        System.out.println("nbrElement = " + nbrElement);
        String myline = line;
        while (myline.length() > 1) {
            for (int i = 0; i < myline.length() - 1; i++) {
                char first = myline.charAt(0);
                System.out.println("first = " + first);
                char second = myline.charAt(1);
                System.out.println("voisin = " + second);

                if (first == second) {
                    myline = myline.replaceFirst(String.valueOf(first), "");
                } else if ((first == 'P' && second == 'C') || (first == 'C' && second == 'F') || (first == 'F' && second == 'P')) {
                    myline = myline.replaceFirst(String.valueOf(second), "");
                } else {
                    myline = myline.replaceFirst(String.valueOf(first), "");
                }
            }         
        }
        System.out.println(myline.trim());
    }

    @SuppressWarnings("unused")
    private void example() {


        ArrayList<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();

        List<Integer> distinctItems = stream.distinct().toList();
        List<Integer> sortedItems = stream.sorted().toList();
        // List<Integer> filteredItems = stream.filter().toList();
        // List<Integer> mappedItems = stream.map().toList();
        // List<Integer> limitedItems = stream.limit().toList();
        // List<Integer> skippedItems = stream.skip().toList();
        // List<Integer> collectedItems = stream.collect(Collectors.toList());
    }

}
