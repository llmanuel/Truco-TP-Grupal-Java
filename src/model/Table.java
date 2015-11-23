package model;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.TableStates.Games;
import model.TableStates.NormalRound;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private LinkedList<Player> playersInGame;
    private LinkedList<Slot> slotInGame;
    private Player cursor;
    private Player roundBeginner;
    private Games gameState;
    private Judge judge;
    private Croupier croupier;
    private Scoreboard scoreboard;

    public void Table(){

        Games gameState = new NormalRound(this);
        croupier = new Croupier();
    }

    /**************************
     *
     * Here begins the methods to set up the table before the game begins
     *
     **************************/

    public void letSitThese(LinkedList<Player> Players) throws InvalidNumberOfPlayersException {

        if( (Players.size() == 2) || (Players.size() == 4) ||(Players.size() == 6))
        this.playersInGame =Players;


        else throw (new InvalidNumberOfPlayersException());
    }

    public void getAJudge(Judge judge){

        this.judge = judge;
    }

    public void getScoreBoard(Scoreboard scoreboard){

        this.scoreboard = scoreboard;
    }

    public int getNumberOfPlayers() {
        return (playersInGame.size());
    }


    public void setGame() {
        this.createSlots(this.playersInGame.size());
    }

    private void createSlots(int size) {
        slotInGame = new LinkedList<Slot>();
        for (Player actualPlayer : this.playersInGame){
            Slot newSlot = new Slot( actualPlayer );
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

    public void raiseBet() throws InvalidGameCallException {

        this.gameState.raiseBet();
    }

    public void callEnvido() throws InvalidGameCallException {

        this.gameState.callEnvido();
    }

    public void callRealEnvido() throws InvalidGameCallException {

        this.gameState.callRealEnvido();
    }

    public void callFaltaEnvido() throws InvalidGameCallException {

        this.gameState.callFaltaEnvido();
    }

    public int getPoints(){

        return (this.gameState.getPoints());
    }

    public void raiseBet(Games nextGame) {

        this.gameState = nextGame;
    }

    public void giveUpGame() {
//        this.scoreboard.
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
     * PreCondition: Must setRoundBeginner() Before using this method.
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
           while (cursor != playersInGame.get(i)) {
               i = i + 1;
           }
           i = i + 1;
           setCursorAt( playersInGame.get(i));
       }catch (IndexOutOfBoundsException e){setCursorAt( playersInGame.getFirst());}
    }

    /**************************
     *
     * End of iteration methods
     *
     *************************/
//    public void iterateThePlayersFrom(Player theFirst){
//        boolean youCanPlay = false;
//        int everyBodyPLayed = 0;
//        for (Player actualPlayer: playersInGame){
//            if (actualPlayer == theFirst){
//                youCanPlay = true;
//            }
//            if(youCanPlay) {
//                actualPlayer.PlayYourWill();
//                everyBodyPLayed = everyBodyPLayed + 1;
//            }
//        }
//        if(everyBodyPLayed != playersInGame.size()){
//            Player actualPlayer = playersInGame.getFirst();
//            while (actualPlayer != theFirst){
//                actualPlayer.PlayYourWill();
//
//            }
//        }
//    }

    public void declareWinner(CanHaveScore member) {
    }

}