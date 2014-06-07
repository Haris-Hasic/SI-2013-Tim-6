package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import org.hibernate.cfg.annotations.reflection.XMLContext.Default;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Hitnost;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.PrivilegijaUposlenika;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;
import ba.unsa.etf.si.app.fdss_aplikacija.paneli.panelObradiZahtjev;

import com.toedter.calendar.JDateChooser;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

public class frmKreirajZadatak extends JDialog {

	private JPanel contentPane;
	private JTextField tTipUredjaja;
	private JTextField tIFBU;
	private JTextField tNaziv;
	private JTextField tTelefon;
	private JTextField tTip;
	private JTextField tZahtjevPodnesen;
	JComboBox cbHitnost;
	JComboBox cbServiser;
	JDateChooser dcRok;
	JDateChooser dcPokupitiDo;
	
	DefaultTableModel model;
	Zahtjev zahtjev;
	int redniBroj;
	public frmKreirajZadatak(DefaultTableModel model,int redniBroj) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		this.model=model;
		this.zahtjev=zahtjev;
		this.redniBroj=redniBroj;
		int  brojZahtjeva=Integer.valueOf(model.getValueAt(redniBroj, 1).toString());
		 zahtjev=new HibernateZahtjev().dajZahtjev(brojZahtjeva);
		
