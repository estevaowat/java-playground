package playground.exercises.warrior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WarriorTest {

    @Test
    @DisplayName("Get warrior rank")
    void getWarriorRank() {
        Warrior samurai = new Warrior();
        Assertions.assertEquals("Pushover", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Novice", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Fighter", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Warrior", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Veteran", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Sage", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Elite", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Conqueror", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Champion", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Master", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Greatest", samurai.rank(samurai.level()).getValue());

        samurai.addExperience(1000);
        Assertions.assertEquals("Greatest", samurai.rank(samurai.level()).getValue());


    }
}
