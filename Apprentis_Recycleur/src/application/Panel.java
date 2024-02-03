package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {
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

}
