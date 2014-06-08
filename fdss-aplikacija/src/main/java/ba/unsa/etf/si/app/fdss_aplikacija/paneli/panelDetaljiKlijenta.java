package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Validacija;

public class panelDetaljiKlijenta extends JPanel {
	private JTextField tJib;
	private JTextField tAdresa;
	private JTextField tWeb;
	private JTextField tEmail;
	private JTextField tGrad;
	private JTextField tTip;
	private JTable table;
	DefaultTableModel model;
	JComboBox cbNaziv;
	/**
	 * Create the panel.
	 */
	public panelDetaljiKlijenta() {
		
		setBorder(BorderFactory.createTitledBorder("Detalji klijenta"));
				
		tJib = new JTextField();
		tJib.setBackground(Color.WHITE);
		tJib.setEditable(false);
		tJib.setColumns(10);
		
		JLabel lblNazivKlijenta = new JLabel("JIB klijenta:");
		lblNazivKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblGrad = new JLabel("Mjesto:");
		lblGrad.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAdresaKlijenta = new JLabel("Adresa klijenta:");
		lblAdresaKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJibKlijenta = new JLabel("Naziv:");
		lblJibKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tAdresa = new JTextField();
		tAdresa.setColumns(10);
		
		tWeb = new JTextField();
		tWeb.setColumns(10);
		
		tEmail = new JTextField();
		tEmail.setColumns(10);
		
		tGrad = new JTextField();
		tGrad.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JLabel label = new JLabel("Tip:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tTip = new JTextField();
		tTip.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		
		JScrollPane scrollPane = new JScrollPane();
		
		cbNaziv = new JComboBox();
		cbNaziv.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJibKlijenta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbNaziv, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblWeb, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tEmail, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(tWeb, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNazivKlijenta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tJib))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(10)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblAdresaKlijenta, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblGrad, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(tTip)
									.addComponent(tAdresa, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
									.addComponent(tGrad, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJibKlijenta)
						.addComponent(cbNaziv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tJib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNazivKlijenta))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresaKlijenta)
						.addComponent(tAdresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tGrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGrad))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeb)
						.addComponent(tWeb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(8))
		);
		
		table = new JTable();
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"JIB proizvo\u0111a\u010Da", "Tip ure\u0111aja", "IBFU", "IBFM"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(model);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		cbNaziv.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
					if(cbNaziv.getSelectedIndex()!=-1 && arg0.getStateChange()==ItemEvent.SELECTED){
						cbUpisiPodatke((Klijent)cbNaziv.getSelectedItem());
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
		List<Klijent> klijenti=new HibernateKlijent().dajSveKlijente();
		if(klijenti.size()>0)
		{
			for(Klijent k:klijenti)
			{
				cbNaziv.addItem(k);
			}
		}
	}
	
	private void cbUpisiPodatke(Klijent k)
	{
		tAdresa.setText(k.getAdresa());
		tEmail.setText(k.getEmail());
		tGrad.setText(k.getMjesto());
		tJib.setText(k.getJib());
		tTip.setText(k.getTip());
		tWeb.setText(k.getWeb());
		
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount() - 1; i > -1; i--) {
		        model.removeRow(i);
		    }
		}
		
		if(k.getUredjaji().size()>0)
		{
			//"JIB proizvo\u0111a\u010Da", "Tip ure\u0111aja", "IBFU", "IBFM"
			for(Uredjaj u:k.getUredjaji())
			{
				model.addRow(new Object[]{u.getJibProizvodaca(),u.getTipUredaja(),u.getIbfu(),u.getIbfm()});
			}
		}
		
	}
}
