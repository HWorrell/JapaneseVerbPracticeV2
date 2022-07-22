import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        //File format:
        //0 == dictionary form
        //1 == u or ru verb
        //2 == english definition

        /*
        String testDict = "勉強する";
        boolean ruVerb = false;

        Verb test = new Verb(testDict, ruVerb);

        System.out.println(test.presentAffirmative());
        System.out.println(test.presentNegative());
        System.out.println(test.pastAffirmative());
        System.out.println(test.pastNegative());
        System.out.println(test.teForm());
        System.out.println(test.shortFormAffirmative());
        System.out.println(test.shortFormNegative());
        */

        //pull in config file
        File config = new File("Config.ini");
        //default if it doesn't exist
        if (!config.exists()) {
            UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
        } else {
            try {
                Scanner scanner = new Scanner(config);
                String in = scanner.nextLine();
                in = in.replace("FontSize=[", "").replace("]", "");
                int fontSize = Integer.parseInt(in);
                UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, fontSize));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        File sourceDir = new File("SourceFiles//Active");
        File[] dir = sourceDir.listFiles();

        Vector<Verb> verbVector = new Vector<>();

        for (File f : dir
        ) {
            if (f.getName().contains(".txt")) {
                try {
                    BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_16));
                    String str = "";
                    while ((str = inReader.readLine()) != null) {
                        String dictionaryForm = str.substring(0, str.indexOf("\t"));
                        str = str.substring(str.indexOf("\t") + 1);
                        String uorRu = str.substring(0, str.indexOf("\t"));
                        str = str.substring(str.indexOf("\t") + 1);
                        String english = str.replace("\t", "");
                        boolean uorRUBool = uorRu.toLowerCase().contains("ru");
                        Verb tempTerm = new Verb(dictionaryForm, uorRUBool, english);
                        verbVector.add(tempTerm);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        //SelfQuiz selfQuiz = new SelfQuiz(verbVector);

        //selfQuiz.selfQuiz(10);

        //FlashCards flashCards = new FlashCards(verbVector);

        String in = JOptionPane.showInputDialog("Enter 1 to self quiz\r\n" +
                "Enter 2 to have a quiz with Hiragana and Katakana parsing (for someone that can't read them)\r\n" +
                "Enter 3 to do flash cards\r\n" +
                "Enter \"quit\" to quit");

        switch (in) {
            case "1":
                int selfRounds = Integer.parseInt(JOptionPane.showInputDialog("How may rounds do you want to do?"));
                SelfQuiz selfQuiz = new SelfQuiz(verbVector);
                selfQuiz.selfQuiz(selfRounds);
                System.exit(0);
                break;
            case "2":
                int otherRounds = Integer.parseInt(JOptionPane.showInputDialog("How may rounds do you want to do?"));
                //hiragana translation file
                File hiraganaInFile = new File("hiragana.csv");
                //katakana translation file
                File katakanaInFile = new File("katakana.csv");
                RomajiParser romajiParser = new RomajiParser(hiraganaInFile, katakanaInFile);
                OtherQuiz otherQuiz = new OtherQuiz(verbVector, romajiParser);
                otherQuiz.otherQuiz(otherRounds);
                System.exit(0);
                break;
            case "3":
                int flashcardRounds = Integer.parseInt(JOptionPane.showInputDialog("How may rounds do you want to do?"));
                FlashCards flashCards = new FlashCards(verbVector);
                flashCards.showFlashCard(flashcardRounds);
                System.exit(0);
                break;
            default:
                System.exit(0);

        /*
        for (Verb v: verbVector
             ) {
            testOutput(v);
        }

 */

        }

    /*
    static void testOutput(Verb v){
        System.out.println(v.getDictionaryForm());
        System.out.println(v.presentAffirmative());
        System.out.println(v.presentNegative());
        System.out.println(v.pastAffirmative());
        System.out.println(v.pastNegative());
        System.out.println(v.teForm());
        System.out.println(v.shortFormAffirmative());
        System.out.println(v.shortFormNegative());


    }
    */

    }
}