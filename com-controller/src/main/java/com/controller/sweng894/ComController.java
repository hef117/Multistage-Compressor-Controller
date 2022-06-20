package com.controller.sweng894;

public class ComController {

	public static void main(String[] args) {
		
//		System instrumentation tags "V" for vibration, "P" for pressure,  "T" for temperature, "F" for flow,// 
		
		//Stage-1 I/O instruments 
		String VT100 =             "1ST Stage Vibration Sensor";
		int VI100  =               3;  // First Stage Vibration sensor reading
		int VSH100 =               2; // First Stage vibration alarm set-point
		int VSL100=                3;        // 
		int VSHH100=               10;     // Shutdown high set-point
		int VSLL100=               10;     // Shutdown set-point
		int VAH100=                0;        // alarm high flag
		int VAL100=                0;        // alarm low flag
		int VAHH100=               0;       // shutdown high flag
		int VPH100 =               1; // 2nd Stage Vibration permissive
		//int VALL100=             0;       // shutdown low flag
		int VT100_STAT =           0;  // Sensor signal integrity
		String VAH100_Discrp =     "Check for high alarm";
		String VAL100_Discrp_LO=   "Check for low alarm";
		String VAHH100_Discrp_SD = "Check for high shutdown";
		//String VALL100_Discrp_SD="Check for low shutdown";
		String VPH100_Discrp=      "Check for permissive*";
		//String CoolingSystem =   "Compressor Cooling System";
		String VT100_ENG      =    "mils";
		
		//Stage-2 I/O instruments  
		String VT200 =             "2ND Stage Vibration Sensor";
		int VI200  =               1;                        // Stage Vibration sensor reading
		int VSH200 =               8;                        // vibration high alarm set-point
		int VSL200=                2;                        // 
		int VSHH200=               9;                       // Shutdown high set-point
		int VSLL200=               1;                       // Shutdown set-point
		int VAH200=                0;                        // alarm high flag
		int VAL200=                0;                        // alarm low flag
		int VAHH200=               0;                        // shutdown high flag
		int VPH200 =               1;                        // 2nd Stage Vibration permissive
		//int VALL100=             0;                        // shutdown low flag
		int VT200_STAT =           0;                        // Sensor signal integrity
		String VAH200_Discrp =     "Check for high alarm";
		String VAL200_Discrp_LO=   "Check for low alarm";
		String VAHH200_Discrp_SD = "Check for high shutdown";
		//String VALL200_Discrp_SD="Check for low shutdown";
		String VPH200_Discrp=      "Check for permissive*";
		String VT200_ENG      =    "mils";
		
		//Stage-3 I/O instruments 
		String VT300 =             "3RD Stage Vibration Sensor";
		int VI300  =               5;                        // Stage Vibration sensor reading
		int VSH300 =               6;                        // vibration high alarm set-point
		int VSL300=                4;                        // 
		int VSHH300=               10;                       // Shutdown high set-point
		int VSLL300=               10;                       // Shutdown set-point
		int VAH300=                0;                        // alarm high flag
		int VAL300=                0;                        // alarm low flag
		int VAHH300=               0;                        // shutdown high flag
		int VPH300 =               1;                        // 2nd Stage Vibration permissive
		//int VALL100=             0;                        // shutdown low flag
		int VT300_STAT =           0;                        // Sensor signal integrity
		String VAH300_Discrp =     "Check for high alarm";
		String VAL300_Discrp_LO=   "Check for low alarm";
		String VAHH300_Discrp_SD = "Check for high shutdown";
		//String VALL300_Discrp_SD="Check for low shutdown";
		String VPH300_Discrp=      "Check for permissive*";
		String VT300_ENG      =    "mils";
		
						
		String PT1100 =             "1ST Stage suction pressure Sensor";
		int PI1100=                 8;         // Sensor Reading
		int PSH1100=                30;        // Alarm High set-point
		int PSL1100=                15;        // Alarm low set point
		int PSHH1100=               35;        // Shutdown high set-point
		int PSLL1100=               10;        // Shutdown set-point
		int PAH1100=                0;         // alarm high flag
		int PAL1100=                0;         // alarm low flag
		int PAHH1100=               0;         // shutdown high flag
		int PALL1100=               0;         // shutdown low flag
		int PT1100_STAT =           1;         // Sensor signal integrity
		String PAH1100_Discrp =     "Check for high alarm";
		String PAL1100_Discrp_LO =  "Check for low alarm";
		String PAHH1100_Discrp_SD = "Check for high shutdown";
		String PALL1100_Discrp_SD = "Check for low shutdown";
		String PT1100_ENG      =    "PSIG";

		

	    String transmtag =         "initialized";
		int transmreading  =       0;          // sensor reading
		int setpoint=              0;          // Alarm OR Shutdown set-point 
		int alarmFlag =            0;          // alarm flag 
  	    int transmitter_status =   0;          // sensor signal integrity 
  	    int c_status =             0;          // compressor status
        String alarm_Discrp  =     "ALARM logic initilized ";
        String perm_Discrp   =     "PERMISSIVE logic initilized ";
        String transm_eng    =     "engineering unit";
        String SD_transm_eng=      "";
        
        
        int permissvFlag =         0;          // permissive flag
		int HIS500 =               0;          // Compressor  start/stop status 0= stopped, 1= ready to start, 2= Running
		int HS_LOAD=               0;          // Compressor  loading status 0= unloaded, 1 = loading, 2 = loaded, 3 unloading,
		
		// Auxiliary Systems instrumentation tags 
		
		String PT100 =             "PT100 Compressor Cooling Pressure";
		int PI100=                 8;         // Sensor Reading
		int PSH100=                30;         // Alarm High set-point
		int PSL100=                15;         // Alarm low set point
		int PSHH100=               35;         // Shutdown high set-point
		int PSLL100=               10;         // Shutdown set-point
		int PAH100=                0;          // alarm high flag
		int PAL100=                0;          // alarm low flag
		int PAHH100=               0;          // shutdown high flag
		int PALL100=               0;          // shutdown low flag
		int PT100_STAT =           1;          // Sensor signal integrity
		String PAH100_Discrp =     "Check for high alarm";
		String PAL100_Discrp_LO =  "Check for low alarm";
		String PAHH100_Discrp_SD = "Check for high shutdown";
		String PALL100_Discrp_SD = "Check for low shutdown";
		String CoolingSystem =     "Compressor Cooling System";
		String PT100_ENG      =    "PSIG";
		
		
		
		String TT100 =             "TT100 Oil System Temperature";
		int TI100=                 230;
		int TSH100=                210;
		int TSL100=                190;
		int TSHH100=               220;
		int TSLL100=               180;
		int TAH100=                0;
		int TAL100=                0;
		int TAHH100=               0;
		int TALL100=               0;
		int TT100_STAT =           1;
		String TAH100_Discrp =     "Check for high alarm";
		String TAL100_Discrp_LO =  "Check for low alarm";
		String TAHH100_Discrp_SD = "Check for high shutdown";
		String TALL100_Discrp_SD = "Check for low shutdown";
		String TT100_ENG      =    "degC";
		String OilSystem =         "Compressor Oil System";

		
		String PT500 =             "PT500 Compressor Suction Pressure";
		int PI500=                 45;
		int PSH500=                40;
		int PSL500=                30;
		int PSHH500=               42;
		int PSLL500=               20;
		int PAH500=                0;
		int PAL500=                0;
		int PAHH500=               0;
		int PALL500=               0;
		int PT500_STAT =           1;
		String PAH500_Discrp =     "Check for high alarm";
		String PAL500_Discrp_LO =  "Check for low alarm";
		String PAHH500_Discrp_SD = "Check for high shutdown";
		String PALL500_Discrp_SD = "Check for low shutdown";
		String PT500_ENG      =    "PSIG";
		String SucSystem =         "Compressor suction";
		
		
		String PT2500 =            "PT500 Compressor discharge Pressure";
		int PI2500=                450;
		int PSH2500=               400;
		int PSL2500=               300;
		int PSHH2500=              420;
		int PSLL2500=              200;
		int PAH2500=               0;
		int PAL2500=               0;
		int PAHH2500=              0;
		int PALL2500=              0;
		int PT2500_STAT =          1;
		String PAH2500_Discrp =     "Check for high alarm";
		String PAL2500_Discrp_LO =  "Check for low alarm";
		String PAHH2500_Discrp_SD = "Check for high shutdown";
		String PALL2500_Discrp_SD = "Check for low shutdown";
		String DischSystem =        "Compressor discharge";
		String PT2500_Discrp =      " ";
		String PT2500_ENG      =    "PSIG";
		
		
		
//=========================================High Alarm Module================================================================//
                                                            		
		// High ALarm parameters data object for leaf structure
		Object[][] input = new Object[][] { { VT100, VI100, VSH100, VAH100, VT100_STAT, VAH100_Discrp,VT100_ENG },
				                            { VT200, VI200, VSH200, VAH200, VT200_STAT, VAH200_Discrp,VT200_ENG },
				                            { VT300, VI300, VSH300, VAH300, VT300_STAT, VAH300_Discrp,VT300_ENG }, 
				                            { PT1100, PI1100, PSH1100, PAH1100, PT1100_STAT, PAH1100_Discrp,PT1100_ENG },};
		// High ALarm parameters data object
		for (int raw = 0; raw <= 3; raw++) {
			for (int i = 0; i < 7; i++) {
				if (i == 0) {
					transmtag = (String) input[raw][i];
					//System.out.println("Transmitter Discription:" + "  " + transmtag);
				}

				if (i == 1) {
					transmreading = (int) input[raw][i];
					//System.out.println("Transmitter READING" + "  " + transmreading);
				}

				else if (i == 2) {
					setpoint = (int) input[raw][i];
					//System.out.println("SET-POINT" + "  " + setpoint);
				}

				else if (i == 3) {
					alarmFlag = (int) input[raw][i];

					//System.out.println("Alarm Flag" + "  " + alarmFlag);
				} else if (i == 4) {
					transmitter_status = (int) input[raw][i];
					//System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
				}

				else if (i == 5) {
					alarm_Discrp = (String) input[raw][i];
					//System.out.println(alarm_Discrp);
				}
				else if (i == 6) {
					transm_eng= (String) input[raw][i];
					//System.out.println(transm_eng);
				}
				else if (i == 7) {
					transm_eng= (String) input[raw][i];
					//System.out.println("Transmitter Discription:" + "  " + transmreading+transm_eng);
				}
				
			}
			// call the leaf alarm high with the parameters for the high alarm conditions
			ComAuxSys alarmhigh = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
					alarm_Discrp,transm_eng);
			alarmhigh.detectHighAlarm();
			//System.out.println("================================");
		}
///======================================== Low Alarm Module====================================================///
		// Low ALarm parameters data object
		Object[][] input_L = new Object[][] { { VT100, VI100, VSL100, VAL100, VT100_STAT, VAL100_Discrp_LO,VT100_ENG},
				                              { VT200, VI200, VSL200, VAL200, VT200_STAT, VAL200_Discrp_LO,VT200_ENG },
				                              { VT300, VI300, VSL300, VAL300, VT300_STAT, VAL300_Discrp_LO,VT300_ENG },
				                              { PT1100, PI1100, PSL1100, PAL1100, PT1100_STAT, PAL1100_Discrp_LO,PT1100_ENG }};
		//map each low alarm parameter to each specific field to be send to the low alarm leaf class 
		for (int raw = 0; raw <= 3; raw++) {
			for (int i = 0; i <= 6; i++) {
				if (i == 0) {
					transmtag = (String) input_L[raw][i];
					//System.out.println("Transmitter Discription:" + "  " + transmtag);
				}

				if (i == 1) {
					transmreading = (int) input_L[raw][i];
					//System.out.println("Transmitter READING" + "  " + transmreading);
				}

				else if (i == 2) {
					setpoint = (int) input_L[raw][i];
					//System.out.println("SET-POINT" + "  " + set-point);
				}

				else if (i == 3) {
					alarmFlag = (int) input_L[raw][i];

					//System.out.println("Alarm Flag" + "  " + alarmFlag);
				} else if (i == 4) {
					transmitter_status = (int) input_L[raw][i];
					//System.out.println("Transmitter Signal Integrity" + " " + transmitter_status);
				}

				else if (i == 5) {
					alarm_Discrp = (String) input_L[raw][i];
					//System.out.println(alarm_Discrp);
				}
				else if (i == 6) {
					transm_eng = (String) input_L[raw][i];
					//System.out.println(transm_eng);
				}

			}
			// call the low alarm leaf with parameters associated with low alarm conditions 
			ComAuxSys alarmLow = new LowAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp,transm_eng);
			alarmLow.detectLowAlarm();
			//System.out.println("================================");
		}

