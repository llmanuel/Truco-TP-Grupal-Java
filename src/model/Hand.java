package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hand {
    /*Se llama hand a las tres cartas que posee el jugador*/
    private LinkedList<Card> cards;

    public Hand(LinkedList<Card> cards) {
        
        this.cards = cards;
    }
}
