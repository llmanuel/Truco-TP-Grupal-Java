package model;

import model.Exceptions.*;

import java.util.LinkedList;

public class CpuPlayer implements Player {

    private int playerId;
    private Hand hand;
    private Slot slot;
    private Table table;
    private boolean iMadeACall;

    public CpuPlayer(int idNumber) {
        playerId = idNumber;
        this.iMadeACall=false;
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
    public void playCard(Card cardToPlay) throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, MustAcceptCallFirstException, DonTHaveThatCardException {
        if ((this.table.tellMeIfItsMyTurn(this)) && (this.table.tellMeIfCallWasAccepted())) {
            this.slot.receiveCard(this.hand.getCard(cardToPlay));
            this.table.finishTurn();
        } else if(!this.table.tellMeIfItsMyTurn(this)) throw new NotYourTurnException();
        else throw new MustAcceptCallFirstException();
    }

    @Override
    public void play() throws NotYourTurnException {
        Card cardToPlay;
        try {
            if(!iMadeACall)this.decideOfMakingACall();
            if(this.table.tellMeIfItsMyTurn(this)){
                cardToPlay = this.chooseCardToPlay();
                iMadeACall = false;
                this.playCard(cardToPlay);
            } else throw new NotYourTurnException();
        } catch (MustAcceptCallFirstException e) {this.acceptCall();

        }catch (Exception e1){}
    }

    private void decideOfMakingACall() throws NotCardThrownException, NotYourTurnException {
        try {
           this.thinkEnvidos();
        } catch (TeamDoesntExistException e) {}
    }


    private boolean thinkEnvidos() throws TeamDoesntExistException, NotYourTurnException {
        iMadeACall = false;
            if(this.getHand().isFlor()){
                try {
                    this.callFlor();
                    iMadeACall = true;
                } catch (InvalidGameCallException e) {}
            }
        if(!iMadeACall) {
            try {
                if (this.getHand().calculateEnvido() > 30) {
                    this.callRealEnvido();
                    iMadeACall = true;
                } else if (this.getHand().calculateEnvido() > 25) {
                    this.callEnvido();
                    iMadeACall = true;
                }
            } catch (InvalidGameCallException e1) {}
        }
        return iMadeACall;
    }

    public int searchHigherCardInTheRound(){
        int maxValue = 0;
        try {
                Slot actualSlot = table.getSlotsOfHumanPlayers();
                if (actualSlot.getLastOne().getValue() > maxValue) {

                    maxValue = actualSlot.getLastOne().getValue();
                }
            return  maxValue;
        } catch (NotCardThrownException e) {
            return  maxValue;
        }
    }

    /***************************************************************************************************
     * Method that give to CpuPlayer the possibility of choose what card play in a round.              *
     * It will play the card with the lesser value in it's hand that can win to the other card played. *
     * If it can't play a card like that it will play the card with lesser value in it's hand.         *
     ***************************************************************************************************/
    public Card chooseCardToPlay(){

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
        else if(!this.hand.isFlor()) throw new InvalidGameCallException();
        else throw new NotYourTurnException();
    }

    @Override
    public void acceptCall() throws NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this))  {
            try {
                this.table.acceptCall();
            } catch (NothingToAcceptException e) {}
        } else throw new NotYourTurnException();
    }

    @Override
    public void setHand(Hand newHand) {
        this.hand = newHand;
    }

}
