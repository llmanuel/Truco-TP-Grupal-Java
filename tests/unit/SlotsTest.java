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
    Card first;
    Card second;
    Card thirdCard;

    @Before
    public void setup() throws InvalidSuiteException, InvalidCardNumberException {
        myPlayer = new HumanPlayer(1);
        slot = new Slots(myPlayer);
        first = new Card(1,"ESPADA", 14);
        second = new Card(1,"ORO", 8);
        thirdCard = new Card(1,"BASTO", 13);
    }

    @Test
    public void slotsCanReceiveCards()  {

        Assert.assertTrue(slot.receiveFirstCard(first));
        Assert.assertTrue(slot.receiveSecondCard(second));
        Assert.assertTrue(slot.receiveThirdCard(thirdCard));
    }

    @Test
    public void slotsKnowsItsOwner() throws InvalidSuiteException, InvalidCardNumberException {

        Assert.assertTrue(slot.isYourPlayer(myPlayer));
    }

    @Test
    public void slotsReturnsFalseIfIsNotHIsPlayer() throws InvalidSuiteException, InvalidCardNumberException {

        HumanPlayer otherPlayer = new HumanPlayer(2);
        Assert.assertFalse(slot.isYourPlayer(otherPlayer));
    }

    @Test
    public void slotsReturnsTheFirstCard() throws NotCardThrownException{

        Assert.assertEquals(first.getValue(),slot.getFirstOne().getNumber());
    }

    @Test
    public void slotsReturnsTheSecondCard() throws NotCardThrownException{

        Assert.assertEquals(first.getValue(),slot.getSecondOne().getNumber());
    }

    @Test
    public void slotsReturnsTheThirdCard() throws NotCardThrownException{

        Assert.assertEquals(first.getValue(),slot.getThirdOne().getNumber());
    }

    @Test
    public void slotsThrowsAwayTheCardsWhenItIsTellToDoSo(){

       slot.throwCards();
    }
}
