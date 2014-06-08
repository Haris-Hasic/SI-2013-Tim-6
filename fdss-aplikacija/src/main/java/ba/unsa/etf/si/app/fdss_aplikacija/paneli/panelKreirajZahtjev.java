package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Hitnost;

import com.toedter.calendar.JDateChooser;

public class panelKreirajZahtjev extends JPanel {
	JComboBox cbNazivFirme;
	JComboBox cbHitnost;
	JComboBox cbIBFU;
	JDateChooser dateChooser;
	/**
	 * Create the panel.
	 */
	List<Klijent> klijenti;
	public panelKreirajZahtjev(List<Klijent> klijenti) {
		this.klijenti=klijenti;
		initialize();
		dodajPodatke();
	}
	
	public void initialize()
	{
		setBorder(BorderFactory.createTitledBorder("Kreiraj zahtjev"));
		
		JLabel lblNazivFirme = new JLabel("Naziv firme:");
		lblNazivFirme.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIbfu = new JLabel("IBFU:");
		lblIbfu.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHitnost = new JLabel("Hitnost:");
		lblHitnost.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbHitnost = new JComboBox();
		cbHitnost.setBackground(Color.WHITE);
		
		JLabel lblRok = new JLabel("Rok:");
		lblRok.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnKreirajZahtjev = new JButton("Kreiraj zahtjev");
		btnKreirajZahtjev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					kreirajZahtjev((Uredjaj)cbIBFU.getSelectedItem(), (Hitnost)cbHitnost.getSelectedItem(),new Date(dateChooser.getDate().getTime()));
					JOptionPane.showMessageDialog(null, "Zahtjev uspješno kreiran !");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		
		cbNazivFirme = new JComboBox();
		cbNazivFirme.setBackground(Color.WHITE);
		cbNazivFirme.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
					if(cbNazivFirme.getSelectedIndex()!=-1 && arg0.getStateChange()==ItemEvent.SELECTED){
						cbIBFU.removeAllItems();
						Klijent k=(Klijent)cbNazivFirme.getItemAt(cbNazivFirme.getSelectedIndex());
						for(Uredjaj u:k.getUredjaji())
						{
							cbIBFU.addItem(u);
						}
						
					}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		});
		
		cbIBFU = new JComboBox();
		cbIBFU.setBackground(Color.WHITE);
		
		dateChooser = new JDateChooser();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNazivFirme, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cbNazivFirme, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblIbfu, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cbIBFU, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblHitnost, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cbHitnost, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblRok, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(319, Short.MAX_VALUE)
					.addComponent(btnKreirajZahtjev, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNazivFirme))
						.addComponent(cbNazivFirme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblIbfu))
						.addComponent(cbIBFU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblHitnost))
						.addComponent(cbHitnost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRok))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnKreirajZahtjev))
		);
		setLayout(groupLayout);
	}
	
	public void dodajPodatke(){
		if(klijenti.size()!=0)
		{
			for(Klijent k:klijenti)
			{
				cbNazivFirme.addItem(k);
			}
			
			cbHitnost.addItem(Hitnost.NISKA);
			cbHitnost.addItem(Hitnost.SREDNJA);
			cbHitnost.addItem(Hitnost.VELIKA);
		}
	}
	
	public void kreirajZahtjev(Uredjaj u,Hitnost h,Date d) throws GeneralniException
	{
		Zahtjev z=new Zahtjev();
		z.setHitnost(h);
		z.setUredjaj(u);
		z.setRok(d);
		z.setZahtjevPodnesen(new Date(new java.util.Date().getTime()));
		new HibernateZahtjev().dodajZahtjev(z);
	}
}
