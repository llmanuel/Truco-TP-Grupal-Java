package integration;

import model.Croupier;
import model.Hand;
import model.HumanPlayer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alexdebian on 11/10/15.
 */
public class PlayerAndHandTest {

	@Test
	public void PlayerSavesCorrectHand() throws Exception {
        Croupier croupier = new Croupier();
        HumanPlayer humanPlayer = new HumanPlayer( 1 );

        Hand hand =  croupier.giveHand();

        humanPlayer.receiveAHand(hand);
        Assert.assertTrue(humanPlayer.getHand() == hand);
	}
	
}