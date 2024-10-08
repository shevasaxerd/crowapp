import ru.CryptoPro.JCP.ASN.PKIX1Explicit88._title_Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class CrowApp extends JFrame {
   private int crowCount;
   private Random random;
   private Image crowImage;
   private ArrayList<Point> crowPositions;
   private JLabel label;
   private JButton button;

    public CrowApp() {
        super("Crow");
        crowCount = 0;
        random = new Random();
        crowPositions = new ArrayList<>();
        crowImage = new ImageIcon("crow1.png").getImage();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 400);
        setLayout(null);
        label = new JLabel("Number of crows: " + crowCount);
        label.setBounds(200, 20, 150, 30);
        add(label);

        button = new JButton("Add crow");
        button.setBounds(20, 20,150,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crowCount++;
                label.setText("Number of crows: " + crowCount);
                repaint();
            }
        });

        add(label);
        add(button);
        setVisible(true);
    }

}
