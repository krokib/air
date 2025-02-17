/*
 * Epreuve air - Split en fonction
 * 
 * Créez un programme qui découpe une chaîne de caractères en tableau en
 * fonction du séparateur donné en 2e argument.
 * Votre programme devra intégrer une fonction prototypée comme ceci :
 * ma_fonction(string_à_couper, string_séparateur) { // syntaxe selon votre langage
 *      # votre algorithme
 *      return (tableau)
 * }
 * 
 * Exemples d’utilisation :
 * $> python exo.py “Crevette magique dans la mer des étoiles” “la”
 * Crevette magique dans
 * mer des étoiles
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

 public class Air01 {

    /*
     * coupe array en deux à index et retourne le deuxième char[], index inclus
     * retourne null si index = -1 ou index > array.length
     */
    private static char[] getSecondArray(char[] array, int index) {
        if (index == -1) {
            return null;
        } else if (index > array.length) {
            return null;
        } else {
            int len = array.length - index;
            char[] result = new char[len];
            for (int i = 0; i < len; i++) {
                result[i] = array[index + i];
            }
            return result;
        }
        
    }

    /*
     * coupe array en deux à index et retourne le premier char[], index non inclus
     * retourne null si index = -1
     * retourne null si index = 0
     */
    private static char[] getFirstArray(char[] array, int index) {
        if (index == -1) {
            return array;
        } else if (index == 0) {
            return null;
        } else {
            char[] result = new char[index];
            for (int i = 0; i < index; i++) {
                result[i] = array[i];
            }
            return result;
        }  
    }
    
    /*
     * retourne l'indice de la première occurence de separ dans array
     * retourne -1 si array ne contient pas separ
     */
    private static int getFirstIndex(char[] array, String separ) {
        char[] separArray = separ.toCharArray();
        if (array.length >= separArray.length) {
            for (int i = 0; i < array.length - separArray.length + 1; i ++) {
                if (array[i] == separArray[0]) {
                    for (int j = 0; j < separArray.length; j++) {
                        if (array[i + j] != separArray[j]) {
                            break;
                        } else if (j == separArray.length - 1) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    /*
     * retourne le nombre de chaines non vides après découpage de str par separ
     * retourne un int > 0
     */
    private static int getNumberOfStrings(String str, String separ) {
        int result = 1;
        int index = 0;
        char[] array = str.toCharArray();
        while (index != -1) {
            index = getFirstIndex(array, separ);
            if (index != -1) {
                array = getSecondArray(array, index + separ.length());
            }
            if (index > 0 && getFirstIndex(array, separ) != 0) {
                result++;
            }
        }
        return result;
    }

    /*
     * coupe str en chaines non vides selon separ
     * retourne un String[] contenant toutes ces chaines
     */
    private static String[] cutString(String str, String separ) {
        int lenSepar = separ.toCharArray().length;

        //initialisation du résultat
        int len = getNumberOfStrings(str, separ);
        String[] result = new String[len];

        //recherche des chaines non vides et rempissages du resultat
        int index = 0; //indice de la prochaine occurrence de separ
        char[] secondArray = str.toCharArray();
        for (int i = 0; i < len; i ++) {
            while (index == 0) {
                //separ se trouve au début de secondArray
                index = getFirstIndex(secondArray, separ);
                if (index == 0) {
                    secondArray = getSecondArray(secondArray, index + lenSepar);
                }
            }
            result[i] = String.copyValueOf(getFirstArray(secondArray, index));
            secondArray = getSecondArray(secondArray, index + lenSepar);
            index = 0;
        }
        
        return result;
    }

    private static void printArray(String[] strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }
 
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("error");
        } else {
            printArray(cutString(args[0], args[1]));
        }
    }
 }