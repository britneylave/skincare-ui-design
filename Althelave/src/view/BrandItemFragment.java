package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controller.ProductController;
import model.Product;
import util.Helper;

public class BrandItemFragment extends JPanel{

	private ArrayList<Product> products;
	private Helper helper;
	private ProductController pc;
	private JFrame home;
	
	public BrandItemFragment(JFrame home) {
		this.home = home;
		helper = Helper.getInstance();
		pc = new ProductController();
		products = pc.getAllProducts();
		
		setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		setLayout(new GridLayout(3, 3, 10, 10));
		setBackground(helper.DEFAULT_PINK_BG);
		
		for (int i = 0; i < products.size(); i++) {
			JPanel tempPanel = pc.createProductPanel(products.get(i));
			tempPanel.addMouseListener(new MouseListener() {
			
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
					tempPanel.setBorder(BorderFactory.createEmptyBorder());
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					if(e.getSource() == tempPanel){
						home.setCursor(Cursor.HAND_CURSOR);
					}
					tempPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, helper.DEFAULT_PINK_BG, Color.GRAY));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			add(tempPanel);
		}
	}

}
