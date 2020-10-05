package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Helper;

public class ViewBasicSkincareFrame extends JFrame implements MouseListener{

	private Helper helper;
	private JLabel backLabel;
	private JPanel backPanel;
	private ImageIcon icon, video;
	
	public ViewBasicSkincareFrame() {
		helper = Helper.getInstance();
		initializeObjects();
		
		setIconImage(icon.getImage());
		setTitle("Althelave - Basic Skincare");
		getContentPane().setBackground(helper.DEFAULT_PINK_BG);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(700, 735));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	private void initializeObjects() {
		backLabel = new JLabel(setBackText(false));
		backLabel.addMouseListener(this);
		
		backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		backPanel.setBackground(helper.DEFAULT_PINK_BG);
		backPanel.add(backLabel);
		
		add(backPanel, BorderLayout.NORTH);
		
		JPanel x = new AboutUsFragment();
		x.setPreferredSize(new Dimension(x.getWidth(), 60));
		
//		try {
//			Desktop.getDesktop().open(new File("skincare_basic/basic.mp4"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		video = helper.getImg("skincare_basic/basic.mp4", 100, 100); //skincare_basic/basic.mp4
//		JLabel videoLabel = new JLabel(video);
		
		icon = helper.getImg("logo/althelave_logo.png", 10, 10);
		
//		add(videoLabel, BorderLayout.CENTER);
		add(x, BorderLayout.SOUTH);
	}
	
	private String setBackText(boolean on){
		return on ? "<html><u><p style='font-family: \"Comic Sans MS\", cursive, sans-serif;'>Back to Home Page</p><u></html>" : 
			"<html><p style='font-family: \"Comic Sans MS\", cursive, sans-serif;'>Back to Home Page</p></html>";
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
