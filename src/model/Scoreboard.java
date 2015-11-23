package model;

import model.Exceptions.CanHaveScoreDoesntExistException;
import model.Exceptions.PlayerDoesNotExistsException;

import java.util.LinkedList;

public class Scoreboard {

    private LinkedList<Score> scores;
    private Table table;


    public Scoreboard(LinkedList<CanHaveScore> players, Table table) {
		this.scores = new LinkedList<Score>();

        for(CanHaveScore canHaveScoreActual : players){
            this.scores.add(new Score(canHaveScoreActual));
        }

        this.table = table;
	}

	public int getPointsOf(CanHaveScore whomWantedScoreIs) throws CanHaveScoreDoesntExistException {
        return  this.getScore(whomWantedScoreIs).getScore();
	}

    private Score getScore(CanHaveScore whomWantedScoreIs) throws CanHaveScoreDoesntExistException {
        for (Score scoreActual : this.scores)
            if (scoreActual.getMember() == whomWantedScoreIs) {
                return scoreActual;
            }
        throw new CanHaveScoreDoesntExistException();
    }

    public void increaseTheScoreOf(CanHaveScore whomScoreGonnaBeIncreased, int scoreIncrease) throws CanHaveScoreDoesntExistException {
        this.getScore( whomScoreGonnaBeIncreased ).increaseScoreBy(scoreIncrease);
        this.didAnyoneWinAlready();
	}

    private void didAnyoneWinAlready() {
        for(Score actualScore : this.scores){
            if (actualScore.getScore() >= 30){
                this.table.declareWinner(actualScore.getMember());
            }
        }
    }

}
