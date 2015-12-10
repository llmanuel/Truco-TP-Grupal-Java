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
    public int giveUpPoints(){

        return (1);
    }

    @Override
    public void giveUp() {
        this.theTable.beginNextGame();
    }

    @Override
    public void callTruco() throws InvalidGameCallException {
        this.theTable.raiseBet(new Truco(theTable, this.getPoints()));
    }

    @Override
    public void callReTruco() throws InvalidGameCallException {
        throw new InvalidGameCallException();
    }

    @Override
    public void callVale4() throws InvalidGameCallException {
        throw new InvalidGameCallException();
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
        throw new InvalidGameCallException();
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
