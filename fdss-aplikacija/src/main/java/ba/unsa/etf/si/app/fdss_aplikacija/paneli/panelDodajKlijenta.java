package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.JSeparator;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelDodajKlijenta extends JPanel {
	private JTextField naziv_tb;
	private JTextField tip_tb;
	private JTextField jib_tb;
	private JTextField adresa_tb;
	private JTextField mjesto_tb;
	private JTextField telefon_tb;
	private JTextField email_tb;
	private JTextField web_tb;
	private HibernateKlijent hk;
	/**
	 * Create the panel.
	 */
	public panelDodajKlijenta() {
		
		setBorder(BorderFactory.createTitledBorder("Dodaj klijenta:"));
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJib = new JLabel("JIB :");
		lblJib.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTip = new JLabel("Tip :");
		lblTip.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAdresa = new JLabel("Adresa :");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel = new JLabel("Mjesto :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblWeb = new JLabel("Web :");
		lblWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		
		naziv_tb = new JTextField();
		naziv_tb.setColumns(10);
		
		tip_tb = new JTextField();
		tip_tb.setColumns(10);
		
		jib_tb = new JTextField();
		jib_tb.setColumns(10);
		
		adresa_tb = new JTextField();
		adresa_tb.setColumns(10);
		
		mjesto_tb = new JTextField();
		mjesto_tb.setColumns(10);
		
		telefon_tb = new JTextField();
		telefon_tb.setColumns(10);
		
		email_tb = new JTextField();
		email_tb.setColumns(10);
		
		web_tb = new JTextField();
		web_tb.setColumns(10);
		
		JButton btnDodajKlijenta = new JButton("Dodaj klijenta");
		btnDodajKlijenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(! new HibernateKlijent().postojiKlijent(jib_tb.getText()))
				{
					try {
						
						Klijent k = new Klijent();
						pokupiPodatke(k);
						
						hk = new HibernateKlijent();
						
						if(!hk.postojiKlijent(k.getJib())) {
							
							hk.dodajKlijenta(k);
							ocistiPoljaZaUnos();
							JOptionPane.showMessageDialog(null, "Klijent " + k.getNaziv() + " uspješno unesen !");
						}
						
						else
							throw new GeneralniException("Korisnik sa datim JIB je već unesen u bazu !");
					}
					
					catch(GeneralniException ge) {
						
						JOptionPane.showMessageDialog(null, ge.getMessage());
					}
				}else
				{
					new Validacija().poruka("Klijent sa istim JIB je već unesen");
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
								.addComponent(btnDodajKlijenta, Alignment.TRAILING)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(11)
										.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblTip, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNaziv, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblWeb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresa, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblJib, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tip_tb, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(jib_tb, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(adresa_tb, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(naziv_tb, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
								.addComponent(mjesto_tb)
								.addComponent(telefon_tb)
								.addComponent(email_tb)
								.addComponent(web_tb))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNaziv)
						.addComponent(naziv_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tip_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTip))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jib_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJib))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(adresa_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdresa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mjesto_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(telefon_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(email_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(web_tb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeb))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDodajKlijenta, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
//		TitledBorder border=(TitledBorder)getBorder();
//		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
	}
	
	private void pokupiPodatke(Klijent k) throws GeneralniException {
		
		k.setNaziv(naziv_tb.getText());
		k.setTip(tip_tb.getText());
		k.setJib(jib_tb.getText());
		k.setAdresa(adresa_tb.getText());
		k.setMjesto(mjesto_tb.getText());
		k.setTelefon(telefon_tb.getText());
		k.setEmail(email_tb.getText());
		k.setWeb(web_tb.getText());

	}
	
	private void ocistiPoljaZaUnos() {
		
		naziv_tb.setText("");
		tip_tb.setText("");
		jib_tb.setText("");
		adresa_tb.setText("");
		mjesto_tb.setText("");
		telefon_tb.setText("");
		email_tb.setText("");
		web_tb.setText("");
	}
}
