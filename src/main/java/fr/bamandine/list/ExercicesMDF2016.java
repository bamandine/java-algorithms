package fr.bamandine.list;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class ExercicesMDF2016 {

    public static void productionVoiture() {
        String  line;
        int infoPremiereLigne = 0;
        List<Integer> values = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if(infoPremiereLigne == 0) {
                infoPremiereLigne = Integer.parseInt(line);
            } else {
                values.add(Integer.parseInt(line));
            }
            /* Lisez les données et effectuez votre traitement */
        }

        int somme = values.stream().mapToInt(v -> v).sum();
        //TODO

        System.out.println(somme);
    }

    public static void snake() {
        String line;
        int tailleSnake = 0;
        int infoDeuxiemeLigne = 0;
        int head=0;
        List<String> directions = new ArrayList<>();
        List<Coord> positions = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if (tailleSnake == 0) {
                tailleSnake = Integer.parseInt(line);
                for(int i = 0; i < tailleSnake; i++) {
                    positions.add(new Coord(i, 0));
                }
                head=tailleSnake - 1;
            } else if (infoDeuxiemeLigne == 0) {
                infoDeuxiemeLigne = Integer.parseInt(line);

            } else {
                directions.add(line);
            }
            /* Lisez les données et effectuez votre traitement */
        }

        for (int d = 0; d < directions.size(); d++) {
            int coordXActual = positions.get(head).x;
            int coordYActual = positions.get(head).y;
            switch (directions.get(d)) {
                case "D":
                    positions.set(head, positions.get(head).D());
                    break;

                case "G":
                    positions.set(head, positions.get(head).G());
                    break;

                case "H":
                    positions.set(head, positions.get(head).H());
                    break;

                case "B":
                    positions.set(head, positions.get(head).B());
                    break;
            }

            for (int p = 0; p < head; p++) {
                positions.set(p, new Coord(positions.get(p+1).x, positions.get(p+1).y));
            }
            positions.set(head - 1, new Coord(coordXActual, coordYActual));
        }

        StringBuffer sb = new StringBuffer();
        //TODO

        System.out.println(positions.get(0).x + " " + positions.get(0).y);
    }

    public static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x=x;
            this.y=y;
        }

        Coord D() {
            this.x+=1;
            return this;
        }

        Coord G() {
            this.x-=1;
            return this;
        }

        Coord H() {
            this.y-=1;
            return this;
        }

        Coord B() {
            this.y+=1;
            return this;
        }

        void setNewCoord(Coord coord) {
            this.x = coord.x;
            this.y = coord.y;
        }
    }

    public static void renduMonnaie() {
        String line;
        int monnaie = 0;
        int nbPieces = 0;
        List<Piece> values = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if(monnaie == 0) {
                monnaie = Integer.parseInt(line);
            } else if (nbPieces == 0) {
                nbPieces = Integer.parseInt(line);
            } else {
                String[] ligne = line.split(" ");
                Piece piece = new Piece(Integer.valueOf(ligne[0]), Integer.valueOf(ligne[1]));
                values.add(piece);
            }
            /* Lisez les données et effectuez votre traitement */
        }

        Collections.reverse(values);

        int recurse = recurse(values, monnaie, 0);
        if (recurse == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(recurse);
        }

        StringBuffer sb = new StringBuffer();
        //TODO

        System.out.println(sb.toString());
    }

    public static int recurse(List<Piece> typePieces,
                              int monnaieARendre,
                              int nbPieces) {

        if (typePieces.isEmpty()) {
            if (monnaieARendre == 0) {
                return nbPieces;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        Piece piece = typePieces.get(0);
        int min = Integer.MAX_VALUE;
        int rendu = monnaieARendre / piece.valeur;
        int nbPiecesdeCeType = Math.min(piece.nbre, rendu);
        List<Integer> pieces = new ArrayList<Integer>();
        for (int i = 0; i <= nbPiecesdeCeType; ++i) {
            int resteARendre = monnaieARendre;
            int nbPiecesARendre = nbPieces;
            nbPiecesARendre += i;
            resteARendre -= piece.valeur * i;
            pieces.add(recurse(typePieces.subList(1, typePieces.size()),
                    resteARendre,
                    nbPiecesARendre));

        }
        Collections.sort(pieces);
        min = pieces.get(0);
        return min;

    }

    public static class Piece {
        int nbre;
        int valeur;

        public Piece(Integer nbre, Integer valeur) {
            this.nbre = nbre;
            this.valeur = valeur;
        }
    }
}
