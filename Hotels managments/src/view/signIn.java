package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Customer;
import model.UsersRepo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignIn {

	private JFrame frame;
	private JLabel wellcome;
	private JTextField mailField;
	public UsersRepo customers;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public void signInForm(JLabel j) {
		wellcome = j;
		//wellcome.setText("pish-pesh");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		customers = new UsersRepo("Members/Customers.txt");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mailTitle = new JLabel("\u05DE\u05D9\u05D9\u05DC :");
		mailTitle.setBounds(301, 47, 69, 20);
		frame.getContentPane().add(mailTitle);
		
		JLabel passwordTitle = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
		passwordTitle.setBounds(301, 115, 69, 20);
		frame.getContentPane().add(passwordTitle);
		
		mailField = new JTextField();
		mailField.setBounds(73, 44, 146, 26);
		frame.getContentPane().add(mailField);
		mailField.setColumns(10);
		
		JButton signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8 !");
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer c = customers.validUser("Daniel@gmail.com", "pt1234");
				if(c == null) {
					System.out.println("somthing is incorrect!");
				}
				else {
					String str = c.toString(); 
					String[] a = str.split(" ");
					System.out.println(a[0] + " u r loged in!");
				}
			}
		});
		signInBtn.setBounds(73, 174, 146, 29);
		frame.getContentPane().add(signInBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 112, 146, 26);
		frame.getContentPane().add(passwordField);
	}
}
