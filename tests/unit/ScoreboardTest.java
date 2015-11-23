import model.CanHaveScore;
import model.Exceptions.CanHaveScoreDoesntExistException;
import model.HumanPlayer;
import model.Scoreboard;
import model.Table;
import model.TableStates.Truco;
import org.junit.Assert;
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

    @Test
    public void scoreboardStartsWithZeroPoints() throws CanHaveScoreDoesntExistException {
        Scoreboard scoreboard = new Scoreboard( playerList, table );

        LinkedList<CanHaveScore> players = scoreboard.getPlayers();

        Assert.assertEquals( 0, scoreboard.getPointsOf( players.getFirst()) , 0.001 );
        Assert.assertEquals( 0, scoreboard.getPointsOf( players.getLast()) , 0.001 );

    }

    @Test
    public void pointsIncreaseCorrectly() throws CanHaveScoreDoesntExistException {
        Scoreboard scoreboard = new Scoreboard( playerList, table );

        LinkedList<CanHaveScore> players = scoreboard.getPlayers();

        Truco truco = new Truco( this.table );

        scoreboard.increaseTheScoreOf( players.getFirst(),  truco );

        Assert.assertEquals( 2, scoreboard.getPointsOf( players.getFirst()) , 0.001 );

    }



}