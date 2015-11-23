package integration;

import model.*;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class TableAndJudgeTest {


    private Table table;
    private Judge judge;
    private Scoreboard scoreboard;
    private LinkedList<Player> fourPlayers;

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


//        this.scoreboard = new Scoreboard( 4 );

        this.table = new Table();
        this.table.letSitThese( fourPlayers );
        this.table.setGame();

        this.judge = new Judge( this.scoreboard );

    }

    @Test (expected = NotCardThrownException.class)
    public void judgeThrowsExceptionWhenNoCardHasBeenThrown() throws NotCardThrownException {
        Games actualGame = new Truco();
        this.judge.setWinnerOfTheRound( this.table.getSlots(), actualGame);
    }

    @Test
    public void tableCanPassSlotsAndGameToJudgeCorrectly(){

    }


}
