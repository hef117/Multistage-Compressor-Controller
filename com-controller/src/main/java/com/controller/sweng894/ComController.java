package com.controller.sweng894;



public class ComController {

	public static void main(String[] args) {
		
//		//Stage 1 I/OS
		String VT100 = "1ST Stage Vibration Sensor";
		int VI100  = 110;  // First Stage Vibration sensor reading
		int VSH100 = 100; // First Stage vibration alarm set-point
		int VAH100 = 13;  // First Stage Vibration alarm Flag
		int VPH100 = 1;  // First Stage Vibration permissive Flag 
		int VT100_STAT = 1; // Vibration sensor signal integrity
		String VAH100_Discrp  = "*";

		int VSL100 = 100; // First Stage vibration alarm set-point
		int VAL100 = 13;  // First Stage Vibration alarm Flag
						
		String PT1100 = "1ST Stage suction pressure Sensor";
		int PI1100  = 120;  // First Stage Vibration sensor reading
		int PSH1100 = 102; // First Stage vibration alarm set-point
		int PAH1100 = 12;  // First Stage Vibration alarm Flag
		int PT1100_STAT = 1; // Vibration sensor signal integrity
		String PAH1100_Discrp  = "*";
		
		int PSL1100 = 11; // First Stage vibration alarm set-point
		int PAL1100 = 12;  // First Stage Vibration alarm Flag
		
		//Stage 2 I/OS
		String VT200 = "2ND Stage Vibration Sensor";
		int VI200  = 21; // 2nd Stage Stage Vibration sensor reading
		int VSH200 = 22; // 2nd Stage vibration set-point 
		int VAH200 = 23; // 2nd Stage Vibration alarm
		int VPH200 = 1; // 2nd Stage Vibration permissive 
		int VT200_STAT = 1; // Vibration sensor signal integrity 
		String VAH200_Discrp  = "**";

		int VSL200 = 22; // 2nd Stage vibration set-point 
		int VAL200 = 23; // 2nd Stage Vibration alarm
		
		//Stage 3 I/OS
		String VT300 = "3RD Stage Vibration Sensor";
		int VI300  = 31; // 3rd Stage Vibration sensor reading
		int VSH300 = 32; // 3rd Stage vibration set-point 
		int VAH300 = 33; // 3rd Stage Vibration alarm
		int VPH300 = 1; // 3rd Stage Vibration permissive 
		int VT300_STAT = 1; // Vibration sensor signal integrity 
		String VAH300_Discrp  = "***";

		int VSL300 = 32; // 3rd Stage vibration set-point 
		int VAL300 = 33; // 3rd Stage Vibration alarm

		
		String transmtag ="initialized";
		int transmreading  = 0; // 3rd Stage Vibration sensor reading
		int setpoint= 0; // 3rd Stage vibration set-point 
		int alarmFlag = 0; // 3rd Stage Vibration alarm 
  	    int transmitter_status = 0; // Vibration sensor signal integrity 
        String alarm_Discrp  = " ";
		
        // Compressor Status
		int C_STATUS =0; // Compressor  start/stop status 0= stopped, 1= ready to start, 2= Running
		int C_LOAD   =0; // Compressor  loading status 0= unloaded, 1 = loading, 2 = loaded, 3 unloading,
        
		// High ALarm parameters data object
		Object[][] input = new Object[][] { { VT100, VI100, VSH100, VAH100, VT100_STAT, VAH100_Discrp },
				{ PT1100, PI1100, PSH1100, PAH1100, PT1100_STAT, PAH1100_Discrp },
				{ VT200, VI200, VSH200, VAH200, VT200_STAT, VAH200_Discrp },
				{ VT300, VI300, VSH300, VAH300, VT300_STAT, VAH300_Discrp } };
		// High ALarm parameters data object
		for (int raw = 0; raw <= 3; raw++) {
			for (int i = 0; i <= 6; i++) {
				if (i == 0) {
					transmtag = (String) input[raw][i];
					System.out.println("Transmitter Discription:" + "  " + transmtag);
				}

				if (i == 1) {
					transmreading = (int) input[raw][i];
					System.out.println("Transmitter READING" + "  " + transmreading);
				}

				else if (i == 2) {
					setpoint = (int) input[raw][i];
					System.out.println("SET-POINT" + "  " + setpoint);
				}

				else if (i == 3) {
					alarmFlag = (int) input[raw][i];

					System.out.println("Alarm Flag" + "  " + alarmFlag);
				} else if (i == 4) {
					transmitter_status = (int) input[raw][i];
					System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
				}

				else if (i == 5) {
					alarm_Discrp = (String) input[raw][i];
					System.out.println(alarm_Discrp);
				}

			}
			// call the leaf alarm high with the parameters for the high alarm conditions
			ComAuxSys alarmhigh = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
					alarm_Discrp);
			alarmhigh.detectHighAlarm();
			System.out.println("================================");
		}
///======================================== Low Alarm Module====================================================///
		// Low ALarm parameters data object
		Object[][] input_L = new Object[][] { { VT100, VI100, VSL100, VAL100, VT100_STAT, VAH100_Discrp },
				{ PT1100, PI1100, PSL1100, PAL1100, PT1100_STAT, PAH1100_Discrp },
				{ VT200, VI200, VSL200, VAL200, VT200_STAT, VAH200_Discrp },
				{ VT300, VI300, VSL300, VAL300, VT300_STAT, VAH300_Discrp } };
		//map each low alarm parameter to each specific field to be send to the low alarm leaf class 
		for (int raw = 0; raw <= 3; raw++) {
			for (int i = 0; i <= 6; i++) {
				if (i == 0) {
					transmtag = (String) input_L[raw][i];
					System.out.println("Transmitter Discription:" + "  " + transmtag);
				}

				if (i == 1) {
					transmreading = (int) input_L[raw][i];
					System.out.println("Transmitter READING" + "  " + transmreading);
				}

				else if (i == 2) {
					setpoint = (int) input_L[raw][i];
					System.out.println("SET-POINT" + "  " + setpoint);
				}

				else if (i == 3) {
					alarmFlag = (int) input_L[raw][i];

					System.out.println("Alarm Flag" + "  " + alarmFlag);
				} else if (i == 4) {
					transmitter_status = (int) input_L[raw][i];
					System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
				}

				else if (i == 5) {
					alarm_Discrp = (String) input_L[raw][i];
					System.out.println(alarm_Discrp);
				}

			}
			// call the low alarm leaf with parameters assoicated with low alarm conditions 
			ComAuxSys alarmLow = new LowAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp);
			alarmLow.detectLowAlarm();
			System.out.println("================================");
		}

		//ComAuxSys auxvibStagAlm1 = new HighAlarm (transmtag ,transmreading,setpoint,alarmFlag,transmitter_status,alarm_Discrp);
		//ComAuxSys auxvibStagAlm2 = new HighAlarm (VT200 ,VI200,VSH200,VAH200,VT200_STAT,VAH200_Discrp);
		//ComAuxSys auxvibStagAlm3 = new HighAlarm (VT300 ,VI300,VSH300,VAH300,VT300_STAT,VAH300_Discrp);
		

		//auxvibStagAlm1.detectAlarm();
		//auxvibStagAlm2.detectAlarm();
		//auxvibStagAlm3.detectAlarm();

		// Permissive module 
		ComAuxSys auxvibStagVIB1 = new AuxVibPermissive (VT100,VT100_STAT,VPH100,C_STATUS," ");
		ComAuxSys auxvibStagVIB2 = new AuxVibPermissive (VT200,VT200_STAT,VPH200,C_STATUS," ");
		ComAuxSys auxvibStagVIB3 = new AuxVibPermissive (VT300,VT300_STAT,VPH300,C_STATUS," ");
						
		auxvibStagVIB1.detectPermssive();
		auxvibStagVIB2.detectPermssive();
		auxvibStagVIB3.detectPermssive();
		
		////==================================Aux System Composite======================================================////
		 
		
		String C_sensor = "PT100 Compressor Cooling Pressure";
		int PT100=100;
		int PSH100=5;
		int PAH100=0;
		int PT100_STAT = 1;
		String CoolingSystem = "Compressor Cooling System";
		
		
		String T_sensor = "TT100 Oil System Temperature";
		int TT100=200;
		int TSH100=50;
		int TAH100=0;
		int TT100_STAT = 1;		
		String OilSystem = "Compressor Oil System";

		
		String Suc_sensor = "PT500 Compressor Suction Pressure";
		int PT500=0;
		int PSH500=50;
		int PAH500=0;
		int PT500_STAT = 1;
		String SucSystem = "Compressor suction";
		
		String Disch_sensor = "PT500 Compressor discharge Pressure";
		int PT2500=0;
		int PSH2500=50;
		int PAH2500=0;
		int PT2500_STAT = 0;
		String DischSystem = "Compressor discharge";
		
		Compsite aux = new Compsite ();
		ComAuxSys auxcooling     = new HighAlarm(C_sensor,PT100, PSH100, PAH100, PT100_STAT, CoolingSystem); // compressor cooling system High alarms
		ComAuxSys auxoil         = new HighAlarm(T_sensor,TT100, TSH100, TAH100, TT100_STAT, OilSystem); //compressor oil system High alarms
		ComAuxSys comSuction     = new HighAlarm(Suc_sensor,PT500, PSH500, PAH500, PT500_STAT, SucSystem); // compressor suction alarms
		ComAuxSys comDischarge   = new HighAlarm(Disch_sensor,PT2500, PSH2500, PAH2500, PT2500_STAT, DischSystem); // compressor discharge alarms
		aux.addsys(auxoil);
		aux.addsys(auxcooling);
		aux.addsys(comSuction);
		aux.addsys(comDischarge);
		aux.detectHighAlarm();

	}
}