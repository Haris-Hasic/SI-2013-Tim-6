package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.glavneForme.frmAdministrator;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;


public class frmPregledKorisnika extends JFrame {
	
	private JTextField pretraga_tb;
	private DefaultListModel model=new DefaultListModel();
	private HibernateUposlenik h = new HibernateUposlenik();
	Uposlenik uposlenik;
	final JList list;
	public frmPregledKorisnika(Uposlenik u) {
		uposlenik=u;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setTitle("Korisnici");
		setBounds(100, 100, 386, 341);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 369, 301);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnHome = new JButton("");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmAdministrator fa = new frmAdministrator(uposlenik);
				fa.setVisible(true);
				
				dispose();
			}
		});
		btnHome.setBounds(10, 11, 52, 45);
		panel.add(btnHome);
		
		ImageIcon slika = new ImageIcon(getClass().getResource("/home.png"));
		Image sl=slika.getImage();
		Image temp=sl.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		slika=new ImageIcon(temp);
		btnHome.setIcon(new ImageIcon(temp));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(160, 15, 0, 2);
		panel.add(separator);
		
		list = new JList();
		pretraga_tb = new JTextField();
		pretraga_tb.setBounds(97, 20, 150, 28);
		panel.add(pretraga_tb);
		pretraga_tb.setColumns(10);
		
		JButton btnTrazi = new JButton("Tra\u017Ei");
		btnTrazi.setBounds(257, 20, 100, 29);
		panel.add(btnTrazi);
		slika=new ImageIcon(getClass().getResource("/search.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnTrazi.setIcon(new ImageIcon(temp));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 59, 347, 2);
		panel.add(separator_1);
		
		JButton btnUredi = new JButton("Uredi");
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list.getSelectedIndex() > -1)
				{
					Uposlenik u = (Uposlenik)model.getElementAt(list.getSelectedIndex());
					frmIzmjenaKorisnika fi = new frmIzmjenaKorisnika(u);
					fi.setVisible(true);
				}
				
				ispisiListu();
			}
		});
		
		btnTrazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
								
				model.clear();
				
				String unos = pretraga_tb.getText().toLowerCase();
				List<Uposlenik> upos = h.dajSveUposlenike();
				
				for(Uposlenik u:upos)
				{
					String temp = u.getIme().toLowerCase() + " " + u.getPrezime().toLowerCase();
					if(temp.contains(unos))
						model.addElement(u);
				}
			}
		});
		
		btnUredi.setBounds(147, 262, 100, 28);
		panel.add(btnUredi);
		slika=new ImageIcon(getClass().getResource("/edit.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnUredi.setIcon(new ImageIcon(temp));
		
		JButton btnIzbrisi = new JButton("Izbri\u0161i");
		btnIzbrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(list.getSelectedIndex() > -1)
				{
					Uposlenik u = (Uposlenik)model.getElementAt(list.getSelectedIndex());
					
					if(h.postojiUposlenik(u.getId())) {
						
						h.brisiUposlenika(u);
						JOptionPane.showMessageDialog(null, "Uposlenik uspješno obrisan !");
						ispisiListu();
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Greška pri brisanju uposlenika !");
					}
				}

			}
		});
		btnIzbrisi.setBounds(257, 262, 100, 28);
		panel.add(btnIzbrisi);
		slika=new ImageIcon(getClass().getResource("/delete.png"));
		sl=slika.getImage();
		temp=sl.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnIzbrisi.setIcon(new ImageIcon(temp));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 347, 184);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(list);
		list.setModel(model);
		
		ispisiListu();
	}
	
	public void ispisiListu()
	{
		List<Uposlenik> l = h.vratiSveUposlenike();
		
		model.clear();
		
		for(Uposlenik u:l)
			model.addElement(u);
	}
}
