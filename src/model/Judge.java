package model;

import java.util.LinkedList;

public class Judge {
	
	private LinkedList<Player> players = new LinkedList<Player>();
    private Table table;

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
	
	public void setWinnerOfTheRound(LinkedList<Slots> slots) throws NotCardThrownException { //corregir
		int maximumCardInRound = 0;
		Player roundWinner ;
		
		for (Slots actualSlot : slots) {
			if (actualSlot.getLastOne().getValue() > maximumCardInRound) {
				maximumCardInRound = actualSlot.getLastOne().getValue();
				roundWinner = actualSlot.getPlayer();
			}
		}

	}


}
