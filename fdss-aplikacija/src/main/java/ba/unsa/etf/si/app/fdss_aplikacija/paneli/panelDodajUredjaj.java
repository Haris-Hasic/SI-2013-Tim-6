package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JSeparator;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmIzmjenaUredjaja;

import javax.swing.JComboBox;

import java.awt.Color;
import java.util.List;

public class panelDodajUredjaj extends JPanel {
	private JTextField tJIBProzivodzaca;
	private JTextField tIBFM;
	private JTextField tIbfu;
	private JTextField tTipUredjaja;
	private JTextField tJIBKlijenta;
	JComboBox cbKlijent;
	
	/**
	 * Create the panel.
	 */
	public panelDodajUredjaj() {
		
		setBorder(BorderFactory.createTitledBorder("Novi ure\u0111aj:"));
		
		
		JLabel lblJibKorisnika = new JLabel("Klijent:");
		lblJibKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJibProizvoaa = new JLabel("JIB proizvo\u0111a\u010Da:");
		lblJibProizvoaa.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tJIBProzivodzaca = new JTextField();
		tJIBProzivodzaca.setColumns(10);
		
		JButton btnDodajUredjaj = new JButton("Dodaj ure\u0111aj");
		btnDodajUredjaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new HibernateUredjaj().postojiUredjaj(tIbfu.getText()))
				{
					new Validacija().poruka("Uređaj sa istim IFBU je već unesen.");
				}
				else{
					try
					{
						if(cbKlijent.getSelectedIndex()>=0)
						{
							Uredjaj u=new Uredjaj();
							kreirajUredjaj(u);
							new HibernateUredjaj().dodajUredjaj(u);
							ocistiPolja();
							new Validacija().poruka("Uređaj dodan!");
						}else
						{
							new Validacija().poruka("Nepostojeći klijent!");
						}
					}catch(GeneralniException gen)
					{
						new Validacija().poruka(gen.getMessage());
					}
				}
				
			}
		});
		
		tIBFM = new JTextField();
		tIBFM.setColumns(10);
		
		JLabel label = new JLabel("IBFM:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("IBFU:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tIbfu = new JTextField();
		tIbfu.setColumns(10);
		
		tTipUredjaja = new JTextField();
		tTipUredjaja.setColumns(10);
		
		JLabel label_2 = new JLabel("Tip ure\u0111aja:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSeparator separator_1 = new JSeparator();
		
		cbKlijent = new JComboBox();
		cbKlijent.setBackground(Color.WHITE);
		
		JLabel lblJibKlijenta = new JLabel("JIB klijenta:");
		lblJibKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tJIBKlijenta = new JTextField();
		tJIBKlijenta.setEditable(false);
		tJIBKlijenta.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblJibKorisnika, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cbKlijent, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblJibKlijenta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tJIBKlijenta, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblJibProizvoaa, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tJIBProzivodzaca, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tTipUredjaja, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tIbfu, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tIBFM, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(333, Short.MAX_VALUE)
					.addComponent(btnDodajUredjaj)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblJibKorisnika))
						.addComponent(cbKlijent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblJibKlijenta))
						.addComponent(tJIBKlijenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblJibProizvoaa))
						.addComponent(tJIBProzivodzaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(tTipUredjaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(tIbfu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(tIBFM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDodajUredjaj))
		);
		setLayout(groupLayout);
		
		cbKlijent.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
					if(cbKlijent.getSelectedIndex()!=-1 && arg0.getStateChange()==ItemEvent.SELECTED){
						Klijent k=(Klijent)cbKlijent.getSelectedItem();
						tJIBKlijenta.setText(k.getJib());	
					}
				}catch(Exception e)
				{
					
				}
			}
		});
		
		upisiPodatke();
	}
	
	private void upisiPodatke() {
		List<Klijent> _klijenti=new HibernateKlijent().dajSveKlijente();
		if(_klijenti.size()>=0)
		{
			for(Klijent k:_klijenti)
			{
				cbKlijent.addItem(k);
			}
		}
		
	}
	
	private void kreirajUredjaj(Uredjaj uredjaj) throws GeneralniException
	{
		uredjaj.setIbfm(tIBFM.getText());
		uredjaj.setIbfu(tIbfu.getText());
		uredjaj.setJibProizvodaca(tJIBProzivodzaca.getText());
		uredjaj.setKlijent((Klijent)cbKlijent.getSelectedItem());
		uredjaj.setTipUredaja(tTipUredjaja.getText());
	}
	
	private void ocistiPolja()
	{
		tIBFM.setText("");
		tIbfu.setText("");
		tJIBProzivodzaca.setText("");
		tTipUredjaja.setText("");
		
	}
}
