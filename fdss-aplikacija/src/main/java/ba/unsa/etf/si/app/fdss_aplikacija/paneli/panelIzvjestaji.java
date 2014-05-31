package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ba.unsa.etf.si.app.fdss_aplikacija.beans.Klijent;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Uredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.beans.Zahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateKlijent;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUposlenik;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateUredjaj;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZadatak;
import ba.unsa.etf.si.app.fdss_aplikacija.hibernate_klasa.HibernateZahtjev;
import ba.unsa.etf.si.app.fdss_aplikacija.klase.TestPristupaBazi;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

public class panelIzvjestaji extends JPanel {
	private JTextField teh_ibfuUred_tb;
	
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 36, Font.BOLD);
	private static Font obicniFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
	private static Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC);
	private JTextField hrm_un_tb;
	private JTextField kli_jib_tb;
	private static Uposlenik uposlenik; 

	/**
	 * Create the panel.
	 */
	public panelIzvjestaji(final Uposlenik u) {
		
		uposlenik = u;
		
		setBorder(BorderFactory.createTitledBorder("Kreiranje izvje\u0161taja"));
		
		final JRadioButton posIzv_rdbtn = new JRadioButton("Izvještaj o Poslovanju");
		posIzv_rdbtn.setSelected(false);
		
		final JRadioButton hrmIzv_rdbtn = new JRadioButton("HRM Izvještaj");
		
		final JRadioButton kliIzv_rdbtn = new JRadioButton("Izvještaj o Klijentima");
		
		JButton btnKreirajIzvjestaj = new JButton("Kreiraj Izvještaj");
		
		final JPanel pos_panel = new JPanel();
		pos_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
		
		final JDateChooser hrm_od_dateC = new JDateChooser();
		hrm_od_dateC.setBounds(81, 21, 157, 20);
		hrm_panel.add(hrm_od_dateC);
		hrm_od_dateC.setEnabled(false);
		
		final JDateChooser hrm_do_dateC = new JDateChooser();
		hrm_do_dateC.setBounds(81, 52, 157, 20);
		hrm_panel.add(hrm_do_dateC);
		hrm_do_dateC.setEnabled(false);
		
		final JPanel kli_panel = new JPanel();
		kli_panel.setLayout(null);
		kli_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_2 = new JLabel("Od :");
		label_2.setEnabled(false);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(42, 21, 29, 20);
		kli_panel.add(label_2);
		
		JLabel label_3 = new JLabel("Do :");
		label_3.setEnabled(false);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(42, 52, 29, 20);
		kli_panel.add(label_3);
		
		final JDateChooser kli_od_dateC = new JDateChooser();
		kli_od_dateC.setBounds(81, 21, 157, 20);
		kli_panel.add(kli_od_dateC);
		kli_od_dateC.setEnabled(false);
		
		final JDateChooser kli_do_dateC = new JDateChooser();
		kli_do_dateC.setBounds(81, 52, 157, 20);
		kli_panel.add(kli_do_dateC);
		kli_do_dateC.setEnabled(false);
		
		final JRadioButton tehIzv_rdbtn = new JRadioButton("Tehnički Izvještaj");
		final JPanel teh_panel = new JPanel();
		teh_panel.setLayout(null);
		teh_panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_5 = new JLabel("Od :");
		label_5.setEnabled(false);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(51, 21, 29, 20);
		teh_panel.add(label_5);
		
		JLabel label_6 = new JLabel("Do :");
		label_6.setEnabled(false);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(43, 52, 37, 20);
		teh_panel.add(label_6);
		
		JLabel lblibfuUreaja = new JLabel("IBFU uređaja :");
		lblibfuUreaja.setEnabled(false);
		lblibfuUreaja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblibfuUreaja.setBounds(0, 83, 82, 20);
		teh_panel.add(lblibfuUreaja);
		
		final JDateChooser teh_od_dateC = new JDateChooser();
		teh_od_dateC.setBounds(90, 21, 148, 20);
		teh_panel.add(teh_od_dateC);
		teh_od_dateC.setEnabled(false);
		
		final JDateChooser teh_do_dateC = new JDateChooser();
		teh_do_dateC.setBounds(90, 52, 148, 20);
		teh_panel.add(teh_do_dateC);
		teh_do_dateC.setEnabled(false);
		
		teh_ibfuUred_tb = new JTextField();
		teh_ibfuUred_tb.setEnabled(false);
		teh_ibfuUred_tb.setColumns(10);
		teh_ibfuUred_tb.setBounds(90, 83, 148, 20);
		teh_panel.add(teh_ibfuUred_tb);
		
		JButton btnNazad = new JButton("Nazad");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pos_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(posIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addComponent(kliIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tehIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(hrm_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addComponent(hrmIzv_rdbtn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(kli_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teh_panel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
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
						.addComponent(posIzv_rdbtn))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(hrm_panel, 0, 0, Short.MAX_VALUE)
						.addComponent(pos_panel, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(kliIzv_rdbtn)
						.addComponent(tehIzv_rdbtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(kli_panel, 0, 0, Short.MAX_VALUE)
						.addComponent(teh_panel, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNazad, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKreirajIzvjestaj, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(125))
		);
		
		JLabel lblJibKlijenta = new JLabel("JIB klijenta :");
		lblJibKlijenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJibKlijenta.setEnabled(false);
		lblJibKlijenta.setBounds(-2, 83, 73, 20);
		kli_panel.add(lblJibKlijenta);
		
		kli_jib_tb = new JTextField();
		kli_jib_tb.setEnabled(false);
		kli_jib_tb.setColumns(10);
		kli_jib_tb.setBounds(81, 83, 157, 20);
		kli_panel.add(kli_jib_tb);
		
		hrm_un_tb = new JTextField();
		hrm_un_tb.setEnabled(false);
		hrm_un_tb.setBounds(81, 83, 157, 20);
		hrm_panel.add(hrm_un_tb);
		hrm_un_tb.setColumns(10);
		pos_panel.setLayout(null);
		
		JLabel lblOd = new JLabel("Od :");
		lblOd.setEnabled(false);
		lblOd.setBounds(22, 21, 29, 20);
		pos_panel.add(lblOd);
		lblOd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblDo = new JLabel("Do :");
		lblDo.setEnabled(false);
		lblDo.setBounds(22, 52, 29, 20);
		pos_panel.add(lblDo);
		lblDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		final JDateChooser pos_od_dateC = new JDateChooser();
		pos_od_dateC.setBounds(61, 21, 177, 20);
		pos_panel.add(pos_od_dateC);
		pos_od_dateC.setEnabled(false);
		
		final JDateChooser pos_do_dateC = new JDateChooser();
		pos_do_dateC.setBounds(61, 52, 177, 20);
		pos_panel.add(pos_do_dateC);
		pos_do_dateC.setEnabled(false);
		setLayout(groupLayout);
		
	    ButtonGroup grupa = new ButtonGroup();
	    grupa.add(posIzv_rdbtn);
	    grupa.add(hrmIzv_rdbtn);
	    grupa.add(kliIzv_rdbtn);
	    grupa.add(tehIzv_rdbtn);
	    
		final ArrayList<Component> list_ti = new ArrayList<Component>(Arrays.asList(((Container)pos_panel).getComponents()));
		final ArrayList<Component> list_hrm = new ArrayList<Component>(Arrays.asList(((Container)hrm_panel).getComponents()));
		final ArrayList<Component> list_pos = new ArrayList<Component>(Arrays.asList(((Container)kli_panel).getComponents()));
		final ArrayList<Component> list_ured = new ArrayList<Component>(Arrays.asList(((Container)teh_panel).getComponents()));
	    
		posIzv_rdbtn.addMouseListener(new MouseAdapter() {
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
		
		kliIzv_rdbtn.addMouseListener(new MouseAdapter() {
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
		
		tehIzv_rdbtn.addMouseListener(new MouseAdapter() {
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
		
		btnKreirajIzvjestaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {

					Document document = new Document(PageSize.A4, 50, 50, 50, 50);
					String putanja= System.getProperty("user.home") + "/Desktop";

					Date Od, Do; 
					String user, IBFU, JIBKlijenta;
					String i = "Izvještaj";

					if(posIzv_rdbtn.isSelected() == true) {
						
						Od = new Date(pos_od_dateC.getDate().getTime());
						Do = new Date(pos_do_dateC.getDate().getTime());
						i = i + " o Poslovanju Servisa";
						
						DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						Date date = new Date();
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(putanja+"/"+i+dateFormat.format(date)+".pdf"));
						document.open();
						
						iscrtajHeader(document, i);
						podesiDetaljeIzvjestaja(document, i);
						ispisiTijeloPoslovanjeIzvjestaja(document, Do, Od);
					}

					else if(hrmIzv_rdbtn.isSelected() == true) {
						
						HibernateUposlenik hu = new HibernateUposlenik();
						Uposlenik up = new Uposlenik();
						
						Od = new Date(hrm_od_dateC.getDate().getTime());
						Do = new Date(hrm_do_dateC.getDate().getTime());
						user = hrm_un_tb.getText();
						i = "Human Resource " + i;
						
						if(hu.postojiUposlenik(user))
							up = hu.dajUposlenika(user);
						
						else
							throw new Exception("Nepostojeći JIB klijenta !");
						
						DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						Date date = new Date();
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(putanja+"/"+i+up.getIme()+up.getPrezime()+dateFormat.format(date)+".pdf"));
						document.open();
						
						iscrtajHeader(document, i);
						podesiDetaljeIzvjestaja(document, i);
						ispisiTijeloHRMIzvjestaja(document, Od, Do, up);
					}

					else if(kliIzv_rdbtn.isSelected() == true) {
						
						HibernateKlijent hu = new HibernateKlijent();
						Klijent k = new Klijent();
						
						Od = new Date(kli_od_dateC.getDate().getTime());
						Do = new Date(kli_do_dateC.getDate().getTime());
						JIBKlijenta = kli_jib_tb.getText();
						i = i + " o Klijentu"; 
						
						if(hu.postojiKlijent(JIBKlijenta))
							k = hu.dajKlijenta(JIBKlijenta);
						
						else
							throw new Exception("Nepostojeći JIB klijenta !");
						
						DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						Date date = new Date();
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(putanja+"/"+i+JIBKlijenta+dateFormat.format(date)+".pdf"));
						document.open();
						
						iscrtajHeader(document, i);
						podesiDetaljeIzvjestaja(document, i);
						ispisiTijeloKlijentelaIzvjestaja(document, Od, Do, k);
					}

					else {
						
						HibernateUredjaj hu = new HibernateUredjaj();
						Uredjaj ur = new Uredjaj();
						
						Od = new Date(teh_od_dateC.getDate().getTime());
						Do = new Date(teh_do_dateC.getDate().getTime());
						IBFU = teh_ibfuUred_tb.getText();
						i = i + " o Uredaju";
						
						if(hu.postojiUredjaj(IBFU))
							ur = hu.dajUredjaj(IBFU);
						
						else
							throw new Exception("Nepostojeći IBFU uredaja !");
						
						DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
						Date date = new Date();
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(putanja+"/"+i+ur.getIbfu()+dateFormat.format(date)+".pdf"));
						document.open();
						
						iscrtajHeader(document, i);
						podesiDetaljeIzvjestaja(document, i);
						ispisiTijeloTehnickogIzvjestaja(document, Od, Do, ur);
					}
					
					iscrtajFooter(document);
					document.close();
					
					JOptionPane.showMessageDialog(null, "Izvještaj uspješno kreiran i nalazi se na vašem desktopu !");
				} 

				catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Kreiranje izvještaja neuspjelo ! \nDetalji :\n" + e.getMessage());
				}
			}
		});
	}
	// Odavde počinje
	 
	 
	 	public static void iscrtajHeader(Document document, String n) throws Exception {
		
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
			
		com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(panelIzvjestaji.class.getClass().getResource("/logoServisa.jpg"));
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
		
		image = com.itextpdf.text.Image.getInstance(panelIzvjestaji.class.getClass().getResource("/GrbBIH.png"));
		image.scaleAbsoluteHeight(50);
		image.scaleAbsoluteWidth(50);
		c1.addElement(image);
		
	    table.addCell(c1);
	    
		document.add(table);
		
		// Naslov
		Anchor anchorTarget = new Anchor("");
		anchorTarget.setName("BackToTop");
		Paragraph paragraph1 = new Paragraph(n, catFont);

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
	
	public static void podesiDetaljeIzvjestaja(Document document, String t) {
	
		document.addTitle(t);
	    document.addSubject(t);
	    document.addKeywords("Java, PDF, iText");
	    //document.addAuthor(uposlenik.getIme() + " " + uposlenik.getPrezime());
	    //document.addCreator(uposlenik.getIme() + " " + uposlenik.getPrezime());
	}
	
	public static void ispisiTijeloHRMIzvjestaja(Document document, Date Od, Date Do, Uposlenik up) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);
	    
	    SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + (f.format(Od)).toString(), obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + (f.format(Do)).toString(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getIme(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getPrezime(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getJmbg(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getAdresa(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getMjesto(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getTelefon(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(up.getPrivilegija().toString(), obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    HibernateZadatak hz = new HibernateZadatak();
	    List<Zadatak> lz = hz.dajSveZadatke(up);
	    List<Zadatak> lnz = hz.dajSveNezavrseneZadatke(up);
	    
	    c1 = new PdfPCell(new Phrase("Broj aktivnih zadataka:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("" + lz.size() + "", obicniFont));
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
	    
	    int lzz = lz.size() - lnz.size();
	    
	    c1 = new PdfPCell(new Phrase("" + lzz + "", obicniFont));
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
	    
	    double ef = (lzz/lz.size())*100;
	    
	    c1 = new PdfPCell(new Phrase(ef + " %", obicniFont));
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
	    
	    int oc = (int)(ef/10);
	    
	    c1 = new PdfPCell(new Phrase(oc + "/10", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
		
	    table2.setHorizontalAlignment(1);
	    document.add(table2);
	}
	
	public static void ispisiTijeloTehnickogIzvjestaja(Document document, Date Od, Date Do, Uredjaj u) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
	    
	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + (f.format(Od)).toString(), obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + (f.format(Do)).toString(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(u.getJibProizvodaca(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(u.getTipUredaja(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(u.getIbfu(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(u.getIbfm(), obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj trenutnih servisiraja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    HibernateZadatak hz = new HibernateZadatak();
	    HibernateUredjaj hu = new HibernateUredjaj();
	    List<Uredjaj> listaUred = hu.dajSveUredjaje();
	    List<Zadatak> listaZad = hz.dajSveZadatke();
	    int br = 0;
	    
	    for(Uredjaj ur:listaUred)
	    	for(Zadatak z:listaZad)
	    		if(z.getZahtjev().getUredjaj().getIbfu().compareTo(ur.getIbfu()) == 0)
	    			br = br + 1;
	    		
	    c1 = new PdfPCell(new Phrase(br + "", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    HibernateZahtjev hzah = new HibernateZahtjev();
	    List<Zahtjev> listaZah = hzah.dajSveZahtjeve();
	    int bru = 0;
	    
	    for(Uredjaj ur:listaUred)
	    	for(Zahtjev zah:listaZah)
	    		if(zah.getUredjaj().getIbfu().compareTo(ur.getIbfu()) == 0)
	    			bru = bru + 1;
	    
	    c1 = new PdfPCell(new Phrase("Broj zahtjeva za servisiranje:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(bru + "", obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase( "-" + br*5 + "% ratinga", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    if(br != 0 && bru != 0) {
	    	
		    c1 = new PdfPCell(new Phrase("Efikasnost servisa:", boldFont));
		    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			c1.setPaddingBottom(8);
			c1.setPaddingTop(5);
			c1.setPaddingRight(5);
		    table2.addCell(c1);
	    	
		    c1 = new PdfPCell(new Phrase( 100 - (bru - br)*10 + "%", obicniFont));
		    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setPaddingBottom(8);
			c1.setPaddingTop(5);
			c1.setPaddingLeft(5);
		    table2.addCell(c1);
	    }
		    
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
	
	public static void ispisiTijeloKlijentelaIzvjestaja(Document document, Date Od, Date Do, Klijent k) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
	    
	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + (f.format(Od)).toString(), obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + (f.format(Do)).toString(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getNaziv(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getJib(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getTip(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getAdresa(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getMjesto(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getTelefon(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getEmail(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(k.getWeb(), obicniFont));
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
	    
	    HibernateUredjaj hu = new HibernateUredjaj();
	    List<Uredjaj> lsu = hu.dajSveUredjaje(k);
	    String lista = "";
	    
	    for(Uredjaj u:lsu)
	    	lista = lista + u.getTipUredaja() + " - " + u.getIbfu() + "\n";
	    
	    c1 = new PdfPCell(new Phrase(lista, obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    HibernateZahtjev hz = new HibernateZahtjev();
	    List<Zahtjev> lz = hz.dajSveZahtjeve();
	    HibernateZadatak hzad = new HibernateZadatak();
	    List<Zadatak> lzad = hzad.dajSveZadatke();
	    int i = 0;
	    int j = 0;
	    
	    for(Uredjaj u:lsu) {
	    	for(Zahtjev z:lz) {
	    		if(u.getIbfu().compareTo(z.getUredjaj().getIbfu()) == 0)
	    			i = i+1;
	    	}
	    }
	    
	    for(Uredjaj u:lsu) {
	    	for(Zadatak z:lzad) {
	    		if(u.getIbfu().compareTo(z.getZahtjev().getUredjaj().getIbfu()) == 0)
	    			j = j + 1;
	    	}
	    }
	    
	    c1 = new PdfPCell(new Phrase("Broj podnesenih zahtjeva:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(i + "", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Broj servisiranja:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(j + "", obicniFont));
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
	
	public static void ispisiTijeloPoslovanjeIzvjestaja(Document document, Date Od, Date Do) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
	    table.setWidthPercentage(100);

	    SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
	    
	    PdfPCell c1 = new PdfPCell(new Phrase("Od:  " + (f.format(Od)).toString(), obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table.addCell(c1);

	    c1 = new PdfPCell(new Phrase("Do:  " + (f.format(Do)).toString(), obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase("+38733123456", obicniFont));
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
	    
	    HibernateZahtjev hz = new HibernateZahtjev();
	    List<Zahtjev> lz = hz.dajSveZahtjeve();
	    
	    c1 = new PdfPCell(new Phrase("Ukupno primljenih zahtjeva:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(lz.size() + "", obicniFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingLeft(5);
	    table2.addCell(c1);
	    
	    HibernateZadatak hzad = new HibernateZadatak();
	    int br = hzad.dajSveZadatke().size() - hzad.dajSveNezavrseneZadatke().size();
	    
	    c1 = new PdfPCell(new Phrase("Ukupno obavljenih zadataka:", boldFont));
	    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c1.setPaddingBottom(8);
		c1.setPaddingTop(5);
		c1.setPaddingRight(5);
	    table2.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(br + "", obicniFont));
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
	    
	    c1 = new PdfPCell(new Phrase(br*154.43 + " KM", obicniFont));
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
}
