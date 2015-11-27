package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;

/**
 * Created by manuel on 23/11/15.
 */
public class LastsRound implements Games {
    int points = 1;
    private Table theTable;

    public LastsRound(Table theTable){

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
    public void iDontWannaAnswer() {

    }

    @Override
    public void nextRound() {

        theTable.beginNextGame();
        this.theTable.raiseBet(new LastsRound(theTable));
    }
}
