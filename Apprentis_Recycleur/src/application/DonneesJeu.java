package application;

import javax.swing.JOptionPane;

public class DonneesJeu {

	public int score = 0;
	public int nbVies = 5;
	public int dechetsRestants;
	public int sequence=0;
	
	public DonneesJeu(int score, int nbVies, int dechetsRestants) {
		this.score = score;
		this.nbVies = nbVies;
		this.dechetsRestants = dechetsRestants;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setVies(int nbVies) {
		this.nbVies = nbVies;
	}
	
	public int getVies() {
		return this.nbVies;
	}
	
	public void setRestants(int dechetsRestants) {
		this.dechetsRestants = dechetsRestants;
	}
	
	public int getRestants() {
		return this.dechetsRestants;
	}
	
	public void incrementerScore(int ajout) {
		this.score += ajout;
	}
	
	public void decrementerScore(int suppression) {
		this.score -= suppression;
	}
	
	public void enleverVie() {
		this.nbVies--;
		
		if (nbVies == 0) {
			JOptionPane.showMessageDialog(null, "Vous avez perdu :(" + "\n"+ " Score final: " + score);
			System.exit(0);
		}
	}
	
	public void enleverDechet() {
		this.dechetsRestants--;
		
		if (dechetsRestants == 0) {
			JOptionPane.showMessageDialog(null, "Félicitations! " + "\n"+ " Score final: " + score);
			System.exit(0);
		}
	}
}
