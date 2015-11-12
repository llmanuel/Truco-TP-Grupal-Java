package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Judge {
    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

    public boolean isFlor(Card... cards) {
        for (int i = 0; i <= cards.length; i++){
            if (cards[i].getSuit() != cards[i+1].getSuit())
                return false;
        }
        return false;
    }
}
