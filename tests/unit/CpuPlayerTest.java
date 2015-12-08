import model.Card;
import model.CpuPlayer;
import model.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class CpuPlayerTest {

    private Card card1, card2, card3;
    private LinkedList<Card> hand1Cards;
    private Hand hand1;

    @Before
    public void setup() {
        card1 = new Card( 5, "BASTO", 2 );
        card2 = new Card( 7, "BASTO", 4 );
        card3 = new Card( 7, "ESPADA", 12 );

        hand1Cards = new LinkedList<Card>();
        hand1Cards.add( card1 );
        hand1Cards.add( card2 );
        hand1Cards.add( card3 );

        hand1 = new Hand( hand1Cards );

    }

    @Test
    public void canInstanciateACpuPlayer(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );
    }

    @Test
    public void canReceiveAHandCorrectly(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        cpuplayer.setHand( hand1 );

        Assert.assertTrue( cpuplayer.getHand() == hand1 );

    }

    @Test
    public void canCalculateEnvidoCorrectly(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        cpuplayer.setHand( hand1 );

        Assert.assertEquals( 32, cpuplayer.calculateEnvido(), 0.0001 );

    }

    @Test
    public void savesPlayerIdCorrectly(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        Assert.assertEquals( 1, cpuplayer.getIdNumber(), 0.0001 );
    }

//    @Test
//    public void canPlayACard() throws DonTHaveThatCardException, NotCardThrownException {
//        CpuPlayer cpuplayer = new CpuPlayer( 1 );
//
//        cpuplayer.setHand( hand1 );
//
//        Slot slot = new Slot( cpuplayer );
//
//        cpuplayer.setSlot( slot );
//
//        cpuplayer.playCard( card1 );
//
//        Assert.assertTrue( slot.getLastOne() == card1 );

//    }

    @Test
    public void canOrderMyCards(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        card1 = new Card( 5, "BASTO", 2 );
        card2 = new Card( 7, "BASTO", 4 );
        card3 = new Card( 7, "ESPADA", 12 );

        hand1Cards = new LinkedList<Card>();
        hand1Cards.add( card3 );
        hand1Cards.add( card2 );
        hand1Cards.add( card1 );

        hand1 = new Hand( hand1Cards );
        cpuplayer.setHand( hand1 );
        LinkedList<Card> cards = cpuplayer.orderMyHandLowToHigh();

        Assert.assertTrue(cards.get(0).getValue() <= cards.get(1).getValue());
        Assert.assertTrue(cards.get(1).getValue() <= cards.get(2).getValue());
        Assert.assertTrue(cards.get(0).getValue() == 2);
        Assert.assertTrue(cards.get(1).getValue() == 4);
        Assert.assertTrue(cards.get(2).getValue() == 12 );
    }
}
