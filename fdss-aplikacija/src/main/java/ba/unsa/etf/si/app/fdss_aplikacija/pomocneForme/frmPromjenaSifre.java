package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class frmPromjenaSifre extends JDialog {

	private JPanel contentPane;
	private JPasswordField staraSifra_pf;
	private JPasswordField novaSifra_pf;
	private JPasswordField potvrdaSifre_pf;
	private Uposlenik up;


	public frmPromjenaSifre(final Uposlenik u) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		up = u;
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Promjena \u0161ifre");
		setBounds(100, 100, 416, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaraifra = new JLabel("Stara \u0161ifra:");
		lblStaraifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStaraifra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStaraifra.setBounds(42, 27, 71, 14);
		contentPane.add(lblStaraifra);
		
		JLabel lblNovaifra = new JLabel("Nova \u0161ifra:");
		lblNovaifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaifra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNovaifra.setBounds(42, 58, 71, 14);
		contentPane.add(lblNovaifra);
		
		JLabel lblPotvrdaNoveifre = new JLabel("Potvrda nove \u0161ifre:");
		lblPotvrdaNoveifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPotvrdaNoveifre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPotvrdaNoveifre.setBounds(10, 89, 103, 14);
		contentPane.add(lblPotvrdaNoveifre);
		
		staraSifra_pf = new JPasswordField();
		staraSifra_pf.setBounds(123, 25, 271, 20);
		contentPane.add(staraSifra_pf);
		
		novaSifra_pf = new JPasswordField();
		novaSifra_pf.setBounds(123, 56, 271, 20);
		contentPane.add(novaSifra_pf);
		
		potvrdaSifre_pf = new JPasswordField();
		potvrdaSifre_pf.setBounds(123, 87, 271, 20);
		contentPane.add(potvrdaSifre_pf);
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				HibernateUposlenik hu = new HibernateUposlenik();
				
				if( novaSifra_pf.getText().compareTo(potvrdaSifre_pf.getText()) == 0 && up.getPassword().compareTo(Validacija.HesirajMD5(Validacija.HesirajMD5(staraSifra_pf.getText()))) == 0
					&& !hu.postojiPassword(Validacija.HesirajMD5(novaSifra_pf.getText()))) {
					
					up.setPassword(novaSifra_pf.getText());
					hu.updateUposlenika(up);
					
					novaSifra_pf.setText("");
					staraSifra_pf.setText("");
					potvrdaSifre_pf.setText("");
					
					JOptionPane.showMessageDialog(null, "Uspješno promijenjena lozinka !");
				}
				
				else {
					
					if(hu.postojiPassword(Validacija.HesirajMD5(novaSifra_pf.getText())))
						JOptionPane.showMessageDialog(null, "Unesena nova lozinka je već zauzeta !");
					
					else
						JOptionPane.showMessageDialog(null, "Lozinke se ne slažu !");
				}		
			}
		});
		btnNewButton.setBounds(305, 123, 89, 23);
		contentPane.add(btnNewButton);
	}
}
