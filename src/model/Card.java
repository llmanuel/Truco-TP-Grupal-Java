package model;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Card {
    private Integer value;
    private String palo;

    public Card(Integer value, String palo) {
        this.value = value;
        this.palo = palo;
    }

    public Integer getValue() {
        return value;
    }
}
