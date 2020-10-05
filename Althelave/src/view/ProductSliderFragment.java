package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import util.Helper;

public class ProductSliderFragment extends JPanel implements MouseListener{

	private JScrollPane productsScrollPane;
	private JScrollBar productsScrollBar;
	private JPanel productItemsPanel, productsTitlePanel, aboutUsPanel;
	private JLabel fProdLabel, sProdLabel, tProdLabel, foProdLabel, fiProdLabel, siProdLabel, 
					seProdLabel, eProdLabel, niProdLabel, rightArrow, leftArrow, titleLabel;
	private ArrayList<ImageIcon> productImages;
	private Helper helper;
	private int movement = 210;
	private JFrame home;
	
	public ProductSliderFragment(JFrame home) {
		this.home = home;
		setLayout(new BorderLayout());
		setBackground(helper.DEFAULT_PINK_BG);
		helper = Helper.getInstance();
		initializeObjects();
		insertProductImages();
		insertComponentsIntoProductPanel();
		manageContent();
		displayContent();
	}
	
	private void initializeObjects(){
		productImages = new ArrayList<>();
		titleLabel = new JLabel(helper.getString("Hot Items", 11, ""));
		aboutUsPanel = new AboutUsFragment();
		productItemsPanel = new JPanel(new GridLayout(1,0,10,0));
		productItemsPanel.setBackground(helper.DEFAULT_PINK_BG);
		productsTitlePanel = new JPanel();
		productsTitlePanel.setBackground(helper.DEFAULT_PINK_BG);
		productsScrollPane = new JScrollPane(productItemsPanel);
		productsScrollPane.setBackground(helper.DEFAULT_PINK_BG);
	}
	
	private void displayContent() {
		add(productsTitlePanel, BorderLayout.NORTH);
		add(productsScrollPane, BorderLayout.CENTER);
		add(rightArrow, BorderLayout.EAST);
		add(leftArrow, BorderLayout.WEST);
		add(aboutUsPanel, BorderLayout.SOUTH);
	}

	private void insertProductImages() {
		int size = 200;
		productImages.add(helper.getImg("hot_items/innisfree_cream.jpg", size, size));
		productImages.add(helper.getImg("hot_items/abloom.jpg", size, size));
		productImages.add(helper.getImg("hot_items/drunkelephant.jpg", size, size));
		productImages.add(helper.getImg("hot_items/althea_fresh.jpg", size, size));
		productImages.add(helper.getImg("hot_items/caudalie.jpg", size, size));
		productImages.add(helper.getImg("hot_items/etude.jpg", size, size));
		productImages.add(helper.getImg("hot_items/laneige.jpg", size, size));
		productImages.add(helper.getImg("hot_items/innisfree_serum.jpg", size, size));
		productImages.add(helper.getImg("hot_items/krave_gbr.jpg", size, size));
	}
	
	private void insertComponentsIntoProductPanel() {		
		fProdLabel = new JLabel(productImages.get(0));
		sProdLabel = new JLabel(productImages.get(1));
		tProdLabel = new JLabel(productImages.get(2));
		foProdLabel = new JLabel(productImages.get(3));
		fiProdLabel = new JLabel(productImages.get(4));
		siProdLabel = new JLabel(productImages.get(5));
		seProdLabel = new JLabel(productImages.get(6));
		eProdLabel = new JLabel(productImages.get(7));
		niProdLabel = new JLabel(productImages.get(8));
		
		productItemsPanel.add(fProdLabel);
		productItemsPanel.add(sProdLabel);
		productItemsPanel.add(tProdLabel);
		productItemsPanel.add(foProdLabel);
		productItemsPanel.add(fiProdLabel);
		productItemsPanel.add(siProdLabel);
		productItemsPanel.add(seProdLabel);
		productItemsPanel.add(eProdLabel);
		productItemsPanel.add(niProdLabel);
		
		rightArrow = new JLabel(helper.getImg("right_arrow.png", 30, 70));
		rightArrow.addMouseListener(this);

		leftArrow = new JLabel(helper.getImg("left_arrow.png", 30, 70));
		leftArrow.addMouseListener(this);
	}
	
	private void manageContent(){
		productsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		productsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		productsScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		productsScrollBar = productsScrollPane.getHorizontalScrollBar();
		
		productsTitlePanel.add(titleLabel);
		
		setBorder(BorderFactory.createEmptyBorder(0,20,5,20));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == rightArrow){
			int finalValue = productsScrollBar.getValue() + movement;
			if(productsScrollBar.getValue() >= 1260)
				productsScrollBar.setValue(0);
			else{
				while(productsScrollBar.getValue() < finalValue && productsScrollBar.getValue() < 1300){
					productsScrollBar.setValue(productsScrollBar.getValue() + 40);
					try {
						Thread.sleep(60);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				System.out.println(productsScrollBar.getValue());
//				productsScrollBar.setValue(productsScrollBar.getValue() + movement);
			}
		}
		else if(e.getSource() == leftArrow){
			//1306 - 210 = 1096
			int finalValue = productsScrollBar.getValue() - (productsScrollBar.getValue() <= 106 ? 106 : movement);
			if(productsScrollBar.getValue() <= 0)
				productsScrollBar.setValue(productsScrollBar.getMaximum());
			else{
				while(productsScrollBar.getValue() >= finalValue && productsScrollBar.getValue() > 0){
					if(productsScrollBar.getValue() <= 30)
						productsScrollBar.setValue(0);
					else
						productsScrollBar.setValue(productsScrollBar.getValue() - 40);
					try {
						Thread.sleep(60);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
//			if(productsScrollBar.getValue() - movement > movement){
//				productsScrollBar.setValue(productsScrollBar.getValue() - movement);
//			}
//			else productsScrollBar.setValue(productsScrollBar.getMaximum());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == rightArrow || e.getSource() == leftArrow)
			home.setCursor(Cursor.HAND_CURSOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == rightArrow || e.getSource() == leftArrow)
			home.setCursor(Cursor.DEFAULT_CURSOR);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
