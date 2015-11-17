package unit;

import model.PlayerDoesNotExistsException;
import model.Scoreboard;
import org.junit.Assert;
import org.junit.Test;


public class ScoreboardTest {

    private static final Integer numberOfPlayers = 2;

    @Test
    public void canInstantiateScoreboard() {
        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
    }

    @Test
    public void scoreboardSuccessfulyInitialize() {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
        int playerID = 2;
        Assert.assertTrue(0 == scoreboard.getScoreOfPlayer(playerID));

    }

    @Test
    public void canIncreaseTheScoreOfThePlayer() {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);

        int playerID = 2;
        int score = 2;
        int oldScore = scoreboard.getScoreOfPlayer(playerID);

        scoreboard.increseTheScoreOf(playerID, score);

        Assert.assertTrue(oldScore + score == scoreboard.getScoreOfPlayer(playerID));

    }

    @Test(expected = PlayerDoesNotExistsException.class)
    public void cantIncreaseTheScoreOfAnInvalidPlayer() throws PlayerDoesNotExistsException {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);

        int playerID = 3;
        int score = 2;

        scoreboard.increseTheScoreOf(playerID, score);
    }

    @Test
    public void PlayerWin() {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);

        int playerID = 2;
        int score = 30;

        scoreboard.increseTheScoreOf(playerID, score);

        Assert.assertTrue(playerID == scoreboard.lookForAWinner());

    }


}