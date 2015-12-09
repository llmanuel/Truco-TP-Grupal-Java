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

            this.slot.receiveCard(cardToPlay);
        } else throw new NotYourTurnException();
    }

    public void playCardAutomatically() throws NotCardThrownException, DonTHaveThatCardException, NotYourTurnException {

        Card cardToPlay = this.chooseCardToPlay();

        this.playCard(cardToPlay);
    }

    public int searchHigherCardInTheRound() throws NotCardThrownException {
        int maxValue = 0;
        try {
            for (Slot actualSlot : this.table.getSlotsOfHumanPlayers()) {

                if (actualSlot.getLastOne().getValue() > maxValue) {

                    maxValue = actualSlot.getLastOne().getValue();
                }
            }
        } catch (NotCardThrownException e) {
            return  maxValue;
        }
        return  maxValue;
    }

    /***************************************************************************************************
     * Method that give to CpuPlayer the possibility of choose what card play in a round.              *
     * It will play the card with the lesser value in it's hand that can win to the other card played. *
     * If it can't play a card like that it will play the card with lesser value in it's hand.         *
     ***************************************************************************************************/
    public Card chooseCardToPlay() throws NotCardThrownException {

        int higherCardInRound = searchHigherCardInTheRound();
        LinkedList<Card> ordererCards = this.orderMyHandLowToHigh();
        for (Card myCard :ordererCards) {

            if ((myCard.getValue() > higherCardInRound) && (higherCardInRound !=0)){

                Card  cardToPlay = myCard;
                return cardToPlay;
            }

        }
        if (higherCardInRound == 0){
            return  (ordererCards.get(1));
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
    public void callEnvido() throws InvalidGameCallException, NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callEnvido();
        }
        else throw new NotYourTurnException();

    }


    @Override
    public void callRealEnvido() throws InvalidGameCallException, NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callRealEnvido();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void callFaltaEnvido() throws NotYourTurnException, InvalidGameCallException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callFaltaEnvido();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void callTruco() throws InvalidGameCallException, NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this)){
            this.table.callTruco();
        }
        else throw new NotYourTurnException();
    }

    @Override
    public void callReTruco() throws NotYourTurnException, InvalidGameCallException {
        if(this.table.tellMeIfItsMyTurn(this)){
            this.table.callReTruco();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void callVale4() throws InvalidGameCallException, NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callVale4();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void giveUp() throws NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.giveUpGame();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void callFlor() throws TeamDoesntExistException, InvalidGameCallException, NotYourTurnException {

        if(this.table.tellMeIfItsMyTurn(this) && (this.hand.isFlor())) {
            this.table.callFlor();
        }
        else throw new NotYourTurnException();
    }

    @Override
    public void acceptCall() throws TeamDoesntExistException, NotYourTurnException {
        if((this.table.tellMeIfItsMyTurn(this)) && (this.calculateEnvido() > 25)) {
            this.table.acceptCall();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void setHand(Hand newHand) {
        this.hand = newHand;
    }

}
