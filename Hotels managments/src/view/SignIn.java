package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Customer;
import model.UsersRepo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignIn {

	protected static final UsersRepo UsersRepo = null;
	private JFrame frame;
	private JLabel wellcome;
	private JTextField mailField;
	public UsersRepo customers;
	private JPasswordField passwordField;

	public void signInForm(UsersRepo c, JLabel j, Customer u) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn(c, j, u);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignIn(UsersRepo c, JLabel j, Customer user) {
		customers = c;
		wellcome = j;
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
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(94, 149, 113, 14);
		errorLabel.setForeground(Color.red);
		frame.getContentPane().add(errorLabel);
//check valid user
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField.getPassword().length > 0 && mailField.getText().length() > 0) {
					Customer temp = customers.find(mailField.getText());
					if(temp == null)
						errorLabel.setText("no such an email!");
					else if(!temp.getPass().equals(String.valueOf(passwordField.getPassword()))) {
						errorLabel.setText("worng password");
					}
					else {
						user.duplicate(temp.getFirstName(), temp.getLastName(), temp.getPhone(), temp.getEmail(), temp.getID(), temp.getGender(), temp.getPass(), temp.getDay(), temp.getMonth(), temp.getYear());
						wellcome.setText("Hello " + user.getFirstName());
						errorLabel.setText("");
						JOptionPane.showMessageDialog(null, user.getFirstName() + " thank you for register!"); // CREATES MASSAGE
					}
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
