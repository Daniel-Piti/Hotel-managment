package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.HotelRepo;
import model.UsersRepo;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class RemoveHotel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void removeHotelForm(HotelRepo h, UsersRepo c, int dark) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveHotel window = new RemoveHotel();
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
	public RemoveHotel() {
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
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(108, 50, 214, 185);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("בחר מלון למחיקה:");
		lblNewLabel_1.setBounds(155, 27, 148, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("מחק!");
		btnNewButton.setBounds(155, 206, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
