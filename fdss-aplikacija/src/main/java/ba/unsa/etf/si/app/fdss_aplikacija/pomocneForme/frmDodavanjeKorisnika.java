package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.glavneForme.frmAdministrator;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.PrivilegijaUposlenika;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.util.HibernateUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDodavanjeKorisnika extends JFrame {

	private JPanel contentPane;
	private JTextField ime_tb;
	private JTextField prezime_tb;
	private JTextField username_tb;
	private JTextField password_tb;
	private JTextField adresa_tb;
	private JTextField mjesto_tb;
	private JTextField telefon_tb;
	private JTextField email_tb;
	private JTextField jmbg_tb;
	JRadioButton administrator_rdbtn;
	JRadioButton dispecer_rdbtn;
	JRadioButton serviser_rdbtn;
	JRadioButton menadzer_rdbtn;
	Uposlenik uposlenik;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public frmDodavanjeKorisnika(Uposlenik u) {
		uposlenik=u;
		setResizable(false);
		setTitle("Dodaj korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 416, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime :");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(50, 28, 70, 14);
		panel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime :");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(50, 59, 70, 14);
		panel.add(lblPrezime);
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko ime :");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(27, 123, 93, 14);
		panel.add(lblKorisnikoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka :");
		lblLozinka.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLozinka.setBounds(50, 154, 70, 14);
		panel.add(lblLozinka);
		
		JLabel lblAdresa = new JLabel("Adresa :");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresa.setBounds(50, 182, 70, 14);
		panel.add(lblAdresa);
		
		JLabel lblGrad = new JLabel("Mjesto :");
		lblGrad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrad.setBounds(50, 213, 70, 14);
		panel.add(lblGrad);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(50, 244, 70, 14);
		panel.add(lblTelefon);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(50, 275, 70, 14);
		panel.add(lblEmail);
		
		ime_tb = new JTextField();
		ime_tb.setBounds(130, 25, 241, 20);
		panel.add(ime_tb);
		ime_tb.setColumns(10);
		
		prezime_tb = new JTextField();
		prezime_tb.setBounds(130, 56, 241, 20);
		panel.add(prezime_tb);
		prezime_tb.setColumns(10);
		
		username_tb = new JTextField();
		username_tb.setBounds(130, 120, 241, 20);
		panel.add(username_tb);
		username_tb.setColumns(10);
		
		password_tb = new JPasswordField();
		password_tb.setBounds(130, 151, 241, 20);
		panel.add(password_tb);
		password_tb.setColumns(10);
		
		adresa_tb = new JTextField();
		adresa_tb.setBounds(130, 179, 241, 20);
		panel.add(adresa_tb);
		adresa_tb.setColumns(10);
		
		mjesto_tb = new JTextField();
		mjesto_tb.setBounds(130, 210, 241, 20);
		panel.add(mjesto_tb);
		mjesto_tb.setColumns(10);
		
		telefon_tb = new JTextField();
		telefon_tb.setBounds(130, 241, 241, 20);
		panel.add(telefon_tb);
		telefon_tb.setColumns(10);
		
		email_tb = new JTextField();
		email_tb.setBounds(130, 272, 241, 20);
		panel.add(email_tb);
		email_tb.setColumns(10);
		
		panel.setBorder(BorderFactory.createTitledBorder("Novi korisnik"));
		
		jmbg_tb = new JTextField();
		jmbg_tb.setBounds(130, 87, 241, 20);
		panel.add(jmbg_tb);
		jmbg_tb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("JMBG :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(74, 90, 46, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 324, 416, 49);
		panel_1.setBorder(BorderFactory.createTitledBorder("Privilegija"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		administrator_rdbtn = new JRadioButton("Administrator");
		administrator_rdbtn.setSelected(true);
		administrator_rdbtn.setBounds(118, 18, 109, 23);
		panel_1.add(administrator_rdbtn);
		
		menadzer_rdbtn = new JRadioButton("Menad\u017Eer");
		menadzer_rdbtn.setBounds(24, 18, 92, 23);
		panel_1.add(menadzer_rdbtn);
		
		serviser_rdbtn = new JRadioButton("Serviser");
		serviser_rdbtn.setBounds(323, 18, 77, 23);
		panel_1.add(serviser_rdbtn);
		
		dispecer_rdbtn = new JRadioButton("Dispečer");
		dispecer_rdbtn.setBounds(229, 18, 92, 23);
		panel_1.add(dispecer_rdbtn);
		
	    ButtonGroup grupa = new ButtonGroup();
	    grupa.add(administrator_rdbtn);
	    grupa.add(menadzer_rdbtn);
	    grupa.add(dispecer_rdbtn);
	    grupa.add(serviser_rdbtn);
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDodajKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					Uposlenik u = new Uposlenik();
					pokupiPodatke(u); // Ovdje baca exception ako podaci nisu ispravni 
					
					HibernateUposlenik h = new HibernateUposlenik();

					if(!h.postojiUposlenik(u.getUserName()) && !h.postojiUposlenikJMBG(u.getJmbg())) {
						
						h.dodajUposlenika(u);
						ocistiPoljaZaUnos();
						JOptionPane.showMessageDialog(null, "Korisnik uspješno unesen !");
					}
					
					else if(h.postojiUposlenik(u.getUserName()))
						throw new GeneralniException("Username već postoji !");
					
					else
						throw new GeneralniException("Korisnik sa datim JMBG je već unesen u bazu !");
				}
				
				catch (Exception g) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, g.getMessage());
				}
			}
		});
		
		btnDodajKorisnika.setBounds(301, 380, 124, 31);
		contentPane.add(btnDodajKorisnika);
		
		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnNazad.setBounds(167, 380, 124, 31);
		contentPane.add(btnNazad);
	}
	
	private void pokupiPodatke(Uposlenik u) throws GeneralniException {
		
		u.setIme(ime_tb.getText());
		u.setPrezime(prezime_tb.getText());
		u.setJmbg(jmbg_tb.getText());
		u.setAdresa(adresa_tb.getText());
		u.setMjesto(mjesto_tb.getText());
		u.setTelefon(telefon_tb.getText());
		u.setEmail(email_tb.getText());
		
		u.setUserName(username_tb.getText());
		u.setPassword(password_tb.getText());
		
		if(menadzer_rdbtn.isSelected())
		{
			u.SetPrivilegija(PrivilegijaUposlenika.MENADZER);
		}else if(administrator_rdbtn.isSelected())
		{
			u.SetPrivilegija(PrivilegijaUposlenika.ADMINISTRATOR);
		}else if(serviser_rdbtn.isSelected())
		{
			u.SetPrivilegija(PrivilegijaUposlenika.SERVISER);
		}else
		{
			u.SetPrivilegija(PrivilegijaUposlenika.DISPECER);
		}
	}
	
	private void ocistiPoljaZaUnos() {
		
		ime_tb.setText("");
		prezime_tb.setText("");
		jmbg_tb.setText("");
		adresa_tb.setText("");
		mjesto_tb.setText("");
		telefon_tb.setText("");
		email_tb.setText("");
		
		username_tb.setText("");
		password_tb.setText("");
	}
}
