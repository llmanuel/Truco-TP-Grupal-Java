package unit;

import model.CanHaveScore;
import model.HumanPlayer;
import model.Scoreboard;
import model.Table;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ScoreboardTest {

    private HumanPlayer player1;
    private HumanPlayer player2;
    private LinkedList<CanHaveScore> playerList;
    private Table table;

    @Before
    public void setup(){
        player1 = new HumanPlayer( 1 );
        player2 = new HumanPlayer( 2 );

        playerList = new LinkedList<CanHaveScore>( );
        playerList.add( player1 );
        playerList.add( player2 );

        table = new Table();
    }

    @Test
    public void canInstantiateScoreboard(){
        Scoreboard scoreboard = new Scoreboard( playerList, table );

    }



}