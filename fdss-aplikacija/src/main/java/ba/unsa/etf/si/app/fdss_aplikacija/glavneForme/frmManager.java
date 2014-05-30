package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDetaljiKlijenta;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDetaljiUredjaja;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDodajKlijenta;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDodajUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelIzvjestaji;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelObradiZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelPregledKlijenata;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelPregledUredjaja;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelPregledZadatakaMenadzer;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmPromjenaSifre;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class frmManager extends JFrame {
	
	private JPanel contentPane;
	private JPanel centralniPanel;
	private Uposlenik uposlenik;
	
	public frmManager(final Uposlenik uposlenik) {
		this.uposlenik=uposlenik;
		
		setTitle("Prijavljen kao: ");
		setBounds(100, 100, 849, 597);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int novaVarijable=5;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		
		JButton btnIzvjetaji = new JButton("Kreiraj izvještaj");
		btnIzvjetaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelIzvjestaji(uposlenik);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnIzvjetaji.setHorizontalAlignment(SwingConstants.LEFT);
		btnIzvjetaji.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnZadaci = new JButton("Pregled zadataka");
		btnZadaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledZadatakaMenadzer();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();	
			}
		});
		btnZadaci.setHorizontalAlignment(SwingConstants.LEFT);
		
		centralniPanel=new JPanel();
		contentPane.add(centralniPanel, BorderLayout.CENTER);
				
		JButton btnNewButton_1 = new JButton("Dodaj ure\u0111aj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelDodajUredjaj();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		
		
		
		
		
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPregledUreaja = new JButton("Pregled ure\u0111aja");
		btnPregledUreaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledUredjaja(true);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();

			}
		});
		btnPregledUreaja.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregledUreaja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPretragaUreaja = new JButton("Detalji uređaja");
		btnPretragaUreaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelDetaljiUredjaja();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPretragaUreaja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPretragaUreaja.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnDodajKlijenta = new JButton("Dodaj klijenta");
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.remove(centralniPanel);
				centralniPanel = new panelDodajKlijenta();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnDodajKlijenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnDodajKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPregled = new JButton("Pregled klijenata");
		btnPregled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledKlijenata(true);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPregled.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregled.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPretraga = new JButton("Detalji klijenta");
		btnPretraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelDetaljiKlijenta();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPretraga.setHorizontalAlignment(SwingConstants.LEFT);
		btnPretraga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnNewButton = new JButton("Odjavi se");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JButton btnZahtjevi = new JButton("Obradi zahtjev");
		
		ImageIcon slika = new ImageIcon(getClass().getResource("/NotifIcon.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		
		slika=new ImageIcon(getClass().getResource("/LogoutIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnNewButton.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/AddUserIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnDodajKlijenta.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/AddIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnNewButton_1.setIcon(new ImageIcon(temp));
		
		
		
		slika=new ImageIcon(getClass().getResource("/SearchIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20
				, java.awt.Image.SCALE_SMOOTH);
		btnPretragaUreaja.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/SearchUserIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20
				, java.awt.Image.SCALE_SMOOTH);
		btnPretraga.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/RepoIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnIzvjetaji.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/ViewIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPregled.setIcon(new ImageIcon(temp));
		btnPregledUreaja.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/GroupIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPregled.setIcon(new ImageIcon(temp));
		
		slika=new ImageIcon(getClass().getResource("/ZadaciIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnZadaci.setIcon(new ImageIcon(temp));
		btnZadaci.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		slika=new ImageIcon(getClass().getResource("/NotifIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnZahtjevi.setIcon(new ImageIcon(temp));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Postavke");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPromjenaifre = new JMenuItem("Promjena \u0161ifre");
		mntmPromjenaifre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPromjenaSifre fs=new frmPromjenaSifre();
				fs.setVisible(true);
			}
		});
		mnNewMenu.add(mntmPromjenaifre);
		
		JMenuItem mntmOtvoriIzvjetaj = new JMenuItem("Otvori izvještaj");
		mntmOtvoriIzvjetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chooser c=new Chooser();
				Process p = null;
				try {
					p = Runtime
							   .getRuntime()
							   .exec("rundll32 url.dll,FileProtocolHandler "+c.fileName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						try {
							p.waitFor();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		});
		mnNewMenu.add(mntmOtvoriIzvjetaj);
		
		JMenuItem mntmIzlaz = new JMenuItem("Izlaz");
		mntmIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmIzlaz);
		
		JMenu mnOstalo = new JMenu("Ostalo");
		menuBar.add(mnOstalo);
		
		JMenuItem mntmPopratnaDokumentacija = new JMenuItem("Popratna dokumentacija");
		mntmPopratnaDokumentacija.addActionListener(new ActionListener() {
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
		mnOstalo.add(mntmPopratnaDokumentacija);
		
		JMenuItem mntmOnlinePomo = new JMenuItem("Online pomoć");
		mnOstalo.add(mntmOnlinePomo);
		
		JMenuItem mntmNadogradi = new JMenuItem("Nadogradi");
		mntmNadogradi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Instalirana je najnovija verzija aplikacije.");
			}
		});
		mnOstalo.add(mntmNadogradi);
		
		panel.setBorder(BorderFactory.createTitledBorder("Klijenti:"));
		TitledBorder border=(TitledBorder)panel.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_2.setBorder(BorderFactory.createTitledBorder("Ure\u0111aji:"));
		 border=(TitledBorder)panel_2.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_4.setBorder(BorderFactory.createTitledBorder("Aktivnosti:"));
		border=(TitledBorder)panel_4.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnDodajKlijenta, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnPregled, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnPretraga, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDodajKlijenta)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnPregled)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPretraga)
					.addGap(13))
		);
		panel.setLayout(gl_panel);
				
				JLabel lblFdss = new JLabel("FDSS © – All rights reserved.");
				lblFdss.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblFdss.setHorizontalAlignment(SwingConstants.CENTER);
				
			
		
		

		
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(29)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
										.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
										.addComponent(lblFdss, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
							.addContainerGap())
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFdss)
							.addGap(5))
				);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(btnPregledUreaja, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(btnPretragaUreaja, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPregledUreaja)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPretragaUreaja)
					.addGap(7))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		btnZahtjevi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelObradiZahtjev();
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnZahtjevi.setHorizontalAlignment(SwingConstants.LEFT);
		btnZahtjevi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(btnIzvjetaji, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnZadaci, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(btnZahtjevi, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnZahtjevi)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnZadaci)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIzvjetaji)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		panel_1.setLayout(gl_panel_1);
		
		
		
		
	}
}

class Chooser extends JFrame {

JFileChooser chooser;
String fileName;

public Chooser() {
chooser = new JFileChooser();
int r = chooser.showOpenDialog(new JFrame());
if (r == JFileChooser.APPROVE_OPTION) {
fileName = chooser.getSelectedFile().getPath();
}
}
}
