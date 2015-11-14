package model;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Hand {
    /*Se llama hand a las tres cartas que posee el jugador*/
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
//        return cards.size() == getNumberOfCardsWithSameSuit();
    }

    public int calculateEnvido() {
        if (allSuitsAreDifferent()){
            return (maxCardNumber());
        }else{
           return getEnvidoFrom(getCardsOfTheSameSuit());
        }
//        Hashtable<String, Integer> envidoDictionary = new Hashtable<String, Integer>();
//        for (int i = 0; i < cards.size(); i++){
//            if (envidoDictionary.containsKey(cards.get(i).getSuit())){
//                if (envidoDictionary.get(cards.get(i).getSuit()) <= 21){
//                    envidoDictionary.put(cards.get(i).getSuit(), envidoDictionary.get(cards.get(i).getSuit()) + 20);
////                    Integer valorViejo = envidoDictionary.get(cards.get(i).getSuit());
////                    envidoDictionary.put(cards.get(i).getSuit(), valorViejo += 20);
//                    if (cards.get(i).getNumber() < 10){
//                        envidoDictionary.put(cards.get(i).getSuit(), envidoDictionary.get(cards.get(i).getSuit()) + 20);
////                        Integer valorViejo = envidoDictionary.get(cards.get(i).getSuit());
////                        envidoDictionary.put(cards.get(i).getSuit(), valorViejo += 20);
//                    }
//                }
//            }
//        }
//        return 0;
    }

//    public Integer getNumberOfCardsWithSameSuit() {
//        if(cards.get(1))
//        int numberOfCardsWithSameSuit = 1;
//        String suit = cards.get(0).getSuit();
//        for (Card card : cards) {
//            if (card.getSuit().equals(card.))
//                numberOfCardsWithSameSuit++;
//        }
//        return numberOfCardsWithSameSuit;
//    }

    public boolean allSuitsAreDifferent() {
        ArrayList<String> suits = new ArrayList<String>();
        for (Card card : cards) {
            if (!suits.contains(card.getSuit()))
                suits.add(card.getSuit());
        }
        return (cards.size() == suits.size());
    }

    public int maxCardNumber() {
        int searchedMax = 0;
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getNumber() > searchedMax)
                searchedMax = cards.get(i).getNumber();
        }
        return searchedMax;
    }

    public LinkedList getCardsOfTheSameSuit() {
        LinkedList<Card> cardsOfTheSameSuit = new LinkedList<Card>();
        for (int i = 0 ; i< cards.size(); i++){
            if (cards.get(i).getSuit() == getMostRepeatedSuit()){
                cardsOfTheSameSuit.add(cards.get(i));
            }
        }
        LinkedList handOfCardsWithTheSameSuit = new LinkedList(cardsOfTheSameSuit);
        return handOfCardsWithTheSameSuit;
    }

    public String getMostRepeatedSuit() {
        /*se presupone que por lo menos dos cartas son del mismo palo*/
        if(cards.get(0).getSuit() == cards.get(1).getSuit()){
            return cards.get(0).getSuit();
        }else{
            return cards.get(1).getSuit();
        }
    }

    public Integer getEnvidoFrom(LinkedList<Card> cards) {
        int sumatoriaEnvido = 20;
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(i).getNumber() < 10){
                sumatoriaEnvido += cards.get(i).getNumber();
            }
        }
        return sumatoriaEnvido;
    }
}
