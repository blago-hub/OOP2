import java.awt.*;

public class Ellips implements DrawObject{

    private int centerX;
    private int centerY;
    private int a;
    private int b;

    private Color color;


    public Ellips(int centerX, int centerY, int a, int b, Color color){
        this.centerX = centerX;
        this.centerY = centerY;
        this.a = a;
        this.b = b;
        this.color = color;
    }


    @Override
    public void draw(Graphics2D g2d) {
        int x = 0;
        int y = b;
        int d1 = b * b - a * a * (2 * b - 1);
        int dx = 0;
        int dy = 2 * a * a * y;

        // Рисование первой четверти эллипса
        while (dx < dy) {
            g2d.setColor(color);
            g2d.fillRect(centerX + x, centerY + y, 2, 2);
            g2d.fillRect(centerX - x, centerY + y, 2, 2);
            g2d.fillRect(centerX + x, centerY - y, 2, 2);
            g2d.fillRect(centerX - x, centerY - y, 2, 2);

            if (d1 <= 0) {
                x++;
                dx += 2 * b * b;
                d1 += dx + b * b;
            } else {
                x++;
                y--;
                dx += 2 * b * b;
                dy -= 2 * a * a;
                d1 += dx - dy + b * b;
            }
        }

        int d2 = (int) (b * b * (x + 0.5) * (x + 0.5) + a * a * (y - 1) * (y - 1) - a * a * b * b);

        while (y >= 0) {
            g2d.setColor(color);
            g2d.fillRect(centerX + x, centerY + y, 2, 2);
            g2d.fillRect(centerX - x, centerY + y, 2,2);
            g2d.fillRect(centerX + x, centerY - y, 2, 2);
            g2d.fillRect(centerX - x, centerY - y, 2, 2);

            if (d2 > 0) {
                y--;
                dy -= 2 * a * a;
                d2 -= dy + a * a;
            } else {
                y--;
                x++;
                dx += 2 * b * b;
                dy -= 2 * a * a;
                d2 += dx - dy + a * a;
            }
        }
    }
}