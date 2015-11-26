package model;

import model.Exceptions.DonTHaveThatCardException;

public class CpuPlayer implements Player, CanHaveScore {

    private int playerId;
    private Hand hand;
    private Slot slot;
    private boolean isMyTurn;
    private Table table;

    public CpuPlayer(int idNumber){
        playerId = idNumber;
        isMyTurn = false;
    }

	@Override
	public int calculateEnvido() {
		return this.hand.calculateEnvido();
	}

    @Override
    public void setSlot(Slot actualSlot){
        this.slot = actualSlot;
    }

    @Override
    public void sitOnTable(Table table) {

        this.table = table;
    }

    @Override
    public void playCard(Card cardToPlay) throws DonTHaveThatCardException {
        this.slot.receiveCard( this.hand.getCard(cardToPlay) );
    }

    @Override
    public Hand getHand() {
        return this.hand;
    }

    @Override
    public int getIdNumber(){
        return playerId;
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
    public void setHand(Hand newHand){
        this.hand = newHand;
    }
}
