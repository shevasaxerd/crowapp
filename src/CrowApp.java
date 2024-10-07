import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class CrowApp extends JPanel {
    private int crowCount;
    private Random random;
    private Image crowImage;
    private ArrayList<Point> crowPositions;
    private JLabel label;

    public CrowApp() {
        crowCount = 0;
        random = new Random();
        crowPositions = new ArrayList<>();

        crowImage = new ImageIcon("crow1.png").getImage();

        JFrame frame = new JFrame("Crows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);
        label = new JLabel("Number of crows: " + crowCount);
        label.setBounds(200, 20, 150, 30);
        frame.add(label);
        JButton addButton = new JButton("Add crow");
        addButton.setBounds(20, 20, 150, 30);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crowCount++;
                int x = random.nextInt(frame.getWidth() - 100);
                int y = random.nextInt(frame.getHeight() - 100);
                crowPositions.add(new Point(x, y));
                label.setText("Number of crows: " + crowCount);

                repaint();
            }
        });

        frame.add(label);
        this.setBounds(0, 0, 600, 400);
        frame.add(this);
        frame.add(addButton);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point p : crowPositions) {
            g.drawImage(crowImage, p.x, p.y, this);
        }
    }
}
