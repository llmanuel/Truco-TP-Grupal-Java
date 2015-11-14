package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    /*Se llama hand a las tres cartas que posee el jugador*/
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public boolean isFlor() {
        String suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit))
                return false;
        }
        return true;
    }
}
