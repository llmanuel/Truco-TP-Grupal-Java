package model;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private LinkedList<Player> PlayersInGame;
    private LinkedList<Slots> slotsInGame;

    public void letSitThese(LinkedList<Player> Players) throws InvalidNumberOfPlayersException{

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
        slotsInGame = new LinkedList<Slots>();
        for (Player player: PlayersInGame){
            Slots newSlot = new Slots(player);
            slotsInGame.add(newSlot);
        }
    }

    public Card whichCardThrow(Player thisPlayer) throws NotCardThrownException, PlayerDoesNotExistsException {
        for (Slots actualSlot: slotsInGame){
            if(actualSlot.isYourPlayer(thisPlayer)){
                return actualSlot.getLastOne();
            }
        }
        throw new PlayerDoesNotExistsException();
    }
}