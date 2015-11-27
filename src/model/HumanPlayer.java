package model;

import model.Exceptions.*;


public class HumanPlayer implements Player {

    private int playerId;
    private Hand hand;
    private Slot slot;
    private boolean isMyTurn;
    private Table table;

    public HumanPlayer(int idNumber) {
        playerId = idNumber;
        isMyTurn = false;
    }

    @Override
    public int calculateEnvido() {
        return this.hand.calculateEnvido();
    }

    @Override
    public int getIdNumber() {
        return playerId;
    }

    @Override
    public void setSlot(Slot newSlot) {
        this.slot = newSlot;
    }

    @Override
    public void sitOnTable(Table table) {

        this.table = table;
    }

    @Override
    public void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException, TeamDoesntExistException, NotCardThrownException {
        if ((isMyTurn) && (this.table.tellMeIfCallWasAccepted())) {
            this.slot.receiveCard( cardToPlay );
            this.table.finishTurn();
        } else throw new NotYourTurnException();
    }

    @Override
    public void itsYourTurn() {
        this.isMyTurn = true;
    }

    @Override
    public void turnFinished() {
        this.isMyTurn = false;
    }

    @Override
    public void callEnvido() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.callEnvido();
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {

        }
    }

    @Override
    public void callRealEnvido() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.callRealEnvido();
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void callFaltaEnvido() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.callFaltaEnvido();
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callTruco() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.raiseBet();
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callReTruco() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.raiseBet();
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callVale4() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.raiseBet();
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void giveUp() throws NotYourTurnException {
        if(isMyTurn)
            this.table.giveUpGame();
        else throw new NotYourTurnException();
    }

    @Override
    public void callFlor() {
    }

    @Override
    public void acceptCall() throws NotYourTurnException {
        try {
            if(isMyTurn)
                this.table.acceptCall();
            else throw new NotYourTurnException();
        } catch (TeamDoesntExistException e) {

        }
    }

    @Override
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

}