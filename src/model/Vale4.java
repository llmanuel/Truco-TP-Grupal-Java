package model;


import model.Exceptions.InvalidCallException;

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
