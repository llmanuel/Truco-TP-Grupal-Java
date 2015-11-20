package model;

import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.PlayerDoesNotExistsException;

import javax.print.attribute.standard.PrinterLocation;
import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private LinkedList<Player> PlayersInGame;
    private LinkedList<Slot> slotInGame;
    private Player cursor;
    private Player roundBeginner;


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

    private void setCursorAt(Player thisPLayer){

        cursor = thisPLayer;
    }

    /*
     * This will also set cursor at the round beginner.
     */
    public void setRoundBeginner(Player thisPLayer){

        roundBeginner = thisPLayer;
        setCursorAt(roundBeginner);
    }

    /*
     * Returns the next player to play
     */
    public Player nextPlayer(){
        Player thatPlayer = cursor;
        this.getTheNextOne();
        return thatPlayer;
    }

    /*
     * PreCondition: Must setRoundBeginner() Before using this method
     */
    private void getTheNextOne() {
        int i=0;
        while ((PlayersInGame.get(i) != null) && (cursor != PlayersInGame.get(i))){
            i = i + 1;
        }
        i = i + 1;
        if (PlayersInGame.get(i) != null)
            setCursorAt(PlayersInGame.get(i));
        else  setCursorAt(PlayersInGame.getFirst());
    }

//    public void iterateThePlayersFrom(Player theFirst){
//        boolean youCanPlay = false;
//        int everyBodyPLayed = 0;
//        for (Player actualPlayer: PlayersInGame){
//            if (actualPlayer == theFirst){
//                youCanPlay = true;
//            }
//            if(youCanPlay) {
//                actualPlayer.PlayYourWill();
//                everyBodyPLayed = everyBodyPLayed + 1;
//            }
//        }
//        if(everyBodyPLayed != PlayersInGame.size()){
//            Player actualPlayer = PlayersInGame.getFirst();
//            while (actualPlayer != theFirst){
//                actualPlayer.PlayYourWill();
//
//            }
//        }
//    }

    public void declareWinner(CanHaveScore member) {
    }
}