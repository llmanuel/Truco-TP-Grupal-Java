package integration;

import model.*;
import model.Exceptions.*;
import model.TableStates.Games;
import model.TableStates.Truco;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class TableAndJudgeTest {


    private Table table;
    private Judge judge;
    private Scoreboard scoreboard;
    private LinkedList<Player> twoPlayers;
    private LinkedList<Team> twoPlayersTeam;
    private Team teamMyPlayer;
    private Team teamOtherPlayer;
    HumanPlayer myPlayer;
    HumanPlayer otherPLayer;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private LinkedList<Card> hand1Cards;
    private LinkedList<Card> hand2Cards;
    private Hand hand1;
    private Hand hand2;

    @Before
    public void setup() throws InvalidNumberOfPlayersException {
        card1 = new Card(5, "BASTO", 2);
        card2 = new Card(7, "ESPADA", 12);
        card3 = new Card(7, "BASTO", 4);

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


        myPlayer = new HumanPlayer(1);
        LinkedList<Player> myPlayerList= new LinkedList<Player>(  );
        myPlayerList.add( myPlayer );

        otherPLayer = new HumanPlayer(2);
        LinkedList<Player> otherPlayerList = new LinkedList<Player>(  );
        otherPlayerList.add( otherPLayer );

        teamMyPlayer = new Team( myPlayerList );
        teamOtherPlayer = new Team( otherPlayerList );

        twoPlayers = new LinkedList<Player>();
        twoPlayers.addLast(myPlayer);
        twoPlayers.addLast(otherPLayer);

        twoPlayersTeam = new LinkedList<Team>();
        twoPlayersTeam.addLast(teamMyPlayer);
        twoPlayersTeam.addLast(teamOtherPlayer);

        this.table = new Table();

        myPlayer.setTable( this.table );
        otherPLayer.setTable( this.table );

        this.scoreboard = new Scoreboard( twoPlayersTeam, this.table );

        this.table.letSitThese( twoPlayers );
        this.table.setTeams(teamMyPlayer,teamOtherPlayer);
        this.table.setGame();

        this.judge = new Judge( this.scoreboard );

        this.table.setJudge( this.judge );

    }

    @Test (expected = NotCardThrownException.class)
    public void judgeThrowsExceptionWhenNoCardHasBeenThrown() throws NotCardThrownException, TeamDoesntExistException, SomebodyWonTheGame, WasATieException {
        Games actualGame = new Truco(this.table, 0);
        this.judge.setWinnerOfTheRound( this.table.getSlots());
    }

    @Test
    public void judgeReturnWinnerOfARoundCorrectly() throws NotYourTurnException, DonTHaveThatCardException, NotCardThrownException, TeamDoesntExistException, MustAcceptCallFirstException {
        myPlayer.setHand( hand1 );
        otherPLayer.setHand( hand2 );

        myPlayer.playCard( card1 );
        otherPLayer.playCard( card4 );


    }



}
