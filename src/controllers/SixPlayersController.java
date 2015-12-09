package controllers;

import model.Builder;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Player;
import model.Table;
import view.SixPlayersGame;

import java.util.LinkedList;

public class SixPlayersController {
    private Table table;
    private SixPlayersGame gameView;
    private Builder builder;
    private LinkedList<Player> players;
    private Player cursor;

    public SixPlayersController(SixPlayersGame sixPlayersGame) throws InvalidNumberOfPlayersException, NotCardThrownException {

        gameView = sixPlayersGame;
        builder = new Builder(6);
        players = builder.getPlayers();
        this.table = builder.getTable();
        this.startGame();

    }

    private void startGame() throws NotCardThrownException {
        this.initializeScores();
        this.setTeamsNames();
        this.drawCardsPlayerInTurn();
        this.drawSlotPlayerInTurn();
        this.drawSlotOtherPlayer();
    }

    private void initializeScores() {

        this.gameView.initializeScores();
    }

    private void setTeamsNames() {

        this.gameView.setTeamsNames();
    }

    public void drawSlotPlayerInTurn() {

        this.gameView.drawSlotPlayerInTurn(table.getActualPlayer().getSlot());
    }

    public void drawCardsPlayerInTurn() {

        this.gameView.drawCardsPlayerInTurn(table.getActualPlayer(), table.getActualPlayer().getHand());
    }

    public void drawSlotOtherPlayer() {

        cursor = table.getActualPlayer();
        LinkedList<Player> nextPlayers = new LinkedList<Player>();
        for (int i = 0; i < (this.table.getPlayers().size() - 1); i++){

            this.getTheNextOne();
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

    public void setCursorAt(Player cursorAtPlayer) {
        this.cursor = cursorAtPlayer;
    }


}
