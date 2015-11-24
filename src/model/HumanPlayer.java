package model;

public class HumanPlayer implements Player, CanHaveScore {

    private int playerId;
	private Hand hand;
    private Slot slot;
    private boolean isMyTurn;

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
    public void playCard(Card cardToPlay) {
       this.slot.receiveCard( this.hand.getCard(cardToPlay) );
    }

    @Override
    public void itsMyTurn() {
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