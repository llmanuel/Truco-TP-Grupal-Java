package model;

import model.Exceptions.FirstTeamWonException;
import model.Exceptions.NobodyWonYetException;
import model.Exceptions.SecondTeamWonException;
import model.Exceptions.TeamDoesntExistException;
import model.TableStates.Games;

import java.util.LinkedList;

public class Scoreboard {

    private LinkedList<Score> scores;
    private Table table;


    public Scoreboard(LinkedList<Team> teams, Table table) {
		this.scores = new LinkedList<Score>();

        for(Team actualTeam : teams){
            this.scores.add(new Score(actualTeam));
        }

        this.table = table;
	}

	public int getPointsOf(Player whomWantedScoreIs) throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {
        try {
            this.didAnyoneWinAlready();
        } catch (NobodyWonYetException e) {

        }
        return this.getScore(whomWantedScoreIs).getScore();
	}

    private Score getScore(Player whomWantedScoreIs) throws TeamDoesntExistException {
        for (Score scoreActual : this.scores)
            if (scoreActual.getMember().isMember( whomWantedScoreIs ) ) {
                return scoreActual;
            }
        throw new TeamDoesntExistException();
    }

    public void increaseTheScoreOf(Player whomScoreGonnaBeIncreased, Games actualGame) throws TeamDoesntExistException {
        this.getScore( whomScoreGonnaBeIncreased ).increaseScoreBy(actualGame.getPoints());
	}

    private void didAnyoneWinAlready() throws FirstTeamWonException, SecondTeamWonException, NobodyWonYetException {
        Team winnerTeam = null;
        for(Score actualScore : this.scores){
            if (actualScore.getScore() >= 30){
                winnerTeam = actualScore.getMember();
            }
        }

        if (winnerTeam == this.scores.getFirst().getMember()){
            throw new FirstTeamWonException();
        } else if (winnerTeam == null) {
            throw new NobodyWonYetException();
        } else {
            throw new SecondTeamWonException();
        }

    }

    public LinkedList<Team> getPlayers() {
        LinkedList<Team> players = new LinkedList<Team>(  );
        for (Score actualScore : this.scores){
            players.add( actualScore.getMember());
        }
        return players;
    }

    public void playerGaveUpThisGame(Team team, Games game) {
    	
    	for (Score actualScore :scores){
    		
    		if (actualScore.getMember() != team){
    			
    			actualScore.increaseScoreBy(game.giveUp());
    		}
    	}
    }

	public double getPointsOf(Team whomWantedScoreIs) throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {
        try {
            this.didAnyoneWinAlready();
        } catch (NobodyWonYetException e) {

        }

		return  this.getScore(whomWantedScoreIs).getScore();

	}

	public Score getScore(Team whoWantedScoreIs) throws TeamDoesntExistException {
		
		for (Score actualScore :scores) {
			
			if (actualScore.getMember() == whoWantedScoreIs){
				
				return actualScore;
			}
		}
		throw new TeamDoesntExistException();
	}

	public void increaseTheScoreOf(Team team, Games game)throws TeamDoesntExistException {
		
		boolean increase = false;
		for (Score actualScore :scores){
			
			if (actualScore.getMember() == team){
				
				actualScore.increaseScoreBy(game.getPoints());
				increase = true;
			}
		}
		if (!increase){
		
			throw new TeamDoesntExistException();
		}
		
	}

}
