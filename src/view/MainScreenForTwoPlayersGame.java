package view;


import controllers.TwoPlayersMatchController;
import model.Exceptions.InvalidGameCallException;
import model.Exceptions.NotCardThrownException;
import model.Exceptions.NotYourTurnException;
import model.Exceptions.TeamDoesntExistException;
import model.Player;

import java.util.LinkedList;

public class MainScreenForTwoPlayersGame extends javax.swing.JFrame {
    /**
     * Creates new form VentanaPrincipalDeJuego
     */
    public MainScreenForTwoPlayersGame() {
        initComponents();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @param
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //TwoPlayersMatchController twoPlayersController = new TwoPlayersMatchController(this);
        carta1Player2 = new javax.swing.JLabel();
        carta2Player2 = new javax.swing.JLabel();
        carta3Player2 = new javax.swing.JLabel();
        carta3Player1 = new javax.swing.JLabel();
        carta1Player1 = new javax.swing.JLabel();
        carta2Player1 = new javax.swing.JLabel();
        etiquetaPlayer1 = new javax.swing.JLabel();
        etiquetaPlayer2 = new javax.swing.JLabel();
        faltaEnvido = new javax.swing.JButton();
        botonEnvido = new javax.swing.JButton();
        realEnvido = new javax.swing.JButton();
        botonTruco = new javax.swing.JButton();
        botonAumentarApuestaDeTruco = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Partida de Truco en juego");
        setName("Partida"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(true);

        carta1Player2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        carta1Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta1Player2MouseClicked(evt);
            }
        });

        carta2Player2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        carta2Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta2Player2MouseClicked(evt);
            }
        });

        carta3Player2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        carta3Player2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta3Player2MouseClicked(evt);
            }
        });

        carta3Player1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        carta3Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta3Player1MouseClicked(evt);
            }
        });

        carta1Player1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        carta1Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta1Player1MouseClicked(evt);
            }
        });

        carta2Player1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N

        carta2Player1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carta2Player1MouseClicked(evt);
            }
        });

        etiquetaPlayer1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        etiquetaPlayer1.setForeground(new java.awt.Color(102, 102, 102));


        etiquetaPlayer2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        etiquetaPlayer2.setForeground(new java.awt.Color(102, 102, 102));


        faltaEnvido.setText("Falta Envido");
        faltaEnvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                faltaEnvidoMouseClicked(evt);
            }
        });

        botonEnvido.setText("Envido");
        botonEnvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEnvidoMouseClicked(evt);
            }
        });

        realEnvido.setText("Real Envido");
        realEnvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realEnvidoMouseClicked(evt);
            }
        });

        botonTruco.setText("Truco");
        botonTruco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonTrucoMouseClicked(evt);
            }
        });

        botonAumentarApuestaDeTruco.setText("Aumentar Apuesta");
        botonAumentarApuestaDeTruco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAumentarApuestaDeTrucoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(carta1Player2)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(etiquetaPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(etiquetaPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(184, 184, 184)
                                                .addComponent(carta2Player2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(carta1Player1)
                                                .addGap(176, 176, 176)
                                                .addComponent(carta2Player1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(carta3Player2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(carta3Player1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(91, 91, 91))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(botonTruco)
                                                .addGap(42, 42, 42))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(botonAumentarApuestaDeTruco)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(realEnvido)
                                                        .addComponent(faltaEnvido))
                                                .addGap(24, 24, 24))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(botonEnvido)
                                                .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(etiquetaPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(carta1Player1)
                                        .addComponent(carta2Player1)
                                        .addComponent(carta3Player1))
                                .addGap(72, 72, 72)
                                .addComponent(botonEnvido)
                                .addGap(18, 18, 18)
                                .addComponent(realEnvido)
                                .addGap(18, 18, 18)
                                .addComponent(faltaEnvido)
                                .addGap(59, 59, 59)
                                .addComponent(botonTruco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonAumentarApuestaDeTruco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(carta1Player2)
                                        .addComponent(carta2Player2)
                                        .addComponent(carta3Player2))
                                .addGap(74, 74, 74)
                                .addComponent(etiquetaPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carta1Player2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta1Player2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carta1Player2MouseClicked

    private void carta2Player2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta2Player2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carta2Player2MouseClicked

    private void carta3Player2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta3Player2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carta3Player2MouseClicked

    private void carta1Player1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta1Player1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carta1Player1MouseClicked

    private void carta2Player1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta2Player1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carta2Player1MouseClicked

    private void carta3Player1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carta3Player1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_carta3Player1MouseClicked

    private void botonEnvidoMouseClicked(java.awt.event.MouseEvent evt)  {

        try {
            twoPlayersController.callEnvido();
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

    private void realEnvidoMouseClicked(java.awt.event.MouseEvent evt)  {

        try {
            twoPlayersController.callRealEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void faltaEnvidoMouseClicked(java.awt.event.MouseEvent evt) {

        try {
            twoPlayersController.callFaltaEnvido();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void botonTrucoMouseClicked(java.awt.event.MouseEvent evt) {

        try {
            twoPlayersController.callTruco();
        } catch (NotYourTurnException e) {
            e.printStackTrace();
        } catch (NotCardThrownException e) {
            e.printStackTrace();
        } catch (TeamDoesntExistException e) {
            e.printStackTrace();
        }
    }

    private void botonAumentarApuestaDeTrucoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAumentarApuestaDeTrucoMouseClicked
        // TODO add your handling code here:

        twoPlayersController.raiseBet();
    }//GEN-LAST:event_botonAumentarApuestaDeTrucoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger( MainScreenForTwoPlayersGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger( MainScreenForTwoPlayersGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger( MainScreenForTwoPlayersGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger( MainScreenForTwoPlayersGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreenForTwoPlayersGame().setVisible(true);
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAumentarApuestaDeTruco;
    private javax.swing.JButton botonEnvido;
    private javax.swing.JButton botonTruco;
    private javax.swing.JLabel carta1Player1;
    private javax.swing.JLabel carta1Player2;
    private javax.swing.JLabel carta2Player1;
    private javax.swing.JLabel carta2Player2;
    private javax.swing.JLabel carta3Player1;
    private javax.swing.JLabel carta3Player2;
    private javax.swing.JLabel etiquetaPlayer1;
    private javax.swing.JLabel etiquetaPlayer2;
    private javax.swing.JButton faltaEnvido;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton realEnvido;
    private TwoPlayersMatchController twoPlayersController;

    public void refreshCardsLabels(LinkedList<String> namesOfTheCards, int playerID) {

        if (playerID == 1){

            carta1Player1.setText(namesOfTheCards.get(0));
            carta2Player1.setText(namesOfTheCards.get(1));
            carta3Player1.setText(namesOfTheCards.get(2));

        } else {

            carta1Player2.setText(namesOfTheCards.get(0));
            carta2Player2.setText(namesOfTheCards.get(1));
            carta3Player2.setText(namesOfTheCards.get(2));
        }

    }

    public void setController(TwoPlayersMatchController twoPlayersMatchController) {

        twoPlayersController = twoPlayersMatchController;
    }

    public void setPlayerName(Player player) {

        if(player.getIdNumber() == 1){

            etiquetaPlayer1.setText("Jugador 1");
        } else {

            etiquetaPlayer2.setText("Jugador 2");
        }
    }
    // End of variables declaration//GEN-END:variables
}
