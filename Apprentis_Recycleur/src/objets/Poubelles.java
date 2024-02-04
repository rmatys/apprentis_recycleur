package objets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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
	
	private double largeur = 30;
	private double hauteur = 30;
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
		
		double initPosX = 40;
		double initPosY = 40;
		point = new Point2D.Double(initPosX + 70 * id.ordinal(), initPosY);
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
	public void dessiner(Graphics2D g2d) {
		Graphics2D g2dPrive = (Graphics2D) g2d.create();
		
		AffineTransform mat = new AffineTransform();
		mat.scale(1, -1);
		
		g2dPrive.setColor(Color.black);
		
		double l = largeur;
		double h = hauteur;
		double px = (point.getX()-l/2);
		double py = (point.getY()-h/2);
		
		rectangle = new Rectangle2D.Double(px, py, l, h);
		g2dPrive.fill(mat.createTransformedShape(rectangle));	
		
		g2dPrive.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g2dPrive.setColor(Color.yellow);
		g2dPrive.drawString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", (int)point.getX(), (int)point.getY());
		System.out.println(this.nom);
	}

	@Override
	public boolean contient(double xPix, double yPix) {
		return false;
	}
}
