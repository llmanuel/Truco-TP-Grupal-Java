package controllers;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;
import model.Player;
import model.Table;
import view.TwoPlayersGame;

public class TwoPlayersMatchController  {

    private Table table;
    private TwoPlayersGame gameView;

    public TwoPlayersMatchController(TwoPlayersGame newGameView, Table newTable) {
        table = newTable;
        gameView = newGameView;
    }


    public void callEnvido() throws InvalidGameCallException, NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callEnvido();
   }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callRealEnvido();
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callFaltaEnvido();
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callTruco();
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callReTruco();
    }

    public  void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callVale4();
    }

    public void callFlor() {
        table.getActualPlayer().callFlor();
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException {
        table.getActualPlayer().acceptCall();
    }

    public void giveUpGame() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().giveUp();
    }

    public Player getPlayer() {
        return table.getActualPlayer();
    }


}
