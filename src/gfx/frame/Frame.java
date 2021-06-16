package gfx.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;

import architexture.Tag;

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
	JButton executeButton;
	JTree tagHierarchy;
	
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
		BorderLayout border = new BorderLayout();
		this.panel.setLayout(border);
		
		menuBar = new JMenuBar();
		this.executeButton = new JButton("Execute");
		
		String[] menuNames = new String[] {"FIle","Edit","Help"};
		String[][] items = new String[menuNames.length][];
		items[0] = new String[] {"New Web Scrape","New Dictation","Open","Save","Preferences","Close"};
		items[1] = new String[] {};
		items[2] = new String[] {"About", "Manual"};
		
		makeMenuBar(menuBar,menuNames,items);
		this.frame.setJMenuBar(menuBar);
		this.AttributesTable = makeTable(new String[]{"Name","Value"},new String[][] {new String[] {"Test","Test2"},new String[] {"foo","bar"}});
	
		this.pane = new JScrollPane(AttributesTable);
		
		JLabel urlLabel = new JLabel("URL:");
		JTextField urlField = new JTextField();
		urlField.setEditable(true);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(BorderFactory.createTitledBorder("Attributes"));
		westPanel.setLayout(new BoxLayout(westPanel,BoxLayout.Y_AXIS));
		this.panel.add(westPanel,BorderLayout.WEST);
		
		//attrLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		//westPanel.getComponent(0).set;
		
		westPanel.add(AttributesTable);
		
		//this.panel.add(urlLabel, BorderLayout.NORTH);
		JPanel topPanel = new JPanel();
		
		
		//East Section
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		panel.add(eastPanel, "East");
		eastPanel.setPreferredSize(new Dimension(200,height));
		eastPanel.setBorder(BorderFactory.createTitledBorder("Website Hierarchy"));
		if(Tag.site != null) {
		tagHierarchy = websiteToJTree(Tag.site);
		}else {
			System.out.println("Site is null...");
		}
		JScrollPane scPane = new JScrollPane(tagHierarchy);
		eastPanel.add(scPane,BorderLayout.CENTER);
		
		
		GridBagLayout topFlow = new GridBagLayout();
		GridBagConstraints topCon = new GridBagConstraints();
		topPanel.setLayout(topFlow);
		
		this.panel.add(topPanel,BorderLayout.NORTH);
		topCon.weightx = topCon.weighty = 0;
		topCon.weightx = 3;
		topPanel.add(urlLabel,topCon);
		topCon.fill = GridBagConstraints.BOTH;
		topCon.weightx = 50;
		topCon.gridwidth = 3;
		topCon.gridx = 2;
		topPanel.add(urlField,topCon);
	
		//topCon.weightx = topCon.weighty = 0;
		//topCon.fill = GridBagConstraints.HORIZONTAL;
		//topCon.weightx = 5;
		urlField.setEnabled(false);
		executeButton.setEnabled(false);
		topPanel.add(executeButton);
		
		
		
		panel.add(pane);
		pane.setPreferredSize(new Dimension(this.width/3,this.height/3));
		pane.setLocation(150, 150);
		
		
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.add(panel);
		this.frame.show();
		
		
		
	}
	
	public JTable makeTable(String[] headers, String[][] data) {
		JTable table = null;
		
		//headers = the column names
		
		/**
		 * Data = 
		 * 
		 */
		
		if(data != null) {
			if(data.length > 0) {
				table = new JTable(data[0].length,headers.length);
				
				JTableHeader th = table.getTableHeader();
				TableColumnModel tcm = th.getColumnModel();
				
				
				for(int i = 0; i < headers.length; i++) {
					TableColumn tc = tcm.getColumn(i);
					tc.setHeaderValue(headers[i]);	
				}
				
				
				for(int i = 0; i < data.length;i++) {
					for(int ix = 0; ix < data[i].length; ix++) {
						
						//if(data[i].length < data[i])
						table.getModel().setValueAt(data[i][ix], ix, i);
					}
				}
				th.repaint();
				
			}
		}
		
		
		
		
		
		
		return table;
	}
	
	public JTree websiteToJTree(Tag[] website) {
		JTree tree = null;
		
		DefaultMutableTreeNode origin = null;
		DefaultMutableTreeNode parent = null;
		DefaultMutableTreeNode child = null;
		
		origin = new DefaultMutableTreeNode("Website");
		boolean[] added = new boolean[website.length];
		for(int i = 0; i < website.length; i++) {
			
			if(added[i] != true) {
				if(website[i].isParent) {
					parent = new DefaultMutableTreeNode(website[i].type);
					Tag tempTag = website[i];
					System.out.println(website[i].toString());
					for(int ix = 0; ix < tempTag.children.length;ix ++) {
						child = new DefaultMutableTreeNode(tempTag.children[ix].type);
						added[tempTag.children[ix].tagIndex] = true;
						parent.add(child);
					}
					origin.add(parent);
					added[i] = true;
				}else {
					parent = new DefaultMutableTreeNode(website[i].type);
					origin.add(parent);
					added[i] = true;
				}
			}
			
			
			origin.add(parent);
		}
		
		tree = new JTree(origin);
		//tree.add(parent);
		
		return tree;
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
