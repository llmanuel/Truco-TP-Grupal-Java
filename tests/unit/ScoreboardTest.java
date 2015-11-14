package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Scoreboard;

/**
 * Created by alexdebian on 11/11/15.
 */
public class ScoreboardTest {
	
	private static final Integer numberOfPlayers = 2;
	private static final Integer playerID = 2;
	
    @Test
    public void canInstantiateScoreboard(){
        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
    }
    
    @Test
    public void scoreboardSuccessfulyInitialize(){
    	
    	Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
    	
    	Assert.assertTrue( 0 == scoreboard.getScoreOfPlayer(playerID));
    	
    }
    
    @Test
    public void canIncreaseTheScoreOfThePlayer(){
    	
    	Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
    	
    	int score = 2;
    	int oldScore = scoreboard.getScoreOfPlayer(playerID);
    	
    	scoreboard.increseTheScoreOf(playerID , score);
    	
    	Assert.assertTrue(oldScore + score == scoreboard.getScoreOfPlayer(playerID));
    	
    }
}