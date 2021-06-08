package gfx.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {

	String title;
	int width, height;
	
	//Just in case I need a jPanel I'll leave a declaration there
	JPanel panel;
	public JFrame frame;
	static Frame mainFrame;
	
	public Frame(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.frame = new JFrame(this.title);
		this.frame.setSize(width,height);
		this.panel = new JPanel();
		this.panel.setSize(width,height);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(panel);
		this.frame.show();
		
		
		
	}
	
}
