/*
 * Epreuve air - Contrôle de pass sanitaire
 * 
 * Créez un programme qui supprime d’un tableau tous les éléments qui ne
 * contiennent pas une autre chaîne de caractères.
 * Utilisez une fonction de ce genre (selon votre langage) :
 * ma_fonction(array_de_strings, string) {
 *      # votre algorithme
 *      return (nouvel_array_de_strings)
 * }
 * 
 * Exemples d’utilisation :
 * $> python exo.py “Michel” “Albert” “Thérèse” “Benoit” “t”
 * Michel
 * 
 * $> python exo.py “Michel” “Albert” “Thérèse” “Benoit” “a”
 * Michel, Thérèse, Benoit
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air06 {

    //Teste si deux caractères sont égaux, peu importe la casse
    private static boolean isEqual(char c1, char c2) {
        if (c1 >= 'a' && c1 <= 'z') {
            return c1 == c2 || c1 == c2 + 'a' - 'A';
        } else if (c1 >= 'A' && c1 <= 'Z') {
            return c1 == c2 || c1 == c2 + 'A' - 'a';
        } else if (c1 == 'ç' || c1 == 'Ç') {
            return c2 == 'ç' || c2 == 'Ç';
        } else if (c1 == 'é' || c1 == 'É') {
            return c2 == 'é' || c2 == 'É';
        } else {
            return c1 == c2;
        }
    }

    //Teste si str contient pass
    private static boolean isIn(String str, String pass) {
        char[] strArray = str.toCharArray();
        char[] passArray = pass.toCharArray();
        if (strArray.length < passArray.length) {
            return false;
        } else {
            boolean result = false;
            for (int i = 0; i < strArray.length - passArray.length + 1 ; i++) {
                result = true;
                for (int j = 0; j < passArray.length; j++) {
                    result &= (isEqual(strArray[i + j], passArray[j]));
                }
                if (result) {
                    return result;
                }
            }
            return result;
        }
    }

    //retourne tous les éléments de strs qui ne contiennent pas pass
    private static String[] passSan(String[] strs, String pass) {
        int len = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!isIn(strs[i], pass)) {
                len++;
            }
        }
        String[] result = new String[len];
        int j = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!isIn(strs[i], pass)) {
                result[j] = strs[i];
                j++;
            }
        }
        return result;
    }

    private static void printResult(String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            System.out.print(strs[i] + " ");
        }
        System.out.println(strs[strs.length - 1]);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("error");
        } else {
            String[] array = new String[args.length - 1];
            for (int i = 0; i < args.length - 1; i++) {
                array[i] = args[i];
            }
            printResult(passSan(array, args[args.length - 1]));
        }
    }
}