package paneli;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class panelPregledKlijenata extends JPanel {

	    private JTable tabela=new JTable();
	   
	    /**	
	 * 
	 * Create the panel.
	 */
	
	public panelPregledKlijenata(Boolean _dugmeVidljivo) {
		setBorder(BorderFactory.createTitledBorder("Pregled klijenata:"));
		
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Naziv", "Tip", "JIB", "Adresa", "Mjesto", "Telefon", "Email", "Web"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabela.getColumnModel().getColumn(0).setPreferredWidth(133);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(111);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(93);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		
		 JButton btnIzmjeni = new JButton("Izmjeni");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnIzmjeni)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(17)
					.addComponent(btnIzmjeni))
		);
		setLayout(groupLayout);
		btnIzmjeni.setVisible(_dugmeVidljivo);
	}
}
