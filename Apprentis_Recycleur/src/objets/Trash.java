package objets;

import java.awt.Graphics2D;

import interfaces.Dessinable;
import interfaces.Selectionnable;

public class Trash implements Selectionnable, Dessinable {
	public String nom;
	public int idType;
	public String image; 
	
	public Trash(String nomTrash, int id) {
		this.nom = nomTrash;
		this.idType = id;
	}
	
	public Trash(String nomTrash, int id, String image) {
		this.nom = nomTrash;
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
