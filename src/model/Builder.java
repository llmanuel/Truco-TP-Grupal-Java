package model;


import model.Exceptions.InvalidNumberOfPlayersException;

public class Builder {

    public Builder(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        validateNumberOfPlayers(numberOfPlayers);
    }

    private void validateNumberOfPlayers(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        if((numberOfPlayers != 2)&&(numberOfPlayers !=4)&&(numberOfPlayers !=6)){
            throw new InvalidNumberOfPlayersException();
        }
    }
}
