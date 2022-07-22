import javax.swing.*;
import java.util.Random;
import java.util.Vector;

public class SelfQuiz {
    Vector<Verb> verbVector;
    SelfQuiz(Vector<Verb> v){
        this.verbVector = v;
    }

    void selfQuiz(int rounds) {

        Random random = new Random();

        for (int i = 0; i < rounds; i++) {
            int term = random.nextInt(this.verbVector.size());
            if (random.nextBoolean()) {
                switch (random.nextInt(7)) {
                    //english definition -> form
                    case 0:
                    //dictionary
                        JOptionPane.showMessageDialog(null, "What is the dictionary form for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).getDictionaryForm());
                        break;
                    //pres affirm
                    case 1:
                        JOptionPane.showMessageDialog(null, "What is the present affirmative form for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).presentAffirmative());
                        break;
                    //pres neg
                    case 2:
                        JOptionPane.showMessageDialog(null, "What is the present negative form for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).presentNegative());
                        break;
                    //past affirm
                    case 3:
                        JOptionPane.showMessageDialog(null, "What is the past affirmative form for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).pastAffirmative());
                        break;
                    //past neg
                    case 4:
                        JOptionPane.showMessageDialog(null, "What is the past negative form for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).pastNegative());
                        break;
                    //te
                    case 5:
                        JOptionPane.showMessageDialog(null, "What is the te form for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).teForm());
                        break;
                    //short negative
                    case 6:
                        JOptionPane.showMessageDialog(null, "What is the short form negative for the verb " + this.verbVector.elementAt(term).getEnDefinition());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).shortFormNegative());
                        break;
                }
            } else {
                //dictionary form -> form
                switch (random.nextInt(7)) {
                    //definition
                    case 0:
                        JOptionPane.showMessageDialog(null, "What is the definition for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).getEnDefinition());
                        break;
                    //pres affirm
                    case 1:
                        JOptionPane.showMessageDialog(null, "What is the present affirmative form for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).presentAffirmative());
                        break;
                    //pres neg
                    case 2:
                        JOptionPane.showMessageDialog(null, "What is the present negative form for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).presentNegative());
                        break;
                    //past affirm
                    case 3:
                        JOptionPane.showMessageDialog(null, "What is the past affirmative form for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).pastAffirmative());
                        break;
                    //past neg
                    case 4:
                        JOptionPane.showMessageDialog(null, "What is the past negative form for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).pastNegative());
                        break;
                    //te
                    case 5:
                        JOptionPane.showMessageDialog(null, "What is the te form for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).teForm());
                        break;
                    //short negative
                    case 6:
                        JOptionPane.showMessageDialog(null, "What is the short form negative for the verb " + this.verbVector.elementAt(term).getDictionaryForm());
                        JOptionPane.showMessageDialog(null, this.verbVector.elementAt(term).shortFormNegative());
                        break;
                }
            }
        }
    }
}
