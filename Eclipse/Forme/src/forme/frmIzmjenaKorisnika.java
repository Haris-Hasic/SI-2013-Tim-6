package forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class frmIzmjenaKorisnika extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public frmIzmjenaKorisnika() {//u implementaciji promjeniti ovaj konstruktor u public frmIzmjenaKorisnika(Korisnik k)
		setResizable(false);	 //i onda u prazna polja upisati njegove vrijednosti
		setTitle("Ure\u0111ivanje korisnika");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(3, 11, 431, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Ime:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 27, 70, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 58, 70, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Korisni\u010Dko ime:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 89, 70, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u0160ifra:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(10, 120, 70, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Adresa:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(10, 148, 70, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Grad:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(10, 179, 70, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Telefon:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(10, 210, 70, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Email:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(10, 241, 70, 14);
		panel.add(label_7);
		
		textField = new JTextField();
		textField.setBounds(90, 24, 241, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 55, 241, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 86, 241, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(90, 117, 241, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(90, 145, 241, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(90, 176, 137, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(90, 207, 137, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(90, 238, 137, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		panel.setBorder(BorderFactory.createTitledBorder("Podaci o korisniku"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 283, 429, 83);
		panel_1.setBorder(BorderFactory.createTitledBorder("Privilegija"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setSelected(true);
		rdbtnAdministrator.setBounds(41, 23, 109, 23);
		panel_1.add(rdbtnAdministrator);
		
		JRadioButton rdbtnMenader = new JRadioButton("Menad\u017Eer");
		rdbtnMenader.setBounds(41, 49, 109, 23);
		panel_1.add(rdbtnMenader);
		
		JRadioButton rdbtnServiser = new JRadioButton("Serviser");
		rdbtnServiser.setBounds(192, 23, 109, 23);
		panel_1.add(rdbtnServiser);
		
		JRadioButton rdbtnDispacher = new JRadioButton("Dispacher");
		rdbtnDispacher.setBounds(192, 49, 109, 23);
		panel_1.add(rdbtnDispacher);
		
		JButton btnDodajKorisnika = new JButton("Uredi");
		btnDodajKorisnika.setBounds(319, 377, 105, 23);
		contentPane.add(btnDodajKorisnika);
	}
}
