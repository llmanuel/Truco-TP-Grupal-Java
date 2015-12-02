package controllers;

import model.Builder;
import model.Exceptions.*;
import model.HumanPlayer;
import model.Player;
import model.Table;
import view.TwoPlayersGame;

import java.util.LinkedList;

public class TwoPlayersMatchController  {

    private Table table;
    private TwoPlayersGame gameView;
    private HumanPlayer Player1, Player2;
    private Builder builder;
    private LinkedList<Player> players;

    public TwoPlayersMatchController(TwoPlayersGame newGameView/*, Table newTable*/) throws InvalidNumberOfPlayersException {
        gameView = newGameView;
        builder = new Builder(2);
        players = builder.getPlayers();
        this.table = builder.getTable();
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

    public void drawCardsPlayerInTurn(){
        this.gameView.drawCardsPlayerInTurn(table.getActualPlayer().getHand() , table.getActualPlayer());
    }

    public void drawSlotPlayerInTurn(){
        this.gameView.drawSlotPlayerInTurn( table.getActualPlayer().getSlot());
    }


    public void playCard(int i) {
        try {
            table.getActualPlayer().playCard( table.getActualPlayer().getHand().getCards().get(i-1) );
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (DonTHaveThatCardException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        }
    }
}
