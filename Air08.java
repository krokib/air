/*
 * Epreuve air - Mélanger deux tableaux triés
 * 
 * Créez un programme qui fusionne deux listes d’entiers triées en les
 * gardant triées, les deux listes seront séparées par un “fusion”.
 * Utilisez une fonction de ce genre (selon votre langage) :
 * sorted_fusion(array1, array2) {
 *      # your algo
 *      return (new_array)
 * }
 * 
 * Exemples d’utilisation :
 * $> ruby exo.rb 10 20 30 fusion 15 25 35
 * 10 15 20 25 30 35
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air08 {

    /*
     * fusionne deux tableaux d'entiers triés en un tableau d'entiers triés
     */
    private static int[] fusion(int[] ints1, int[] ints2) {
        int len = ints1.length + ints2.length;
        int[] result = new int[len];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < len; i++) {
            if (index1 >= ints1.length) {
                //tous les éléments de ints1 sont placés dans result
                result[i] = ints2[index2];
                index2++;
            } else if (index2 >= ints2.length) {
                //tous les éléments de ints2 sont placés dans result
                result[i] = ints1[index1];
                index1++;
            } else {
                if (ints1[index1] <= ints2[index2]) {
                    result[i] = ints1[index1];
                    index1++;
                } else {
                    result[i] = ints2[index2];
                    index2++;
                }
            }
        }
        return result;
    }

    private static int[][] cutArgumentsInt(String[] args) {
        int[][] result = new int[2][];
        String[][] strs = cutArgumentString(args);
        for (int k = 0; k < 2; k++) {
            result[k] = new int[strs[k].length];
            for (int i = 0; i < strs[k].length; i++) {
                result[k][i] = Integer.parseInt(strs[k][i]);
            }
        }
        return result;
    }

    private static void printResult(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println(ints[ints.length - 1]);
    }



    //Teste si str = "fusion"
    private static boolean isFusion(String str) {
        char[] fusion = "fusion".toCharArray();
        char[] array = str.toCharArray();
        if (array.length != fusion.length) {
            return false;
        } else {
            for (int i = 0; i < fusion.length; i++) {
                if (array[i] != fusion[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    /*
     * Recherche la String "fusion" dans strs
     * Retourne l'indice de fusion dans strs
     * Retourne -1 si absent ou au moins deux occurrences
     */
    private static int fusionIndex(String[] strs) {
        boolean fusionFound = false;
        int fusionIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (isFusion(strs[i])) {
                if (fusionFound) {
                    return -1;
                } else {
                    fusionFound = true;
                    fusionIndex = i;
                }
            }
        }
        return fusionFound ? fusionIndex : -1;
    }

    //Teste si un tableau de int est une suite d'entiers
    //triés par ordre croissant
    private static boolean isSorted(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //Teste si les éléments de strs sont des entiers
    private static boolean isNumbers(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].matches("[+-]?[0-9]+")) {
                return false;
            }
        }
        return true;
    }

    /*
     * coupe strs en deux tableaux selon le séparateur "fusion"
     * présent dans le tableau
     */
    private static String[][] cutArgumentString(String[] strs) {
        String[][] result = new String[2][];
        int fusionIndex = fusionIndex(strs);
        result[0] = new String[fusionIndex];
        result[1] = new String[strs.length - fusionIndex - 1];
        for (int i = 0; i < fusionIndex; i++) {
            result[0][i] = strs[i];
        }
        for (int i = 0; i < strs.length - fusionIndex - 1; i++) {
            result[1][i] = strs[fusionIndex + 1 + i];
        }
        return result;
    }

    private static boolean testArguments(String[] args) {
        if (args.length < 3) {
            return false;
        } else {
            //Présence du mot 'fusion' une et une seule fois
            int fusionIndex = fusionIndex(args);
            if (fusionIndex == -1) {
                return false;
            } else {
                String[][] strs = cutArgumentString(args);
                if (!isNumbers(strs[0]) || !isNumbers(strs[1])) {
                    return false;
                } else {
                    int[][] ints = cutArgumentsInt(args);
                    if (!isSorted(ints[0]) || !isSorted(ints[1])) {
                        return false;
                    }
                }
            }
            return true;
        }
        
    }

    public static void main(String[] args) {
        if (!testArguments(args)) {
            System.out.println("error");
        } else {
            int[][] ints = cutArgumentsInt(args);
            printResult(fusion(ints[0], ints[1]));
        }
    }
}