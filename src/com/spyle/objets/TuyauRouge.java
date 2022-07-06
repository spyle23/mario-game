package com.spyle.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TuyauRouge extends Objet{
	
	//**** VARIABLES ****//
	private Image imgTuyauRouge;
	private ImageIcon icoTuyauRouge;
	
	
	//**** CONSTRUCTEUR	****//	
	public TuyauRouge(int x, int y) {

		super(x, y, 43, 65);		
		this.icoTuyauRouge = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		this.imgTuyauRouge = this.icoTuyauRouge.getImage();
	}
	
	
	//**** GETTERS ****//		
	public Image getImgTuyauRouge() {return imgTuyauRouge;}
		
		
	//**** SETTERS ****//
		

	//**** METHODES ****//

}
