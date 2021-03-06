package model;


import model.Exceptions.InvalidNumberOfPlayersException;

import java.util.LinkedList;

public class Builder {

    private final LinkedList<Player> players = new LinkedList<>();
    private final LinkedList<Team> teams = new LinkedList<>();

    private Table table ;
    private Team team1;
    private Team team2;
    private Scoreboard scoreboard;
    private Judge judge;

    public Builder(int numberOfPlayers) throws InvalidNumberOfPlayersException {
        validateNumberOfPlayers(numberOfPlayers);
        createTable();
        createPlayers(numberOfPlayers);
        setTeams();
        setScoreboard();
        setJudge();
        prepareTable();
    }


    public Builder(int numberOfHumanPlayers, int numberOfCpuPlayers) throws InvalidNumberOfPlayersException {
        validateNumberOfPlayers(numberOfHumanPlayers+numberOfCpuPlayers);
        createTable();
        createPlayersWithCpu();
        setTeams();
        setScoreboard();
        setJudge();
        prepareTable();
    }

    private void createPlayersWithCpu() {
        Player player1 = new HumanPlayer(1);
        Player player2 = new CpuPlayer(2);

        player1.setTable( this.table );
        player2.setTable( this.table );

        players.add(player1);
        players.add(player2);
    }


    private void createTable() {
        this.table = new Table();
    }

    private void setScoreboard() {

        scoreboard = new Scoreboard(teams, table);

    }

    private void setJudge() {

        judge = new Judge(scoreboard);
    }

    private void setTeams() {
        LinkedList<Player> playersTeam1 = new LinkedList<>();
        LinkedList<Player> playersTeam2 = new LinkedList<>();

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

        player1.setTable( this.table );
        player2.setTable( this.table );

        players.add(player1);
        players.add(player2);

    }

    private void createFourPlayers() {
        createTwoPlayers();

        Player player3 = new HumanPlayer(3);
        Player player4 = new HumanPlayer(4);

        player3.setTable( this.table );
        player4.setTable( this.table );

        players.add(player3);
        players.add(player4);
    }

    private void createSixPlayers() {
        createFourPlayers();

        Player player5 = new HumanPlayer(5);
        Player player6 = new HumanPlayer(6);

        player5.setTable( this.table );
        player6.setTable( this.table );

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
