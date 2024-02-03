package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, Serializable {
	private static final long serialVersionUID = -3422389399040540538L;
	
	private boolean premiereFois = true;
	private boolean enCoursAnim = false;

	/**
	 * Create the panel.
	 */
	public Panel() {
		setLayout(null);
        setBackground(Color.gray);
	}
	
	private void initialization() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (premiereFois) {
			initialization();
		}
		
//		Image recyclage = image("bin1.jpeg");
		
		Graphics2D g2dImage = (Graphics2D) g2d.create();
		g2dImage.translate(50, 50);
//		g2dImage.drawImage(recyclage, 20, 
//				20, null);
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
