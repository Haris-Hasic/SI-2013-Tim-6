package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.TestPristupaBazi;

import java.awt.Font;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPodesiBazu extends JFrame{
	private JTextField tbaza;
	private JTextField tuser;
	private JTextField tpass;
	public frmPodesiBazu() {
		setBounds(100, 100, 288, 213);
		getContentPane().setLayout(null);
		
		tbaza = new JTextField();
		tbaza.setBounds(107, 43, 135, 20);
		getContentPane().add(tbaza);
		tbaza.setColumns(10);
		
		tuser = new JTextField();
		tuser.setBounds(107, 74, 135, 20);
		getContentPane().add(tuser);
		tuser.setColumns(10);
		
		tpass = new JTextField();
		tpass.setBounds(107, 105, 135, 20);
		getContentPane().add(tpass);
		tpass.setColumns(10);
		
		JLabel lblImeBaze = new JLabel("Ime baze:");
		lblImeBaze.setBounds(46, 43, 68, 14);
		getContentPane().add(lblImeBaze);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(37, 74, 77, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(37, 105, 77, 14);
		getContentPane().add(lblPassword);
		
		JButton btnProvjeri = new JButton("Testiraj konekciju");
		btnProvjeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestPristupaBazi t= new TestPristupaBazi(tbaza.getText(),tuser.getText(),tpass.getText());
				try {
					if(TestPristupaBazi.Testiraj()) JOptionPane.showMessageDialog(null, "Konekcija je uspješna za navedene parametre.");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
		});
		btnProvjeri.setBounds(107, 136, 135, 23);
		getContentPane().add(btnProvjeri);
		
		JLabel lblProvjeraParametaraKonekcije = new JLabel("Podešavanje parametara konekcije");
		lblProvjeraParametaraKonekcije.setForeground(Color.BLUE);
		lblProvjeraParametaraKonekcije.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProvjeraParametaraKonekcije.setBounds(10, 9, 251, 23);
		getContentPane().add(lblProvjeraParametaraKonekcije);
	}

}
