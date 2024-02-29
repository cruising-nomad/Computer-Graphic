import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Initial extends JPanel {

    private final int width = 200;
    private final int height = 200;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set antialiasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define points for the lines
        Point2D.Double p1 = new Point2D.Double(width / 2.0, 0);
        Point2D.Double p2 = new Point2D.Double(0, height);
        Point2D.Double p3 = new Point2D.Double(width, height);

        // Draw lines
        g2d.setStroke(new BasicStroke(5)); // Adjust stroke width as desired
        g2d.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
        g2d.drawLine((int) p1.getX(), (int) p1.getY(), (int) p3.getX(), (int) p3.getY());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Initial A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Initial());
        frame.setSize(new Dimension(200, 200));
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
