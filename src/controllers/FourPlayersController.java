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
    private int turn = 1;

    public FourPlayersController(FourPlayersGame newGameView) throws InvalidNumberOfPlayersException, NotCardThrownException {
        gameView = newGameView;
        builder = new Builder(4);
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

    private void setTeamsNames() {

        this.gameView.setTeamsNames();
    }

    private void initializeScores() {

        this.gameView.initializeScores();
    }

    public void drawSlotPlayerInTurn() {

        this.gameView.drawSlotPlayerInTurn( table.getActualPlayer().getSlot());
    }


    public void drawCardsPlayerInTurn() {

        this.gameView.drawCardsPlayerInTurn(table.getActualPlayer(), table.getActualPlayer().getHand());
    }


    public void giveUpGame() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException {
        table.getActualPlayer().giveUp();
    }

    public void acceptCall() throws NotCardThrownException, NotYourTurnException, TeamDoesntExistException {
        table.getActualPlayer().acceptCall();
    }

    public void callFlor() throws NotYourTurnException, InvalidGameCallException, TeamDoesntExistException {
        table.getActualPlayer().callFlor();
    }

    public void callVale4() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callVale4();
    }

    public void callReTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callReTruco();
    }

    public void callTruco() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callTruco();
    }

    public void callFaltaEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callFaltaEnvido();
    }

    public void callRealEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callRealEnvido();
    }

    public void callEnvido() throws NotYourTurnException, NotCardThrownException, TeamDoesntExistException, InvalidGameCallException {
        table.getActualPlayer().callEnvido();
    }

    public void playCard(int i) {
        try {
            table.getActualPlayer().playCard(table.getActualPlayer().getHand().getCards().get(i - 1));
        }
        catch (Exception e) {}
    }

    public void drawSlotOtherPlayer() {
        if (turn > 4){ turn = 1; }

        LinkedList<Player> otherTeam = this.getOtherTeam();

        this.turn = turn + 1;
        Player partner = this.getAcutalPlayerPartner();
        this.gameView.drawSlotOtherPlayers(partner, otherTeam);
    }

    public Player getAcutalPlayerPartner() {

        if (this.table.getActualPlayer().getIdNumber() == this.table.getTeamOfActualPlayer().getMembers().get(0).getIdNumber()){

            return this.table.getTeamOfActualPlayer().getMembers().get(1);
        }
        return this.table.getTeamOfActualPlayer().getMembers().get(0);
    }

    public LinkedList<Player> getOtherTeam() {

         LinkedList<Player> otherTeam = null;
        if (this.builder.getTeams().getFirst().isMember(this.table.getActualPlayer())) {

            otherTeam = this.builder.getTeams().getLast().getMembers();
        } else {

            otherTeam = this.builder.getTeams().getFirst().getMembers();
        }
        System.out.println("Turno numero: " + turn);
        if ((turn == 2) || (turn == 3) || (turn ==4 )){
        System.out.println("Invirtio");
            return this.invertOrderOfPlayers(otherTeam);
        }
        return otherTeam;

    }

    private LinkedList<Player> invertOrderOfPlayers(LinkedList<Player> otherTeam) {

        Player player = otherTeam.removeFirst();
        otherTeam.addLast(player);

        return otherTeam;
    }
}
//    (third-first)
//1-3   4   -   2           / 1 ronda
//2-4   3   -   1           / 2 ronda invertir queda 1-3
//3-1   4   -   2           / 3 ronda invertir queda 2-4
//4-2   1   -   3           / 4 ronda invertit queda 3-1