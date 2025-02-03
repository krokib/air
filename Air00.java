/*
 * Epreuve air - Split
 * 
 * Créez un programme qui découpe une chaîne de caractères en tableau
 * (séparateurs : espaces, tabulations, retours à la ligne).
 * Votre programme devra utiliser une fonction prototypée comme ceci :
 * ma_fonction(string_à_couper, string_séparateur) { // syntaxe selon votre langage
 *      # votre algorithme
 *      return (tableau)
 * }
 * 
 * Exemples d’utilisation :
 * $> python exo.py “Bonjour les gars”
 * Bonjour
 * les
 * gars
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

 public class Air00 {

   private static boolean isInString(char car, String str) {
      for (char c : str.toCharArray()) {
         if (car == c) {
            return true;
         }   
      }
      return false;
   }

   private static String[] cutString(String str, String separ) {
      //Recherche de la taille du String[] retourné
      int strBigArrayLen = 0;
      boolean newWord = true;
      for (char c : str.toCharArray()) {
         if (isInString(c, separ)) {
            newWord = true;
         } else if (newWord) {
            strBigArrayLen++;
            newWord = false;
         }
      }

      //initialisation du String[] retourné
      String[] strBigArray = new String[strBigArrayLen];

      //remplissage du String[]
      int wordNumber = 0;
      char[] strArray = str.toCharArray();
      char[] wordArray;
      for (int i = 0; i < strArray.length; i++) {
         if (!isInString(strArray[i], separ)) {
            int j = i + 1;
            while (j < strArray.length && !isInString(strArray[j], separ)) {
               j++;
            }
            wordArray = new char[j - i + 1];
            for (int k = 0; k < j - i; k++) {
               wordArray[k] = strArray[i + k];
            }
            strBigArray[wordNumber] = String.copyValueOf(wordArray);
            wordNumber++;
            i = j;
         }
      }
      return strBigArray;
   }

   private static void printArray(String[] strs) {
      for (String str : strs) {
         System.out.println(str);
      }
   }
 
    public static void main(String[] args) {
      if (args.length != 1) {
         System.out.println("args.length = " + args.length);
         System.out.println("error");
      } else {
         printArray(cutString(args[0]," \t\n"));
      }
    }
 }