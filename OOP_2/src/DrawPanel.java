import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawPanel extends JFrame {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;

    private final List<DrawObject> drawObjects;

    public DrawPanel(List<DrawObject> drawObjects) {
        setTitle("Drawing Panel");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.drawObjects = drawObjects;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);


        for (DrawObject obj : drawObjects) {
            obj.draw(g2d);
        }
    }
}
