package playground;

public class SpinWords {

    public String spinWords(String sentence) {
        var words = sentence.split(" ");
        var newSentence = new String[words.length];
        for(int i = 0; i < words.length; i++) {
            var word = words[i];
            if(word.length() >= 5) {
                var letters = word.split("");
                var newLetters = new String[letters.length];

                for(int j = 0; j < letters.length; j++) {
                    newLetters[j] = letters[(letters.length - j) - 1];
                }

                var newWord = String.join("", newLetters);
                word = newWord;
            }
            newSentence[i] = word;
        }
        return String.join(" ", newSentence);
    }

}
