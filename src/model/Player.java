package model;


import model.Exceptions.*;

public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void setTable(Table table);
    void setHand(Hand newHand);
    void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException, TeamDoesntExistException, NotCardThrownException;
    void play() throws NotCardThrownException, DonTHaveThatCardException, TeamDoesntExistException, NotYourTurnException;
    void callEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException;
    void callRealEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException;
    void callFaltaEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException;
    void callTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException;
    void callReTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException;
    void callVale4() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException;
    void giveUp() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException;
    void callFlor() throws NotYourTurnException, TeamDoesntExistException, InvalidGameCallException;
    void acceptCall() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException;

    Hand getHand();

    Slot getSlot();
}

