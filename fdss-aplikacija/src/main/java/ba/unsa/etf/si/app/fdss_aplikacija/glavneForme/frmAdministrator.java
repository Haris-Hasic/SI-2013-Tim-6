package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

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
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmDodavanjeKorisnika;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmPregledKorisnika;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmPromjenaSifre;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;


public class frmAdministrator extends JFrame {
	Uposlenik uposlenik;
	public frmAdministrator(Uposlenik u) {
		uposlenik=u;
		setResizable(false);
		setTitle("Administrator");
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
				dispose();
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
		menuBar.add(mnPostavke);
		
		JMenuItem mntmPromjenaifre = new JMenuItem("Promjena \u0161ifre");
		mntmPromjenaifre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPromjenaSifre fs=new frmPromjenaSifre();
				fs.setVisible(true);
			}
		});
		mnPostavke.add(mntmPromjenaifre);
		
	}
}
