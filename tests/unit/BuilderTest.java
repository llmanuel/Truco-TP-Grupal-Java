package unit;

import model.Builder;
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
        }catch (Exception e){
            exceptionNotThrown = false;
        }
        Assert.assertTrue(exceptionNotThrown);
    }
}
