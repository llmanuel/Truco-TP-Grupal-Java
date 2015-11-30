package model;


import model.Exceptions.InvalidNumberOfPlayersException;
import view.MainScreenForTwoPlayersGame;

import javax.swing.*;
import java.util.LinkedList;

public class Builder {

    LinkedList<Player> players = new LinkedList<Player>();
    LinkedList<Team> teams = new LinkedList<Team>();

    Table table = new Table();
    Team team1;
    Team team2;
    Scoreboard scoreboard;
    Judge judge;

    JFrame gameView = new JFrame();
    //MainScreenForTwoPlayersGame twoPlayersGame;

    public Builder(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        validateNumberOfPlayers(numberOfPlayers);
        createPlayers(numberOfPlayers);
        setTeams();
        prepareTable();
        setScoreboard();
        setJudge();
    }

     private void setScoreboard() {

        scoreboard = new Scoreboard(teams, table);

    }

    private void setJudge() {

        judge = new Judge(scoreboard);
    }

    private void setTeams() {
        LinkedList<Player> playersTeam1 = new LinkedList<Player>();
        LinkedList<Player> playersTeam2 = new LinkedList<Player>();

        for(int i = 0; i < players.size(); i++){
            if (i%2 == 0){
                playersTeam1.add(players.get(i));
            }else{
                playersTeam2.add(players.get(i));
            }
        }

        this.team1 = new Team(playersTeam1);
        this.team2 = new Team(playersTeam2);

        this.teams.add(team1);
        this.teams.add(team2);
    }

    private void prepareTable() throws InvalidNumberOfPlayersException {
        this.table.letSitThese(players);
        this.table.setJudge(judge);
        this.table.setScoreBoard(scoreboard);
        this.table.setTeams(team1, team2);
        this.table.setGame();
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

    public LinkedList<Player> getPlayers() {

        return players;
    }

    public LinkedList<Team> getTeams() {

        return teams;
    }

    public Table getTable() {
        return table;
    }
}
