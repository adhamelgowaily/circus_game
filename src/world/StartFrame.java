package world;

import javax.swing.*;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {
    
GameController gameController;
Level level;

        public StartFrame() {
        //Creation of menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        //JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem easyMenuItem = new JMenuItem("New Easy Game");
        JMenuItem mediumMenuItem = new JMenuItem("New Medium Game");
        JMenuItem hardMenuItem = new JMenuItem("New Hard Game");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        //menu.add(newMenuItem);
        menu.add(easyMenuItem);
        menu.add(mediumMenuItem);
        menu.add(hardMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        
        setTitle("Choose level");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");
        
        //Easy button
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600, new Easy()), menuBar,Color.BLACK);
                level = Level.Easy;
                setVisible(false);

            }
        });
        //Medium button
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600, new Medium()), menuBar,Color.BLACK);
                level = Level.Medium;
                setVisible(false);

            }
        });
        //Hard button
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600, new Hard()), menuBar,Color.BLACK);
                level = Level.Hard;
                setVisible(false);

            }
        });

        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);
        add(panel);
        setVisible(true);
        //new game button pressed
        //creates a game with same difficulty chosen
        /*newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(level) {
                    case Level.Easy:
                        gameController.changeWorld(new CircusOfPlates(900, 600, new Easy()));
                        break;
                    case Level.Medium:
                        gameController.changeWorld(new CircusOfPlates(900, 600, new Medium()));
                        break;
                    case Level.Hard:
                        gameController.changeWorld(new CircusOfPlates(900, 600, new Hard()));
                        break;
                } 
            }
        }); */

        easyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.changeWorld(new CircusOfPlates(900, 600, new Easy()));
            }
        });
        mediumMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.changeWorld(new CircusOfPlates(900, 600, new Medium()));
            }
        });
        hardMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.changeWorld(new CircusOfPlates(900, 600, new Hard()));;
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
    }
}
