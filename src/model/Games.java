package model;

import model.Exceptions.InvalidCallException;

public interface Games {

    int getPoints();
    void raiseBet();
    void callEnvido() throws InvalidCallException;
    void callRealEnvido() throws InvalidCallException;
    void callFaltaEnvido() throws InvalidCallException;
}
