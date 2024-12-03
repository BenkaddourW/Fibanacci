package edu.bdeb.a14;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe permettant de calculer les termes de la suite de Fibonacci
 * en utilisant des approches itérative et récursive avec mémorisation.
 * La méthode itérative est utilisée pour afficher les termes successifs de la suite,
 * tandis que la méthode récursive avec mémorisation optimise les appels récursifs
 * en stockant les résultats intermédiaires dans une table de hachage.
 */
public class Fibonacci {

    /**
     * Calcule et affiche les termes de la suite de Fibonacci en utilisant une approche itérative.
     * Cette méthode affiche les termes successifs de la suite de Fibonacci jusqu'à
     * la valeur spécifiée par le paramètre {@code nombre}.
     *
     * @param nombre le nombre de termes de la suite de Fibonacci à afficher.
     *               Si {@code nombre} vaut 0, aucun terme n'est affiché.
     *               Si {@code nombre} vaut 1, seul le premier terme (0) est affiché.
     */
    public static void CalculerFibonacciIteratif(int nombre) {
        // Si le nombre demandé est 0, il n'y a rien à afficher
        if (nombre == 0) return;

        // Initialisation des deux premiers termes de la suite
        BigInteger premierNombre = BigInteger.ZERO;
        BigInteger deuxiemeNombre = BigInteger.ONE;

        // Affichage du premier terme
        System.out.print(premierNombre);

        // Si le nombre demandé est supérieur à 1, affiche également le deuxième terme
        if (nombre > 1) {
            System.out.print(" - " + deuxiemeNombre);
        }

        // Boucle pour calculer et afficher les termes suivants
        for (int i = 2; i < nombre; i++) {
            // Calcule le terme suivant en ajoutant les deux précédents
            BigInteger valeurFibonacci = premierNombre.add(deuxiemeNombre);

            // Affiche le terme calculé
            System.out.print(" - " + valeurFibonacci);

            // Met à jour les variables pour le prochain calcul
            premierNombre = deuxiemeNombre;
            deuxiemeNombre = valeurFibonacci;
        }
    }

    // Map pour stocker les résultats intermédiaires (mémorisation)
    private static final Map<BigInteger, BigInteger> memoire = new HashMap<>();

    /**
     * Calcule un terme spécifique de la suite de Fibonacci en utilisant une approche récursive
     * avec mémorisation. Cette méthode permet de réduire la complexité de l'algorithme récursif
     * en mémorisant les résultats des sous-calculs.
     *
     * @param nombre le rang du terme de la suite de Fibonacci à calculer.
     *               Doit être un entier non négatif.
     * @return le terme de la suite de Fibonacci au rang {@code nombre}.
     *         Retourne un objet {@link BigInteger} représentant le terme calculé.
     */
    public static BigInteger CalculerFibonacciRecursif(BigInteger nombre) {
        // Cas de base : Fibonacci(0) = 0 et Fibonacci(1) = 1
        if (nombre.compareTo(BigInteger.ONE) <= 0) {
            return nombre;
        }

        // Vérifie si le résultat est déjà mémorisé
        if (memoire.containsKey(nombre)) {
            return memoire.get(nombre); // Retourne la valeur mémorisée
        }

        // Calcul récursif avec mémorisation
        BigInteger resultat = CalculerFibonacciRecursif(nombre.subtract(BigInteger.ONE))
                .add(CalculerFibonacciRecursif(nombre.subtract(BigInteger.TWO)));

        // Stocke le résultat dans la map pour un accès futur
        memoire.put(nombre, resultat);
        return resultat;
    }
}
