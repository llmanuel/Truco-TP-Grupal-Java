package model;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private CircularLinkedList<Player> PlayersInGame;
    private LinkedList<Slot> slotInGame;


    public void letSitThese(CircularLinkedList<Player> Players) throws InvalidNumberOfPlayersException{

        if( (Players.getSize() == 2) || (Players.getSize() == 4) ||(Players.getSize() == 6))
        this.PlayersInGame =Players;


        else throw (new InvalidNumberOfPlayersException());
    }

    public int getNumberOfPlayers() {
        return (PlayersInGame.getSize());
    }


    public void setGame() {
        this.createSlots(this.PlayersInGame.getSize());
    }

    private void createSlots(int size) {
        slotInGame = new LinkedList<Slot>();
        for (int i = 0; i == PlayersInGame.getSize() ; i++){
            Slot newSlot = new Slot(PlayersInGame.get(i));
            slotInGame.add(newSlot);
        }
    }

    public Card whichCardThrow(Player thisPlayer) throws NotCardThrownException, PlayerDoesNotExistsException {
        for (Slot actualSlot: slotInGame){
            if(actualSlot.isYourPlayer(thisPlayer)){
                return actualSlot.getLastOne();
            }
        }
        throw new PlayerDoesNotExistsException();
    }

    public LinkedList<Slot> getSlots(){
        return this.slotInGame;
    }
}