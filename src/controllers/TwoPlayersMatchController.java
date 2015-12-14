package controllers;

import model.Builder;
import model.Exceptions.*;
import model.Player;
import model.Table;
import view.TwoPlayersGame;

import java.util.LinkedList;

public class TwoPlayersMatchController  {
    private final Player player1;
    private final Player player2;
    private Table table;
    private final TwoPlayersGame gameView;

    public TwoPlayersMatchController(TwoPlayersGame newGameView, boolean withCpu) throws InvalidNumberOfPlayersException {
        gameView = newGameView;

        Builder builder;

        if ( withCpu )
            builder = new Builder(1,1);
        else
            builder = new Builder(2);

        this.table = builder.getTable();
        this.player1 = builder.getPlayers().getFirst();
        this.player2 = builder.getPlayers().getLast();
        
        this.drawRound();
    }


    private void drawScores() {
        LinkedList<Player> players = new LinkedList<>();
        players.addFirst( this.player1 );
        players.addLast( this.player2 );

        this.gameView.drawScores(table.getScoreboard(), players);
    }


    public void callEnvido() throws InvalidGameCallException, NotYourTurnException, NotCardThrownException, TeamDoesntExistException {

        table.getActualPlayer().callEnvido();
   }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {

            table.getActualPlayer().callRealEnvido();
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {

            table.getActualPlayer().callFaltaEnvido();
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {

            table.getActualPlayer().callTruco();
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {

            table.getActualPlayer().callReTruco();
    }

    public  void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {

            table.getActualPlayer().callVale4();
    }

    public void callFlor() throws NotYourTurnException, InvalidGameCallException, TeamDoesntExistException {

            table.getActualPlayer().callFlor();
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException, TeamDoesntExistException, InvalidGameCallException, NothingToAcceptException {

            table.getActualPlayer().acceptCall();
    }

    public void giveUpGame() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().giveUp();
        this.drawRound();
    }

    private void drawCardsPlayerInTurn(){
        this.gameView.drawCardsPlayerInTurn(table.getActualPlayer().getHand() , table.getActualPlayer());
    }

    private void drawSlotPlayerInTurn(){
        this.gameView.drawSlotPlayerInTurn( table.getActualPlayer().getSlot());
    }

    private void drawSlotOtherPlayer(){
        this.gameView.drawSlotOtherPlayer( this.getOtherPlayer().getSlot() );
    }


    public void playCard(int i) {
        try {
            table.getActualPlayer().playCard( table.getActualPlayer().getHand().getCards().get(i-1) );
            this.drawRound();
        } catch (Exception ignored) {

        }
    }

    private Player getOtherPlayer() {
        Player playerToReturn = null;

        for (Player actualPlayer : this.table.getPlayers()){
            if (! actualPlayer.equals( this.table.getActualPlayer() )){
                playerToReturn = actualPlayer;
            }
        }
        return playerToReturn;
    }

    public void drawRound() {
        if(this.table.getActualPlayer().getIdNumber() == 2){this.player2.play();}
        this.drawSlotPlayerInTurn();
        this.drawSlotOtherPlayer();
        this.drawCardsPlayerInTurn();
        this.drawScores();
    }

    public void cleanPlayerInTurnCards() {

        this.gameView.cleanPlayerInTurnCards();
    }
}