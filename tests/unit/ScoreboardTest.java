package unit;

import model.*;
import model.Exceptions.FirstTeamWonException;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.SecondTeamWonException;
import model.Exceptions.TeamDoesntExistException;
import model.TableStates.Truco;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ScoreboardTest {

    private Table table;
    private Scoreboard scoreboard;


    @Before
    public void setup() throws InvalidNumberOfPlayersException {
      Builder builder = new Builder(2);

      this.table = builder.getTable();

      scoreboard = table.getScoreboard();
    }

    @Test
    public void scoreboardStartsWithZeroPoints() throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {


        LinkedList<Team> players = scoreboard.getPlayers();

        Assert.assertEquals( 0, scoreboard.getPointsOf( players.getFirst()) , 0.001 );
        Assert.assertNotEquals( 2, scoreboard.getPointsOf( players.getLast()) , 0.001 );

    }

    @Test
    public void pointsIncreaseCorrectly() throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {
        LinkedList<Team> players = scoreboard.getPlayers();

        Truco truco = new Truco( this.table, 0 );

        scoreboard.increaseTheScoreOf( players.getFirst(),  truco );

        Assert.assertEquals( 2, scoreboard.getPointsOf( players.getFirst()) , 0.001 );
        Assert.assertEquals( 0, scoreboard.getPointsOf( players.getLast() ), 0.001 );

    }

    @Test
    public void pointsIncreaseCorrectlyWhenGameGaveUp() throws TeamDoesntExistException, SecondTeamWonException, FirstTeamWonException {

        LinkedList<Team> players = scoreboard.getPlayers();

        Truco truco = new Truco( this.table, 2 );

        scoreboard.playerGaveUpThisGame(players.getFirst(), truco);
        
        Assert.assertEquals( 2, scoreboard.getPointsOf( players.getLast()) , 0.001 );
        

    }



}