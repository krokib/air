/*
 * Epreuve air - Concat
 * 
 * Créez un programme qui transforme un tableau de chaînes de caractères
 * en une seule chaîne de caractères. Espacés d’un séparateur donné en
 * dernier argument au programme.
 * 
 * Utilisez une fonction de ce genre (selon votre langage) :
 * ma_fonction(array_de_strings, separateur) {
 *      # votre algorithme
 *      return (string)
 * }
 * 
 * Exemples d’utilisation :
 * $> python exo.py “je” “teste” “des” “trucs” “ “
 * Je teste des trucs
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air02 {

   private static String concat(String[] strs, String separ) {
      String result = "";
      for (int i = 0; i < strs.length; i++) {
         result += strs[i] + ((i != (strs.length - 1)) ? separ : "");
      }
      return result;
   }
 
   public static void main(String[] args) {
      if (args.length < 3) {
         System.out.println("error");
      } else {
         String[] strs = new String[args.length - 1];
         for (int i = 0; i < args.length - 1; i++) {
            strs[i] = args[i];
         }
         System.out.println(concat(strs, args[args.length - 1]));
      }
   }
}