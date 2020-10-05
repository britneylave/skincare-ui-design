package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import util.Helper;

public class HomeFrame extends JFrame{
	
	private JScrollPane newsPanel;
	private JPanel sliderPanel, logoPanel, wrapLogoPanel, contentPanel, productsPanel;
	private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private Helper helper;
	private ImageIcon icon;
	private UIManager UI;

	public HomeFrame() {
		UI=new UIManager();
		helper = Helper.getInstance();
		UI.put("OptionPane.background", helper.DEFAULT_PINK_BG);
		UI.put("Panel.background", helper.DEFAULT_PINK_BG);
		UIManager.put("Button.background", Color.white);
		initialize();
		
		setTitle("Althelave");
		getContentPane().setBackground(helper.DEFAULT_PINK_BG);
		setState(ICONIFIED);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(new Dimension(700, 735));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void initialize() {
		createObjects();
		initializeContent();
		display();
	}

	private void createObjects() {
		contentPanel = new JPanel(new BorderLayout());
		productsPanel = new ProductSliderFragment(this);
		sliderPanel = new SideSliderFragment();
		wrapLogoPanel = new NavigationFragment(this);
		logoPanel = new LogoFragment();
		newsPanel = new HappeningFragment();
		icon = helper.getImg("logo/althelave_logo.png", 10, 10);
	}

	private void initializeContent() {
		wrapLogoPanel.add(logoPanel, BorderLayout.NORTH);
		contentPanel.setBackground(helper.DEFAULT_PINK_BG);
		contentPanel.add(wrapLogoPanel, BorderLayout.NORTH);
		contentPanel.add(newsPanel, BorderLayout.CENTER);
	}

	private void display(){
//		displayPopUp();
		add(sliderPanel, BorderLayout.EAST);
		add(productsPanel, BorderLayout.SOUTH);
		add(contentPanel, BorderLayout.CENTER);
		setIconImage(icon.getImage());
	}

	//jadinya tida di pakai
	private void displayPopUp() {
		JPanel welcomePanel = new JPanel(new BorderLayout(0,10));
		JPanel textPanel = new JPanel(new BorderLayout());
		JPanel labelTitlePanel = new JPanel();
		welcomePanel.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
		ImageIcon banner = helper.getImg("welcome_banner.jpg", 500, 300);
		ImageIcon dialogImg = helper.getImg("logo/althelave_logo.png", 100, 100);
		JLabel welcomeBanner = new JLabel(banner);
		JLabel message = new JLabel(helper.getString("Welcome to Al The Lave !", 14, "color: #f488ab;"));
		labelTitlePanel.add(message);
		textPanel.add(labelTitlePanel, BorderLayout.NORTH);
		welcomePanel.add(welcomeBanner, BorderLayout.CENTER);
		welcomePanel.add(textPanel, BorderLayout.SOUTH);
		
		Object options[] = {};
		JOptionPane jp = new JOptionPane(welcomePanel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options);
		JDialog dialog = jp.createDialog("Al The Lave");
	    Image image = dialogImg.getImage();
	    dialog.setIconImage(image);
	}

}
