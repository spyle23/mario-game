package com.spyle.affichage;

public class Score {
	
	//**** VARIABLES ****//
	private final int NBR_TOTAL_SCORE = 10;
	private int score;
	
	//**** CONSTRUCTEUR ****//
	public Score() {
		this.score = 0;
	}

	
	//**** GETTERS ****//
	public int getScore() {return score;}
	
	
	
	public int getNBR_TOTAL_SCORE() {return NBR_TOTAL_SCORE;}


	//**** SETTERS ****//
	public void setScore(int score) {this.score = score;}
}
