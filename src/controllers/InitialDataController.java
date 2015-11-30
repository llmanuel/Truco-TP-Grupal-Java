package controllers;

import model.Builder;
import model.Exceptions.InvalidNumberOfPlayersException;

public class InitialDataController {

    private Builder builder;

    public void prepareTableFor(int i) {
        try {
            builder = new Builder( i );
        } catch (InvalidNumberOfPlayersException e) {

        }

    }

}
