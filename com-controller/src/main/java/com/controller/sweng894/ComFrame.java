package com.controller.sweng894;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ComFrame extends JFrame implements ActionListener {
	
	ComPanel panel;
	
    int Resetcommand=1;
    int Startcommand=1;
    int Stopcommand =1;
    
    int Stg1VibDisableReq =0;
    int Stg2VibDisableReq =0;
    int Stg3VibDisableReq =0;
    
    int AuxcoolingDisableReq =0;
    int AuxoilDisableReq =0;
    int SuctionDisableReq =0;
    int DischargeDisableReq =0;
    
    
//	Compressor command buttons
	JButton Reset_Button;
	JButton Start_Button;
	JButton Stop_Button;
	
// alarm disable buttons 	
	JButton STG1_Alrm_Button;
	JButton STG2_Alrm_Button;
	JButton STG3_Alrm_Button;
	
	JButton COOL_Alrm_DISABLE;
	JButton Oil_Alrm_DISABLE;
	JButton SUCTION_Alrm_DISABLE;
	JButton DISCH_Alrm_DISABLE;
	
	JLabel HS500;
	JLabel HSTP500;
	JLabel RESETREQU;
// Analog Readings	
	JLabel VI100;	
	JLabel VI200;
    JLabel VI300;
	JLabel PI100;
	JLabel TI100;
	JLabel PI500;
	JLabel PI2500;
	
	JLabel VAL100;
	JLabel VAH100;
	JLabel VAL200;
	JLabel VAH200;
	JLabel VAL300;
	JLabel VAH300;

	JLabel VPH100;
	JLabel VPH200;
	JLabel VPH300;
	
	JLabel VAHH100;
	JLabel VAHH200;
	JLabel VAHH300;
	
	JLabel PAL100;
	JLabel PAH100;
	JLabel PALL100;
	JLabel PAHH100;

	JLabel TAL100;
	JLabel TAH100;
	JLabel TALL100;
	JLabel TAHH100;

	JLabel PAL500;
	JLabel PAH500;
	JLabel PALL500;
	JLabel PAHH500;
	
	JLabel PAL2500;
	JLabel PAH2500;
	JLabel PALL2500;
	JLabel PAHH2500;
	
	
	ComFrame(){
            
		panel= new ComPanel ();
		
		
		 Reset_Button= new JButton("RESET COMMAND");	
		 Reset_Button.setBounds(50,650,180,15);
		 Reset_Button.setFocusable(false);
		 Reset_Button.addActionListener(this);

		 Start_Button= new JButton("START COMMAND");	
		 Start_Button.setBounds(50,670,180,15);
		 Start_Button.setFocusable(false);
		 Start_Button.addActionListener(this);
		 
		 Stop_Button= new JButton("STOP COMMAND");	
		 Stop_Button.setBounds(50,690,180,15);
		 Stop_Button.setFocusable(false);
		 Stop_Button.addActionListener(this);
		 
		 
		 
        // Commands  
		 STG1_Alrm_Button= new JButton("DISABLE STG1 ALARMS");	
		 STG1_Alrm_Button.setBounds(800,650,180,15);
		 STG1_Alrm_Button.setFocusable(false);
		 STG1_Alrm_Button.addActionListener(this);
		 
		 STG2_Alrm_Button= new JButton("DISABLE STG2 ALARMS");	
		 STG2_Alrm_Button.setBounds(800,670,180,15);
		 STG2_Alrm_Button.setFocusable(false);
		 STG2_Alrm_Button.addActionListener(this);
		 
		 STG3_Alrm_Button= new JButton("DISABLE STG3 ALARMS");	
		 STG3_Alrm_Button.setBounds(800,690,180,15);
		 STG3_Alrm_Button.setFocusable(false);
		 STG3_Alrm_Button.addActionListener(this);
		 
		 COOL_Alrm_DISABLE= new JButton("DISABLE COOL ALARMS");	
		 COOL_Alrm_DISABLE.setBounds(800,710,180,15);
		 COOL_Alrm_DISABLE.setFocusable(false);
		 COOL_Alrm_DISABLE.addActionListener(this);
		 

		 Oil_Alrm_DISABLE= new JButton("DISABLE OIL ALARMS");	
		 Oil_Alrm_DISABLE.setBounds(800,730,180,15);
		 Oil_Alrm_DISABLE.setFocusable(false);
		 Oil_Alrm_DISABLE.addActionListener(this);
		 
		
		 SUCTION_Alrm_DISABLE= new JButton("DISABLE SUCTION ALARMS");	
		 SUCTION_Alrm_DISABLE.setBounds(800,750,180,15);
		 SUCTION_Alrm_DISABLE.setFocusable(false);
		 SUCTION_Alrm_DISABLE.addActionListener(this);
		 
		 DISCH_Alrm_DISABLE= new JButton("DISABLE DISCHARGE ALARMS");	
		 DISCH_Alrm_DISABLE.setBounds(800,770,180,15);
		 DISCH_Alrm_DISABLE.setFocusable(false);
		 DISCH_Alrm_DISABLE.addActionListener(this);
		
		 
		 // Indicators
		 VI100= new JLabel();
		 VI100.setBounds(80,400,200,15);
		 VI200= new JLabel();
		 VI200.setBounds(80,420,200,15);
		 VI300= new JLabel();
		 VI300.setBounds(80,440,200,15);
		 PI100= new JLabel();
		 PI100.setBounds(80,460,200,15);
		 TI100= new JLabel();
		 TI100.setBounds(80,480,200,15);
		 PI500= new JLabel();
		 PI500.setBounds(80,500,200,15);
		 PI2500= new JLabel();
		 PI2500.setBounds(80,520,200,15);
		 
		 // RESET prompt 
		 RESETREQU= new JLabel();
		 RESETREQU.setBounds(235,650,180,15);
		 
		// START COMMAND UI Indication
		 HS500= new JLabel();
		 HS500.setBounds(235,670,180,15);
         
		 // Stop Indicator
		 HSTP500= new JLabel();
		 HSTP500.setBounds(235,690,180,15);
		 // Reset Required
		 
		 
		 
		 
		 // Alarm indicators
		 VAL100= new JLabel();
		 VAL100.setBounds(550,650,300,15);
		 VAH100= new JLabel();
		 VAH100.setBounds(550,670,300,15);
		 
		
		
		 VAL200= new JLabel();
		 VAL200.setBounds(550,690,300,15);
		 VAH200= new JLabel();
		 VAH200.setBounds(550,710,300,15);
		 
		 VAL300= new JLabel();
		 VAL300.setBounds(550,730,300,15);
		 VAH300= new JLabel();
		 VAH300.setBounds(550,750,300,15);
		 
		 VPH100= new JLabel();
     	 VPH100.setBounds(300,650,300,15);
     	 VPH200= new JLabel();
    	 VPH200.setBounds(300,670,300,15);
    	 VPH300= new JLabel();
    	 VPH300.setBounds(300,690,300,15);
		 
		 VAHH100= new JLabel();
		 VAHH100.setBounds(300,710,300,15);
		 VAHH200= new JLabel();
		 VAHH200.setBounds(300,730,300,15);
		 VAHH300= new JLabel();
		 VAHH300.setBounds(300,750,300,15);
	
		 
		 PAL100= new JLabel();
    	 PAL100.setBounds(780,400,300,15);		 
    	 PAH100= new JLabel();
		 PAH100.setBounds(780,420,300,15);
		 
		 PALL100= new JLabel();
		 PALL100.setBounds(780,440,300,15);
		 PAHH100= new JLabel();
		 PAHH100.setBounds(780,460,300,15);
		 
		 
		 TAL100= new JLabel();
    	 TAL100.setBounds(780,500,300,15);		 
    	 TAH100= new JLabel();
		 TAH100.setBounds(780,520,300,15);
		 
		 TALL100= new JLabel();
		 TALL100.setBounds(780,540,300,15);
		 TAHH100= new JLabel();
		 TAHH100.setBounds(780,560,300,15);
		 
		 
		 PAL500= new JLabel();
    	 PAL500.setBounds(80,80,300,15);		 
    	 PAH500= new JLabel();
		 PAH500.setBounds(80,100,300,15);
		 
		 PALL500= new JLabel();
		 PALL500.setBounds(80,120,300,15);
		 PAHH500= new JLabel();
		 PAHH500.setBounds(80,140,300,15);
		 
		 
		 PAL2500= new JLabel();
    	 PAL2500.setBounds(760,80,300,15);		 
    	 PAH2500= new JLabel();
		 PAH2500.setBounds(760,100,300,15);
		 
		 PALL2500= new JLabel();
		 PALL2500.setBounds(760,120,300,15);
		 
		 PAHH2500= new JLabel();
		 PAHH2500.setBounds(760,140,300,15);
		 
		 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);	
		this.add(Reset_Button);
		this.add(Start_Button);
		this.add(Stop_Button);
		
		this.add(STG1_Alrm_Button);
		this.add(STG2_Alrm_Button);
		this.add(STG3_Alrm_Button);
		
		this.add(COOL_Alrm_DISABLE);
		this.add(Oil_Alrm_DISABLE);
		this.add(SUCTION_Alrm_DISABLE);
		this.add(DISCH_Alrm_DISABLE);
		
		this.add(VI100);
		this.add(VI200);
		this.add(VI300);
		this.add(PI100);
		this.add(TI100);
		this.add(PI500);
		this.add(PI2500);
		

		this.add(VAL100);
		this.add(VAH100);
		this.add(VAL200);
		this.add(VAH200);
		this.add(VAL300);
		this.add(VAH300);
		
		this.add(VPH100);
		this.add(VPH200);
		this.add(VPH300);
		this.add(VAHH100);
		this.add(VAHH200);
		this.add(VAHH300);
		
		this.add(PAL100);
		this.add(PAH100);
		this.add(PALL100);
		this.add(PAHH100);
		
		this.add(TAL100);
		this.add(TAH100);
		this.add(TALL100);
		this.add(TAHH100);
		
		
		this.add(PAL500);
		this.add(PAH500);
		this.add(PALL500);
		this.add(PAHH500);
		
		this.add(PAL2500);
		this.add(PAH2500);
		this.add(PALL2500);
		this.add(PAHH2500);	
		
		
		this.add(HS500);
		this.add(HSTP500);
		this.add(RESETREQU);
		
		
		this.add(panel);
		
		this.pack();
		this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
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
		    AuxcoolingDisableReq =0;
		    AuxoilDisableReq =0;
		    SuctionDisableReq =0;
		    DischargeDisableReq =0;
			
			// System.out.println("Resetcommand="+Resetcommand);	
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
	}
		else if(e.getSource()==STG2_Alrm_Button) {
			Stg2VibDisableReq=1;
	}
		else if(e.getSource()==STG3_Alrm_Button) {
			Stg3VibDisableReq=1;	
	 }
		else if(e.getSource()==COOL_Alrm_DISABLE) {
			
			AuxcoolingDisableReq =1;
		}
        else if(e.getSource()==Oil_Alrm_DISABLE) {
			
	    AuxoilDisableReq =1;
			
		}
        else if(e.getSource()==SUCTION_Alrm_DISABLE) {
			
        	SuctionDisableReq =1;		
    		}
       else if(e.getSource()==DISCH_Alrm_DISABLE) {
    	   DischargeDisableReq =1;
       }	
   } 	
}