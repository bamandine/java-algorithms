package fr.bamandine.main;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FakerUtils {
    private static final Faker FAKER = new Faker();

    public static List<Address>  listAddress(int nbElement) {
        List<Address> liste = new ArrayList<>();
        for(int compteur = nbElement; compteur >= 0; compteur--) {
            liste.add(FAKER.address());
        }
        return liste;
    }

    public static List<Integer> listRandomDigitNotZero(int nbElement) {
        List<Integer> liste = new ArrayList<>();
        for(int compteur = nbElement; compteur >= 0; compteur--) {
            liste.add(FAKER.number().randomDigitNotZero());
        }
        return liste;
    }

    public static List<Integer> listRandomNumberBetween(int nbElement, int min, int max) {
        List<Integer> liste = new ArrayList<>();
        for(int compteur = nbElement; compteur >= 0; compteur--) {
            liste.add(FAKER.number().numberBetween(min, max));
        }
        return liste;
    }

    public static List<Date> listRandomDateBetween(int nbElement, Date from, Date to) {
        List<Date> liste = new ArrayList<>();
        for(int compteur = nbElement; compteur >= 0; compteur--) {
            liste.add(FAKER.date().between(from, to));
        }
        return liste;
    }

    public static List<String> listRandomStringLengthBetween(int nbElement, int minimumLength, int maximumLength) {
        List<String> liste = new ArrayList<>();
        for(int compteur = nbElement; compteur >= 0; compteur--) {
            liste.add(FAKER.lorem().characters(minimumLength, maximumLength));
        }
        return liste;
    }
}
