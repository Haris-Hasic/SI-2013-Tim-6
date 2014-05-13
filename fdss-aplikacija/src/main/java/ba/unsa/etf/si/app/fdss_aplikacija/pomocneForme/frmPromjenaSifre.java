package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class frmPromjenaSifre extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPromjenaSifre frame = new frmPromjenaSifre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPromjenaSifre() {
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 25, 271, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(123, 56, 271, 20);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(123, 87, 271, 20);
		contentPane.add(passwordField_2);
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBounds(305, 123, 89, 23);
		contentPane.add(btnNewButton);
	}
}
