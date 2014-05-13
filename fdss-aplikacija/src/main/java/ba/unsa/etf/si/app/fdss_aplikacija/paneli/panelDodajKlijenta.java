package ba.unsa.etf.si.app.fdss_aplikacija.paneli;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JSeparator;

public class panelDodajKlijenta extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public panelDodajKlijenta() {
		setBorder(BorderFactory.createTitledBorder("Dodaj klijenta:"));
		
		JLabel lblNaziv = new JLabel("Naziv:");
		lblNaziv.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblJib = new JLabel("JIB:");
		lblJib.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTip = new JLabel("Tip:");
		lblTip.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel = new JLabel("Mjesto:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JButton btnDodajKlijenta = new JButton("Dodaj klijenta");
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(11)
										.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblTip, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNaziv, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblWeb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresa, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblJib, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addComponent(textField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addComponent(textField_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_6, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(btnDodajKlijenta))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNaziv)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTip))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJib))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdresa))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeb))
					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnDodajKlijenta))
		);
		setLayout(groupLayout);
//		TitledBorder border=(TitledBorder)getBorder();
//		border.setTitleFont(new Font("Tahoma", Font.PLAIN, 11));
		
	}
}
