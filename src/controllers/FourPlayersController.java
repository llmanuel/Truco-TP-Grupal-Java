package controllers;

import model.Builder;
import model.Exceptions.*;
import model.Player;
import model.Table;
import view.FourPlayersGame;

import java.util.LinkedList;

public class FourPlayersController {
    private Table table;
    private FourPlayersGame gameView;
    private Builder builder;
    private LinkedList<Player> players;

    public FourPlayersController(FourPlayersGame newGameView) throws InvalidNumberOfPlayersException {
        gameView = newGameView;
        builder = new Builder(4);
        players = builder.getPlayers();
        this.table = builder.getTable();
        this.startGame();

    }

    private void startGame() {
      //  this.drawCardsPlayerInTurn();
      //  this.drawSlotPlayerInTurn();
      //  this.drawSlotOtherPlayer();
    }

    public void giveUpGame() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().giveUp();
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException {
        table.getActualPlayer().acceptCall();
    }

    public void callFlor() {
        table.getActualPlayer().callFlor();
    }

    public void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callVale4();
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callReTruco();
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callTruco();
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callFaltaEnvido();
    }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callRealEnvido();
    }

    public void callEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callEnvido();
    }

    public void playCard(int i) throws NotYourTurnException, DonTHaveThatCardException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().playCard( table.getActualPlayer().getHand().getCards().get(i-1)  );
    }
}
