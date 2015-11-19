package model;

import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.PlayerDoesNotExistsException;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private LinkedList<Player> PlayersInGame;
    private LinkedList<Slot> slotInGame;


    public void letSitThese(LinkedList<Player> Players) throws InvalidNumberOfPlayersException {

        if( (Players.size() == 2) || (Players.size() == 4) ||(Players.size() == 6))
        this.PlayersInGame =Players;


        else throw (new InvalidNumberOfPlayersException());
    }

    public int getNumberOfPlayers() {
        return (PlayersInGame.size());
    }


    public void setGame() {
        this.createSlots(this.PlayersInGame.size());
    }

    private void createSlots(int size) {
        slotInGame = new LinkedList<Slot>();
        for (int i = 0; i == PlayersInGame.size() ; i++){
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