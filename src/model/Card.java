package model;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Card {
    private static final ArrayList<String> VALID_SUITS = new ArrayList<String>(Arrays.asList("ORO", "BASTO", "ESPADA", "COPA"));

    private Integer number, value;
    private String suit;

    public Card(Integer number, String suit, Integer value) throws InvalidCardNumberException, InvalidSuiteException {

        this.validateNumber(number);
        this.validateSuit(suit);

        this.number = number;
        this.suit = suit;
        this.value = value;
    }

    private void validateSuit(String suit) throws InvalidSuiteException {
        if (!VALID_SUITS.contains(suit)) {
            throw new InvalidSuiteException();
        }
    }

    private void validateNumber(Integer number) throws InvalidCardNumberException {
        if (number < 0 || number > 13) {
            throw new InvalidCardNumberException();
        }

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
