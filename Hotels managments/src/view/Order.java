package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Hotel;

public class Order {

	private JFrame frame;
	private Hotel hotel;
	public void orderForm(Hotel h) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order(h);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Order(Hotel h) {
		hotel = h;
		System.out.println(hotel.toString());
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
