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
	
	private double diametre = 10;
	private Point2D.Double point;
	private Ellipse2D.Double cercle= new Ellipse2D.Double();
	
	
	public Trash(String nomTrash, int id) {
		this.nom = nomTrash;
		this.idType = id;
	}
	
	public Trash(String nomTrash, int id, String image) {
		this.nom = nomTrash;
		this.idType = id;
		this.image = image;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void dessiner(Graphics2D g2d, double pixelsParMetre) {
		Graphics2D g2dPrive = (Graphics2D) g2d.create();
		
		AffineTransform mat = new AffineTransform();
		mat.scale(pixelsParMetre, -pixelsParMetre);
		
		g2dPrive.setColor(Color.black);
		
		double d = diametre / pixelsParMetre;
		cercle = new Ellipse2D.Double(point.getX()-d/2, point.getY()-d/2, d, d);
		g2dPrive.fill(mat.createTransformedShape(cercle));
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
