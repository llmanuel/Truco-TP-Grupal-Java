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
    private LinkedList<Team> fourPlayersTeams;
    private Team teamMyPlayer;
    private Team teamOtherPlayer;
    private Team teamCharles;
    private Team teamNick;

    @Before
    public void setup() throws InvalidNumberOfPlayersException {
        HumanPlayer myPlayer = new HumanPlayer(1);
        LinkedList<Player> myPlayerList= new LinkedList<Player>(  );
        myPlayerList.add( myPlayer );

        HumanPlayer otherPLayer = new HumanPlayer(2);
        LinkedList<Player> otherPlayerList = new LinkedList<Player>(  );
        myPlayerList.add( otherPLayer );

        HumanPlayer charles = new HumanPlayer(3);
        LinkedList<Player> charlesList= new LinkedList<Player>(  );
        myPlayerList.add( charles );

        HumanPlayer nick = new HumanPlayer(4);
        LinkedList<Player> nickList = new LinkedList<Player>(  );
        myPlayerList.add( nick );


        teamMyPlayer = new Team( myPlayerList );
        teamOtherPlayer = new Team( otherPlayerList );
        teamCharles = new Team( charlesList );
        teamNick = new Team( nickList );


        fourPlayers = new LinkedList<Player>();
        fourPlayers.addLast(myPlayer);
        fourPlayers.addLast(otherPLayer);
        fourPlayers.addLast(charles);
        fourPlayers.addLast(nick);

        fourPlayersTeams = new LinkedList<Team>();
        fourPlayersTeams.addLast(teamMyPlayer);
        fourPlayersTeams.addLast(teamOtherPlayer);
        fourPlayersTeams.addLast(teamCharles);
        fourPlayersTeams.addLast(teamNick);

        this.table = new Table();


        this.scoreboard = new Scoreboard( fourPlayersTeams, this.table );

        this.table.letSitThese( fourPlayers );
        this.table.setGame();

        this.judge = new Judge( this.scoreboard );

    }

    @Test (expected = NotCardThrownException.class)
    public void judgeThrowsExceptionWhenNoCardHasBeenThrown() throws NotCardThrownException, CanHaveScoreDoesntExistException {
        Games actualGame = new Truco(this.table, 0);
        this.judge.setWinnerOfTheRound( this.table.getSlots(), actualGame);
    }




}
