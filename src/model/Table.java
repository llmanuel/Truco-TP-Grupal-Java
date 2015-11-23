package model;

import model.Exceptions.InvalidCallException;
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
    private Games gameState;

    public void Table(){

        Games gameState = new NormalRound();
    }

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


    public LinkedList<Slot> getSlots(){
        return this.slotInGame;
    }

    private void setCursorAt(Player thisPLayer){

        cursor = thisPLayer;
    }

    /**************************
     *
     * Here begins the methods for the calls
     *
     **************************/

    public void raiseBet(){

        this.gameState.raiseBet();
    }

    public void callEnvido() throws InvalidCallException {

        this.gameState.callEnvido();
    }

    public void callRealEnvido() throws InvalidCallException {

        this.gameState.callRealEnvido();
    }

    public void callFaltaEnvido() throws InvalidCallException {

        this.gameState.callFaltaEnvido();
    }

    public int getPoints(){

        return (this.gameState.getPoints());
    }
    /**************************
     *
     * Here begins the methods for the iteration between the players
     *
     **************************/

    /*
     * Sets who's the first to play.
     * This will also set cursor at the round beginner.
     */
    public void setRoundBeginner(Player thisPLayer){

        roundBeginner = thisPLayer;
        setCursorAt(roundBeginner);
    }

    /*
     *PreCondition: Must setRoundBeginner() Before using this method.
     * Returns the next player to play.
     */
    public Player nextPlayer(){
        Player thatPlayer = cursor;
        this.getTheNextOne();
        return thatPlayer;
    }

    /*
     * Sets the cursor at the next player to play.
     */
    private void getTheNextOne() {
       try {
           int i = 0;
           while (cursor != PlayersInGame.get(i)) {
               i = i + 1;
           }
           i = i + 1;
           setCursorAt(PlayersInGame.get(i));
       }catch (IndexOutOfBoundsException e){setCursorAt(PlayersInGame.getFirst());}
    }

    /**************************
     *
     * End of iteration methods
     *
     *************************/
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