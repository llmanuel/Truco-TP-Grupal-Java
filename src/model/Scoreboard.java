package model;

import model.Exceptions.CanHaveScoreDoesntExistException;
import model.TableStates.Games;

import java.util.LinkedList;

public class Scoreboard {

    private LinkedList<Score> scores;
    private Table table;


    public Scoreboard(LinkedList<Team> teams, Table table) {
		this.scores = new LinkedList<Score>();

        for(Team canHaveScoreActual : teams){
            this.scores.add(new Score(canHaveScoreActual));
        }

        this.table = table;
	}

	public int getPointsOf(Team whomWantedScoreIs) throws CanHaveScoreDoesntExistException {
        return  this.getScore(whomWantedScoreIs).getScore();
	}

    private Score getScore(Team whomWantedScoreIs) throws CanHaveScoreDoesntExistException {
        for (Score scoreActual : this.scores)
            if (scoreActual.getMember() == whomWantedScoreIs) {
                return scoreActual;
            }
        throw new CanHaveScoreDoesntExistException();
    }

    public void increaseTheScoreOf(Team whomScoreGonnaBeIncreased, Games actualGame) throws CanHaveScoreDoesntExistException {
        this.getScore( whomScoreGonnaBeIncreased ).increaseScoreBy(actualGame.getPoints());
        this.didAnyoneWinAlready();
	}

    private void didAnyoneWinAlready() {
        for(Score actualScore : this.scores){
            if (actualScore.getScore() >= 30){
                this.table.declareWinner(actualScore.getMember());
            }
        }
    }

    public LinkedList<Team> getPlayers() {
        LinkedList<Team> players = new LinkedList<Team>(  );
        for (Score actualScore : this.scores){
            players.add( actualScore.getMember() );
        }
        return players;
    }

    public void playerGaveUpThisGame(Team player, Games game) {


    }
}
