package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;

public class panelPregledZahtjeva extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model;//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 List<Zahtjev> zahtjevi;
	 
	/**
	 * Create the panel.
	 */
	public panelPregledZahtjeva(List<Zahtjev> zahtjevi) {
		this.zahtjevi=zahtjevi;
		initialize();
		popuniPodatke();
	}
	public void popuniPodatke() {
		int count=1;
		for(Zahtjev z:zahtjevi)
		{
			model.addRow(new Object[]{count++,z.getUredjaj().getKlijent(),z.getUredjaj().getIbfu(),z.getUredjaj().getTipUredaja()
					,z.getHitnost(),z.getRok(),z.getUredjaj().getKlijent().getTelefon()});
		}
		
	}
	public void initialize() {
		setBorder(BorderFactory.createTitledBorder("Pregled zahtjeva"));
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Br.", "Naziv firme", "IBFU", "Tip ure\u0111aja", "Hitnost", "Rok", "Telefon"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
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
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
	
}
