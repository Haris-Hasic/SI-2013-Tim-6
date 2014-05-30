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
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.JCheckBoxMenuItem;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDetaljiKlijenta;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDetaljiUredjaja;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelDodajKlijenta;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelPregledKlijenata;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelPregledUredjaja;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelPregledZadatakaServiser;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmPromjenaSifre;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class frmServiser extends JFrame {
	private JPanel contentPane;
	private JPanel centralniPanel;
	final Uposlenik uposlenik;
	public frmServiser(final Uposlenik uposlenik) {
		this.uposlenik=uposlenik;
		
		setTitle("Prijavljen kao: " + uposlenik.getIme() + " " + uposlenik.getPrezime());
		setBounds(100, 100, 743, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		centralniPanel=new JPanel();
		contentPane.add(centralniPanel, BorderLayout.CENTER);
		
		JButton btnPregledUreaja = new JButton("Pregled ure\u0111aja");
		btnPregledUreaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledUredjaja(false);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnPregledUreaja.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregledUreaja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnPretragaUreaja = new JButton("Detalji ure\u0111aja");
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
		
		JButton btnPregled = new JButton("Pregled klijenata");
		btnPregled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledKlijenata(false);
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
			public void mouseClicked(MouseEvent arg0) {

				frmLogin.pocetna.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		JButton btnZadaci = new JButton("Zadaci");
		btnZadaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(centralniPanel);
				centralniPanel = new panelPregledZadatakaServiser(uposlenik);
				contentPane.add(centralniPanel, BorderLayout.CENTER);
				centralniPanel.revalidate();
				centralniPanel.updateUI();
			}
		});
		btnZadaci.setHorizontalAlignment(SwingConstants.LEFT);
		
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
		
		slika=new ImageIcon(getClass().getResource("/AddIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		
		slika=new ImageIcon(getClass().getResource("/NotifIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		
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
		
		JMenuItem mntmOtvoriIzvjeaj = new JMenuItem("Otvori izvještaj");
		mnNewMenu.add(mntmOtvoriIzvjeaj);
		
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
		
		panel.setBorder(BorderFactory.createTitledBorder("Korisnici:"));
		TitledBorder border=(TitledBorder)panel.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_2.setBorder(BorderFactory.createTitledBorder("Ure\u0111aji:"));
		 border=(TitledBorder)panel_2.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		panel_5.setBorder(BorderFactory.createTitledBorder("Profil:"));
		border=(TitledBorder)panel_5.getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPretraga, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(btnPregled, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnPregled)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPretraga)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
				
				JLabel lblFdss = new JLabel("FDSS © – All rights reserved.");
				lblFdss.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblFdss.setHorizontalAlignment(SwingConstants.CENTER);
				
			
		
		

		
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(12)
									.addComponent(panel_2, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(12)
									.addComponent(panel, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(12)
									.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFdss, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap(29, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(26))
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblFdss)
							.addContainerGap())
				);

				
				
				
				GroupLayout gl_panel_5 = new GroupLayout(panel_5);
				gl_panel_5.setHorizontalGroup(
					gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnZadaci, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addContainerGap())
				);
				gl_panel_5.setVerticalGroup(
					gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnZadaci)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPregledUreaja, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(btnPretragaUreaja, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPregledUreaja)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPretragaUreaja)
					.addGap(8))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
	}
}
