package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MyOrdersController;
import model.Customer;
import model.DarkFlag;
import model.DarkMode;

public class MyOrders extends DarkMode {

	private JFrame frame;
	private MyOrdersController myOrdersController;
//JLABLES
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
//PANELS
	public ArrayList<JPanel> panels = new ArrayList<JPanel>();
//BTNS
	public ArrayList<JButton> btns = new ArrayList<JButton>();
	
	public void runMyOrders(Customer user) {
		EventQueue.invokeLater(() -> {
			try {
				MyOrders window = new MyOrders(user);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MyOrders(Customer user) {
		myOrdersController = new MyOrdersController(user);
		initialize();
		myOrdersController.setPanels(frame, labels, panels, btns);
		setMode(DarkFlag.getInstance(), frame, labels, null, null, panels);
		frame.getContentPane().setLayout(null);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
