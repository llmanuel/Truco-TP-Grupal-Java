package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Table;
import model.TableStates.Games;

/**
 * Created by manuel on 22/11/15.
 */
public class FaltaEnvido implements Games {
    private Table theTable;

    public FaltaEnvido(Table theTable){

        this.theTable = theTable;
    }

    @Override
    public int giveUp(){

        return (this.getPoints() - 1);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public void raiseBet() throws InvalidGameCallException {
        throw new InvalidGameCallException();
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
