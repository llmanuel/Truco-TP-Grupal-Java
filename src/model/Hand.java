package model;

import model.Exceptions.DonTHaveThatCardException;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hand {
    /* We call Hand to the three cards that a player possess */
    private LinkedList<Card> cards;

    public Hand(LinkedList<Card> cards) {
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

    public int calculateEnvido() {
        if (allSuitsAreDifferent()){
            return (maxCardNumber());
        }else{
            return getEnvidoFrom(getCardsOfTheSameSuit());
        }
    }

    private boolean allSuitsAreDifferent() {
        ArrayList<String> suits = new ArrayList<String>();
        for (Card card : cards) {
            if (!suits.contains(card.getSuit()))
                suits.add(card.getSuit());
        }
        return (cards.size() == suits.size());
    }

    private int maxCardNumber() {
        int searchedMax = 0;
        for (Card card : cards) {
            if (card.getNumber() > searchedMax)
                searchedMax = card.getNumber();
        }
        return searchedMax;
    }

    private LinkedList<Card> getCardsOfTheSameSuit() {
        LinkedList<Card> cardsOfTheSameSuit = new LinkedList<Card>();
        for (Card card : cards) {
            if (card.getSuit().equals(getMostRepeatedSuit())) {
                cardsOfTheSameSuit.add(card);
            }
        }
        return new LinkedList(cardsOfTheSameSuit);
    }

    private String getMostRepeatedSuit() {
        /*se presupone que por lo menos dos cartas son del mismo palo*/
        String posibleFirstSuit = cards.getFirst().getSuit();
        String posibleSecondSuit = cards.getLast().getSuit();
        int timesFirstSuit = 0;
        int timesSecondSuit = 0;
        for (Card actualCard: cards){
            if(actualCard.getSuit() == posibleFirstSuit) timesFirstSuit += 1;
            else {
                timesSecondSuit += 1;
                posibleSecondSuit = actualCard.getSuit();
            }
        }
        if(timesFirstSuit > timesSecondSuit){
            return posibleFirstSuit;
        }else{
            return posibleSecondSuit;
        }
    }

    private Integer getEnvidoFrom(LinkedList<Card> cards) {
        int sumatoriaEnvido = 20;
        for (Card card : cards) {
            if (card.getNumber() < 10) {
                sumatoriaEnvido += card.getNumber();
            }
        }
        return sumatoriaEnvido;
    }

    public Card getCard(Card cardToPlay) throws DonTHaveThatCardException {

        if(cards.indexOf( cardToPlay ) != -1) {
            Card cardToReturn = this.cards.get(cards.indexOf( cardToPlay ));
            this.cards.remove(cards.indexOf(cardToPlay));
            return cardToReturn;
        }
        else throw new DonTHaveThatCardException();

    }

    public LinkedList<Card> getCards() {
        return this.cards;
    }
}
