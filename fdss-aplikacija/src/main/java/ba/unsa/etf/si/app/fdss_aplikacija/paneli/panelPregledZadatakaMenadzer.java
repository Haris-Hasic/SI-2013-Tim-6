package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;

public class panelPregledZadatakaMenadzer extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model;//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 
	 
	/**
	 * Create the panel.
	 */
	public panelPregledZadatakaMenadzer() {
		setBorder(BorderFactory.createTitledBorder("Pregled zadataka"));
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Br.", "Naziv firme", "IBFU", "Tip ure\u0111aja", "Podne\u0161en", "Pokupiti do", "Rok", "Hitnost", "Serviser"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, Object.class, String.class, String.class, String.class
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
		popuniTabelu();
	}
	 
	 private void popuniTabelu() {
		 List<Zadatak> zadaci=new HibernateZadatak().dajSveNezavrseneZadatke();
		 //"Br.", "Naziv firme", "IBFU", "Tip ure\u0111aja", "Podne\u0161en", "Pokupiti do", "Rok", "Hitnost", "Serviser"
		 if(zadaci.size()!=0)
		 {
			for(int i=0;i<zadaci.size();i++)
			{
				Zadatak z=zadaci.get(i);
				String naziv=z.getZahtjev().getUredjaj().getKlijent().getNaziv();
				String ibfu=z.getZahtjev().getUredjaj().getIbfu();
				String tip=z.getZahtjev().getUredjaj().getTipUredaja();
				SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
				String podnesen=format.format(new java.util.Date(z.getZahtjev().getZahtjevPodnesen().getTime()));
				String pokupitiDo=format.format(new java.util.Date(z.getDonijetiUredjajDo().getTime()));
				String rok=format.format(new java.util.Date(z.getZavrsitiDo().getTime()));
				String hitnost=z.getHitnost();
				String serviser=z.getServiser().toString();
				model.addRow(new Object[]{String.valueOf(i),naziv,ibfu,tip,podnesen,pokupitiDo,rok,hitnost,serviser});
			}
		 }
		
	}
}
