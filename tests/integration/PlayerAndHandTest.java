package integration;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class PlayerAndHandTest {


    private HumanPlayer humanPlayer;
    private Croupier croupier;

    @Before
    public void setup()  {
        croupier = new Croupier();
        humanPlayer = new HumanPlayer( 1 );
    }

	@Test
	public void playerSavesCorrectHand() throws Exception {
        Hand hand =  croupier.giveHand();

        humanPlayer.setHand(hand);
        Assert.assertTrue(humanPlayer.getHand() == hand);
	}

    @Test
    public void playerReturnsEnvidoCorrectly()  {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "BASTO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand newHand = new Hand( cards );

        this.humanPlayer.setHand( newHand );

        Assert.assertTrue( this.humanPlayer.calculateEnvido() == 32 );


    }




}