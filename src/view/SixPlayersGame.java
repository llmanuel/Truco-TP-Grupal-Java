package view;

import controllers.SixPlayersController;
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

public class SixPlayersGame extends JFrame{
    private SixPlayersController controller;
    private JButton florButton;
    private JButton noQuieroButton;
    private JButton reTrucoButton;
    private JButton vale4Button;
    private JButton envidoButton;
    private JButton meVoyAlMazoButton;
    private JButton realEnvidoButton;
    private JButton faltaEnvidoButton;
    private JButton quieroButton;
    private JButton trucoButton;
    private JLabel card1HandPlayerInTurn;
    private JLabel card2HandPlayerInTurn;
    private JLabel card3HandPlayerInTurn;
    private JLabel team2ID;
    private JLabel team1ID;
    private JLabel team2Score;
    private JLabel team1Score;
    private JLabel player1SameTeamID;
    private JLabel card1SlotPlayer1SameTeam;
    private JLabel card2SlotPlayer1SameTeam;
    private JLabel card3SlotPlayer1SameTeam;
    private JLabel player2OtherTeamID;
    private JLabel card1SlotPlayer2OtherTeam;
    private JLabel card2SlotPlayer2OtherTeam;
    private JLabel card3SlotPlayer2OtherTeam;
    private JLabel player2SameTeamID;
    private JLabel card1SlotPlayer2SameTeam;
    private JLabel card2SlotPlayer2SameTeam;
    private JLabel card3SlotPlayer2SameTeam;
    private JLabel player3OtherTeamID;
    private JLabel card1SlotPlayer3OtherTeam;
    private JLabel card2SlotPlayer3OtherTeam;
    private JLabel card3SlotPlayer3OtherTeam;
    private JLabel card1SlotPlayerInTurn;
    private JLabel card2SlotPlayerInTurn;
    private JLabel card3SlotPlayerInTurn;
    private JLabel player1OtherTeamID;
    private JLabel card3SlotPlayer1OtherTeam;
    private JLabel card2SlotPlayer1OtherTeam;
    private JLabel card1SlotPlayer1OtherTeam;
    private JPanel rootPanel;
    private JLabel playerInTurnID;

    public SixPlayersGame() throws NotCardThrownException {
        super("Truco");

        try {
            controller = new SixPlayersController(this);
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

    private void card3HandPlayerInTurnClicked() {

        this.controller.cleanPlayerInTurnCards();
        this.showMassageNextPlayer();
        this.controller.playCard(3);

    }

    private void card2HandPlayerInTurnClicked() {

        this.controller.cleanPlayerInTurnCards();
        this.showMassageNextPlayer();
        this.controller.playCard(2);

    }

    private void card1HandPlayerInTurnClicked() {

        this.controller.cleanPlayerInTurnCards();
        this.showMassageNextPlayer();
        this.controller.playCard(1);

    }

    private void meVoyAlMazoButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.giveUpGame();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void noQuieroButtonClicked() {
        try {
            this.showMassageNextPlayer();
            this.controller.giveUpGame();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void quieroButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.acceptCall();
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (TeamDoesntExistException ignored) {

        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        }
    }

    private void florButtonClicked() {
        try {
            this.controller.callFlor();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (InvalidGameCallException | TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void vale4ButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.callVale4();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.showMessage( "No podes jugar Vale 4 en este momento" );
        }
    }

    private void retrucoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.callReTruco();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.showMessage( "No podes jugar Retruco en este momento" );
        }
    }

    private void trucoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.callTruco();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.showMessage( "No podes jugar Truco en este momento" );
        }
    }

