package unit;

import org.junit.Before;
import org.junit.Test;
import model.Scoreboard;

/**
 * Created by alexdebian on 11/11/15.
 */
public class ScoreboardTest {
	
	private static final Integer numberOfPlayers = 2;
	
    @Test
    public void canInstantiateScoreboard(){
        Scoreboard scoreboard = new Scoreboard(numberOfPlayers);
    }


}