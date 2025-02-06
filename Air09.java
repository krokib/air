/*
 * Epreuve air - Rotation vers la gauche
 * 
 * Créez un programme qui décale tous les éléments d’un tableau vers la
 * gauche. Le premier élément devient le dernier à chaque rotation.
 * Utilisez une fonction de ce genre (selon votre langage) :
 * ma_rotation(array) {
 *      # votre algorithme
 *      return (new_array)
 * }
 * 
 * Exemples d’utilisation :
 * $> python exo.py “Michel” “Albert” “Thérèse” “Benoit”
 * Albert, Thérèse, Benoit, Michel
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air09 {

    private static String[] rotation(String[] strs) {
        String[] result = new String[strs.length];
        result[strs.length - 1] = strs[0];
        if (strs.length > 1) {
            for (int i = 1; i < strs.length; i++) {
                result[i - 1] = strs[i];
            }
        }
        return result;
    }

    private static void printResult(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("error");
        } else {
            printResult(rotation(args));
        }
    }
}