///================================================Permissive module====================================================///
		// permissive parameters data object
		Object[][] input_P = new Object[][] { { VT100,VT100_STAT,VPH100 ,HIS500 , VPH100_Discrp },
				                              { VT200,VT200_STAT,VPH200 ,HIS500 , VPH200_Discrp },
				                              { VT300,VT300_STAT,VPH300 ,HIS500 , VPH300_Discrp}};
		//map each low alarm parameter to each specific field to be send to the low alarm leaf class 
		for (int raw = 0; raw < 3; raw++) {
			for (int i = 0; i <= 5; i++) {
				if (i == 0) {
					transmtag = (String) input_P[raw][i];
					//System.out.println("Transmitter Discription:" + "  " + transmtag);
				}
				else if (i == 1) {
					transmitter_status = (int) input_P[raw][i];
					//System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
				}
				else if (i == 2) {
					permissvFlag = (int) input_P[raw][i];

					//System.out.println("Alarm Flag" + "  " + permissvFlag);
				} 
				else if (i == 3) {
					c_status = (int) input_P[raw][i];
					//System.out.println("Transmitter Singal Intigrity" + " " + c_status);
				}

				else if (i == 4) {
					perm_Discrp = (String) input_P[raw][i];
					//System.out.println(perm_Discrp);
				}

			}
			// call the low alarm leaf with parameters associated with low alarm conditions 
			ComAuxSys auxvibStagVIB1 = new AuxVibPermissive (transmtag,transmitter_status,permissvFlag,c_status,perm_Discrp);
			auxvibStagVIB1.detectPermssive();
			//System.out.println("================================");
		}
		
		
