package integration;

import model.*;
import model.Exceptions.DonTHaveThatCardException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerAndSlotTest {
    Player player;
    Slot slot;
    Croupier croupier;


    @Before
    public void setup(){
        this.croupier = new Croupier();

        this.player = new HumanPlayer( 1 );

        this.slot = new Slot( this.player );
        this.player.setSlot( this.slot );

        this.player.setHand( this.croupier.giveHand() );

    }

    /*Players Must have a Table to play*/
    @Test
    public void playerCanPlayACertainCard() throws NotCardThrownException, NotYourTurnException, TeamDoesntExistException, DonTHaveThatCardException {
        Card cardToPlay = this.player.getHand().getCards().getFirst();
        this.player.itsYourTurn();
        this.player.playCard( cardToPlay );

        Assert.assertTrue( this.slot.getLastOne() == cardToPlay);
    }


}
