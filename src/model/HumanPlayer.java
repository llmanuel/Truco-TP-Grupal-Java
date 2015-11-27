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
            e.printStackTrace();
        }

    }

    @Override
    public void callTruco() {
        try {
            this.table.raiseBet();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callReTruco() {
        try {
            this.table.raiseBet();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callVale4() {
        try {
            this.table.raiseBet();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
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
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

}