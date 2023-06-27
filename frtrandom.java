import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class frtrandom extends JFrame {

    private final int width = 800;
    private final int height = 600;
    private final int initialLineWidth = 10;
    private final Random random = new Random();

    public frtrandom() {
        super("Fractal Tree");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    public void drawTree(Graphics2D g, int x1, int y1, double angle, int depth, int lineWidth) {
        if (depth == 0)
            return;

        int branchLength = depth * 10 + random.nextInt(30) - 15;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * branchLength);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * branchLength);

        float colorHue = random.nextFloat();
        Color branchColor = Color.getHSBColor(colorHue, 1, 1);
        g.setColor(branchColor);
        g.setStroke(new BasicStroke(lineWidth));
        g.drawLine(x1, y1, x2, y2);

        double angle1 = angle - random.nextInt(40) - 10;
        double angle2 = angle + random.nextInt(40) + 10;
        int depth1 = depth - 1;
        int depth2 = depth - 1;
        int lineWidth1 = lineWidth - random.nextInt(2);
        int lineWidth2 = lineWidth - random.nextInt(2);

        drawTree(g, x2, y2, angle1, depth1, lineWidth1);
        drawTree(g, x2, y2, angle2, depth2, lineWidth2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        int startX = width / 2;
        int startY = height - 10;
        double angle = -90;
        int depth = 10;

        drawTree(g2d, startX, startY, angle, depth, initialLineWidth);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frtrandom fractalTree = new frtrandom();
            fractalTree.setVisible(true);
        });
    }
}
