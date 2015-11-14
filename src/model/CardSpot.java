package model;

/**
 * Created by manuel on 14/11/15.
 */
public class CardSpot {

    private Card theCard;
    private boolean throwable;
    public CardSpot(Card card) {

        theCard = card;
        throwable = false;
    }

    public Card getCard() {
        return theCard;
    }

    public void throwCard() {
        throwable = true;
    }
}
