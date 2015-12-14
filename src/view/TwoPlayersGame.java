package view;

import controllers.TwoPlayersMatchController;
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

    public TwoPlayersGame(boolean withCpu) {
        super("Truco");

        try {
            controller = new TwoPlayersMatchController(this, withCpu);
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
            public void mouseClicked(MouseEvent mouseEvent) {meVoyAlMazoButtonClicked();}
        });

        card1PlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                card1PlayerInTurnClicked();
            }
        });
        card2PlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                card2PlayerInTurnClicked();
            }
        });
        card3PlayerInTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                card3PlayerInTurnClicked();
            }
        });

    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog( null, message );
    }

    private void showMassageNextPlayer() {
        JOptionPane.showMessageDialog(null, "Turno del proximo jugador" );
    }

    private BufferedImage getCardImage(Card actualCard){
        String imagePath = "resources/images/cards/105x160/" + actualCard.getSuit() + "/" + actualCard.getNumber() + ".png";
        BufferedImage cardPicture = null;

        try {
            cardPicture = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            this.showMessage( "No se pudo leer archivo de imagen " + imagePath );
        }

        return cardPicture;
    }



    private void card1PlayerInTurnClicked() {
        this.controller.cleanPlayerInTurnCards();
        this.showMassageNextPlayer();
        this.controller.playCard(1);
    }

    private void card2PlayerInTurnClicked()  {

        this.cleanPlayerInTurnCards();
        this.showMassageNextPlayer();
        this.controller.playCard(2);
    }

    private void card3PlayerInTurnClicked() {

        this.cleanPlayerInTurnCards();
        this.showMassageNextPlayer();
        this.controller.playCard(3);
    }

    private void meVoyAlMazoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();
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
            this.controller.cleanPlayerInTurnCards();
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

            this.controller.acceptCall();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (TeamDoesntExistException ignored) {

        } catch (InvalidGameCallException e) {
            e.printStackTrace();
        } catch (NothingToAcceptException e) {
            this.controller.drawRound();
            this.showMessage( "No se hizo ningun canto" );
        }
    }

    private void florButtonClicked() {
        try {
            this.controller.callFlor();
            this.controller.drawRound();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (InvalidGameCallException | TeamDoesntExistException e) {
            this.controller.drawRound();
            this.showMessage( "No puedes cantar Flor en este momento" );
        }
    }

    private void vale4ButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();

            this.controller.callVale4();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.controller.drawRound();
            this.showMessage( "No podes jugar Vale 4 en este momento" );
        }
    }

    private void retrucoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();

            this.controller.callReTruco();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException e) {
            this.showMessage( "No se ha tirado carta alguna" );
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.controller.drawRound();
            this.showMessage( "No podes jugar Retruco en este momento" );
        }
    }

    private void trucoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();

            this.controller.callTruco();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.controller.drawRound();
            this.showMessage( "No podes jugar Truco en este momento" );
        }
    }

    private void faltaEnvidoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();

            this.controller.callFaltaEnvido();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.controller.drawRound();
            this.showMessage( "No podes jugar Falta Envido en este momento" );
        }
    }

    private void realEnvidoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();

            this.controller.callRealEnvido();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (InvalidGameCallException e) {
            this.controller.drawRound();
            this.showMessage( "No podes jugar Real Envido en este momento" );
        }
    }

    private void envidoButtonClicked() {
        try {
            this.controller.cleanPlayerInTurnCards();

            this.controller.callEnvido();
            this.showMassageNextPlayer();
            this.controller.drawRound();
        } catch (InvalidGameCallException e) {
            this.controller.drawRound();
            this.showMessage( "No podes jugar Envido en este momento" );
        } catch (NotYourTurnException e) {
            this.showMessage( "No es tu turno para jugar" );
        } catch (NotCardThrownException | TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    public void drawCardsPlayerInTurn(Hand playerHand, Player player){
        this.playerInTurnName.setText("Jugador " + player.getIdNumber());

        try {
            this.card1PlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerHand.getCards().get(0) ) ) ) ;
        } catch (IndexOutOfBoundsException e){
            this.card1PlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2PlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerHand.getCards().get(1) ) ) ) ;
        } catch (IndexOutOfBoundsException e){
            this.card2PlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3PlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerHand.getCards().get(2) ) ) ) ;
        } catch (IndexOutOfBoundsException e ){
            this.card3PlayerInTurn.setIcon( new ImageIcon(  ) );
        }
    }

    public void drawSlotPlayerInTurn(Slot playerSlot){
        try {
            this.card1SlotPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerSlot.getFirstOne() ) ) );
        } catch (NotCardThrownException e) {
            this.card1SlotPlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card2SlotPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerSlot.getSecondOne() ) ) ) ;
        } catch (NotCardThrownException e) {
            this.card2SlotPlayerInTurn.setIcon( new ImageIcon(  ) );
        }

        try {
            this.card3SlotPlayerInTurn.setIcon( new ImageIcon( this.getCardImage( playerSlot.getThirdOne() ) ) )   ;
        } catch (NotCardThrownException e) {
            this.card3SlotPlayerInTurn.setIcon( new ImageIcon(  ) );
        }
    }

    public void drawSlotOtherPlayer(Slot otherPlayerSlot) {
        try {
            this.firstCardPlayedByOtherPlayer.setIcon( new ImageIcon( this.getCardImage( otherPlayerSlot.getFirstOne() ) ) );
        } catch (NotCardThrownException e) {
            this.firstCardPlayedByOtherPlayer.setIcon( new ImageIcon(  ) );
        }

        try {
            this.secondCardPlayedByOtherPlayer.setIcon( new ImageIcon( this.getCardImage( otherPlayerSlot.getSecondOne() ) ) );
        } catch (NotCardThrownException e) {
            this.secondCardPlayedByOtherPlayer.setIcon( new ImageIcon(  ) );
        }

        try {
            this.thirdCardPlayedByOtherPlayer.setIcon( new ImageIcon( this.getCardImage( otherPlayerSlot.getThirdOne() ) ) ) ;
        } catch (NotCardThrownException e) {
            this.thirdCardPlayedByOtherPlayer.setIcon( new ImageIcon(  ) );
        }
    }

    public void drawScores(Scoreboard scoreboard, LinkedList<Player> players) {
        try {
            firstPlayerID.setText( "Jugador " +  String.valueOf( players.getFirst().getIdNumber() ) );
            secondPlayerID.setText( "Jugador " + String.valueOf( players.getLast().getIdNumber() ) );

            firstPlayerScore.setText(String.valueOf(scoreboard.getPointsOf(players.getFirst())));
            secondPlayerScore.setText(String.valueOf(scoreboard.getPointsOf(players.getLast())));

        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        } catch (SecondTeamWonException e) {
            this.showMessage( "Gano el Jugador 2" );
        } catch (FirstTeamWonException e) {
            this.showMessage( "Gano el jugador 1" );
        }
    }

    public void cleanPlayerInTurnCards() {

        this.card1PlayerInTurn.setIcon( new ImageIcon(  ) );
        this.card2PlayerInTurn.setIcon( new ImageIcon(  ) );
        this.card3PlayerInTurn.setIcon( new ImageIcon(  ) );
    }
}
