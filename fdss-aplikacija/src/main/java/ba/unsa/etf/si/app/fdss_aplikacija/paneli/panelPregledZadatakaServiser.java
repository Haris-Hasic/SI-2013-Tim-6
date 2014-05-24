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
import javax.swing.LayoutStyle.ComponentPlacement;












import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.pomocneForme.frmDetaljnijeZadatakServiser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.List;

public class panelPregledZadatakaServiser extends JPanel {
	 private JTable tabela=new JTable();
	 private DefaultTableModel model=new DefaultTableModel();//model se koristi za unos podataka u tabelu(model.add ili nesto slicno)
	 Uposlenik uposlenik;
	 
	/**
	 * Create the panel.
	 */
	public panelPregledZadatakaServiser(Uposlenik uposlenik) {
		this.uposlenik=uposlenik;
		setBorder(BorderFactory.createTitledBorder("Pregled zadataka"));
		model=new DefaultTableModel(
				new Object[][] {
						},
					new String[] {
						"Br.", "Naziv firme", "Podne\u0161en", "Pokupiti do", "Rok", "Hitnost"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, Object.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				};
		tabela.setModel(model);
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
		
		popuniPodatke();
	}
	
	private void popuniPodatke(){
		//long id=uposlenik.getId();
		List<Zadatak> zadaci=new HibernateZadatak().dajSveNezavrseneZadatke(uposlenik);
		//"Br.", "Naziv firme", "Poslovnica", "Podne\u0161en", "Pokupiti do", "Rok", "Hitnost"
		if(zadaci.size()>0)
		{
			for(int i=0;i<zadaci.size();i++)
			{
				Zadatak zadatak=zadaci.get(i);
				String nazivFirme=zadatak.getZahtjev().getUredjaj().getKlijent().getNaziv();
				SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
				String podnesen=format.format(zadatak.getZahtjevPodnesen());
				String pokupiti=format.format(zadatak.getDonijetiUredjajDo());
				String rok=format.format(zadatak.getZavrsitiDo());
				String hitnost=zadatak.getHitnost();
				
				model.addRow(new Object[]{i,nazivFirme,podnesen,pokupiti,rok,hitnost});
			}
		}
	}
}
