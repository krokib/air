/*
 * Epreuve air - Sur chacun d’entre eux
 * 
 * Créez un programme qui est capable de reconnaître et de faire une
 * opération (addition ou soustraction) sur chaque entier d’une liste.
 * 
 * Exemples d’utilisation :
 * $> ruby exo.rb 1 2 3 4 5 “+2”
 * 3 4 5 6 7
 * 
 * $> ruby exo.rb 10 11 12 20 “-5”
 * 5 6 7 15
 * 
 * L’opération à appliquer sera toujours le dernier élément.
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air05 {

    private static boolean testArguments(String[] args) {
        if (args.length < 3) {
            return false;
        } else {
            for (int i = 0; i < args.length - 1 ; i++) {
                if (!args[i].matches("[+-]?[0-9]+")) {
                    return false;
                }
            }
            if (!args[args.length - 1].matches("[+-][0-9]+")) {
                return false;
            }
            return true;
        }   
    }

    private static int[] operationOnEachOne(int[] list, char sign, int op) {
        for (int i = 0; i < list.length; i ++) {
            switch (sign) {
                case '+':
                    list[i] += op;
                    break;
                case '-':
                    list[i] -= op;
                    break;
                default:
                break;
            }
        }
        return list;
    }

    private static void printResult(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println(ints[ints.length - 1]);
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
            char sign = args[len - 1].toCharArray()[0];
            char[] tmpArray = args[len - 1].toCharArray();
            char[] array = new char[tmpArray.length - 1];
            for (int i = 0; i < tmpArray.length - 1; i++) {
                array[i] = tmpArray[i + 1];
            }
            int op = Integer.parseInt(String.copyValueOf(array));
            printResult(operationOnEachOne(ints, sign, op));
        }
    }
}