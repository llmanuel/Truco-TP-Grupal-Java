package model;

/**
 * Created by manuel on 22/11/15.
 */
public class FaltaEnvido implements Games {
    private Table theTable;

    public FaltaEnvido(Table theTable){

        this.theTable = theTable;
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public void raiseBet() {

    }

    @Override
    public void callEnvido() {

    }

    @Override
    public void callRealEnvido() {

    }

    @Override
    public void callFaltaEnvido() {

    }
}
