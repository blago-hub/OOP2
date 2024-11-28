import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DrawObject> objects = new ArrayList<>();
        objects.add(new Ellips(200, 200, 100, 50, Color.GREEN));

        new DrawPanel(objects);
    }
}
