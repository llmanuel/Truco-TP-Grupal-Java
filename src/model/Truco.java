package model;

public class Truco implements Games {
    int points = 2;

    @Override
    public int getPoints(){
        return this.points;
    }

}