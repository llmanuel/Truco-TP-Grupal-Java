package controllers;

import model.Exceptions.InvalidGameCallException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;
import model.Table;

/**
 * Created by lucas on 30/11/15.
 */

public class MatchController {

    private Table table;

    private void setTable(Table newTable) {

        table = newTable;
    }

    public void callEnvido() throws InvalidGameCallException, NotYourTurnException, NotCardThrownException, TeamDoesntExistException {

        table.getActualPlayer().callEnvido();

   }

    




}
