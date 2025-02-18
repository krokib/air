/*
 * Epreuve air - Afficher le contenu
 * 
 * Créez un programme qui affiche le contenu d’un fichier donné en
 * argument.
 * 
 * Exemples d’utilisation :
 * $> cat a.txt
 * Je danse le mia
 * 
 * $> ruby exo.rb “a.txt”
 * Je danse le mia
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments
 * ou de fichier inaccessible.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Air10 {

    private static boolean testArgument(String[] args) {
        if (args.length != 1) {
            return false;
        } else {
            File file = new File(args[0]);
            if (!file.canRead()) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        if (!testArgument(args)) {
            System.out.println("error");
        } else {
            File file = new File(args[0]);
            try {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                int i;
                while ((i = buffer.read()) != -1) {
                    System.out.print((char) i);
                }
                buffer.close();
                System.out.println("");
            } catch (Exception e) {
                System.out.println("error");
            }
            
        }
    }
}