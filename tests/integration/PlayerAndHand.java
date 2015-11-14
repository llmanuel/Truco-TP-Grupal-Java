package integration;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.Card;
import model.Hand;
import model.HumanPlayer;

/**
 * Created by alexdebian on 11/10/15.
 */
public class PlayerAndHand {

	@Test
	public void APlayerCanReceiveAHand() throws Exception {
		
	    Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand hand = new Hand(cards);
        
        HumanPlayer humanPlayer = new HumanPlayer(1);
        
        humanPlayer.receiveAHand(hand);
        
        Assert.assertTrue(humanPlayer.getHand() != null);
    
	}
	
}