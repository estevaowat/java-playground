package playground.exercises.warrior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WarriorTrainingTest {

    @Test
    void successfulTraining() {
        Warrior boxer = new Warrior();
        String description = "Catch leafs under tree";
        Integer experience = 30;
        String result = boxer.training(description, experience, 1);

        Assertions.assertEquals(130, boxer.experience());
        Assertions.assertEquals(description, result);
        Assertions.assertEquals(boxer.achievements().size(), 1);
        Assertions.assertEquals(boxer.achievements().get(0), description);
    }

    @Test
    @DisplayName("warrior's level does not meet the minimum level requirement")
    void warriorsLevelDoesNotMeetMinimumLevelRequirement() {
        Warrior boxer = new Warrior();
        String result = boxer.training("Defeat Takamura-san", 100, 2);
        Assertions.assertEquals("Not strong enough", result);
    }
}
