import java.awt.*;
import javax.swing.*;

public class frtgrid extends JFrame {

    private final int width = 800;
    private final int height = 600;

    public frtgrid() {
        super("Fractal Tree - Grid");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0)
            return;

        int branchLength = depth * 10;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * branchLength);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * branchLength);

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - 90, depth - 1);
        drawTree(g, x2, y2, angle + 90, depth - 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);

        int startX = width / 2;
        int startY = height - 10;
        int angle = -90;
        int depth = 12; // Increase depth for a taller tree

        drawTree(g, startX, startY, angle, depth);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frtgrid fractalTree = new frtgrid();
            fractalTree.setVisible(true);
        });
    }
}
