package unit;

import model.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Judge;

/**
 * Created by alexdebian on 11/11/15.
 */
public class JudgeTest {

    Card card1 = new Card(7, "ESPADA");
    Card card2 = new Card(2, "BASTO");
    Card card3 = new Card(1, "COPA");
    Card card4 = new Card(12, "ORO");
    Card card5 = new Card(7, "BASTO");
    Card card6 = new Card(6, "ORO");


    @Test
    public void canInstantiateAJudge(){
        Judge judge = new Judge();
    }

    @Test
    public void correctlyComparesCardsValue(){
        Judge judge = new Judge();

        Assert.assertFalse(judge.isCardAHigherThanCardB(card1, card2));
        Assert.assertTrue(judge.isCardAHigherThanCardB(card2, card1));
    }

    @Test
    public void testsEnvidoCalculation(){
        Judge judge = new Judge();

        judge
    }

}