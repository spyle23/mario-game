package com.spyle.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bloc extends Objet{
	//**** VARIABLES ****//
		private Image imgBloc;
		private ImageIcon icoBloc;
		
		
		//**** CONSTRUCTEUR	****//	
		public Bloc(int x, int y) {

			super(x, y, 30, 30);		
			this.icoBloc = new ImageIcon(getClass().getResource("/images/bloc.png"));
			this.imgBloc = this.icoBloc.getImage();
		}
		
		
		//**** GETTERS ****//		
		public Image getImgBloc() {return imgBloc;}
			
			
		//**** SETTERS ****//
			

		//**** METHODES ****//
}
