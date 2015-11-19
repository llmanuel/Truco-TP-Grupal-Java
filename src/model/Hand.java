package model;

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
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getNumber() > searchedMax)
                searchedMax = cards.get(i).getNumber();
        }
        return searchedMax;
    }

    private LinkedList getCardsOfTheSameSuit() {
        LinkedList<Card> cardsOfTheSameSuit = new LinkedList<Card>();
        for (int i = 0 ; i< cards.size(); i++){
            if (cards.get(i).getSuit() == getMostRepeatedSuit()){
                cardsOfTheSameSuit.add(cards.get(i));
            }
        }
        LinkedList handOfCardsWithTheSameSuit = new LinkedList(cardsOfTheSameSuit);
        return handOfCardsWithTheSameSuit;
    }

    private String getMostRepeatedSuit() {
        /*se presupone que por lo menos dos cartas son del mismo palo*/
        if(cards.get(0).getSuit() == cards.get(1).getSuit()){
            return cards.get(0).getSuit();
        }else{
            return cards.get(1).getSuit();
        }
    }

    private Integer getEnvidoFrom(LinkedList<Card> cards) {
        int sumatoriaEnvido = 20;
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(i).getNumber() < 10){
                sumatoriaEnvido += cards.get(i).getNumber();
            }
        }
        return sumatoriaEnvido;
    }

    public Card getCard(Card cardToPlay) {
        Card cardToReturn =  this.cards.get( cards.indexOf( cardToPlay ) );
        this.cards.remove( cards.indexOf( cardToPlay ) );
        return cardToReturn;
    }
}
