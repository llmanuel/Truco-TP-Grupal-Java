package model;

import model.Exceptions.InvalidCardNumberException;
import model.Exceptions.InvalidSuiteException;

import java.util.LinkedList;


public class Croupier {
    private Deck deck;

    public Hand giveHand() throws InvalidSuiteException, InvalidCardNumberException {
        LinkedList<Card> newCards = new LinkedList<Card>();

        newCards.add(deck.getCard());
        newCards.add(deck.getCard());
        newCards.add(deck.getCard());

        Hand newHand = new Hand( newCards );

        return newHand;

    }

    private void initializeDeck() throws InvalidSuiteException, InvalidCardNumberException {
        this.deck = new Deck();
    }

    public void prepareForNewRound() throws InvalidSuiteException, InvalidCardNumberException {

        this.initializeDeck();
    }
}
