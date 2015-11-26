package model.TableStates;

import model.Table;

/**
 * Created by manuel on 23/11/15.
 */
public class LastsRounds implements Games {
    int points = 1;
    private Table theTable;

    public LastsRounds(Table theTable){

        this.theTable = theTable;
    }

    @Override
    public int giveUp(){

        return (1);
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
    public void nextRound() {

    }
}
