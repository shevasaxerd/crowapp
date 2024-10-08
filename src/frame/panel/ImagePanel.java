package frame.panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImagePanel extends JPanel {
    private List<Point> imagePositions = new ArrayList<>();
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    public void addImageAtRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(getWidth() - image.getWidth(null));
        int y = random.nextInt(getHeight() - image.getHeight(null));
        imagePositions.add(new Point(x, y));
        repaint();
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : imagePositions) {
            g.drawImage(image, point.x, point.y, this);
        }
    }
}