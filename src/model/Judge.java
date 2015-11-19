package model;

import java.util.LinkedList;

public class Judge {
	
	private LinkedList<Player> players = new LinkedList<Player>();
    private Table table;


	int florWinner;

	public Judge() {
		
	}
	
    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

	public void setPlayers(LinkedList<Player> players) {
		this.players = players;
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
