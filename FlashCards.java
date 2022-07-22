import javax.swing.*;
import java.util.Random;
import java.util.Vector;

public class FlashCards {

    Vector<Verb> verbVector;

    FlashCards(Vector<Verb> v){
        this.verbVector = v;
    }

    void showFlashCard(int rounds) {
        Random random = new Random();
        boolean dict;
        for (int i = 0; i < rounds; i++) {
            dict = random.nextBoolean();
            //if show dictionary form
            if (dict) {
                int value = random.nextInt(this.verbVector.size());
                JOptionPane.showMessageDialog(null, "Dictionary Form: " + this.verbVector.elementAt(value).getDictionaryForm());
                JOptionPane.showMessageDialog(null, "Present Affirmative: " + this.verbVector.elementAt(value).presentAffirmative() + "\r\n" +
                        "Present Negative: " + this.verbVector.elementAt(value).presentNegative() + "\r\n" +
                        "Past Affirmative: " + this.verbVector.elementAt(value).pastAffirmative() + "\r\n" +
                        "Past Negative: " + this.verbVector.elementAt(value).pastNegative() + "\r\n" +
                        "Te form: " + this.verbVector.elementAt(value).teForm() + "\r\n" +
                        "Short Form Negative: " + this.verbVector.elementAt(value).shortFormNegative() + "\r\n" +
                        "Definition: " + this.verbVector.elementAt(value).getEnDefinition());

            }
            //if show definition
            else {
                int value = random.nextInt(this.verbVector.size());
                JOptionPane.showMessageDialog(null, "Definition: " + this.verbVector.elementAt(value).getEnDefinition());
                JOptionPane.showMessageDialog(null, "Present Affirmative: " + this.verbVector.elementAt(value).presentAffirmative() + "\r\n" +
                        "Present Negative: " + this.verbVector.elementAt(value).presentNegative() + "\r\n" +
                        "Past Affirmative: " + this.verbVector.elementAt(value).pastAffirmative() + "\r\n" +
                        "Past Negative: " + this.verbVector.elementAt(value).pastNegative() + "\r\n" +
                        "Te form: " + this.verbVector.elementAt(value).teForm() + "\r\n" +
                        "Short Form Negative: " + this.verbVector.elementAt(value).shortFormNegative() + "\r\n" +
                        "Dictionary Form: " + this.verbVector.elementAt(value).getDictionaryForm());
            }
        }//end for
    }// end flash cards
}
