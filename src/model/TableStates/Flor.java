package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;

/**
 * Created by manuel on 06/12/15.
 */
public class Flor implements Games {

    private Table theTable;
    int points;

    public Flor(Table theTable) {
        this.theTable = theTable;
        this.points = 3;
    }

    @Override
    public int giveUp(){return 0;}


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
        return false;
    }

    @Override
    public void nextRound() {
        this.theTable.nextRound(new LastsRound(theTable));
    }

    /*
    * Raises bet 2 points to another Envido. In this case, this method does the same thing that callEnvido
    */

    @Override
    public void raiseBet(){}

    @Override
    public void callTruco() throws InvalidGameCallException {
        throw new InvalidGameCallException();
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
}
