package model;


public class Score {
    private final CanHaveScore canHaveScore;
    private int score;

    public Score(CanHaveScore canHaveScore) {
        this.canHaveScore = canHaveScore;
        this.score = 0;
    }
}
