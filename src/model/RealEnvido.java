package model;

public class RealEnvido implements Games {
    int points = 3;
    private Table theTable;

    public void RealEnvido(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
