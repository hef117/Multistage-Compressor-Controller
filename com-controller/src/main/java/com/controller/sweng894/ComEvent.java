package com.controller.sweng894;

class ComEvent  {
	
///========================================Alarm Module====================================================///

public static void leafevent(String SenTagIn,
	        		int senReadingIn,
	        		int senAlmHiSPIn,
	        		int senShutDwnHiSPIn,
	        		int senAlmLoSPIn,
	        		int senAlmHiFlgIn,
	        		int senShutDwnHiFlgIn,
	        		int senAlmLoFlgIn,
	        		int senPermissFlgIn,
	        		int sensSTATIn,
	        		int c_STATIn,
	        		String senAlmDiscrpHiIn,
	        		String senShutdwnDiscrpHiIn,
	        		String senAlmDiscrpLoIn,
	        		String senPermissDiscrpIn,
	        		String senEngUnitIn) 
	        {
	        	
	        	//Stage-1 I/O instruments 
	        	String SenTag =                SenTagIn  ;  //"1ST Stage Vibration Sensor";
	        	int senReading  =              senReadingIn ;  // First Stage Vibration sensor reading	        	
	        	int senAlmHiSP =               senAlmHiSPIn; // First Stage vibration alarm set-point  	   
	        	int senShutDwnHiSP=            senShutDwnHiSPIn;     // Shutdown high set-point
	        	int senAlmLoSP=                senAlmLoSPIn;        //
	        	//int senShutDwnLoSP=            senShutDwnLoSPIn; // Shutdown set-point
	        	int senAlmHiFlg=               senAlmHiFlgIn;        // alarm high flag
	        	int senShutDwnHiFlg=           senShutDwnHiFlgIn;
	        	int senAlmLoFlg=               senAlmLoFlgIn;        // alarm low flag
	        	//int senShutDwnLoFlg=           senShutDwnLoFlgIn;       // shutdown low flag
	        	int senPermissFlg =            senPermissFlgIn;//2nd Stage Vibration permissive
	        	String senEngUnit=             senEngUnitIn;
	        	int sensSTAT =              sensSTATIn;  // Sensor signal integrity
	        	int c_STAT =                c_STATIn;  // Sensor signal integrity
	        
	        	String senAlmDiscrpHi =     senAlmDiscrpHiIn;
	        	String senShutdwnDiscrpHi = senShutdwnDiscrpHiIn;
	        	String senAlmDiscrpLo=      senAlmDiscrpLoIn;
	        	//String senShutdwnDiscrpLo=  senShutdwnDiscrpLoIn;
	        	String senPermissDiscrp=      senPermissDiscrpIn;
	        	//String CoolingSystem =    "Compressor Cooling System";
	        	
	        	
	        
	        			
	        		    String transmtag =         "initialized";
	        			int transmreading  =       0;          // sensor reading
	        			int setpointLo=            0;          // Alarm OR Shutdown set-point
	        			int setpointHi=            0;          // Alarm OR Shutdown set-point
	        			int alarmFlagLo =          0;          // alarm flag
	        			int alarmFlagHi =          0;          // alarm flag
	        	  	    int transmitter_status =   0;          // sensor signal integrity 
	        	  	    int c_status =             0;          // compressor status
	        	        String alarm_DiscrpLo  =     "ALARM logic initilized ";
	        	        String alarm_DiscrpHi  =     "ALARM logic initilized ";
	        	        String perm_Discrp   =     "PERMISSIVE logic initilized ";
	        	        String transm_eng    =     "engineering unit";
	        	        String SD_transm_eng=      "";	        
	        	       // String senComposite =       senCompositeIn;
	        	        
Object[] input_L = new Object[] {SenTag,senReading,senAlmLoSP,senAlmHiSP,senAlmLoFlg,senAlmHiFlg,sensSTAT,c_STAT,senAlmDiscrpLo,senAlmDiscrpHi,senPermissDiscrp,senEngUnit};
			//map each low alarm parameter to each specific field to be send to the low alarm leaf class 
			
				for (int i = 0; i <= 10; i++) {
					if (i == 0) {
						transmtag = (String) input_L[i];
						//System.out.println("Transmitter Discription:" + "  " + transmtag);
					}

					if (i == 1) {
						transmreading = (int) input_L[i];
						//System.out.println("Transmitter READING" + "  " + transmreading);
					}

					else if (i == 2) {
						setpointLo = (int) input_L[i];
						//System.out.println("SET-POINT-Low" + "  " + setpointLo);
					}

					else if (i == 3) {
						setpointHi = (int) input_L[i];

						//System.out.println("SET-POINT-High" + "  " + setpointHi);
					} 
					else if (i == 4) {
						alarmFlagLo = (int) input_L[i];
						//System.out.println("SET-POINT" + "  " + set-point);
					}

					else if (i == 5) {
						alarmFlagHi = (int) input_L[i];

						//System.out.println("Alarm Flag" + "  " + alarmFlag);
					}
					else if (i == 6) {
						transmitter_status = (int) input_L[i];
						//System.out.println("Transmitter Signal Integrity" + " " + transmitter_status);
					}
					else if (i == 7) {
						c_status = (int) input_L[i];
						//System.out.println("Transmitter Signal Integrity" + " " + transmitter_status);
					}

					else if (i == 8) {
						alarm_DiscrpLo = (String) input_L[i];
						//System.out.println(alarm_Discrp);
					}
					else if (i == 9) {
						alarm_DiscrpHi = (String) input_L[i];
						//System.out.println(alarm_Discrp);
					}
					else if (i == 10) {
						perm_Discrp = (String) input_L[i];
						//System.out.println(transm_eng);
					}
					else if (i == 11) {
						transm_eng = (String) input_L[i];
						//System.out.println(transm_eng);
					}
					
					
					

				}
				// call the alarm leaf with parameters associated with low or high alarm conditions 
				ComAuxSys alarmLow = new LowAlarm(transmtag, transmreading, setpointLo, alarmFlagLo, transmitter_status,alarm_DiscrpLo,transm_eng);
				alarmLow.detectLowAlarm();
				ComAuxSys alarmHigh = new HighAlarm(transmtag, transmreading, setpointHi, alarmFlagHi, transmitter_status,alarm_DiscrpHi,transm_eng);
				alarmHigh.detectHighAlarm();
				ComAuxSys auxvibStagVIB1 = new AuxVibPermissive (transmtag,transmitter_status,senPermissFlg,c_status,perm_Discrp);
				auxvibStagVIB1.detectPermssive();
				}
	  
