package integration;

import java.util.LinkedList;

import model.Croupier;
import org.junit.Assert;
import org.junit.Test;

import model.Card;
import model.Hand;
import model.HumanPlayer;

/**
 * Created by alexdebian on 11/10/15.
 */
public class PlayerAndHandTest {

	@Test
	public void APlayerCanReceiveAHand() throws Exception {

        Croupier croupier = new Croupier();
        HumanPlayer humanPlayer = new HumanPlayer( 1 );

        
        humanPlayer.receiveAHand(croupier.giveHand());

        
        Assert.assertTrue(humanPlayer.getHand() != null);
    
	}
	
}