package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import world.*;

public class Main {
	private final String level;
	private JFrame startFrame;
	private Node parent;

	public static void main(String[] args) throws IOException {
		StartFrame startFrame1 = new StartFrame();
	}
	public Main(String level) {

		this.level = level;
	}
	public void startGame() throws IOException {
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
		GameController gameController = null;
		//GameController gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Easy()), menuBar, Color.BLACK);
//		switch(level) {
//			case "Easy":
//				gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Easy()), menuBar, Color.BLACK);
//				break;
//			case "Medium":
//				gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Medium()), menuBar, Color.BLACK);
//				break;
//			case "Hard":
//				gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Hard()), menuBar, Color.BLACK);
//				break;
//
//		}

		//GameController finalGameController2 = gameController;

//		newMenuItem.addActionListener(new ActionListener() {
//		@Override public void actionPerformed(ActionEvent e) {
//				finalGameController2.changeWorld(new CircusOfPlates(900, 600, new Easy()));
//
//
//			}
//		});
//		GameController finalGameController = gameController;
//		pauseMenuItem.addActionListener(new ActionListener() {
//		@Override public void actionPerformed(ActionEvent e) {
//				finalGameController.pause();
//				//gameController.pause();
//			}
//		});
//		GameController finalGameController1 = gameController;
//		resumeMenuItem.addActionListener(new ActionListener() {
//			@Override public void actionPerformed(ActionEvent e) {
//				finalGameController1.resume();
//			}
//		});
	}



}