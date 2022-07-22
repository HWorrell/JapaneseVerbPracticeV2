import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Vector;

public class RomajiParser {
    Vector<String> hiragana;
    Vector<String> romaji;
    Vector<String> multiples;
    Vector<String> katakana;
    Vector<String> katakanaRomaji;

    RomajiParser(File hiraganaIn, File katakanaIn){
        this.hiragana = new Vector<>();
        this.romaji = new Vector<>();
        this.multiples = new Vector<>();
        this.katakana = new Vector<>();
        this.katakanaRomaji = new Vector<>();

        try {
            //parse the file
            CSVParser parser = CSVParser.parse(hiraganaIn, Charset.defaultCharset(), CSVFormat.EXCEL);

            //romaji character == 0, hiragana == 1
            //compound hiragana have length > 1
            for (CSVRecord r: parser
                 ) {
                romaji.add(r.get(0));
                hiragana.add(r.get(1));
                if (r.get(1).length() > 1){
                    this.multiples.add(r.get(1));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //same logic for katakana as hiragana
        //TODO Combine these processes if possible
        try {
            CSVParser parser = CSVParser.parse(katakanaIn, Charset.defaultCharset(), CSVFormat.EXCEL);

            for (CSVRecord r: parser
            ) {
                katakanaRomaji.add(r.get(0));
                katakana.add(r.get(1));
                if (r.get(1).length() > 1){
                    this.multiples.add(r.get(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //character parser; only called from within this class
    private String parseCharacter(String in){

        for(int i = 0; i < this.hiragana.size(); i++){
            if (hiragana.elementAt(i).equals(in)){
                return romaji.elementAt(i);
            }
        }
        for (int i = 0; i < this.katakana.size(); i++){
            if (katakana.elementAt(i).equals(in)){
                return katakanaRomaji.elementAt(i);
            }
        }
        return in;
    }

    //term parser; called from outside class, utilizes internal methods
    public String parseTerm(String in){
        //initial state: empty stringbuilder, non-double sound flag
        StringBuilder builder = new StringBuilder();
        boolean doubleSound = false;
        //loop the string character by character
        for(int i = 0; i < in.length(); i++){
            //if term has more than 2 characters remaining
            if (in.length() > i + 1){
                //check for possiblity of multiple character combination
                //i - i + 2 (inclusive exclusive)
                if (this.multiples.contains(in.substring(i, i + 2))){
                    //if multi character term is present, send in and parse them together
                    String toAppend = parseCharacter(in.substring(i, i + 2));
                    //if previous character was small tsu, double up on first character and reset flag
                    if (doubleSound){
                        toAppend = toAppend.substring(i, i + 1) + toAppend;
                        doubleSound = false;
                    }
                    //add to builder
                    builder.append(toAppend + " ");
                    //since this was a multi-character case, manually increment the loop variable to skip forward
                    i++;
                }
                //if not a multi character, then check for small tsu
                else if(in.substring(i, i + 1).equals("っ")){
                    //if small tsu, set double sound flag, move on
                    doubleSound = true;
                    continue;
                }
                //if not a multi character and not a small tsu, parse the term
                else{
                    String toAppend = parseCharacter(in.substring(i, i + 1));
                    //if previous character was small tsu, double up on first character and reset flag
                    if (doubleSound){
                        toAppend = toAppend.substring(0, 1) + toAppend;
                        doubleSound = false;
                    }
                    builder.append(toAppend + " ");
                }

            } else{
                String toAppend = parseCharacter(in.substring(i, i + 1));
                if (doubleSound){
                    toAppend = toAppend.substring(0, 1) + toAppend;
                    doubleSound = false;
                }
                builder.append(toAppend + " ");
            }
        }


        return builder.toString();
    }

}
