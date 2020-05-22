package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.UsersRepo;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class start {
	
	
	UsersRepo customers;
	UsersRepo HotelManagers;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start window = new start();
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
	public start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton signInBtn = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn t = new signIn();
				t.signInForm();
			}
		});
		signInBtn.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(signInBtn);
		
		JButton signUpBtn = new JButton("\u05D4\u05E8\u05E9\u05DE\u05D4");
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp t = new signUp();
				t.signUpForm();
			}
		});
		signUpBtn.setBounds(335, 45, 89, 23);
		frame.getContentPane().add(signUpBtn);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	customers.setData();
		    	HotelManagers.setData();
		    }
		});
		
//READ TO FILE
		customers = new UsersRepo("Members/Customers.txt");
		HotelManagers = new UsersRepo("Members/Hotel manegers.txt");
//MANAGE PANELS
		setHotelList();
	}
	
	public void setHotelList() {
		ActionListener listener = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					String text = ((JButton) e.getSource()).getName();
		            JOptionPane.showMessageDialog(null, text);
		        }
			}
		};
		
		File directory=new File("Hotels");
	    int counter = directory.list().length;
	    System.out.println("File Count:"+ counter);
		int i;
		JPanel[] panels = new JPanel[counter];//HOTEL COUNTER
		JLabel[] lbs = new JLabel[counter];
		JButton[] btns = new JButton[counter];
		for(i = 0; i < counter; i++) {
			panels[i] = new JPanel();
			btns[i] = new JButton("Order now!");
			lbs[i]=new JLabel("123");//hotel name
			
			
		    btns[i].addActionListener(listener);
		    btns[i].setName(String.valueOf(i));
		    btns[i].setBounds(50, 50, 100, 100);
		    
		    lbs[i].setPreferredSize(new Dimension(200, 40));
		    btns[i].setPreferredSize(new Dimension(200, 40));
		    
		    panels[i].setBounds(10, i*(100 + 10) + 10, 300, 100);
			panels[i].setBorder(BorderFactory.createLineBorder(Color.black));

			panels[i].add(lbs[i]);
			panels[i].add(btns[i]);
			frame.getContentPane().add(panels[i]);
		}
	}

}
