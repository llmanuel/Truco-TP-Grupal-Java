package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;

public class Truco implements Games {
    int points = 2;
    private Table theTable;
    private int lastGamePoints;

    public Truco(Table theTable, int lastGamePoints){
        this.theTable = theTable;
        this.lastGamePoints = lastGamePoints;
    }

    @Override
    public int giveUp(){

        return (this.lastGamePoints);
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new ReTruco( theTable, this.getPoints()));
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
    public void acceptCall() {
        this.theTable.getActualPlayer().itsYourTurn();
    }

    @Override
    public void nextRound() {

    }
}
