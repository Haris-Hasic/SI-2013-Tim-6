package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class panelIzvjestaji extends JPanel {
	private JTextField ti_ibfu_tb;
	private JTextField ured_idUred_tb;

	/**
	 * Create the panel.
	 */
	public panelIzvjestaji() {
		setBorder(BorderFactory.createTitledBorder("Kreiranje izvje\u0161taja"));
		
		final JRadioButton tehIzv_rdbtn = new JRadioButton("Tehnički Izvještaj");
		tehIzv_rdbtn.setSelected(false);
		
		final JRadioButton hrmIzv_rdbtn = new JRadioButton("HRM Izvještaj");
		
		final JRadioButton posIzv_rdbtn = new JRadioButton("Poslovni Izvještaj");
		
		JButton btnKreirajIzvjestaj = new JButton("Kreiraj Izvještaj");
		btnKreirajIzvjestaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*
				  
				 
				String Do = "1.1.2015";
				String Od = "1.1.2014";
				String IBFU = "1234";
				String Korisnik = "Hamo";
				String i = "Izvještaj";

				if(rdbtnTehnickiIzvjetaj.isSelected() == true) {

					Do = tb_TI_Do.getText();
					Od = tb_TI_Od.getText();
					IBFU = tb_TI_IBFU.getText();
					i = "Tehnicki " + i;
				}

				else if(rdbtnHrmIzvjetaj.isSelected() == true) {

					Do = tb_HRM_Do.getText();
					Od = tb_HRM_Od.getText();
					Korisnik = (String)cb_HRM_Korisnik.getSelectedItem();
					i = "Human Resource " + i;
				}

				else {

					Do = tb_TI_Do.getText();
					Od = tb_TI_Od.getText();
					i = "Poslovni " + i;
				}


				try {

					Document document = new Document(PageSize.A4, 50, 50, 50, 50);
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Haris/Desktop/haris.pdf"));
					document.open();

					iscrtajHeader(document);
					podesiDetaljeIzvjestaja(document);
					//ispisiTijeloHRMIzvjestaja(document);
					//ispisiTijeloTehnickogIzvjestaja(document);
					//ispisiTijeloKlijentelaIzvjestaja(document);
					ispisiTijeloPoslovanjeIzvjestaja(document);
					iscrtajFooter(document);
					
					document.close();
				} 

				catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Kreiranje izvještaja neuspjelo ! \nDetalji :\n" + e.getMessage());
				}
				 
				 
				 */
			}
		});
		
		final JPanel ti_panel = new JPanel();
		ti_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		final JPanel hrm_panel = new JPanel();
		hrm_panel.setLayout(null);
		hrm_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("Od :");
		label.setEnabled(false);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(42, 21, 29, 20);
		hrm_panel.add(label);
		
		JLabel label_1 = new JLabel("Do :");
		label_1.setEnabled(false);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(42, 52, 29, 20);
		hrm_panel.add(label_1);
		
		JLabel lblUposlenik = new JLabel("Uposlenik :");
		lblUposlenik.setEnabled(false);
		lblUposlenik.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUposlenik.setBounds(-2, 83, 73, 20);
		hrm_panel.add(lblUposlenik);
		
		JDateChooser hrm_od_dateC = new JDateChooser();
		hrm_od_dateC.setBounds(81, 21, 157, 20);
		hrm_panel.add(hrm_od_dateC);
		hrm_od_dateC.setEnabled(false);
		
		JDateChooser hrm_do_dateC = new JDateChooser();
		hrm_do_dateC.setBounds(81, 52, 157, 20);
		hrm_panel.add(hrm_do_dateC);
		hrm_do_dateC.setEnabled(false);
		
		final JPanel pos_panel = new JPanel();
		pos_panel.setLayout(null);
		pos_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_2 = new JLabel("Od :");
		label_2.setEnabled(false);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(22, 21, 29, 20);
		pos_panel.add(label_2);
		
		JLabel label_3 = new JLabel("Do :");
		label_3.setEnabled(false);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(22, 52, 29, 20);
		pos_panel.add(label_3);
		
		JDateChooser pos_od_dateC = new JDateChooser();
		pos_od_dateC.setBounds(61, 21, 177, 20);
		pos_panel.add(pos_od_dateC);
		pos_od_dateC.setEnabled(false);
		
		JDateChooser pos_do_dateC = new JDateChooser();
		pos_do_dateC.setBounds(61, 52, 177, 20);
		pos_panel.add(pos_do_dateC);
		pos_do_dateC.setEnabled(false);
		
		final JRadioButton uredIzv_rdbtn = new JRadioButton("Izvještaj o Uređaju");
		final JPanel ured_panel = new JPanel();
		ured_panel.setLayout(null);
		ured_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_5 = new JLabel("Od :");
		label_5.setEnabled(false);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(51, 21, 29, 20);
		ured_panel.add(label_5);
		
		JLabel label_6 = new JLabel("Do :");
		label_6.setEnabled(false);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(43, 52, 37, 20);
		ured_panel.add(label_6);
		
		JLabel lblIdUreaja = new JLabel("ID uređaja :");
		lblIdUreaja.setEnabled(false);
		lblIdUreaja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdUreaja.setBounds(10, 83, 70, 20);
		ured_panel.add(lblIdUreaja);
		
		JDateChooser ured_od_dateC = new JDateChooser();
		ured_od_dateC.setBounds(90, 21, 148, 20);
		ured_panel.add(ured_od_dateC);
		ured_od_dateC.setEnabled(false);
		
		JDateChooser ured_do_dateC = new JDateChooser();
		ured_do_dateC.setBounds(90, 52, 148, 20);
		ured_panel.add(ured_do_dateC);
		ured_do_dateC.setEnabled(false);
		
		ured_idUred_tb = new JTextField();
		ured_idUred_tb.setEnabled(false);
		ured_idUred_tb.setColumns(10);
		ured_idUred_tb.setBounds(90, 83, 148, 20);
		ured_panel.add(ured_idUred_tb);
		
		JButton btnNazad = new JButton("Nazad");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tehIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(ti_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(posIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(uredIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(hrm_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(hrmIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pos_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ured_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(298, Short.MAX_VALUE)
					.addComponent(btnNazad, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnKreirajIzvjestaj, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(hrmIzv_rdbtn)
						.addComponent(tehIzv_rdbtn))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(hrm_panel, 0, 0, Short.MAX_VALUE)
						.addComponent(ti_panel, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(posIzv_rdbtn)
						.addComponent(uredIzv_rdbtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pos_panel, 0, 0, Short.MAX_VALUE)
						.addComponent(ured_panel, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNazad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKreirajIzvjestaj, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(125))
		);
		
		JComboBox hrm_uposlenik_cb = new JComboBox();
		hrm_uposlenik_cb.setEnabled(false);
		hrm_uposlenik_cb.setBounds(81, 83, 157, 20);
		hrm_panel.add(hrm_uposlenik_cb);
		ti_panel.setLayout(null);
		
		JLabel lblOd = new JLabel("Od :");
		lblOd.setEnabled(false);
		lblOd.setBounds(22, 21, 29, 20);
		ti_panel.add(lblOd);
		lblOd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblDo = new JLabel("Do :");
		lblDo.setEnabled(false);
		lblDo.setBounds(22, 52, 29, 20);
		ti_panel.add(lblDo);
		lblDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIbfu = new JLabel("IBFU :");
		lblIbfu.setEnabled(false);
		lblIbfu.setBounds(16, 83, 35, 20);
		ti_panel.add(lblIbfu);
		lblIbfu.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JDateChooser ti_od_dateC = new JDateChooser();
		ti_od_dateC.setBounds(61, 21, 177, 20);
		ti_panel.add(ti_od_dateC);
		ti_od_dateC.setEnabled(false);
		
		JDateChooser ti_do_dateC = new JDateChooser();
		ti_do_dateC.setBounds(61, 52, 177, 20);
		ti_panel.add(ti_do_dateC);
		ti_do_dateC.setEnabled(false);
		
		ti_ibfu_tb = new JTextField();
		ti_ibfu_tb.setEnabled(false);
		ti_ibfu_tb.setBounds(61, 83, 177, 20);
		ti_panel.add(ti_ibfu_tb);
		ti_ibfu_tb.setColumns(10);
		setLayout(groupLayout);
		
	    ButtonGroup grupa = new ButtonGroup();
	    grupa.add(tehIzv_rdbtn);
	    grupa.add(hrmIzv_rdbtn);
	    grupa.add(posIzv_rdbtn);
	    grupa.add(uredIzv_rdbtn);
	    
		final ArrayList<Component> list_ti = new ArrayList<Component>(Arrays.asList(((Container)ti_panel).getComponents()));
		final ArrayList<Component> list_hrm = new ArrayList<Component>(Arrays.asList(((Container)hrm_panel).getComponents()));
		final ArrayList<Component> list_pos = new ArrayList<Component>(Arrays.asList(((Container)pos_panel).getComponents()));
		final ArrayList<Component> list_ured = new ArrayList<Component>(Arrays.asList(((Container)ured_panel).getComponents()));
	    
		tehIzv_rdbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for(Component component : list_ti)
					component.setEnabled(true);
				
				for(Component component : list_hrm)
					component.setEnabled(false);
				
				for(Component component : list_pos)
					component.setEnabled(false);
				
				for(Component component : list_ured)
					component.setEnabled(false);
			}
		});
		
		hrmIzv_rdbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(Component component : list_ti)
					component.setEnabled(false);
				
				for(Component component : list_hrm)
					component.setEnabled(true);
				
				for(Component component : list_pos)
					component.setEnabled(false);
				
				for(Component component : list_ured)
					component.setEnabled(false);
			}
		});
		
		posIzv_rdbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(Component component : list_ti)
					component.setEnabled(false);
				
				for(Component component : list_hrm)
					component.setEnabled(false);
				
				for(Component component : list_pos)
					component.setEnabled(true);
				
				for(Component component : list_ured)
					component.setEnabled(false);
			}
		});
		
		uredIzv_rdbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(Component component : list_ti)
					component.setEnabled(false);
				
				for(Component component : list_hrm)
					component.setEnabled(false);
				
				for(Component component : list_pos)
					component.setEnabled(false);
				
				for(Component component : list_ured)
					component.setEnabled(true);
			}
		});

	}
	
	/*
	 
	 
	 	public static void iscrtajHeader(Document document) throws Exception {
		
		// Header
		PdfPTable table = new PdfPTable(3);
	    float[] relative = { 12, 76, 12 };
	    table.setWidths(relative);
	    table.setWidthPercentage(100);
	    table.setHorizontalAlignment(1);

	    PdfPCell c1 = new PdfPCell(new Phrase(" ", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    c1.setVerticalAlignment(Element.ALIGN_CENTER);
	    c1.setBorder(Rectangle.NO_BORDER);
			
		com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("C:/Users/Haris/Desktop/logoServisa.jpg");
		image.scaleAbsoluteHeight(65);
		image.scaleAbsoluteWidth(65);
		c1.addElement(image);
		
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("\nOvlasteni servis za fiskalne uredaje\nBosna i Hercegovina", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    c1.setBorder(Rectangle.NO_BORDER);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase(" ", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    c1.setBorder(Rectangle.NO_BORDER);
			
		image = com.itextpdf.text.Image.getInstance("C:/Users/Haris/Desktop/GrbBIH.png");
		image.scaleAbsoluteHeight(50);
		image.scaleAbsoluteWidth(50);
		c1.addElement(image);
		
	    table.addCell(c1);
	    
		document.add(table);
		
		// Naslov
		Anchor anchorTarget = new Anchor("");
		anchorTarget.setName("BackToTop");
		Paragraph paragraph1 = new Paragraph("Tehnicki izvjestaj", catFont);

		paragraph1.setSpacingAfter(30);
		paragraph1.setAlignment(1);

		paragraph1.add(anchorTarget);
		document.add(paragraph1);
	}
	
	public static void iscrtajFooter(Document document) throws Exception {
		
		document.add(new Paragraph(" "));
		
		// Footer
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);

		PdfPCell c1 = new PdfPCell(new Phrase("Sarajevo,", obicniFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
	   	c1.setPaddingLeft(5);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Izvještaj podnio :", obicniFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    c1.setPaddingBottom(8);
	    c1.setPaddingTop(5);
		table.addCell(c1);
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		
		c1 = new PdfPCell(new Phrase(dateFormat.format(date) + ". godine", obicniFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
	   	c1.setPaddingLeft(5);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase(" ", obicniFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setBorderWidthLeft(0);
		c1.setBorderWidthRight(0);
		c1.setBorderWidthTop(0);
	    c1.setPaddingBottom(8);
	    c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
		table.addCell(c1);
		    
		table.setHorizontalAlignment(1);
		document.add(table);
	}
	
	public static void podesiDetaljeIzvjestaja(Document document) {
	
		document.addTitle("My first PDF");
	    document.addSubject("Using iText");
	    document.addKeywords("Java, PDF, iText");
	    document.addAuthor("Lars Vogel");
	    document.addCreator("Lars Vogel");
	}
	
	public static void ispisiTijeloHRMIzvjestaja(Document document) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + "15.04.1992", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + "27.05.2014", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);
	    
	    table.setHorizontalAlignment(1);
	    document.add(table);
		
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
	    
	    PdfPTable table2 = new PdfPTable(2);
	    
	    float[] relativeW = { 25, 70 };
	    table2.setWidths(relativeW);
	    table2.setWidthPercentage(100);

	    c1 = new PdfPCell(new Phrase("Ime:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Haris", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Prezime:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Hasic", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("JMBG:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("1504992173043", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Adresa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Tuzlanska bb", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Rodni grad:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Olovo", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj telefona:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("+38762380249", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Pozicija:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Serviser", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Opis radnog mjesta:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Serviser\nasdasdads\nadsdsdsa", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj aktivnih zadataka:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj izvršenih zadataka:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Efikasnost:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Procjena nadleznog menadzera:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("\n\n\n\n", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Finalna ocjena:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
		
	    table2.setHorizontalAlignment(1);
	    document.add(table2);
	}
	
	public static void ispisiTijeloTehnickogIzvjestaja(Document document) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + "15.04.1992", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + "27.05.2014", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);
	    
	    table.setHorizontalAlignment(1);
	    document.add(table);
		
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
	    
	    PdfPTable table2 = new PdfPTable(2);
	    
	    float[] relativeW = { 25, 70 };
	    table2.setWidths(relativeW);
	    table2.setWidthPercentage(100);

	    c1 = new PdfPCell(new Phrase("JIB proizvodaca:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("1504992173043", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Tip uredaja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Fiskalna kasa", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("IBFU:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("hh111111", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("IBFM:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("hh111110", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj uredaja koji se trenutno servisiraju:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj uredaja koji cekaju na servisiranje:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj kvarova:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj redovnih servisiranja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Preformanse proizvodaca:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Efikasnost uredaja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Procjena nadleznog menadzera:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("\n\n\n\n\n\n\n", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
		
	    table2.setHorizontalAlignment(1);
	    document.add(table2);
	}
	
	public static void ispisiTijeloKlijentelaIzvjestaja(Document document) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + "15.04.1992", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + "27.05.2014", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);
	    
	    table.setHorizontalAlignment(1);
	    document.add(table);
		
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
	    
	    PdfPTable table2 = new PdfPTable(2);
	    
	    float[] relativeW = { 25, 70 };
	    table2.setWidths(relativeW);
	    table2.setWidthPercentage(100);

	    c1 = new PdfPCell(new Phrase("Naziv klijenta:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Konzum d.o.o", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Identifikacioni broj:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("123456789012", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Tip :", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Lanac supermarketa", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Adresa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Branilaca grada bb", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Grad:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Sarajevo", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Telefon:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("+38761123456", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("E-mail adresa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("konzum@gmail.com", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Web stranica:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("www.konzum.co.hr", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Lista uredaja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj popravki:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj redovnih servisiranja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Procjena nadleznog menadzera:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("\n\n\n\n\n\n\n", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
		
	    table2.setHorizontalAlignment(1);
	    document.add(table2);
	}
	
	public static void ispisiTijeloPoslovanjeIzvjestaja(Document document) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + "15.04.1992", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + "27.05.2014", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);
	    
	    table.setHorizontalAlignment(1);
	    document.add(table);
		
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
	    
	    PdfPTable table2 = new PdfPTable(2);
	    
	    float[] relativeW = { 25, 70 };
	    table2.setWidths(relativeW);
	    table2.setWidthPercentage(100);

	    c1 = new PdfPCell(new Phrase("Naziv servisa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("FisCalService d.o.o", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Identifikacioni broj:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("123456789012", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Adresa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Branilaca grada bb", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Grad:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Sarajevo", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Telefon:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("+38761123456", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("E-mail adresa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("fiscalservice@gmail.com", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Web adresa:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("www.fiscalservice.co.ba", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Ukupno primljenih zahtjeva:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Ukupno obavljenih zadataka:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj redovnih servisiranja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj popravljenih kvarova:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Zarada u datom periodu:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("NaN", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Procjena nadleznog menadzera:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("\n\n\n\n\n\n\n", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
		
	    table2.setHorizontalAlignment(1);
	    document.add(table2);
	}
	 
	 
	 
	 
	 */
}
