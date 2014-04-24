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

import forme.frmIzmjenaKlijenta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnNewButton = new JButton("Izmjeni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frmIzmjenaKlijenta fk=new frmIzmjenaKlijenta();
			fk.setVisible(true);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(btnNewButton))
		);
		setLayout(groupLayout);
		btnNewButton.setVisible(_dugmeVidljivo);
	}
}
