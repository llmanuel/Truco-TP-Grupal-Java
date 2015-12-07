package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;

/**
 * Created by manuel on 23/11/15.
 */
public class LastsRound implements Games {
    int points = 1;
    private Table theTable;
    private boolean gameWasAccepted;

    public LastsRound(Table theTable){

        this.theTable = theTable;
        gameWasAccepted = true;
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
    public void callFlor() throws InvalidGameCallException {

    }

    @Override
    public void iDontWannaAnswer() {

    }

    @Override
    public void acceptCall() throws TeamDoesntExistException {

    }

    @Override
    public boolean tellIfTheGameWasAccepted() {
        return this.gameWasAccepted;
    }

    @Override
    public void nextRound() {

        this.theTable.nextRound(new LastsRound(theTable));
    }
}
