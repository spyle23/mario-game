package com.spyle.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.spyle.objets.Bloc;
import com.spyle.objets.TuyauRouge;
import com.spyle.personnages.Mario;


//***** La classe Scene est le classe la plus importante de l'application. *****//
//***** Elle est accessible par toutes les autres classes, contient le "moteur" de l'application *****//
//***** Elle g�re la partie graphique. *****//
@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	
	//**** VARIABLES **//
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;  
	private Image imgChateau1;  
	private ImageIcon icoDepart;  
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;   // d�placement du fond d'�cran.
	private int xPos; // position absolue dans le jeu
	private int ySol; // hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	
	public Mario mario;
	public TuyauRouge tuyauRouge1;
	public Bloc bloc1;
	
	
	//**** CONSTRUCTEUR ****//	
	public Scene(){
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png")); 
		this.imgChateau1 = this.icoChateau1.getImage();  
		this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		mario = new Mario(300, 245);
		tuyauRouge1 = new TuyauRouge(600, 230);
		bloc1 = new Bloc(400, 180);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHautPlafond(){return hauteurPlafond;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}


	//**** METHODES ****//
	public void deplacementFond(){ // D�placement des images "fixes" de l'�cran simulant le d�placement de mario 
		
		if(this.xPos >= 0){
			// Mise � jour des positions des �l�ments du jeu lors du d�placement de mario
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		// Permanence du fond d'�cran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}


	public void paintComponent(Graphics g) { // Dessin de toutes les images visibles � l'�cran (appel toutes les 3 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;

		// D�tection contact mario avec un objet
		if(this.mario.proche(this.bloc1)){this.mario.contact(bloc1);}
 		if(this.mario.proche(this.tuyauRouge1)){this.mario.contact(tuyauRouge1);}
		
		// D�placement de tous les objets "fixes" du jeu
		this.deplacementFond();
		this.tuyauRouge1.deplacement();
		this.bloc1.deplacement();
		
		// Image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		// Image du ch�teau du d�part
 		g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null);
    	// Image du panneau de d�part
 		g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null);
 		//Image du tuyau rouge
 		g2.drawImage(this.tuyauRouge1.getImgTuyauRouge(), this.tuyauRouge1.getX(), this.tuyauRouge1.getY(), null);
 		//Image du bloc
 		g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX(), this.bloc1.getY(), null);
    	// Image de mario
 		if(this.mario.isSaut()){g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);}
 		else{g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);}	
	}
}