package unit;

import model.Card;
import model.Exceptions.DonTHaveThatCardException;
import model.Hand;
import org.junit.Assert;
import org.junit.Test;


import java.util.LinkedList;

public class HandTest {
    @Test()
    public void canInstatiateHand(){
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand hand = new Hand(cards);
    }

    @Test()
    public void canGetCardsFromAHand() throws  DonTHaveThatCardException {
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand hand = new Hand(cards);

        Assert.assertEquals(card1,hand.getCard(card1));
        Assert.assertEquals(card2,hand.getCard(card2));
        Assert.assertEquals(card3,hand.getCard(card3));
    }

    @Test (expected = DonTHaveThatCardException.class)
    public void canTGetACardTwoTimesFromAHand() throws DonTHaveThatCardException {
        Card card1 = new Card(5, "ORO", 1);
        Card card2 = new Card(7, "ORO", 5);
        Card card3 = new Card(7, "ESPADA", 6);

        LinkedList<Card> cards = new LinkedList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        Hand hand = new Hand(cards);

        Assert.assertEquals(card1,hand.getCard(card1));
        Assert.assertEquals(card1,hand.getCard(card1));
    }

    @Test
    public void testsFlor() {
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
    public void testEnvido(){
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
    
}