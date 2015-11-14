package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class HumanPlayer implements Player {

    private int playerId;
	private Hand hand;

    public HumanPlayer(int idNumber){
        playerId = idNumber;
    }

    @Override
    public int calculateEnvido() {
        return 0;
    }

    @Override
    public int getIdNumber(){
        return playerId;
    }

	public void receiveAHand(Hand hand) { this.hand = hand;	}

	public Hand getHand() {	return hand; }
}
