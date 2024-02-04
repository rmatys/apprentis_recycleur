package objets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import interfaces.Dessinable;
import interfaces.Selectionnable;

public class Trash implements Selectionnable, Dessinable {
	public String nom;
	public int idType;
	public String image;
	
	private double diametre = 2;
	private Point2D.Double point;
	private Ellipse2D.Double cercle= new Ellipse2D.Double();
	
	
	public Trash(String nomTrash, int id) {
		this.nom = nomTrash;
		this.idType = id;
		
		point = new Point2D.Double(18, 8);
	}
	
	public Trash(String nomTrash, int id, String image) {
		this.nom = nomTrash;
		this.idType = id;
		this.image = image;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setId(int id) {
		this.idType = id;
	}
	
	public int getId() {
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
		
		double d = diametre / pixelsParMetre;
		double px = (point.getX()-d/2) / pixelsParMetre;
		double py = (point.getY()-d/2) / pixelsParMetre;
		
		cercle = new Ellipse2D.Double(px, py, d, d);
		g2dPrive.fill(mat.createTransformedShape(cercle));
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
