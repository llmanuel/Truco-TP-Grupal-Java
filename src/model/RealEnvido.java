package model;

import model.Exceptions.InvalidGameCallException;

public class RealEnvido implements Games {
    int points;
    private Table theTable;

    public RealEnvido(Table theTable, int points){
        this.theTable = theTable;
        this.points = points;
    }

    @Override
    public int giveUp(){

        return (this.getPoints() - 1);
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new RealEnvido(theTable, getPoints() + 3));
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
    public void callRealEnvido(){

        this.theTable.raiseBet(new RealEnvido(theTable, getPoints() + 3));
    }

    @Override
    public void callFaltaEnvido(){

        this.theTable.raiseBet(new FaltaEnvido(theTable));
    }
}
