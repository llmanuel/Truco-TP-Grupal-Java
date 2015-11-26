package unit;

import model.*;
import model.Exceptions.TeamDoesntExistException;
import model.TableStates.Truco;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScoreboardTest {

    private HumanPlayer player1;
    private HumanPlayer player2;
    private HumanPlayer player3;
    private HumanPlayer player4;

    private LinkedList<Team> playerList;
    private Table table;
    

  @Before
    public void setup(){
        player1 = new HumanPlayer(1);
        player2 = new HumanPlayer(2);
        player3 = new HumanPlayer(3);
        player4 = new HumanPlayer(4);
     
        LinkedList<Player> players1 = new LinkedList<Player>();
        LinkedList<Player> players2 = new LinkedList<Player>();
        
        players1.add(player1);
        players1.add(player2);
        
        players2.add(player3);
        players2.add(player4);

        Team team1 = new Team(players1);
        Team team2 = new Team(players2);
        
        playerList = new LinkedList<Team>();
        
        playerList.add(team1);
        playerList.add(team2);
        
        table = new Table();
    }

    @Test
    public void canInstantiateScoreboard(){
        Scoreboard scoreboard = new Scoreboard( playerList, table );

    }

    @Test
    public void scoreboardStartsWithZeroPoints() throws TeamDoesntExistException {
        Scoreboard scoreboard = new Scoreboard( playerList, table );

        LinkedList<Team> players = scoreboard.getPlayers();

        Assert.assertEquals( 0, scoreboard.getPointsOf( players.getFirst()) , 0.001 );
        Assert.assertNotEquals( 2, scoreboard.getPointsOf( players.getLast()) , 0.001 );

    }

    @Test
    public void pointsIncreaseCorrectly() throws TeamDoesntExistException {
        Scoreboard scoreboard = new Scoreboard( playerList, table );

        LinkedList<Team> players = scoreboard.getPlayers();

        Truco truco = new Truco( this.table, 0 );

        scoreboard.increaseTheScoreOf( players.getFirst(),  truco );

        Assert.assertEquals( 2, scoreboard.getPointsOf( players.getFirst()) , 0.001 );

    }

    @Test
    public void pointsIncreaseCorrectlyWhenGameGaveUp() throws TeamDoesntExistException{
        Scoreboard scoreboard = new Scoreboard( playerList, table );

        LinkedList<Team> players = scoreboard.getPlayers();

        Truco truco = new Truco( this.table, 0 );

        scoreboard.playerGaveUpThisGame(players.getFirst(), truco);
        
        Assert.assertEquals( 2, scoreboard.getPointsOf( players.getLast()) , 0.001 );
        

    }



}