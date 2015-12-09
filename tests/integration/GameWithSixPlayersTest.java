package integration;


import model.Builder;
import model.Card;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Hand;
import org.junit.Before;

import java.util.LinkedList;

public class GameWithSixPlayersTest {
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private LinkedList<Card> hand1Cards;
    private LinkedList<Card> hand2Cards;
    private Hand hand1;
    private Hand hand2;
    private Builder builder;

    @Before
    public void setup() throws InvalidNumberOfPlayersException {
        card1 = new Card(5, "BASTO", 2);
        card2 = new Card(7, "BASTO", 4);
        card3 = new Card(7, "ESPADA", 12);

        card4 = new Card(12, "ESPADA", 7);
        card5 = new Card(3, "ORO", 10);
        card6 = new Card(7, "ORO", 11);

        hand1Cards = new LinkedList<Card>();
        hand1Cards.add(card1);
        hand1Cards.add(card2);
        hand1Cards.add(card3);

        hand2Cards = new LinkedList<Card>();
        hand2Cards.add(card4);
        hand2Cards.add(card5);
        hand2Cards.add(card6);

        hand1 = new Hand(hand1Cards);
        hand2 = new Hand(hand2Cards);

        builder = new Builder(6);

    }
}
