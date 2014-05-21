package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class frmDodavanjeKorisnika extends JFrame {

	private JPanel contentPane;
	private JTextField ime_tb;
	private JTextField prezime_tb;
	private JTextField username_tb;
	private JTextField password_tb;
	private JTextField adresa_tb;
	private JTextField grad_tb;
	private JTextField telefon_tb;
	private JTextField email_tb;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public frmDodavanjeKorisnika() {
		setResizable(false);
		setTitle("Dodaj korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(3, 11, 431, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Ime:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(33, 28, 70, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(33, 59, 70, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Korisni\u010Dko ime:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 90, 93, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u0160ifra:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(33, 121, 70, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Adresa:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(33, 149, 70, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Grad:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(33, 180, 70, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Telefon:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(33, 211, 70, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Email:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(33, 242, 70, 14);
		panel.add(label_7);
		
		ime_tb = new JTextField();
		ime_tb.setBounds(113, 25, 241, 20);
		panel.add(ime_tb);
		ime_tb.setColumns(10);
		
		prezime_tb = new JTextField();
		prezime_tb.setBounds(113, 56, 241, 20);
		panel.add(prezime_tb);
		prezime_tb.setColumns(10);
		
		username_tb = new JTextField();
		username_tb.setBounds(113, 87, 241, 20);
		panel.add(username_tb);
		username_tb.setColumns(10);
		
		password_tb = new JTextField();
		password_tb.setBounds(113, 118, 241, 20);
		panel.add(password_tb);
		password_tb.setColumns(10);
		
		adresa_tb = new JTextField();
		adresa_tb.setBounds(113, 146, 241, 20);
		panel.add(adresa_tb);
		adresa_tb.setColumns(10);
		
		grad_tb = new JTextField();
		grad_tb.setBounds(113, 177, 137, 20);
		panel.add(grad_tb);
		grad_tb.setColumns(10);
		
		telefon_tb = new JTextField();
		telefon_tb.setBounds(113, 208, 137, 20);
		panel.add(telefon_tb);
		telefon_tb.setColumns(10);
		
		email_tb = new JTextField();
		email_tb.setBounds(113, 239, 137, 20);
		panel.add(email_tb);
		email_tb.setColumns(10);
		
		panel.setBorder(BorderFactory.createTitledBorder("Novi korisnik"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 283, 429, 83);
		panel_1.setBorder(BorderFactory.createTitledBorder("Privilegija"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setSelected(true);
		rdbtnAdministrator.setBounds(41, 23, 109, 23);
		panel_1.add(rdbtnAdministrator);
		
		JRadioButton rdbtnMenader = new JRadioButton("Menad\u017Eer");
		rdbtnMenader.setBounds(41, 49, 109, 23);
		panel_1.add(rdbtnMenader);
		
		JRadioButton rdbtnServiser = new JRadioButton("Serviser");
		rdbtnServiser.setBounds(192, 23, 109, 23);
		panel_1.add(rdbtnServiser);
		
		JRadioButton rdbtnDispacher = new JRadioButton("Dispacher");
		rdbtnDispacher.setBounds(192, 49, 109, 23);
		panel_1.add(rdbtnDispacher);
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Uposlenik u = new Uposlenik();
				u.setId(1);
				u.setIme(ime_tb.getText());
				u.setPrezime(prezime_tb.getText());
				u.setJib("1504992173043"); // fali kontrola za dodavanje JIB broja
				u.setAdresa(adresa_tb.getText());
				u.setMjesto(grad_tb.getText());
				u.setTelefon(telefon_tb.getText());
				u.setEmail(email_tb.getText());
				
				u.setUserName(username_tb.getText());
				u.setPassword(password_tb.getText());
				
				HibernateUposlenik h = new HibernateUposlenik();
				h.dodajUposlenika(u);
				
				List<Uposlenik> l = h.vratiSveUposlenike();
			}
		});
		
		btnDodajKorisnika.setBounds(300, 377, 124, 23);
		contentPane.add(btnDodajKorisnika);
	}
}
