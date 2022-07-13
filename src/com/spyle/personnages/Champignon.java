package com.spyle.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.spyle.objets.Objet;

public class Champignon extends Personnage implements Runnable {

	//**** VARIABLES ****//
		private Image imgChamp;
		private ImageIcon icoChamp;
	    private final int PAUSE = 15;
	    private int dxChamp;
	    
	//**** CONSTRUCTEUR ****//
	    public Champignon(int x, int y) {
			super(x, y, 27, 30);
			super.setVersDroite(true);
			super.setMarche(true);
			
			this.icoChamp =  new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
			this.imgChamp = this.icoChamp.getImage();
			
			Thread chronoChamp = new Thread(this);
			chronoChamp.start();
		}

		
	    
	    
	//**** GETTERS ****//
	    
	    public Image getImgChamp() {
			return imgChamp;
		}
	    
	//**** METHODES ****//
	    public void bouge() {
	    	if(super.isVersDroite()) {
	    		this.dxChamp = 1;
	    	}else {
	    		this.dxChamp = -1;
	    	}
	    	super.setX(super.getX() + this.dxChamp);
	    }


	@Override
	public void run() {
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {}
		
		while(true) {
			if(this.vivant) {
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
				this.dxChamp = -1;
			}else if(super.contactArriere(objet) && !this.isVersDroite()) {
				this.setVersDroite(true);
				this.dxChamp = 1;
			}
		}
		//contact avec la tortue
		public void contactTortue(Tortue tortue) {
			if(super.contactAvant(tortue) && this.isVersDroite()) {
				this.setVersDroite(false);
				this.dxChamp = -1;
			}else if(super.contactArriere(tortue) && !this.isVersDroite()) {
				this.setVersDroite(true);
				this.dxChamp = 1;
			}
		}
		
		public Image meurt() {
			ImageIcon ico;
			Image img;
			String str;
			
			if(this.isVersDroite()) {
				str = "/images/champEcraseDroite.png";
			}else {
				str = "/images/champEcraseGauche.png";
			}
			
			ico = new ImageIcon(getClass().getResource(str));
			img = ico.getImage();
			
			return img;
		}
}
