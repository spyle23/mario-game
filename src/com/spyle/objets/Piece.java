package com.spyle.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet implements Runnable {
		//**** VARIABLES ****//
		private final int PAUSE = 15;
		private int compteur = 0;
	
		//**** CONSTRUCTEUR	****//	
			public Piece(int x, int y) {

				super(x, y, 30, 30);		
				super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
				super.imgObjet = this.icoObjet.getImage();
			}
			
			
			//**** GETTERS ****//		
			
				
				
			//**** SETTERS ****//
				

			//**** METHODES ****//
		
			public Image bouge() {
				ImageIcon ico;
				String str;
				Image img;
				
				this.compteur++;
				if(this.compteur/100 == 0) {
					str = "/images/piece1.png";
				}else {
					str = "/images/piece2.png";
				}
				if(this.compteur == 200) {
					this.compteur = 0;
				}
				
				ico = new ImageIcon(getClass().getResource(str));
				img = ico.getImage();
				
				return img;
			}


			@Override
			public void run() {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {}
				
				while(true) {
					this.bouge();
					try {
						Thread.sleep(PAUSE);
					} catch (InterruptedException e) {}

				}
			}
}
