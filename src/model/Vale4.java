package model;


import model.Exceptions.InvalidGameCallException;

public class Vale4 implements Games {
    int points = 4;
    private Table theTable;

    public Vale4(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public int giveUp(){

        return (this.getPoints() - 1);
    }

    @Override
    public void raiseBet() throws InvalidGameCallException {

       throw new InvalidGameCallException();
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
