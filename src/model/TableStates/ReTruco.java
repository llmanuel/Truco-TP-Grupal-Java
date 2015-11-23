package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;

public class ReTruco implements Games {
    int points = 3;
    private Table theTable;

    public ReTruco(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public int giveUp(){

        return (this.getPoints() - 1);
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new Vale4(theTable));
    }

    @Override
    public int getPoints(){
        return this.points;
    }

    @Override
    public void callEnvido() throws InvalidGameCallException {

        throw new InvalidGameCallException();
    }

    @Override
    public void callRealEnvido() throws InvalidGameCallException {

        throw new InvalidGameCallException();
    }

    @Override
    public void callFaltaEnvido() throws InvalidGameCallException {

        throw new InvalidGameCallException();
    }
}
