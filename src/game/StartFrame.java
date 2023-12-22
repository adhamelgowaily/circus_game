package game;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartFrame extends JFrame{

    public static void main(String[] args) {
       new StartFrame();
    }

    public StartFrame()
    {
        setTitle("Choose level");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main("Easy");
                setVisible(false);
                try {
                    main.startGame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main("Medium");
                setVisible(false);
                try {
                    main.startGame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main("Hard");
                setVisible(false);
                try {
                    main.startGame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);
        add(panel);
        setVisible(true);
    }
}
