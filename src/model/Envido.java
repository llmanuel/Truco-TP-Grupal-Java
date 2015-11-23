package model;

public class Envido implements Games {
    int points;
    private Table theTable;

    public Envido(Table theTable, int points){
        this.theTable = theTable;
        this.points = points;
    }

    /*
    * Raises bet 2 points to another Envido
    */

    @Override
    public void callEnvido(){

        this.theTable.raiseBet(new Envido(theTable ,this.getPoints() + 2));
    }

    @Override
    public void callRealEnvido(){

        this.theTable.raiseBet(new RealEnvido(theTable, 3));
    }

    @Override
    public void callFaltaEnvido(){

        this.theTable.raiseBet(new FaltaEnvido(theTable));
    }

    /*
    * Raises bet 2 points to another Envido. In this case, this method does the same thing that callEnvido
    */

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new Envido(theTable,this.getPoints() + 2));
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
