package model.TableStates;

import model.Exceptions.TeamDoesntExistException;
import model.Table;

public class Envido implements Games {
    int points;
    private int lastGamePoints;
    private Table theTable;
    private boolean gameWasAccepted;

    public Envido(Table theTable, int points, int lastGamePoints){
        this.theTable = theTable;
        this.points = points;
        this.lastGamePoints = lastGamePoints;
        this.gameWasAccepted = false;
    }

    @Override
    public int giveUp(){

        return (this.lastGamePoints);
    }

    /*
    * Raises bet 2 points to another Envido
    */

    @Override
    public void callEnvido(){

        this.theTable.raiseBet(new Envido(theTable ,this.getPoints() + 2, this.getPoints()));
    }

    @Override
    public void callRealEnvido(){

        this.theTable.raiseBet(new RealEnvido(theTable, 3, this.getPoints()));
    }

    @Override
    public void callFaltaEnvido(){

        this.theTable.raiseBet(new FaltaEnvido(theTable));
    }

    @Override
    public void callFlor() {

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

    /*
    * Raises bet 2 points to another Envido. In this case, this method does the same thing that callEnvido
    */

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new Envido(theTable,this.getPoints() + 2, this.getPoints()));
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
