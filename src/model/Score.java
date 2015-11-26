package model;

public class Score {
    private Team team;
    private int score;

    public Score(Team canHaveScore) {
        this.team = canHaveScore;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public Team getMember() {
        return this.team;
    }

    public void increaseScoreBy(int scoreIncrease) {
        this.score =+ scoreIncrease;
    }
}
