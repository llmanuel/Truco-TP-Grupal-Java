package model.TableStates;

import model.Exceptions.TeamDoesntExistException;
import model.Table;
import model.TableStates.*;

/**
 * Created by manuel on 22/11/15.
 */
public class NormalRound implements Games {
    int points = 1;
    private Table theTable;

    public NormalRound(Table theTable){

        this.theTable = theTable;
        this.theTable.handOut();
        this.theTable.increaseRoundCounter();
    }

    @Override
    public int giveUp(){

        return (2);
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
    public void callEnvido(){

        this.theTable.raiseBet(new Envido( theTable, 2 , this.getPoints()));
    }

    @Override
    public void callRealEnvido(){

        this.theTable.raiseBet(new RealEnvido( theTable, 3 , this.getPoints()));
    }

    @Override
    public void callFaltaEnvido(){

        this.theTable.raiseBet(new FaltaEnvido(theTable));
    }

    @Override
    public void iDontWannaAnswer() {

    }

    @Override
    public void acceptCall() throws TeamDoesntExistException {

    }

    @Override
    public void nextRound() {

        this.theTable.increaseRoundCounter();
        this.theTable.nextRound(new LastsRound(theTable));
    }
}
