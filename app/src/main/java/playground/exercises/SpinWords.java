package playground.exercises;

public class SpinWords {

    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        String[] newSentence = new String[words.length];

        for(int i = 0; i < words.length; i++) {
            String word = words[i];

            if(word.length() >= 5) {
                String[] letters = word.split("");
                String[] newLetters = new String[letters.length];

                for(int j = 0; j < letters.length; j++) {
                    newLetters[j] = letters[(letters.length - j) - 1];
                }

                word = String.join("", newLetters);
            }

            newSentence[i] = word;
        }

        return String.join(" ", newSentence);
    }
}
