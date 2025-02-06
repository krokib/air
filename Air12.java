/*
 * Epreuve air - Le roi des tris
 * 
 * Créez un programme qui trie une liste de nombres. Votre programme
 * devra implémenter l’algorithme du tri rapide (QuickSort).
 * Vous utiliserez une fonction de cette forme (selon votre langage) :
 * my_quick_sort(array) {
 *      # votre algorithme
 *      return (new_array)
 * }
 * 
 * Exemples d’utilisation :
 * $> python exo.py 6 5 4 3 2 1
 * 1 2 3 4 5 6
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 * Wikipedia vous présentera une belle description de cet algorithme de tri.
 */

public class Air12 {

    /*
     * Tri un tableau de int par ordre croissant par tri rapide
     * Le pivot, à chaque itération, est le dernier élément du sous-tableau
     */
    private static int[] quickSort(int[] ints, int first, int last) {
        if (first < last) {
            int j = first;
            int tmp;
            for (int i = first; i < last; i++) {
                if (ints[i] <= ints[last]) {
                    tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                    j++;
                }
            }
            tmp = ints[j];
            ints[j] = ints[last];
            ints[last] = tmp;
            quickSort(ints, first, j - 1);
            quickSort(ints, j + 1, last);
        }
        return ints;
    }

    private static void printResult(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    private static boolean testArguments(String[] args) {
        if (args.length == 0) {
            return false;
        } else {
            for (int i = 0; i < args.length; i++) {
                if (!args[i].matches("[+-]?[0-9]+")) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        if (!testArguments(args)) {
            System.out.println("error");
        } else {
            int[] ints = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                ints[i] = Integer.parseInt(args[i]);
            }
            printResult(quickSort(ints, 0, ints.length - 1));
        }
    }
}