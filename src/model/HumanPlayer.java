package model;

public class HumanPlayer implements Player, CanHaveScore {

    private int playerId;
	private Hand hand;
    private Slot slot;

    public HumanPlayer(int idNumber){
        playerId = idNumber;
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
    public void playCard(Card cardToPlay) {
       this.slot.receiveCard( this.hand.getCard(cardToPlay) );
    }

    @Override
    public void setHand(Hand hand) { this.hand = hand;	}

	public Hand getHand() {	return hand; }

}