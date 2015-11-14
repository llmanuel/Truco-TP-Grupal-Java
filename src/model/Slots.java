package model;


/**
 * Created by manuel on 13/11/15.
 */
public class Slots {


    private Player player;
    private CardSpot firstCard;
    private CardSpot secondCard;
    private CardSpot thirdCard;

    public Slots(Player player) {
        this.player = player;
    }

    public boolean receiveFirstCard(Card card) {
        firstCard = new CardSpot(card);
        return true;
    }

    public boolean receiveSecondCard(Card card) {
        secondCard = new CardSpot(card);
        return true;
    }

    public boolean receiveThirdCard(Card card) {
        thirdCard = new CardSpot(card);
        return true;
    }

    public boolean isYourPlayer(Player myPlayer) {
        return (this.player.getIdNumber() == myPlayer.getIdNumber());
    }

    public Card getFirstOne() throws NotCardThrownException{
        if(firstCard.isItInGame())
            return firstCard.getCard();
        else throw new NotCardThrownException();
    }

    public Card getSecondOne() throws NotCardThrownException{
        if (firstCard.isItInGame())
            return secondCard.getCard();
        else throw new NotCardThrownException();
    }

    public Card getThirdOne() throws NotCardThrownException{
        if(firstCard.isItInGame())
            return thirdCard.getCard();
        else throw new NotCardThrownException();
    }

    public void throwCards() {

        this.firstCard.throwCard();
        this.secondCard.throwCard();
        this.thirdCard.throwCard();
    }
}