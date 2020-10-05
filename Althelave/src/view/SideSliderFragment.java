package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import util.Helper;

public class SideSliderFragment extends JPanel{

	private Timer sliderTimer;
	private JLabel sliderLabel, sliderDesc;
	private ArrayList<String> images;
	private GridBagLayout grid;
	private GridBagConstraints cons;
	private Helper helper;
	private int n = 0;
	private Color borderColor;
	private JProgressBar pBar;
	private JPanel progPanel;
	private int time = 0;

	public SideSliderFragment() {
		helper = Helper.getInstance();
		initializeObjects();
		insertSliderImages();
		displaySlider();
	}
	
	private void initializeObjects(){
		progPanel = new JPanel(new GridLayout());
		pBar = new JProgressBar();
		pBar.setValue(0);
		pBar.setPreferredSize(new Dimension(200,5));
		pBar.setForeground(Color.LIGHT_GRAY);
		pBar.setBorderPainted(false);
		pBar.setBorder(BorderFactory.createEmptyBorder());
		progPanel.add(pBar);
		borderColor = new Color(244, 136, 171);
		grid = new GridBagLayout();
		cons = new GridBagConstraints();
		images = new ArrayList<>();
		sliderLabel = new JLabel();
		sliderDesc = new JLabel(helper.getString("Spot it. Shop it.", 11, ""));
	}
	
	private void insertSliderImages(){
		images.add("vertical_banner.jpg");
		images.add("vertical_banner2.jpg");
		images.add("vertical_banner3.jpg");
		images.add("vertical_banner4.jpg");
		images.add("vertical_banner5.jpg");
	}
	
	private void displaySlider(){
		setBackground(helper.DEFAULT_PINK_BG);
		setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
		setLayout(grid);
		add(progPanel);
		add(sliderLabel);
		add(sliderDesc);
		
		startSlide();
	}
	
	private void startSlide(){
		createSlider();
		sliderTimer = new Timer(12, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time += 12;
				pBar.setValue(pBar.getValue() + 1);
				if(time % 1488 == 0){
					if(n == 4) n = 0;
					else n++;
					pBar.setValue(0);
					createSlider();
				}
			}
		});
		sliderTimer.start();
	}

	private void createSlider() {
		ImageIcon verticalSliderImg = helper.getImg("slideshow_banner/"+images.get(n), 200, 350);
		sliderLabel.setIcon(verticalSliderImg);
//		sliderLabel.setBorder(new LineBorder(borderColor, 3, true));

		cons.gridx = 0;
		cons.gridy = 0;
		grid.setConstraints(progPanel, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		grid.setConstraints(sliderLabel, cons);

		cons.gridx = 0;
		cons.gridy = 2;
		cons.insets = new Insets(10, 0, 0, 0);
		grid.setConstraints(sliderDesc, cons);
	}

}
