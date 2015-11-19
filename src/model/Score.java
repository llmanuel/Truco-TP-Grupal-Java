package model;

import model.CanHaveScore;

public class Score {
    private CanHaveScore canHaveScore;
    private int score;

    public Score(CanHaveScore canHaveScore) {
        this.canHaveScore = canHaveScore;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public CanHaveScore getMember() {
        return this.canHaveScore;
    }

    public void increaseScoreBy(int scoreIncrease) {
        this.score =+ scoreIncrease;
    }
}
