package view;
import game.Plate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import pieces.Piece;
public class Display extends JFrame{

	private JPanel container = new JPanel();
	//Un bouton par case de l'échiquier
	JButton[][] cells = new JButton[8][8];
	private JMenuBar menuBar = new JMenuBar();
	JMenu game = new JMenu("Game"),
	    help = new JMenu("Help");
	 JMenuItem   newGame = new JMenuItem("New Game"),
	    leave = new JMenuItem("Leave"),
	    logs = new JMenuItem("Logs");


	public Display(){

		this.setSize(900, 900);
		this.setTitle("Echiquier");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//On initialise le conteneur avec tous les composants
		initDisplay();
		initMenu();
		this.setJMenuBar(menuBar);
		//On ajoute le conteneur
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void initMenu() {
		game.add(newGame);
	    game.addSeparator();
	    game.add(leave);	    
	    
	    help.add(logs);
	    
	    menuBar.add(game);
	    menuBar.add(help);
	}
	private void initDisplay() {
		// TODO Auto-generated method stub
		GridBagLayout gl = new GridBagLayout();
		//L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		//On positionne la case de départ du composant
		gbc.gridx = 0;
		gbc.gridy = 0;
		//La taille en hauteur et en largeur
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		
		container.setLayout(gl);
		for (JButton[] cellLine : cells) {
			for (JButton cell : cellLine) {
				cell = new JButton();
				cell.setPreferredSize(new Dimension(90, 90));
				if (gbc.gridx % 2 == 0){
					if (gbc.gridy %2 == 0) {
						cell.setBackground(Color.white);
					}
					else cell.setBackground(Color.black);
				}
				else {

					if (gbc.gridy %2 == 0) {
						cell.setBackground(Color.black);
					}
					else cell.setBackground(Color.white);				
				}
				container.add(cell, gbc);
				gbc.gridy ++;
			}
			gbc.gridx ++;
			gbc.gridy = 0;
		}
	}
	
	private void refreshDisplay(Plate gamePlate) {
		Piece[][] pieces = gamePlate.getPlate();
	}
}
