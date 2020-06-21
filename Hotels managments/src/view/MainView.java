package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.MainController;
import model.DarkMode;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainView {
	private MainController mainController;
	
	private JFrame frame;
	private JButton signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");		
	private JButton signUpBtn = new JButton("\u05D4\u05E8\u05E9\u05DE\u05D4");
	private JLabel wellcome = new JLabel("Hello guest !");
	private JButton disconnectBtn = new JButton("\u05D4\u05EA\u05E0\u05EA\u05E7");
	private JRadioButton darkModeRadio = new JRadioButton("Dark mode");		
	private JRadioButton lightMode = new JRadioButton("Light mode");
//DarkFlag
	private int darkFlag = 0;
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
		new DarkMode(0, frame, labels, btns, radioBtns, panels);
	}

//Initialize the contents of the frame.
	private void setUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		signInBtn.setBounds(410, 19, 110, 23);
		frame.getContentPane().add(signInBtn);
		btns.add(signInBtn);
		
		signUpBtn.setBounds(410, 72, 110, 23);
		frame.getContentPane().add(signUpBtn);
		btns.add(signUpBtn);
		
		wellcome.setBounds(430, 153, 89, 44);
		frame.getContentPane().add(wellcome);
		labels.add(wellcome);
		
		disconnectBtn.setBounds(410, 129, 110, 23);
		frame.getContentPane().add(disconnectBtn);
		disconnectBtn.setVisible(false);
		btns.add(disconnectBtn);
		
		lightMode.setSelected(true);
		lightMode.setBounds(417, 209, 155, 29);
		frame.getContentPane().add(lightMode);
		radioBtns.add(lightMode);
		
		darkModeRadio.setBounds(417, 273, 155, 29);
		frame.getContentPane().add(darkModeRadio);
		radioBtns.add(darkModeRadio);
}

//Event listeners
	public void listeners() {
	//Sign in
		signInBtn.addActionListener((ActionEvent e) -> {
			mainController.loadSignIn(wellcome, signInBtn, signUpBtn, disconnectBtn);
		});
	//Sign up
		signUpBtn.addActionListener((ActionEvent e) -> {
			mainController.loadSignUp(wellcome, signInBtn, signUpBtn, disconnectBtn);
		});
	//Disconnect
		disconnectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainController.resetUser();
				wellcome.setText("Hello guest!");
				signInBtn.setVisible(true);
				signUpBtn.setVisible(true);
				disconnectBtn.setVisible(false);
			}
		});
	//Dark radio
		darkModeRadio.addActionListener((ActionEvent e) -> {
			if(darkFlag == 0) {
				new DarkMode(1, frame, labels, btns, radioBtns, panels);
				darkModeRadio.setSelected(true);
				lightMode.setSelected(false);
				mainController.setDarkFlag(1);
				darkFlag = 1;
			}
			darkModeRadio.setSelected(true);
		});
	//Light radio
		lightMode.addActionListener((ActionEvent e) -> {
			if(darkFlag == 1) {
				new DarkMode(0, frame, labels, btns, radioBtns, panels);
				darkModeRadio.setSelected(false);
				lightMode.setSelected(true);
				mainController.setDarkFlag(0);
				darkFlag = 0;
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