    private void faltaEnvidoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.callFaltaEnvido();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.showMessage( "No podes jugar Falta Envido en este momento" );
        }
    }

    private void realEnvidoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.callRealEnvido();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.showMessage( "No podes jugar Real Envido en este momento" );
        }
    }

    private void envidoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
            this.showMassageNextPlayer();
            this.controller.callEnvido();
        } catch (InvalidGameCallException e) {
            this.showMessage( "No podes jugar Envido en este momento" );
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog( null, message );
    }

    public void setTeamsNames() {

        this.team1ID.setText("Equipo 1");
        this.team2ID.setText("Equipo 2");
    }

    public void initializeScores() {

        this.team1Score.setText("0");
        this.team2Score.setText("0");
    }

    private void clearHandPlayerInTurn() {

        this.card1HandPlayerInTurn.setText(" ");
        this.card2HandPlayerInTurn.setText(" ");
        this.card3HandPlayerInTurn.setText(" ");

    }

    public void drawSlotPlayerInTurn(Slot playerSlot) {

        try {
            this.card1SlotPlayerInTurn.setIcon(new ImageIcon(this.getCardImage(playerSlot.getFirstOne())));
        } catch (NotCardThrownException e) {
            this.card1SlotPlayerInTurn.setIcon(new ImageIcon());
        }

        try {
            this.card2SlotPlayerInTurn.setIcon(new ImageIcon(this.getCardImage(playerSlot.getSecondOne())));
        } catch (NotCardThrownException e) {
            this.card2SlotPlayerInTurn.setIcon(new ImageIcon());
        }

        try {
            this.card3SlotPlayerInTurn.setIcon(new ImageIcon(this.getCardImage(playerSlot.getThirdOne())));
        } catch (NotCardThrownException e) {
            this.card3SlotPlayerInTurn.setIcon(new ImageIcon());
        }
    }

    private BufferedImage getCardImage(Card actualCard){
        String imagePath = "resources/images/cards/59x90/" + actualCard.getSuit() + "/" + actualCard.getNumber() + ".png";
        BufferedImage cardPicture = null;

        try {
            cardPicture = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            this.showMessage( "No se pudo leer archivo de imagen " + imagePath );
        }

        return cardPicture;
    }

    public void drawCardsPlayerInTurn(Player player, Hand playerHand) {
        this.playerInTurnID.setText("Jugador " + player.getIdNumber());

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

    public void drawScores(Scoreboard scoreboard, LinkedList<Team> teams) {

        try {
            this.team1Score.setText(String.valueOf(scoreboard.getPointsOf(teams.getFirst())));
            this.team2Score.setText(String.valueOf(scoreboard.getPointsOf(teams.getLast())));

        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (SecondTeamWonException e) {
            this.showMessage("Gano el Jugador 2");
        } catch (FirstTeamWonException e) {
            this.showMessage( "Gano el jugador 1" );
        }
    }

    public void drawSlotOtherPlayers(LinkedList<Player> otherTeam) {

        this.player1SameTeamID.setText("Jugador " + otherTeam.get(1).getIdNumber());
        try {
            this.card1SlotPlayer1SameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(1).getSlot().getFirstOne()) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayer1SameTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayer1SameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(1).getSlot().getSecondOne()) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer1SameTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayer1SameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(1).getSlot().getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer1SameTeam.setIcon( new ImageIcon(  ) );
        }

        this.player2SameTeamID.setText("Jugador " + otherTeam.get(3).getIdNumber());
        try {
            this.card1SlotPlayer2SameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(3).getSlot().getFirstOne()) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayer2SameTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayer2SameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(3).getSlot().getSecondOne()) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer2SameTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayer2SameTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(3).getSlot().getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer2SameTeam.setIcon( new ImageIcon(  ) );
        }

        this.player1OtherTeamID.setText("Jugador " + otherTeam.get(0).getIdNumber());
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

        this.player2OtherTeamID.setText("Jugador " + otherTeam.get(2).getIdNumber());
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

        this.player3OtherTeamID.setText("Jugador " + otherTeam.get(4).getIdNumber());
        try {
            this.card1SlotPlayer3OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(4).getSlot().getFirstOne()) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayer3OtherTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayer3OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(4).getSlot().getSecondOne()) ) );
        } catch (NotCardThrownException e) {
            this.card2SlotPlayer3OtherTeam.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayer3OtherTeam.setIcon( new ImageIcon( this.getCardImage( otherTeam.get(4).getSlot().getThirdOne()) ) );
        } catch (NotCardThrownException e) {
            this.card3SlotPlayer3OtherTeam.setIcon( new ImageIcon(  ) );
        }
    }

    private void showMassageNextPlayer() {
        JOptionPane.showMessageDialog(null, "Turno del proximo jugador" );
    }

    public void cleanPlayerInTurnCards() {

        this.card1HandPlayerInTurn.setIcon( new ImageIcon(  ) );
        this.card2HandPlayerInTurn.setIcon( new ImageIcon(  ) );
        this.card3HandPlayerInTurn.setIcon( new ImageIcon(  ) );
    }

}