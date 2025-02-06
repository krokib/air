/*
 * Epreuve air - Un seul à la fois
 * 
 * Créez un programme qui affiche une chaîne de caractères en évitant les
 * caractères identiques adjacents.
 * 
 * Exemples d’utilisation :
 * $> python exo.py “Hello milady, bien ou quoi ??”
 * Helo milady, bien ou quoi ?
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air04 {

    private static String unSeulAlaFois(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                result += array[i];
            }
        }
        result += array[array.length - 1];
        return result;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("error");
        } else {
            System.out.println(unSeulAlaFois(args[0]));
        }
    }
}