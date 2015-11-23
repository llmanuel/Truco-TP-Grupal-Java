package model;

public class ReTruco implements Games {
    int points = 3;
    private Table theTable;

    public void ReTruco(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
