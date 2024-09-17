import java.awt.*;
import javax.swing.*;

public class frttree extends JFrame {

    private final int width = 800;
    private final int height = 600;
    private final int initialLineWidth = 10;

    public frttree() {
        super("Fractal Tree with Leaves");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    public void drawTree(Graphics2D g, int x1, int y1, double angle, int depth, int lineWidth) {
        if (depth == 0)
            return;

        int branchLength = depth * 10;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * branchLength);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * branchLength);

        g.setStroke(new BasicStroke(lineWidth));
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);

        int angle1 = (int) (angle - 20);
        int angle2 = (int) (angle + 20);
        int depth1 = depth - 1;
        int depth2 = depth - 1;
        int lineWidth1 = lineWidth - 1;
        int lineWidth2 = lineWidth - 1;

        drawTree(g, x2, y2, angle1, depth1, lineWidth1);
        drawTree(g, x2, y2, angle2, depth2, lineWidth2);
        if (depth <= 3) {
            drawLeaves(g, x2, y2, 8);
        }
    }

    public void drawLeaves(Graphics2D g, int x, int y, int size) {
        g.setColor(new Color(34, 139, 34)); // Dark Green
        g.fillOval(x - size, y - size, size * 2, size * 2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        int startX = width / 2;
        int startY = height - 10;
        int angle = -90;
        int depth = 10;

        drawTree(g2d, startX, startY, angle, depth, initialLineWidth);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frttree fractalTree = new frttree();
            fractalTree.setVisible(true);
        });
    }
}
