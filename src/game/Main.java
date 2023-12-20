package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import world.CircusOfPlates;
import world.Easy;
import world.Hard;

public class Main {
	
	public static void main(String[] args) throws IOException {

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
		final GameController gameController = GameEngine.start("Circus Of plates", new CircusOfPlates(900, 600,new Easy()),menuBar,Color.BLACK);
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				//gameController.changeWorld(new CircusOfPlates(1700, 1700));
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