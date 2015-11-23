
import model.Card;
import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;
import org.junit.Before;

import java.util.LinkedList;

public class NormalRoundTest {

    private Card card1,card2,card3,card4,card5,card6;
    private LinkedList<Card> hand1;


    @Before
    public void setup() throws InvalidSuiteException, InvalidCardNumberException {
        card1 = new Card(5, "BASTO", 1);
        card2 = new Card(7, "BASTO", 5);
        card3 = new Card(7, "ESPADA", 6);

        card4 = new Card(12, "ESPADA", 6);
        card5 = new Card(3, "ORO", 5);
        card6 = new Card(7, "ORO", 5);
        
        hand1 = new LinkedList<Card>();





    }




}
