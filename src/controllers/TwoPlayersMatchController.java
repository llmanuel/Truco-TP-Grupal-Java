package controllers;

import model.Builder;
import model.Exceptions.*;
import model.Player;
import model.Table;
import view.TwoPlayersGame;

import java.util.LinkedList;

public class TwoPlayersMatchController  {
    private final LinkedList<Player> players;
    private Table table;
    private TwoPlayersGame gameView;
    private Builder builder;

    public TwoPlayersMatchController(TwoPlayersGame newGameView) throws InvalidNumberOfPlayersException {
        gameView = newGameView;
        builder = new Builder(2);
        this.table = builder.getTable();
        this.players = builder.getPlayers();
        this.drawRound();
    }


    public void drawScores() {

        this.gameView.drawScores(table.getScoreboard(), this.players);
    }


    public void callEnvido() throws InvalidGameCallException, NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callEnvido();
        this.drawRound();
   }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callRealEnvido();
        this.drawRound();
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callFaltaEnvido();
        this.drawRound();
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callTruco();
        this.drawRound();
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callReTruco();
        this.drawRound();
    }

    public  void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callVale4();
        this.drawRound();
    }

    public void callFlor() throws NotYourTurnException, InvalidGameCallException, TeamDoesntExistException {
        table.getActualPlayer().callFlor();
        this.drawRound();
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException, TeamDoesntExistException {
        table.getActualPlayer().acceptCall();
        this.drawRound();
    }

    public void giveUpGame() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().giveUp();
        this.drawRound();
    }

    public Player getPlayer() {
        return table.getActualPlayer();
    }

    public void drawCardsPlayerInTurn(){
        this.gameView.drawCardsPlayerInTurn(table.getActualPlayer().getHand() , table.getActualPlayer());
    }

    public void drawSlotPlayerInTurn(){
        this.gameView.drawSlotPlayerInTurn( table.getActualPlayer().getSlot());
    }

    public void drawSlotOtherPlayer(){
        this.gameView.drawSlotOtherPlayer( this.getOtherPlayer().getSlot() );
    }


    public void playCard(int i) {
        try {
            table.getActualPlayer().playCard( table.getActualPlayer().getHand().getCards().get(i-1) );
            this.drawRound();
        } catch (Exception e) {

        }
    }

    public Player getOtherPlayer() {
        Player playerToReturn = null;

        for (Player actualPlayer : this.table.getPlayers()){
            if (! actualPlayer.equals( this.table.getActualPlayer() )){
                playerToReturn = actualPlayer;
            }
        }
        return playerToReturn;
    }

    public void drawRound() {
        this.drawSlotPlayerInTurn();
        this.drawSlotOtherPlayer();
        this.drawCardsPlayerInTurn();
        this.drawScores();
    }
}