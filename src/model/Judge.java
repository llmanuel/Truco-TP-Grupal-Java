package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Judge {
    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

    public boolean isFlor(Card... cards) {
        String suit = cards[0].getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit))
                return false;
        }
        return true;
    }
}
