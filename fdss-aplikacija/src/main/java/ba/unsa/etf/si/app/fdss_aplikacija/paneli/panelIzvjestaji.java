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
}
