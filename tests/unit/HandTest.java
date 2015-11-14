package unit;

import junit.framework.TestCase;
import model.Card;
import model.Hand;
import model.InvalidCardNumberException;
import model.InvalidSuiteException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandTest extends TestCase {
    @Test
    public void canInstatiateHand() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        List<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand hand = new Hand(cards);
    }
}