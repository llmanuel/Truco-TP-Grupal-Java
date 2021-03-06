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
    public void playCard(Card cardToPlay) throws NotYourTurnException, DonTHaveThatCardException, TeamDoesntExistException, NotCardThrownException, MustAcceptCallFirstException {
        if ((this.table.tellMeIfItsMyTurn(this)) && (this.table.tellMeIfCallWasAccepted())) {
            this.slot.receiveCard( this.hand.getCard( cardToPlay ) );
            this.table.finishTurn();
        } else if(!this.table.tellMeIfItsMyTurn(this)) throw new NotYourTurnException();
        else throw new MustAcceptCallFirstException();
    }

    @Override
    public void play(){}

    @Override
    public void callEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException {

        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callEnvido();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void callRealEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException {

        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callRealEnvido();
        }
        else throw new NotYourTurnException();


    }

    @Override
    public void callFaltaEnvido() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException {

        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callFaltaEnvido();
        }
        else throw new NotYourTurnException();


    }

    @Override
    public void callTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException {

        if(this.table.tellMeIfItsMyTurn(this)){
            this.table.callTruco();
        }
        else throw new NotYourTurnException();


    }

    @Override
    public void callReTruco() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException {

        if(this.table.tellMeIfItsMyTurn(this)){
            this.table.callReTruco();
        }
        else throw new NotYourTurnException();


    }

    @Override
    public void callVale4() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException, InvalidGameCallException {

        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.callVale4();
        }
        else throw new NotYourTurnException();

    }

    @Override
    public void giveUp() throws NotYourTurnException, TeamDoesntExistException, NotCardThrownException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.giveUpGame();
        }
        else throw new NotYourTurnException();
    }

    @Override
    public void callFlor() throws NotYourTurnException, TeamDoesntExistException, InvalidGameCallException {
        if(this.table.tellMeIfItsMyTurn(this) && (this.hand.isFlor())) {
            this.table.callFlor();
        }
        else if(!this.hand.isFlor()) throw new InvalidGameCallException();
            else throw new NotYourTurnException();
    }

    @Override
    public void acceptCall() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, NothingToAcceptException {
        if(this.table.tellMeIfItsMyTurn(this)) {
            this.table.acceptCall();
        }
        else throw new NotYourTurnException();
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