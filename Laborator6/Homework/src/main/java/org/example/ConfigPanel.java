package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    /**
     * init() function creeaza componentele(JLabel, JSpinner, JComboBox, JButton) in cadrul panoului ConfigPanel
     * */
    private void init() {
        // create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        //create the rest of the components
        linesLabel = new JLabel("Line probability:");
        Double[] edgeProbability = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        linesCombo = new JComboBox<>(edgeProbability);
        createButton = new JButton("Create new game");

        // add the components to the panel
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);

        //configure listener for createButton
        createButton.addActionListener(this::createGame);
    }
    /**
     * creeaza un nou joc
     * */
    private void createGame(ActionEvent e) {
        DrawingPanel canvas = frame.canvas;
        canvas.createBoard();
        canvas.repaint();
    }
}
