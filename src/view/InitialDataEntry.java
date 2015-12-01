package view;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitialDataEntry extends JFrame {
    private JComboBox playerQuantityComboBox;
    private JButton empezarJuegoButton;
    private JLabel welcomeMessageLabel;
    private JPanel rootPanel;

    public InitialDataEntry() {
        empezarJuegoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                empezarJuegoButtonClicked(mouseEvent);
            }
        });
    }

    private void empezarJuegoButtonClicked(MouseEvent mouseEvent) {

    }
}
