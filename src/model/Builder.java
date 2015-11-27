package model;


import model.Exceptions.InvalidNumberOfPlayersException;

import java.util.LinkedList;

public class Builder {

    LinkedList<Player> players;

    public Builder(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        validateNumberOfPlayers(numberOfPlayers);
        createPlayers(numberOfPlayers);
    }

    private void createPlayers(int numberOfPlayers) {
        switch (numberOfPlayers){
//            case 2: createTwoPlayers();
//                break;
//            case 4: createFourPlayers();
//                break;
//            case 6: createSixPlayers();
//                break;
        }
    }

    private void validateNumberOfPlayers(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        if((numberOfPlayers != 2)&&(numberOfPlayers !=4)&&(numberOfPlayers !=6)){
            throw new InvalidNumberOfPlayersException();
        }
    }
}
