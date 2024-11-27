package edu.bdeb.a14;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * La classe {@code Afficher} fournit des méthodes pour obtenir un nombre valide de l'utilisateur,
 * afficher la suite de Fibonacci de manière itérative et récursive, et comparer les performances de ces deux méthodes.
 *
 * @author benkaddour
 * @author jawhar
 */

public class Afficher {

    /**
     * Demande à l'utilisateur un nombre valide pour générer la suite de Fibonacci.
     * La saisie de l'utilisateur est validée pour s'assurer que le nombre est un entier positif
     * inférieur ou égal à 1000.
     *
     * @return un entier représentant le nombre d'éléments à afficher dans la suite de Fibonacci.
     */
    public static int getValidNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            try {
                // Demander à l'utilisateur de saisir un nombre
                System.out.print("Combien de nombres voulez-vous dans la suite de Fibonacci ? (max 1000) ");

                // Lire l'entrée utilisateur en tant que chaîne
                String input = scanner.nextLine().trim();

                // Vérifie si l'utilisateur a appuyé sur "Entrée" sans rien saisir
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Vous devez entrer un nombre.");
                }

                // Convertir l'entrée en entier
                number = Integer.parseInt(input);

                // Vérification des limites
                if (number < 0) {
                    throw new IllegalArgumentException("Le nombre doit être positif.");
                } else if (number > 1000) {
                    throw new IllegalArgumentException("Le nombre ne peut pas dépasser 1000.");
                }

                break; // Sortir de la boucle si l'entrée est valide
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un entier valide.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }

        return number; // Retourner le nombre valide
    }

    /**
     * Affiche la suite de Fibonacci en utilisant deux méthodes différentes : itérative et récursive.
     * Cette méthode mesure également les performances des deux méthodes en termes de durée d'exécution.
     *
     * @param number le nombre d'éléments à afficher dans la suite de Fibonacci.
     * @return un tableau de deux valeurs représentant les durées d'exécution respectives pour les méthodes itérative et récursive.
     */
    public static long[] displayFibonacci(int number) {
        long durationIterative = 0;
        long durationRecursive = 0;

        if (number == 0) {
            System.out.println("Vous avez demandé 0 éléments, il n'y a rien à afficher.");
        } else {
            // Affichage de la suite Fibonacci avec la méthode itérative
            System.out.println("\nAfficher la suite de Fibonacci en utilisant la méthode itérative :");
            long startIterative = System.nanoTime();
            Fibonacci.CalculateFibonacciIterative(number);
            long endIterative = System.nanoTime();
            durationIterative = (endIterative - startIterative) / 1_000_000; // Conversion en millisecondes
            System.out.println("\nDurée du traitement itératif : " + durationIterative + " millisecondes");

            // Affichage de la suite Fibonacci avec la méthode récursive
            System.out.println("\nAfficher la suite de Fibonacci en utilisant la méthode récursive :");
            long startRecursive = System.nanoTime();
            for (int i = 0; i < number; i++) {
                System.out.print(Fibonacci.CalculateFibonacciRecursive(BigInteger.valueOf(i)) + " - ");
            }
            long endRecursive = System.nanoTime();
            durationRecursive = (endRecursive - startRecursive) / 1_000_000; // Conversion en millisecondes
            System.out.println("\nDurée du traitement récursif : " + durationRecursive + " millisecondes");
        }

        // Retourner les deux durées dans un tableau
        return new long[] {durationIterative, durationRecursive};
    }

    /**
     * Compare les performances des méthodes itérative et récursive en fonction de leurs durées d'exécution.
     *
     * @param durationIterative la durée d'exécution de la méthode itérative en millisecondes.
     * @param durationRecursive la durée d'exécution de la méthode récursive en millisecondes.
     */
    public static void comparePerformance(long durationIterative, long durationRecursive) {
        System.out.println("\nComparaison des performances :");

        if (durationIterative < durationRecursive) {
            System.out.println("La méthode itérative est la plus rapide.");
        } else if (durationIterative > durationRecursive) {
            System.out.println("La méthode récursive est la plus rapide.");
        } else {
            System.out.println("Les deux méthodes ont des performances équivalentes.");
        }
    }
}
