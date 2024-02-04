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

public class Panel extends JPanel implements Runnable, Serializable {
	private static final long serialVersionUID = -3422389399040540538L;
	
	private boolean premiereFois = true;
	private boolean enCoursAnim = false;
	
	public ArrayList<Poubelles> listPoubelles = new ArrayList<Poubelles>();
	public Trash trashAJeter = new Trash("", -1);

	/**
	 * Create the panel.
	 */
	public Panel() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		g2d.translate(0, getHeight());
		
		for (int i = 0; i < listPoubelles.size(); i++) {
			listPoubelles.get(i).dessiner(g2d);
		}
		
		trashAJeter.dessiner(g2d);
	}
	
	@Override
	public void run() {
		
	}
	
	public void demarrerAnim() {
		if (!enCoursAnim) {
			enCoursAnim = true;
			Thread proc = new Thread(this);
			proc.start();
		}
	}
	
	public void arreterAnim() {
		enCoursAnim = false;
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
