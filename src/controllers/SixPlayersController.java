package controllers;

import model.Builder;
import model.Exceptions.InvalidNumberOfPlayersException;
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

    public SixPlayersController(SixPlayersGame sixPlayersGame) throws InvalidNumberOfPlayersException {

        gameView = sixPlayersGame;
        builder = new Builder(6);
        players = builder.getPlayers();
        this.table = builder.getTable();
        this.startGame();

    }

    private void startGame() {
    }


}
