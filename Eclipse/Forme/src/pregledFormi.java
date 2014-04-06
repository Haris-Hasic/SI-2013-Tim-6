import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class pregledFormi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pregledFormi frame = new pregledFormi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pregledFormi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Menad\u017Eer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmManager frm=new frmManager();
				frm.setVisible(true);
			
				}
			
		});
		btnNewButton.setBounds(10, 38, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin l=new frmLogin();
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 11, 103, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnServiser = new JButton("Serviser");
		btnServiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmServiser ser=new frmServiser();
				ser.setVisible(true);
			}
		});
		btnServiser.setBounds(10, 72, 103, 23);
		contentPane.add(btnServiser);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdministrator admin=new frmAdministrator();
				admin.setVisible(true);
			}
		});
		btnAdministrator.setBounds(10, 106, 103, 23);
		contentPane.add(btnAdministrator);
		
		JButton btnDispatcher = new JButton("Dispatcher");
		btnDispatcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDispatcher dispatch=new frmDispatcher();
				dispatch.setVisible(true);
			}
		});
		btnDispatcher.setBounds(10, 135, 103, 23);
		contentPane.add(btnDispatcher);
	}
}
