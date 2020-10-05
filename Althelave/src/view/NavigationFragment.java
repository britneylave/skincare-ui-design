package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import util.Helper;

public class NavigationFragment extends JPanel implements MouseListener, ActionListener{
	
	private JMenuBar menuBar;
	private JMenu brandMenu, basicMenu, innisfreeMenu;
	private JMenuItem caudalieItem, laneigeItem, innisfreeSkincareItem, innisfreeBodycareItem;
	private Helper helper;
	private JSeparator innisfreeSeparator, caudalieSeparator, skincareSeparator;
	private Color SEPARATOR_COLOR = new Color(255, 208, 223);
	private JFrame home;

	public NavigationFragment(JFrame home) {
		this.home = home;
		UIManager.put("PopupMenu.border", new LineBorder(new Color(220, 177, 191), 2));
		UIManager.put("Menu.selectionBackground", new Color(255,238,242));
		UIManager.put("MenuItem.selectionBackground", new Color(255,238,242));
		helper = Helper.getInstance();
		setLayout(new BorderLayout());
		initializeObjects();
		makeNavigationBar();
	}
	
	private void initializeObjects() {
		innisfreeSeparator = new JSeparator();
		innisfreeSeparator.setBorder(BorderFactory.createLineBorder(SEPARATOR_COLOR));
		caudalieSeparator = new JSeparator();
		caudalieSeparator.setBorder(BorderFactory.createLineBorder(SEPARATOR_COLOR));
		skincareSeparator = new JSeparator();
		skincareSeparator.setBorder(BorderFactory.createLineBorder(SEPARATOR_COLOR));
		
		menuBar = new JMenuBar();
		menuBar.setLayout(new GridBagLayout());
		brandMenu = createMenu(helper.getString("Brands", 11, ""));
		brandMenu.setMnemonic(KeyEvent.VK_B);
		
		basicMenu = createMenu(helper.getString("Skincare Guide for Beginner", 11, ""));
		
		innisfreeMenu = createMenu(helper.getString("Innisfree", 11, ""));
		innisfreeMenu.setBackground(helper.DEFAULT_PINK_BG);
		innisfreeMenu.setOpaque(true);
		
		innisfreeSkincareItem = createJMenuItem(helper.getString("Skin Care Line", 11, ""));
		innisfreeSkincareItem.setMnemonic(KeyEvent.VK_S);
		innisfreeSkincareItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
		innisfreeSkincareItem.addActionListener(this);
		
		innisfreeBodycareItem = createJMenuItem(helper.getString("Body Care Line", 11, ""));
		innisfreeBodycareItem.setMnemonic(KeyEvent.VK_B);
		innisfreeBodycareItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
		innisfreeBodycareItem.addActionListener(this);
		
		caudalieItem = createJMenuItem(helper.getString("Caudalie", 11, ""));
		caudalieItem.setMnemonic(KeyEvent.VK_C);
		caudalieItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
		caudalieItem.addActionListener(this);
		
		laneigeItem = createJMenuItem(helper.getString("Laneige", 11, ""));
		laneigeItem.setMnemonic(KeyEvent.VK_L);
		laneigeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
		laneigeItem.addActionListener(this);
		
		innisfreeMenu.add(innisfreeSkincareItem);
		innisfreeMenu.add(skincareSeparator);
		innisfreeMenu.add(innisfreeBodycareItem);
		
		brandMenu.add(innisfreeMenu);
		brandMenu.add(innisfreeSeparator);
		brandMenu.add(caudalieItem);
		brandMenu.add(caudalieSeparator);
		brandMenu.add(laneigeItem);
		
		menuBar.add(brandMenu);
		menuBar.add(basicMenu);
	}
	
	private JMenuItem createJMenuItem(String menuItemName){
		JMenuItem menuItem = new JMenuItem(menuItemName);
		menuItem.setPreferredSize(new Dimension(230, 40));
		menuItem.setBackground(helper.DEFAULT_PINK_BG);
		menuItem.addMouseListener(this);
		menuItem.setIcon(helper.getImg("right_arrow.png", 10, 10));
		return menuItem;
	}
	
	private JMenu createMenu(String menuName){
		JMenu menu = new JMenu(menuName);
		menu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		menu.addMouseListener(this);
		return menu;
	}

	private void makeNavigationBar() {
		menuBar.setBackground(helper.DEFAULT_PINK_BG);
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		add(menuBar, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setMenuColor(e, brandMenu, true);
		setMenuColor(e, basicMenu, true);
		setMenuColor(e, innisfreeMenu, true);
		setMenuColor(e, caudalieItem, true);
		setMenuColor(e, innisfreeBodycareItem, true);
		setMenuColor(e, innisfreeSkincareItem, true);
		setMenuColor(e, laneigeItem, true);
	}

	private void setMenuColor(MouseEvent e, JMenu m, boolean b) {
		if(e.getSource() == m && b){
			m.setForeground(Color.white);
			home.setCursor(Cursor.HAND_CURSOR);
		} else if(!b){
			m.setForeground(Color.black);
			home.setCursor(Cursor.DEFAULT_CURSOR);
		}
	}
	
	private void setMenuColor(MouseEvent e, JMenuItem m, boolean b) {
		if(e.getSource() == m && b)
			home.setCursor(Cursor.HAND_CURSOR);
		else if(!b)
			home.setCursor(Cursor.DEFAULT_CURSOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setMenuColor(e, brandMenu, false);
		setMenuColor(e, basicMenu, false);
		setMenuColor(e, innisfreeMenu, false);
		setMenuColor(e, caudalieItem, false);
		setMenuColor(e, innisfreeBodycareItem, false);
		setMenuColor(e, innisfreeSkincareItem, false);
		setMenuColor(e, laneigeItem, false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == innisfreeSkincareItem){
			home.dispose();
			new ViewProductsFrame(home, "Innisfree", "skin");
		}else if(e.getSource() == innisfreeBodycareItem){
			home.dispose();
			new ViewProductsFrame(home, "Innisfree", "body");
		}else if(e.getSource() == caudalieItem){
			home.dispose();
			new ViewProductsFrame(home, "Caudalie", "");
		}else if(e.getSource() == laneigeItem){
			home.dispose();
			new ViewProductsFrame(home, "Laneige", "");
		}else if(e.getSource() == basicMenu){
			int result = JOptionPane.showOptionDialog(null, helper.getString("Open Skincare Guide Beginner in Browser?", 11, ""), 
					"Al The Lave", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					null, null);
			if(result == JOptionPane.YES_OPTION)
				try {
					Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=tkjWvigs9q8"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == innisfreeSkincareItem){
			home.dispose();
			new ViewProductsFrame(home, "Innisfree", "skin");
		}else if(e.getSource() == innisfreeBodycareItem){
			home.dispose();
			new ViewProductsFrame(home, "Innisfree", "body");
		}else if(e.getSource() == caudalieItem){
			home.dispose();
			new ViewProductsFrame(home, "Caudalie", "");
		}else if(e.getSource() == laneigeItem){
			home.dispose();
			new ViewProductsFrame(home, "Laneige", "");
		}
	}

}
