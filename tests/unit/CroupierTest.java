package unit;

import model.Croupier;
import model.Hand;
import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class CroupierTest {

    private Croupier croupier;

    @Before
    public void setup() throws InvalidSuiteException, InvalidCardNumberException {
    	
         croupier = new Croupier();
    }


    @Test
    public void testCroupierCanGiveAHand() throws InvalidSuiteException, InvalidCardNumberException {

        Assert.assertThat( croupier.giveHand(), instanceOf( Hand.class ) );
    }

}
