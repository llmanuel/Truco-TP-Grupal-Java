package view;

/**
 * Created by lucas on 27/11/15.
 */

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ScreenToAskForInicialData extends JFrame {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Configuracion inicial.");

        frame.setVisible(true);
        frame.setSize(500, 600);

        JCheckBox numberOfPlayers = new JCheckBox("Chin");
        numberOfPlayers.setMnemonic(KeyEvent.VK_C);
        numberOfPlayers.setSelected(true);

       // numberOfPlayers.addItemListener(this);
    }








}







