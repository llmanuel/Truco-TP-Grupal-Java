package model;

/**
 * Created by manuel on 22/11/15.
 */
public class NormalRound implements Games {
    int points = 1;
    private Table theTable;

    public void FaltaEnvido(Table theTable){

        this.theTable = theTable;
    }

    @Override
    public void raiseBet(){

//        this.theTable.raiseBet();
    }

    @Override
    public int getPoints(){
        return this.points;
    }

    @Override
    public void callEnvido(){

//        this.theTable.raiseBet();
    }

    @Override
    public void callRealEnvido(){

//        this.theTable.raiseBet();
    }

    @Override
    public void callFaltaEnvido(){

//        this.theTable.raiseBet();
    }
}
