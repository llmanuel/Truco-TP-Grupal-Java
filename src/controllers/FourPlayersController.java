package controllers;

import model.Builder;
import model.Exceptions.*;
import model.Player;
import model.Table;
import model.Team;
import view.FourPlayersGame;

import java.util.LinkedList;

public class FourPlayersController {
    private Table table;
    private final FourPlayersGame gameView;
    private Builder builder;
    private Player cursor;

    public FourPlayersController(FourPlayersGame newGameView) throws InvalidNumberOfPlayersException, NotCardThrownException {
        gameView = newGameView;
        builder = new Builder(4);
        this.table = builder.getTable();
        this.startGame();

    }

    private void startGame() {
        this.initializeScores();
        this.setTeamsNames();
        this.drawCardsPlayerInTurn();
        this.drawSlotPlayerInTurn();
        this.drawSlotOtherPlayer();
    }

    private void setTeamsNames() {

        this.gameView.setTeamsNames();
    }

    private void initializeScores() {

        this.gameView.initializeScores();
    }

    private void drawSlotPlayerInTurn() {

        this.gameView.drawSlotPlayerInTurn(table.getActualPlayer().getSlot());
    }


    private void drawCardsPlayerInTurn() {

        this.gameView.drawCardsPlayerInTurn(table.getActualPlayer(), table.getActualPlayer().getHand());
    }


    public void giveUpGame() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().giveUp();
        this.drawRound();
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException, TeamDoesntExistException, InvalidGameCallException, NothingToAcceptException {
        try {
            table.getActualPlayer().acceptCall();
            this.drawRound();
        }catch (NothingToAcceptException e){
            this.drawRound();
            throw new NothingToAcceptException();
        }
    }

    public void callFlor() throws NotYourTurnException, InvalidGameCallException, TeamDoesntExistException {
        table.getActualPlayer().callFlor();
        this.drawRound();
    }

    public void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callVale4();
        this.drawRound();
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callReTruco();
        this.drawRound();
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callTruco();
        this.drawRound();
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callFaltaEnvido();
        this.drawRound();
    }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callRealEnvido();
        this.drawRound();
    }

    public void callEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callEnvido();
        this.drawRound();
    }

    public void playCard(int i) {
        try {
            table.getActualPlayer().playCard(table.getActualPlayer().getHand().getCards().get(i - 1));
            this.drawRound();
        } catch (Exception ignored) {
        }
    }

    private void drawSlotOtherPlayer() {

        cursor = table.getActualPlayer();
        System.out.println("Jugador en turno :" + cursor.getIdNumber());
        LinkedList<Player> nextPlayers = new LinkedList<>();
        for (int i = 0; i < (this.table.getPlayers().size() - 1); i++){

            this.getTheNextOne();
            System.out.println("Jugador en lista de getTheNextOne :" + cursor.getIdNumber());
            nextPlayers.add(cursor);
        }
        this.gameView.drawSlotOtherPlayers(nextPlayers);
    }

    private void getTheNextOne() {

        try {
            int i = 0;
            while (cursor != table.getPlayers().get(i)) {
                i = i + 1;
            }
            i = i + 1;
            setCursorAt(table.getPlayers().get(i));
        } catch (IndexOutOfBoundsException e) {
            setCursorAt(table.getPlayers().getFirst());
        }
    }

    private void setCursorAt(Player cursorAtPlayer) {
        this.cursor = cursorAtPlayer;
    }

    private void drawScores() {

        LinkedList<Team> teams = new LinkedList<>();
        teams.addFirst(this.builder.getTeams().getFirst());
        teams.addLast(this.builder.getTeams().getLast());
        this.gameView.drawScores(table.getScoreboard(), teams);
    }

    private void drawRound() {
        this.drawSlotPlayerInTurn();
        this.drawSlotOtherPlayer();
        this.drawCardsPlayerInTurn();
        this.drawScores();
    }

    public void cleanPlayerInTurnCards() {

        this.gameView.cleanPlayerInTurnCards();
    }
}
