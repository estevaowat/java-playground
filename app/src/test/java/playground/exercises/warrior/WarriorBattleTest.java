package playground.exercises.warrior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WarriorBattleTest {

    @Test
    @DisplayName("If an enemy level does not fall in the range of 1 to 100, the battle cannot happen and should return Invalid level.")
    void battleInvalidLevel() {
        Warrior samurai = new Warrior();
        Assertions.assertEquals("Invalid level", samurai.battle(-1));
        Assertions.assertEquals("Invalid level", samurai.battle(-1));
    }

    @Test
    @DisplayName("Completing a battle against an enemy with the same level as your warrior will be worth 10 experience points.")
    void battleSameLevel() {
        Warrior samurai = new Warrior();
        samurai.battle(1);
        Assertions.assertEquals(110, samurai.experience());
    }

    @Test
    @DisplayName("Completing a battle against an enemy who is one level lower than your warrior will be worth 5 experience points.")
    void battleOneLevelLower() {
        Warrior samurai = new Warrior();
        samurai.addExperience(200);
        samurai.battle(1);
        Assertions.assertEquals(300, samurai.experience());
    }


    @Test
    @DisplayName("Completing a battle against an enemy who is two levels lower or more than your warrior will give 0 experience points.")
    void battleTwoLevelLower() {
        Warrior samurai = new Warrior();
        samurai.addExperience(400);
        samurai.battle(1);
        Assertions.assertEquals(500, samurai.experience());
    }


    @Test
    @DisplayName("Completing a battle against an enemy who is one level higher" +
            "or more than your warrior will accelarate your experience gaining. " +
            "The formula is 20 * diff * diff where diff equals the difference in " +
            "levels between the enemy and your warrior.")
    void battleWithEnemyWithOneHigherLevel() {
        Warrior samurai = new Warrior();
        samurai.battle(2);
        Assertions.assertEquals(120, samurai.experience());
    }

    @Test
    @DisplayName("Completing a battle against an enemy who is one level higher" +
            "or more than your warrior will accelarate your experience gaining. " +
            "The formula is 20 * diff * diff where diff equals the difference in " +
            "levels between the enemy and your warrior.")
    void battleWithEnemyWithTwoHigherLevel() {
        Warrior samurai = new Warrior();
        samurai.battle(3);
        Assertions.assertEquals(180, samurai.experience());
    }

    @Test
    @DisplayName("if your warrior is at least one rank lower than your enemy, " +
            " and at least 5 levels lower, your warrior cannot fight against an enemy" +
            " that strong and must instead return You've been defeated.")
    void battleWithEnemyWithHigherAndAtLeast5LevelsLower() {
        Warrior samurai = new Warrior();
        String result = samurai.battle(12);
        Assertions.assertEquals("You've been defeated", result);
    }


    @Test
    @DisplayName("Return Easy fight  if your warrior is 2 or more levels higher than your enemy's level.")
    void easyFight() {
        Warrior samurai = new Warrior();
        samurai.addExperience(200);
        String result = samurai.battle(1);
        Assertions.assertEquals("Easy fight", result);
    }

    @Test
    @DisplayName("Return A good fight if your warrior is either 1 level higher or equal to your enemy's level.")
    void goodFight() {
        Warrior samurai = new Warrior();
        Assertions.assertEquals("A good fight", samurai.battle(1));

        samurai.addExperience(100);
        Assertions.assertEquals("A good fight", samurai.battle(1));
    }

    @Test
    @DisplayName("Return An intense fight if your warrior's level is lower than the enemy's level.")
    void intenseFight() {
        Warrior samurai = new Warrior();
        String result = samurai.battle(4);
        Assertions.assertEquals("An intense fight", result);
    }
}
