package model;

public class CpuPlayer implements Player, CanHaveScore {

    private int playerId;
    private Hand hand;
    private Slot slot;

    public CpuPlayer(int idNumber){
        playerId = idNumber;
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
    public void playCard(Card cardToPlay) {
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
    public void setHand(Hand newHand){
        this.hand = newHand;
    }
}
