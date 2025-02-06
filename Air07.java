/*
 * Epreuve air - Insertion dans un tableau trié
 * 
 * Créez un programme qui ajoute à une liste d’entiers triée un nouvel entier
 * tout en gardant la liste triée dans l’ordre croissant. Le dernier argument est
 * l’élément à ajouter.
 * Utilisez une fonction de ce genre (selon votre langage) :
 * sorted_insert(array, new_element) {
 *      # your algo
 *      return (new_array)
 * }
 * 
 * Exemples d’utilisation :
 * $> ruby exo.rb 1 3 4 2
 * 1 2 3 4
 * 
 * $> ruby exo.rb 10 20 30 40 50 60 70 90 33
 * 10 20 30 33 40 50 60 70 90
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air07 {

    private static int[] triInt(int[] ints, int newInt) {
        int[] result = new int[ints.length + 1];
        boolean tri = false;
        for (int i = 0; i < ints.length; i++) {
            if (!tri && newInt < ints[i]) {
                tri = true;
                result[i] = newInt;
            } else {
                result[i] = ints[(tri ? (i - 1) : i)];
            }
        }
        result[ints.length] = tri ? ints[ints.length - 1] : newInt;
        return result;
    }

    private static void printResult(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    private static boolean testArguments(String[] args) {
        if (args.length < 2) {
            return false;
        } else {
            for (int i = 0; i < args.length; i++) {
                if (!args[i].matches("[+-]?[0-9]+")) {
                    return false;
                }
            }
            //Vérification du tri croissant de la suite entrée en arguments
            int[] ints = new int[args.length - 1];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.parseInt(args[i]);
            }
            for (int i = 0; i < ints.length - 1; i++) {
                if (ints[i] > ints[i + 1]) {
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
            int len = args.length;
            int[] ints = new int[len - 1];
            for (int i = 0; i < len - 1; i++) {
                ints[i] = Integer.parseInt(args[i]);
            }
            int newInt = Integer.parseInt(args[len - 1]);
            printResult(triInt(ints, newInt));
        }
    }
}