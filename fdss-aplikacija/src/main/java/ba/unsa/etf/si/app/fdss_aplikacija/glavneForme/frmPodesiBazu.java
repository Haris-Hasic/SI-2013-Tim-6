package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class frmPodesiBazu extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public frmPodesiBazu() {
		setBounds(100, 100, 288, 213);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(107, 43, 135, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 74, 135, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 105, 135, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
		btnProvjeri.setBounds(107, 136, 135, 23);
		getContentPane().add(btnProvjeri);
		
		JLabel lblProvjeraParametaraKonekcije = new JLabel("Podešavanje parametara konekcije");
		lblProvjeraParametaraKonekcije.setForeground(Color.BLUE);
		lblProvjeraParametaraKonekcije.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProvjeraParametaraKonekcije.setBounds(10, 9, 251, 23);
		getContentPane().add(lblProvjeraParametaraKonekcije);
	}

}
