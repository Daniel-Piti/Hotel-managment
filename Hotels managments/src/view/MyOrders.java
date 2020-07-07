package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MyOrdersController;
import model.Customer;
import model.DarkMode;

public class MyOrders extends DarkMode {

	private JFrame frame;
	private MyOrdersController myOrdersController;
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
//PANELS
	public ArrayList<JPanel> panels = new ArrayList<JPanel>();
	
	public void runMyOrders(int dark, Customer user) {
		EventQueue.invokeLater(() -> {
			try {
				MyOrders window = new MyOrders(dark, user);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MyOrders(int dark, Customer user) {
		myOrdersController = new MyOrdersController(user);
		initialize();
		myOrdersController.setPanels(frame, labels, panels);
		setMode(dark, frame, labels, null, null, panels);
		frame.getContentPane().setLayout(null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
