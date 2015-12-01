package view;

import controllers.FourPlayersController;
import model.Exceptions.InvalidGameCallException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private FourPlayersController controller;

    public FourPlayersGame() {
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
}


