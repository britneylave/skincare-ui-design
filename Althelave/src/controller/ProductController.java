package controller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Product;
import util.Database;
import util.Helper;

public class ProductController {
	
	private Helper helper;

	public ProductController() {
		helper = Helper.getInstance();
	}
	
	public void resetProductList(){
		if(Database.products.isEmpty()) return;
		Database.products = new ArrayList<>();
	}
	
	public void addNewProduct(String name, String photoPath, int price){
		Database.products.add(createNewProduct(name, photoPath, price));
	}
	
	public ArrayList<Product> getAllProducts(){
		return Database.products;
	}
	
	public void insertInnisfreeBodyProducts(){
		addNewProduct("Camellia Nourishing Body Balm", "/products/innisfree/bodycare/body_balm.png", 130000);
		addNewProduct("Olive Oil Body Cleanser", "/products/innisfree/bodycare/body_cleanser.png", 85000);
		addNewProduct("Perfect Fresh Foot Spray", "/products/innisfree/bodycare/foot_spray.png", 120000);
		addNewProduct("Olive Real Body Lotion", "/products/innisfree/bodycare/body_lotion.png", 135000);
		addNewProduct("Travel Size Body Cleanser", "/products/innisfree/bodycare/travel_size_cleanser.png", 45000);
		addNewProduct("Refreshing Citrus Body Scrub", "/products/innisfree/bodycare/body_scrub.png", 155000);
		addNewProduct("Camellia Nourishing Shower Oil", "/products/innisfree/bodycare/shower_oil.png", 165000);
	}
	
	public void insertInnisfreeSkinProducts(){
		addNewProduct("Volcanic Pore Clay Mask", "/products/innisfree/skincare/claymask.png", 180000);
		addNewProduct("Green Tea Seed Cream", "/products/innisfree/skincare/cream.png", 230000);
		addNewProduct("Sea Water Ampoule", "/products/innisfree/skincare/ampoule.png", 400000);
		addNewProduct("Roller Ball for Eyes", "/products/innisfree/skincare/eye_ball.png", 95000);
		addNewProduct("Recycled Coffee Mask", "/products/innisfree/skincare/mask.png", 185000);
		addNewProduct("Innisfree Skin Lotion", "/products/innisfree/skincare/toner.png", 125000);
		addNewProduct("Eye Essence", "/products/innisfree/skincare/eye_essence.png", 225000);
		addNewProduct("Bija Trouble Facial Foam", "/products/innisfree/skincare/facial_foam.png", 105000);
		addNewProduct("Sun Stick SPF 50+", "/products/innisfree/skincare/sunstick.png", 215000);
	}
	
	public void insertLaneigeProducts(){
		addNewProduct("Water Bank Hydro Essence", "/products/laneige/hydro_essence.png", 380000);
		addNewProduct("Air Light Sun Stick", "/products/laneige/air_light_sun.png", 320000);
		addNewProduct("Cica Sleeping Mask", "/products/laneige/cica_sleeping_mask.png", 180000);
		addNewProduct("Cleansing Water", "/products/laneige/cleansing_water.png", 125000);
		addNewProduct("White Dew Milky Cleanser", "/products/laneige/cream_cleanser.png", 135000);
		addNewProduct("Fresh Calming Morning Mask", "/products/laneige/fresh_calming_mask.png", 190000);
		addNewProduct("Clear C Peeling Serum", "/products/laneige/clear_c_serum.png", 280000);
		addNewProduct("Moisturizing Cream", "/products/laneige/moisture_cream.png", 230000);
		addNewProduct("Skin Refiner Lotion", "/products/laneige/skin_refiner.png", 290000);
	}
	
	public void insertCaudalieProducts(){
		addNewProduct("VinoPerfect Tinted Moisturizer", "/products/caudalie/vinoperfect_tinted_moist.png", 410000);
		addNewProduct("Hydrating Beauty Elixir", "/products/caudalie/beauty_elixir.png", 520000);
		addNewProduct("Instant Detoxifying Mask", "/products/caudalie/instant_detox_mask.png", 480000);
		addNewProduct("VinoPerfect Peeling Mask", "/products/caudalie/vinoperfect_peeling_mask.png", 390000);
		addNewProduct("3 Mini(s) Trial Size", "/products/caudalie/mini_mask_trio.png", 515000);
		addNewProduct("Vineactiv Anti Wrinkle Serum", "/products/caudalie/vineactiv_anti_wrinkle.png", 630000);
		addNewProduct("Moisturizing Mask", "/products/caudalie/moisturizing_mask.png", 380000);
		addNewProduct("VinoPerfect Serum", "/products/caudalie/vinoperfect_serum.png", 700000);
	}
	
	public JPanel createProductPanel(Product p){
		GridBagLayout grid;
		GridBagConstraints cons;
		grid = new GridBagLayout();
		cons = new GridBagConstraints();
		JPanel panel = new JPanel(grid);
		panel.setBackground(helper.DEFAULT_PINK_BG);
		
		ImageIcon i = helper.getImg(p.getPhotoPath(), 100, 100);
		
		JLabel img = new JLabel(i);
		JLabel name = new JLabel(helper.getString(p.getName(), 10, ""));
		JLabel price = new JLabel(helper.getString(Integer.toString(p.getPrice()), 10, ""));
		
		cons.gridx = 0;
		cons.gridy = 0;
		grid.setConstraints(img, cons);

		cons.gridx = 0;
		cons.gridy = 1;
		grid.setConstraints(name, cons);

		cons.gridx = 0;
		cons.gridy = 2;
		grid.setConstraints(price, cons);
		
		panel.add(img);
		panel.add(name);
		panel.add(price);
		
		return panel;
	}
	
	public Product createNewProduct(String name, String photoPath, int price){
		Product p = new Product();
		p.setName(name);
		p.setPhotoPath(photoPath);
		p.setPrice(price);
		return p;
	}

}
