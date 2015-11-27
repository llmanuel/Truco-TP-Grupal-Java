package unit;

import model.Builder;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.PlayerDoesNotExistsException;
import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {
    @Test
    public void canInstantiateBuilder(){
        boolean exceptionNotThrown = true;
        try {
            Builder builderWith2Players = new Builder(2);
            Builder builderWith4Players = new Builder(4);
            Builder builderWith6Players = new Builder(6);
        }catch (InvalidNumberOfPlayersException e){
            exceptionNotThrown = false;
        }
        Assert.assertTrue(exceptionNotThrown);
    }

    @Test (expected = InvalidNumberOfPlayersException.class)
    public void getErrorWhenTryToInvokeBuilderWithWrongNumberOfPlayers() throws InvalidNumberOfPlayersException {
        Builder b = new Builder(5);
    }


    @Test
    public void canSetPlayersCorrectly() throws InvalidNumberOfPlayersException {

        Builder builderWith4Players = new Builder(4);
        Assert.assertEquals(1,builderWith4Players.getPlayers().get(0).getIdNumber());
        Assert.assertEquals(4,builderWith4Players.getPlayers().get(3).getIdNumber());

    }

    @Test
    public void canSetTeamsCorrectly() throws InvalidNumberOfPlayersException, PlayerDoesNotExistsException {

        Builder builderWith4Players = new Builder(4);

        Assert.assertEquals(1,builderWith4Players.getTeams().get(0).getMember(1).getIdNumber());
        Assert.assertEquals(3,builderWith4Players.getTeams().get(0).getMember(3).getIdNumber());
        Assert.assertEquals(2,builderWith4Players.getTeams().get(1).getMember(2).getIdNumber());
        Assert.assertEquals(4,builderWith4Players.getTeams().get(1).getMember(4).getIdNumber());

    }
}
