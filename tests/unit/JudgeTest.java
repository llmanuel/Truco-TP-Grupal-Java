package unit;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

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
    Scoreboard scoreboard;


    @Before
    public void setUp() throws Exception {
        card1 = new Card(7, "ESPADA", 12);
        card2 = new Card(2, "BASTO", 9);
        card3 = new Card(1, "COPA", 8);
        card4 = new Card(12, "ORO", 7);
        card5 = new Card(7, "BASTO", 4);
        card6 = new Card(6, "BASTO", 3);
        card7 = new Card(6, "ORO", 3);
//        this.scoreboard = new Scoreboard(2);

    }

    @Test
    public void canInstantiateAJudge(){
        Judge judge = new Judge(this.scoreboard);
    }

    @Test
    public void correctlyComparesCardsValue(){
        Judge judge = new Judge(this.scoreboard);

        Assert.assertTrue(judge.isCardAHigherThanCardB(card1, card2));
        Assert.assertFalse(judge.isCardAHigherThanCardB(card2, card1));
    }


}