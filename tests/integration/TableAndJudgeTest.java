import model.*;
import model.Exceptions.*;
import model.TableStates.Games;
import model.TableStates.Truco;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class TableAndJudgeTest {


    private Table table;
    private Judge judge;
    private Scoreboard scoreboard;
    private LinkedList<Player> fourPlayers;
    private LinkedList<CanHaveScore> fourPlayersScoreboard;

    @Before
    public void setup() throws InvalidNumberOfPlayersException {
        HumanPlayer myPLayer = new HumanPlayer(1);
        HumanPlayer otherPLayer = new HumanPlayer(2);
        HumanPlayer charles = new HumanPlayer(3);
        HumanPlayer nick = new HumanPlayer(4);

        fourPlayers = new LinkedList<Player>();
        fourPlayers.addLast(myPLayer);
        fourPlayers.addLast(otherPLayer);
        fourPlayers.addLast(charles);
        fourPlayers.addLast(nick);

        fourPlayersScoreboard = new LinkedList<CanHaveScore>();
        fourPlayersScoreboard.addLast(myPLayer);
        fourPlayersScoreboard.addLast(otherPLayer);
        fourPlayersScoreboard.addLast(charles);
        fourPlayersScoreboard.addLast(nick);

        this.table = new Table();


        this.scoreboard = new Scoreboard( fourPlayersScoreboard, this.table );

        this.table.letSitThese( fourPlayers );
        this.table.setGame();

        this.judge = new Judge( this.scoreboard );

    }

    @Test (expected = NotCardThrownException.class)
    public void judgeThrowsExceptionWhenNoCardHasBeenThrown() throws NotCardThrownException, CanHaveScoreDoesntExistException {
        Games actualGame = new Truco(this.table, 0);
        this.judge.setWinnerOfTheRound( this.table.getSlots(), actualGame);
    }

    @Test
    public void tableCanPassSlotsAndGameToJudgeCorrectly() throws InvalidSuiteException, InvalidCardNumberException, CanHaveScoreDoesntExistException, NotYourTurnException {
        Games actualGame = new Truco(this.table, 0);
        Card card1 = new Card(1, "BASTO", 1);
        Card card2 = new Card(3, "ORO", 3);
        Card card3 = new Card(4, "ORO", 4);
        Card card4 = new Card(5, "ORO", 5);

        LinkedList<Card> listOfCards = new LinkedList<Card>();
        listOfCards.add(card1);
        listOfCards.add(card2);
        listOfCards.add(card3);
        listOfCards.add(card4);

        Hand hand = new Hand(listOfCards);

        fourPlayers.get(0).sitOnTable(table);
        fourPlayers.get(1).sitOnTable(table);
        fourPlayers.get(2).sitOnTable(table);
        fourPlayers.get(3).sitOnTable(table);

        fourPlayers.get(0).setHand(hand);
        fourPlayers.get(1).setHand(hand);
        fourPlayers.get(2).setHand(hand);
        fourPlayers.get(3).setHand(hand);

        fourPlayers.get(0).playCard(card1);
        fourPlayers.get(1).playCard(card2);
        fourPlayers.get(2).playCard(card3);
        fourPlayers.get(3).playCard(card4);

        boolean exceptionRised = false;
        try {
            this.judge.setWinnerOfTheRound( this.table.getSlots(), actualGame);
        } catch (NotCardThrownException e) {
            exceptionRised = true;
        }

        Assert.assertFalse(exceptionRised);
    }


}
