package model;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.TeamDoesntExistException;
import model.TableStates.Flor;
import model.TableStates.Games;
import model.TableStates.NormalRound;

import java.util.LinkedList;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Table {

    private LinkedList<Player> playersInGame;
    private LinkedList<Slot> slotsInGame;
    private Player cursor;
    private Player roundBeginner;
    private Player cursorForCalls;
    private Games gameState;
    private Judge judge;
    private Croupier croupier;
    private Scoreboard scoreboard;
    private int roundCounter;
    private Team firstTeam;
    private Team secondTeam;
    private Team teamsCursor;

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
        slotsInGame = new LinkedList<Slot>();
        for (Player actualPlayer : this.playersInGame){
            Slot newSlot = new Slot( actualPlayer );
            slotsInGame.add(newSlot);
            actualPlayer.setSlot(newSlot);
        }
    }

    public LinkedList<Slot> getSlots(){
        return this.slotsInGame;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    /**************************
     *
     * Here begins the methods for the calls
     *
     **************************/

    public void callTruco() throws InvalidGameCallException {
        this.gameState.callTruco();
    }

    public void callReTruco() throws InvalidGameCallException {
        this.gameState.callReTruco();
    }

    public void callVale4() throws InvalidGameCallException {
        this.gameState.callVale4();
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

    public void callFlor() throws TeamDoesntExistException, InvalidGameCallException {
        this.gameState.callFlor();
        this.scoreboard.increaseTheScoreOf(this.getActualPlayer(), new Flor(this));
        this.gameState.nextRound();
    }

    public int getPoints(){

        return (this.gameState.getPoints());
    }

    public void raiseBet(Games nextGame) {

        this.gameState = nextGame;
        this.verifyOthersTeamDecision();
    }

    public void
    theEnvidoGameWasAccepted() throws TeamDoesntExistException {
        this.judge.setWinnerOfEnvido(this.slotsInGame, this.gameState);
        /*nextRound on Envidos Games will set the game state on LastsRounds*/
        this.gameState.nextRound();
        this.setCursorAt(this.cursorForCalls);
    }

    public void nextRound(Games nextGame){
        this.gameState = nextGame;
    }

    public void acceptCall() throws TeamDoesntExistException {
        this.gameState.acceptCall();
    }

    public void giveUpGame() {
        this.scoreboard.playerGaveUpThisGame(this.getTeamOfActualPlayer(),this.gameState);
        this.gameState.giveUp();
    }

    /**************************
     *
     * Here begins the methods for the iteration between the players
     *
     **************************/

    private void setCursorAt(Player thisPLayer){

        cursor = thisPLayer;
        this.cursor.play();
    }

    /*
     * Sets who's the first to play.
     * This will also set cursor at the round beginner.
     */
    public void setRoundBeginner(Player thisPlayer){

        roundBeginner = thisPlayer;
        this.setCursorAt(roundBeginner);
    }

    /*
     * PreCondition: Must setRoundBeginner() Before using this method.
     * Returns the next player to play.
     */
    public Player nextPlayer() throws TeamDoesntExistException, NotCardThrownException {
        this.getTheNextOne();
        if ((cursor == roundBeginner) && (this.roundCounter != 3)){
            this.increaseRoundCounter();
            Player nextBeginner = judge.setWinnerOfTheRound(this.getSlots());
            this.gameState.nextRound();
            this.setRoundBeginner(nextBeginner);
            return nextBeginner;
        }
        else if ((cursor == roundBeginner) && (this.roundCounter == 3)){
            this.judge.setWinnerOfGame(this.slotsInGame,this.gameState);
            beginNextGame();
        }

        return this.cursor;
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

    public void continueWithRound(){

        this.setCursorAt(this.cursorForCalls);
    }

    public Player getActualPlayer(){

        return this.cursor;
    }

    public void finishTurn() throws TeamDoesntExistException, NotCardThrownException {

        /*It's the turn of the player who is on cursor*/
        this.setCursorAt(this.nextPlayer());
    }

    public boolean tellMeIfItsMyTurn(Player askingPlayer){
        return (this.cursor == askingPlayer);
    }
    /**************************
     *
     * End of iteration methods
     *
     *************************/

    /**Reparte cartas a los jugadores*/
    public void handOut() {
        croupier.prepareForNewRound();
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

        for(Slot actualSlot: slotsInGame){
            actualSlot.throwCards();
        }
    }

    private void reOrderPlayers() {
        Player newLastPlayer = playersInGame.pollFirst();
        playersInGame.addLast( newLastPlayer );
    }

    private void reOrderTeam(Team teamToReorder) {
        Player newLastPlayer = teamToReorder.pollFirst();

        teamToReorder.addLast(newLastPlayer);
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
        teamsCursor = this.getTheEnemyTeamOf(this.cursor);
        cursorForCalls = this.cursor;
        setCursorAt(teamsCursor.getFirstMember());
    }

    public Team getTheEnemyTeamOf(Player thisPlayer) {
        if (firstTeam.isMember(thisPlayer))
            return secondTeam;
        else return firstTeam;
    }

    public void askNextPlayerOnTheTeam(Team teamToAnswer){
        this.reOrderTeam(teamToAnswer);
        Player nextPlayer = teamToAnswer.getFirstMember();
        if(nextPlayer == cursorForCalls)
            this.gameState.giveUpPoints();
        this.cursor = nextPlayer;
    }

    public Team getTeamCursor(){
        return this.teamsCursor;
    }

    public Team getTeamOfActualPlayer(){
        if (firstTeam.isMember(this.cursor))
        return firstTeam;
        else return secondTeam;
    }

    public boolean tellMeIfCallWasAccepted(){
       return this.gameState.tellIfTheGameWasAccepted();
    }

    public LinkedList<Player> getPlayers() {
        return playersInGame;
    }

    public Slot getSlotsOfHumanPlayers(){

        if (slotsInGame.get(0).getPlayer().getIdNumber() != getActualPlayer().getIdNumber()) {

            return slotsInGame.get(0);
        }
        return  slotsInGame.get(1);
    }

}