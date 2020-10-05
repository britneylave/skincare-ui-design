package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Helper;

public class LogoFragment extends JPanel{

	private JPanel logoGridPanel;
	private JLabel althelaveSignature, althelaveLogo, mottoLabel;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private Helper helper;
	
	public LogoFragment() {
		helper = Helper.getInstance();
		initializeObjects();
		displayLogo();
	}

	private void initializeObjects() {
		mottoLabel = new JLabel(helper.getString("Invest on your skin", 9, ""));
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		logoGridPanel = new JPanel(gbl);
		althelaveSignature = new JLabel();
		althelaveLogo = new JLabel(helper.getImg("logo/althelave.png", 100, 50));
	}

	private void displayLogo() {
		setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		setBackground(helper.DEFAULT_PINK_BG);
		
		althelaveSignature.setIcon(helper.getImg("logo/althelave_logo.png", 90, 90));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		logoGridPanel.add(althelaveLogo, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		logoGridPanel.add(mottoLabel, gbc);
		logoGridPanel.setBackground(helper.DEFAULT_PINK_BG);
		
		add(althelaveSignature);
		add(logoGridPanel);
	}

}
