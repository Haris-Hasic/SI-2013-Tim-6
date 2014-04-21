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

public class panelPregledUredjaja extends JPanel {

	    private JTable tabela=new JTable();
	    private JTextField textField;
	/**
	 * Create the panel.
	 */
	public panelPregledUredjaja() {
		
		setBorder(BorderFactory.createTitledBorder("Pregled ure\u0111aja:"));
		TitledBorder border=(TitledBorder)getBorder();
		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));

		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"JIP klijenta", "JIB proizvo\u0111a\u0107a", "Tip ure\u0111aja", "IBFU", "IBFM"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabela.getColumnModel().getColumn(0).setPreferredWidth(133);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(111);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(93);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(93);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		
		JLabel lblFilter = new JLabel("Filter:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnIzmjeni = new JButton("Izmjeni");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblFilter)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
						.addComponent(btnIzmjeni))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFilter)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIzmjeni)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
