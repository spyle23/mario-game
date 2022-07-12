package com.spyle.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.spyle.objets.Bloc;
import com.spyle.objets.Objet;
import com.spyle.objets.TuyauRouge;
import com.spyle.personnages.Mario;


//***** La classe Scene est le classe la plus importante de l'application. *****//
//***** Elle est accessible par toutes les autres classes, contient le "moteur" de l'application *****//
//***** Elle gère la partie graphique. *****//
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
	private int dx;   // déplacement du fond d'écran.
	private int xPos; // position absolue dans le jeu
	private int ySol; // hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	
	public Mario mario;
	public TuyauRouge tuyauRouge1;
	public TuyauRouge tuyauRouge2;
	public TuyauRouge tuyauRouge3;
	public TuyauRouge tuyauRouge4;
	public TuyauRouge tuyauRouge5;
	public TuyauRouge tuyauRouge6;
	public TuyauRouge tuyauRouge7;
	public TuyauRouge tuyauRouge8;
	
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	private ImageIcon icoChateau2;
	private Image imgChateau2;
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	
	private ArrayList<Objet> tabOjets;
	
	
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
		tuyauRouge2 = new TuyauRouge(1000, 230);
		tuyauRouge3 = new TuyauRouge(1600, 230);
		tuyauRouge4 = new TuyauRouge(1900, 230);
		tuyauRouge5 = new TuyauRouge(2500, 230);
		tuyauRouge6 = new TuyauRouge(3000, 230);
		tuyauRouge7 = new TuyauRouge(3800, 230);
		tuyauRouge8 = new TuyauRouge(4500, 230);
		
		
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1300, 190);
		bloc4 = new Bloc(1750, 170);
		bloc5 = new Bloc(2100, 170);
		bloc6 = new Bloc(2260, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(2740, 190);
		bloc9 = new Bloc(2850, 170);
		bloc10 = new Bloc(3500, 140);
		bloc11 = new Bloc(3660, 150);
		bloc12 = new Bloc(4090, 210);
		
		this.icoChateau2 = new ImageIcon(getClass().getResource("/images/chateauFin.png")); 
		this.imgChateau2 = this.icoChateau2.getImage();
		this.icoDrapeau = new ImageIcon(getClass().getResource("/images/drapeau.png")); 
		this.imgDrapeau = this.icoDrapeau.getImage(); 
		
		tabOjets = new ArrayList<Objet>();
		
		
		tabOjets.add(tuyauRouge1);
		tabOjets.add(tuyauRouge2);
		tabOjets.add(tuyauRouge3);
		tabOjets.add(tuyauRouge4);
		tabOjets.add(tuyauRouge5);
		tabOjets.add(tuyauRouge6);
		tabOjets.add(tuyauRouge7);
		tabOjets.add(tuyauRouge8);
		tabOjets.add(bloc1);
		tabOjets.add(bloc2);
		tabOjets.add(bloc3);
		tabOjets.add(bloc4);
		tabOjets.add(bloc5);
		tabOjets.add(bloc6);
		tabOjets.add(bloc7);
		tabOjets.add(bloc8);
		tabOjets.add(bloc9);
		tabOjets.add(bloc10);
		tabOjets.add(bloc11);
		tabOjets.add(bloc12);
		
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
	public void deplacementFond(){ // Déplacement des images "fixes" de l'écran simulant le déplacement de mario 
		
		if(this.xPos >= 0 && this.xPos<=4330){
			// Mise à jour des positions des éléments du jeu lors du déplacement de mario
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		// Permanence du fond d'écran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}


	public void paintComponent(Graphics g) { // Dessin de toutes les images visibles à l'écran (appel toutes les 3 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;

		// Détection contact mario avec un objet
//		if(this.mario.proche(this.bloc1)){this.mario.contact(bloc1);}
// 		if(this.mario.proche(this.tuyauRouge1)){this.mario.contact(tuyauRouge1);}
		for(int i=0; i<tabOjets.size(); i++) {
			if(this.mario.proche(this.tabOjets.get(i))) {
				this.mario.contact(this.tabOjets.get(i));
			}
		}
		
		// Déplacement de tous les objets "fixes" du jeu
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos<=4330) {
			for(int i=0; i<tabOjets.size(); i++) {
				this.tabOjets.get(i).deplacement();
			}
		}
		
		// Image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		// Image du château du départ
 		g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null);
    	// Image du panneau de départ
 		g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null);
 		
 		
 		//image dans la liste des objets
 		for(int i=0; i<tabOjets.size(); i++) {
 			g2.drawImage(this.tabOjets.get(i).getImgObjet(), this.tabOjets.get(i).getX(), this.tabOjets.get(i).getY(), null);
 		}
 		
 		//image de chateau de fin
 		g2.drawImage(this.imgChateau2, 5000 - this.xPos, 145, null);
 		//image de drapeau de fin
 		g2.drawImage(this.imgDrapeau, 4650 - this.xPos, 115, null);
 		
    	// Image de mario
 		if(this.mario.isSaut()){g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);}
 		else{g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);}	
	}
}