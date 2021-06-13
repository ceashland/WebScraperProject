package gfx.frame;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Frame {

	String title;
	int width, height;
	
	//Just in case I need a jPanel I'll leave a declaration there
	JPanel panel;
	public JFrame frame;
	static Frame mainFrame;
	JMenu menu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuBar menuBar;
	
	//components
	public JScrollPane pane;
	public JTable AttributesTable;
	public GroupLayout gl;
	public Frame(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.frame = new JFrame(this.title);
		this.frame.setSize(width,height);
		this.panel = new JPanel();
		this.panel.setSize(width,height);
		//gl= new GroupLayout(panel);
		//this.panel.setLayout(null);
		menuBar = new JMenuBar();
		
		String[] menuNames = new String[] {"FIle","Edit","Help"};
		String[][] items = new String[menuNames.length][];
		items[0] = new String[] {"New","Open","Save","Close"};
		items[1] = new String[] {};
		items[2] = new String[] {"About", "Manual"};
		
		makeMenuBar(menuBar,menuNames,items);
		this.frame.setJMenuBar(menuBar);
		this.AttributesTable = new JTable(2,2);
		this.pane = new JScrollPane(AttributesTable);
		this.panel.add(pane);
		
		
		
		panel.add(pane);
		pane.setPreferredSize(new Dimension(this.width/3,this.height/3));
		pane.setLocation(150, 150);
		
		
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(panel);
		this.frame.show();
		
		
		
	}
	
	public void makeMenuBar(JMenuBar menuBar, String[] jmenunames, String[][] menuItems) {
		menuBar = new JMenuBar();
		
		ArrayList<JMenu> menuCol = new ArrayList<JMenu>();
		ArrayList<JMenuItem> itemCol = new ArrayList<JMenuItem>();
		
		for(int i = 0; i < jmenunames.length; i++) {
			menuCol.add(new JMenu(jmenunames[i]));
			
			for(int ix = 0; ix < menuItems[i].length; ix++) {
				menuCol.get(i).add(new JMenuItem(menuItems[i][ix]));
			}
		}
		
		
		for(int i = 0; i < menuCol.size(); i++) {
			this.menuBar.add(menuCol.get(i));
		}
	}
}
