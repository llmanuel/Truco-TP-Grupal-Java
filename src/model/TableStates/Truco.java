package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;
import model.Team;

public class Truco implements Games {
    int points = 2;
    private Table theTable;
    private int lastGamePoints;
    private boolean gameWasAccepted;
    private Team teamThatMadeTheCall;


    public Truco(Table theTable, int lastGamePoints){
        this.theTable = theTable;
        this.lastGamePoints = lastGamePoints;
        this.gameWasAccepted = false;
        this.teamThatMadeTheCall = this.theTable.getTeamOfActualPlayer();
    }

    @Override
    public int giveUpPoints(){

        return (this.lastGamePoints);
    }

    @Override
    public void giveUp() {
        this.theTable.beginNextGame();
    }

    @Override
    public void callTruco() throws InvalidGameCallException {
        throw new InvalidGameCallException();
    }

    @Override
    public void callReTruco() throws InvalidGameCallException {
        if (this.teamThatMadeTheCall != this.theTable.getTeamOfActualPlayer())
        this.theTable.raiseBet(new ReTruco( theTable, this.getPoints()));
        else throw new InvalidGameCallException();
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
        this.theTable.askNextPlayerOnTheTeam(theTable.getTeamCursor());
    }

    @Override
    public void acceptCall() {
        this.gameWasAccepted = true;
        this.theTable.continueWithRound();
    }

    @Override
    public boolean tellIfTheGameWasAccepted() {
        return this.gameWasAccepted;
    }

    @Override
    public void nextRound() {

    }
}
