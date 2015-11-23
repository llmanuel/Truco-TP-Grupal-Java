package model;


public class Vale4 implements Games {
    int points = 4;
    private Table theTable;

    public void Vale4(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
