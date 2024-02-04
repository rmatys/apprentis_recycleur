package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import objets.Poubelles;
import objets.Trash;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import javax.swing.JLabel;
import java.awt.Font;

public class Panel extends JPanel implements Runnable, Serializable {
	private static final long serialVersionUID = -3422389399040540538L;

	private boolean premiereFois = true;
	private boolean enCoursAnim = false;
	private boolean dragging = false;
	private boolean falling = false;

	private int iterDepuisChute = 0;
	
	public Systems systeme = new Systems();

	public ArrayList<Poubelles> listPoubelles = new ArrayList<Poubelles>();
	public Trash trashAJeter = new Trash("", Systems.TypeDechet.BIO);

	/**
	 * Create the panel.
	 */
	public Panel() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				dragging = true;

				if (!falling) {
					trashAJeter.setPoint(e.getX(), -e.getY() + getHeight());				
					repaint();
				}
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				trashAJeter.setPoint(e.getX(), -e.getY() + getHeight());				
				repaint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (dragging) {
					demarrerAnim();
					dragging = false;
					falling = true;
				}
			}
		});
		setLayout(null);
		setBackground(Color.gray);
	}

	private void initialization() {
		premiereFois = false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (premiereFois) {
			initialization();	
		}
		
		// Caroline Houle professeur en SIM au collège de Maisonneuve
		Image img_dojo = OutilsImage.lireImageEtRedimensionner("dojo.png", getWidth(), getHeight());
		g2d.drawImage(img_dojo, null, getFocusCycleRootAncestor());

		int redimX = 70;
		int redimY = 90;
		
		Graphics2D g2dImage = (Graphics2D) g2d.create();
		g2dImage.translate(35, getHeight() - redimY - 35);
		
		g2d.translate(0, getHeight());

		g2d.setColor(Color.white);
		for (int i = 0; i < listPoubelles.size(); i++) {
			g2d.drawString(listPoubelles.get(i).getNom(), 45+(i*140), 645);
		}

		for (int j = 0; j < listPoubelles.size(); j++) {
			Poubelles poubelle = listPoubelles.get(j);
			Point2D.Double p = trashAJeter.getPoint();
			double d = trashAJeter.getDiametre();

			poubelle.dessiner(g2d);

			// Caroline Houle professeur en SIM au collège de Maisonneuve
			Image img = OutilsImage.lireImageEtRedimensionner("bin" + (poubelle.getId().ordinal()) +".png", redimX, redimY);
			
			if (j != 0) {
				g2dImage.translate(140, 0);
			}
			g2dImage.drawImage(img, null, getFocusCycleRootAncestor());
			

			if (poubelle.getRectangle().contains(p.x, p.y + d, d, d)) {
				//				poubelle.getId();
				trashAJeter.setPoint(getWidth() / 2,  4 * getHeight() / 5);
				arretAnim();
			}
		}

		trashAJeter.dessiner(g2d);
		g2d.translate(0, -getHeight());	
		g2d.setFont(new Font("Arial", Font.PLAIN, 12));
		g2d.drawString("Score : "+"3" /*donnees.getScore()*/, 50, 45);
		g2d.drawString("Vies : "+ "3" /*donnees.getVies()*/, 50, 85);
		g2d.drawString("Déchets restants : "+ "22", /* donnees.getRestants()*/ 50, 125);
	}

	@Override
	public void run() {
		while (enCoursAnim) {
			double gravity = 1.7;

			Point2D.Double p = trashAJeter.getPoint();
			trashAJeter.setPoint(p.x, p.y - gravity * iterDepuisChute);
			iterDepuisChute += 1;

			if (p.y < 0) {
				arretAnim();
			}

			repaint();

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void demarrerAnim() {
		if (!enCoursAnim) {
			enCoursAnim = true;
			Thread proc = new Thread(this);
			proc.start();
		}
	}

	public void arretAnim() {
		enCoursAnim = false;
		falling = false;
		iterDepuisChute = 0;
	}


	public static Image image(String fichier) {
		Image img = null;
		URL urlFichier = Panel.class.getClassLoader().getResource(fichier);
		try {
			img = ImageIO.read(urlFichier);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return(img);
	}

}
