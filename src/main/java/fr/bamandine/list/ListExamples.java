package fr.bamandine.list;

import java.util.*;

public class ListExamples {

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

}
