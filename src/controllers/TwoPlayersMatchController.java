package controllers;

import model.Card;
import model.Exceptions.*;
import model.Player;
import model.Table;
import view.MainScreenForTwoPlayersGame;

import java.util.LinkedList;

/**
 * Created by lucas on 30/11/15.
 */

public class TwoPlayersMatchController  {

    private Table table;
    private MainScreenForTwoPlayersGame gameView;

    public TwoPlayersMatchController(MainScreenForTwoPlayersGame newGameView, Table newTable) {

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

    public void changeCardLabel (Player player){

        LinkedList<String> namesOfTheCards = new LinkedList<String>();
        Card card;

        for (Card actualCard : player.getHand().getCards()) {
            String cardName = new String();
            cardName = actualCard.getNumber().toString() + " " + actualCard.getSuit();
            namesOfTheCards.add(cardName);
        }

        gameView.refreshCardsLabels(namesOfTheCards, player.getIdNumber());

    }

    public void putPlayerName(Player player){

        gameView.setPlayerName(player);
    }


    public void drawData() {

            this.putPlayerName( this.table.getActualPlayer() );
            this.changeCardLabel( this.table.getActualPlayer() );

    }

    public void playCard(Card card) {

        try {
            table.getActualPlayer().playCard(card);
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (DonTHaveThatCardException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        }

        gameView.checkSelectedCard(table.getActualPlayer().getHand().getCards(), table.getActualPlayer(), card);

    }

    public Player getPlayer() {

        return table.getActualPlayer();
    }
}
