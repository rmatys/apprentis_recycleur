package objets;

import java.awt.Graphics2D;

import interfaces.Dessinable;
import interfaces.Selectionnable;

public class Poubelles implements Selectionnable, Dessinable {
	public String nom;
	public int idType;
	public String image;
	
	public Poubelles(String nomPoubelle, int id) {
		this.nom = nomPoubelle;
		this.idType = id;
	}
	
	public Poubelles(String nomPoubelle, int id, String image) {
		this.nom = nomPoubelle;
		this.idType = id;
		this.image = image;
	}

	@Override
	public void dessiner(Graphics2D g2d, double pixelsParMetre) {
		
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
