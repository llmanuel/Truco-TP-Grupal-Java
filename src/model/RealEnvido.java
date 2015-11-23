package model;

public class RealEnvido implements Games {
    int points = 3;
    private Table theTable;

    public RealEnvido(Table theTable){
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
