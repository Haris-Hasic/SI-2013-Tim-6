package ba.unsa.etf.si.app.fdss_aplikacija.glavneForme;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import ba.unsa.etf.si.app.fdss_aplikacija.klase.TestPristupaBazi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmExport extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public frmExport() {
		setBounds(100, 100, 415, 270);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(53, 70, 294, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUnesiteNazivFoldera = new JLabel("1. Unesite naziv fajla u koji želite smjestiti podatke:");
		lblUnesiteNazivFoldera.setBounds(53, 45, 294, 14);
		getContentPane().add(lblUnesiteNazivFoldera);
		
		JButton btnGotovo = new JButton("Exportuj");
		btnGotovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=textField_1.getText();
				String newString = str.replace("\\","/");
				TestPristupaBazi.exportPodataka(newString+"/"+textField.getText() +".csv");
				JOptionPane.showMessageDialog(null, "Podaci su eksportovani.");
				dispose();
			}
		});
		btnGotovo.setBounds(258, 185, 89, 23);
		getContentPane().add(btnGotovo);
		
		JLabel lblNewLabel = new JLabel("Exportovanje podataka iz baze u dokument");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(10, 11, 324, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblOdaberiteLokaciju = new JLabel("2. Odaberite folder u koji želite smjestiti fajl:");
		lblOdaberiteLokaciju.setBounds(53, 114, 294, 14);
		getContentPane().add(lblOdaberiteLokaciju);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 139, 200, 23);
		getContentPane().add(textField_1);
		
		JButton btnOdaberi = new JButton("Odaberi");
		btnOdaberi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int r = chooser.showOpenDialog(new JFrame());
				String folder = chooser.getSelectedFile().getPath();
				textField_1.setText(folder);
				
			}
		});
		btnOdaberi.setBounds(258, 139, 89, 23);
		getContentPane().add(btnOdaberi);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Potrebno je u prvi textbox unijeti naziv fajla u koji želimo smjestiti podatke, npr. primjer.csv, \n"
						+ "zatim kliknuti na button odaberi i odabrati datoteku u koju želimo smjestiti fajl čije smo ime unijeli u prvom textboxu. \n"
						+ "Nakon toga potrebno je kliknuti dogme extraktuj. Traženi fajl nalazi se u odabranoj datoteci na računaru.");
			}
		});
		button.setIcon(new ImageIcon(frmExport.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		button.setBounds(339, 11, 26, 23);
		getContentPane().add(button);
	}
}


