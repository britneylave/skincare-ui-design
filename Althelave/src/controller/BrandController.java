package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.BrandItemFragment;
import view.HomeFrame;
import view.ViewProductsFrame;

public class BrandController {

	private static BrandController brandController = null;
	private static ProductController productController;
	private static JFrame _home;
	
	private BrandController() {
		// TODO Auto-generated constructor stub
	}
	
	public static BrandController getInstance(JFrame home){
		_home = home;
		if(brandController == null){
			productController = new ProductController();
			return brandController = new BrandController();
		}
		return brandController;
	}
	
	public JPanel validateBrand(String brand, String type){
		productController.resetProductList();
		
		if(brand.equals("Innisfree") && type.equals("skin"))
			productController.insertInnisfreeSkinProducts();
		else if(brand.equals("Innisfree") && type.equals("body"))
			productController.insertInnisfreeBodyProducts();
		else if(brand.equals("Laneige"))
			productController.insertLaneigeProducts();
		else if(brand.equals("Caudalie")) productController.insertCaudalieProducts();
			
		return new BrandItemFragment(_home);
	}

}
