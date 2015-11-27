package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;

public class ReTruco implements Games {
    int points = 3;
    private Table theTable;
    private int lastGamePoints;
    private boolean gameWasAccepted;

    public ReTruco(Table theTable, int lastGamePoints){
        this.theTable = theTable;
        this.lastGamePoints = lastGamePoints;
        this.gameWasAccepted = false;
    }

    @Override
    public int giveUp(){

        return (this.lastGamePoints);
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new Vale4(theTable, this.getPoints()));
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
        this.theTable.askNextPlayerOnTheTeam(theTable.getTeamCursor());
    }

    @Override
    public void acceptCall() throws TeamDoesntExistException {
        this.gameWasAccepted = true;
        this.theTable.getActualPlayer().itsYourTurn();
    }

    @Override
    public boolean tellIfTheGameWasAccepted() {
        return this.gameWasAccepted;
    }

    @Override
    public void nextRound() {

    }
}
