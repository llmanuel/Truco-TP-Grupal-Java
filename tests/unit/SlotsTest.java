package unit;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by manuel on 13/11/15.
 */
public class SlotsTest {

    Slots slot;
    HumanPlayer myPlayer;

    @Before
    public void setup(){
        myPlayer = new HumanPlayer(1);
        slot = new Slots(myPlayer);
    }

    @Test
    public void slotsCanReceiveCards() throws InvalidSuiteException, InvalidCardNumberException {

        Card anyCard = new Card(1,"ESPADA", 14);
        Card otherCard = new Card(1,"ORO", 8);
        Card Card = new Card(1,"BASTO", 13);
        Assert.assertTrue(slot.receiveFirstCard(anyCard));
        Assert.assertTrue(slot.receiveSecondCard(anyCard));
        Assert.assertTrue(slot.receiveThirdCard(anyCard));
    }

    @Test
    public void slotsKnowsItsOwner() throws InvalidSuiteException, InvalidCardNumberException {

        Assert.assertTrue(slot.isYourPlayer(myPlayer));
    }
//
//    @Test
//    public void slotsReturnsFlaseIfIsNotHIsPlayer() throws InvalidSuiteException, InvalidCardNumberException {
//
//        HumanPlayer otherPlayer = new HumanPlayer();
//        Assert.assertFalse(slot.isYourPlayer(otherPlayer));
//    }
}
