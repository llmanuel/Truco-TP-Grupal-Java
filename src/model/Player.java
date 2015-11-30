package model;


import model.Exceptions.DonTHaveThatCardException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;

public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void setTable(Table table);
    void setHand(Hand newHand);
    void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException, TeamDoesntExistException, NotCardThrownException;
    void itsYourTurn();
    void turnFinished();

    void callEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callRealEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callFaltaEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callReTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callVale4() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void giveUp() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callFlor();
    void acceptCall() throws NotYourTurnException, NotCardThrownException;

    Hand getHand();
}

