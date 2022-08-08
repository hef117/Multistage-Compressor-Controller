package com.controller.sweng894;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ComPanel extends JPanel {
	
Image image;

	ComPanel(){
		image = new ImageIcon("test1.png").getImage();
		
		this.setPreferredSize(new Dimension (940,595));
		this.setForeground(Color.blue);
	}
	
	public void paint(Graphics g) {
		 Graphics2D  g2D = (Graphics2D)g;	;
		 g2D.setBackground(Color.blue);
	     g2D.drawImage(image,-60,-240, null);
	   
		//g2D.drawLine(0,0,500,500);
	
	}

}
