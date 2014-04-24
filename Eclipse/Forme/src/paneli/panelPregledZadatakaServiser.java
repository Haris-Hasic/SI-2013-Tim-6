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
import javax.swing.LayoutStyle.ComponentPlacement;

import forme.frmDetaljnijeZadatakServiser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelPregledZadatakaServiser extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model=new DefaultTableModel();//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 
	 
	/**
	 * Create the panel.
	 */
	public panelPregledZadatakaServiser() {
		setBorder(BorderFactory.createTitledBorder("Pregled zadataka"));
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Br.", "Naziv firme", "Poslovnica", "Podne\u0161en", "Pokupiti do", "Rok", "Hitnost"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabela.getColumnModel().getColumn(0).setPreferredWidth(33);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(tabela);
		
		JButton btnDetaljno = new JButton("Detaljno");
		btnDetaljno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDetaljnijeZadatakServiser fd=new frmDetaljnijeZadatakServiser();
				fd.setVisible(true);
			}
		});
		
		JButton btnZavri = new JButton("Zavr\u0161i");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnZavri, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDetaljno)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDetaljno)
						.addComponent(btnZavri)))
		);
		setLayout(groupLayout);
	}
}
