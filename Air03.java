/*
 * Epreuve air - Chercher l’intrus
 * 
 * Créez un programme qui retourne la valeur d’une liste qui n’a pas de paire.
 * 
 * Exemples d’utilisation :
 * $> python exo.py 1 2 3 4 5 4 3 2 1
 * 5
 * 
 * $> python exo.py bonjour monsieur bonjour
 * monsieur
 * 
 * Afficher error et quitter le programme en cas de problèmes d’arguments.
 */

public class Air03 {

    //Teste si deux String sont équales caractère par caractère
    private static boolean isEqual(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        if (aArray.length != bArray.length) {
            return false;
        } else {
            for (int i = 0; i < aArray.length; i++) {
                if (aArray[i] != bArray[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    //Retourne dans une String, les éléments sans paire de strs,
    //séparés d'un espace
    private static String intrus(String[] strs) {
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            //On parcourt strs de 0 à n-1 (n longeur de strs)
            if (i == strs.length - 1) {
                //Si on est sur le dernier élément, pas de paire possible
                result += (result == "") ? strs[i] : (" " + strs[i]);
            } else {
                //On teste l'égalité avec tous les éléments de i+1 à n-1
                for (int j = i + 1; j < strs.length; j++) {
                    if (isEqual(strs[i], strs[j])) {
                        //Si le jème élément fait la paire
                        //On l'échange avec l'i+1ème élément
                        strs[j] = strs[i + 1];
                        strs[i + 1] = strs[i];
                        //On passe directement au i+2ème élément
                        i++;
                        break;
                    } else if (j == strs.length - 1) {
                        //Si aucun élément paire n'est trouvé, on l'ajoute au résultat
                        result += (result == "") ? strs[i] : (" " + strs[i]);
                    }
                }
            }
            
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("error");
        } else {
            System.out.println(intrus(args));
        }
    }
}