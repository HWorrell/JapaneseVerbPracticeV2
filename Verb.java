public class Verb {

    static final String[][] endings = {{"あ", "い", "う", "え", "お"}, {"か", "き", "く", "け", "こ"}, {"さ", "し", "す", "せ", "そ"}, {"な", "に", "ぬ", "ね", "の"}, {"た", "ち", "つ", "て", "と"}
            , {"は", "ひ", "ふ", "へ", "ほ"}, {"ま", "み", "む", "め", "も"}, {"ら", "り", "る", "れ", "ろ"}, {"が", "ぎ", "ぐ", "げ", "ご"},
            {"ざ", "じ", "ず", "ぜ", "ぞ"}, {"ば", "び", "ぶ", "べ", "ぼ"}, {"ぱ", "ぴ", "ぷ", "ぺ", "ぽ"}, {"だ", "ぢ", "づ", "で", "ど"}};

    String dictionaryForm;
    boolean ruVerb;
    String enDefinition;

    Verb(String dict, boolean ru, String english){
        this.dictionaryForm = dict;
        this.ruVerb = ru;
        this.enDefinition = english;
    }

    public String getEnDefinition() {
        return enDefinition;
    }

    public boolean isRuVerb() {
        return ruVerb;
    }

    public String getDictionaryForm() {
        return dictionaryForm;
    }

    String pastNegative(){
        if (this.dictionaryForm.equals("くる")){
            return "きませんでした";
        }
        if (this.dictionaryForm.substring(this.dictionaryForm.length() - 2).equals("する")){
            return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "しませんでした";
        }

        if (!ruVerb) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            for (int i = 0; i < endings.length; i++) {
                for (int j = 0; j < endings[i].length; j++) {
                    if (endings[i][j].equals(this.dictionaryForm.substring(this.dictionaryForm.length() - 1))) {
                        builder.append(endings[i][1]);
                    }
                }
            }
            return builder.toString() + "ませんでした";
        }
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            return builder.toString() + "ませんでした";
        }
    }

    String pastAffirmative(){
        if (this.dictionaryForm.equals("くる")){
            return "きました";
        }
        if (this.dictionaryForm.substring(this.dictionaryForm.length() - 2).equals("する")){
            return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "しました";
        }
        if (!ruVerb) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            for (int i = 0; i < endings.length; i++) {
                for (int j = 0; j < endings[i].length; j++) {
                    if (endings[i][j].equals(this.dictionaryForm.substring(this.dictionaryForm.length() - 1))) {
                        builder.append(endings[i][1]);
                    }
                }
            }
            return builder.toString() + "ました";
        }
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            return builder.toString() + "ました";
        }
    }

    String presentNegative(){
        if (this.dictionaryForm.equals("くる")){
            return "きません";
        }
        if (this.dictionaryForm.substring(this.dictionaryForm.length() - 2).equals("する")){
            return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "しません";
        }
        StringBuilder builder = new StringBuilder();
        if (!ruVerb) {
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            for (int i = 0; i < endings.length; i++) {
                for (int j = 0; j < endings[i].length; j++) {
                    if (endings[i][j].equals(this.dictionaryForm.substring(this.dictionaryForm.length() - 1))) {
                        builder.append(endings[i][1]);
                    }
                }
            }
        }
        else {
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
        }
        return builder.toString() + "ません";
    }

    String presentAffirmative() {
        if (this.dictionaryForm.equals("くる")){
            return "きます";
        }
        if (this.dictionaryForm.substring(this.dictionaryForm.length() - 2).equals("する")){
            return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "します";
        }
        if (!ruVerb) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            for (int i = 0; i < endings.length; i++) {
                for (int j = 0; j < endings[i].length; j++) {
                    if (endings[i][j].equals(this.dictionaryForm.substring(this.dictionaryForm.length() - 1))) {
                        builder.append(endings[i][1]);
                    }
                }
            }
            return builder.toString() + "ます";
        }
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            return builder.toString() + "ます";
        }
    }

    String teForm(){
        if (this.ruVerb) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            return builder.toString() + "て";
        } else{

            if (this.dictionaryForm.substring(this.dictionaryForm.length() - 2).equals("する")){
                return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "して";
            }
            if (this.dictionaryForm.equals("くる")){
                return "きて";
            }
            if (this.dictionaryForm.equals("いく") || this.dictionaryForm.equals("行く")){
                return this.dictionaryForm.substring(0, 1) + "って";
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            switch (this.dictionaryForm.substring(this.dictionaryForm.length() - 1)){
                case "う":
                case "つ":
                case "る":
                    return builder.toString() + "って";
                case "む":
                case "ぶ":
                case "ぬ":
                    return builder.toString() + "んで";
                case "く":
                    return builder.toString() + "いて";
                case "ぐ":
                    return builder.toString() + "いで";
                case "す":
                    return builder.toString() + "して";
                default:
                    return "Error, check settings for " + this.dictionaryForm;
            }
        }
    }

    String shortFormAffirmative(){
        return this.dictionaryForm;
    }
    String shortFormNegative(){
        if (this.dictionaryForm.equals("ある")){
            return "ない";
        }
        if (this.dictionaryForm.equals("くる")){
            return "こない";
        }
        if (this.dictionaryForm.substring(this.dictionaryForm.length() - 2).equals("する")){
            return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "しない";
        }
        if (ruVerb){
            return this.dictionaryForm.substring(0, this.dictionaryForm.length() - 2) + "ない";
        }
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < this.dictionaryForm.length() - 1; i++) {
                builder.append(this.dictionaryForm.substring(i, i + 1));
            }
            if (this.dictionaryForm.substring(this.dictionaryForm.length() - 1).equals("う")) {
                builder.append("わない");
                return builder.toString();
            } else {
                for (int i = 0; i < endings.length; i++) {
                    for (int j = 0; j < endings[i].length; j++) {
                        if (endings[i][j].equals(this.dictionaryForm.substring(this.dictionaryForm.length() - 1))) {
                            builder.append(endings[i][0]);
                            //return builder.toString();
                        }
                    }
                }
                builder.append("ない");
                return builder.toString();
            }
        }
        //return "Issue with te form for " + this.dictionaryForm;
    }

}
