package com.spyle.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.spyle.objets.Objet;

public class Tortue extends Personnage implements Runnable {
	//**** VARIABLES ****//
			private Image imgTortue;
			private ImageIcon icoTortue;
		    private final int PAUSE = 15;
		    private int dxTortue;
		    
		//**** CONSTRUCTEUR ****//
		    public Tortue(int x, int y) {
				super(x, y, 27, 50);
				super.setVersDroite(true);
				super.setMarche(true);
				
				this.icoTortue =  new ImageIcon(getClass().getResource("/images/tortueArretDroite.png"));
				this.imgTortue = this.icoTortue.getImage();
				
				Thread chronoChamp = new Thread(this);
				chronoChamp.start();
			}

			
		    
		    
		//**** GETTERS ****//
		    
		    public Image getImgTortue() {
				return imgTortue;
			}
		    
		//**** METHODES ****//
		    public void bouge() {
		    	if(super.isVersDroite()) {
		    		this.dxTortue = 1;
		    	}else {
		    		this.dxTortue = -1;
		    	}
		    	super.setX(super.getX() + this.dxTortue);
		    }


		@Override
		public void run() {
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
			
			while(true) {
				if(this.isVivant()) {
					this.bouge();
					try {
						Thread.sleep(PAUSE);
					} catch (InterruptedException e) {}
				}
			}
		}
			
			public void contact(Objet objet) {
				if(super.contactAvant(objet) && this.isVersDroite()) {
					this.setVersDroite(false);
					this.dxTortue = -1;
				}else if(super.contactArriere(objet) && !this.isVersDroite()) {
					this.setVersDroite(true);
					this.dxTortue = 1;
				}
			}
			public void contactChamp(Champignon champ) {
				if(super.contactAvant(champ) && this.isVersDroite()) {
					this.setVersDroite(false);
					this.dxTortue = -1;
				}else if(super.contactArriere(champ) && !this.isVersDroite()) {
					this.setVersDroite(true);
					this.dxTortue = 1;
				}
			}
			
			public Image meurt() {
				ImageIcon ico;
				Image img;
				String str;
				
				str = "/images/tortueFermee.png";
				
				ico = new ImageIcon(getClass().getResource(str));
				img = ico.getImage();
				
				return img;
			}
}
