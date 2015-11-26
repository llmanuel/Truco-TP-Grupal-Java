package model;

import model.Exceptions.TeamDoesntExistException;
import model.Exceptions.NotCardThrownException;
import model.TableStates.Games;

import java.util.LinkedList;

public class Judge {
	
	private LinkedList<Player> players = new LinkedList<Player>();
    private Scoreboard scoreboard;

    public Judge(Scoreboard scoreboard){
        this.scoreboard = scoreboard;
    }


    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public LinkedList<Player> getPlayers() {
        return this.players;
    }

    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

	public void setWinnerOfEnvido() {
		int maximunValueOfEnvido = 0;
        Player envidoWinner ;

		for (Player actualPlayer : this.players) {
			if (actualPlayer.calculateEnvido() > maximunValueOfEnvido ) {
                envidoWinner = actualPlayer;
                maximunValueOfEnvido = actualPlayer.calculateEnvido();
            }
		}
	}
	
	public Player setWinnerOfTheRound(LinkedList<Slot> slots, Games actualGame) throws NotCardThrownException, TeamDoesntExistException { //corregir
		int maximumCardInRound = 0;
		Team roundWinner = null;
        Player playerWhoWon = null;
		
		for (Slot actualSlot : slots) {
			if (actualSlot.getLastOne().getValue() > maximumCardInRound) {
				maximumCardInRound = actualSlot.getLastOne().getValue();
				roundWinner = (Team) actualSlot.getPlayer();
                playerWhoWon = actualSlot.getPlayer();
			}
		}
        this.scoreboard.increaseTheScoreOf( roundWinner, actualGame );
        return playerWhoWon;
	}


}
