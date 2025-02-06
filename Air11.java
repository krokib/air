/*
 * Epreuve air - Afficher une pyramide
 * 
 * Afficher un escalier constitué d’un caractère et d’un nombre d’étages
 * donné en paramètre.
 * 
 * Exemples d’utilisation :
 * $> ruby exo.rb O 5
 *     O
 *    OOO
 *   OOOOO
 *  OOOOOOO
 * OOOOOOOOO
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air11 {

    private static void pyramide(char c, int nb) {
        for (int i = 0; i < nb; i++) {
            for (int j = nb - 1; j > i; j--) {
                System.out.print(' ');
            }
            for (int j = i; j > 0; j--) {
                System.out.print(c);
            }
            System.out.print(c);
            for (int j = 0; j < i; j++) {
                System.out.print(c);
            }
            for (int j = i; j < nb; j++) {
                System.out.print(' ');
            }

            System.out.println("");
        }
    }

    private static boolean testArguments(String[] args) {
        if (args.length != 2) {
            return false;
        } else {
            if (args[0].length() > 1 || !args[1].matches("[0-9]+")) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        if (!testArguments(args)) {
            System.out.println("error");
        } else {
            char car = args[0].toCharArray()[0];
            int nb = Integer.parseInt(args[1]);
            pyramide(car, nb);
        }
    }
}