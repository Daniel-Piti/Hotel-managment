package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Customer;
import model.Hotel;
import model.HotelRepo;
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
	private HotelRepo hotelist;
	JButton signInBtn;
	private JLabel errorLabel;
	private JButton startInBtn;
	private JButton startUpBtn;
	private JButton startDisBtn;

	public void signInForm(UsersRepo c, JLabel j, Customer u, HotelRepo h, JButton in, JButton up, JButton dis) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn(c, j, u, h, in, up, dis);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SignIn(UsersRepo c, JLabel j, Customer user, HotelRepo h, JButton in, JButton up, JButton dis) {
		startInBtn = in;
		startUpBtn = up;
		startDisBtn = dis;
		hotelist = h;
		customers = c;
		wellcome = j;
		setUI();
//check valid user
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField.getPassword().length > 0 && mailField.getText().length() > 0) {
				//PROJECT MASTER
					if(String.valueOf(passwordField.getPassword()).equals("alpha") && mailField.getText().equals("alpha")) {
						AddHotel a = new AddHotel(hotelist, customers);
						a.addHotelform(hotelist, customers);
						frame.dispose();
					}
				//HOTEL MANAGER
					else {
						Hotel ho = hotelist.find(mailField.getText());
						if(ho != null && ho.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
							EditHotel a = new EditHotel(ho);
							a.editHotelForm(ho);
							frame.dispose();
						}
						else {
				//NORMAL USER
							Customer temp = customers.find(mailField.getText());
							if(temp == null) {
								errorLabel.setText("no such an email of users!");
							}
							else if(!temp.getPass().equals(String.valueOf(passwordField.getPassword()))) {
								errorLabel.setText("worng password");
							}
							else {
								user.duplicate(temp.getFirstName(), temp.getLastName(), temp.getPhone(), temp.getEmail(), temp.getID(), temp.getGender(), temp.getPass(), temp.getDay(), temp.getMonth(), temp.getYear());
								wellcome.setText("Hello again " + user.getFirstName());
								wellcome.setForeground(Color.blue);
								startDisBtn.setVisible(true);
								startInBtn.setVisible(false);
								startUpBtn.setVisible(false);
								frame.dispose();
							}
						}
					}
				}
			}
		});
	}

	public void setUI() {
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
		
		signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8 !");
		errorLabel = new JLabel("");
		errorLabel.setBounds(94, 149, 197, 14);
		errorLabel.setForeground(Color.red);
		frame.getContentPane().add(errorLabel);

		signInBtn.setBounds(73, 174, 146, 29);
		frame.getContentPane().add(signInBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 112, 146, 26);
		frame.getContentPane().add(passwordField);	
	}

}
