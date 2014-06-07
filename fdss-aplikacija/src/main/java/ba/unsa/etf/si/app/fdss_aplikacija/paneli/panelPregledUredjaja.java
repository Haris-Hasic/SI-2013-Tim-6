package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

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

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmIzmjenaUredjaja;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class panelPregledUredjaja extends JPanel {

	    private JTable tabela=new JTable();
	    private DefaultTableModel model;
	    /** 
	 * Create the panel.
	 */
	public panelPregledUredjaja(Boolean _dugmeVidljivo) {
		
		setBorder(BorderFactory.createTitledBorder("Pregled ure\u0111aja:"));
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Klijent", "JIB proizvo\u0111a\u010Da", "Tip ure\u0111aja", "IBFU", "IBFM"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class
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
			};
		tabela.setModel(model);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(208);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(111);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(99);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(93);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		
		JButton btnIzmjeni = new JButton("Izmjeni");
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabela.getSelectedRow()>=0)
				{
					String ifbu=model.getValueAt(tabela.getSelectedRow(), 3).toString();
					frmIzmjenaUredjaja fk=new frmIzmjenaUredjaja(model,ifbu);
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
		upisiPodatke();
	}
	
	private void upisiPodatke()
	{
		//"Klijent", "JIB proizvo\u0111a\u010Da", "Tip ure\u0111aja", "IBFU", "IBFM"
		List<Uredjaj> uredjaji=new HibernateUredjaj().dajSveUredjaje();
		if(uredjaji.size()>0)
		{
			for(Uredjaj uredjaj:uredjaji)
			{
				try{
					String klijent=uredjaj.getKlijent().getNaziv()+" "+uredjaj.getKlijent().getJib();
					String jibPro=uredjaj.getJibProizvodaca();
					String tip=uredjaj.getTipUredaja();
					String ibfu=uredjaj.getIbfu();
					String ibfm=uredjaj.getIbfm();
					
					model.addRow(new Object[]{klijent,jibPro,tip,ibfu,ibfm});
				}catch(Exception e)
				{
					
				}
			}
		}
	}
}
