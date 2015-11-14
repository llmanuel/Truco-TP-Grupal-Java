package model;

/**
 * Created by manuel on 13/11/15.
 */
public class Slots {


    private Player player;
    private Card firstCard;

    public Slots(Player player) {
        this.player = player;
    }


    public void receiveFirstCard(Card Card) {

        firstCard = Card;
    }
}
