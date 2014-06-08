package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.PrivilegijaUposlenika;

import javax.swing.JCheckBox;

public class frmIzmjenaKorisnika extends JDialog{

	private JPanel contentPane;
	private JTextField ime_tb;
	private JTextField prezime_tb;
	private JTextField username_tb;
	private JPasswordField password_tb;
	private JTextField adresa_tb;
	private JTextField mjesto_tb;
	private JTextField telefon_tb;
	private JTextField email_tb;
	private JTextField jmbg_tb;
	private Uposlenik up;
	
	JRadioButton administrator_rdbtn;
	JRadioButton menadzer_rdbtn;
	JRadioButton dispecer_rdbtn;
	JRadioButton serviser_rdbtn;
	JCheckBox chckbxNovaLozinka;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public frmIzmjenaKorisnika(Uposlenik u) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				
				frmPregledKorisnika.korisniciPregled.setVisible(true);
			}
		});//u implementaciji promjeniti ovaj konstruktor u public frmIzmjenaKorisnika(Korisnik k)
		
		up = u;
		
		setResizable(false);	 //i onda u prazna polja upisati njegove vrijednosti
		setTitle("Ure\u0111ivanje korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Privilegija"));
		panel_1.setBounds(10, 322, 416, 49);
		contentPane.add(panel_1);
		
		administrator_rdbtn = new JRadioButton("Administrator");
		administrator_rdbtn.setSelected(true);
		administrator_rdbtn.setBounds(118, 18, 109, 23);
		panel_1.add(administrator_rdbtn);
		
		menadzer_rdbtn = new JRadioButton("Menadžer");
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
	    
		switch(u.getPrivilegija())
		{
			case ADMINISTRATOR:
				administrator_rdbtn.setSelected(true);
				break;
			case MENADZER:
				menadzer_rdbtn.setSelected(true);
				break;
			case SERVISER:
				serviser_rdbtn.setSelected(true);
				break;
			case DISPECER:
				dispecer_rdbtn.setSelected(true);
				break;
			default:
				break;	
		}
	    
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Novi korisnik"));
		panel.setBounds(8, 11, 416, 310);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Ime :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(50, 28, 70, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Prezime :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(50, 59, 70, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Korisničko ime :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(27, 123, 93, 14);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Adresa :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(50, 182, 70, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Mjesto :");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(50, 213, 70, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Telefon :");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(50, 244, 70, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Email :");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(50, 275, 70, 14);
		panel.add(label_7);
		
		ime_tb = new JTextField();
		ime_tb.setColumns(10);
		ime_tb.setBounds(130, 25, 241, 20);
		panel.add(ime_tb);
		
		prezime_tb = new JTextField();
		prezime_tb.setColumns(10);
		prezime_tb.setBounds(130, 56, 241, 20);
		panel.add(prezime_tb);
		
		username_tb = new JTextField();
		username_tb.setColumns(10);
		username_tb.setBounds(130, 120, 241, 20);
		panel.add(username_tb);
		
		password_tb = new JPasswordField();
		password_tb.setEnabled(false);
		password_tb.setColumns(10);
		password_tb.setBounds(234, 151, 137, 20);
		panel.add(password_tb);
		
		adresa_tb = new JTextField();
		adresa_tb.setColumns(10);
		adresa_tb.setBounds(130, 179, 241, 20);
		panel.add(adresa_tb);
		
		mjesto_tb = new JTextField();
		mjesto_tb.setColumns(10);
		mjesto_tb.setBounds(130, 210, 241, 20);
		panel.add(mjesto_tb);
		
		telefon_tb = new JTextField();
		telefon_tb.setColumns(10);
		telefon_tb.setBounds(130, 241, 241, 20);
		panel.add(telefon_tb);
		
		email_tb = new JTextField();
		email_tb.setColumns(10);
		email_tb.setBounds(130, 272, 241, 20);
		panel.add(email_tb);
		
		jmbg_tb = new JTextField();
		jmbg_tb.setColumns(10);
		jmbg_tb.setBounds(130, 87, 241, 20);
		panel.add(jmbg_tb);
		
		JLabel label_8 = new JLabel("JMBG :");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(74, 90, 46, 14);
		panel.add(label_8);
		
		chckbxNovaLozinka = new JCheckBox("Nova lozinka");
		chckbxNovaLozinka.setBounds(131, 150, 99, 23);
		panel.add(chckbxNovaLozinka);
		
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        if(chckbxNovaLozinka.isSelected())
		        {
		        	password_tb.setEnabled(true);
		        }
		        else {
		        	password_tb.setText("");
		        	password_tb.setEnabled(false);
		        }
		      }
		    };
		chckbxNovaLozinka.addChangeListener(changeListener);   
		JButton btnNapraviIzmjene = new JButton("Napravi Izmjene");
		btnNapraviIzmjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNapraviIzmjene.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					pokupiPodatke(up); // Ovdje baca exception ako podaci nisu ispravni 
					
					HibernateUposlenik h = new HibernateUposlenik();
					if(chckbxNovaLozinka.isSelected())
					{
						h.updateUposlenika(up);
					}
					else
					{
						h.updateUposlenikBezSifre(up);
					}
					JOptionPane.showMessageDialog(null, "Izmjene izvršene !");
					up=h.dajUposlenika(up.getId());
					frmPregledKorisnika.korisniciPregled.setVisible(true);
					dispose();
				}
				
				catch (GeneralniException g) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, g.getMessage());
				}
			}
		});
		btnNapraviIzmjene.setBounds(302, 382, 124, 31);
		contentPane.add(btnNapraviIzmjene);
		
		upisiPodatke();
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
			u.SetPrivilegija(PrivilegijaUposlenika.MENADZER);
		
		else if(administrator_rdbtn.isSelected())
			u.SetPrivilegija(PrivilegijaUposlenika.ADMINISTRATOR);
		
		else if(serviser_rdbtn.isSelected())
			u.SetPrivilegija(PrivilegijaUposlenika.SERVISER);
		
		else
			u.SetPrivilegija(PrivilegijaUposlenika.DISPECER);
	}
	
	private void upisiPodatke() {
		
		ime_tb.setText(up.getIme());
		prezime_tb.setText(up.getPrezime());
		jmbg_tb.setText(up.getJmbg());
		adresa_tb.setText(up.getAdresa());
		mjesto_tb.setText(up.getMjesto());
		telefon_tb.setText(up.getTelefon());
		email_tb.setText(up.getEmail());
		
		username_tb.setText(up.getUserName());
		//password_tb.setText(up.getPassword());
		
		switch(up.getPrivilegija())
		{
			case ADMINISTRATOR:
				administrator_rdbtn.setSelected(true);
				break;
			case MENADZER:
				menadzer_rdbtn.setSelected(true);
				break;
			case SERVISER:
				serviser_rdbtn.setSelected(true);
				break;
			case DISPECER:
				dispecer_rdbtn.setSelected(true);
				break;
			default:
				break;
					
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
