package unit;

import model.Card;
import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;
import org.junit.*;


public class CardTest {

    private static final Integer VALID_NUMBER = 5;
    private static final String VALID_SUIT = "ORO";
    private static final Integer VALID_VALUE = 12;

    @Test
    public void canInstanciateCard() throws InvalidSuiteException, InvalidCardNumberException {
       Card card = new Card(VALID_NUMBER, VALID_SUIT, VALID_VALUE);
    }


//    @Test (expected = InvalidCardNumberException.class)
//    public void cantCreateCardeWithHigherValueThan12() throws InvalidSuiteException, InvalidCardNumberException {
//        Card card = new Card(14, VALID_SUIT, VALID_VALUE);
//
//    }
//
//    @Test (expected = InvalidSuiteException.class)
//    public void cantCreateCardeWithInvalidSuit() throws InvalidSuiteException, InvalidCardNumberException {
//        Card card = new Card(VALID_NUMBER, "FAFAFA", VALID_VALUE);
//
//    }

    @Test
    public void cardReturnsCorrectNumber() throws InvalidSuiteException, InvalidCardNumberException {
        Card card = new Card(VALID_NUMBER, VALID_SUIT, VALID_VALUE);

        Assert.assertEquals(card.getNumber(), VALID_NUMBER, 0.0001);

    }

    @Test
    public void cardReturnsCorrectValue() throws InvalidSuiteException, InvalidCardNumberException {
        Card card = new Card(VALID_NUMBER, VALID_SUIT, VALID_VALUE);

        Assert.assertEquals(card.getValue(), VALID_VALUE, 0.0001);

    }

    @Test
    public void cardReturnsCorrectSuit() throws InvalidSuiteException, InvalidCardNumberException {
        Card card = new Card(VALID_NUMBER, VALID_SUIT, VALID_VALUE);

        Assert.assertEquals(card.getSuit(), VALID_SUIT);

    }


}