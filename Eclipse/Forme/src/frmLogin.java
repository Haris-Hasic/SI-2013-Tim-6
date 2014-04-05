import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class frmLogin extends JFrame {
	
	private JTextField textField;
	private ImageIcon slika;
	
	private JPanel contentPane;
	private JPasswordField passwordField;

	
	public frmLogin() {
		setResizable(false);
		setTitle("Prijava na sistem");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblKorisnikoIme.setBounds(98, 34, 105, 20);
		getContentPane().add(lblKorisnikoIme);
		
		JLabel lblKorisnikaifra = new JLabel("Korisni\u010Dka \u0161ifra:");
		lblKorisnikaifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikaifra.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblKorisnikaifra.setBounds(98, 74, 105, 14);
		getContentPane().add(lblKorisnikaifra);
		
		textField = new JTextField();
		textField.setBounds(213, 35, 219, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmManager man=new frmManager();
				man.setVisible(true);
			}
		});
		btnPrijaviSe.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnPrijaviSe.setBounds(213, 103, 105, 33);
		getContentPane().add(btnPrijaviSe);
		
		JButton btnNewButton = new JButton("Zatvori");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnNewButton.setBounds(328, 103, 104, 33);
		getContentPane().add(btnNewButton);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 25, 90, 90);
		getContentPane().add(lblNewLabel);
		
		slika = new ImageIcon(getClass().getResource("LoginIcon.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		lblNewLabel.setIcon(slika);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 72, 219, 20);
		contentPane.add(passwordField);
	}
}
