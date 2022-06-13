package com.controller.sweng894;



public class ComController {

	public static void main(String[] args) 
	
	{
		//Stage 1 I/OS
		int VT100  = 0; // First Stage Vibration sensor reading
		int VSH100 = 0; // First Stage vibration set-point 
		int VAH100 = 0; // First Stage Vibration alarm
		int VPH100 = 0; // First Stage Vibration permissive 
		int VT100_STAT = 9999999; // Vibration sensor signal integrity 
		
		//Stage 2 I/OS
		int VT200  = 0; // 2nd Stage Stage Vibration sensor reading
		int VSH200 = 0; // 2nd Stage vibration set-point 
		int VAH200 = 0; // 2nd Stage Vibration alarm
		int VPH200 = 0; // 2nd Stage Vibration permissive 
		int VT200_STAT = 9999999; // Vibration sensor signal integrity 
		
		//Stage 3 I/OS
		int VT300  = 0; // 3rd Stage Vibration sensor reading
		int VSH300 = 0; // 3rd Stage vibration set-point 
		int VAH300 = 0; // 3rd Stage Vibration alarm
		int VPH300 = 0; // 3rd Stage Vibration permissive 
		int VT300_STAT = 9999999; // Vibration sensor signal integrity 
		
		// Compressor Status
		int C_STATUS =0; // Compressor  start/stop status 0= stopped, 1= ready to start, 2= Running
		int C_LOAD   =0; // Compressor  loading status 0= unloaded, 1 = loading, 2 = loaded, 3 unloading,
		
		// Alarms module
		
		ComAuxSys auxvibStagAlm1 = new HighAlarm (" " ,VT100,VSH100,VAH100,VT100_STAT,"");
		ComAuxSys auxvibStagAlm2 = new HighAlarm (" " ,VT200,VSH200,VAH200,VT200_STAT,"");
		ComAuxSys auxvibStagAlm3 = new HighAlarm (" " ,VT300,VSH300,VAH300,VT300_STAT,"");

		auxvibStagAlm1.detectAlarm();
		auxvibStagAlm2.detectAlarm();
		auxvibStagAlm3.detectAlarm();

		// Permissive module 
		ComAuxSys auxvibStagVIB1 = new AuxVibPermissive ("VT100",VT100_STAT,VPH100,C_STATUS,"");
		ComAuxSys auxvibStagVIB2 = new AuxVibPermissive ("VT200",VT200_STAT,VPH200,C_STATUS,"");
		ComAuxSys auxvibStagVIB3 = new AuxVibPermissive ("VT300",VT300_STAT,VPH300,C_STATUS,"");
		
				
		auxvibStagVIB1.detectPermssive();
		auxvibStagVIB2.detectPermssive();
		auxvibStagVIB3.detectPermssive();
		
		////==================================Aux System Composite======================================================////
		 
		String CoolingSystem = "Compressor Cooling System";
		String C_sensor = "PT100 Compressor Cooling Pressure";
		int PT100=100;
		int PSH100=5;
		int PAH100=0;
		int PT100_STAT = 1;
		
		
		String OilSystem = "Compressor Oil System";
		String T_sensor = "TT100 Oil System Temperature";
		int TT100=200;
		int TSH100=50;
		int TAH100=0;
		int TT100_STAT = 1;		
		

		String SucSystem = "Compressor suction";
		String Suc_sensor = "PT500 Compressor Suction Pressure";
		int PT500=0;
		int PSH500=50;
		int PAH500=0;
		int PT500_STAT = 1;
		
		String DischSystem = "Compressor discharge";
		String Disch_sensor = "PT500 Compressor discharge Pressure";
		int PT2500=0;
		int PSH2500=50;
		int PAH2500=0;
		int PT2500_STAT = 0;
		
		
		Compsite aux = new Compsite ();
		ComAuxSys auxcooling     = new HighAlarm(C_sensor,PT100, PSH100, PAH100, PT100_STAT, CoolingSystem); // compressor cooling system High alarms
		ComAuxSys auxoil         = new HighAlarm(T_sensor,TT100, TSH100, TAH100, TT100_STAT, OilSystem); //compressor oil system High alarms
		ComAuxSys comSuction     = new HighAlarm(Suc_sensor,PT500, PSH500, PAH500, PT500_STAT, SucSystem); // compressor suction alarms
		ComAuxSys comDischarge   = new HighAlarm(Disch_sensor,PT2500, PSH2500, PAH2500, PT2500_STAT, DischSystem); // compressor discharge alarms
		aux.addsys(auxoil);
		aux.addsys(auxcooling);
		aux.addsys(comSuction);
		aux.addsys(comDischarge);
		aux.detectAlarm();

	}
}