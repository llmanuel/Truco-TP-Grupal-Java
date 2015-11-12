package unit;

import model.Card;
import model.InvalidCardNumberException;
import model.InvalidSuiteException;
import org.junit.*;

/**
 * Created by alexdebian on 11/11/15.
 */
public class CardTest {

    private static final Integer VALID_NUMBER = 5;
    private static final String VALID_SUIT = "ORO";
    private static final Integer VALID_VALUE = 12;

    @Test
    public void canInstanciateCard() throws InvalidSuiteException, InvalidCardNumberException {
       Card card = new Card(VALID_NUMBER, VALID_SUIT, VALID_VALUE);
    }


    @Test (expected = model.InvalidCardNumberException.class)
    public void cantCreateCardeWithHigherValueThan12() throws InvalidSuiteException, InvalidCardNumberException {
        Card card = new Card(14, VALID_SUIT, VALID_VALUE);

    }

    @Test (expected = model.InvalidSuiteException.class)
    public void cantCreateCardeWithInvalidSuit() throws InvalidSuiteException, InvalidCardNumberException {
        Card card = new Card(VALID_NUMBER, "FAFAFA", VALID_VALUE);

    }



}