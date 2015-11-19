package unit;

import model.Exceptions.PlayerDoesNotExistsException;
import model.Scoreboard;
import org.junit.Assert;
import org.junit.Test;


public class ScoreboardTest {

    private static final Integer numberOfPlayers = 2;

    /*@Test
    public void canInstantiateScoreboard() {
        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
    }

    @Test
    public void scoreboardSuccessfulyInitialize() {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
        int playerID = 2;
        Assert.assertTrue(0 == scoreboard.getPointsOf(playerID));

    }

    @Test
    public void canIncreaseTheScoreOfThePlayer() {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);

        int playerID = 2;
        int score = 2;
        int oldScore = scoreboard.getPointsOf(playerID);

        scoreboard.increaseTheScoreOf(playerID, score);

        Assert.assertTrue(oldScore + score == scoreboard.getPointsOf(playerID));

    }

    @Test(expected = PlayerDoesNotExistsException.class)
    public void cantIncreaseTheScoreOfAnInvalidPlayer() throws PlayerDoesNotExistsException {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);

        int playerID = 3;
        int score = 2;

        scoreboard.increaseTheScoreOf(playerID, score);
    }

    @Test
    public void PlayerWin() {

        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);

        int playerID = 2;
        int score = 30;

        scoreboard.increaseTheScoreOf(playerID, score);

        Assert.assertTrue(playerID == scoreboard.lookForAWinner());

    }*/


}