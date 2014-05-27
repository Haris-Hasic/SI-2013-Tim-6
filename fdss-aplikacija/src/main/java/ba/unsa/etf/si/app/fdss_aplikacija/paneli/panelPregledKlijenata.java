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

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmIzmjenaKlijenta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Color;

public class panelPregledKlijenata extends JPanel {

	    private JTable tabela=new JTable();
	    DefaultTableModel model;
	    /**	
	 * 
	 * Create the panel.
	 */
	
	public panelPregledKlijenata(Boolean _dugmeVidljivo) {
		setBorder(BorderFactory.createTitledBorder("Pregled klijenata:"));
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Br.", "Naziv", "Tip", "JIB", "Adresa", "Mjesto", "Telefon", "Email", "Web"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, Object.class, String.class, String.class, Object.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		tabela.setBackground(Color.WHITE);
		tabela.setModel(model);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(38);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(133);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(130);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(111);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(93);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tabela);
		
		JButton btnNewButton = new JButton("Izmjeni");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabela.getSelectedRow()>=0)
				{
					String jibKlijenta=model.getValueAt(tabela.getSelectedRow(), 3).toString();
					frmIzmjenaKlijenta fk=new frmIzmjenaKlijenta(model,jibKlijenta);
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
		upisiPodatke();
	}
	
	private void upisiPodatke()
	{
		List<Klijent> klijenti=new HibernateKlijent().dajSveKlijente();
		if(klijenti.size()>0)
		{
			//"Br.", "Naziv", "Tip", "JIB", "Adresa", "Mjesto", "Telefon", "Email", "Web"
			for(int i=0;i<klijenti.size();i++)
			{
				Klijent klijent=klijenti.get(i);
				
				String naziv=klijent.getNaziv();
				String tipString=klijent.getTip();
				String jib=klijent.getJib();
				String adresa=klijent.getAdresa();
				String mjesto=klijent.getMjesto();
				String telefon=klijent.getTelefon();
				String email=klijent.getEmail();
				String web=klijent.getWeb();
				
				model.addRow(new Object[]{String.valueOf(i+1),naziv,tipString,jib,adresa,mjesto,telefon,email,web});
			}
		}
	}
}
