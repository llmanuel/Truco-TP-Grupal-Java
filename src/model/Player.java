package model;


public interface Player {
    int calculateEnvido();
    int getIdNumber();
    void setSlot(Slot newSlot);
    void getHand(Hand newHand);
}
