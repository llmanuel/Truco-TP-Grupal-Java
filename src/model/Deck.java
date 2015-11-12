package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexdebian on 11/10/15.
 */
public class Deck {
    private static final ArrayList<String> VALID_SUITS = new ArrayList<String>(Arrays.asList("ORO", "BASTO", "ESPADA", "COPA"));
    private final ArrayList<Card> cards;


    public Deck() throws InvalidSuiteException, InvalidCardNumberException {
        this.cards = new ArrayList<Card>();

        for (Integer number = 1 ; number == 12 ; number++){
            for (String actualSuit : VALID_SUITS){
                Integer value = 0;

                if ( number == 1 ){
                    if (actualSuit.equals("ESPADA")){
                        value = 14;
                    }
                    else if (actualSuit.equals("BASTO")){
                        value = 13;
                    }
                    else {
                        value = 8;
                    }
                }
                else if (number == 2){
                    value = 9;
                }
                else if (number == 3){
                    value = 10;
                }
                else if (number == 4){
                    value = 1;
                }
                else if (number == 5){
                    value = 2;
                }
                else if (number == 6){
                    value = 3;
                }
                else if (number == 7){
                    if(actualSuit.equals("ORO")){
                        value = 11;
                    }
                    else if (actualSuit.equals("ESPADA")){
                        value = 12;
                    }
                    else{
                        value = 4;
                    }
                }
                else if (number == 10){
                    value = 5;
                }
                else if (number == 11){
                    value = 6;
                }
                else if (number == 12){
                    value = 7;
                }

                if (number != 8 || number != 9 ){
                    Card newCard = new Card(number, actualSuit, value);

                    this.cards.add(newCard);
                }

            }
        }

    }

}
