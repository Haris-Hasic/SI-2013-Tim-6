package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.GeneralniException;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Dialog.ModalityType;

public class frmIzmjenaKlijenta extends JDialog {

	private JPanel contentPane;
	private JTextField tWeb;
	private JTextField tTip;
	private JTextField tJib;
	private JTextField tAdresa;
	private JTextField tMjesto;
	private JTextField tEmail;
	private JTextField tTelefon;
	private JTextField tNaziv;
	
	JButton btnNewButton;
	private DefaultTableModel model;
	private Klijent klijent;
	public frmIzmjenaKlijenta(DefaultTableModel model,String jib) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		this.model=model;
		klijent=new HibernateKlijent().dajKlijenta(jib);
		
		setResizable(false);
		setTitle("Izmjena klijenta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Izmjena klijenta:"));
		panel.setBounds(10, 11, 424, 277);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Telefon:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("Tip:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("Naziv:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_4 = new JLabel("Mjesto:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_5 = new JLabel("Web:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_6 = new JLabel("Adresa:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_7 = new JLabel("JIB:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tWeb = new JTextField();
		tWeb.setColumns(10);
		
		tTip = new JTextField();
		tTip.setColumns(10);
		
		tJib = new JTextField();
		tJib.setColumns(10);
		
		tAdresa = new JTextField();
		tAdresa.setColumns(10);
		
		tMjesto = new JTextField();
		tMjesto.setColumns(10);
		
		tEmail = new JTextField();
		tEmail.setColumns(10);
		
		tTelefon = new JTextField();
		tTelefon.setColumns(10);
		
		tNaziv = new JTextField();
		tNaziv.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tNaziv, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(tTip, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tJib, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tAdresa, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tMjesto, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tTelefon, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tEmail, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tWeb, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(tNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(tTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_7))
						.addComponent(tJib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_6))
						.addComponent(tAdresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(tMjesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(tTelefon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(tEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_5))
						.addComponent(tWeb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		btnNewButton = new JButton("Spasi izmjene");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					boolean promjena=false;
					if(!klijent.getAdresa().equals(tAdresa.getText()))
					{
						klijent.setAdresa(tAdresa.getText());promjena=true;
					}
					
					if(!klijent.getEmail().equals(tEmail.getText()))
					{
						klijent.setEmail(tEmail.getText());promjena=true;
					}
					
					if(!klijent.getJib().equals(tJib.getText()))
					{
						if(new HibernateKlijent().postojiKlijent(tJib.getText()))
						{
							throw new GeneralniException("Klijent sa istim JIB je već unesen");
						}
						klijent.setJib(tJib.getText());promjena=true;
					}
					if(!klijent.getMjesto().equals(tMjesto.getText()))
					{
						klijent.setMjesto(tMjesto.getText());promjena=true;
					}
					if(!klijent.getNaziv().equals(tNaziv.getText()))
					{
						klijent.setNaziv(tNaziv.getText());promjena=true;
					}
					if(!klijent.getTelefon().equals(tTelefon.getText()))
					{
						klijent.setTelefon(tTelefon.getText());promjena=true;
					}
					if(!klijent.getTip().equals(tTip.getText()))
					{
						klijent.setTip(tTip.getText());promjena=true;
					}
					if(!klijent.getWeb().equals(tWeb.getText()))
					{
						klijent.setWeb(tWeb.getText());promjena=true;
					}
					
					if(promjena)
					{
						new HibernateKlijent().updateKlijenta(klijent);
						popuniTabeluUFormi();
						new Validacija().poruka("Promjene spasene!");
						dispose();
					}
					else{
						new Validacija().poruka("Promjene nisu napravljene!");
						dispose();
					}
					
				}catch (GeneralniException ge)
				{
					new Validacija().poruka(ge.getMessage());
				}
				
				
			}
		});
		btnNewButton.setBounds(306, 299, 128, 23);
		contentPane.add(btnNewButton);
		
		JButton btnIzbrisiKijenta = new JButton("Izbri\u0161i kijenta");
		btnIzbrisiKijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Podaci će biti trajno obrisani. Da li želite nastaviti?", "Upozorenje", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) {
		        	izbisiPodatkeZaUredjaj();
		        	new HibernateKlijent().brisiKlijenta(klijent);
					popuniTabeluUFormi();
					new Validacija().poruka("Klijent obrisan.");
					dispose();
		        	
		        }
		        
			}
		});
		btnIzbrisiKijenta.setBounds(182, 299, 114, 23);
		contentPane.add(btnIzbrisiKijenta);
		upisiPodatke();
	}
	
	private void upisiPodatke()
	{
		tAdresa.setText(klijent.getAdresa());
		tEmail.setText(klijent.getEmail());
		tJib.setText(klijent.getJib());
		tMjesto.setText(klijent.getMjesto());
		tNaziv.setText(klijent.getNaziv());
		tTelefon.setText(klijent.getTelefon());
		tTip.setText(klijent.getTip());
		tWeb.setText(klijent.getWeb());
	}
	
	private void popuniTabeluUFormi()
	{
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount() - 1; i > -1; i--) {
		        model.removeRow(i);
		    }
		}
		
		List<Klijent> klijenti=new HibernateKlijent().dajSveKlijente();
		if(klijenti.size()>0)
		{
			//"Br.", "Naziv", "Tip", "JIB", "Adresa", "Mjesto", "Telefon", "Email", "Web"
			for(int i=0;i<klijenti.size();i++)
			{
				Klijent klijent=klijenti.get(i);
				
				String naziv=klijent.getNaziv();
				String tipString=klijent.getTip();
				String jib=klijent.getJib();
				String adresa=klijent.getAdresa();
				String mjesto=klijent.getMjesto();
				String telefon=klijent.getTelefon();
				String email=klijent.getEmail();
				String web=klijent.getWeb();
				
				model.addRow(new Object[]{String.valueOf(i+1),naziv,tipString,jib,adresa,mjesto,telefon,email,web});
			}
		}
		
	}
	
	private void izbisiPodatkeZaUredjaj()
	{
		List<Zadatak> _zadaci=new HibernateZadatak().dajSveZadatke();
		List<Zahtjev> zahtjevi=new HibernateZahtjev().dajSveNezavrseneZahtjeve();
		List<Uredjaj> uredjaji=klijent.getUredjaji();
		
		for(Uredjaj uredjaj:uredjaji)
		{
			if(_zadaci.size()>0)
			{
				for(Zadatak zadatak:_zadaci)
				{
					if(zadatak.getZahtjev().getUredjaj().getId()==uredjaj.getId())
					{
						new HibernateZadatak().brisiZadatak(zadatak);
						new HibernateZahtjev().brisiZahtjev(zadatak.getZahtjev());
					}
				}
			}
			
			
			if(zahtjevi.size()>0)
			{
				for(Zahtjev zahtjev:zahtjevi)
				{
					if(zahtjev.getUredjaj().getId()==uredjaj.getId())
					{
						new HibernateZahtjev().brisiZahtjev(zahtjev);
					}
				}
			}
			
			new HibernateUredjaj().brisiUredjaj(uredjaj);
		}
	}
}
