package model;

import model.Exceptions.InvalidGameCallException;

public class Truco implements Games {
    int points = 2;
    private Table theTable;

    public Truco(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new ReTruco(theTable));
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
    public void callRealEnvido() throws InvalidGameCallException {

        throw new InvalidGameCallException();
    }

    @Override
    public void callFaltaEnvido() throws InvalidGameCallException {

        throw new InvalidGameCallException();
    }
}
