package model;

import model.Exceptions.*;


public class HumanPlayer implements Player {

    private int playerId;
    private Hand hand;
    private Slot slot;
    private Table table;

    public HumanPlayer(int idNumber) {
        playerId = idNumber;
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
    public void setTable(Table table) {

        this.table = table;
    }

    @Override
    public void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException, TeamDoesntExistException, NotCardThrownException {
        if ((this.table.tellMeIfItsMyTurn(this)) && (this.table.tellMeIfCallWasAccepted())) {
            this.slot.receiveCard( this.hand.getCard( cardToPlay ) );
            this.table.finishTurn();
        } else throw new NotYourTurnException();
    }

    @Override
    public void itsYourTurn() {

    }

    @Override
    public void turnFinished() {

    }

    @Override
    public void callEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.callEnvido();
            }
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {

        }
    }

    @Override
    public void callRealEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.callRealEnvido();
            }
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {

        }

    }

    @Override
    public void callFaltaEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.callFaltaEnvido();
            }
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.raiseBet();
            }
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callReTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.raiseBet();
            }
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void callVale4() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.raiseBet();
            }
            else throw new NotYourTurnException();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void giveUp() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.giveUpGame();
        }
        else throw new NotYourTurnException();
    }

    @Override
    public void callFlor() throws NotYourTurnException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callFlor();
        }
        else throw new NotYourTurnException();
    }

    @Override
    public void acceptCall() throws NotYourTurnException, NotCardThrownException {
        try {
            if(this.table.tellMeIfItsMyTurn(this)) {
                this.table.acceptCall();
            }
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

    @Override
    public Slot getSlot() {
        return this.slot;
    }

}