package model;


public class Vale4 implements Games {
    int points = 4;
    private Table theTable;

    public void Vale4(Table theTable){
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
