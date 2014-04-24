package paneli;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import forme.frmKreirajZadatak;
public class panelObradiZahtjev extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model=new DefaultTableModel();//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 
	 
	/**
	 * Create the panel.
	 */
	public panelObradiZahtjev() {
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
		
		JButton btnNewButton = new JButton("Kreiraj zadatak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKreirajZadatak fk=new frmKreirajZadatak();
				fk.setVisible(true);
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
