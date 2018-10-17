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

}
