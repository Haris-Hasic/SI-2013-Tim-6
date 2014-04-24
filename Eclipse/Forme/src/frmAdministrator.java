import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import forme.frmDodavanjeKorisnika;
import forme.frmPregledKorisnika;
import forme.frmPromjenaSifre;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JMenu;


public class frmAdministrator extends JFrame {
	public frmAdministrator() {
		setResizable(false);
		setTitle("Administrator");
		setBounds(100, 100, 280, 219);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 244, 92);
		panel_1.setBorder(BorderFactory.createTitledBorder("Uposlenici:"));
		panel.add(panel_1);
		
		ImageIcon slika = new ImageIcon(getClass().getResource("add-user.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		
		JButton btnDodajUposlenika = new JButton("Dodaj korisnika");
		btnDodajUposlenika.setHorizontalAlignment(SwingConstants.LEFT);
		btnDodajUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDodavanjeKorisnika frmKor=new frmDodavanjeKorisnika();
				frmKor.setVisible(true);
			}
		});
		btnDodajUposlenika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodajUposlenika.setIcon(new ImageIcon(temp));
		
		JButton btnPregledUposlenika = new JButton("Pregled korisnika");
		btnPregledUposlenika.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregledUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPregledKorisnika uposlenici=new frmPregledKorisnika();
				uposlenici.setVisible(true);
			}
		});
		btnPregledUposlenika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slika=new ImageIcon(getClass().getResource("SearchIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPregledUposlenika.setIcon(new ImageIcon(temp));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(btnDodajUposlenika, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
				.addComponent(btnPregledUposlenika, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnDodajUposlenika)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPregledUposlenika)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnOdjaviSe = new JButton("Odjavi se");
		btnOdjaviSe.setHorizontalAlignment(SwingConstants.LEFT);
		btnOdjaviSe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOdjaviSe.setBounds(10, 125, 244, 29);
		panel.add(btnOdjaviSe);
		slika=new ImageIcon(getClass().getResource("LogoutIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnOdjaviSe.setIcon(new ImageIcon(temp));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
		);
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
