package unit;

import model.Croupier;
import model.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

public class CroupierTest {

    private Croupier croupier;

    @Before
    public void setup(){
    	
         croupier = new Croupier();
    }


    @Test
    public void testCroupierCanGiveAHand(){

        Assert.assertThat( croupier.giveHand(), instanceOf( Hand.class ) );
    }

}
