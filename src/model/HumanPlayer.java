package model;

import model.Exceptions.NotYourTurnException;


public class HumanPlayer implements Player, CanHaveScore {

    private int playerId;
	private Hand hand;
    private Slot slot;
    private boolean isMyTurn;
    private Table table;

    public HumanPlayer(int idNumber){
        playerId = idNumber;
        isMyTurn = false;
    }

    @Override
    public int calculateEnvido() {
        return this.hand.calculateEnvido();
    }

    @Override
    public int getIdNumber(){
        return playerId;
    }

    @Override
    public void setSlot(Slot newSlot){
        this.slot = newSlot;
    }

    @Override
    public void sitOnTable(Table table) {

        this.table = table;
    }

    @Override
    public void playCard(Card cardToPlay) throws NotYourTurnException {
        if (isMyTurn) {
            this.slot.receiveCard(this.hand.getCard(cardToPlay));
            this.turnFinished();
        }
        else throw new NotYourTurnException();
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
    public void setHand(Hand hand) { this.hand = hand;	}

	public Hand getHand() {	return hand; }

}