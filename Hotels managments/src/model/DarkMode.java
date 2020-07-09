package model;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class DarkMode{
	
	public void setMode(int flag, JFrame frame, ArrayList<JLabel> texts, ArrayList<JButton> buttons, ArrayList<JRadioButton> radios, ArrayList<JPanel> panels) {
		if(flag == 0)
			setLightMode(frame, texts, buttons, radios, panels);
		else
			setDarkMode(frame, texts, buttons, radios, panels);
	}
	
	public void setDarkMode(JFrame frame, ArrayList<JLabel> texts, ArrayList<JButton> buttons, ArrayList<JRadioButton> radios, ArrayList<JPanel> panels) {
		int i;
		if(texts!=null)
			for(i = 0; i < texts.size(); i++)
				texts.get(i).setForeground(Color.white);
		if(buttons!=null)
			for(i = 0; i < buttons.size(); i++) {
				buttons.get(i).setBackground(Color.darkGray);
				buttons.get(i).setBorder(new LineBorder(Color.white, 1, false));
				buttons.get(i).setForeground(Color.white);
			}
		if(radios!=null)
			for(i = 0; i < radios.size(); i++) {
				radios.get(i).setBackground(Color.darkGray);
				radios.get(i).setForeground(Color.white);
			}
		if(panels!=null)
			for(i = 0; i < panels.size(); i++) {
				panels.get(i).setBackground(Color.darkGray);
				panels.get(i).setBorder(new LineBorder(Color.white, 1, false));
			}
			
		frame.getContentPane().setBackground(Color.darkGray);
	}
	
	public void setLightMode(JFrame frame, ArrayList<JLabel> texts, ArrayList<JButton> buttons, ArrayList<JRadioButton> radios, ArrayList<JPanel> panels) {
		int i;
		if(texts!=null)
			for(i = 0; i < texts.size(); i++) {
				texts.get(i).setForeground(Color.darkGray);
			}
		if(buttons!=null)
			for(i = 0; i < buttons.size(); i++) {
				buttons.get(i).setBackground(Color.lightGray);
				buttons.get(i).setBorder(new LineBorder(Color.black, 1, false));
				buttons.get(i).setForeground(Color.black);
			}
		if(radios!=null)
			for(i = 0; i < radios.size(); i++) {
				radios.get(i).setBackground(Color.white);
				radios.get(i).setForeground(Color.darkGray);
			}
		if(panels!=null)
			for(i = 0; i < panels.size(); i++) {
				panels.get(i).setBackground(Color.white);
				panels.get(i).setBorder(new LineBorder(Color.darkGray, 1, false));	
			}
			
		frame.getContentPane().setBackground(Color.white);
	}
}