import model.*;
import model.Exceptions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by lucas on 09/12/15.
 */
public class GameWithFourPlayersTest {

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
    private LinkedList<Card> hand3Cards;
    private LinkedList<Card> hand4Cards;
    private Hand hand3;
    private Hand hand4;
    private Scoreboard scoreboard;

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

        hand1 = new Hand(hand1Cards);
        hand2 = new Hand(hand2Cards);
        hand3 = new Hand(hand3Cards);
        hand4 = new Hand(hand4Cards);

        builder = new Builder(4);

        table = builder.getTable();

        players = builder.getPlayers();

        players.get(0).setHand(hand1);
        players.get(1).setHand(hand2);
        players.get(2).setHand(hand3);
        players.get(3).setHand(hand4);
    }

    @Test
    public void CanPlayASimpleGame() throws NotYourTurnException, DonTHaveThatCardException, NotCardThrownException, TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        Player player4 = players.get(3);

        player1.playCard(card1);
        player2.playCard(card4);
        player3.playCard(card7);
        player4.playCard(card10);

        player2.playCard(card5);
        player3.playCard(card8);
        player4.playCard(card11);
        player1.playCard(card2);

        Assert.assertEquals( 0, table.getScoreboard().getPointsOf(builder.getTeams().getFirst()));
        Assert.assertEquals( 1, table.getScoreboard().getPointsOf(builder.getTeams().getLast()));
    }

    @Test
    public void secondTeamWinTruco() throws NotYourTurnException, DonTHaveThatCardException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException, SecondTeamWonException, FirstTeamWonException {

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        Player player4 = players.get(3);

        player1.playCard(card1);
        player2.playCard(card4);
        player3.playCard(card7);
        player4.playCard(card10);

        player2.callTruco();
        player1.acceptCall();

        player2.playCard(card5);
        player3.playCard(card8);
        player4.playCard(card11);
        player1.playCard(card2);

        Assert.assertTrue(table.getScoreboard().getPointsOf(builder.getTeams().getFirst()) == 0);
        Assert.assertTrue(table.getScoreboard().getPointsOf(builder.getTeams().getLast()) == 2);
    }

    @Test
    public void theGameRotatesCorrectly() throws NotYourTurnException, InvalidGameCallException, NotCardThrownException, TeamDoesntExistException, DonTHaveThatCardException {

        Card newcard1 = new Card(5, "BASTO", 2);
        Card newcard2 = new Card(7, "ORO", 11);
        Card newcard3 = new Card(7, "ESPADA", 12);

        LinkedList<Card> cards = new LinkedList<>();
        cards.add(newcard1);
        cards.add(newcard2);
        cards.add(newcard3);

        Hand newHand = new Hand(cards);

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        Player player4 = players.get(3);

        player1.setHand(newHand);

        player1.playCard(newcard1);
        player2.playCard(card4);
        player3.playCard(card7);
        player4.playCard(card10);

        Assert.assertEquals(2, table.getActualPlayer().getIdNumber());

        player2.playCard(card5);
        player3.playCard(card8);
        player4.playCard(card11);
        player1.playCard(newcard2);

        Assert.assertEquals(1, table.getActualPlayer().getIdNumber());
    }

    @Test
    public void firstTeamWinEnvido() throws NotYourTurnException, InvalidGameCallException, NotCardThrownException, TeamDoesntExistException, DonTHaveThatCardException, SecondTeamWonException, FirstTeamWonException {

        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Player player3 = players.get(2);
        Player player4 = players.get(3);

        player1.callEnvido();
        player2.acceptCall();
        player1.playCard(card1);
        player2.playCard(card4);
        player3.playCard(card7);
        player4.playCard(card10);

        Assert.assertTrue(table.getScoreboard().getPointsOf(builder.getTeams().getFirst()) == 2);
        Assert.assertTrue(table.getScoreboard().getPointsOf(builder.getTeams().getLast()) == 0);

    }



}
