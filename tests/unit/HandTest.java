package unit;

import model.Card;
import model.Hand;
import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;
import org.junit.Assert;
import org.junit.Test;


import java.util.LinkedList;

public class HandTest {
    @Test()
    public void canInstatiateHand() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
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

        LinkedList<Card> cards = new LinkedList<Card>();
        LinkedList<Card> cards2 = new LinkedList<Card>();

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

    @Test
    public void testEnvido() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand hand = new Hand(cards);

        Assert.assertEquals(32, hand.calculateEnvido());
    }

    @Test
    public void testAllSuitsAreDifferent() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        Hand hand = new Hand(cards);

        LinkedList<Card> cards2 = new LinkedList<Card>();
        cards2.add(card1);
        cards2.add(card1);
        cards2.add(card3);
        Hand hand2 = new Hand(cards2);

        Assert.assertTrue(hand.allSuitsAreDifferent());
        Assert.assertFalse(hand2.allSuitsAreDifferent());
    }

    @Test
    public void testMaxCardNumber() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        Hand hand = new Hand(cards);

        LinkedList<Card> cards2 = new LinkedList<Card>();
        cards2.add(card1);
        cards2.add(card1);
        cards2.add(card1);
        Hand hand2 = new Hand(cards2);

        Assert.assertEquals(7, hand.maxCardNumber());
        Assert.assertEquals(5, hand2.maxCardNumber());
    }

    @Test
    public void testCorrectlyCalculatesEnvidoWhenCardsAreAllOfDifferentSuits() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);
        Card card4 = new Card(12, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        Hand hand = new Hand(cards);

        LinkedList<Card> cards2 = new LinkedList<Card>();
        cards2.add(card1);
        cards2.add(card2);
        cards2.add(card4);
        Hand hand2 = new Hand(cards2);

        Assert.assertEquals(7, hand.calculateEnvido());
        Assert.assertEquals(12, hand2.calculateEnvido());
    }

    @Test
    public void testGetCardsOfTheSameSuit() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);
        Card card4 = new Card(12, "ESPADA", 6);
        Card card5 = new Card(3, "ORO", 5);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card5);
        Hand hand = new Hand(cards);
        LinkedList<Card> expectedCards = new LinkedList<Card>();
        expectedCards.add(card2);
        expectedCards.add(card5);
        LinkedList expectedHand = new LinkedList(expectedCards);

        LinkedList<Card> cards2 = new LinkedList<Card>();
        cards2.add(card1);
        cards2.add(card3);
        cards2.add(card4);
        Hand hand2 = new Hand(cards2);
        LinkedList<Card> expectedCards2 = new LinkedList<Card>();
        expectedCards2.add(card3);
        expectedCards2.add(card4);
        LinkedList<Card> expectedHand2 = new LinkedList<Card>(expectedCards2);

        LinkedList whatIGet = hand.getCardsOfTheSameSuit();
        Assert.assertEquals(expectedHand, whatIGet);

        LinkedList whatIGet2 = hand2.getCardsOfTheSameSuit();
        Assert.assertEquals(expectedHand2, whatIGet2);
    }

    @Test
    public void testGetMostRepeatedSuit() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);
        Card card4 = new Card(12, "ESPADA", 6);
        Card card5 = new Card(3, "ORO", 5);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card5);
        Hand hand = new Hand(cards);

        LinkedList<Card> cards2 = new LinkedList<Card>();
        cards2.add(card1);
        cards2.add(card3);
        cards2.add(card4);
        Hand hand2 = new Hand(cards2);

        Assert.assertEquals("ORO", hand.getMostRepeatedSuit());
        Assert.assertEquals("ESPADA", hand2.getMostRepeatedSuit());
    }

    @Test
    public void testGetEnvidoFromCardsOfTheSameSuit() throws InvalidSuiteException, InvalidCardNumberException {
        Card card1 = new Card(5, "BASTO", 1);
        Card card2 = new Card(7, "BASTO", 5);
        Card card3 = new Card(7, "ESPADA", 6);
        Card card4 = new Card(12, "ESPADA", 6);
        Card card5 = new Card(3, "ORO", 5);
        Card card6 = new Card(7, "ORO", 5);


        LinkedList<Card> cards = new LinkedList<Card>();
        Hand emptyHand = new Hand(cards);

        LinkedList<Card> cards1 = new LinkedList<Card>();
        cards1.add(card1);
        cards1.add(card2);

        LinkedList<Card> cards2 = new LinkedList<Card>();
        cards2.add(card3);
        cards2.add(card4);

        LinkedList<Card> cards3 = new LinkedList<Card>();
        cards3.add(card5);
        cards3.add(card6);


        Assert.assertTrue(emptyHand.getEnvidoFrom(cards1).equals(32));
        Assert.assertTrue(emptyHand.getEnvidoFrom(cards2).equals(27));
        Assert.assertTrue(emptyHand.getEnvidoFrom(cards3).equals(30));
    }


}