//		// Permissive module 
//		ComAuxSys auxvibStagVIB1 = new AuxVibPermissive (transmtag,transmitter_status,permissvFlag,C_STATUS,alarm_Discrp);
//		ComAuxSys auxvibStagVIB2 = new AuxVibPermissive (VT200,VT200_STAT,VPH200,C_STATUS," ");
//		ComAuxSys auxvibStagVIB3 = new AuxVibPermissive (VT300,VT300_STAT,VPH300,C_STATUS," ");
//						
//		auxvibStagVIB1.detectPermssive();
//		auxvibStagVIB2.detectPermssive();
//		auxvibStagVIB3.detectPermssive();
//		
////==================================Auxiliary Systems Composite======================================================////
		 

//============================================High Alarm Module================================================================//
		
				// High ALarm parameters data object
		Compsite aux = new Compsite ();
				Object[][] input_SD = new Object[][] { { PT100, PI100, PSH100, PAH100, PT100_STAT, PAH100_Discrp,PT100_ENG },
						                               { TT100, TI100, TSH100, TAH100, TT100_STAT, TAH100_Discrp,TT100_ENG },
						                               { PT500, PI500, PSH500, PAH500, PT500_STAT, PAH500_Discrp,PT500_ENG },
						                               { PT2500, PI2500, PSH2500, PAH2500, PT2500_STAT, PAH2500_Discrp,PT2500_ENG } };
				// High ALarm parameters data object
				for (int raw = 0; raw < 3; raw++) {
					for (int i = 0; i <= 7; i++) {
						if (i == 0) {
							transmtag = (String) input_SD[raw][i];
							// System.out.println("Transmitter Discription:" + " " + transmtag);
						}

						else if (i == 1) {
							transmreading = (int) input_SD[raw][i];
							// System.out.println("Transmitter READING" + " " + transmreading);
						}

						else if (i == 2) {
							setpoint = (int) input_SD[raw][i];
							// System.out.println("SET-POINT" + " " + setpoint);
						}

						else if (i == 3) {
							alarmFlag = (int) input_SD[raw][i];

							// System.out.println("Alarm Flag" + " " + alarmFlag);
						} else if (i == 4) {
							transmitter_status = (int) input_SD[raw][i];
							// System.out.println("Transmitter Singal Intigrity" + " " +
							// transmitter_status);
						}

						else if (i == 5) {
							alarm_Discrp = (String) input_SD[raw][i];
							// System.out.println("Alarm discription"+" "+alarm_Discrp);
						}

						else if (i == 6) {
							SD_transm_eng = (String) input_SD[raw][i];

							// System.out.println("Transmitter Engineering Unit:" + SD_transm_eng );
						}

					}
					// call the leaf alarm high with the parameters for the high alarm conditions
					if (raw == 0) {

						ComAuxSys auxcooling = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag,
								transmitter_status, alarm_Discrp, SD_transm_eng);
						aux.addsys(auxcooling);
						// aux.detectHighAlarm();
						// System.out.println("================================");
					}

					if (raw == 1) {

						ComAuxSys auxoil = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag,
								transmitter_status, alarm_Discrp, SD_transm_eng);
						aux.addsys(auxoil);
						// aux.detectHighAlarm();
						// System.out.println("================================");
					}

					if (raw == 2) {
						ComAuxSys comSuction = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag,
								transmitter_status, alarm_Discrp, SD_transm_eng);
						aux.addsys(comSuction);
						// aux.detectHighAlarm();
						// System.out.println("================================");
					}

					if (raw == 3) {
						ComAuxSys comDischarge = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag,
								transmitter_status, alarm_Discrp, SD_transm_eng);
						aux.addsys(comDischarge);
						// aux.detectHighAlarm();
						// System.out.println("================================");
					}

				}
				aux.detectHighAlarm();

	

