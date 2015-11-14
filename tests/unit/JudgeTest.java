package unit;

import model.Card;
import model.HumanPlayer;
import model.InvalidCardNumberException;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Judge;
import model.Player;

/**
 * Created by alexdebian on 11/11/15.
 */
public class JudgeTest {

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card6;
    Card card7;


    @Before
    public void setUp() throws Exception {
        card1 = new Card(7, "ESPADA", 7);
        card2 = new Card(2, "BASTO", 6);
        card3 = new Card(1, "COPA", 5);
        card4 = new Card(12, "ORO", 4);
        card5 = new Card(7, "BASTO", 3);
        card6 = new Card(6, "BASTO", 2);
        card7 = new Card(6, "ORO", 1);
    }

    @Test
    public void canInstantiateAJudge(){
        Judge judge = new Judge();
    }

    @Test
    public void correctlyComparesCardsValue(){
        Judge judge = new Judge();

        Assert.assertTrue(judge.isCardAHigherThanCardB(card1, card2));
        Assert.assertFalse(judge.isCardAHigherThanCardB(card2, card1));
    }
    
    @Test
    public void correctlyReceivePlayers() {
    	
    	Judge judge = new Judge();
    	HumanPlayer player1 = new HumanPlayer(1);
    	HumanPlayer player2 = new HumanPlayer(2);    	
    	LinkedList<Player> players = new LinkedList<Player>();
    	players.add(player1);
    	players.add(player2);
    	
    	judge.setPlayers(players);
    	
    	Assert.assertTrue(!players.isEmpty());
    	
    	
    }

}