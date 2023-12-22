package game;

import eg.edu.alexu.csd.oop.game.GameEngine;
import world.CircusOfPlates;
import world.Easy;
import world.Hard;
import world.Medium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartFrame extends JFrame {

    GameEngine.GameController gameController;
    Level level;

//    public static void main(String[] args) {
//       new StartFrame();
//    }

    public StartFrame() {

        //final String[] level = {null};

        JMenuBar  menuBar = new JMenuBar();;
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
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

//        final Level level;

//        GameEngine.GameController gameController = null;
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Main main = new Main("Easy");
                gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600, new Easy()) , menuBar, Color.BLACK);
                level = Level.Easy;
                setVisible(false);
//                try {
//                    main.startGame();
//                    main.setParentNode(this);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Main main = new Main("Medium");
                gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600, new Medium()), menuBar, Color.BLACK);
                level = Level.Medium;
                setVisible(false);
//                try {
//                    main.startGame();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Main main = new Main("Hard");
                gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600, new Hard()), menuBar, Color.BLACK);
                level = Level.Hard;
                setVisible(false);
//                try {
//                    main.startGame();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });

        panel.add(easyButton);
        panel.add(mediumButton);
        panel.add(hardButton);
        add(panel);
        setVisible(true);

        newMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {


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
        });
        GameEngine.GameController finalGameController = gameController;
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.pause();
                //gameController.pause();
            }
        });
        GameEngine.GameController finalGameController1 = gameController;
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
    }


}

