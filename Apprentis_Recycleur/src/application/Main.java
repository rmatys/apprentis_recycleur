package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Systems;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private JPanel contentPane=new JPanel();
	Panel panel = new Panel();
	Systems systeme = new Systems();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					//frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1200, 700);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(0, 0, getWidth() - 14, getHeight()-32);
		contentPane.add(panel);
		
		systeme.ajouterPoubelles(panel, 1);
		
	}
}
