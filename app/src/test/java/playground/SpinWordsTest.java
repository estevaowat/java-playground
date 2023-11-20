package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import playground.exercises.SpinWords;

class SpinWordsTest {

    @Test
    @DisplayName("should spin words")
    void spinWords() {
        SpinWords spinner = new SpinWords();
        Assertions.assertEquals("emocleW", spinner.spinWords("Welcome"));
        Assertions.assertEquals("Hey wollef sroirraw", spinner.spinWords("Hey fellow warriors"));
    }
}