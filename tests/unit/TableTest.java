package unit;


import model.*;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.TeamDoesntExistException;
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
    HumanPlayer firstPlayer;
    HumanPlayer secondPlayer;
    HumanPlayer thirdPlayer;
    HumanPlayer fourthPlayer;
    @Before
    public void setup(){
        firstPlayer = new HumanPlayer(1);
        secondPlayer = new HumanPlayer(2);
        thirdPlayer = new HumanPlayer(3);
        fourthPlayer = new HumanPlayer(4);
        HumanPlayer josh = new HumanPlayer(5);
        HumanPlayer robert = new HumanPlayer(6);

        TwoPlayers = new LinkedList<Player>();
        TwoPlayers.addLast(firstPlayer);
        TwoPlayers.addLast(secondPlayer);

        ThreePlayers = new LinkedList<Player>();
        ThreePlayers.addLast(firstPlayer);
        ThreePlayers.addLast(secondPlayer);
        ThreePlayers.addLast(thirdPlayer);


        FourPlayers = new LinkedList<Player>();
        FourPlayers.addLast(firstPlayer);
        FourPlayers.addLast(secondPlayer);
        FourPlayers.addLast(thirdPlayer);
        FourPlayers.addLast(fourthPlayer);

        SixPlayers = new LinkedList<Player>();
        SixPlayers.addLast(firstPlayer);
        SixPlayers.addLast(secondPlayer);
        SixPlayers.addLast(thirdPlayer);
        SixPlayers.addLast(fourthPlayer);
        SixPlayers.addLast(josh);
        SixPlayers.addLast(robert);
    }
    @Test
    public void canInstantiateTable(){
        table = new Table();
    }

    @Test
    public void buildATableWithTwoPlayers() throws InvalidNumberOfPlayersException {
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




    /*
     * Iteration between PLayers
     */

    @Test
    public void tableCanIterateAmongPlayersFromTheFirstPlayerInTheList() throws InvalidNumberOfPlayersException, TeamDoesntExistException, NotCardThrownException {
        table = new Table();
        table.letSitThese( FourPlayers );
        table.setGame();
        table.setRoundBeginner(firstPlayer);
        Assert.assertEquals(1,table.getActualPlayer().getIdNumber());
        int i = 2;
        while (i < 4){
            Assert.assertEquals(i,table.nextPlayer().getIdNumber());
            i = i + 1;
        }

    }

    @Test
    public void tableCanIterateAmongPlayersFromTheSecondPlayerInTheList() throws InvalidNumberOfPlayersException, TeamDoesntExistException, NotCardThrownException {
        table = new Table();
        table.letSitThese( FourPlayers );
        table.setGame();
        table.setRoundBeginner(secondPlayer);

        Assert.assertEquals(2,table.getActualPlayer().getIdNumber());
        Assert.assertEquals(3,table.nextPlayer().getIdNumber());
        Assert.assertEquals(4,table.nextPlayer().getIdNumber());
        Assert.assertEquals(1,table.nextPlayer().getIdNumber());
    }

    @Test
    public void tableCanIterateAmongPlayersFromTheThirdPlayerInTheList() throws InvalidNumberOfPlayersException, TeamDoesntExistException, NotCardThrownException {
        table = new Table();
        table.letSitThese( FourPlayers );
        table.setGame();
        table.setRoundBeginner(thirdPlayer);

        Assert.assertEquals(3,table.getActualPlayer().getIdNumber());
        Assert.assertEquals(4,table.nextPlayer().getIdNumber());
        Assert.assertEquals(1,table.nextPlayer().getIdNumber());
        Assert.assertEquals(2,table.nextPlayer().getIdNumber());
    }

    @Test
    public void tableCanIterateAmongPlayersFromTheFourthPlayerInTheList() throws InvalidNumberOfPlayersException, TeamDoesntExistException, NotCardThrownException {
        table = new Table();
        table.letSitThese( FourPlayers );
        table.setGame();
        table.setRoundBeginner(fourthPlayer);

        Assert.assertEquals(4,table.getActualPlayer().getIdNumber());
        Assert.assertEquals(1,table.nextPlayer().getIdNumber());
        Assert.assertEquals(2,table.nextPlayer().getIdNumber());
        Assert.assertEquals(3,table.nextPlayer().getIdNumber());
    }

    @Test
    public void tableGiveTheSlotsOfHumanPlayers() throws InvalidNumberOfPlayersException {

        table = new Table();
        LinkedList<Player> players = new LinkedList<>();
        CpuPlayer cpu = new CpuPlayer(1);
        HumanPlayer human = new HumanPlayer(2);
        cpu.setTable(table);
        human.setTable(table);
        players.add(cpu);
        players.add(human);
        table.letSitThese( players );
        table.setGame();



        Slot slotTest = table.getSlotsOfHumanPlayers();

        Assert.assertTrue(human.getIdNumber() == slotTest.getPlayer().getIdNumber());

    }

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
