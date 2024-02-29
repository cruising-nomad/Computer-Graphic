import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BeatingHeart extends JPanel implements ActionListener {

    private final int width = 500;
    private final int height = 300;
    private final int circleCenterX = width / 2;
    private final int circleCenterY = height / 2;
    private int circleRadius = 30; // Initial radius
    private final int radiusChange = 10; // Amount the radius changes with each beat
    private boolean circleGrowing = true;
    private final int delay = 15; // milliseconds between animation frames

    public BeatingHeart() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw circle
        g2d.setColor(Color.BLACK);
        g2d.fillOval(circleCenterX - circleRadius, circleCenterY - circleRadius, circleRadius * 2, circleRadius * 2);

        // Update circle radius
        if (circleGrowing) {
            circleRadius += radiusChange;
            if (circleRadius >= circleCenterX) { // Circle can't grow further than window
                circleGrowing = false; 
            }
        } else {
            circleRadius -= radiusChange;
            if (circleRadius <= 10) { // Set a minimum radius
                circleGrowing = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pulsing Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BeatingHeart());
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
