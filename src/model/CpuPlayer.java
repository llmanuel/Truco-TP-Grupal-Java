package model;

import model.Exceptions.*;

import java.util.LinkedList;

public class CpuPlayer implements Player {

    private int playerId;
    private Hand hand;
    private Slot slot;
    private boolean isMyTurn;
    private Table table;

    public CpuPlayer(int idNumber) {
        playerId = idNumber;
        isMyTurn = false;
    }

    @Override
    public int calculateEnvido() {
        return this.hand.calculateEnvido();
    }

    @Override
    public void setSlot(Slot actualSlot) {
        this.slot = actualSlot;
    }

    @Override
    public void setTable(Table table) {

        this.table = table;
    }

    @Override
    public void playCard(Card cardToPlay) throws DonTHaveThatCardException, NotYourTurnException, NotCardThrownException {

        if ((this.table.tellMeIfItsMyTurn(this)) && (this.table.tellMeIfCallWasAccepted())) {

            this.slot.receiveCard(this.hand.getCard(cardToPlay));
        } else throw new NotYourTurnException();
    }

    private int searchHigherCardInTheRound() throws NotCardThrownException {
        int maxValue = 0;
        for (Slot actualSlot : this.table.getSlotsOfHumanPlayers()) {

            if (actualSlot.getLastOne().getValue() > maxValue) {

                maxValue = actualSlot.getLastOne().getValue();
            }
        }
        return  maxValue;
    }

    public Card chooseCardToPlay() throws NotCardThrownException {

        int higherCardInRound = searchHigherCardInTheRound();
        LinkedList<Card> ordererCards = this.orderMyHandLowToHigh();
        for (Card myCard :ordererCards) {

            if (myCard.getValue() > higherCardInRound){

                Card  cardToPlay = myCard;
                return cardToPlay;
            }

        }
        return (ordererCards.get(0));
    }

    public LinkedList<Card> orderMyHandLowToHigh(){

        LinkedList<Card> cards = this.hand.getCards();
        for (int i = 1 ; i < cards.size(); i++) {

            for (int j = 0; j < cards.size() - 1; j++) {

                if (cards.get(j).getValue() > cards.get(j + 1).getValue()) {

                    Card lowCard = cards.remove(j+1);
                    Card highCard = cards.remove(j);
                    cards.add(j, lowCard );
                    cards.add(j + 1, highCard);
                }
            }
        }
        return  cards;
    }



    @Override
    public Hand getHand() {
        return this.hand;
    }

    @Override
    public Slot getSlot() {
        return this.slot;
    }

    @Override
    public int getIdNumber() {
        return playerId;
    }

    @Override
    public void callEnvido() {
        try {
            this.table.callEnvido();
        } catch (InvalidGameCallException e) {

        }
    }

    @Override
    public void callRealEnvido() {
        try {
            this.table.callRealEnvido();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void callFaltaEnvido() {
        try {
            this.table.callFaltaEnvido();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void callTruco() {
        try {
            this.table.callTruco();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void callReTruco() {
        try {
            this.table.callReTruco();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void callVale4() {
        try {
            this.table.callVale4();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void giveUp() {
        this.table.giveUpGame();

    }

    @Override
    public void callFlor() {

    }

    @Override
    public void acceptCall() {
        try {
            this.table.acceptCall();
        } catch (TeamDoesntExistException e) {

        }

    }

    @Override
    public void setHand(Hand newHand) {
        this.hand = newHand;
    }

}
