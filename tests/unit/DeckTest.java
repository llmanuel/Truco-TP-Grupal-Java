package unit;

import junit.framework.Assert;
import model.Card;
import model.InvalidCardNumberException;
import model.InvalidSuiteException;
import org.junit.Test;
import model.Deck;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by alexdebian on 11/11/15.
 */
public class DeckTest {


    @Test
    public void canInstantiateDeck() throws InvalidSuiteException, InvalidCardNumberException {
        Deck deck = new Deck();
    }

    @Test
    public void deckReturnACardCorrecly() throws InvalidSuiteException, InvalidCardNumberException {
        Deck deck = new Deck();

        org.junit.Assert.assertThat(deck.getCard(), instanceOf(Card.class) );

    }

}