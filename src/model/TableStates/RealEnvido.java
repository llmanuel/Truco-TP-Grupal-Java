package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;

public class RealEnvido implements Games {
    int points;
    private int lastGamePoints;
    private Table theTable;

    public RealEnvido(Table theTable, int points, int lastGamePoints){
        this.theTable = theTable;
        this.points = points;
        this.lastGamePoints = lastGamePoints;
    }

    @Override
    public int giveUp(){

        return (this.lastGamePoints);
    }

    @Override
    public void raiseBet(){

        this.theTable.raiseBet(new RealEnvido(theTable, getPoints() + 3, this.getPoints()));
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

        this.theTable.raiseBet(new RealEnvido(theTable, getPoints() + 3, this.getPoints()));
    }

    @Override
    public void callFaltaEnvido(){

        this.theTable.raiseBet(new FaltaEnvido(theTable));
    }
}
