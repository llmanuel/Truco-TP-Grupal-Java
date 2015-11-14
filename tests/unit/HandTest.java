package unit;

import junit.framework.TestCase;
import model.Card;
import model.Hand;
import model.InvalidCardNumberException;
import model.InvalidSuiteException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandTest {
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

    @Test
    public void testsFlor() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);
        Card card4 = new Card(3, "ORO", 4);

        List<Card> cards = new ArrayList<Card>();
        List<Card> cards2 = new ArrayList<Card>();

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card4);

        Hand hand = new Hand(cards);
        Hand hand2 = new Hand(cards2);

        Assert.assertFalse(hand.isFlor());
        Assert.assertTrue(hand2.isFlor());
    }
}