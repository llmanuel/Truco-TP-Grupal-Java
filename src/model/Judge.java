package model;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Judge {
	
	LinkedList<Player> players = new LinkedList<Player>();
	int maximunValueOfEnvido = 0;
	int winnerEnvido;
	
	public Judge() {
		
	}
	
    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

	public void setPlayers(LinkedList<Player> players) {
			this.players = players;
	}

	public LinkedList<Player> getPlayers(){
		return this.players;
	}
    
    
}
