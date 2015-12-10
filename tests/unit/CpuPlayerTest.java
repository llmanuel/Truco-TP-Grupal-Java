import model.*;
import model.Exceptions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class CpuPlayerTest {

    private Card card1, card2, card3, card4, card5, card6;
    private LinkedList<Card> hand1Cards, hand2Cards;
    private Hand hand1, hand2;

    @Before
    public void setup() {
        card1 = new Card( 5, "BASTO", 2 );
        card2 = new Card( 7, "BASTO", 4 );
        card3 = new Card( 1, "ESPADA", 14 );

        card4 = new Card(5, "ORO", 2);
        card5 = new Card(7, "ORO", 11);
        card6 = new Card(7, "ESPADA", 12);


        hand1Cards = new LinkedList<Card>();
        hand1Cards.add( card1 );
        hand1Cards.add( card2 );
        hand1Cards.add( card3 );

        hand2Cards = new LinkedList<Card>();
        hand2Cards.add( card4 );
        hand2Cards.add( card5 );
        hand2Cards.add( card6 );

        hand1 = new Hand( hand1Cards );
        hand2 = new Hand(hand2Cards);
    }

    @Test
    public void canInstanciateACpuPlayer(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );
    }

    @Test
    public void canReceiveAHandCorrectly(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        cpuplayer.setHand( hand1 );

        Assert.assertTrue( cpuplayer.getHand() == hand1 );

    }

    @Test
    public void canCalculateEnvidoCorrectly(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        cpuplayer.setHand( hand1 );

        Assert.assertEquals( 32, cpuplayer.calculateEnvido(), 0.0001 );

    }

    @Test
    public void savesPlayerIdCorrectly(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        Assert.assertEquals( 1, cpuplayer.getIdNumber(), 0.0001 );
    }

//    @Test
//    public void canPlayACardSecond() throws DonTHaveThatCardException, NotCardThrownException, NotYourTurnException, InvalidNumberOfPlayersException, TeamDoesntExistException {
//        Table table = new Table();
//
//        HumanPlayer firstPlayer = new HumanPlayer(1);
//        CpuPlayer secondPlayer = new CpuPlayer(2);
//
//        secondPlayer.setTable(table);
//        firstPlayer.setTable(table);
//
//        LinkedList<Player> players = new LinkedList<Player>();
//        players.addLast(firstPlayer);
//        players.addLast(secondPlayer);
//
//        table.letSitThese(players);
//
//        table.setGame();
//
//        firstPlayer.setHand(hand1);
//        secondPlayer.setHand(hand2);
//
//        firstPlayer.playCard(card3);
//
//        Assert.assertTrue( secondPlayer.getSlot().getLastOne() == card4 );
//
//    }

    @Test
    public void canOrderMyCards(){
        CpuPlayer cpuplayer = new CpuPlayer( 1 );

        card1 = new Card( 5, "BASTO", 2 );
        card2 = new Card( 7, "BASTO", 4 );
        card3 = new Card( 7, "ESPADA", 12 );

        hand1Cards = new LinkedList<Card>();
        hand1Cards.add( card3 );
        hand1Cards.add( card2 );
        hand1Cards.add( card1 );

        hand1 = new Hand( hand1Cards );
        cpuplayer.setHand( hand1 );
        LinkedList<Card> cards = cpuplayer.orderMyHandLowToHigh();

        Assert.assertTrue(cards.get(0).getValue() <= cards.get(1).getValue());
        Assert.assertTrue(cards.get(1).getValue() <= cards.get(2).getValue());
        Assert.assertTrue(cards.get(0).getValue() == 2);
        Assert.assertTrue(cards.get(1).getValue() == 4);
        Assert.assertTrue(cards.get(2).getValue() == 12 );
    }

//    @Test
//    public void canSearchTheHigherCardPlayedInTheRound() throws InvalidNumberOfPlayersException, NotYourTurnException, DonTHaveThatCardException, NotCardThrownException, TeamDoesntExistException {
//        Table table = new Table();
//
//        HumanPlayer firstPlayer = new HumanPlayer(1);
//        CpuPlayer secondPlayer = new CpuPlayer(2);
//
//        secondPlayer.setTable(table);
//        firstPlayer.setTable(table);
//
//        LinkedList<Player> players = new LinkedList<Player>();
//        players.addLast(firstPlayer);
//        players.addLast(secondPlayer);
//
//        table.letSitThese(players);
//
//        table.setGame();
//
//        firstPlayer.setHand(hand1);
//        secondPlayer.setHand(hand2);
//
//        firstPlayer.playCard(card3);
//
//        Assert.assertTrue(secondPlayer.searchHigherCardInTheRound() == 14);
//
//    }
}
