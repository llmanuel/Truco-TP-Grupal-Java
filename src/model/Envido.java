package model;

public class Envido implements Games {
    int points = 2;
    private Table theTable;

    public void Envido(Table theTable){
        this.theTable = theTable;
    }

    @Override
    public void raiseBet(){

//        this.theTable.raiseBet();
    }

    @Override
    public int getPoints(){
        return this.points;
    }
}
