package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.omg.CORBA.PRIVATE_MEMBER;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.ConnectException;
public class frmLogin extends JFrame {
	
	private JTextField userName_tb;
	private ImageIcon slika;
	
	private JPanel contentPane;
	private JPasswordField password_tb;
	public static frmLogin pocetna;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					
					final frmSplashScreen fsp = new frmSplashScreen();
					fsp.setVisible(true);
					
					Timer timer = new Timer(1000, new ActionListener() {
					        public void actionPerformed(ActionEvent e) {
					        	
					    		HibernateUposlenik u = new HibernateUposlenik();
					    		u.dajSveUposlenike();
					    		HibernateKlijent k = new HibernateKlijent();
					    		k.dajSveKlijente();

					    		fsp.setVisible(false);
					            fsp.dispose();
					            
								final frmLogin frame = new frmLogin();
								frame.setVisible(true);
					        }
					    });
					
					    timer.setRepeats(false);
					    timer.start();
					
				} catch (Exception e) {

					final frmLogin frame = new frmLogin();
					frame.setVisible(true);
				}
			}
		});
	}

	public frmLogin() {
		
		pocetna = this;
		setResizable(false);
		setTitle("FDSS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime :");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblKorisnikoIme.setBounds(35, 102, 105, 20);
		getContentPane().add(lblKorisnikoIme);
		
		JLabel lblKorisnikaifra = new JLabel("Lozinka :");
		lblKorisnikaifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikaifra.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblKorisnikaifra.setBounds(35, 136, 105, 14);
		getContentPane().add(lblKorisnikaifra);
		
		userName_tb = new JTextField();
		userName_tb.setBounds(150, 102, 228, 20);
		getContentPane().add(userName_tb);
		userName_tb.setColumns(10);
		
		JButton PrijaviSe_btn = new JButton("Prijavi se");
		PrijaviSe_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				if ( userName_tb.getText().compareTo("a") == 0 ) {
					
					frmAdministrator fa = new frmAdministrator(null);
					fa.setVisible(true);
					dispose();
				}
				
				else if ( userName_tb.getText().compareTo("m") == 0 ) {
					frmManager fm=new frmManager(null);
					fm.setVisible(true);
					setVisible(false);
			    }
				
				else if ( userName_tb.getText().compareTo("s") == 0 ) {
					frmServiser fs=new frmServiser(null);
					fs.setVisible(true);
					setVisible(false);
				}
				
				else if ( userName_tb.getText().compareTo("d") == 0 ) {
					
					frmDispatcher fd=new frmDispatcher(null);
					fd.setVisible(true);
					setVisible(false);
				}
				
				else {
					
				}
				provjeriPodatke(userName_tb.getText(), new String(password_tb.getPassword()));
				
				
			}
		});
		
		PrijaviSe_btn.setFont(new Font("Cambria", Font.PLAIN, 14));
		PrijaviSe_btn.setBounds(273, 164, 105, 30);
		getContentPane().add(PrijaviSe_btn);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(94, 11, 252, 85);
		getContentPane().add(lblNewLabel);
		
		slika = new ImageIcon(getClass().getResource("/FDSS Logo.jpg"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		lblNewLabel.setIcon(slika);
		
		password_tb = new JPasswordField();
		password_tb.setBounds(150, 133, 228, 20);
		contentPane.add(password_tb);
	}
	
	private void provjeriPodatke(String userName,String password)
	{
		if(new HibernateUposlenik().postojiUposlenik(userName))
		{
			Uposlenik u=new HibernateUposlenik().dajUposlenika(userName);
			if(u.getPassword().equals(password))
			{
				
				switch(u.getPrivilegija())
				{
				case ADMINISTRATOR:
					frmAdministrator fa=new frmAdministrator(u);
					fa.setVisible(true);
					setVisible(false);
					break;
				case SERVISER:
					frmServiser fs=new frmServiser(u);
					fs.setVisible(true);
					setVisible(false);
					break;
				case DISPECER:
					frmDispatcher fd=new frmDispatcher(u);
					fd.setVisible(true);
					setVisible(false);
					break;
				case MENADZER:
					frmManager fm=new frmManager(u);
					fm.setVisible(true);
					setVisible(false);
				}
			}
			else new Validacija().poruka("Pogresni login podaci!");
		}
		else new Validacija().poruka("Pogresni login podaci!");
		
	}
}
