package view;

import controllers.FourPlayersController;
import model.*;
import model.Exceptions.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private JLabel thirdPlayerID;
    private JLabel firstPlayerID;
    private JLabel secondPlayerID;
    private FourPlayersController controller;
    private JDialog nextPlayer;

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
                try {
                    florButtonClicked();
                } catch (NotYourTurnException e) {
                    e.printStackTrace();
                } catch (TeamDoesntExistException e) {
                    e.printStackTrace();
                }
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

    public void showMassageNextPlayer() {

        JOptionPane.showMessageDialog(nextPlayer,"Turno del proximo jugador.","",JOptionPane.WARNING_MESSAGE);
    }

    private BufferedImage getCardImage(Card actualCard){
        String imagePath = "resources/images/cards/74x112/" + actualCard.getSuit() + "/" + actualCard.getNumber() + ".png";
        BufferedImage cardPicture = null;

        try {
            cardPicture = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            this.showMessage( "No se pudo leer archivo de imagen " + imagePath );
        }

        return cardPicture;
    }

    private void card3HandPlayerInTurnClicked() {

        this.showMassageNextPlayer();
        this.controller.playCard(3);

    }

    private void card2HandPlayerInTurnClicked() {

        this.showMassageNextPlayer();
        this.controller.playCard(2);

    }

    private void card1HandPlayerInTurnClicked() {

        this.showMassageNextPlayer();
        this.controller.playCard(1);

    }

    private void meVoyAlMazoButtonClicked() {
        try {
            this.showMassageNextPlayer();
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
            this.showMassageNextPlayer();
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
            this.showMassageNextPlayer();
            this.controller.acceptCall();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void florButtonClicked() throws NotYourTurnException, TeamDoesntExistException{
        try {
            this.showMassageNextPlayer();
            this.controller.callFlor();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void vale4ButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.callVale4();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void retrucoButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.callReTruco();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void trucoButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.callTruco();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void faltaEnvidoButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.callFaltaEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void realEnvidoButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.callRealEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void envidoButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.callEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    public void drawCardsPlayerInTurn(Player player, Hand playerHand) {
        this.idPlayerInTurn.setText("Jugador " + player.getIdNumber());

        this.clearHandPlayerInTurn();

        try {
            this.card1HandPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerHand.getCards().get(0) ) ) );
        } catch (IndexOutOfBoundsException e){
            this.card1HandPlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2HandPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerHand.getCards().get(1) ) ) );
        } catch (IndexOutOfBoundsException e){
            this.card2HandPlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3HandPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerHand.getCards().get(2) ) ) );
        } catch (IndexOutOfBoundsException e ){
            this.card3HandPlayerInTurn.setIcon( new ImageIcon(  ) );
        }
    }

    public void drawSlotPlayerInTurn(Slot playerSlot) {

        try {
            this.card1SlotPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerSlot.getFirstOne() ) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerSlot.getSecondOne() ) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerSlot.getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayerInTurn.setIcon( new ImageIcon(  ) );
        }
    }

    public void drawSlotOtherPlayers(LinkedList<Player> otherTeam) {

        this.secondPlayerID.setText("Jugador " + otherTeam.get(1).getIdNumber());
        try {
            this.card1SlotPlayerSameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(1).getSlot().getFirstOne()) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayerSameTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayerSameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(1).getSlot().getSecondOne()) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayerSameTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayerSameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(1).getSlot().getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayerSameTeam.setIcon( new ImageIcon(  ) );
        }

        this.firstPlayerID.setText("Jugador " + otherTeam.get(0).getIdNumber());
        try {
            this.card1SlotPlayer1OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(0).getSlot().getFirstOne()) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayer1OtherTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayer1OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(0).getSlot().getSecondOne()) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer1OtherTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayer1OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(0).getSlot().getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer1OtherTeam.setIcon( new ImageIcon(  ) );
        }

        this.thirdPlayerID.setText("Jugador " + otherTeam.get(2).getIdNumber());
        try {
            this.card1SlotPlayer2OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(2).getSlot().getFirstOne()) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayer2OtherTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayer2OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(2).getSlot().getSecondOne()) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer2OtherTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayer2OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(2).getSlot().getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer2OtherTeam.setIcon( new ImageIcon(  ) );
        }
    }

    public void initializeScores() {

        this.firstTeamScore.setText("0");
        this.secondTeamScore.setText("0");
    }

    public void setTeamsNames() {

        this.firstTeamName.setText("Equipo 1");
        this.secondTeamName.setText("Equipo 2");
    }

    private void clearHandPlayerInTurn() {

        this.card1HandPlayerInTurn.setText(" ");
        this.card2HandPlayerInTurn.setText(" ");
        this.card3HandPlayerInTurn.setText(" ");

    }

    public void drawScores(Scoreboard scoreboard, LinkedList<Team> teams) {

        try {

            this.firstTeamScore.setText(String.valueOf(scoreboard.getPointsOf(teams.getFirst())));
            this.secondTeamScore.setText(String.valueOf(scoreboard.getPointsOf(teams.getLast())));

        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (SecondTeamWonException e) {
            this.showMessage("Gano el Jugador 2");
        } catch (FirstTeamWonException e) {
        this.showMessage( "Gano el jugador 1" );
        }
    }
}




