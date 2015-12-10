package model.TableStates;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.TeamDoesntExistException;

public interface Games {

    int getPoints();
    int giveUpPoints();
    void giveUp();
    void callTruco() throws InvalidGameCallException;
    void callReTruco() throws InvalidGameCallException;
    void callVale4() throws InvalidGameCallException;
    void callEnvido() throws InvalidGameCallException;
    void callRealEnvido() throws InvalidGameCallException;
    void callFaltaEnvido() throws InvalidGameCallException;
    void callFlor() throws InvalidGameCallException, TeamDoesntExistException;
    void iDontWannaAnswer();
    void acceptCall() throws TeamDoesntExistException;
    boolean tellIfTheGameWasAccepted();
    void nextRound();

}
