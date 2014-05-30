package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JMenu;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.TestPristupaBazi;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmDodavanjeKorisnika;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmPregledKorisnika;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmPromjenaSifre;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class frmAdministrator extends JFrame {
	Uposlenik uposlenik;
	public frmAdministrator(Uposlenik u) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		
		this.uposlenik = u;
		setResizable(false);
		//setTitle("Administrator: " + uposlenik.getIme() + " " + uposlenik.getPrezime());
		setBounds(100, 100, 270, 254);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 244, 114);
		panel_1.setBorder(BorderFactory.createTitledBorder("Uposlenici:"));
		panel.add(panel_1);
		
		ImageIcon slika = new ImageIcon(getClass().getResource("/add-user.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		
		JButton btnDodajUposlenika = new JButton("Dodaj korisnika");
		btnDodajUposlenika.setHorizontalAlignment(SwingConstants.LEFT);
		btnDodajUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDodavanjeKorisnika frmKor = new frmDodavanjeKorisnika(uposlenik);
				frmKor.setVisible(true);
			}
		});
		btnDodajUposlenika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodajUposlenika.setIcon(new ImageIcon(temp));
		
		JButton btnPregledUposlenika = new JButton("Pregled korisnika");
		btnPregledUposlenika.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregledUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPregledKorisnika uposlenici = new frmPregledKorisnika(uposlenik);
				uposlenici.setVisible(true);
				dispose();
			}
		});
		btnPregledUposlenika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slika=new ImageIcon(getClass().getResource("/SearchIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPregledUposlenika.setIcon(new ImageIcon(temp));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPregledUposlenika, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addComponent(btnDodajUposlenika, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(btnDodajUposlenika)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPregledUposlenika)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		slika=new ImageIcon(getClass().getResource("/LogoutIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
		);
		
		JButton btnOdjaviSe = new JButton("Odjavi se");
		btnOdjaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOdjaviSe.setBounds(27, 140, 212, 29);
		panel.add(btnOdjaviSe);
		btnOdjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		btnOdjaviSe.setHorizontalAlignment(SwingConstants.LEFT);
		btnOdjaviSe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOdjaviSe.setIcon(new ImageIcon(temp));
		
		JLabel lblNewLabel = new JLabel("FDSS © – All rights reserved.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 180, 244, 14);
		panel.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPostavke = new JMenu("Postavke");
		mnPostavke.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnPostavke);
		
		JMenuItem mntmPromjenaifre = new JMenuItem("Promjena \u0161ifre");
		mntmPromjenaifre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmPromjenaifre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPromjenaSifre fs=new frmPromjenaSifre();
				fs.setVisible(true);
			}
		});
		mnPostavke.add(mntmPromjenaifre);
		
		JMenuItem mntmPodesiParametreKonekcije = new JMenuItem("Podesi parametre konekcije");
		mntmPodesiParametreKonekcije.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnPostavke.add(mntmPodesiParametreKonekcije);
		
		JMenuItem mntmExportPodatakaIz = new JMenuItem("Export podataka iz baze");
		mntmExportPodatakaIz.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmExportPodatakaIz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExport ex=new frmExport();
				ex.setVisible(true);
			}
		});
		mnPostavke.add(mntmExportPodatakaIz);
		
		JMenuItem mntmImportPodatakaU = new JMenuItem("Import podataka u bazu");
		mntmImportPodatakaU.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmImportPodatakaU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Potrebno je odabrati fajl sa ekstenzijom .csv u kojem se nalaze novi podaci koji se trebaju unijeti u bazu");
				Chooser c=new Chooser();
				String putanja=c.fileName;
				String novi = putanja.replace("\\","/");
				TestPristupaBazi.importPodataka(novi);
				
			}
		});
		mnPostavke.add(mntmImportPodatakaU);
		
		JMenuItem mntmIzlaz = new JMenuItem("Izlaz");
		mntmIzlaz.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		mntmIzlaz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		mnPostavke.add(mntmIzlaz);
		
		JMenu mnOstalo = new JMenu("Ostalo");
		mnOstalo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnOstalo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Popratna dokumentacija");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final File f = new File(frmLogin.class.getProtectionDomain().getCodeSource().getLocation().getPath());
					if (f.exists()) {
						Process p = Runtime
						   .getRuntime()
						   .exec("rundll32 url.dll,FileProtocolHandler "+f+"\\Uputstvo za korištenje.pdf");
						p.waitFor();
			 
					} else {
			 
						JOptionPane.showMessageDialog(null, "Dokument ne postoji");
			 
					}			 
			  	  } catch (Exception ex) {
					ex.printStackTrace();
				  }
			}
		});
		mnOstalo.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Online pomoć");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "https://github.com/Haris-Hasic/SI2013Tim6/wiki/Uputstvo-za-kori%C5%A1tenje";
		         try {
					Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnOstalo.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNadogradi = new JMenuItem("Nadogradi");
		mntmNadogradi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNadogradi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Instalirana je najnovija verzija aplikacije.");
			}
		});
		mnOstalo.add(mntmNadogradi);
		
	}
}