//============================================= Auxiliary System low Alarm===================================================//

////Low aLarm parameters data object

		Object[][] input_alm_lo = new Object[][] { { PT100, PI100, PSL100, PAL100, PT100_STAT, PAL100_Discrp_LO,PT100_ENG },
						                               { TT100, TI100, TSL100, TAL100, TT100_STAT, TAL100_Discrp_LO,TT100_ENG },
						                               { PT500, PI500, PSL500, PAL500, PT500_STAT, PAL500_Discrp_LO,PT500_ENG },
						                               { PT2500, PI2500, PSL2500, PAL2500, PT2500_STAT, PAL2500_Discrp_LO,PT2500_ENG } };
				// low aLarm parameters iteration
				for (int raw = 0; raw < 3; raw++) {
					for (int i = 0; i <=7; i++) {
						if (i == 0) {
							transmtag = (String) input_alm_lo[raw][i];
							//System.out.println("Transmitter Discription:" + "  " + transmtag);
						}

						else if (i == 1) {
							transmreading = (int) input_alm_lo[raw][i];
							//System.out.println("Transmitter READING" + "  " + transmreading);
						}

						else if (i == 2) {
							setpoint = (int) input_alm_lo[raw][i];
							//System.out.println("SET-POINT" + "  " + setpoint);
						}

						else if (i == 3) {
							alarmFlag = (int) input_alm_lo[raw][i];

							//System.out.println("Alarm Flag" + "  " + alarmFlag);
						} else if (i == 4) {
							transmitter_status = (int) input_alm_lo[raw][i];
							//System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
						}

						else if (i == 5) {
							alarm_Discrp = (String) input_alm_lo[raw][i];
							//System.out.println("Alarm discription"+" "+alarm_Discrp);
						}
						
						else if (i == 6) {
							SD_transm_eng = (String) input_alm_lo[raw][i];
					
							//System.out.println("Transmitter Engineering Unit:" + SD_transm_eng );
						}
						
					}
					
					// call the leaf alarm high with the parameters for the high alarm conditions
					if (raw == 0) {
						
						ComAuxSys auxcooling     = new LowAlarm(transmtag,transmreading,setpoint,alarmFlag,transmitter_status,alarm_Discrp,SD_transm_eng); 
						aux.addsys(auxcooling);
						//System.out.println("================================");
					}

					if (raw == 1) {
					
						ComAuxSys auxoil     = new LowAlarm(transmtag,transmreading,setpoint,alarmFlag,transmitter_status,alarm_Discrp,SD_transm_eng);
						aux.addsys(auxoil);
						//aux.detectHighAlarm();
						//System.out.println("================================");
					}

					if (raw == 2) {
						ComAuxSys comSuction    = new LowAlarm(transmtag,transmreading,setpoint,alarmFlag,transmitter_status,alarm_Discrp,SD_transm_eng);
						aux.addsys(comSuction);
						//aux.detectHighAlarm();
						//System.out.println("================================");
					}

					if (raw == 3) {
						ComAuxSys comDischarge    = new LowAlarm(transmtag,transmreading,setpoint,alarmFlag,transmitter_status,alarm_Discrp,SD_transm_eng);
						aux.addsys(comDischarge);
						//aux.detectHighAlarm();
						//System.out.println("================================");
										}
					
							
				}	
				aux.detectLowAlarm();
