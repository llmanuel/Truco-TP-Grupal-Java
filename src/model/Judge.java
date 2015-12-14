package model;

import model.Exceptions.*;
import model.TableStates.Games;

import java.util.LinkedList;

public class Judge {

    private final Scoreboard scoreboard;
    private final long[] roundWinsPerTeam;

    public Judge(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
        roundWinsPerTeam = new long[]{0, 0};
    }


    public boolean isCardAHigherThanCardB(Card cardA, Card cardB) {
        return (cardA.getValue()) > (cardB.getValue());
    }

    public void setWinnerOfEnvido(LinkedList<Slot> slots, Games actualGame) throws TeamDoesntExistException {
        int maximunValueOfEnvido = 0;
        Player envidoWinner = null;

        for (Slot actualSlot : slots) {
            Player actualPlayer = actualSlot.getPlayer();
            if (actualPlayer.calculateEnvido() > maximunValueOfEnvido) {
                envidoWinner = actualPlayer;
                maximunValueOfEnvido = actualPlayer.calculateEnvido();
            }
        }
        this.scoreboard.increaseTheScoreOf( envidoWinner, actualGame );

    }

    public Player setWinnerOfTheRound(LinkedList<Slot> slots) throws NotCardThrownException, SomebodyWonTheGame {
        int maximumCardInRound = 0;
        Player roundWinner = null;

        for (Slot actualSlot : slots) {
            if (actualSlot.getLastOne().getValue() > maximumCardInRound) {
                maximumCardInRound = actualSlot.getLastOne().getValue();
                roundWinner = actualSlot.getPlayer();
            }
        }
        assert roundWinner != null;
        this.setRoundWinsPerTeam(roundWinner);
        this.checkIfAnyoneWonTwoRounds();
        return roundWinner;
    }

    private void setRoundWinsPerTeam(Player roundWinner){

        Team firstTeam = this.scoreboard.getFirstTeam();
        if(firstTeam.isMember(roundWinner)){
            this.roundWinsPerTeam[0]++;
        } else this.roundWinsPerTeam[1]++;
    }

    private void checkIfAnyoneWonTwoRounds() throws SomebodyWonTheGame {
        if ( this.roundWinsPerTeam[0] == 2 || this.roundWinsPerTeam[1] == 2)
            throw new SomebodyWonTheGame();

    }

    public void setWinnerOfGame(LinkedList<Slot> slots, Games actualGame) throws TeamDoesntExistException {

            if (roundWinsPerTeam[0] > roundWinsPerTeam[1]) {
                scoreboard.increaseTheScoreOf( slots.get( 0 ).getPlayer(), actualGame );
            } else {
                scoreboard.increaseTheScoreOf( slots.get( 1 ).getPlayer(), actualGame );
            }
            this.roundWinsPerTeam[0] = 0;
            this.roundWinsPerTeam[1] = 0;
    }


}
