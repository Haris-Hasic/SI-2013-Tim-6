package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

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

public class frmIzmjenaUredjaja extends JDialog {

	private JPanel contentPane;
	private JTextField tJIBKlijenta;
	private JTextField tJIBProizvodzaca;
	private JTextField tIFBU;
	private JTextField tIFBM;
	private JTextField tTip;
	JComboBox cbKlijent;
	Uredjaj uredjaj;
	DefaultTableModel model;

	
	public frmIzmjenaUredjaja(DefaultTableModel defaultTableModel,String ibfu) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);//promjeniti konstruktor u frmIzmjenaUredjaja(uredjaj u)
																				//i na osnovu toka popuniti tb
		
		model=defaultTableModel;
		uredjaj=new HibernateUredjaj().dajUredjaj(ibfu);
		
		setTitle("Izmjena ure\u0111aja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 405, 230);
		
		JLabel label = new JLabel("Tip ure\u0111aja:");
		label.setBounds(36, 126, 87, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("IBFU:");
		label_1.setBounds(36, 163, 87, 14);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("JIB proizvo\u0111a\u010Da:");
		label_2.setBounds(16, 91, 107, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("IBFM:");
		label_3.setBounds(36, 200, 87, 14);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJibKlijenta = new JLabel("JIB klijenta:");
		lblJibKlijenta.setBounds(30, 60, 95, 14);
		lblJibKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tJIBKlijenta = new JTextField();
		tJIBKlijenta.setEditable(false);
		tJIBKlijenta.setBounds(129, 57, 194, 20);
		tJIBKlijenta.setColumns(10);
		
		tJIBProizvodzaca = new JTextField();
		tJIBProizvodzaca.setBounds(127, 88, 194, 20);
		tJIBProizvodzaca.setColumns(10);
		
		tIFBU = new JTextField();
		tIFBU.setBounds(127, 160, 121, 20);
		tIFBU.setColumns(10);
		
		tIFBM = new JTextField();
		tIFBM.setBounds(127, 197, 121, 20);
		tIFBM.setColumns(10);
		
		tTip = new JTextField();
		tTip.setBounds(127, 123, 194, 20);
		tTip.setColumns(10);
		panel.setBorder(BorderFactory.createTitledBorder("Podaci o ure\u0111aju:"));
		
		JButton btnStasiIzmjene = new JButton("Spasi izmjene");
		btnStasiIzmjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					boolean promjena=false;
					if(!(uredjaj.getIbfm().equals(tIFBM.getText())))
					{
						uredjaj.setIbfm(tIFBM.getText());
						promjena=true;
					}
					if(!(uredjaj.getIbfu().equals(tIFBU.getText())))
					{
						if(new HibernateUredjaj().postojiUredjaj(tIFBU.getText()))
						{
							throw new GeneralniException("Uređaj sa istim IFBU je već unesen.");
						}
						else
						{
							uredjaj.setIbfu(tIFBU.getText());
							promjena=true;
						}
					}
					if(!(uredjaj.getJibProizvodaca().equals(tJIBProizvodzaca.getText())))
					{
						uredjaj.setJibProizvodaca(tJIBProizvodzaca.getText());
						promjena=true;
					}
					if(!(uredjaj.getTipUredaja().equals(tTip.getText())))
					{
						uredjaj.setTipUredaja(tTip.getText());
						promjena=true;
					}
					if(!(uredjaj.getKlijent().getJib().equals(((Klijent)cbKlijent.getSelectedItem()).getJib())))
					{
						uredjaj.setKlijent((Klijent)cbKlijent.getSelectedItem());
						promjena=true;
					}
					
					if(promjena)
					{
						new HibernateUredjaj().updateUredjaj(uredjaj);
						popuniTabeluUFormi();
						new Validacija().poruka("Promjene spasene!");
						dispose();
					}
					else{
						new Validacija().poruka("Promjene nisu napravljene!");
						dispose();
					}
				}catch(GeneralniException e)
				{
					new Validacija().poruka(e.getMessage());
				}
			}
		});
		btnStasiIzmjene.setBounds(297, 252, 118, 23);
		contentPane.setLayout(null);
		
		JButton btnIzbriiUreaj = new JButton("Izbri\u0161i ure\u0111aj");
		btnIzbriiUreaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int reply = JOptionPane.showConfirmDialog(null, "Podaci će biti trajno obrisani. Da li želite nastaviti?", "Upozorenje", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			        	izbisiPodatkeZaUredjaj();
			        	new HibernateUredjaj().brisiUredjaj(uredjaj);
						popuniTabeluUFormi();
						new Validacija().poruka("Uređaj obrisan.");
						dispose();
			        	
			        }
				}catch(Exception e)
				{
					new Validacija().poruka("Brisanje trenutno nije moguće. Razlog: "+e.getMessage());
				}
			}
		});
		btnIzbriiUreaj.setBounds(171, 252, 116, 23);
		contentPane.add(btnIzbriiUreaj);
		contentPane.add(btnStasiIzmjene);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblJibKlijenta);
		panel.add(tJIBKlijenta);
		panel.add(label_2);
		panel.add(tJIBProizvodzaca);
		panel.add(label_3);
		panel.add(label_1);
		panel.add(label);
		panel.add(tIFBU);
		panel.add(tTip);
		panel.add(tIFBM);
		
		cbKlijent = new JComboBox();
		cbKlijent.setBounds(129, 26, 194, 20);
		panel.add(cbKlijent);
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKlijent.setBounds(30, 29, 95, 14);
		panel.add(lblKlijent);
		
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
	
	private void upisiPodatke()
	{
		List<Klijent> klijenti=new HibernateKlijent().dajSveKlijente();
		for(Klijent klijent:klijenti)
		{
			cbKlijent.addItem(klijent);
		}
		cbKlijent.setSelectedItem(uredjaj.getKlijent());
		tIFBM.setText(uredjaj.getIbfm());
		tIFBU.setText(uredjaj.getIbfu());
		tJIBProizvodzaca.setText(uredjaj.getJibProizvodaca());
		tTip.setText(uredjaj.getTipUredaja());
	}
	
	private void popuniTabeluUFormi()
	{
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount() - 1; i > -1; i--) {
		        model.removeRow(i);
		    }
		}
		
		List<Uredjaj> uredjaji=new HibernateUredjaj().dajSveUredjaje();
		
		if(uredjaji.size()>0)
		{
			for(Uredjaj uredjaj:uredjaji)
			{
				String klijent=uredjaj.getKlijent().getNaziv()+" "+uredjaj.getKlijent().getJib();
				String jibPro=uredjaj.getJibProizvodaca();
				String tip=uredjaj.getTipUredaja();
				String ibfu=uredjaj.getIbfu();
				String ibfm=uredjaj.getIbfm();
				
				model.addRow(new Object[]{klijent,jibPro,tip,ibfu,ibfm});
			}
		}
	}
	
	private void izbisiPodatkeZaUredjaj()
	{
		List<Zadatak> _zadaci=new HibernateZadatak().dajSveZadatke();
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
		
		List<Zahtjev> zahtjevi=new HibernateZahtjev().dajSveZahtjeve();
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
	}
}
