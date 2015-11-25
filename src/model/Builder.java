package model;

import java.util.LinkedList;

public class Builder {

    public Builder(int numberOfPlayers){

        LinkedList<Player> thePlayers = new LinkedList<Player>();
        LinkedList<CanHaveScore> theCanHaveScorePL = new LinkedList<CanHaveScore>();

        /*creating required n. of players*/
        for (int i = 1; i <= numberOfPlayers; i++){
            HumanPlayer newPlayer = new HumanPlayer(i);
            thePlayers.add(newPlayer);
            theCanHaveScorePL.add(newPlayer);
        }

        Table table = new Table();
        Scoreboard theScoreboard = new Scoreboard( theCanHaveScorePL, table );

        Judge judge = new Judge(theScoreboard);

        table.getAJudge(judge);
        table.getScoreBoard(theScoreboard);
    }
}
