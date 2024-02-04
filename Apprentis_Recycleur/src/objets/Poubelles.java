package objets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

import interfaces.Dessinable;
import interfaces.Selectionnable;
import application.Systems;

public class Poubelles implements Selectionnable, Dessinable {
	public String nom;
	public Systems.TypePoubelle idType;
	public String image;
	
	private double largeur = 10;
	private double hauteur = 10;
	private Point2D.Double point;
	private Rectangle2D.Double rectangle = new Rectangle2D.Double();
	
	public Poubelles(String nomPoubelle, Systems.TypePoubelle id, String image) {
		this.nom = nomPoubelle;
		this.idType = id;
		this.image = image;
	}
	public Poubelles(String nomPoubelle, Systems.TypePoubelle id) {
		this.nom = nomPoubelle;
		this.idType = id;
		
		double initPosX = 2;
		double initPosY = 2;
		point = new Point2D.Double(initPosX + 4 * id.ordinal(), initPosY);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setId(Systems.TypePoubelle id) {
		this.idType = id;
	}
	
	public Systems.TypePoubelle getId() {
		return this.idType;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return this.image;
	}
	
	

	@Override
	public void dessiner(Graphics2D g2d, double pixelsParMetre) {
		Graphics2D g2dPrive = (Graphics2D) g2d.create();
		
		AffineTransform mat = new AffineTransform();
		mat.scale(pixelsParMetre, -pixelsParMetre);
		
		g2dPrive.setColor(Color.black);
		
		double l = largeur / pixelsParMetre;
		double h = hauteur / pixelsParMetre;
		rectangle = new Rectangle2D.Double(point.getX()-l/2, point.getY()-h/2, l, h);
		g2dPrive.fill(mat.createTransformedShape(rectangle));	
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