//============================================Compressor High Shutdown=================================================================================
				
				Object[][] input_SD_HI = new Object[][] { { PT100, PI100, PSHH100, PAHH100, PT100_STAT, PAHH100_Discrp_SD,PT100_ENG },
		                                                  { TT100, TI100, TSHH100, TAHH100, TT100_STAT, TAHH100_Discrp_SD,TT100_ENG },
		                                                  { PT500, PI500, PSHH500, PAHH500, PT500_STAT, PAHH500_Discrp_SD,PT500_ENG },
		                                                  { PT2500,PI2500,PSHH2500,PAHH2500,PT2500_STAT,PAHH2500_Discrp_SD,PT2500_ENG } };
		        // High ALarm parameters data object
				for (int raw = 0; raw < 3; raw++) {
					for (int i = 0; i <= 6; i++) {
						if (i == 0) {
							transmtag = (String) input_SD_HI[raw][i];
		                   //System.out.println("Transmitter Discription:" + "  " + transmtag);
						}

						else if (i == 1) {
							transmreading = (int) input_SD_HI[raw][i];
		                    //System.out.println("Transmitter READING" + "  " + transmreading);
						}

						else if (i == 2) {
							setpoint = (int) input_SD_HI[raw][i];
		                    //System.out.println("SET-POINT" + "  " + setpoint);
						}

						else if (i == 3) {
							alarmFlag = (int) input_SD_HI[raw][i];

		                    //System.out.println("Alarm Flag" + "  " + alarmFlag);
						} else if (i == 4) {
							transmitter_status = (int) input_SD_HI[raw][i];
		                    //System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
						}

						else if (i == 5) {
							alarm_Discrp = (String) input_SD_HI[raw][i];
		                    //System.out.println("Alarm discription"+" "+alarm_Discrp);
						}

						else if (i == 6) {
							SD_transm_eng = (String) input_SD_HI[raw][i];

		                   //System.out.println("Transmitter Engineering Unit:" + SD_transm_eng );
						}

					}
		                  // call the leaf alarm high with the parameters for the high alarm conditions
					if (raw == 0) {
						ComAuxSys auxcooling = new Highshutdown(transmtag, transmreading, setpoint, alarmFlag,transmitter_status, alarm_Discrp, SD_transm_eng);
						aux.addsys(auxcooling);
		                //aux.detectHighAlarm();
		                //System.out.println("================================");
					}

					if (raw == 1) {

						ComAuxSys auxoil = new Highshutdown(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp, SD_transm_eng);
						aux.addsys(auxoil);
		                //aux.detectHighAlarm();
		                //System.out.println("================================");
					}

					if (raw == 2) {
						ComAuxSys comSuction = new Highshutdown(transmtag, transmreading, setpoint, alarmFlag,transmitter_status, alarm_Discrp, SD_transm_eng);
						aux.addsys(comSuction);
		                 //aux.detectHighAlarm();
		                 //System.out.println("================================");
					}

					if (raw == 3) {
						ComAuxSys comDischarge = new Highshutdown(transmtag, transmreading, setpoint, alarmFlag,transmitter_status, alarm_Discrp,SD_transm_eng);
						aux.addsys(comDischarge);
		                //aux.detectHighAlarm();
		                //System.out.println("================================");
					}
				}
					aux.detectHighShutdown();
