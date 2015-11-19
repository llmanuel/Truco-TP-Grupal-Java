package integration;

import model.Croupier;
import model.Hand;
import model.HumanPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerAndHandTest {


    private HumanPlayer humanPlayer;
    private Croupier croupier;

    @Before
    public void setup(){
        croupier = new Croupier();
        humanPlayer = new HumanPlayer( 1 );
    }

	@Test
	public void PlayerSavesCorrectHand() throws Exception {
        Hand hand =  croupier.giveHand();

        humanPlayer.setHand(hand);
        Assert.assertTrue(humanPlayer.getHand() == hand);
	}




}