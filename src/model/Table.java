package model;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private int slots;
    private LinkedList<Player> PlayersInGame;

    public Table(int slots) {

        this.slots = slots;
    }

    public void letSitThese(LinkedList<Player> Players) throws InvalidNumberOfPlayersException{

        if( (Players.size() == 2) || (Players.size() == 4) ||(Players.size() == 6))
        this.PlayersInGame =Players;

        else throw (new InvalidNumberOfPlayersException());
    }

    public int getNumberOfPlayers() {
        return (PlayersInGame.size());
    }
}