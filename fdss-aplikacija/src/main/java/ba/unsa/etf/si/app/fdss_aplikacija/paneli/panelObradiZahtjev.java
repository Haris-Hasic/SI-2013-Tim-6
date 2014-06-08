package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.Servis;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmKreirajZadatak;


public final class panelObradiZahtjev extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model;//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 panelObradiZahtjev ovajPanel;	 
	/**
	 * Create the panel.
	 */
	public panelObradiZahtjev() {
		initialize();
		popuniPodatke();
		ovajPanel=this;
	}
	public void popuniPodatke()
	{
		if (model.getRowCount() > 0) {
		    for (int i = model.getRowCount() - 1; i > -1; i--) {
		        model.removeRow(i);
		    }
		}
		int count=0;
		for(Zahtjev z:new Servis().get_zahthevi())
		{	
			

			model.addRow(new Object[]{ String.valueOf(count++),String.valueOf(z.getId()),z.getUredjaj().getKlijent(),z.getUredjaj().getIbfu(),z.getUredjaj().getTipUredaja()
					,z.getHitnost(),z.getRok(),z.getUredjaj().getKlijent().getTelefon()});
			
		}
	}
	private void initialize()
	{
		setBorder(BorderFactory.createTitledBorder("Pregled zahtjeva"));
		model=new DefaultTableModel(
				new Object[][] {},
					new String[] {
						"Br.", "Zahtjev", "Naziv firme", "IBFU", "Tip ure\u0111aja", "Hitnost", "Rok", "Telefon"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				};
		tabela.setModel(model);
			
		tabela.getColumnModel().getColumn(0).setPreferredWidth(33);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(tabela);
		
		JButton btnNewButton = new JButton("Kreiraj zadatak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabela.getSelectedRow()>=0)
				{
					int redTabele=tabela.getSelectedRow();
					frmKreirajZadatak fk=new frmKreirajZadatak(model,tabela.getSelectedRow());
					fk.setVisible(true);
				}
					
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnNewButton))
		);
		setLayout(groupLayout);
	}
	
	
}
