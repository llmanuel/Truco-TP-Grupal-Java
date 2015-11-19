package model;


import model.Exceptions.NotCardThrownException;

import java.util.LinkedList;

/**
 * Created by manuel on 13/11/15.
 */
public class Slot {
    private Player player;
    private LinkedList<Card> cards;

    public Slot(Player player) {
        this.player = player;
        cards = new LinkedList<Card>();
    }

    public boolean receiveCard(Card newCard) {
        this.cards.addLast(newCard);
        return true;
    }

    public boolean isYourPlayer(Player myPlayer) {
        return (this.player.getIdNumber() == myPlayer.getIdNumber());
    }

    public Card getFirstOne() throws NotCardThrownException {

        if(!cards.isEmpty())
            return (cards.getFirst());
        else throw new NotCardThrownException();
    }

    public Card getSecondOne() throws NotCardThrownException{
        if(cards.size() == 2)
           return (cards.get(1));
        else throw new NotCardThrownException();
    }

    public Card getThirdOne() throws NotCardThrownException{
        if(cards.size() == 3)
            return (cards.getLast());
        else throw new NotCardThrownException();
    }

    public Card getLastOne() throws NotCardThrownException{
        if(!cards.isEmpty())
            return (cards.getLast());
        else throw new NotCardThrownException();
    }

    public void throwCards() {

        cards = new LinkedList<Card>();
    }

    public Player getPlayer() {
        return this.player;
    }
}