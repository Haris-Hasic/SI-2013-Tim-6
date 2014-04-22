package forme;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class frmPregledKorisnika extends JFrame {
	private JTextField textField;
	
	public frmPregledKorisnika() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Korisnici");
		setBounds(100, 100, 386, 220);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 369, 181);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 11, 52, 45);
		panel.add(btnHome);
		
		ImageIcon slika = new ImageIcon(getClass().getResource("..\\home.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		btnHome.setIcon(new ImageIcon(temp));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(160, 15, 0, 2);
		panel.add(separator);
		
		textField = new JTextField();
		textField.setBounds(97, 20, 150, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnTrazi = new JButton("Tra\u017Ei");
		btnTrazi.setBounds(257, 20, 100, 29);
		panel.add(btnTrazi);
		slika=new ImageIcon(getClass().getResource("..\\search.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnTrazi.setIcon(new ImageIcon(temp));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 59, 347, 2);
		panel.add(separator_1);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Korisnik Ime Prezime 1", "Korisnik Ime Prezime 2", "Korisnik Ime Prezime 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 72, 347, 60);
		panel.add(list);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIzmjenaKorisnika fi=new frmIzmjenaKorisnika();
				fi.setVisible(true);
			}
		});
		btnUredi.setBounds(147, 143, 100, 28);
		panel.add(btnUredi);
		slika=new ImageIcon(getClass().getResource("..\\edit.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnUredi.setIcon(new ImageIcon(temp));
		
		JButton btnIzbrisi = new JButton("Izbri\u0161i");
		btnIzbrisi.setBounds(257, 143, 100, 28);
		panel.add(btnIzbrisi);
		slika=new ImageIcon(getClass().getResource("..\\delete.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnIzbrisi.setIcon(new ImageIcon(temp));
	}
}
