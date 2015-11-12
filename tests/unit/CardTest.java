package unit;

import model.Card;
import org.junit.*;

/**
 * Created by alexdebian on 11/11/15.
 */
public class CardTest {

    @Test
    public void canInstanciateCard(){
        Integer valor = 5;
        String palo = "testValue";
        Card card = new Card(valor, palo);
    }

}