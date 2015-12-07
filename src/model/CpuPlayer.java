package model;

import model.Exceptions.DonTHaveThatCardException;
import model.Exceptions.InvalidGameCallException;
import model.Exceptions.TeamDoesntExistException;

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
    public void playCard(Card cardToPlay) throws DonTHaveThatCardException {
        this.slot.receiveCard( this.hand.getCard( cardToPlay ) );
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
