package integration;


import model.*;
import model.Exceptions.InvalidNumberOfPlayersException;
import org.junit.Before;
import org.junit.Test;

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
    private Table table;
    private LinkedList<Player> players;
    private Card card7;
    private Card card8;
    private Card card9;
    private Card card10;
    private Card card11;
    private Card card12;
    private Card card13;
    private Card card14;
    private Card card15;
    private Card card16;
    private Card card17;
    private Card card18;
    private LinkedList<Card> hand3Cards;
    private LinkedList<Card> hand4Cards;
    private LinkedList<Card> hand5Cards;
    private LinkedList<Card> hand6Cards;
    private Hand hand3;
    private Hand hand4;
    private Hand hand5;
    private Hand hand6;
    private Scoreboard scoreboard;
    private Player player1, player2, player3, player4, player5, player6;

    @Before
    public void setup() throws InvalidNumberOfPlayersException {
        card1 = new Card(5, "BASTO", 2);
        card2 = new Card(7, "BASTO", 4);
        card3 = new Card(7, "ESPADA", 12);

        card4 = new Card(12, "ESPADA", 7);
        card5 = new Card(3, "ORO", 10);
        card6 = new Card(7, "ORO", 11);

        card7 = new Card(4, "ORO", 1);
        card8 = new Card(5, "ORO", 2);
        card9 = new Card(2, "ORO", 9);

        card10 = new Card(11, "ESPADA", 6);
        card11 = new Card(6, "ORO", 3);
        card12 = new Card(1, "ORO", 8);

        card13 = new Card(10, "ESPADA", 5);
        card14 = new Card(1, "COPA", 8);
        card15 = new Card(7, "COPA", 4);

        card16 = new Card(12, "COPA", 7);
        card17 = new Card(3, "COPA", 10);
        card18 = new Card(6, "ESPADA", 11);


        hand1Cards = new LinkedList<Card>();
        hand1Cards.add(card1);
        hand1Cards.add(card2);
        hand1Cards.add(card3);

        hand2Cards = new LinkedList<Card>();
        hand2Cards.add(card4);
        hand2Cards.add(card5);
        hand2Cards.add(card6);

        hand3Cards = new LinkedList<Card>();
        hand3Cards.add(card7);
        hand3Cards.add(card8);
        hand3Cards.add(card9);

        hand4Cards = new LinkedList<Card>();
        hand4Cards.add(card10);
        hand4Cards.add(card11);
        hand4Cards.add(card12);

        hand5Cards = new LinkedList<Card>();
        hand5Cards.add(card13);
        hand5Cards.add(card14);
        hand5Cards.add(card15);

        hand6Cards = new LinkedList<Card>();
        hand6Cards.add(card16);
        hand6Cards.add(card17);
        hand6Cards.add(card18);



        hand1 = new Hand(hand1Cards);
        hand2 = new Hand(hand2Cards);
        hand3 = new Hand(hand3Cards);
        hand4 = new Hand(hand4Cards);
        hand5 = new Hand(hand5Cards);
        hand6 = new Hand(hand6Cards);


        builder = new Builder(6);

        table = builder.getTable();

        players = builder.getPlayers();

        players.get(0).setHand(hand1);
        player1 = players.get(0);

        players.get(1).setHand(hand2);
        player2 = players.get(1);

        players.get(2).setHand(hand3);
        player3 = players.get(2);

        players.get(3).setHand(hand4);
        player4 = players.get(3);

        players.get(4).setHand(hand5);
        player5 = players.get(4);

        players.get(5).setHand(hand6);
        player6 = players.get(5);

        scoreboard = table.getScoreboard();

    }

    @Test
    public void roundGoesNormal(){




    }
}
