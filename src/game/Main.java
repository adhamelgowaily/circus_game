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

	//public static void main(String[] args) throws IOException {
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
		//GameController gameController = null;
		GameController gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Easy()), menuBar, Color.BLACK);
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

		//final GameController gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Easy()), menuBar, Color.BLACK);
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new CircusOfPlates(900, 600, new Easy()));
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
	}

	
}