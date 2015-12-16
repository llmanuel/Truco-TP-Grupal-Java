package model;

import model.Exceptions.FirstTeamWonException;
import model.Exceptions.NobodyWonYetException;
import model.Exceptions.SecondTeamWonException;
import model.Exceptions.TeamDoesntExistException;
import model.TableStates.Games;

import java.util.LinkedList;

public class Scoreboard {

    private final LinkedList<Score> scores;
    private final Table table;


    public Scoreboard(LinkedList<Team> teams, Table table) {
        this.scores = new LinkedList<>();

        for(Team actualTeam : teams){
            this.scores.add(new Score(actualTeam));
        }

        this.table = table;
	}

	public int getPointsOf(Player whomWantedScoreIs) throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {
        try {
            this.didAnyoneWinAlready();
        } catch (NobodyWonYetException ignored) {

        }
        return this.getScore(whomWantedScoreIs).getScore();
	}

    private Score getScore(Player whomWantedScoreIs) throws TeamDoesntExistException {
        for (Score scoreActual : this.scores)
            if (scoreActual.getTeam().isMember( whomWantedScoreIs ) ) {
                return scoreActual;
            }
        throw new TeamDoesntExistException();
    }

    public void increaseTheScoreOf(Player whomScoreGonnaBeIncreased, Games actualGame) throws TeamDoesntExistException {
        if(actualGame.getPoints() == 0){
            this.getScore( whomScoreGonnaBeIncreased ).increaseScoreBy(this.getScoreOfFaltaEnvidoFor(whomScoreGonnaBeIncreased));
        } else  this.getScore( whomScoreGonnaBeIncreased ).increaseScoreBy(actualGame.getPoints());
	}

    private int getScoreOfFaltaEnvidoFor(Player whomScoreGonnaBeIncreased) throws TeamDoesntExistException {
        Team teamWhoLost = this.table.getTheEnemyTeamOf(whomScoreGonnaBeIncreased);
        int pointsToAsign = 0;
        try {
            if(this.getPointsOf(teamWhoLost) < 15 ){
                pointsToAsign = 15 - this.getPointsOf(teamWhoLost);
            } else pointsToAsign = 30 - (this.getPointsOf(teamWhoLost) - 15);
        } catch (SecondTeamWonException | FirstTeamWonException ignored) {}
        return pointsToAsign;
    }

    private void didAnyoneWinAlready() throws FirstTeamWonException, SecondTeamWonException, NobodyWonYetException {
        Team winnerTeam = null;
        for(Score actualScore : this.scores){
            if (actualScore.getScore() >= 30){
                winnerTeam = actualScore.getTeam();
            }
        }

        if (winnerTeam == this.scores.getFirst().getTeam()){
            throw new FirstTeamWonException();
        } else if (winnerTeam == null) {
            throw new NobodyWonYetException();
        } else {
            throw new SecondTeamWonException();
        }

    }

    public LinkedList<Team> getPlayers() {
        LinkedList<Team> players = new LinkedList<>();
        for (Score actualScore : this.scores){
            players.add( actualScore.getTeam());
        }
        return players;
    }

    public void playerGaveUpThisGame(Team team, Games game) {

    	for (Score actualScore :scores){

    		if (actualScore.getTeam() != team){

    			actualScore.increaseScoreBy(game.giveUpPoints());
    		}
    	}
    }

	public int getPointsOf(Team whomWantedScoreIs) throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {
        try {
            this.didAnyoneWinAlready();
        } catch (NobodyWonYetException ignored) {

        }

		return  this.getScore(whomWantedScoreIs).getScore();

	}

	private Score getScore(Team whoWantedScoreIs) throws TeamDoesntExistException {
		
		for (Score actualScore :scores) {
			
			if (actualScore.getTeam() == whoWantedScoreIs){
				
				return actualScore;
			}
		}
		throw new TeamDoesntExistException();
	}

	public void increaseTheScoreOf(Team team, Games game)throws TeamDoesntExistException {
		
		boolean increase = false;
		for (Score actualScore :scores){
			
			if (actualScore.getTeam() == team){
				
				actualScore.increaseScoreBy(game.getPoints());
				increase = true;
			}
		}
		if (!increase){
		
			throw new TeamDoesntExistException();
		}
		
	}

    public Team getFirstTeam(){
       return this.scores.getFirst().getTeam();
    }
}
