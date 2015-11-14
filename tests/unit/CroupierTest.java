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

<<<<<<< HEAD
    @Before
    public void setup() {
    	
         croupier = new Croupier();
    }

=======
>>>>>>> f93a68c1f68c76be50681e6923c69ddaacbd7528
    @Test
    public void testCroupierCanGiveAHand() throws InvalidSuiteException, InvalidCardNumberException {
        //Croupier croupier = new Croupier();

        Assert.assertThat( croupier.giveHand(), instanceOf( Hand.class ) );

    }
}
