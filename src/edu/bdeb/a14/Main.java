package edu.bdeb.a14;

import static edu.bdeb.a14.Afficher.*;

/**
 * La classe edu.bdeb.a14.Main contient le point d'entrée du programme.
 * Elle permet d'afficher la séquence de Fibonacci et de comparer les performances.
 *
 * @author benkaddour wafaa Elhak
 * @author Allani Jawhar
 */
public class Main {

    /**
     * Point d'entrée du programme.
     * Cette méthode valide l'entrée de l'utilisateur pour obtenir un nombre de termes,
     * puis affiche la séquence de Fibonacci et compare les performances des méthodes itérative et récursive.
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */

    public static void main(String[] args) {

        // Appel de la méthode pour valider l'entrée de l'utilisateur et obtenir un nombre valide
        int number = getValidNumber();

        // Appel de la méthode pour afficher la suite de Fibonacci et mesurer les performances
        long[] durations = displayFibonacci(number);

        // Appel de la méthode pour comparer les performances des deux méthodes
        comparePerformance(durations[0], durations[1]);
    }
}
