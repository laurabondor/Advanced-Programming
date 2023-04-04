package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exportBtn = new JButton("Export");
    JButton resetBtn = new JButton("Reset");
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    /**
     * init() function adauga si configura butoanele create in panoul ControlPanel
     * */
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 5));

        //add all buttons
        add(loadBtn);
        add(saveBtn);
        add(exportBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(e1 -> {
            try {
                loadGame();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        saveBtn.addActionListener(e1 -> {
            try {
                saveGame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        exportBtn.addActionListener(e -> {
            try {
                exportGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        resetBtn.addActionListener(this::resetGame);
    }
    /**
     * reseteaza jocul la valorile initiale
     * */
    private void resetGame(ActionEvent e) {
        frame.canvas.createBoard();
        frame.canvas.repaint();
    }
    /**
     * restabileste starea jocului din fisierul file.txt
     * */
    private void loadGame() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("file.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        DrawingPanel game = (DrawingPanel) in.readObject();
        in.close();
        fileIn.close();
        frame.canvas.repaint();
    }
    /**
     * salveaza starea curenta a jocului in fisierul file.txt
     * */
    private void saveGame() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("file.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(frame.canvas);
        out.close();
        fileOut.close();
    }
    /**
     * exporta imaginea curenta a tablei de joc in image.png
     * */
    private void exportGame() throws IOException {
        BufferedImage image = new BufferedImage(frame.canvas.getWidth(), frame.canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        frame.canvas.paint(g2d);
        ImageIO.write(image, "png", new File("image.png"));
        g2d.dispose();
    }
    /**
     * inchide jocul
     * */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}