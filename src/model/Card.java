package model;

public class Card {
    private final Integer number;
    private final Integer value;
    private final String suit;

    public Card(Integer number, String suit, Integer value) {

        this.number = number;
        this.suit = suit;
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }

    public Integer getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }
}
