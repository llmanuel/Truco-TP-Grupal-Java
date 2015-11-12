package unit;

import model.Card;
import org.junit.*;

/**
 * Created by alexdebian on 11/11/15.
 */
public class CardTest {

    private static final Integer VALID_VALUE = 5;
    private static final String VALID_SUIT = "ORO";

    @Test
    public void canInstanciateCard(){
       Card card = new Card(VALID_VALUE, VALID_SUIT);
    }


    @Test (expected = model.InvalidCardNumberException.class)
    public void cantCreateCardeWithHigherValueThan12(){
        Card card = new Card(14, VALID_SUIT);

    }


}