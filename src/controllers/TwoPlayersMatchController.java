package controllers;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;
import view.MainScreenForTwoPlayersGame;

/**
 * Created by lucas on 30/11/15.
 */

public class TwoPlayersMatchController {

    private Table table;
    private MainScreenForTwoPlayersGame gameView;

    public TwoPlayersMatchController(MainScreenForTwoPlayersGame newGameView) {

        //table = newTable;
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

    public void changeCardLabel (){

        String cardName;

        table.getActualPlayer().getHand();


    }




}
