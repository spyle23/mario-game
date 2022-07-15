package com.spyle.affichage;

public class Decount implements Runnable {

	//**** VARIABLES ****//
	private final int INITIAL=100;
	private final int PAUSE =1000;
 	private int count;
	
	//**** CONSTRUCTEUR ****//
	public Decount() {
		this.count = this.INITIAL;
		Thread chrono = new Thread(this);
		chrono.start();
	}

	
	//**** METHODES ****//
	@Override
	public void run() {
		while(true) {
			if(this.count>0) {
				this.count--;
			}
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}
		}
	}

	
	//**** GETTERS ****//
	
	public int getCount() {return count;}
}
