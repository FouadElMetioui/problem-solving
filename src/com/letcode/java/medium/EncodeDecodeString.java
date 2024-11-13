package com.letcode.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "World", "foo", "bar");
        String encoded = encode(strings);
        System.out.println("Encoded string: " + encoded);

        // Test du décodage
        List<String> decoded = decode(encoded);
        System.out.println("Decoded strings: " + decoded);


        assert strings.equals(decoded) : "Encoding/Decoding failed";
        System.out.println("Test passed!");


    }

    public static String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length());
            result.append('_');
            result.append(str);

        }

        return result.toString();
    }


    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder mot = new StringBuilder();
        StringBuilder length = new StringBuilder();

        char[] caracters = str.toCharArray();
        int i = 0;
        List<Character> longeurChifres = new ArrayList<>();
        while (i < caracters.length) {
            // Trouve la longueur du mot courant
            while (caracters[i] != '_') {
                longeurChifres.add(caracters[i]);
                i++;
            }
            // Construit la longueur à partir des chiffres
            for (char l : longeurChifres) {
                length.append(l);
            }
            int longeur = Integer.parseInt(String.valueOf(length));
            i++; // Passe au début du mot

            // Lit le mot courant
            for (int j = i; j < i + longeur; j++) {
                mot.append(caracters[j]);
            }
            result.add(mot.toString());
            mot.setLength(0); // Réinitialise le mot en construction
            length.setLength(0); // Réinitialise la longueur en construction
            longeurChifres.clear(); // Réinitialise la liste des chiffres
            i += longeur; // Passe au mot suivant
        }

        return result;
    }
}
