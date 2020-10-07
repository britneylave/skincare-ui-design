package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.JTextComponent;

import util.Helper;

public class HappeningFragment extends JScrollPane{

	private JPanel containerPanel;
	private Helper helper;
	private String str = "";
	private ArrayList<ImageIcon> images;
	private ArrayList<String> descriptions;
	private Color SEPARATOR_COLOR = new Color(255, 208, 223);
	
	public HappeningFragment() {
		helper = Helper.getInstance();
		setBorder(BorderFactory.createEmptyBorder(10, 55, 25, 10));
		setBackground(helper.DEFAULT_PINK_BG);
		getVerticalScrollBar().setBackground(new Color(253, 198, 216));
		getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
		        this.thumbColor = new Color(244, 136, 171);
		    }
		});
		initializeContent();
		setPanel();
		initializeContent();
	}
	
	private void initializeContent() {
		int size = 120;
		images = new ArrayList<>();
		images.add(helper.getImg("happening/credit_card.jpg", size, size));
		images.add(helper.getImg("happening/delivery.jpg", size, size));
		images.add(helper.getImg("happening/flash_sale.jpg", size, size));
		images.add(helper.getImg("happening/new_year_sale.jpg", size, size));
		
		descriptions = new ArrayList<>();
		str ="<html>[ NEW !! ] From now on, Al The Lave<br/>"
				+ "customers can proceed their payment<br/>"
				+ "using credit cards! Al The Lave<br/>"
				+ "accepts Visa and Master Cards from<br/>"
				+ "any bank. Place your order now!<br/>"
				+ "note: cards' Expiry date & CVV <br/>"
				+ "number required.<br/></html>";
		descriptions.add(helper.getString(str, 9.5f, ""));
		str ="<html>[ NEW !! ] Instant Delivery is now<br/>"
				+ "available! Enjoy Rp.20.000,- off your<br/>"
				+ "delivery fee with minimum purchase<br/>"
				+ "of Rp.250.000,- at Al The Lave.* <br/>"
				+ "*T&C applied<br/></html>";
		descriptions.add(helper.getString(str, 9.5f, ""));
		str ="<html>[ HOT !! ] The fastest fingers are<br/>"
				+ "the winner! Don't forget to join<br/>"
				+ "Al The Lave's Flash Sale, starts at<br/>"
				+ "12.00 everyday. Tag us on Instagram<br/>"
				+ "@AlTheLave to be featured!<br/></html>";
		descriptions.add(helper.getString(str, 9.5f, ""));
		str ="<html>HAPPY NEW YEAR 2020!<br/>"
				+ "Celebrate 2020 with Al The Lave by<br/>"
				+ "enjoying Rp.20.000,- flat price for<br/>"
				+ "all products featured in our SALE<br/>"
				+ "page. SALE will starts on 01 January<br/>"
				+ "til drop!<br/></html>";
		descriptions.add(helper.getString(str, 9.5f, ""));
	}

	private void setPanel() {
		containerPanel = new JPanel();
		containerPanel.setLayout(new GridLayout(0,1,0,15));
		containerPanel.setBackground(helper.DEFAULT_PINK_BG);
		containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
		
		for (int i = 0; i < images.size(); i++){
			containerPanel.add(templatePanel(images.get(i), descriptions.get(i)));
		}
		setViewportView(containerPanel);
	}

	private JPanel templatePanel(ImageIcon imageIcon, String description){
		JPanel panel = new JPanel(new BorderLayout(10,10));
		panel.setBackground(helper.DEFAULT_PINK_BG);
		JLabel _img = new JLabel(imageIcon);
		JLabel _desc = new JLabel(description);
		
		panel.add(_img, BorderLayout.WEST);
		panel.add(_desc, BorderLayout.CENTER);
		
		panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setBackground(helper.DEFAULT_PINK_BG);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(SEPARATOR_COLOR);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return panel;
	}

}
