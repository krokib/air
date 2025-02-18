/*
 * Epreuve air - Meta exercice
 * 
 * Créez un programme qui vérifie si les exercices de votre épreuve de l’air
 * sont présents dans le répertoire et qu’ils fonctionnent (sauf celui là). Créez
 * au moins un test pour chaque exercice.
 * 
 * Exemples d’utilisation :
 * $> python exo.py
 * air00 (1/3) : success
 * air00 (2/3) : success
 * air00 (3/3) : success
 * air01 (1/2) : success
 * air01 (2/2) : failure
 * air02 (1/1) : success
 * ...
 * Total success: (56/62)
 * 
 * Bonus : trouvez le moyen d’utiliser du vert et du rouge pour rendre
 * réussites et échecs plus visibles.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Air13 {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private static Map<Integer, Map<Integer, List<String>>> TESTS;
    private static Map<Integer, Map<Integer, String>> RESULTS;

    private static void initialisationTESTS() {
        TESTS = new TreeMap<>();
        RESULTS = new TreeMap<>();
        
        TESTS.put(0, new TreeMap<>());
        RESULTS.put(0, new TreeMap<>());

        TESTS.get(0).put(0, new ArrayList<>());
        TESTS.get(0).get(0).add(" \tBonjour   \n\tles\n\n\tgars  \n");
        RESULTS.get(0).put(0, "Bonjour\nles\ngars\n");
        TESTS.get(0).put(1, new ArrayList<>());
        TESTS.get(0).get(1).add("Bonjour les gars et les meufs");
        RESULTS.get(0).put(1, "Bonjour\nles\ngars\net\nles\nmeufs\n");
        TESTS.get(0).put(2, null);
        RESULTS.get(0).put(2, "error\n");

        TESTS.put(1, new TreeMap<>());
        RESULTS.put(1, new TreeMap<>());
        
        TESTS.get(1).put(0, new ArrayList<>());
        TESTS.get(1).get(0).add("1");
        TESTS.get(1).get(0).add("2");
        TESTS.get(1).get(0).add("3");
        RESULTS.get(1).put(0, "error\n");
        TESTS.get(1).put(1, new ArrayList<>());
        TESTS.get(1).get(1).add("Crevette magique dans la mer des étoiles");
        TESTS.get(1).get(1).add("la");
        RESULTS.get(1).put(1, "Crevette magique dans \n mer des étoiles\n");
        TESTS.get(1).put(2, new ArrayList<>());
        TESTS.get(1).get(2).add("Je danse avec les chiens mais pas les loups");
        TESTS.get(1).get(2).add("x");
        RESULTS.get(1).put(2, "Je danse avec les chiens mais pas les loups\n");

        TESTS.put(2, new TreeMap<>());
        RESULTS.put(2, new TreeMap<>());

        TESTS.get(2).put(0, null);
        RESULTS.get(2).put(0, "error\n");
        TESTS.get(2).put(1, new ArrayList<>());
        TESTS.get(2).get(1).add("Je");
        TESTS.get(2).get(1).add("teste");
        TESTS.get(2).get(1).add("des");
        TESTS.get(2).get(1).add("trucs");
        TESTS.get(2).get(1).add(" ");
        RESULTS.get(2).put(1, "Je teste des trucs\n");

        TESTS.put(3, new TreeMap<>());
        RESULTS.put(3, new TreeMap<>());

        TESTS.get(3).put(0, null);
        RESULTS.get(3).put(0, "error\n");
        TESTS.get(3).put(1, new ArrayList<>());
        TESTS.get(3).get(1).add("1");
        TESTS.get(3).get(1).add("2");
        TESTS.get(3).get(1).add("3");
        TESTS.get(3).get(1).add("4");
        TESTS.get(3).get(1).add("5");
        TESTS.get(3).get(1).add("4");
        TESTS.get(3).get(1).add("3");
        TESTS.get(3).get(1).add("2");
        TESTS.get(3).get(1).add("1");
        RESULTS.get(3).put(1, "5\n");
        TESTS.get(3).put(2, new ArrayList<>());
        TESTS.get(3).get(2).add("monsieur");
        TESTS.get(3).get(2).add("monsieur");
        TESTS.get(3).get(2).add("bonjour");
        RESULTS.get(3).put(2, "bonjour\n");

        TESTS.put(4, new TreeMap<>());
        RESULTS.put(4, new TreeMap<>());

        TESTS.get(4).put(0, null);
        RESULTS.get(4).put(0, "error\n");
        TESTS.get(4).put(1, new ArrayList<>());
        TESTS.get(4).get(1).add("Hello milady, bien ou quoi ??");
        RESULTS.get(4).put(1, "Helo milady, bien ou quoi ?\n");

        TESTS.put(5, new TreeMap<>());
        RESULTS.put(5, new TreeMap<>());

        TESTS.get(5).put(0, null);
        RESULTS.get(5).put(0, "error\n");
        TESTS.get(5).put(1, new ArrayList<>());
        TESTS.get(5).get(1).add("1");
        TESTS.get(5).get(1).add("2");
        TESTS.get(5).get(1).add("3");
        TESTS.get(5).get(1).add("4");
        TESTS.get(5).get(1).add("5");
        TESTS.get(5).get(1).add("+2");
        RESULTS.get(5).put(1, "3 4 5 6 7\n");
        TESTS.get(5).put(2, new ArrayList<>());
        TESTS.get(5).get(2).add("10");
        TESTS.get(5).get(2).add("11");
        TESTS.get(5).get(2).add("12");
        TESTS.get(5).get(2).add("20");
        TESTS.get(5).get(2).add("-5");
        RESULTS.get(5).put(2, "5 6 7 15\n");
        TESTS.get(5).put(3, new ArrayList<>());
        TESTS.get(5).get(3).add("prout");
        TESTS.get(5).get(3).add("prout");
        TESTS.get(5).get(3).add("prout");
        TESTS.get(5).get(3).add("-prout");
        RESULTS.get(5).put(3, "error\n");

        TESTS.put(6, new TreeMap<>());
        RESULTS.put(6, new TreeMap<>());

        TESTS.get(6).put(0, null);
        RESULTS.get(6).put(0, "error\n");
        TESTS.get(6).put(1, new ArrayList<>());
        TESTS.get(6).get(1).add("Bertrand");
        RESULTS.get(6).put(1, "error\n");
        TESTS.get(6).put(2, new ArrayList<>());
        TESTS.get(6).get(2).add("Michel");
        TESTS.get(6).get(2).add("Albert");
        TESTS.get(6).get(2).add("Thérèse");
        TESTS.get(6).get(2).add("Benoit");
        TESTS.get(6).get(2).add("t");
        RESULTS.get(6).put(2, "Michel\n");
        TESTS.get(6).put(3, new ArrayList<>());
        TESTS.get(6).get(3).add("Michel");
        TESTS.get(6).get(3).add("Albert");
        TESTS.get(6).get(3).add("Thérèse");
        TESTS.get(6).get(3).add("Benoit");
        TESTS.get(6).get(3).add("a");
        RESULTS.get(6).put(3, "Michel Thérèse Benoit\n");

        TESTS.put(7, new TreeMap<>());
        RESULTS.put(7, new TreeMap<>());

        TESTS.get(7).put(0, null);
        RESULTS.get(7).put(0, "error\n");
        TESTS.get(7).put(1, new ArrayList<>());
        TESTS.get(7).get(1).add("pas un nombre");
        TESTS.get(7).get(1).add("7");
        RESULTS.get(7).put(1, "error\n");
        TESTS.get(7).put(2, new ArrayList<>());
        TESTS.get(7).get(2).add("6");
        TESTS.get(7).get(2).add("8");
        TESTS.get(7).get(2).add("1");
        TESTS.get(7).get(2).add("1");
        RESULTS.get(7).put(2, "error\n");
        TESTS.get(7).put(3, new ArrayList<>());
        TESTS.get(7).get(3).add("1");
        TESTS.get(7).get(3).add("3");
        TESTS.get(7).get(3).add("4");
        TESTS.get(7).get(3).add("2");
        RESULTS.get(7).put(3, "1 2 3 4\n");
        TESTS.get(7).put(4, new ArrayList<>());
        TESTS.get(7).get(4).add("10");
        TESTS.get(7).get(4).add("20");
        TESTS.get(7).get(4).add("30");
        TESTS.get(7).get(4).add("40");
        TESTS.get(7).get(4).add("50");
        TESTS.get(7).get(4).add("60");
        TESTS.get(7).get(4).add("70");
        TESTS.get(7).get(4).add("90");
        TESTS.get(7).get(4).add("33");
        RESULTS.get(7).put(4, "10 20 30 33 40 50 60 70 90\n");

        TESTS.put(8, new TreeMap<>());
        RESULTS.put(8, new TreeMap<>());

        TESTS.get(8).put(0, null);
        RESULTS.get(8).put(0, "error\n");
        TESTS.get(8).put(1, new ArrayList<>());
        TESTS.get(8).get(1).add("fusion");
        TESTS.get(8).get(1).add("fusion");
        TESTS.get(8).get(1).add("67");
        RESULTS.get(8).put(1, "error\n");
        TESTS.get(8).put(2, new ArrayList<>());
        TESTS.get(8).get(2).add("10");
        TESTS.get(8).get(2).add("20");
        TESTS.get(8).get(2).add("30");
        TESTS.get(8).get(2).add("fusion");
        TESTS.get(8).get(2).add("15");
        TESTS.get(8).get(2).add("25");
        TESTS.get(8).get(2).add("35");
        RESULTS.get(8).put(2, "10 15 20 25 30 35\n");
        TESTS.get(8).put(3, new ArrayList<>());
        TESTS.get(8).get(3).add("10");
        TESTS.get(8).get(3).add("20");
        TESTS.get(8).get(3).add("30");
        TESTS.get(8).get(3).add("fusion");
        TESTS.get(8).get(3).add("90");
        TESTS.get(8).get(3).add("80");
        TESTS.get(8).get(3).add("60");
        RESULTS.get(8).put(3, "error\n");

        TESTS.put(9, new TreeMap<>());
        RESULTS.put(9, new TreeMap<>());

        TESTS.get(9).put(0, null);
        RESULTS.get(9).put(0, "error\n");
        TESTS.get(9).put(1, new ArrayList<>());
        TESTS.get(9).get(1).add("Michel");
        TESTS.get(9).get(1).add("Albert");
        TESTS.get(9).get(1).add("Thérèse");
        TESTS.get(9).get(1).add("Benoit");
        RESULTS.get(9).put(1, "Albert Thérèse Benoit Michel\n");

        TESTS.put(10, new TreeMap<>());
        RESULTS.put(10, new TreeMap<>());

        TESTS.get(10).put(0, null);
        RESULTS.get(10).put(0, "error\n");
        TESTS.get(10).put(1, new ArrayList<>());
        TESTS.get(10).get(1).add("a.txt");
        RESULTS.get(10).put(1, "Je danse le mia\n");

        TESTS.put(11, new TreeMap<>());
        RESULTS.put(11, new TreeMap<>());

        TESTS.get(11).put(0, null);
        RESULTS.get(11).put(0, "error\n");
        TESTS.get(11).put(1, new ArrayList<>());
        TESTS.get(11).get(1).add("AA");
        TESTS.get(11).get(1).add("5");
        RESULTS.get(11).put(1, "error\n");
        TESTS.get(11).put(2, new ArrayList<>());
        TESTS.get(11).get(2).add("O");
        TESTS.get(11).get(2).add("prout");
        RESULTS.get(11).put(2, "error\n");
        TESTS.get(11).put(3, new ArrayList<>());
        TESTS.get(11).get(3).add("O");
        TESTS.get(11).get(3).add("5");
        RESULTS.get(11).put(3, "    O    \n   OOO   \n  OOOOO  \n OOOOOOO \nOOOOOOOOO\n");
        
        TESTS.put(12, new TreeMap<>());
        RESULTS.put(12, new TreeMap<>());

        TESTS.get(12).put(0, null);
        RESULTS.get(12).put(0, "error\n");
        TESTS.get(12).put(1, new ArrayList<>());
        TESTS.get(12).get(1).add("prout");
        RESULTS.get(12).put(1, "error\n");
        TESTS.get(12).put(2, new ArrayList<>());
        TESTS.get(12).get(2).add("6");
        TESTS.get(12).get(2).add("5");
        TESTS.get(12).get(2).add("4");
        TESTS.get(12).get(2).add("3");
        TESTS.get(12).get(2).add("2");
        TESTS.get(12).get(2).add("1");
        RESULTS.get(12).put(2, "1 2 3 4 5 6\n");
    }
    
    /*
     * vérifier la présence dans le répertoire
     * compiler
     * exécuter plusiurs fois avec des arguments différents à chaque fois
     * lire et vérifier le retour pour le test
     */

    private static String getJavaFileName(int i) {
        return ((i < 10) ? ("Air0" + i + ".java") : ("Air" + i + ".java"));
    }

    private static String getClassFileName(int i) {
        return ((i < 10) ? ("Air0" + i + ".class") : ("Air" + i + ".class"));
    }

    private static String getExecFileName(int i) {
        return ((i < 10) ? ("Air0" + i) : ("Air" + i));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        File file;
        ProcessBuilder pb;
        Process proc;
        List<String> test;
        int successTotal = 0;
        int failureTotal = 0;

        initialisationTESTS();
        try {
            proc = Runtime.getRuntime().exec("touch a.txt");
            proc.waitFor();
            proc.destroy();
            FileWriter fw = new FileWriter("a.txt");
            fw.write("Je danse le mia");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 13; i++) {
            file = new File(getJavaFileName(i));

            if (!file.canRead()) {
                System.out.println("error");
            } else {

                /********Compilation********/
                file = new File(getClassFileName(i));
                proc = Runtime.getRuntime().exec("javac " + getJavaFileName(i));
                proc.waitFor();
                proc.destroy();
                System.out.println("javac " + getJavaFileName(i));
                
                /********tests********/
                    for (int j = 0; j < TESTS.get(i).size(); j++) {
                        test  = new ArrayList<>();
                        test.add("java");
                        test.add(getExecFileName(i));
                        if (TESTS.get(i).get(j) != null){
                            for (String str : TESTS.get(i).get(j)) {
                                test.add(str);
                            }
                        }
                        
                        pb = new ProcessBuilder(test);
                        
                        char[] cbuff = new char[10];
                        String result = "";
                        proc = pb.start();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        int cbuffLen;
                        while ((cbuffLen = reader.read(cbuff)) != -1) {
                            result += new String(cbuff, 0, cbuffLen);
                        }
                        int testsNb = TESTS.get(i).size();
                        System.out.print(getExecFileName(i) + " (" + (j+1) + "/" + testsNb + ") : ");
                        int comp = result.compareTo(RESULTS.get(i).get(j));
                        if (comp == 0) {
                            System.out.println(ANSI_GREEN + "success" + ANSI_RESET);
                            successTotal++;
                        } else {
                            System.out.println(ANSI_RED + "failure" + ANSI_RESET);
                            failureTotal++;
                        }

                        proc.waitFor();
                        reader.close();
                        proc.destroy();
                    }
            
                /********Effacement de Air**.class********/
                file = new File(getClassFileName(i));
                proc = Runtime.getRuntime().exec("/usr/bin/rm " + getClassFileName(i));
                proc.waitFor();
                proc.destroy();
                System.out.println("rm " + getClassFileName(i));
            }
        }
        proc = Runtime.getRuntime().exec("rm a.txt");
        proc.waitFor();
        proc.destroy();
        System.out.println("Total success: (" + successTotal + "/" + (successTotal + failureTotal) + ")");
    }
}