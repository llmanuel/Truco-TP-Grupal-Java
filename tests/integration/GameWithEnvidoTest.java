package integration;

import model.*;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by manuel on 27/11/15.
 */
public class GameWithEnvidoTest {

    private Card card1,card2,card3,card4,card5,card6;
    private LinkedList<Card> hand1Cards;
    private LinkedList<Card> hand2Cards;
    private Hand hand1;
    private Hand hand2;
    private HumanPlayer player1;
    private HumanPlayer player2;
    private Table table;
    private LinkedList<Player> playersList;
    private LinkedList<Player> player1team;
    private LinkedList<Player> player2team;
    private Team team1;
    private Team team2;
    private LinkedList<Team> teamList;
    private Scoreboard scoreboard;
    private Judge judge;


    @Before
    public void setup() throws InvalidNumberOfPlayersException {
        card1 = new Card(5, "BASTO", 2);
        card2 = new Card(7, "BASTO", 4);
        card3 = new Card(7, "ESPADA", 12);

        card4 = new Card(12, "ESPADA", 7);
        card5 = new Card(3, "ORO", 10);
        card6 = new Card(7, "ORO", 11);

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
        player1team = new LinkedList<Player>( );
        player1team.add( player1 );

        player2 = new HumanPlayer( 2 );
        player2team = new LinkedList<Player>( );
        player2team.add( player2 );



        playersList = new LinkedList<Player>();
        playersList.add(player1);
        playersList.add(player2);

        table = new Table();
        table.letSitThese(playersList);

        player1.setTable(table);
        player2.setTable(table);

        team1 = new Team( player1team );
        team2 = new Team( player2team );

        teamList = new LinkedList<Team>(  );
        teamList.add( team1 );
        teamList.add( team2 );

        this.scoreboard = new Scoreboard( teamList, table );

        this.judge = new Judge( this.scoreboard );

        this.table.setJudge( this.judge );
        this.table.setScoreBoard( this.scoreboard );
        this.table.setTeams( team1, team2 );

    }

    @Test
    public void firstPlayerCallEnvidoTest() throws TeamDoesntExistException, NotYourTurnException, NotCardThrownException {
        this.table.setGame();

        player1.setHand( hand1 );
        player2.setHand( hand2 );

        player1.callEnvido();
        player2.acceptCall();

        Assert.assertTrue( scoreboard.getPointsOf( player2 ) == 0 );
        Assert.assertEquals( 2 ,scoreboard.getPointsOf( player1 ));
    }

    @Test
    public void firstPlayerCallEnvidoAndTheOtherGivesUpTest() throws TeamDoesntExistException, NotYourTurnException, NotCardThrownException {
        this.table.setGame();

        player1.setHand( hand1 );
        player2.setHand( hand2 );

        player1.callEnvido();
        player2.giveUp();

        Assert.assertEquals( 0 , scoreboard.getPointsOf( player2 ) );
        Assert.assertEquals( 1 , scoreboard.getPointsOf( player1 ));
    }
}