	  public static void  compsiteEvent(String SenTagIn,
      		int senReadingIn,
      		int senAlmHiSPIn,
      		int senShutDwnHiSPIn,
      		int senAlmLoSPIn,
      		int senShutDwnLoSPIn,
      		int senAlmHiFlgIn,
      		int senShutDwnHiFlgIn,
      		int senAlmLoFlgIn,
      		int senShutDwnLoFlgIn,
      		int sensSTATIn,
      		String senAlmDiscrpHiIn,
      		String senShutdwnDiscrpHiIn,
      		String senAlmDiscrpLoIn,
      		String senShutdwnDiscrpLoIn,
      		String senEngUnitIn,
      		ComAuxSys auxcooling) 
	        {
	        	//Stage-1 I/O instruments 
	        	String SenTag =                SenTagIn  ;  //"1ST Stage Vibration Sensor";
	        	int senReading  =              senReadingIn ;  // First Stage Vibration sensor reading	        	
	        	int senAlmHiSP =               senAlmHiSPIn; // First Stage vibration alarm set-point
	        	int senShutDwnHiSP=            senShutDwnHiSPIn;     // Shutdown high set-point
	        	int senAlmLoSP=                senAlmLoSPIn;
	        	int senShutDwnLoSP=            senShutDwnLoSPIn;   
	        	int senAlmHiFlg=               senAlmHiFlgIn;        // alarm high flag
	        	int senShutDwnHiFlg=           senShutDwnHiFlgIn;
	        	int senAlmLoFlg=               senAlmLoFlgIn;
	        	int senShutDwnLoFlg=           senShutDwnLoFlgIn;
	        	int senPermissFlg =           0;//2nd Stage Vibration permissive
	        	int sensSTAT =           sensSTATIn;  // Sensor signal integrity
	        	String senAlmDiscrpLo=   senAlmDiscrpLoIn;
	        	String senAlmDiscrpHi =  senAlmDiscrpHiIn;
	        	String senShutdwnDiscrpHi = senShutdwnDiscrpHiIn;
	        	String senShutdwnDiscrpLo=  senShutdwnDiscrpLoIn;
	        	String senPermissDiscrp=      "Check for permissive*";
	        	//String CoolingSystem =    "Compressor Cooling System";
	        	String senEngUnit      =    senEngUnitIn;
	        	
	        
	        			
	        		    String transmtag =         "initialized";
	        			int transmreading  =       0;          // sensor reading
	        			int setpointLo=            0;          // Alarm OR Shutdown set-point
	        			int setpointHi=            0;          // Alarm OR Shutdown set-point
	        			int alarmFlagLo =          0;          // alarm flag
	        			int alarmFlagHi =          0;          // alarm flag
	        	  	    int transmitter_status =   0;          // sensor signal integrity 
	        	  	    int c_status =             0;          // compressor status
	        	        String alarm_DiscrpLo  =     "ALARM logic initilized ";
	        	        String alarm_DiscrpHi  =     "ALARM logic initilized ";
	        	        String perm_Discrp   =     "PERMISSIVE logic initilized ";
	        	        String transm_eng    =     "engineering unit";
	        	        String SD_transm_eng=      "";	        
	        	        Compsite aux = new Compsite ();

	        	        
	     Object[] input_L = new Object[] {SenTag,senReading,senAlmHiSP,senShutDwnHiSP,senAlmLoSP,senShutDwnLoSP,senAlmHiFlg,senShutDwnHiFlg,senAlmLoFlg,senShutDwnLoFlg,sensSTAT,senAlmDiscrpHi,senShutdwnDiscrpHi,senAlmDiscrpLo,senShutdwnDiscrpLo,senEngUnit};
			//map each low alarm parameter to each specific field to be send to the low alarm leaf class 
			
				for (int i = 0; i <= 15; i++) {
					if (i == 0) {
						transmtag = (String) input_L[i];
						//System.out.println("Transmitter Discription:" + "  " + transmtag);
					}

					if (i == 1) {
						transmreading = (int) input_L[i];
						//System.out.println("Transmitter READING" + "  " +transmreading);
					}

					else if (i == 2) {
						senAlmHiSP = (int) input_L[i];
						//System.out.println("senAlmHiSP" + "  " +senAlmHiSP);
					}

					else if (i == 3) {
						senShutDwnHiSP = (int) input_L[i];

						//System.out.println("senShutDwnHiSP" + "  " +senShutDwnHiSP);
					} 
					else if (i == 4) {
						senAlmLoSP = (int) input_L[i];
						//System.out.println("SET-POINT" + "  " +senAlmLoSP);
					}

					else if (i == 5) {
						senShutDwnLoSP = (int) input_L[i];

						//System.out.println("Alarm Flag" + "  " +senShutDwnLoSP);
					}
					else if (i == 6) {
						senAlmHiFlg = (int) input_L[i];
						//System.out.println("Transmitter Signal Integrity" + " " +senAlmHiFlg);
					}

					else if (i == 7) {
						senShutDwnHiFlg = (int) input_L[i];
						//System.out.println(senShutDwnHiFlg);
					}
					else if (i == 8) {
						senAlmLoFlg = (int) input_L[i];
						//System.out.println(senAlmLoFlg);
					}
					else if (i == 9) {
						senShutDwnLoFlg = (int) input_L[i];
						//System.out.println(senShutDwnLoFlg);
					}
					
					else if (i == 10) {
						sensSTAT = (int) input_L[i];
						//System.out.println(sensSTAT);
						
					}
					else if (i == 11) {
						senAlmDiscrpHi = (String) input_L[i];
						//System.out.println(senAlmDiscrpHi);
					
					}
					
					else if (i == 12) {
						senShutdwnDiscrpHi = (String) input_L[i];
						//System.out.println(senShutdwnDiscrpHi);
					
					}
					else if (i == 13) {
						senAlmDiscrpLo = (String) input_L[i];
						//System.out.println(senAlmDiscrpLo);
											}
					else if (i == 14) {
						senShutdwnDiscrpLo = (String) input_L[i];
						//System.out.println(senShutdwnDiscrpLo);
					}

					else if (i == 15) {
						 senEngUnit = (String) input_L[i];
						//System.out.println(senEngUnit);
						
					}
				}
				// call composite with different alarm or shutdown parameters
			
				auxcooling = new LowAlarm(transmtag, transmreading,senAlmLoSP,senAlmLoFlg,sensSTAT,senAlmDiscrpLo,senEngUnit);
				aux.addsys(auxcooling);
				aux.detectLowAlarm(); 
				
				auxcooling = new HighAlarm(transmtag, transmreading,senAlmHiSP,senAlmLoFlg,sensSTAT,senAlmDiscrpHi,senEngUnit);
				aux.addsys(auxcooling);
				aux.detectHighAlarm();
				
				auxcooling = new Lowshutdown(transmtag, transmreading,senShutDwnLoSP,senShutDwnLoFlg,sensSTAT,senShutdwnDiscrpLo,senEngUnit);
				aux.addsys(auxcooling);
				aux.detectLowShutdown();
				
				auxcooling = new Highshutdown(transmtag, transmreading,senShutDwnHiSP,senShutDwnHiFlg,sensSTAT,senShutdwnDiscrpHi,senEngUnit);
				aux.addsys(auxcooling);
				aux.detectHighShutdown();
				
	        }	
	  
}
