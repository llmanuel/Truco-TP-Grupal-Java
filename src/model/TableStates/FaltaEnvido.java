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
    public int giveUp(){

        return (this.getPoints() - 1);
    }

    @Override
    public int getPoints() {
        //TODO terminar de pensar como manejar puntos del falta envido
        return 0;
    }

    @Override
    public void raiseBet() throws InvalidGameCallException {
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
    public void iDontWannaAnswer() {
        this.theTable.askNextPlayerOnTheTeam(theTable.getTeamCursor());
    }

    @Override
    public void acceptCall() throws TeamDoesntExistException {
        this.theTable.theEnvidoGameWasAccepted();
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
