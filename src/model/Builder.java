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
            case 2: createTwoPlayers();
                break;
            case 4: createFourPlayers();
                break;
            case 6: createSixPlayers();
                break;
        }
    }

    private void createTwoPlayers() {
        Player player1 = new HumanPlayer(1);
        Player player2 = new HumanPlayer(2);

        players.add(player1);
        players.add(player2);
    }

    private void createFourPlayers() {
        createTwoPlayers();

        Player player3 = new HumanPlayer(3);
        Player player4 = new HumanPlayer(4);

        players.add(player3);
        players.add(player4);
    }

    private void createSixPlayers() {
        createFourPlayers();

        Player player5 = new HumanPlayer(5);
        Player player6 = new HumanPlayer(6);

        players.add(player5);
        players.add(player6);
    }

    private void validateNumberOfPlayers(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        if((numberOfPlayers != 2)&&(numberOfPlayers !=4)&&(numberOfPlayers !=6)){
            throw new InvalidNumberOfPlayersException();
        }
    }
}
