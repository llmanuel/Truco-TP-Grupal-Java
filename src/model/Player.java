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

    void callEnvido();
    void callRealEnvido();
    void callFaltaEnvido();
    void callTruco();
    void callReTruco();
    void callVale4();
    void giveUp();
    void callFlor();

    Hand getHand();
}

