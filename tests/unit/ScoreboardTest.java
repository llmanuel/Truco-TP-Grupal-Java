import model.*;
import model.Exceptions.CanHaveScoreDoesntExistException;
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
        HumanPlayer myPlayer = new HumanPlayer(1);
        LinkedList<Player> myPlayerList= new LinkedList<Player>(  );
        myPlayerList.add( myPlayer );

        HumanPlayer otherPLayer = new HumanPlayer(2);
        LinkedList<Player> otherPlayerList = new LinkedList<Player>(  );
        myPlayerList.add( otherPLayer );

        table = new Table();
    }

 /*   @Test
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

        Truco truco = new Truco( this.table, 0 );

        scoreboard.increaseTheScoreOf( players.getFirst(),  truco );

        Assert.assertEquals( 2, scoreboard.getPointsOf( players.getFirst()) , 0.001 );

    }

    @Test
    public void pointsIncreaseCorrectlyWhenGameGaveUp(){
        Scoreboard scoreboard = new Scoreboard( playerList, table );

        LinkedList<CanHaveScore> players = scoreboard.getPlayers();

        Truco truco = new Truco( this.table, 0 );

        scoreboard.playerGaveUpThisGame(players.getFirst(), truco);

    }

    */

}