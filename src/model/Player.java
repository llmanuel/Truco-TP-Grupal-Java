package model;


import model.Exceptions.DonTHaveThatCardException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;

public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void sitOnTable(Table table);
    void setHand(Hand newHand);
    void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException, TeamDoesntExistException, NotCardThrownException;
    void itsYourTurn();
    void turnFinished();

    void callEnvido() throws NotYourTurnException;
    void callRealEnvido() throws NotYourTurnException;
    void callFaltaEnvido() throws NotYourTurnException;
    void callTruco() throws NotYourTurnException;
    void callReTruco() throws NotYourTurnException;
    void callVale4() throws NotYourTurnException;
    void giveUp() throws NotYourTurnException;
    void callFlor();
    void acceptCall() throws NotYourTurnException;

    Hand getHand();
}

