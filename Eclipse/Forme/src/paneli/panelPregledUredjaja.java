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

import forme.frmIzmjenaUredjaja;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelPregledUredjaja extends JPanel {

	    private JTable tabela=new JTable();
	/**
	 * Create the panel.
	 */
	public panelPregledUredjaja(Boolean _dugmeVidljivo) {
		
		setBorder(BorderFactory.createTitledBorder("Pregled ure\u0111aja:"));

		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"JIP klijenta", "JIB proizvo\u0111a\u010Da", "Tip ure\u0111aja", "IBFU", "IBFM"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabela.getColumnModel().getColumn(0).setPreferredWidth(133);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(111);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(93);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(93);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		
		JButton btnIzmjeni = new JButton("Izmjeni");
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIzmjenaUredjaja fi=new frmIzmjenaUredjaja();
				fi.setVisible(true);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
						.addComponent(btnIzmjeni))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIzmjeni))
		);
		setLayout(groupLayout);
		btnIzmjeni.setVisible(_dugmeVidljivo);
	}
}
