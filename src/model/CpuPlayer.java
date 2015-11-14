package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class CpuPlayer implements Player {

    private int playerId;

    public CpuPlayer(int idNumber){
        playerId = idNumber;
    }

	@Override
	public int calculateEnvido() {
		// TODO Auto-generated method stub
		return 0;
	}

    public int getIdNumber(){
        return playerId;
    }
}
