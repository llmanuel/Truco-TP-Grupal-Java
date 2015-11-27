package model.TableStates;

import model.Exceptions.InvalidGameCallException;

public interface Games {

    int getPoints();
    int giveUp();
    void raiseBet() throws InvalidGameCallException;
    void callEnvido() throws InvalidGameCallException;
    void callRealEnvido() throws InvalidGameCallException;
    void callFaltaEnvido() throws InvalidGameCallException;
    void iDontWannaAnswer();
    void nextRound();
}
