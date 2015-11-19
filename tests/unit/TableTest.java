package unit;


import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.instanceOf;


public class TableTest {

    Table table;
    LinkedList<Player> TwoPlayers;
    LinkedList<Player> ThreePlayers;
    LinkedList<Player> FourPlayers;
    LinkedList<Player> SixPlayers;
    @Before
    public void setup(){
        HumanPlayer myPLayer = new HumanPlayer(1);
        HumanPlayer otherPLayer = new HumanPlayer(2);
        HumanPlayer charles = new HumanPlayer(3);
        HumanPlayer nick = new HumanPlayer(4);
        HumanPlayer josh = new HumanPlayer(5);
        HumanPlayer robert = new HumanPlayer(6);

        TwoPlayers = new LinkedList<Player>();
        TwoPlayers.add(myPLayer);
        TwoPlayers.add(otherPLayer);

        ThreePlayers = new LinkedList<Player>();
        ThreePlayers.add(myPLayer);
        ThreePlayers.add(otherPLayer);
        ThreePlayers.add(charles);


        FourPlayers = new LinkedList<Player>();
        FourPlayers.add(myPLayer);
        FourPlayers.add(otherPLayer);
        FourPlayers.add(charles);
        FourPlayers.add(nick);

        SixPlayers = new LinkedList<Player>();
        SixPlayers.add(myPLayer);
        SixPlayers.add(otherPLayer);
        SixPlayers.add(charles);
        SixPlayers.add(nick);
        SixPlayers.add(josh);
        SixPlayers.add(robert);
    }
    @Test
    public void canInstantiateTable(){
        table = new Table();
    }

    @Test
    public void buildATableWithTwoPlayers() throws InvalidNumberOfPlayersException{
        table = new Table();
        table.letSitThese(TwoPlayers);
        Assert.assertEquals(2,table.getNumberOfPlayers());
    }

    @Test
    public void aTableWithFourPlayers() throws InvalidNumberOfPlayersException{
        table = new Table();
        table.letSitThese(FourPlayers);
        Assert.assertEquals(4,table.getNumberOfPlayers());
    }

    @Test
    public void aTableWithSixPlayers() throws InvalidNumberOfPlayersException{
        table = new Table();
        table.letSitThese(SixPlayers);
        Assert.assertEquals(6,table.getNumberOfPlayers());
    }

    @Test (expected = InvalidNumberOfPlayersException.class)
    public void aTableCantHaveANotPairNumber() throws InvalidNumberOfPlayersException{

        table = new Table();
        table.letSitThese(ThreePlayers);
    }

    @Test
    public void tableRuturnsSlotsCorrectly() throws InvalidNumberOfPlayersException {
        table = new Table();
        table.letSitThese( FourPlayers );
        table.setGame();
        Assert.assertThat( table.getSlots(), instanceOf( LinkedList.class  ));


    }

//    @Test
//    public void aTableCanReceiveACardOnlyFromAPlayer() throws InvalidNumberOfPlayersException, InvalidSuiteException, InvalidCardNumberException {
//        table = new Table();
//        table.letSitThese(TwoPlayers);
//        Card myCard = new Card( 1, "Espada", 14);
//        table.receiveCard(myCard);
//    }

//    @Test
//    public void theTablesSetsTheGame() throws InvalidNumberOfPlayersException{
//        table = new Table();
//        table.setGame();
//    }
}