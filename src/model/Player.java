package model;


import model.Exceptions.DonTHaveThatCardException;
import model.Exceptions.NotYourTurnException;

public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void sitOnTable(Table table);
    void setHand(Hand newHand);
    void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException;
    void itsYourTurn();
    void turnFinished();
    Hand getHand();
}

