package unit;

import model.Card;
import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;
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

    @Test (expected = RuntimeException.class)
    public void deckCantReturnMoreThan40Cards() throws InvalidSuiteException, InvalidCardNumberException{
        Deck deck = new Deck();

        for ( int i=1; i < 42; i++){
            deck.getCard();
        }

    }

}