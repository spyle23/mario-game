package com.spyle.jeu;

//***** La classe Chrono gère un flux indépendant du flux principal qui exécute la méthode run() *****//
public class Chrono implements Runnable{

	//**** VARIABLES **//
	private final int PAUSE = 3; // temps d'attente entre 2 tours de boucle : 3 millisecondes
	
	
	//**** METHODES **//
	@Override
	public void run() {

		while(true){ 			
			Main.scene.repaint(); // Appel de la méthode PaintComponent de l'objet scene
			try {Thread.sleep(PAUSE);} // temps de pause du flux (3 ms)
			catch (InterruptedException e) {}
		}
	}
}