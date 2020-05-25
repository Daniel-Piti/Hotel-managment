package view;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Customer;
import model.HotelRepo;
import model.UsersRepo;
import model.Validation;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class SignUp {
	private JFrame frame;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneField;
	private JTextField mailField;
	private JTextField idField;
	private JPasswordField passwordField;
	
	private JRadioButton maleRadio = new JRadioButton("\u05D6\u05DB\u05E8");
	private JRadioButton femaleRadio = new JRadioButton("\u05E0\u05E7\u05D1\u05D4");

	private JLabel firstNameLabel = new JLabel("");
	private JLabel LastNameLabel = new JLabel("");
	private JLabel phoneNumberLabel = new JLabel("");
	private JLabel mailLabel = new JLabel("");
	private JLabel dateLabel = new JLabel("");
	private JLabel passwordLabel = new JLabel("");
	private JLabel idLabel = new JLabel("");
	
	private JButton signUpBtn = new JButton("\u05D4\u05E8\u05E9\u05DD");
	
	private JComboBox<String> yearField = new JComboBox<>();
	private JComboBox<String> monthField = new JComboBox<>();
	private JComboBox<String> dayField = new JComboBox<>();
	
	public UsersRepo customers;
	public HotelRepo hotels;
	
	public void signUpForm(UsersRepo c, HotelRepo h) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp(c, h);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp(UsersRepo c, HotelRepo h) {
		hotels = h;
		customers = c;
		setUI();
		btnsEvents();
	}
  
    boolean isValidDate(int d, int m, int y) 
    {
        if (m == 2)  
            if ((((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0))) 
                return (d <= 29); 
            else
                return (d <= 28); 
        if (m == 4 || m == 6 || m == 9 || m == 11) 
            return (d <= 30); 
  
        return true; 
    }

    private void setUI() {
    	JLabel signUpTitle = new JLabel("\u05D4\u05E8\u05E9\u05DE\u05D4 :");
    	JLabel firstNameTitle = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9 :");
    	JLabel lastNameTitle = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4 :");
    	JLabel phoneTitle = new JLabel("\u05E4\u05DC\u05D0\u05E4\u05D5\u05DF :");
    	JLabel mailTitle = new JLabel("\u05DE\u05D9\u05D9\u05DC :");
    	JLabel idTitle = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA :");
    	JLabel genderTitle = new JLabel("\u05DE\u05D9\u05DF :");
    	JLabel passwordTitle = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 :");
    	JLabel birthDayTitle = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05DC\u05D9\u05D3\u05D4 :");

    	frame = new JFrame();
		frame.setBounds(100, 100, 452, 585);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		signUpTitle.setBounds(179, 39, 65, 14);
		frame.getContentPane().add(signUpTitle);
		
		firstNameTitle.setBounds(334, 95, 80, 14);
		frame.getContentPane().add(firstNameTitle);
		
		lastNameTitle.setBounds(334, 132, 80, 14);
		frame.getContentPane().add(lastNameTitle);
		
		phoneTitle.setBounds(334, 168, 80, 14);
		frame.getContentPane().add(phoneTitle);
		
		mailTitle.setBounds(334, 204, 80, 14);
		frame.getContentPane().add(mailTitle);
		
		idTitle.setBounds(334, 243, 80, 14);
		frame.getContentPane().add(idTitle);
		
		genderTitle.setBounds(334, 286, 80, 14);
		frame.getContentPane().add(genderTitle);
		
		passwordTitle.setBounds(334, 329, 80, 14);
		frame.getContentPane().add(passwordTitle);
		
		birthDayTitle.setBounds(334, 368, 80, 14);
		frame.getContentPane().add(birthDayTitle);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(219, 92, 86, 20);
		firstNameField.setColumns(10);
		frame.getContentPane().add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(219, 129, 86, 20);
		frame.getContentPane().add(lastNameField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(219, 165, 86, 20);
		frame.getContentPane().add(phoneField);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(219, 201, 86, 20);
		frame.getContentPane().add(mailField);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(219, 240, 86, 20);
		frame.getContentPane().add(idField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 326, 86, 20);
		frame.getContentPane().add(passwordField);
		
		maleRadio.setBounds(263, 284, 48, 23);
		frame.getContentPane().add(maleRadio);
		
		femaleRadio.setBounds(202, 283, 57, 23);
		frame.getContentPane().add(femaleRadio);

		femaleRadio.setSelected(true);
		
		firstNameLabel.setBounds(74, 95, 112, 14);
		frame.getContentPane().add(firstNameLabel);
		firstNameLabel.setForeground(Color.red);

		LastNameLabel.setBounds(74, 132, 112, 14);
		frame.getContentPane().add(LastNameLabel);
		LastNameLabel.setForeground(Color.red);
		
		phoneNumberLabel.setBounds(74, 171, 140, 14);
		frame.getContentPane().add(phoneNumberLabel);
		phoneNumberLabel.setForeground(Color.red);
		
		mailLabel.setBounds(74, 204, 112, 14);
		frame.getContentPane().add(mailLabel);
		mailLabel.setForeground(Color.red);
		
		dateLabel.setBounds(150, 396, 112, 14);
		frame.getContentPane().add(dateLabel);
		dateLabel.setForeground(Color.red);

		passwordLabel.setBounds(74, 329, 112, 14);
		frame.getContentPane().add(passwordLabel);
		passwordLabel.setForeground(Color.red);

		
		idLabel.setBounds(74, 243, 112, 14);
		frame.getContentPane().add(idLabel);
		idLabel.setForeground(Color.red);
		int i;

		yearField.addItem("Year");
		
		for(i=1;i<=120;i++)
			yearField.addItem(Integer.toString(2021-i));
		
		yearField.setBounds(240, 365, 65, 20);
		frame.getContentPane().add(yearField);
		
		monthField.setBounds(153, 365, 75, 20);
		frame.getContentPane().add(monthField);
		monthField.addItem("Month");
		
		for(i=1;i<=12;i++)
			monthField.addItem(Integer.toString(i));
		
		dayField.setBounds(74, 365, 57, 20);
		frame.getContentPane().add(dayField);
		
		dayField.addItem("Day");
		for(i=1;i<=31;i++)
			dayField.addItem(Integer.toString(i));
		
		signUpBtn.setBounds(130, 464, 150, 50);
		frame.getContentPane().add(signUpBtn, 65, 20);
		frame.getContentPane().add(monthField);
    }
	
    private void btnsEvents() {
    //RADIO MALE
		maleRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maleRadio.setSelected(true);
				femaleRadio.setSelected(false);
			}
		});
	//RADIO FEMALE
		femaleRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maleRadio.setSelected(false);
				femaleRadio.setSelected(true);
			}
		});
	//SAVE BUTTON
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				Validation v = new Validation();
				
	//check first
				if(!v.validName(firstNameField.getText(), firstNameLabel))
					flag = false;
	//check lastname
				if(!v.validName(lastNameField.getText(), LastNameLabel))
					flag = false;
								
	//check phonenumber
				if(!v.validPhone(phoneField.getText(), phoneNumberLabel))
					flag = false;
	//check mail
				if(!v.validEmail(mailField.getText(), mailLabel))
					flag = false;
				
				if(customers.emailUsed(mailField.getText()) || hotels.emailUsed(mailField.getText())) {
					mailLabel.setText("Email allready used");
					flag = false;
				}
	//check ID
				if(!v.validID(idField.getText(), idLabel))
					flag = false;
	//check Password
				if(!v.validPassword(passwordField.getPassword(), passwordLabel))
					flag = false;
	//check date
				if(!v.validDate(dayField.getSelectedIndex(), monthField.getSelectedIndex(), yearField.getSelectedIndex(), dateLabel))
					flag = false;
				
				if(flag) {
					boolean gen = true;
					if(femaleRadio.isSelected())
						gen = false;
					customers.addUser(new Customer(firstNameField.getText(), lastNameField.getText(), phoneField.getText(), mailField.getText(),
							 idField.getText(), gen, new String(passwordField.getPassword()), dayField.getSelectedIndex(),
							 monthField.getSelectedIndex(), 2021 - yearField.getSelectedIndex()));
					JOptionPane.showMessageDialog(null, firstNameField.getText() + " thank you for register!"); // CREATES MASSAGE
				}
			}
		});
	}
}
