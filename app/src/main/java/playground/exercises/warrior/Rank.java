package playground.exercises.warrior;

public enum Rank {
    Pushover(1),
    Novice(2),
    Fighter(3),
    Warrior(4),
    Veteran(5),
    Sage(6),
    Elite(7),
    Conqueror(8),
    Champion(9),
    Master(10),
    Greatest(11);


    private final int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    public int getRankNumber() {
        return rank;
    }

}
