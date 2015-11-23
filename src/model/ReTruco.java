package model;

import model.Exceptions.InvalidCallException;

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
    public void callEnvido() throws InvalidCallException {

        throw new InvalidCallException();
    }

    @Override
    public void callRealEnvido() throws InvalidCallException {

        throw new InvalidCallException();
    }

    @Override
    public void callFaltaEnvido() throws InvalidCallException {

        throw new InvalidCallException();
    }
}
