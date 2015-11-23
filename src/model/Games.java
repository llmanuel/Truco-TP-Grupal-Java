package model;

import model.Exceptions.InvalidGameCallException;

public interface Games {

    int getPoints();
    void raiseBet() throws InvalidGameCallException;
    void callEnvido() throws InvalidGameCallException;
    void callRealEnvido() throws InvalidGameCallException;
    void callFaltaEnvido() throws InvalidGameCallException;
}
