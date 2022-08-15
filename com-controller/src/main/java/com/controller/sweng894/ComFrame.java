package com.controller.sweng894;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ComFrame extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ComPanel panel;
	
    int Resetcommand=1;
    int Startcommand=1;
    int Stopcommand =1;
    int AutoStopcommand;
    
    int Stg1VibDisableReq =0;
    int Stg2VibDisableReq =0;
    int Stg3VibDisableReq =0;
    
    int AuxcoolingDisableReq =0;
    int AuxoilDisableReq =0;
    int SuctionDisableReq =0;
    int DischargeDisableReq =0;
    String HSLD="100";
    int HSLDSP=100;
    
    
//	Compressor command buttons
	JButton Reset_Button;
	JButton Start_Button;
	JButton Stop_Button;
    JButton Summit_Button;	
	JButton Auto_Stop_Button;
// alarm disable buttons 	
	JButton STG1_Alrm_Button;
	JButton alrm_REST;
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
// actuators and Loading parameters  
	JLabel PV500;
	JLabel PV2500;
	JLabel PV100;
	JLabel STARTUPTIMER;
	JLabel autload;
	
	
	JLabel VAL100;
	JLabel VAH100;
	JLabel VAL200;
	JLabel VAH200;
	JLabel VAL300;
	JLabel VAH300;
	
	JLabel VSL100;
	JLabel VSH100;
	JLabel VSHH100;

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
	
	JLabel TSL100;
	JLabel TSH100;
	JLabel TSLL100;
	JLabel TSHH100;

	JLabel PAL500;
	JLabel PAH500;
	JLabel PALL500;
	JLabel PAHH500;
	
	JLabel PSL500;
	JLabel PSH500;
	JLabel PSLL500;
	JLabel PSHH500;
	
	JLabel PAL2500;
	JLabel PAH2500;
	JLabel PALL2500;
	JLabel PAHH2500;
    JTextField HS500LDSP;	
	
	JLabel PSL2500;
	JLabel PSH2500;
	JLabel PSLL2500;
	JLabel PSHH2500;
	
	ComFrame(){
            
		panel= new ComPanel ();
		
		
		 Reset_Button= new JButton("RESET");	
		 Reset_Button.setBounds(10,450,120,15);
		 Reset_Button.setFocusable(false);
		 Reset_Button.addActionListener(this);

		 Start_Button= new JButton("START");	
		 Start_Button.setBounds(10,470,120,15);
		 Start_Button.setFocusable(false);
		 Start_Button.addActionListener(this);
		 
		 Stop_Button= new JButton("STOP");	
		 Stop_Button.setBounds(10,490,120,15);
		 Stop_Button.setFocusable(false);
		 Stop_Button.addActionListener(this);
		 
		 Auto_Stop_Button= new JButton("AutoSTOP");
		 Auto_Stop_Button.setBounds(10,570,120,15);
		 Auto_Stop_Button.setFocusable(false);
		 Auto_Stop_Button.addActionListener(this);
		 
		 // SETPOINTS
		 HS500LDSP= new JTextField();
		 HS500LDSP.setBounds(10,510,120,20);
		 HS500LDSP.setForeground(Color.green);
		 HS500LDSP.setBackground(Color.black);
		 HS500LDSP.setCaretColor(Color.white);
		 HS500LDSP.setText("Loading point");
		 HS500LDSP.setEditable(true);
		 
		 Summit_Button= new JButton("Enter");	
		 Summit_Button.setBounds(10,530,120,15);
		 Summit_Button.setFocusable(false);
		 Summit_Button.addActionListener(this);
		 
		 
        // Commands alrm_REST  
		 STG1_Alrm_Button= new JButton("STG1 ALRMS");	
		 STG1_Alrm_Button.setBounds(800,450,130,15);
		 STG1_Alrm_Button.setFocusable(false);
		 STG1_Alrm_Button.addActionListener(this);
		 
		 alrm_REST= new JButton("ALRM RST");	
		 alrm_REST.setBounds(700,450,100,15);
		 alrm_REST.setFocusable(false);
		 alrm_REST.addActionListener(this);
		 
		 
		 
		 STG2_Alrm_Button= new JButton("STG2 ALRMS");	
		 STG2_Alrm_Button.setBounds(800,470,130,15);
		 STG2_Alrm_Button.setFocusable(false);
		 STG2_Alrm_Button.addActionListener(this);
		 
		 STG3_Alrm_Button= new JButton("STG3 ALRMS");	
		 STG3_Alrm_Button.setBounds(800,490,130,15);
		 STG3_Alrm_Button.setFocusable(false);
		 STG3_Alrm_Button.addActionListener(this);
		 
		 COOL_Alrm_DISABLE= new JButton("COOL ALRMS");	
		 COOL_Alrm_DISABLE.setBounds(800,510,130,15);
		 COOL_Alrm_DISABLE.setFocusable(false);
		 COOL_Alrm_DISABLE.addActionListener(this);
		 

		 Oil_Alrm_DISABLE= new JButton("OIL ALRMS");	
		 Oil_Alrm_DISABLE.setBounds(800,530,130,15);
		 Oil_Alrm_DISABLE.setFocusable(false);
		 Oil_Alrm_DISABLE.addActionListener(this);
		 
		
		 SUCTION_Alrm_DISABLE= new JButton("SUCT ALRMS");	
		 SUCTION_Alrm_DISABLE.setBounds(800,550,130,15);
		 SUCTION_Alrm_DISABLE.setFocusable(false);
		 SUCTION_Alrm_DISABLE.addActionListener(this);
		 
		 DISCH_Alrm_DISABLE= new JButton("DISCH ALRMS");	
		 DISCH_Alrm_DISABLE.setBounds(800,570,130,15);
		 DISCH_Alrm_DISABLE.setFocusable(false);
		 DISCH_Alrm_DISABLE.addActionListener(this);
		
		 
		 // Indicators
		 VI100= new JLabel();
		 VI100.setBounds(210,134,200,15);
		 
		 VI200= new JLabel();
		 VI200.setBounds(380,134,200,15);
		 
		 VI300= new JLabel();
		 VI300.setBounds(540,134,200,15);
		 
		 PI100= new JLabel();
		 PI100.setBounds(705,134,200,15);
		 
		 TI100= new JLabel();
		 TI100.setBounds(210,480,200,15);
		 
		 PI500= new JLabel();
		 PI500.setBounds(110,323,200,15);
		 
		 PI2500= new JLabel();
		 PI2500.setBounds(617,323,200,15);
		 
		 // actuators 
		 PV500= new JLabel();
		 PV500.setBounds(20,275,200,15);
		 
		 PV2500= new JLabel();
		 PV2500.setBounds(800,275,130,15);

		 PV100= new JLabel();
		 PV100.setBounds(440,22,300,15);
		 
		 
		 
		 // Startup timer
		 STARTUPTIMER= new JLabel();
		 STARTUPTIMER.setBounds(10,54,100,15);
		
		 //auto-load
		 autload= new JLabel();
		 autload.setBounds(10,74,120,15);
		 // RESET prompt 
		 RESETREQU= new JLabel();
		 RESETREQU.setBounds(132,450,180,15);
		 
		// START COMMAND UI Indication
		 HS500= new JLabel();
		 HS500.setBounds(132,470,140,15);
         
		 // Stop Indicator
		 HSTP500= new JLabel();
		 HSTP500.setBounds(132,490,140,15);
		 // Reset Required
		 
		 // Alarm indicators
		 VAL100= new JLabel();
		 VAL100.setBounds(210,114,300,15);		 
		 VAH100= new JLabel();
		 VAH100.setBounds(210,94,300,15);
		 
		// SET POINTS
		 VSL100= new JLabel();
		 VSL100.setBounds(142,114,300,18);
	     VSH100= new JLabel();
		 VSH100.setBounds(142,94,300,18);	 
						 
		 VAL200= new JLabel(); //210,134
		 VAL200.setBounds(380,114,300,15);
		 VAH200= new JLabel();
		 VAH200.setBounds(380,94,300,15);
		 
		 VAL300= new JLabel();
		 VAL300.setBounds(540,114,300,15);
		 VAH300= new JLabel();
		 VAH300.setBounds(540,94,300,15);
		 
		 VPH100= new JLabel();
     	 VPH100.setBounds(210,74,300,15);
     	 
     	 VPH200= new JLabel();
    	 VPH200.setBounds(380,74,300,15);
    	 
    	 VPH300= new JLabel();
    	 VPH300.setBounds(540,74,300,15);
		 
		 VAHH100= new JLabel();
		 VAHH100.setBounds(210,54,300,15);
		 VSHH100= new JLabel();
		 VSHH100.setBounds(142,54,300,15);

		 
		 
		 VAHH200= new JLabel();
		 VAHH200.setBounds(380,60,300,15);
		 
		 VAHH300= new JLabel();
		 VAHH300.setBounds(540,54,300,15);
	
		 PAL100= new JLabel();
    	 PAL100.setBounds(705,114,300,15);		 
    	 PAH100= new JLabel();
		 PAH100.setBounds(705,94,300,15);
		 
		 PALL100= new JLabel();
		 PALL100.setBounds(705,74,300,15);
		 PAHH100= new JLabel();
		 PAHH100.setBounds(705,54,300,15);
		 
		 TAL100= new JLabel();
    	 TAL100.setBounds(210,500,300,15);		 
    	 TAH100= new JLabel();
		 TAH100.setBounds(210,520,300,15);
		 
		 TSL100= new JLabel();
		 TSL100.setBounds(340,500,300,15);
	     TSH100= new JLabel();
		 TSH100.setBounds(340,520,300,15);
		 
		 TALL100= new JLabel();
		 TALL100.setBounds(210,540,300,15);
		 TAHH100= new JLabel();
		 TAHH100.setBounds(210,560,300,15);
		 
		 TSLL100= new JLabel();
		 TSLL100.setBounds(340,540,300,15);
	     TSHH100= new JLabel();
		 TSHH100.setBounds(340,560,300,15);
		 
		 
		 PAL500= new JLabel();
    	 PAL500.setBounds(110,343,300,15);		 
    	 PAH500= new JLabel();
		 PAH500.setBounds(110,363,300,15);
		 
		 PSL500= new JLabel();
		 PSL500.setBounds(18,343,300,15);
		 PSH500= new JLabel();
		 PSH500.setBounds(18,363,300,15);
		 
		 PALL500= new JLabel();
		 PALL500.setBounds(110,383,300,15);
		 PAHH500= new JLabel();
		 PAHH500.setBounds(110,403,300,15);
		 	 
		 PSLL500= new JLabel();
		 PSLL500.setBounds(18,383,300,15);
		 PSHH500= new JLabel();
		 PSHH500.setBounds(18,403,300,15);
		 
		 
		 
		 
		 PAL2500= new JLabel();
    	 PAL2500.setBounds(617,343,300,15);		 
    	 PAH2500= new JLabel();
		 PAH2500.setBounds(617,363,300,15);
		 
		 PSL2500= new JLabel();
		 PSL2500.setBounds(700,343,300,15);
		 PSH2500= new JLabel();
		 PSH2500.setBounds(700,363,300,15);
		 
		 PALL2500= new JLabel();
		 PALL2500.setBounds(617,383,300,15);
		 PAHH2500= new JLabel();
		 PAHH2500.setBounds(617,403,300,15);
         
		 PSLL2500= new JLabel();
		 PSLL2500.setBounds(700,383,300,15);
		 PSHH2500= new JLabel();
		 PSHH2500.setBounds(700,403,300,15);
		

		        
		this.add(Reset_Button);
		this.add(Start_Button);
		this.add(Stop_Button);
		this.add(Auto_Stop_Button);
		
		this.add(STG1_Alrm_Button);
		this.add(alrm_REST);
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
		this.add(STARTUPTIMER);
		this.add(autload);

		this.add(VAL100);
		this.add(VAH100);
		this.add(VAL200);
		this.add(VAH200);
		this.add(VAL300);
		this.add(VAH300);
		
		this.add(VSL100);
		this.add(VSH100);
		this.add(VSHH100);
		
		
		this.add(PSL500);
		this.add(PSH500);
		this.add(PSLL500);
		this.add(PSHH500);
		
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
		
		this.add(TSL100);
		this.add(TSH100);
		this.add(TSLL100);
		this.add(TSHH100);
		
		
		this.add(PAL500);
		this.add(PAH500);
		this.add(PALL500);
		this.add(PAHH500);
		
		this.add(PAL2500);
		this.add(PAH2500);
		this.add(PALL2500);
		this.add(PAHH2500);	
		
		this.add(PSL2500);
		this.add(PSH2500);
		this.add(PSLL2500);
		this.add(PSHH2500);	
		
		this.add(PV500);
		this.add(PV2500);
		this.add(PV100);
		this.add(HS500);
		this.add(HSTP500);
		this.add(RESETREQU);
		
		
		this.add(HS500LDSP);
		this.add(Summit_Button);	
		this.add(panel);
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Compressor Main Page");
		//this.setSize(1000,908);	
		this.setResizable(false);
		this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setLayout(null);
	
	}
	 	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==Reset_Button) {
			Resetcommand=0;
			Startcommand=0;
			Stopcommand=0;
			AutoStopcommand=0;
			
			
			
			// System.out.println("Resetcommand="+Resetcommand);	
	}
		else if(e.getSource()==Stop_Button) {
			Stopcommand=1;
			Startcommand=0;
			//System.out.println("Stopcommand="+Stopcommand);	
			
	}
		else if(e.getSource()==Start_Button) {
			Startcommand=1;
			//System.out.println("Startcommand="+Startcommand);	
	}else if(e.getSource()==Auto_Stop_Button) {
		AutoStopcommand=1;
		//System.out.println("AutoStopcommand="+Stopcommand);	
		
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
       else if(e.getSource()==Summit_Button) {
    	   HSLD=HS500LDSP.getText();
    	   //System.out.println("loading setpoint="+HSLD);
    	   HSLDSP= Integer.parseInt(HSLD);
    	   //System.out.println("loading setpoint="+HSLDSP);
       }
       else if(e.getSource()==alrm_REST) {
    	    Stg1VibDisableReq=0;
			Stg2VibDisableReq=0;
			Stg3VibDisableReq=0;
		    AuxcoolingDisableReq =0;
		    AuxoilDisableReq =0;
		    SuctionDisableReq =0;
		    DischargeDisableReq =0;  
       }
   } 	
}