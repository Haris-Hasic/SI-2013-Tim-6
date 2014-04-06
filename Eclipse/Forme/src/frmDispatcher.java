import javax.swing.ImageIcon;
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
import java.awt.Color;


public class frmDispatcher extends JFrame {
	public frmDispatcher() {
		setTitle("Prijavljen kao: Ime i Prezime");
		setBounds(100, 100, 548, 358);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmPostavke = new JMenuItem("Postavke");
		menuBar.add(mntmPostavke);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 225, 285);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 8, 215, 91);
		panel_1.setBorder(BorderFactory.createTitledBorder("Profil:"));
		panel.add(panel_1);
		
		JButton btnNoviZadaci = new JButton("Obavje\u0161tenja i poruke(2)");
		btnNoviZadaci.setHorizontalAlignment(SwingConstants.LEFT);
		btnNoviZadaci.setFont(new Font("Tahoma", Font.BOLD, 11));
		ImageIcon slika = new ImageIcon(getClass().getResource("NotifIcon.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		
		btnNoviZadaci.setIcon(new ImageIcon(temp));
		slika=new ImageIcon(getClass().getResource("ZadaciIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		
		JButton btnKreirajZahtjev = new JButton("Kreiraj zahtjev");
		btnKreirajZahtjev.setHorizontalAlignment(SwingConstants.LEFT);
		btnKreirajZahtjev.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slika=new ImageIcon(getClass().getResource("add-blog.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnKreirajZahtjev.setIcon(new ImageIcon(temp));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNoviZadaci, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKreirajZahtjev, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnNoviZadaci)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnKreirajZahtjev, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Korisnici:"));
		panel_2.setBounds(5, 110, 215, 91);
		panel.add(panel_2);
		
		JButton button = new JButton("Pregled korisnika");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slika=new ImageIcon(getClass().getResource("GroupIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(temp));
		
		JButton button_1 = new JButton("Tra\u017Ei korisnika");
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slika=new ImageIcon(getClass().getResource("SearchUserIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		button_1.setIcon(new ImageIcon(temp));
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 203, Short.MAX_VALUE)
				.addComponent(button, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
				.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 85, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton button_2 = new JButton("Odjavi se");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_2.setBounds(5, 245, 215, 29);
		panel.add(button_2);
		slika=new ImageIcon(getClass().getResource("LogoutIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		button_2.setIcon(new ImageIcon(temp));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(224, 0, 301, 285);
		getContentPane().add(panel_3);
	}

}
