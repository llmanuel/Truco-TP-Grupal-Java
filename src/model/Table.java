package model;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.TeamDoesntExistException;
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
    private Player teamsCursor;
    private Player roundBeginner;
    private Games gameState;
    private Judge judge;
    private Croupier croupier;
    private Scoreboard scoreboard;
    private int roundCounter;
    private Team firstTeam;
    private Team secondTeam;

    public Table() {

        croupier = new Croupier();
    }

    /**************************
     *
     * Here begins the methods to set up the table before the game begins
     *
     **************************/

    public void letSitThese(LinkedList<Player> Players) throws InvalidNumberOfPlayersException {

        if( (Players.size() == 2) || (Players.size() == 4) ||(Players.size() == 6)) {

            this.playersInGame = Players;
            this.createSlots(this.playersInGame.size());
        }
        else throw (new InvalidNumberOfPlayersException());
    }

    public void setTeams(Team team1, Team team2){

        this.firstTeam = team1;
        this.secondTeam = team2;
    }

    public void setJudge(Judge judge){

        this.judge = judge;
    }

    public void setScoreBoard(Scoreboard scoreboard){

        this.scoreboard = scoreboard;
    }

    public int getNumberOfPlayers() {
        return (playersInGame.size());
    }


    public void setGame() {
        this.roundCounter = 0;
        gameState = new NormalRound(this);
        this.setRoundBeginner(this.playersInGame.getFirst());
    }

    private void createSlots(int size) {
        slotInGame = new LinkedList<Slot>();
        for (Player actualPlayer : this.playersInGame){
            Slot newSlot = new Slot( actualPlayer );
            slotInGame.add(newSlot);
            actualPlayer.setSlot(newSlot);
        }
    }

    public LinkedList<Slot> getSlots(){
        return this.slotInGame;
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
        this.verifyOthersTeamDecision();
    }

    public void giveUpGame() {
//        avisar al scoreBoard o al Judge que alguien se rindio y hay q darle los puntos al team corrrespondiente
        this.gameState = new NormalRound(this);
    }

    /**************************
     *
     * Here begins the methods for the iteration between the players
     *
     **************************/

    private void setCursorAt(Player thisPLayer){

        cursor = thisPLayer;
    }

    /*
     * Sets who's the first to play.
     * This will also set cursor at the round beginner.
     */
    public void setRoundBeginner(Player thisPlayer){

        roundBeginner = thisPlayer;
        this.setCursorAt(roundBeginner);
        thisPlayer.itsYourTurn();
    }

    /*
     * PreCondition: Must setRoundBeginner() Before using this method.
     * Returns the next player to play.
     */
    public Player nextPlayer() throws TeamDoesntExistException, NotCardThrownException {
        if (this.roundCounter == 3){
            this.judge.setWinnerOfGame(this.slotInGame,this.gameState);
            beginNextGame();
            return this.cursor;
        }
        this.getTheNextOne();
        if (cursor == roundBeginner){
            this.increaseRoundCounter();
            Player nextBeginner = judge.setWinnerOfTheRound(this.getSlots());
            this.gameState.nextRound();
            this.setRoundBeginner(nextBeginner);
            return nextBeginner;
        }
        Player thatPlayer = cursor;
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

    public Player getActualPlayer(){

        return this.cursor;
    }

    public void finishTurn() throws TeamDoesntExistException, NotCardThrownException {
        Player actualPlayer = this.getActualPlayer();
        actualPlayer.turnFinished();
        Player nextPlayer = this.nextPlayer();
        nextPlayer.itsYourTurn();
    }

    /**************************
     *
     * End of iteration methods
     *
     *************************/

    public void declareWinner(Team member) {
    }

    public void handOut() {
        for(Player actualPlayer: playersInGame){
            actualPlayer.setHand(croupier.giveHand());
        }
    }

    public void beginNextGame() {

        this.roundCounter = 0;
        this.gameState = new NormalRound(this);
        this.reOrderPlayers();
        this.cleanSlots();
        this.handOut();
        this.setRoundBeginner(this.playersInGame.getFirst());
    }

    private void cleanSlots() {

        for(Slot actualSlot: slotInGame){
            actualSlot.throwCards();
        }
    }

    private void reOrderPlayers() {
        LinkedList<Player> newOrderOfPLayers = new LinkedList<Player>();
        Player newLastPlayer = playersInGame.pollFirst();

        newOrderOfPLayers.addAll(playersInGame);
        newOrderOfPLayers.addLast(newLastPlayer);
        this.playersInGame = newOrderOfPLayers;
    }

    private void reOrderTeam() {
        LinkedList<Player> newOrderOfPLayers = new LinkedList<Player>();
        Player newLastPlayer = playersInGame.pollFirst();

        newOrderOfPLayers.addAll(playersInGame);
        newOrderOfPLayers.addLast(newLastPlayer);
        this.playersInGame = newOrderOfPLayers;
    }

    public void increaseRoundCounter() {
        roundCounter = roundCounter + 1;
    }

    /**************************
     *
     * Verification of decision when a team makes a call
     *
     *************************/

    private void verifyOthersTeamDecision(){
        Team teamToAnswer = this.getTheEnemyTeamOf(this.cursor);
        teamsCursor= teamToAnswer.getMember(1);
        teamsCursor.itsYourTurn();
    }


    private Team getTheEnemyTeamOf(Player cursor) {
        if (firstTeam.isMember(cursor))
            return secondTeam;
        else return firstTeam;
    }

    public Player nextPlayerOnTheTeam(Team teamToAnswer){
        this.getTheNextOneOnTheTeam();
        if (teamsCursor == teamToAnswer){
            this.increaseRoundCounter();
            Player nextBeginner = judge.setWinnerOfTheRound(this.getSlots());
            this.gameState.nextRound();
            this.setRoundBeginner(nextBeginner);
            return nextBeginner;
        }
        Player thatPlayer = cursor;
        return thatPlayer;
    }

    /*
     * Sets the cursor at the next player to play.
     */
    private void getTheNextOneOnTheTeam() {
        try {
            int i = 0;
            while (teamsCursor != playersInGame.get(i)) {
                i = i + 1;
            }
            i = i + 1;
            setCursorAt( playersInGame.get(i));
        }catch (IndexOutOfBoundsException e){setCursorAt( playersInGame.getFirst());}
    }
}