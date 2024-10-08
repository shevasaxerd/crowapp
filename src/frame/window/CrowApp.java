package frame.window;

import frame.panel.ImagePanel;
import services.CountingCrowServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrowApp extends JFrame {
   private Image crowImage;
   private JLabel label;
   private JButton button;
   private JPanel panel;
   private ImagePanel imagePanel;
   private CountingCrowServiceImpl countingCrowServiceImpl;

    public CrowApp() {
        super("Crow");
        countingCrowServiceImpl = new CountingCrowServiceImpl();
        countingCrowServiceImpl.count = 0;
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
                countingCrowServiceImpl.increment();
                label.setText("Number of crows: " + countingCrowServiceImpl.count);
                imagePanel.addImageAtRandomPosition();
            }
        });
    }
    void labelSettings(){
        label = new JLabel("Number of crows: " + countingCrowServiceImpl.count);
        label.setBounds(200, 20, 150, 30);
    }
    void imageSettings(){
        crowImage = new ImageIcon("crow1.png").getImage();
        imagePanel = new ImagePanel(crowImage);
        add(imagePanel, BorderLayout.CENTER);
    }



}
