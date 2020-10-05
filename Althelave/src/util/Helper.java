package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Product;

public class Helper {

	private static Helper helper = null;
	public static final Color DEFAULT_PINK_BG = new Color(253, 225, 234);
	private GraphicsEnvironment ge = 
	         GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	private Helper() {
		// TODO Auto-generated constructor stub
	}
	
	public static Helper getInstance(){
		if(helper == null)
			return helper = new Helper();
		return helper;
	}
	
	public ImageIcon getImg(String path, int h, int w) {
		ImageIcon imageIcon = new ImageIcon("resources/"+path);
		Image newimg = imageIcon.getImage().getScaledInstance(h, w, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		return imageIcon;
	}
	
	public String getString(String str, float size, String additionalDesign){

	    try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new 
					File("resources/font/Slabo27px-Regular.ttf")));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "<html><p style='font-family: \"Slabo 27px\", cursive, sans-serif;" + additionalDesign + ""
				+ " font-size: "+size+"px;'>"+str+"</p></html>";
	}
	
}
