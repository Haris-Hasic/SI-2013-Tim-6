package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

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

public class panelPregledZahtjeva extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model=new DefaultTableModel();//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 
	 
	/**
	 * Create the panel.
	 */
	public panelPregledZahtjeva() {
		setBorder(BorderFactory.createTitledBorder("Pregled zahtjeva"));
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
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
		});
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