//============================================Compressor Low Shutdown=================================================================================
					
					Object[][] input_SD_LO = new Object[][] { { PT100, PI100, PSLL100, PALL100, PT100_STAT, PALL100_Discrp_SD,PT100_ENG },
			                                                  { TT100, TI100, TSLL100, TALL100, TT100_STAT, TALL100_Discrp_SD,TT100_ENG },
			                                                  { PT500, PI500, PSLL500, PALL500, PT500_STAT, PALL500_Discrp_SD,PT500_ENG },
			                                                  { PT2500,PI2500,PSLL2500,PALL2500,PT2500_STAT,PALL2500_Discrp_SD,PT2500_ENG } };
			        // High ALarm parameters data object
					for (int raw = 0; raw < 3; raw++) {
						for (int i = 0; i <= 6; i++) {
							if (i == 0) {
								transmtag = (String) input_SD_LO[raw][i];
			                   System.out.println("Transmitter Discription:" + "  " + transmtag);
							}

							else if (i == 1) {
								transmreading = (int) input_SD_LO[raw][i];
			                    System.out.println("Transmitter READING" + "  " + transmreading);
							}

							else if (i == 2) {
								setpoint = (int) input_SD_LO[raw][i];
			                    System.out.println("SET-POINT" + "  " + setpoint);
							}

							else if (i == 3) {
								alarmFlag = (int) input_SD_LO[raw][i];

			                    System.out.println("Alarm Flag" + "  " + alarmFlag);
							} else if (i == 4) {
								transmitter_status = (int) input_SD_LO[raw][i];
			                    System.out.println("Transmitter Singal Intigrity" + " " + transmitter_status);
							}

							else if (i == 5) {
								alarm_Discrp = (String) input_SD_LO[raw][i];
			                    System.out.println("Alarm discription"+" "+alarm_Discrp);
							}

							else if (i == 6) {
								SD_transm_eng = (String) input_SD_LO[raw][i];

			                   System.out.println("Transmitter Engineering Unit:" + SD_transm_eng );
							}

						}
			                  // call the leaf alarm high with the parameters for the high alarm conditions
						if (raw == 0) {
							ComAuxSys auxcooling = new Lowshutdown(transmtag, transmreading, setpoint, alarmFlag,transmitter_status, alarm_Discrp, SD_transm_eng);
							aux.addsys(auxcooling);
			                //aux.detectHighAlarm();
			                //System.out.println("================================");
						}

						if (raw == 1) {

							ComAuxSys auxoil = new Lowshutdown(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp, SD_transm_eng);
							aux.addsys(auxoil);
			                //aux.detectHighAlarm();
			                //System.out.println("================================");
						}

						if (raw == 2) {
							ComAuxSys comSuction = new Lowshutdown(transmtag, transmreading, setpoint, alarmFlag,transmitter_status, alarm_Discrp, SD_transm_eng);
							aux.addsys(comSuction);
			                 //aux.detectHighAlarm();
			                 //System.out.println("================================");
						}

						if (raw == 3) {
							ComAuxSys comDischarge = new Lowshutdown(transmtag, transmreading, setpoint, alarmFlag,transmitter_status, alarm_Discrp,SD_transm_eng);
							aux.addsys(comDischarge);
			                //aux.detectHighAlarm();
			                //System.out.println("================================");
						}
				}
						aux.detectLowShutdown();	
	        }
			
	}

	

