package unit;

import model.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by manuel on 13/11/15.
 */
public class SlotsTest {

    Slots slot;

    @Before
    public void setup(){
        HumanPlayer myPlayer = new HumanPlayer();
        slot = new Slots(myPlayer);
    }

    @Test
    public void slotsCanReceiveCards() throws InvalidSuiteException, InvalidCardNumberException {

        Card anyCard = new Card(1, "Espada", 14);
        slot.receiveFirstCard(anyCard);
    }
}
