package controllers;

import model.Builder;
import model.Exceptions.*;
import model.Player;
import model.Scoreboard;
import model.Table;
import view.TwoPlayersGame;

public class TwoPlayersMatchController  {

    private Table table;
    private TwoPlayersGame gameView;
    private Builder builder;
    private boolean notInFirstRound;
    private boolean envidoHasAlreadyBeenCalled;

    private boolean callWaiting;//avisa si hay algun llamado al que responder. se usa para saber si se puede responder algo con quiero/no quiero.

    public TwoPlayersMatchController(TwoPlayersGame newGameView) throws InvalidNumberOfPlayersException {
        gameView = newGameView;
        builder = new Builder(2);
        this.table = builder.getTable();
        this.startGame();
    }

    private void startGame() {
        this.drawCardsPlayerInTurn();
        this.drawSlotPlayerInTurn();
        this.drawSlotOtherPlayer();
        this.drawScores();
        this.notInFirstRound = false;
        this.envidoHasAlreadyBeenCalled = false;
        this.callWaiting = false;
    }

    public void drawScores() {
        this.gameView.drawScores(table.getScoreboard(), table.getPlayers());
    }


    public void callEnvido() throws InvalidGameCallException, NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callEnvido();
        envidoHasAlreadyBeenCalled = true;
        callWaiting = true;
   }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callRealEnvido();
        envidoHasAlreadyBeenCalled = true;
        callWaiting = true;
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callFaltaEnvido();
        envidoHasAlreadyBeenCalled = true;
        callWaiting = true;
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callTruco();
        callWaiting = true;
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callReTruco();
        callWaiting = true;
    }

    public  void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().callVale4();
        callWaiting = true;
    }

    public void callFlor() {
        table.getActualPlayer().callFlor();
        callWaiting = true;
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException {
        table.getActualPlayer().acceptCall();
        callWaiting = false;
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

    public void drawSlotOtherPlayer(){
        this.gameView.drawSlotOtherPlayer( this.getOtherPlayer().getSlot() );
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

    public Player getOtherPlayer() {
        Player playerToReturn = null;

        for (Player actualPlayer : this.table.getPlayers()){
            if (! actualPlayer.equals( this.table.getActualPlayer() )){
                playerToReturn = actualPlayer;
            }
        }
        return playerToReturn;
    }

    public boolean cantCallEnvidoAnyMore() {
        return (envidoHasAlreadyBeenCalled || notInFirstRound);
    }

    public boolean isCallWaiting(){
        return callWaiting;
    }

}