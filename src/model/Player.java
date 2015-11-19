package model;


public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void setHand(Hand newHand);
    void playCard(Card cardToPlay);
}
