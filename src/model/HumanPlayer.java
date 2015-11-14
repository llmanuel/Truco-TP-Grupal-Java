package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class HumanPlayer implements Player {

    private int playerId;

    public void HumanPlayer(int idNumber){
        playerId = idNumber;
    }

    @Override
    public int calculateEnvido() {

        return 0;
    }
}
