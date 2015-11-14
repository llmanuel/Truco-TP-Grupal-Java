package unit;

import model.Croupier;
import model.Hand;
import model.InvalidCardNumberException;
import model.InvalidSuiteException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class CroupierTest {

    private Croupier croupier;

    @Before
    public void setup() {
    	
         croupier = new Croupier();
    }

    @Test
    public void testCroupierCanGiveAHand() throws InvalidSuiteException, InvalidCardNumberException {
        //Croupier croupier = new Croupier();

        Assert.assertThat( croupier.giveHand(), instanceOf( Hand.class ) );


    }
}
