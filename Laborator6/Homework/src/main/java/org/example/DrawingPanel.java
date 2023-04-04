package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
public class DrawingPanel extends JPanel implements Serializable {
    MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private transient BufferedImage image; //the offscreen image
    private transient Graphics2D graphics; //the tools needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // get the x,y coordinates of the mouse click
                int mouseX = e.getX();
                int mouseY = e.getY();

                // iterate over the lines and find the line that was clicked
                for (int i = 0; i < numVertices; i++) {
                    for (int j = i + 1; j < numVertices; j++) {
                        if (Math.random() <= edgeProbability) {
                            int x1 = x[i];
                            int y1 = y[i];
                            int x2 = x[j];
                            int y2 = y[j];

                            // calculate the distance from the mouse click to the line
                            double distance = Math.abs((y2 - y1) * mouseX - (x2 - x1) * mouseY + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
                            if (distance < 10) {
                                Graphics2D g2d = graphics;
                                if (g2d.getColor() == Color.BLACK) {
                                    g2d.setColor(Color.RED);
                                } else if (g2d.getColor() == Color.RED) {
                                    g2d.setColor(Color.BLUE);
                                } else {
                                    g2d.setColor(Color.RED);
                                }
                                g2d.drawLine(x1, y1, x2, y2);
                                repaint();
                                break;
                            }
                        }
                    }
                }
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() <= edgeProbability) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }

    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}