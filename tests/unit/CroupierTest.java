package unit;

import model.Croupier;
import model.Hand;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class CroupierTest {
    @Test
    public void testCroupierIsCorrectlyCreated(){
        Croupier testCroupier = new Croupier();
    }

    @Test
    public void testCroupierCanGiveAHand(){
        Croupier croupier = new Croupier();

        Assert.assertThat(croupier.giveHand(), instanceOf (Hand.class));
    }
}
