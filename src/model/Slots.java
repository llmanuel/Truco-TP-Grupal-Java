package model;

import kotlin.properties.NULL_VALUE;

/**
 * Created by manuel on 13/11/15.
 */
public class Slots {


    private Player player;
    private CardSpot firstCard;
    private CardSpot secondCard;
    private CardSpot thirdCard;

    public Slots(Player player) {
        this.player = player;
    }

    public boolean receiveFirstCard(Card card) {
        firstCard = new CardSpot(card);
        return true;
    }

    public boolean receiveSecondCard(Card card) {
        secondCard = new CardSpot(card);
        return true;
    }

    public boolean receiveThirdCard(Card card) {
        thirdCard = new CardSpot(card);
        return true;
    }

    public boolean isYourPlayer(Player myPlayer) {
        return (this.player.getIdNumber() == myPlayer.getIdNumber());
    }

    public Card getFirstOne() {
        return firstCard.getCard();
    }

    public Card getSecondOne() {
        return secondCard.getCard();
    }

    public Card getThirdOne() {
        return thirdCard.getCard();
    }

    public void throwCards() {

        this.firstCard.throwCard();
        this.secondCard.throwCard();
        this.thirdCard.throwCard();
    }
}