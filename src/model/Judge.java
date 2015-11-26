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
	
	public Player setWinnerOfTheRound(LinkedList<Slot> slots) throws NotCardThrownException, TeamDoesntExistException {
		int maximumCardInRound = 0;
		Player roundWinner = null;
		
		for (Slot actualSlot : slots) {
			if (actualSlot.getLastOne().getValue() > maximumCardInRound) {
				maximumCardInRound = actualSlot.getLastOne().getValue();
				roundWinner =  actualSlot.getPlayer();
			}
		}
        return roundWinner;
	}

    public void setWinnerOfGame(LinkedList<Slot> slots, Games actualGame){
        int team1GamesWon = 0;
        int team2GamesWon = 0;
        int maximumCardInRound = 0;
        Player roundWinner = null;

        try{
            for (Slot actualSlot : slots) {
                if (actualSlot.getLastOne().getValue() > maximumCardInRound) {
                    maximumCardInRound = actualSlot.getLastOne().getValue();
                    roundWinner =  actualSlot.getPlayer();
                }
            }
        } catch (NotCardThrownException e) {

        }

    }


}
