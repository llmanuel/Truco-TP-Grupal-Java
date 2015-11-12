package unit;

import model.InvalidCardNumberException;
import model.InvalidSuiteException;
import org.junit.Test;
import model.Deck;

/**
 * Created by alexdebian on 11/11/15.
 */
public class DeckTest {


    @Test
    public void canInstantiateDeck() throws InvalidSuiteException, InvalidCardNumberException {
        Deck deck = new Deck();
    }

}