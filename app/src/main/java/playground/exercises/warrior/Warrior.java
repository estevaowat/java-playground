package playground.exercises.warrior;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Warrior {

    private static final int maxLevel = 100;
    private final List<String> achievements = new ArrayList<>();
    private final int experiencePerLevel = 100;
    private int experience = 100;

    private static Map<Integer, String> createRankOrder() {
        Map<Integer, String> rankOrder = new LinkedHashMap<>();
        rankOrder.put(maxLevel, Rank.Greatest.name());
        rankOrder.put(90, Rank.Master.name());
        rankOrder.put(80, Rank.Champion.name());
        rankOrder.put(70, Rank.Conqueror.name());
        rankOrder.put(60, Rank.Elite.name());
        rankOrder.put(50, Rank.Sage.name());
        rankOrder.put(40, Rank.Veteran.name());
        rankOrder.put(30, Rank.Warrior.name());
        rankOrder.put(20, Rank.Fighter.name());
        rankOrder.put(10, Rank.Novice.name());
        rankOrder.put(1, Rank.Pushover.name());
        return rankOrder;
    }

    public List<String> achievements() {
        return achievements;
    }

    public int experience() {
        return experience;
    }

    public int level() {
        return Math.max(experience / experiencePerLevel, 1);
    }

    public void addExperience(int newExperience) {
        experience = experience + newExperience;

        int maxExperience = maxLevel * experiencePerLevel;

        if(experience >= maxExperience) {
            experience = maxExperience;
        }
    }

    public Map.Entry<Integer, String> rank(Integer level) {
        Map<Integer, String> rankOrder = createRankOrder();

        for(Map.Entry<Integer, String> rank : rankOrder.entrySet()) {
            int levelMinimalRank = rank.getKey();

            if(level >= levelMinimalRank) {
                return rank;
            }
        }

        return null;

    }

    public String rank() {
        return rank(level()).getValue();
    }

    public String battle(int enemyLevel) {

        boolean invalidLevel = enemyLevel < 1 || enemyLevel > maxLevel;

        if(invalidLevel) {
            return "Invalid level";
        }

        int diffLevel = enemyLevel - level();

        if(diffLevel < -1) {
            return "Easy fight";
        }

        boolean goodFight = diffLevel == 0 || diffLevel == -1;

        if(goodFight) {
            if(diffLevel == 0) {
                addExperience(10);
            } else {
                addExperience(5);
            }
            return "A good fight";
        }

        int enemyRank = rank(enemyLevel).getKey();
        int warriorRank = rank(level()).getKey();

        if(diffLevel >= 5 && enemyRank > warriorRank) {
            return "You've been defeated";
        }

        addExperience(20 * diffLevel * diffLevel);

        return "An intense fight";
    }

    public String training(String description, Integer experience, int minimalLevel) {
        if(level() < minimalLevel) {
            return "Not strong enough";
        }

        addExperience(experience);
        achievements.add(description);

        return description;
    }
}
