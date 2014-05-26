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
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_2 = new JLabel("Tip ure\u0111aja:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_3 = new JLabel("Naziv firme:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_4 = new JLabel("IBFU:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_5 = new JLabel("Hitnost:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tTip = new JTextField();
		tTip.setBackground(Color.WHITE);
		tTip.setEditable(false);
		tTip.setColumns(10);
		
		tIbfu = new JTextField();
		tIbfu.setBackground(Color.WHITE);
		tIbfu.setEditable(false);
		tIbfu.setColumns(10);
		
		tNaziv = new JTextField();
		tNaziv.setBackground(Color.WHITE);
		tNaziv.setEditable(false);
		tNaziv.setColumns(10);
		
		tTelefon = new JTextField();
		tTelefon.setBackground(Color.WHITE);
		tTelefon.setEditable(false);
		tTelefon.setColumns(10);
		
		JLabel lblZahtjevPodnesen = new JLabel("Zahtjev podne\u0161en:");
		lblZahtjevPodnesen.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tPodensen = new JTextField();
		tPodensen.setBackground(Color.WHITE);
		tPodensen.setEditable(false);
		tPodensen.setColumns(10);
		
		JLabel lblRokDo = new JLabel("Rok do:");
		lblRokDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tRok = new JTextField();
		tRok.setBackground(Color.WHITE);
		tRok.setEditable(false);
		tRok.setColumns(10);
		
		tPokupiti = new JTextField();
		tPokupiti.setBackground(Color.WHITE);
		tPokupiti.setEditable(false);
		tPokupiti.setColumns(10);
		
		JLabel lblPokupitiDo = new JLabel("Pokupiti do:");
		lblPokupitiDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tHitnost = new JTextField();
		tHitnost.setBackground(Color.WHITE);
		tHitnost.setEditable(false);
		tHitnost.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tNaziv, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tTelefon, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tIbfu, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tHitnost, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblZahtjevPodnesen, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tPodensen, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblRokDo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tRok, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblPokupitiDo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tPokupiti, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(tTelefon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(tIbfu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(tTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tHitnost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tPodensen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblZahtjevPodnesen))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRokDo))
						.addComponent(tRok, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPokupitiDo))
						.addComponent(tPokupiti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
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
