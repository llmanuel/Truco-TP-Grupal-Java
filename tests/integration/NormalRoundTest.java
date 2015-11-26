import model.*;
import model.Exceptions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class NormalRoundTest {

    private Card card1,card2,card3,card4,card5,card6;
    private LinkedList<Card> hand1Cards;
    private LinkedList<Card> hand2Cards;
    private Hand hand1;
    private Hand hand2;
    private HumanPlayer player1;
    private HumanPlayer player2;
    private Table table;
    private LinkedList<Player> playersList;


    @Before
    public void setup() throws InvalidSuiteException, InvalidCardNumberException, InvalidNumberOfPlayersException {
        card1 = new Card(5, "BASTO", 1);
        card2 = new Card(7, "BASTO", 5);
        card3 = new Card(7, "ESPADA", 6);

        card4 = new Card(12, "ESPADA", 6);
        card5 = new Card(3, "ORO", 5);
        card6 = new Card(7, "ORO", 5);
        
        hand1Cards = new LinkedList<Card>();
        hand1Cards.add( card1 );
        hand1Cards.add( card2 );
        hand1Cards.add( card3 );

        hand2Cards = new LinkedList<Card>();
        hand2Cards.add( card4 );
        hand2Cards.add( card5 );
        hand2Cards.add( card6 );

        hand1 = new Hand( hand1Cards );
        hand2 = new Hand( hand2Cards );

        player1 = new HumanPlayer( 1 );
        player2 = new HumanPlayer( 2 );

        player1.setHand( hand1 );
        player2.setHand( hand2 );

        playersList = new LinkedList<Player>();
        playersList.add(player1);
        playersList.add(player2);

        table = new Table();
        table.letSitThese(playersList);

        player1.sitOnTable(table);
        player2.sitOnTable(table);

    }

    @Test
    public void playersCanPlayCardsInTheirTurn() throws NotYourTurnException, NotCardThrownException {
        /*With setgame() the turn belongs directly to player1 because he is the first on the List*/
        table.setGame();

        Hand playerHand = player1.getHand();

        player1.playCard(playerHand.getCards().getFirst());

        Slot firstPlayerSlot = table.getSlots().getFirst();

        Card theCardPlayed = firstPlayerSlot.getLastOne();

        Assert.assertEquals(card1,theCardPlayed);
    }

    @Test (expected = NotYourTurnException.class)
    public void playersCantPlayMoreThanACardInTheirTurn() throws NotYourTurnException, NotCardThrownException {
        table.setGame();/*With setgame() the turn belongs directly to player1 because he is the first on the List*/

        Hand playerHand = player1.getHand();

        player1.playCard(playerHand.getCards().getFirst());

        player1.playCard(playerHand.getCards().getFirst());

    }

    @Test (expected = NotYourTurnException.class)
    public void playersCanTPlayCardsOutOfTheirTurn() throws NotYourTurnException, NotCardThrownException {
        table.setGame();/*With setgame() the turn belongs directly to player1 because he is the first on the List*/
        player2.playCard(card4);
        Slot SecondPlayerSlot = table.getSlots().getFirst();
        Card theCardPlayed = SecondPlayerSlot.getLastOne();
        Assert.assertEquals(card4,theCardPlayed);
    }

    @Test
    public void whenPlayersFinishThierTurnTheOtherOneCanPlay() throws NotYourTurnException, NotCardThrownException {
        table.setGame();/*With setgame() the turn belongs directly to player1 because he is the first on the List*/
        player1.playCard(card1);/*When a Player plays a Card, it's turn finish automatically*/
        Slot fristPlayerSlot = table.getSlots().getFirst();
        Card theCardPlayed = fristPlayerSlot.getLastOne();
        Assert.assertEquals(card1,theCardPlayed);


        player2.playCard(card4);
        Slot SecondPlayerSlot = table.getSlots().getLast();
        Card theCardPlayed2 = SecondPlayerSlot.getLastOne();
        Assert.assertEquals(card4,theCardPlayed2);
    }


}
