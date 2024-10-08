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
   private JPanel panel;
   private ImagePanel imagePanel;

    public CrowApp() {
        super("Crow");
        crowCount = 0;
        random = new Random();
        crowPositions = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        //setLayout(null);


        panel = new JPanel();
        imageSettings();
        labelSettings();
        buttonSettings();
        panel.add(button);
        panel.add(label);



        add(panel, BorderLayout.NORTH);
        setVisible(true);

    }

    void buttonSettings(){
        button = new JButton("Add crow");
        button.setBounds(20, 20,150,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crowCount++;
                label.setText("Number of crows: " + crowCount);
                imagePanel.addImageAtRandomPosition();
            }
        });
    }
    void labelSettings(){
        label = new JLabel("Number of crows: " + crowCount);
        label.setBounds(200, 20, 150, 30);
    }
    void imageSettings(){
        crowImage = new ImageIcon("crow1.png").getImage();
        imagePanel = new ImagePanel(crowImage);
        add(imagePanel, BorderLayout.CENTER);
    }



}
