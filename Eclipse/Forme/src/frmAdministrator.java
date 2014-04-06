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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class frmAdministrator extends JFrame {
	public frmAdministrator() {
		setTitle("Prijavljen kao: Ime i Prezime");
		setBounds(100, 100, 537, 245);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmPostavke = new JMenuItem("Postavke");
		menuBar.add(mntmPostavke);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 213, 173);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 191, 92);
		panel_1.setBorder(BorderFactory.createTitledBorder("Uposlenici:"));
		panel.add(panel_1);
		
		ImageIcon slika = new ImageIcon(getClass().getResource("add-user.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		
		JButton btnDodajUposlenika = new JButton("Dodaj uposlenika");
		btnDodajUposlenika.setHorizontalAlignment(SwingConstants.LEFT);
		btnDodajUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDodajUposlenika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodajUposlenika.setIcon(new ImageIcon(temp));
		
		JButton btnPregledUposlenika = new JButton("Pregled uposlenika");
		btnPregledUposlenika.setHorizontalAlignment(SwingConstants.LEFT);
		btnPregledUposlenika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPregledUposlenika uposlenici=new frmPregledUposlenika();
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
		btnOdjaviSe.setBounds(10, 125, 191, 29);
		panel.add(btnOdjaviSe);
		slika=new ImageIcon(getClass().getResource("LogoutIcon.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnOdjaviSe.setIcon(new ImageIcon(temp));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(212, 0, 301, 173);
		getContentPane().add(panel_2);
		
	}
}
