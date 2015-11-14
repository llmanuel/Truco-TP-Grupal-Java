package unit;

import model.Card;
import model.HumanPlayer;
import model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest {

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card6;
    Card card7;
    HumanPlayer humanPlayer;

    @Before
    public void setUp() throws Exception {
        card1 = new Card(7, "ESPADA", 7);
        card2 = new Card(2, "BASTO", 6);
        card3 = new Card(1, "COPA", 5);
        card4 = new Card(12, "ORO", 4);
        card5 = new Card(7, "BASTO", 3);
        card6 = new Card(6, "BASTO", 2);
        card7 = new Card(6, "ORO", 1);
    }

    @Test
    public void canInstatiateHumanPlayer(){
        humanPlayer = new HumanPlayer(1);
    }

    @Test
    public void aPlayerCanGiveHIsId(){
        humanPlayer = new HumanPlayer(1);
        Assert.assertEquals(1, humanPlayer.getIdNumber());
    }
}
