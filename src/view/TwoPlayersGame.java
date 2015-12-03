package view;

import controllers.TwoPlayersMatchController;
import model.Exceptions.*;
import model.Hand;
import model.Player;
import model.Slot;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TwoPlayersGame extends JFrame {
    private static final int H = 800;
    private static final int W = 600;
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
    private TwoPlayersMatchController controller;

    public TwoPlayersGame() {
        super("Truco");

        try {
            controller = new TwoPlayersMatchController(this);
        } catch (InvalidNumberOfPlayersException e) {
            e.printStackTrace();
        }

        setContentPane(rootPanel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        // Button Listeners
        envidoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                envidoButtonClicked(mouseEvent);
            }
        });
        realEnvidoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                realEnvidoButtonClicked(mouseEvent);
            }
        });
        faltaEnvidoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                faltaEnvidoButtonClicked(mouseEvent);
            }
        });
        trucoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                trucoButtonClicked(mouseEvent);
            }
        });
        retrucoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                retrucoButtonClicked(mouseEvent);
            }
        });
        vale4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                vale4ButtonClicked(mouseEvent);
            }

        });
        florButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                florButtonClicked(mouseEvent);
            }
        });
        quieroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                quieroButtonClicked(mouseEvent);
            }
        });
        noQuieroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                noQuieroButtonClicked(mouseEvent);
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

    private void card1PlayerInTurnClicked(MouseEvent mouseEvent) {
        this.controller.playCard(1);
    }

    private void card2PlayerInTurnClicked(MouseEvent mouseEvent) {
        this.controller.playCard(2);
    }

    private void card3PlayerInTurnClicked(MouseEvent mouseEvent) {
        this.controller.playCard(3);
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

    private void noQuieroButtonClicked(MouseEvent mouseEvent) {
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

    private void quieroButtonClicked(MouseEvent mouseEvent) {
        try {
            this.controller.acceptCall();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        }
    }

    private void florButtonClicked(MouseEvent mouseEvent) {
        this.controller.callFlor();
    }

    private void vale4ButtonClicked(MouseEvent mouseEvent) {
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

    private void retrucoButtonClicked(MouseEvent mouseEvent) {
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

    private void trucoButtonClicked(MouseEvent mouseEvent) {
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

    private void faltaEnvidoButtonClicked(MouseEvent mouseEvent) {
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

    private void realEnvidoButtonClicked(MouseEvent mouseEvent) {
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

    private void envidoButtonClicked(MouseEvent mouseEvent) {
        try {
            this.controller.callEnvido();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    public void drawCardsPlayerInTurn(Hand playerHand, Player player){
        this.playerInTurnName.setText("Jugador " + player.getIdNumber());

        this.card1PlayerInTurn.setText( playerHand.getCards().get(0).getNumber().toString() + " de " + playerHand.getCards().get(0).getSuit() );
        this.card2PlayerInTurn.setText( playerHand.getCards().get(1).getNumber().toString() + " de " + playerHand.getCards().get(1).getSuit() );
        this.card3PlayerInTurn.setText( playerHand.getCards().get(2).getNumber().toString() + " de " + playerHand.getCards().get(2).getSuit() );


    }

    public void drawSlotPlayerInTurn(Slot playerSlot){

        try {
            this.card1SlotPlayerInTurn.setText( playerSlot.getFirstOne().getNumber().toString() + " de " + playerSlot.getFirstOne().getSuit());
            this.card2SlotPlayerInTurn.setText( playerSlot.getSecondOne().getNumber().toString() + " de " + playerSlot.getSecondOne().getSuit());
            this.card3SlotPlayerInTurn.setText( playerSlot.getThirdOne().getNumber().toString() + " de " + playerSlot.getThirdOne().getSuit());
        } catch (NotCardThrownException e) {
            this.card1SlotPlayerInTurn.setText(" ");
            this.card2SlotPlayerInTurn.setText(" ");
            this.card3SlotPlayerInTurn.setText(" ");

        }

    }
    
}
