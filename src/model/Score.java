package model;

public class Score {
    private final Team team;
    private int score;

    public Score(Team team) {
        this.team = team;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public Team getTeam() {
        return this.team;
    }

    public void increaseScoreBy(int scoreIncrease) {
        this.score += scoreIncrease;
    }
}
