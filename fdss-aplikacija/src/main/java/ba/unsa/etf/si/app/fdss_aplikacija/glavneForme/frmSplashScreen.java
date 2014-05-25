package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class frmSplashScreen extends JFrame {
	
	public frmSplashScreen() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setResizable(false);
		setBounds(100, 100, 629, 391);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 629, 391);
		panel.add(label);
		
		ImageIcon slika = new ImageIcon(getClass().getResource("/SplashScreen.jpg"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		label.setIcon(slika);
		
	}
}
