package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;

/**
 * Created by manuel on 26/11/15.
 */
public class SecondRound implements Games {
    private Table theTable;
    private int points;

    public SecondRound(Table theTable) {
        this.theTable = theTable;
    }
    @Override
    public int giveUp(){

        return (1);
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new Truco(theTable, this.getPoints()));
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

    @Override
    public void nextRound() {

        this.theTable.raiseBet(new LastsRound(theTable));
    }
}
