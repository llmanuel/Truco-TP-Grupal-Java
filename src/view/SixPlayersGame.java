package view;

import controllers.FourPlayersController;
import controllers.SixPlayersController;
import model.Exceptions.InvalidNumberOfPlayersException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
}
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

    private void card3HandPlayerInTurnClicked() {

    }

    private void card2HandPlayerInTurnClicked() {

    }

    private void card1HandPlayerInTurnClicked() {

    }

    private void meVoyAlMazoButtonClicked() {

    }

    private void noQuieroButtonClicked() {

    }

    private void quieroButtonClicked() {

    }

    private void florButtonClicked() {
    }

    private void vale4ButtonClicked() {

    }

    private void retrucoButtonClicked() {

    }

    private void trucoButtonClicked() {

    }

    private void faltaEnvidoButtonClicked() {

    }

    private void realEnvidoButtonClicked() {

    }

    private void envidoButtonClicked() {
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog( null, message );
    }

    public void setTeamsNames() {

        this.team1ID.setText("Equipo 1");
        this.team2ID.setText("Equipo 2");
    }
}