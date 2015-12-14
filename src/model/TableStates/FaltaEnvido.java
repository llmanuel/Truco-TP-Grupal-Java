package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;
import model.TableStates.Games;

/**
 * Created by manuel on 22/11/15.
 */
public class FaltaEnvido implements Games {
    private Table theTable;
    private boolean gameWasAccepted;

    public FaltaEnvido(Table theTable){

        this.theTable = theTable;
        this.gameWasAccepted = false;
    }

    @Override
    public int giveUpPoints(){

        return (1);
    }

    @Override
    public void giveUp() {
        this.nextRound();
        this.theTable.continueWithRound();
    }

    @Override
    public int getPoints() {
        return 0;
    }

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
        this.theTable.askNextPlayerOnTheTeam(theTable.getTeamCursor());
    }

    @Override
    public void acceptCall()  {
        try {
            this.theTable.theEnvidoGameWasAccepted();
        } catch (TeamDoesntExistException e) {}
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
