package model;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Scoreboard {

	private Integer numberOfPlayers;
	private LinkedList<Integer> scores = new LinkedList<Integer>();

	public Scoreboard(Integer numberofplayers) {
		
		this.numberOfPlayers = numberofplayers;
		
		for (int i = 0; i <= numberOfPlayers ; i++){
			
			scores.add(i, 0);
		}
	}

	public int getScoreOfPlayer(Integer playerId) {
		
		return scores.get(playerId); 
	}

	public void increseTheScoreOf(int playerID, int score) {
		
		int newScore = score + scores.get(playerID);
		scores.add(playerID, newScore);
		
	}

	public int getScoreOfPlayer(int playerID) {
		return scores.get(playerID);
	}







}
