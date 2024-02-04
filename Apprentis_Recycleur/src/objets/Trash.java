package objets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import interfaces.Dessinable;
import interfaces.Selectionnable;
import application.Systems;

public class Trash implements Selectionnable, Dessinable {
	public String nom;
	public Systems.TypeDechet idType;
	public String image;
	
	private double diametre = 20;
	private Point2D.Double point;
	private Ellipse2D.Double cercle= new Ellipse2D.Double();
	
	
	public Trash(String nomTrash, Systems.TypeDechet id) {
		this.nom = nomTrash;
		this.idType = id;
		
		point = new Point2D.Double(500, 600);
	}
	
	public Trash(String nomTrash, Systems.TypeDechet id, String image) {
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
	
	public void setId(Systems.TypeDechet id) {
		this.idType = id;
	}
	
	public Systems.TypeDechet getId() {
		return this.idType;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return this.image;
	}
	
	public void setPoint(Point2D.Double point) {
		this.point = point;
	}
	
	public void setPoint(double x, double y) {
		this.point = new Point2D.Double(x, y);
	}
	
	public Point2D.Double getPoint() {
		return this.point;
	}
	
	public double getDiametre() {
		return this.diametre;
	}
	
	@Override
	public void dessiner(Graphics2D g2d) {
		Graphics2D g2dPrive = (Graphics2D) g2d.create();
		
		AffineTransform mat = new AffineTransform();
		mat.scale(1, -1);
		
		g2dPrive.setColor(Color.black);
		
		double d = diametre;
		double px = (point.getX()-d/2);
		double py = (point.getY()-d/2);
		
		cercle = new Ellipse2D.Double(px, py, d, d);
		g2dPrive.fill(mat.createTransformedShape(cercle));
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
