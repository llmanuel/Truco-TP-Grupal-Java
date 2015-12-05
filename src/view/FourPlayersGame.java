package view;

import controllers.FourPlayersController;
import model.Exceptions.*;
import model.Player;
import model.Slot;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class FourPlayersGame extends JFrame {
    private JPanel rootPanel;
    private JButton envidoButton;
    private JButton trucoButton;
    private JButton noQuieroButton;
    private JButton quieroButton;
    private JButton realEnvidoButton;
    private JButton faltaEnvidoButton;
    private JButton florButton;
    private JButton reTrucoButton;
    private JButton vale4Button;
    private JButton meVoyAlMazoButton;
    private JLabel card1SlotPlayerSameTeam;
    private JLabel card2SlotPlayerSameTeam;
    private JLabel card3SlotPlayerSameTeam;
    private JLabel card3SlotPlayer1OtherTeam;
    private JLabel card2SlotPlayer1OtherTeam;
    private JLabel card1SlotPlayer1OtherTeam;
    private JLabel card1SlotPlayer2OtherTeam;
    private JLabel card2SlotPlayer2OtherTeam;
    private JLabel card3SlotPlayer2OtherTeam;
    private JLabel card3HandPlayerInTurn;
    private JLabel card2HandPlayerInTurn;
    private JLabel card1HandPlayerInTurn;
    private JLabel idPlayerInTurn;
    private JLabel card1SlotPlayerInTurn;
    private JLabel card2SlotPlayerInTurn;
    private JLabel card3SlotPlayerInTurn;
    private JLabel firstTeamName;
    private JLabel secondTeamName;
    private JLabel firstTeamScore;
    private JLabel secondTeamScore;
    private FourPlayersController controller;

    public FourPlayersGame() throws NotCardThrownException {
        super("Truco");

        try {
            controller = new FourPlayersController(this);
        } catch (InvalidNumberOfPlayersException e) {
            this.showMessage("Cantidad Invalida de Jugadores.");
        }
        setContentPane(rootPanel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


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
        reTrucoButton.addMouseListener(new MouseAdapter() {
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


        card1HandPlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                    card1HandPlayerInTurnClicked();

            }
        });
        card2HandPlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                    card2HandPlayerInTurnClicked();

            }
        });
        card3HandPlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                    card3HandPlayerInTurnClicked();

            }
        });
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog( null, message );
    }

    private void card3HandPlayerInTurnClicked() {
        try {
            this.controller.playCard(3);
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (DonTHaveThatCardException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
        this.controller.drawSlotPlayerInTurn();
        this.controller.drawSlotOtherPlayer();
        this.controller.drawCardsPlayerInTurn();
    }

    private void card2HandPlayerInTurnClicked() {
        try {
            this.controller.playCard(2);
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (DonTHaveThatCardException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
        this.controller.drawSlotPlayerInTurn();
        this.controller.drawSlotOtherPlayer();
        this.controller.drawCardsPlayerInTurn();
    }

    private void card1HandPlayerInTurnClicked() {

        try {
            this.controller.playCard(1);
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (DonTHaveThatCardException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
        this.controller.drawSlotPlayerInTurn();
        this.controller.drawSlotOtherPlayer();
        this.controller.drawCardsPlayerInTurn();
    }

    private void meVoyAlMazoButtonClicked() {
        try {
            this.controller.giveUpGame();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void noQuieroButtonClicked() {
        try {
            this.controller.giveUpGame();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void quieroButtonClicked() {
        try {
            this.controller.acceptCall();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        }
    }

    private void florButtonClicked() {
        this.controller.callFlor();
    }

    private void vale4ButtonClicked() {
        try {
            this.controller.callVale4();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void faltaEnvidoButtonClicked() {
        try {
            this.controller.callFaltaEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void realEnvidoButtonClicked() {
        try {
            this.controller.callRealEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void envidoButtonClicked() {
        try {
            this.controller.callEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    public void drawCardsPlayerInTurn(Player player) throws NotCardThrownException {
        this.idPlayerInTurn.setText("Jugador " + player.getIdNumber());

        this.card1SlotPlayerInTurn.setText(player.getHand().getCards().get(0).getNumber().toString() + " de " + player.getHand().getCards().get(0).getSuit());
        this.card2HandPlayerInTurn.setText(player.getHand().getCards().get(1).getNumber().toString() + " de " + player.getHand().getCards().get(1).getSuit());
        this.card3HandPlayerInTurn.setText(player.getHand().getCards().get(2).getNumber().toString() + " de " + player.getHand().getCards().get(2).getSuit());

    }

    public void drawSlotPlayerInTurn(Slot playerSlot) {

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


    public void drawSlotOtherPlayers(LinkedList<Player> otherTeam) {
        try {
            this.card1SlotPlayer2OtherTeam.setText( otherTeam.get(0).getSlot().getFirstOne().getNumber().toString() + " de " + otherTeam.get(0).getSlot().getFirstOne().getSuit());

        } catch (NotCardThrownException e) {
            this.card1SlotPlayer2OtherTeam.setText(" ");
        }

        try {
            this.card2SlotPlayer2OtherTeam.setText( otherTeam.get(0).getSlot().getSecondOne().getNumber().toString() + " de " + otherTeam.get(0).getSlot().getSecondOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer2OtherTeam.setText(" ");
        }

        try {
            this.card3SlotPlayer2OtherTeam.setText( otherTeam.get(0).getSlot().getThirdOne().getNumber().toString() + " de " + otherTeam.get(0).getSlot().getThirdOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer2OtherTeam.setText(" ");
        }

        try {
            this.card1SlotPlayer1OtherTeam.setText( otherTeam.get(1).getSlot().getFirstOne().getNumber().toString() + " de " + otherTeam.get(1).getSlot().getFirstOne().getSuit());

        } catch (NotCardThrownException e) {
            this.card1SlotPlayer1OtherTeam.setText(" ");
        }

        try {
            this.card2SlotPlayer1OtherTeam.setText( otherTeam.get(1).getSlot().getSecondOne().getNumber().toString() + " de " + otherTeam.get(1).getSlot().getSecondOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer1OtherTeam.setText(" ");
        }

        try {
            this.card3SlotPlayer1OtherTeam.setText( otherTeam.get(1).getSlot().getThirdOne().getNumber().toString() + " de " + otherTeam.get(1).getSlot().getThirdOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer1OtherTeam.setText(" ");
        }

    }

    public void initializeScores() {

        this.firstTeamScore.setText("0");
        this.secondTeamScore.setText("0");
    }
}




