package fr.bamandine.list;

import java.util.*;
import java.util.stream.Collectors;

public class ExercicesSelection {

    public static void inventaire() throws Exception {
        String  line;
        int nbArticles = 10;
        int compteur = 0;
        Map<String, Integer> produits = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine().trim();

            if(0 == compteur) {
                nbArticles = Integer.parseInt(line);
                compteur++;
            } else {
                String[] produit = line.split(" ");
                String libelle = produit[0];
                Integer prix = Integer.valueOf(produit[1]);
                if(produits.containsKey(libelle)) {
                    produits.put(libelle, produits.get(libelle) + prix);
                } else {
                    produits.put(libelle, prix);
                }
            }
        }

        int max = produits.values().stream()
                .max(Comparator.naturalOrder()).orElse(1);

        String maxProduits = produits.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(" "));

        System.out.println(maxProduits);
    }

    public static void numTelephone() {
        String line;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            int difficulte = Integer.parseInt(line);

            List<String> telNumbers = new ArrayList<>();

            Random random = new Random();
            if (difficulte == 1) {
                //Cas simple
                int cpt = 0;

                for (int i = 10000000; i < 19999999; i++) {
                    String str = Integer.toString(i);
                    TreeSet<String> tree = new TreeSet<>();
                    for (int j = 0; j < 8; j++) {
                        tree.add(str.substring(j, j + 1));
                    }
                    tree.add("0");
                    tree.add("6");
                    if (tree.size() == 4) {
                        telNumbers.add("06" + i);
                        cpt++;
                    }
                    if (cpt == 1000)
                        break;
                }

            } else if (difficulte == 2) {
                //Cas difficile
                while (telNumbers.size() < 15) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(0);
                    int sixOrSeven = random.ints(6, 8).findFirst().orElse(6);
                    sb.append(sixOrSeven);

                    ArrayList<Integer> listChiffres = new ArrayList<>();
                    for (int i = 1; i < 10; i++) {
                        if (i != sixOrSeven) listChiffres.add(i);
                    }

                    Collections.shuffle(listChiffres);
                    for (int i = 0; i < 8; i++) {
                        sb.append(listChiffres.get(i));
                    }

                    String numero = sb.toString();
                    if (!telNumbers.contains(numero)) {
                        telNumbers.add(numero);
                    }
                }
            }
            System.out.println(telNumbers.stream().collect(Collectors.joining(" ")));
            /* Lisez les données et effectuez votre traitement */
        }
    }
}