		initialize();
		popuniPodatke();
		
	}
	private void popuniPodatke()
	{
		
			List<Uposlenik> temp=new HibernateUposlenik().dajSveUposlenike();
			for(int i=0;i<temp.size();i++)
			{
				Uposlenik u=(Uposlenik)temp.get(i);
				if(u.getPrivilegija()==PrivilegijaUposlenika.SERVISER) cbServiser.addItem(u);
			}

		tNaziv.setText(zahtjev.getUredjaj().getKlijent().getNaziv());
		tTip.setText(zahtjev.getUredjaj().getKlijent().getTip());
		tTipUredjaja.setText(zahtjev.getUredjaj().getTipUredaja());
		tTelefon.setText(zahtjev.getUredjaj().getKlijent().getTelefon());
		tIFBU.setText(zahtjev.getUredjaj().getIbfu());
		
		Date datumSQL=zahtjev.getZahtjevPodnesen();
		java.util.Date datum=new java.util.Date(datumSQL.getTime());
	
		SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
		tZahtjevPodnesen.setText(format.format(datum));
		
		cbHitnost.addItem(Hitnost.NISKA);
		cbHitnost.addItem(Hitnost.SREDNJA);
		cbHitnost.addItem(Hitnost.VELIKA);
		cbHitnost.setSelectedItem(zahtjev.getHitnost());
		
		datumSQL=zahtjev.getRok();
		datum=new java.util.Date(datumSQL.getTime());
		dcRok.setDate(datum);
		
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Kreiranje zadatka");
		setBounds(100, 100, 508, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 5, 477, 360);
		panel.setBorder(BorderFactory.createTitledBorder("Podaci o zadataku"));
		
		JLabel label = new JLabel("Br. telefona:");
		label.setBounds(52, 92, 73, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("Tip ure\u0111aja:");
		label_2.setBounds(52, 157, 73, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Naziv firme:");
		label_3.setBounds(52, 30, 73, 14);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_4 = new JLabel("IBFU:");
		label_4.setBounds(52, 126, 73, 14);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_5 = new JLabel("Hitnost:");
		label_5.setBounds(52, 188, 73, 14);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tTipUredjaja = new JTextField();
		tTipUredjaja.setBackground(UIManager.getColor("Button.background"));
		tTipUredjaja.setBounds(129, 154, 139, 20);
		tTipUredjaja.setColumns(10);
		
		tIFBU = new JTextField();
		tIFBU.setBackground(UIManager.getColor("Button.background"));
		tIFBU.setBounds(129, 123, 139, 20);
		tIFBU.setColumns(10);
		
		tNaziv = new JTextField();
		tNaziv.setBackground(UIManager.getColor("Button.background"));
		tNaziv.setBounds(129, 27, 200, 20);
		tNaziv.setColumns(10);
		
		tTelefon = new JTextField();
		tTelefon.setBackground(UIManager.getColor("Button.background"));
		tTelefon.setBounds(129, 89, 139, 20);
		tTelefon.setColumns(10);
		
		cbHitnost = new JComboBox();
		cbHitnost.setBackground(Color.WHITE);
		cbHitnost.setBounds(129, 185, 139, 20);
		
		JLabel lblPoslovnica = new JLabel("Tip:");
		lblPoslovnica.setBounds(52, 61, 73, 14);
		lblPoslovnica.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tTip = new JTextField();
		tTip.setBackground(UIManager.getColor("Button.background"));
		tTip.setBounds(129, 58, 200, 20);
		tTip.setColumns(10);
		
		JLabel lblZahtjevPodnesen = new JLabel("Zahtjev podnesen:");
		lblZahtjevPodnesen.setBounds(16, 219, 109, 14);
		lblZahtjevPodnesen.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tZahtjevPodnesen = new JTextField();
		tZahtjevPodnesen.setBackground(UIManager.getColor("Button.background"));
		tZahtjevPodnesen.setBounds(129, 216, 139, 20);
		tZahtjevPodnesen.setColumns(10);
		
		JLabel lblRokDo = new JLabel("Rok do:");
		lblRokDo.setBounds(16, 250, 109, 14);
		lblRokDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblPokupitiDo = new JLabel("Pokupiti do:");
		lblPokupitiDo.setBounds(16, 281, 109, 14);
		lblPokupitiDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblServiser = new JLabel("Serviser:");
		lblServiser.setBounds(16, 312, 109, 14);
		lblServiser.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbServiser = new JComboBox();
		cbServiser.setBackground(Color.WHITE);
		cbServiser.setBounds(129, 309, 139, 20);
		contentPane.setLayout(null);
		
		JButton btnKreirajZadatak = new JButton("Kreiraj zadatak");
		btnKreirajZadatak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbServiser.getSelectedIndex()>=0)
				{
					try{
						Zadatak z=kreirajZadatak(new Date(dcPokupitiDo.getDate().getTime()),(Hitnost) cbHitnost.getSelectedItem(),(Uposlenik) cbServiser.getSelectedItem(), new Date(dcRok.getDate().getTime()));
						model.removeRow(redniBroj);
						new HibernateZadatak().dodajZadatak(z);
						zahtjev.setZavrsen(true);
						new HibernateZahtjev().updateZahtjev(zahtjev);
						zatvoriFormu();
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				}
				else
				{
					new Validacija().poruka("Serviser nije izabran");
				}
			}
		});
		btnKreirajZadatak.setBounds(355, 376, 137, 23);
		contentPane.add(btnKreirajZadatak);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(label_3);
		panel.add(tNaziv);
		panel.add(lblPoslovnica);
		panel.add(tTip);
		panel.add(label_5);
		panel.add(cbHitnost);
		panel.add(label_2);
		panel.add(tTipUredjaja);
		panel.add(label_4);
		panel.add(tIFBU);
		panel.add(label);
		panel.add(tTelefon);
		panel.add(lblZahtjevPodnesen);
		panel.add(lblServiser);
		panel.add(cbServiser);
		panel.add(lblPokupitiDo);
		panel.add(lblRokDo);
		panel.add(tZahtjevPodnesen);
		
		dcRok = new JDateChooser();
		dcRok.setBounds(129, 247, 139, 20);
		panel.add(dcRok);
				
		dcPokupitiDo = new JDateChooser();
		dcPokupitiDo.setBounds(129, 278, 139, 20);
		panel.add(dcPokupitiDo);
		
		dcPokupitiDo.setDate(new java.util.Date());
	
		
		
	}
	
	public Zadatak kreirajZadatak(Date donijetiUredjajDo,Hitnost hitnost,Uposlenik serviser,Date rok) throws Exception
	{
		try{
			Zadatak z=new Zadatak();
			z.setDonijetiUredjajDo(donijetiUredjajDo);
			z.setHitnost(hitnost.toString());
			z.setServiser(serviser);
			z.setZahtjev(zahtjev);
			z.setZahtjevPodnesen(zahtjev.getZahtjevPodnesen());
			z.setZavrsitiDo(rok);
			return z;
		}
		catch(Exception e)
		{
			throw new Exception();
		}
	}
	
	private void zatvoriFormu() {
		this.dispose();
		
	}
}
