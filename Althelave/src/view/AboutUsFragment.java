package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Helper;

public class AboutUsFragment extends JPanel implements MouseListener{
	
	private Helper helper = Helper.getInstance();
	private JLabel aboutUsLabel;
	private String color;

	public AboutUsFragment() {
		setBackground(helper.DEFAULT_PINK_BG);
		setPreferredSize(new Dimension(this.getWidth(), 50));

		aboutUsLabel = new JLabel(helper.getString("About Us", 11, ""));
		aboutUsLabel.addMouseListener(this);
		add(aboutUsLabel);
	}
	
	public AboutUsFragment(String color) {
		this.color = color;
		setBackground(helper.DEFAULT_PINK_BG);
		setPreferredSize(new Dimension(this.getWidth(), 50));

		aboutUsLabel = new JLabel(helper.getString("About Us", 11, "color: "+this.color+";"));
		aboutUsLabel.addMouseListener(this);
		add(aboutUsLabel);
	}

	private void setHoverEffect(boolean on) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if(on){
//					setCursor(Cursor.HAND_CURSOR);
					aboutUsLabel.setText(helper.getString("Althelave is "
						+ "an Indonesia-based Company that sells skincare products, dedicated "
						+ "to skincare <br/> enthusiasts! Althelave offers the lowest prices "
						+ "with guaranteed authenticity", 10, "text-align:center;color: "+color+";"));
				}else{
//					setCursor(Cursor.DEFAULT_CURSOR);
					aboutUsLabel.setText(helper.getString("About Us", 11, "color: "+color+";"));
				}
			}
		};
		java.util.Timer x = new java.util.Timer(true);
		x.schedule(task, 10);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == aboutUsLabel) {
			setHoverEffect(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == aboutUsLabel)
			setHoverEffect(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
