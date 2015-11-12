package unit;

import model.Card;
import org.junit.Test;
import model.Judge;

/**
 * Created by alexdebian on 11/11/15.
 */
public class JudgeTest {

    @Test
    public void canInstantiateAJudge(){
        Judge judge = new Judge();
    }

    @Test
    public void correctlyComparesCardsValue(){
        Judge judge = new Judge();
        Card card1 = new Card(7, "unPalo");
        Card card2 = new Card(9, "unPalo");

//        judge.
    }

}