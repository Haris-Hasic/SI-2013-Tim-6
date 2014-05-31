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

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmIzmjenaUredjaja;

import javax.swing.JComboBox;

import java.awt.Color;
import java.util.List;

public class panelDetaljiUredjaja extends JPanel {
	private JTextField tJIBProizvodzaca;
	private JTextField tNaziv;
	private JTextField tIfbm;
	private JTextField jTipUredjaja;
	private JTextField tJib;
	private JTextField tAdresa;
	private JTextField tWeb;
	private JTextField tEmail;
	private JTextField tMjesto;
	JComboBox cbIfbu;
	/**
	 * Create the panel.
	 */
	public panelDetaljiUredjaja() {
		
		setBorder(BorderFactory.createTitledBorder("Detalji ure\u0111aja:"));
		
		
		JLabel lblJibKorisnika = new JLabel("IBFU:");
		lblJibKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJibProizvoaa = new JLabel("JIB proizvo\u0111a\u010Da:");
		lblJibProizvoaa.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tJIBProizvodzaca = new JTextField();
		tJIBProizvodzaca.setColumns(10);
		
		tNaziv = new JTextField();
		tNaziv.setColumns(10);
		
		JLabel lblNazivKlijenta = new JLabel("Naziv klijenta:");
		lblNazivKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIbfm = new JLabel("IBFM:");
		lblIbfm.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tIfbm = new JTextField();
		tIfbm.setColumns(10);
		
		jTipUredjaja = new JTextField();
		jTipUredjaja.setColumns(10);
		
		JLabel label_2 = new JLabel("Tip ure\u0111aja:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblGrad = new JLabel("Mjesto:");
		lblGrad.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAdresaKlijenta = new JLabel("Adresa klijenta:");
		lblAdresaKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJibKlijenta = new JLabel("JIB Klijenta:");
		lblJibKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tJib = new JTextField();
		tJib.setColumns(10);
		
		tAdresa = new JTextField();
		tAdresa.setColumns(10);
		
		tWeb = new JTextField();
		tWeb.setColumns(10);
		
		tEmail = new JTextField();
		tEmail.setColumns(10);
		
		tMjesto = new JTextField();
		tMjesto.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		cbIfbu = new JComboBox();
		cbIfbu.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblIbfm, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblJibKorisnika, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblJibProizvoaa, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cbIfbu, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(tIfbm, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addComponent(jTipUredjaja, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
									.addComponent(tJIBProizvodzaca))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWeb, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGrad, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblJibKlijenta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNazivKlijenta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresaKlijenta, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tEmail, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(tJib, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(tAdresa, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(tMjesto, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(tWeb, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(tNaziv)))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJibKorisnika)
						.addComponent(cbIfbu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tJIBProizvodzaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJibProizvoaa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTipUredjaja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tIfbm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIbfm))
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNazivKlijenta))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJibKlijenta)
						.addComponent(tJib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresaKlijenta)
						.addComponent(tAdresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrad)
						.addComponent(tMjesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeb)
						.addComponent(tWeb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(tEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		cbIfbu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
					if(cbIfbu.getSelectedIndex()!=-1 && arg0.getStateChange()==ItemEvent.SELECTED){
						Uredjaj uredjaj=(Uredjaj)cbIfbu.getSelectedItem();
						
						tAdresa.setText(uredjaj.getKlijent().getAdresa());
						tEmail.setText(uredjaj.getKlijent().getEmail());
						tIfbm.setText(uredjaj.getIbfm());
						jTipUredjaja.setText(uredjaj.getTipUredaja());
						tJib.setText(uredjaj.getKlijent().getJib());
						tJIBProizvodzaca.setText(uredjaj.getJibProizvodaca());
						tMjesto.setText(uredjaj.getKlijent().getMjesto());
						tNaziv.setText(uredjaj.getKlijent().getNaziv());
						tWeb.setText(uredjaj.getKlijent().getWeb());
					}
				}catch(Exception e)
				{
					new Validacija().poruka(e.getMessage());
				}
			}
		});
		
	upisiPodatke();
	}
	
	private void upisiPodatke() {
		List<Uredjaj> uredjaji=new HibernateUredjaj().dajSveUredjaje();
		if(uredjaji.size()>0)
		{
			for(Uredjaj uredjaj:uredjaji)
			{
				cbIfbu.addItem(uredjaj);
			}
		}
		
	}
}
