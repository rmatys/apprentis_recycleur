package objets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	
	private double largeur = 70;
	private double hauteur = 90;
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
		
		double initPosX = 70;
		double initPosY = 80 ;
		point = new Point2D.Double(initPosX + 140 * id.ordinal(), initPosY);
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
	
	public Rectangle2D.Double getRectangle() {
		return this.rectangle;
	}
	
	

	@Override
	public void dessiner(Graphics2D g2d) {
		Graphics2D g2dPrive = (Graphics2D) g2d.create();
		g2dPrive.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		AffineTransform mat = new AffineTransform();
		mat.scale(1, -1);
		
		g2dPrive.setColor(Color.black);
		
		double l = largeur;
		double h = hauteur;
		double px = (point.getX()-l/2);
		double py = (point.getY()-h/2);
		
		rectangle = new Rectangle2D.Double(px, py, l, h);
		g2dPrive.fill(mat.createTransformedShape(rectangle));	
		
		g2dPrive.setColor(Color.yellow);
		g2dPrive.drawString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", (int)point.getX(), (int)point.getY());
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
