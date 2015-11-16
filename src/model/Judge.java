package model;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Judge {
	
	LinkedList<Player> players = new LinkedList<Player>();
	int maximunValueOfEnvido = 0;
	int envidoWinner = 0;
	int florWinner;
	Table table;
	
	public Judge() {
		
	}
	
    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

	public void setPlayers(LinkedList<Player> players) {
		
		this.players = players;
		
	}
    
	public void setWinnerOfEnvido() {
		
		for (Player actualPlayer :players) {
			
			if (actualPlayer.calculateEnvido() > this.maximunValueOfEnvido) {
				
				this.envidoWinner = actualPlayer.getIdNumber();
			}
		}
	}
	
	public int setWinnerOfTheRound(LinkedList<Slots> slots) { //corregir
		
		int maximunCardInRound = 0;
		int roundWinner = 0;
		
		for (Slots slot :slots) {
			
			if (slot.getCardValue() > maximunCardInRound) {
				
				roundWinner = slot.getPlayerId();
			}
		}
		return roundWinner;
	}
    
}
