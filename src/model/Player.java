package model;


import model.Exceptions.NotYourTurnException;

public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void setHand(Hand newHand);
    void playCard(Card cardToPlay) throws NotYourTurnException;
    void itsYourTurn();
    void turnFinished();
    Hand getHand();
}

