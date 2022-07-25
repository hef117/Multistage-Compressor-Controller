package com.controller.sweng894;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ComFrame extends JFrame implements ActionListener {
	
    int Resetcommand=1;
    int Startcommand=1;
    int Stopcommand =1;
    
    int Stg1VibDisableReq =0;
    int Stg2VibDisableReq =0;
    int Stg3VibDisableReq =0;
    
    int AuxcoolingDisableReq =1;
    int AuxoilDisableReq =1;
    int SuctionDisableReq =1;
    int DischargeDisableReq =1;
    
    
//	Compressor command buttons
	JButton Reset_Button;
	JButton Start_Button;
	JButton Stop_Button;
	
// alarm disable buttons 	
	JButton STG1_Alrm_Button;
	JButton STG2_Alrm_Button;
	JButton STG3_Alrm_Button;
	
	JButton AuxCooling_Alrm_Button;
	JButton AuxOil_Alrm_Button;
	JButton Suction_Alrm_Button;
	JButton Discharge_Alrm_Button;
	
	JLabel label = new JLabel("MAIN Graphic");	

	 ComFrame(){

		 Reset_Button= new JButton("RESET COMMAND");	
		 Reset_Button.setBounds(10,120,200,20);
		 Reset_Button.setFocusable(false);
		 Reset_Button.addActionListener(this);

		 Start_Button= new JButton("START COMMAND");	
		 Start_Button.setBounds(10,150,200,20);
		 Start_Button.setFocusable(false);
		 Start_Button.addActionListener(this);
		 
		 Stop_Button= new JButton("STOP COMMAND");	
		 Stop_Button.setBounds(10,180,200,20);
		 Stop_Button.setFocusable(false);
		 Stop_Button.addActionListener(this);
		 
// alarm bypass buttons 
		 STG1_Alrm_Button= new JButton("DISABLE STG1 ALARMS");	
		 STG1_Alrm_Button.setBounds(800,120,200,20);
		 STG1_Alrm_Button.setFocusable(false);
		 STG1_Alrm_Button.addActionListener(this);
		 
		 STG2_Alrm_Button= new JButton("DISABLE STG2 ALARMS");	
		 STG2_Alrm_Button.setBounds(800,150,200,20);
		 STG2_Alrm_Button.setFocusable(false);
		 STG2_Alrm_Button.addActionListener(this);
		 
		 STG3_Alrm_Button= new JButton("DISABLE STG3 ALARMS");	
		 STG3_Alrm_Button.setBounds(800,180,200,20);
		 STG3_Alrm_Button.setFocusable(false);
		 STG3_Alrm_Button.addActionListener(this);
		 
		 

		this.add(label);
		this.setBounds(300,0,500,50);
		this.setFont(new Font(null,Font.PLAIN,40) );
		this.setPreferredSize(new Dimension(1000,1000));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(1000,1000);	
		this.setVisible(true);
		this.add(Reset_Button);
		this.add(Start_Button);
		this.add(Stop_Button);
		this.add(Start_Button);
		this.add(STG1_Alrm_Button);
		this.add(STG2_Alrm_Button);
		this.add(STG3_Alrm_Button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==Reset_Button) {
			Resetcommand=0;
			Startcommand=0;
			Stopcommand=0;
			Stg1VibDisableReq=0;
			Stg2VibDisableReq=0;
			Stg3VibDisableReq=0;
			
			 System.out.println("Resetcommand="+Resetcommand);	
	}
		else if(e.getSource()==Stop_Button) {
			Stopcommand=1;
			Startcommand=0;
			System.out.println("Stopcommand="+Stopcommand);	
			
	}
		else if(e.getSource()==Start_Button) {
			Startcommand=1;
			 System.out.println("Startcommand="+Startcommand);	
	}
		
		else if(e.getSource()==STG1_Alrm_Button) {
			Stg1VibDisableReq=1;
			 System.out.println("Stg1VibDisableReq="+Stg1VibDisableReq);	
	}
		else if(e.getSource()==STG2_Alrm_Button) {
			Stg2VibDisableReq=1;
			 System.out.println("Stg2VibDisableReq="+Stg2VibDisableReq);	
	}
		else if(e.getSource()==STG3_Alrm_Button) {
			Stg3VibDisableReq=1;
			 System.out.println("Stg3VibDisableReq="+Stg3VibDisableReq);	
	}
		
  }
}