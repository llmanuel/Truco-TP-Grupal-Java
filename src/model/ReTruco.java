package model;

public class ReTruco implements Games {
    int points = 3;
    private Table theTable;

    public void ReTruco(Table theTable){
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
