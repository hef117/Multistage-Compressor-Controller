package com.controller.sweng894;



public class ComController {

	public static void main(String[] args) 
	
	{
		// The hard-coded value below are used to test the initial logic concept 
		ComAuxSys auxvibStagAlm1 = new AuxVibAlarm ("VT100",200,100,200,1,"");
		ComAuxSys auxvibStagAlm2 = new AuxVibAlarm ("VT200",300,100,200,1,"");
		ComAuxSys auxvibStagAlm3 = new AuxVibAlarm ("VT300",300,100,200,1,"");

		auxvibStagAlm1.detectAlarm();
		auxvibStagAlm2.detectAlarm();
		auxvibStagAlm3.detectAlarm();
		
		ComAuxSys auxvibStagVIB1 = new AuxVibPermissive ("VT100",1,1,0,"");
		ComAuxSys auxvibStagVIB2 = new AuxVibPermissive ("VT200",1,1,0,"");
		ComAuxSys auxvibStagVIB3 = new AuxVibPermissive ("VT300",1,1,0,"");
		
				
		auxvibStagVIB1.detectPermssive();
		auxvibStagVIB2.detectPermssive();
		auxvibStagVIB3.detectPermssive();
	}
}