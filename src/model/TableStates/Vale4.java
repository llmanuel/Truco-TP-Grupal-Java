package model.TableStates;


import model.Exceptions.InvalidGameCallException;
import model.Exceptions.NothingToAcceptException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;

public class Vale4 implements Games {
    int points;
    private Table theTable;
    private int lastGamePoints;
    private boolean gameWasAccepted;

    public Vale4(Table theTable, int lastGamePoints){

        this.points = 4;
        this.theTable = theTable;
        this.lastGamePoints = lastGamePoints;
        this.gameWasAccepted = false;
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
        this.theTable.askNextPlayerOnTheTeam(theTable.getTeamCursor());
    }

    @Override
    public void acceptCall() throws NothingToAcceptException {
        if(this.gameWasAccepted){throw new NothingToAcceptException();}
        else {
            this.gameWasAccepted = true;
            this.theTable.continueWithRound();
        }
    }

    @Override
    public boolean tellIfTheGameWasAccepted() {
        return this.gameWasAccepted;
    }

    @Override
    public void nextRound() {

    }
}
