package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.BrandController;
import util.Helper;

public class ViewProductsFrame extends JFrame implements MouseListener{

	private Helper helper;
	private JLabel titleLabel, backLabel;
	private String brand, type;
	private JPanel productsPanel, titlePanel, containerPanel, backPanel;
	private BrandController brandController;
	private String brandColor;
	private ImageIcon icon;
	private JFrame home;
	
	public ViewProductsFrame(JFrame home, String brand, String type) {
		this.home = home;
		this.brand = brand;
		this.type = type;
		
		helper = Helper.getInstance();
		brandController = BrandController.getInstance(home);
		initializeObjects();
		
		setIconImage(icon.getImage());
		setTitle("Althelave - " + brand);
		getContentPane().setBackground(helper.DEFAULT_PINK_BG);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(700, 735));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void initializeObjects() {
		if(brand.equals("Caudalie"))
			brandColor = "#899c8a";
		else if (brand.equals("Innisfree"))
			brandColor = "#211316";
		else brandColor = "#0246ac";
		
		backLabel = new JLabel(setBackText(false));
		backLabel.addMouseListener(this);
		backLabel.setDisplayedMnemonic(KeyEvent.VK_B);
		
		backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		backPanel.setBackground(helper.DEFAULT_PINK_BG);
		backPanel.add(backLabel);
		titleLabel = new JLabel(helper.getString(brand, 20, "color:"+brandColor+";"));
				
		titlePanel = new JPanel();
		titlePanel.setBackground(helper.DEFAULT_PINK_BG);
		titlePanel.add(titleLabel);
		
		containerPanel = new JPanel(new BorderLayout());
		
		productsPanel = brandController.validateBrand(brand, type);
		containerPanel.add(titlePanel, BorderLayout.NORTH);
		containerPanel.add(productsPanel, BorderLayout.CENTER);
		
		add(backPanel, BorderLayout.NORTH);
		add(containerPanel, BorderLayout.CENTER);
		
		JPanel x = new AboutUsFragment(brandColor);
		x.setPreferredSize(new Dimension(x.getWidth(), 60));
		
		icon = helper.getImg("logo/althelave_logo.png", 10, 10);
		
		add(x, BorderLayout.SOUTH);
	}
	
	private String setBackText(boolean on){
		return on ? helper.getString("<u>Back to Home Page<u/>", 9, "") :
			helper.getString("Back to Home Page", 9, "");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == backLabel){
			setCursor(Cursor.HAND_CURSOR);
			backLabel.setText(setBackText(true));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == backLabel){
			setCursor(Cursor.DEFAULT_CURSOR);
			backLabel.setText(setBackText(false));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == backLabel){
			this.dispose();
			new HomeFrame();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
