package ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;

import javax.swing.UIManager;
import java.awt.Color;


public class frmDetaljnijeZadatakServiser extends JFrame {

	private JPanel contentPane;
	private JTextField tTip;
	private JTextField tIbfu;
	private JTextField tNaziv;
	private JTextField tTelefon;
	private JTextField tPodensen;
	private JTextField tRok;
	private JTextField tPokupiti;
	private JTextField tHitnost;

	/**
	 * Launch the application.
	 */
		/**
	 * Create the frame.
	 */
	Zadatak zadatak;
	public frmDetaljnijeZadatakServiser(Zadatak zadatak) {
		setResizable(false);
		this.zadatak=zadatak;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Pregled zadatka");
		setBounds(100, 100, 403, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 5, 363, 259);
		panel.setBorder(BorderFactory.createTitledBorder("Podaci o zadataku"));
		
		JLabel label = new JLabel("Br. telefona:");
		label.setBounds(52, 56, 73, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("Tip ure\u0111aja:");
		label_2.setBounds(52, 108, 73, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Naziv firme:");
		label_3.setBounds(52, 30, 73, 14);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_4 = new JLabel("IBFU:");
		label_4.setBounds(52, 82, 73, 14);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_5 = new JLabel("Hitnost:");
		label_5.setBounds(52, 134, 73, 14);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tTip = new JTextField();
		tTip.setBounds(129, 105, 139, 20);
		tTip.setBackground(Color.WHITE);
		tTip.setEditable(false);
		tTip.setColumns(10);
		
		tIbfu = new JTextField();
		tIbfu.setBounds(129, 79, 139, 20);
		tIbfu.setBackground(Color.WHITE);
		tIbfu.setEditable(false);
		tIbfu.setColumns(10);
		
		tNaziv = new JTextField();
		tNaziv.setBounds(129, 27, 200, 20);
		tNaziv.setBackground(Color.WHITE);
		tNaziv.setEditable(false);
		tNaziv.setColumns(10);
		
		tTelefon = new JTextField();
		tTelefon.setBounds(129, 53, 139, 20);
		tTelefon.setBackground(Color.WHITE);
		tTelefon.setEditable(false);
		tTelefon.setColumns(10);
		
		JLabel lblZahtjevPodnesen = new JLabel("Zahtjev podne\u0161en:");
		lblZahtjevPodnesen.setBounds(16, 160, 109, 14);
		lblZahtjevPodnesen.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tPodensen = new JTextField();
		tPodensen.setBounds(129, 157, 139, 20);
		tPodensen.setBackground(Color.WHITE);
		tPodensen.setEditable(false);
		tPodensen.setColumns(10);
		
		JLabel lblRokDo = new JLabel("Rok do:");
		lblRokDo.setBounds(16, 186, 109, 14);
		lblRokDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tRok = new JTextField();
		tRok.setBounds(129, 183, 139, 20);
		tRok.setBackground(Color.WHITE);
		tRok.setEditable(false);
		tRok.setColumns(10);
		
		tPokupiti = new JTextField();
		tPokupiti.setBounds(129, 208, 139, 20);
		tPokupiti.setBackground(Color.WHITE);
		tPokupiti.setEditable(false);
		tPokupiti.setColumns(10);
		
		JLabel lblPokupitiDo = new JLabel("Pokupiti do:");
		lblPokupitiDo.setBounds(16, 211, 109, 14);
		lblPokupitiDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tHitnost = new JTextField();
		tHitnost.setBounds(129, 131, 139, 20);
		tHitnost.setBackground(Color.WHITE);
		tHitnost.setEditable(false);
		tHitnost.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(label_3);
		panel.add(tNaziv);
		panel.add(label);
		panel.add(tTelefon);
		panel.add(label_4);
		panel.add(tIbfu);
		panel.add(label_2);
		panel.add(tTip);
		panel.add(label_5);
		panel.add(tHitnost);
		panel.add(lblZahtjevPodnesen);
		panel.add(tPodensen);
		panel.add(lblRokDo);
		panel.add(tRok);
		panel.add(lblPokupitiDo);
		panel.add(tPokupiti);
		upisiPodatke();
	}
	
	private void upisiPodatke()
	{
		SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
		java.util.Date datum;
		tHitnost.setText(zadatak.getHitnost());
		tIbfu.setText(zadatak.getZahtjev().getUredjaj().getIbfu());
		tNaziv.setText(zadatak.getZahtjev().getUredjaj().getKlijent().toString());
		datum=new Date(zadatak.getZahtjevPodnesen().getTime());
		tPodensen.setText(format.format(datum));
		datum=new Date(zadatak.getDonijetiUredjajDo().getTime());
		tPokupiti.setText(format.format(datum));
		datum=new Date(zadatak.getZavrsitiDo().getTime());
		tRok.setText(format.format(datum));
		tTelefon.setText(zadatak.getZahtjev().getUredjaj().getKlijent().getTelefon());
		tTip.setText(zadatak.getZahtjev().getUredjaj().getTipUredaja());
	}
}
