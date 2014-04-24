package paneli;

import javax.swing.BorderFactory;
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

public class panelIzvjestaji extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public panelIzvjestaji() {
		setBorder(BorderFactory.createTitledBorder("Kreiranje izvje\u0161taja"));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tehni\u010Dki izvje\u0161taj");
		rdbtnNewRadioButton.setSelected(true);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblIbfu = new JLabel("IBFU:");
		lblIbfu.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JRadioButton rdbtnHrmIzvjetaj = new JRadioButton("HRM izvje\u0161taj");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("Od:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel("Do:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblKorisnik = new JLabel("Korisnik:");
		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JComboBox comboBox = new JComboBox();
		
		JRadioButton rdbtnPoslovniIzvjetaj = new JRadioButton("Poslovni izvje\u0161taj");
		
		JLabel label_2 = new JLabel("Od:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel label_3 = new JLabel("Do:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Kreiraj izvje\u0161taj");
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(lblOd, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(lblDo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(lblIbfu, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(rdbtnHrmIzvjetaj, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblKorisnik, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(rdbtnPoslovniIzvjetaj, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(310, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(rdbtnNewRadioButton)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblOd))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDo))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblIbfu))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(rdbtnHrmIzvjetaj)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblKorisnik))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(rdbtnPoslovniIzvjetaj)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton))
		);
		setLayout(groupLayout);

	}
}
