package model;

public class Envido implements Games {
    int points = 2;
    private Table theTable;

    public Envido(Table theTable){
        this.theTable = theTable;
    }

    public void raiseToRealEnvido(){
//            this.theTable.raiseToRealEnvido();
    }

    /*
    * Raises bet 2 points to another Envido
    */

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

    @Override
    public void raiseBet(){

//        this.theTable.raiseBet();
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
