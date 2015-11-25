import model.*;
import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerAndSlotTest {
    Player player;
    Slot slot;
    Croupier croupier;


    @Before
    public void setup() throws InvalidSuiteException, InvalidCardNumberException {
        this.croupier = new Croupier();

        this.player = new HumanPlayer( 1 );

        this.slot = new Slot( this.player );
        this.player.setSlot( this.slot );

        this.player.setHand( this.croupier.giveHand() );
    }

    @Test
    public void playerCanPlayACertainCard() throws NotCardThrownException, NotYourTurnException {
        Card cardToPlay = this.player.getHand().getCards().getFirst();
        this.player.itsYourTurn();
        this.player.playCard( cardToPlay );

        Assert.assertTrue( this.slot.getLastOne() == cardToPlay);
    }


}
