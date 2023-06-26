import java.awt.*;
import javax.swing.*;

public class frt extends JFrame {

    private final int width = 800;
    private final int height = 600;

    public frt() {
        super("Fractal Tree");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    public void drawTree(Graphics2D g, int x1, int y1, double angle, int depth) {
        if (depth == 0)
            return;

        int branchLength = depth * 10;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * branchLength);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * branchLength);

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        int startX = width / 2;
        int startY = height - 50;
        int angle = -90;
        int depth = 10;

        drawTree(g2d, startX, startY, angle, depth);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frt fractalTree = new frt();
            fractalTree.setVisible(true);
        });
    }
}
