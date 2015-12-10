package view;

import model.Exceptions.NotCardThrownException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitialDataEntry extends JFrame {

    private JComboBox playerQuantityComboBox;
    private JButton empezarJuegoButton;
    private JLabel welcomeMessageLabel;
    private JPanel rootPanel;
    private static final String textFor2PlayersOption = "2 Jugadores";
    private static final String textFor2PlayersWithCPUOption = "2 Jugadores con CPU";
    private static final String textFor4PlayersOption = "4 Jugadores";
    private static final String textFor6PlayersOption = "6 Jugadores";
    private int selectedPlayerQuantity;

    public InitialDataEntry() {
        super("Truco");

        welcomeMessageLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        playerQuantityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{textFor2PlayersOption, textFor2PlayersWithCPUOption, textFor4PlayersOption, textFor6PlayersOption}));

        setContentPane(rootPanel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        empezarJuegoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    empezarJuegoButtonClicked();
                } catch (NotCardThrownException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String... args) {
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
            java.util.logging.Logger.getLogger(InitialDataEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialDataEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialDataEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialDataEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        InitialDataEntry initialDataEntry = new InitialDataEntry();
        java.awt.EventQueue.invokeLater(() -> initialDataEntry.setVisible(true));
    }

    private void empezarJuegoButtonClicked() throws NotCardThrownException {
        String selectedOption = (String) playerQuantityComboBox.getSelectedItem();
        boolean withCpu;

        switch (selectedOption){
            case textFor2PlayersOption:
                withCpu = false;
                new TwoPlayersGame(withCpu).setVisible(true);

                break;
            case textFor2PlayersWithCPUOption:
                withCpu = true;
                new TwoPlayersGame(withCpu).setVisible(true);

                break;
            case textFor4PlayersOption:
                new FourPlayersGame().setVisible(true);

                break;
            case textFor6PlayersOption:
                new SixPlayersGame().setVisible(true);

                break;
        }
        dispose();
    }
}
