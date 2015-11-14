package model;

/**
 * Created by manuel on 13/11/15.
 */
public class Slots {


    private Player player;
    private Card firstCard;
    private Card secondCard;
    private Card thirdCard;

    public Slots(Player player) {
        this.player = player;
    }


    public boolean receiveFirstCard(Card Card) {
        firstCard = Card;
        return true;
    }

    public boolean receiveSecondCard(Card Card) {
        secondCard = Card;
        return true;
    }

    public boolean receiveThirdCard(Card Card) {
        thirdCard = Card;
        return true;
    }

    public boolean isYourPlayer(Player myPlayer) {
        return (this.player.getIdNumber() == myPlayer.getIdNumber());
    }
}