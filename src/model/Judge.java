package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Judge {
    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue())>(cardB.getValue());
    }

}
