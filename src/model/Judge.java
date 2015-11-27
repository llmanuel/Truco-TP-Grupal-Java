package model;

import model.Exceptions.TeamDoesntExistException;
import model.Exceptions.NotCardThrownException;
import model.TableStates.Games;

import java.util.LinkedList;

public class Judge {
	
	private LinkedList<Player> players = new LinkedList<Player>();
    private Scoreboard scoreboard;
    private long[] roundWinsPerTeam;

    public Judge(Scoreboard scoreboard){
        this.scoreboard = scoreboard;
        roundWinsPerTeam = new long[]{0, 0};
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

	public Player setWinnerOfEnvido() {
		int maximunValueOfEnvido = 0;
        Player envidoWinner = null;

		for (Player actualPlayer : this.players) {
			if (actualPlayer.calculateEnvido() > maximunValueOfEnvido ) {
                envidoWinner = actualPlayer;
                maximunValueOfEnvido = actualPlayer.calculateEnvido();
            }
		}
        return envidoWinner;
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
        this.roundWinsPerTeam[roundWinner.getIdNumber()-1]++;
        return roundWinner;
	}

    public void setWinnerOfGame(LinkedList<Slot> slots, Games actualGame) throws NotCardThrownException, TeamDoesntExistException {
        if (roundWinsPerTeam[0] > roundWinsPerTeam[1]) {
            scoreboard.increaseTheScoreOf(slots.get(0).getPlayer() , actualGame);
        }
        else
        {
            scoreboard.increaseTheScoreOf(slots.get(1).getPlayer() , actualGame);
        }

    }




}
