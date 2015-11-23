package model;

import model.Exceptions.InvalidGameCallException;

public interface Games {

    int getPoints();
    void raiseBet();
    void callEnvido() throws InvalidGameCallException;
    void callRealEnvido() throws InvalidGameCallException;
    void callFaltaEnvido() throws InvalidGameCallException;
}
