package view;

import controllers.TwoPlayersMatchController;
import model.Exceptions.*;
import model.Hand;
import model.Player;
import model.Scoreboard;
import model.Slot;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class TwoPlayersGame extends JFrame {
    private JButton vale4Button;
    private JButton noQuieroButton;
    private JButton florButton;
    private JButton realEnvidoButton;
    private JButton faltaEnvidoButton;
    private JButton retrucoButton;
    private JButton trucoButton;
    private JButton envidoButton;
    private JButton quieroButton;
    private JPanel rootPanel;
    private JLabel card1PlayerInTurn;
    private JLabel firstCardPlayedByOtherPlayer;
    private JLabel card2PlayerInTurn;
    private JLabel secondCardPlayedByOtherPlayer;
    private JLabel thirdCardPlayedByOtherPlayer;
    private JLabel card3PlayerInTurn;
    private JLabel card1SlotPlayerInTurn;
    private JLabel card2SlotPlayerInTurn;
    private JLabel card3SlotPlayerInTurn;
    private JLabel playerInTurnName;
    private JButton meVoyAlMazoButton;
    private JLabel secondPlayerID;
    private JLabel firstPlayerID;
    private JLabel firstPlayerScore;
    private JLabel secondPlayerScore;
    private TwoPlayersMatchController controller;

    public TwoPlayersGame() {
        super("Truco");

        try {
            controller = new TwoPlayersMatchController(this);
        } catch (InvalidNumberOfPlayersException e) {
            this.showMessage("Cantidad Invalida de Jugadores.");
        }

        setContentPane(rootPanel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Button Listeners
        envidoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                envidoButtonClicked();
            }
        });
        realEnvidoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                realEnvidoButtonClicked();
            }
        });
        faltaEnvidoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                faltaEnvidoButtonClicked();
            }
        });
        trucoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                trucoButtonClicked();
            }
        });
        retrucoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                retrucoButtonClicked();
            }
        });
        vale4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                vale4ButtonClicked();
            }

        });
        florButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                florButtonClicked();
            }
        });
        quieroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                quieroButtonClicked();
            }
        });
        noQuieroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                noQuieroButtonClicked();
            }
        });
        meVoyAlMazoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                meVoyAlMazoButtonClicked();
            }
        });

        card1PlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                card1PlayerInTurnClicked(mouseEvent);
            }
        });
        card2PlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                card2PlayerInTurnClicked(mouseEvent);
            }
        });
        card3PlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                card3PlayerInTurnClicked(mouseEvent);
            }
        });

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog( null, message );
    }

    private void card1PlayerInTurnClicked(MouseEvent mouseEvent) {
        this.controller.playCard(1);
        this.controller.drawSlotPlayerInTurn();
        this.controller.drawSlotOtherPlayer();
        this.controller.drawCardsPlayerInTurn();
    }

    private void card2PlayerInTurnClicked(MouseEvent mouseEvent) {
        this.controller.playCard(2);
        this.controller.drawSlotPlayerInTurn();
        this.controller.drawSlotOtherPlayer();
        this.controller.drawCardsPlayerInTurn();
    }

    private void card3PlayerInTurnClicked(MouseEvent mouseEvent) {
        this.controller.playCard(3);
        this.controller.drawSlotPlayerInTurn();
        this.controller.drawSlotOtherPlayer();
        this.controller.drawCardsPlayerInTurn();
    }

    private void meVoyAlMazoButtonClicked() {
        try {
            this.controller.giveUpGame();
            this.controller.drawScores();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {

        } catch (TeamDoesntExistException e) {

        }
    }

    private void noQuieroButtonClicked() {
        try {
            this.controller.giveUpGame();
            enableNotEnvidoButtons();
            this.controller.drawScores();
            if(this.controller.cantCallEnvidoAnyMore()){
                disableEnvidoButtons();
            }
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void quieroButtonClicked() {
        try {
            this.controller.acceptCall();
            enableNotEnvidoButtons();
            this.controller.drawScores();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        }
    }

    private void florButtonClicked() {
        this.controller.callFlor();
    }

    private void vale4ButtonClicked() {
        try {
            this.controller.callVale4();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void retrucoButtonClicked() {
        try {
            this.controller.callReTruco();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void trucoButtonClicked() {
        try {
            this.controller.callTruco();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void faltaEnvidoButtonClicked() {
        try {
            this.controller.callFaltaEnvido();
            disableNotEnvidoButtons();
            disableEnvidoButtons();
            quieroButton.setEnabled(true);
            showMessage("Falta envido cantado");
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    /**disables envidoButton, realEnvidoButton, faltaEnvidoButton, quieroButton and florButton*/
    private void disableEnvidoButtons() {
        envidoButton.setEnabled(false);
        realEnvidoButton.setEnabled(false);
        faltaEnvidoButton.setEnabled(false);
        quieroButton.setEnabled(false);
        florButton.setEnabled(false);
    }

    private void realEnvidoButtonClicked() {
        try {
            this.controller.callRealEnvido();
            disableNotEnvidoButtons();
            showMessage("Real Envido cantado");
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void envidoButtonClicked() {
        try {
            this.controller.callEnvido();
            disableNotEnvidoButtons();
            showMessage("Envido cantado");
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void disableNotEnvidoButtons() {
        vale4Button.setEnabled(false);
        retrucoButton.setEnabled(false);
        trucoButton.setEnabled(false);
        card1PlayerInTurn.setEnabled(false);
        card2PlayerInTurn.setEnabled(false);
        card3PlayerInTurn.setEnabled(false);
    }

    private void enableNotEnvidoButtons() {
        vale4Button.setEnabled(true);
        retrucoButton.setEnabled(true);
        trucoButton.setEnabled(true);
        card1PlayerInTurn.setEnabled(true);
        card2PlayerInTurn.setEnabled(true);
        card3PlayerInTurn.setEnabled(true);
    }

    public void drawCardsPlayerInTurn(Hand playerHand, Player player){
        this.playerInTurnName.setText("Jugador " + player.getIdNumber());

        this.clearHandPlayerInTurn();

        try {
            this.card1PlayerInTurn.setText(playerHand.getCards().get(0).getNumber().toString() + " de " + playerHand.getCards().get(0).getSuit());
        } catch (IndexOutOfBoundsException e){
            this.card1PlayerInTurn.setText(" ");
        }

        try {
            this.card2PlayerInTurn.setText( playerHand.getCards().get(1).getNumber().toString() + " de " + playerHand.getCards().get(1).getSuit() );
        } catch (IndexOutOfBoundsException e){
            this.card2PlayerInTurn.setText(" ");
        }

        try {
            this.card3PlayerInTurn.setText( playerHand.getCards().get(2).getNumber().toString() + " de " + playerHand.getCards().get(2).getSuit() );
        } catch (IndexOutOfBoundsException e ){
            this.card3PlayerInTurn.setText(" ");
        }


    }

    private void clearHandPlayerInTurn() {
        this.card1PlayerInTurn.setText(" ");
        this.card2PlayerInTurn.setText(" ");
        this.card3PlayerInTurn.setText(" ");



    }

    public void drawSlotPlayerInTurn(Slot playerSlot){

        try {
            this.card1SlotPlayerInTurn.setText( playerSlot.getFirstOne().getNumber().toString() + " de " + playerSlot.getFirstOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card1SlotPlayerInTurn.setText(" ");
        }

        try {
            this.card2SlotPlayerInTurn.setText( playerSlot.getSecondOne().getNumber().toString() + " de " + playerSlot.getSecondOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card2SlotPlayerInTurn.setText(" ");
        }

        try {
            this.card3SlotPlayerInTurn.setText( playerSlot.getThirdOne().getNumber().toString() + " de " + playerSlot.getThirdOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card3SlotPlayerInTurn.setText(" ");
        }

    }

    public void drawSlotOtherPlayer(Slot otherPlayerSlot) {
        try {
            this.firstCardPlayedByOtherPlayer.setText( otherPlayerSlot.getFirstOne().getNumber().toString() + " de " + otherPlayerSlot.getFirstOne().getSuit());
        } catch (NotCardThrownException e) {
            this.firstCardPlayedByOtherPlayer.setText(" ");
        }

        try {
            this.secondCardPlayedByOtherPlayer.setText( otherPlayerSlot.getSecondOne().getNumber().toString() + " de " + otherPlayerSlot.getSecondOne().getSuit());
        } catch (NotCardThrownException e) {
            this.secondCardPlayedByOtherPlayer.setText(" ");
        }

        try {
            this.thirdCardPlayedByOtherPlayer.setText( otherPlayerSlot.getThirdOne().getNumber().toString() + " de " + otherPlayerSlot.getThirdOne().getSuit());
        } catch (NotCardThrownException e) {
            this.thirdCardPlayedByOtherPlayer.setText(" ");
        }
    }

    public void drawScores(Scoreboard scoreboard, LinkedList<Player> players) {
        try {
            firstPlayerScore.setText(String.valueOf(scoreboard.getPointsOf(players.get(0))));
            secondPlayerScore.setText(String.valueOf(scoreboard.getPointsOf(players.get(1))));
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }
}
