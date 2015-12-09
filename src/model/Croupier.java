package model;

import java.util.LinkedList;


public class Croupier {
    private Deck deck;

    public Croupier() {
        this.initializeDeck();
    }

    public Hand giveHand(){
        LinkedList<Card> newCards = new LinkedList<Card>();

        newCards.add(deck.getCard());
        newCards.add(deck.getCard());
        newCards.add(deck.getCard());

        Hand newHand = new Hand( newCards );

        return newHand;

    }

    private void initializeDeck() {
        this.deck = new Deck();
    }

    public void prepareForNewRound() {
        this.initializeDeck();
    }
}
