package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.MainController;
import model.DarkFlag;
import model.DarkMode;

public class MainView extends DarkMode {
	private MainController mainController;
	
	private JFrame frame;
	private JButton signInBtn = new JButton("Sign in");		
	private JButton signUpBtn = new JButton("Sign up");
	private JLabel wellcome = new JLabel("Hello guest !");
	private JButton disconnectBtn = new JButton("Disconnect");
	private JButton myOrders = new JButton();
	private JButton editDetails = new JButton("Edit Details");
	private JRadioButton darkModeRadio = new JRadioButton("Dark mode");		 
	private JRadioButton lightMode = new JRadioButton("Light mode");
//BUTTONS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
//RADIO BTNS
	public ArrayList<JRadioButton> radioBtns = new ArrayList<JRadioButton>();
//PANELS
	public ArrayList<JPanel> panels = new ArrayList<JPanel>();
	
//Launch the application.
	public void runMain() {
		EventQueue.invokeLater(()->{
			try {
				MainView window = new MainView();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

//Load the application.
	public MainView() {
		mainController = new MainController();
		setUI();
		listeners();
		mainController.loadHotelList(frame, btns, labels, panels);//HOTEL PANELS MANAGMENTS
		frame.setBounds(100, 100, 549, getLen());
		setMode(0, frame, labels, btns, radioBtns, panels);
	}

	public int getLen() {
		int len = panels.size() * 180;
		if(len <= 180)
			len = 400;
		if(len >= 900)
			len = 900;
		return len;
	}
//Initialize the contents of the frame.
	private void setUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		signInBtn.setBounds(410, 83, 110, 23);
		frame.getContentPane().add(signInBtn);
		btns.add(signInBtn);
		
		signUpBtn.setBounds(410, 135, 110, 23);
		frame.getContentPane().add(signUpBtn);
		btns.add(signUpBtn);
		
		myOrders.setBounds(410, 165, 110, 23);
		myOrders.setText("My orders");
		myOrders.setVisible(false);
		frame.getContentPane().add(myOrders);
		btns.add(myOrders);
		
		wellcome.setBounds(431, 31, 89, 44);
		frame.getContentPane().add(wellcome);
		labels.add(wellcome);
		
		disconnectBtn.setBounds(410, 122, 110, 23);
		frame.getContentPane().add(disconnectBtn);
		disconnectBtn.setVisible(false);
		btns.add(disconnectBtn);
		
		lightMode.setSelected(true);
		lightMode.setBounds(410, 235, 155, 29);
		frame.getContentPane().add(lightMode);
		radioBtns.add(lightMode);
		
		darkModeRadio.setBounds(410, 285, 155, 29);
		frame.getContentPane().add(darkModeRadio);
		radioBtns.add(darkModeRadio);
		
		editDetails.setBounds(410, 210, 110, 23);
		frame.getContentPane().add(editDetails);
		btns.add(editDetails);
		editDetails.setVisible(false);
	}

//Event listeners
	public void listeners() {
		
		editDetails.addActionListener((ActionEvent e) -> {
			mainController.loadEditDetails();
		});
		
//Sign in
		signInBtn.addActionListener((ActionEvent e) -> {
			mainController.loadSignIn(wellcome, signInBtn, signUpBtn, disconnectBtn, myOrders, editDetails);
		});
//Sign up
		signUpBtn.addActionListener((ActionEvent e) -> {
			mainController.loadSignUp(wellcome, signInBtn, signUpBtn, disconnectBtn, myOrders, editDetails);
		});
//My orders
		myOrders.addActionListener((ActionEvent e) -> {
			mainController.loadMyOrders();
		});
//Disconnect
		disconnectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainController.resetUser();
				wellcome.setText("Hello guest!");
				signInBtn.setVisible(true);
				signUpBtn.setVisible(true);
				disconnectBtn.setVisible(false);
				myOrders.setVisible(false);
				editDetails.setVisible(false);
			}
		});
//Dark radio
		darkModeRadio.addActionListener((ActionEvent e) -> {
			if(DarkFlag.getInstance() == 0) {
				
				setMode(1, frame, labels, btns, radioBtns, panels);
				darkModeRadio.setSelected(true);
				lightMode.setSelected(false);
				DarkFlag.setValue(1);
			}
			darkModeRadio.setSelected(true);
		});
//Light radio
		lightMode.addActionListener((ActionEvent e) -> {
			if(DarkFlag.getInstance() == 1) {
				setMode(0, frame, labels, btns, radioBtns, panels);
				darkModeRadio.setSelected(false);
				lightMode.setSelected(true);
				DarkFlag.setValue(0);
			}
			lightMode.setSelected(true);
		});
//Close
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	mainController.saveData();
		    }
		});
	}
}
