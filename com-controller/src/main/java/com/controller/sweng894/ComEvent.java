package com.controller.sweng894;

class ComEvent {

///========================================Alarm Module====================================================///

	public static int[] leafevent(String SenTagIn, int senReadingIn, int senAlmHiSPIn, int senShutDwnHiSPIn,
			int senAlmLoSPIn, int senAlmHiFlgIn, int senShutDwnHiFlgIn, int senAlmLoFlgIn, int senPermissFlgIn,
			int sensSTATIn, int c_STATIn, String senAlmDiscrpHiIn, String senShutdwnDiscrpHiIn, String senAlmDiscrpLoIn,
			String senPermissDiscrpIn, String senEngUnitIn) {

		// Stage-1 I/O instruments
		String SenTag = SenTagIn; // "1ST Stage Vibration Sensor";
		int senReading = senReadingIn; // First Stage Vibration sensor reading
		int senAlmHiSP = senAlmHiSPIn; // First Stage vibration alarm set-point
		int senShutDwnHiSP = senShutDwnHiSPIn; // Shutdown high set-point
		int senAlmLoSP = senAlmLoSPIn; //
		
		int senAlmHiFlg = senAlmHiFlgIn; // alarm high flag
		int senShutDwnHiFlg = senShutDwnHiFlgIn;
		int senAlmLoFlg = senAlmLoFlgIn; // alarm low flag
	
		int senPermissFlg = senPermissFlgIn;// 2nd Stage Vibration permissive
		String senEngUnit = senEngUnitIn;
		int sensSTAT = sensSTATIn; // Sensor signal integrity
		int c_STAT = c_STATIn; // Sensor signal integrity

		String senAlmDiscrpHi = senAlmDiscrpHiIn;
		String senShutdwnDiscrpHi = senShutdwnDiscrpHiIn;
		String senAlmDiscrpLo = senAlmDiscrpLoIn;
		// String senShutdwnDiscrpLo= senShutdwnDiscrpLoIn;
		String senPermissDiscrp = senPermissDiscrpIn;
		// String CoolingSystem = "Compressor Cooling System";

		String transmtag = "initialized";
		int transmreading = 0; // sensor reading
		int setpointLo = 0; // Alarm OR Shutdown set-point
		int setpointHi = 0; // Alarm OR Shutdown set-point
		int FlagLo = 0; // alarm flag
		int FlagHi = 0; // alarm flag
		int transmitter_status = 0; // sensor signal integrity
		int c_status = 0; // compressor status
		String alarm_DiscrpLo = "ALARM logic initilized ";
		String alarm_DiscrpHi = "ALARM logic initilized ";
		String perm_Discrp = "PERMISSIVE logic initilized ";
		String transm_eng = "engineering unit";
		String SD_transm_eng = "";

		Object[] input_L = new Object[] { SenTag, senReading, senAlmHiSP, senShutDwnHiSP, senAlmLoSP, senAlmHiFlg,
				senShutDwnHiFlg, senAlmLoFlg, sensSTAT, c_STAT, senAlmDiscrpHi, senShutdwnDiscrpHi, senAlmDiscrpLo,
				senPermissDiscrp, senEngUnit };

		for (int i = 0; i < 15; i++) {
			if (i == 0) {
				transmtag = (String) input_L[i];
				// System.out.println("Transmitter Discription:" + " " + transmtag);
			}
			else if (i == 1) {
				transmreading = (int) input_L[i];
				// System.out.println("Transmitter READING" + " " +transmreading);
			} else if (i == 2) {
				senAlmHiSP = (int) input_L[i];
				// System.out.println("Sensor high alarm set point" + " " +senAlmHiSP);
			} else if (i == 3) {
				senShutDwnHiSP = (int) input_L[i];
				// System.out.println("Sensor high shutdown set point" + " " +senShutDwnHiSP);
			} else if (i == 4) {
				senAlmLoSP = (int) input_L[i];
				// System.out.println("Sensor Low alarm setpoint" + " " +senAlmLoSP);
			} else if (i == 5) {
				senAlmHiFlg = (int) input_L[i];
				// System.out.println("Sensor high alarm flag"+ senAlmHiFlg);
			} else if (i == 6) {
				senShutDwnHiFlg = (int) input_L[i];
				// System.out.println("Sensor high shutdown flag:" +senShutDwnHiFlg);
			} else if (i == 7) {
				senAlmLoFlg = (int) input_L[i];
				// System.out.println("Sensor low alarm flag:"+ senAlmLoFlg);
			} else if (i == 8) {
				sensSTAT = (int) input_L[i];
				// System.out.println("Sensor status:"+ sensSTAT);
			} else if (i == 9) {
				c_STAT = (int) input_L[i];
				// System.out.println("Compressor status:"+ c_STAT);
			} else if (i == 10) {
				senAlmDiscrpHi = (String) input_L[i];
				// System.out.println("Sensor high alarm description:"+senAlmDiscrpHi);
			} else if (i == 11) {
				senShutdwnDiscrpHi = (String) input_L[i];
				// System.out.println("Sensor high shutdown description:"+ senShutdwnDiscrpHi);
			} else if (i == 12) {
				senAlmDiscrpLo = (String) input_L[i];
				// System.out.println("Sensor low alarm description:"+ senAlmDiscrpLo);
			} else if (i == 13) {
				senPermissDiscrp = (String) input_L[i];
				// System.out.println("Sensor Permissive description:" + senPermissDiscrp);
			} else if (i == 14) {
				senEngUnit = (String) input_L[i];
				// System.out.println("engineering unit:"+ senEngUnit);
			}
		}
		System.out.println("================================");
		// call the alarm leaf with parameters associated with low or high alarm
		// conditions

		ComAuxSys alarmLow = new LowAlarm(transmtag, transmreading, senAlmLoSP, senAlmLoFlg, sensSTAT, alarm_DiscrpLo,
				senEngUnit);

		ComAuxSys alarmHigh = new HighAlarm(transmtag, transmreading, senAlmHiSP,senAlmHiFlg, sensSTAT, alarm_DiscrpHi,
				senEngUnit);

		ComAuxSys PermissVib = new AuxVibPermissive(transmtag, sensSTAT, senPermissFlg, c_status, senPermissDiscrp);

		ComAuxSys shutdwnHigh = new Highshutdown(transmtag, transmreading, senShutDwnHiSP,senShutDwnHiFlg, sensSTAT,
				senShutdwnDiscrpHi, senEngUnit);

		senAlmLoFlg = alarmLow.detectLowAlarm();
		senAlmHiFlg = alarmHigh.detectHighAlarm();
		senPermissFlg = PermissVib.detectPermssive();
		senShutDwnHiFlg = shutdwnHigh.detectHighShutdown();
		int[] flag = new int[4];
		flag[0] = senAlmLoFlg;
		flag[1] = senAlmHiFlg;
		flag[2] = senPermissFlg;
		flag[3] = senShutDwnHiFlg;

		return flag;

	}

	public static int[] compsiteEvent(String SenTagIn, int senReadingIn, int senAlmHiSPIn, int senShutDwnHiSPIn,
			int senAlmLoSPIn, int senShutDwnLoSPIn, int senAlmHiFlgIn, int senShutDwnHiFlgIn, int senAlmLoFlgIn,
			int senShutDwnLoFlgIn, int sensSTATIn, String senAlmDiscrpHiIn, String senShutdwnDiscrpHiIn,
			String senAlmDiscrpLoIn, String senShutdwnDiscrpLoIn, String senEngUnitIn, ComAuxSys auxcooling) {
		// Stage-1 I/O instruments
		String SenTag = SenTagIn; // "1ST Stage Vibration Sensor";
		int senReading = senReadingIn; // First Stage Vibration sensor reading
		int senAlmHiSP = senAlmHiSPIn; // First Stage vibration alarm set-point
		int senShutDwnHiSP = senShutDwnHiSPIn; // Shutdown high set-point
		int senAlmLoSP = senAlmLoSPIn;
		int senShutDwnLoSP = senShutDwnLoSPIn;
		int senAlmHiFlg = senAlmHiFlgIn; // alarm high flag
		int senShutDwnHiFlg = senShutDwnHiFlgIn;
		int senAlmLoFlg = senAlmLoFlgIn;
		int senShutDwnLoFlg = senShutDwnLoFlgIn;
		int sensSTAT = sensSTATIn; // Sensor signal integrity
		String senAlmDiscrpLo = senAlmDiscrpLoIn;
		String senAlmDiscrpHi = senAlmDiscrpHiIn;
		String senShutdwnDiscrpHi = senShutdwnDiscrpHiIn;
		String senShutdwnDiscrpLo = senShutdwnDiscrpLoIn;
		// String senPermissDiscrp= "Check for permissive*";
		// String CoolingSystem = "Compressor Cooling System";
		String senEngUnit = senEngUnitIn;

		String transmtag = "initialized";
		int transmreading = 0; // sensor reading
		int setpointLo = 0; // Alarm OR Shutdown set-point
		int setpointHi = 0; // Alarm OR Shutdown set-point
		int alarmFlagLo = 0; // alarm flag
		int alarmFlagHi = 0; // alarm flag
		int transmitter_status = 0; // sensor signal integrity
		int c_status = 0; // compressor status
		String alarm_DiscrpLo = "ALARM logic initilized ";
		String alarm_DiscrpHi = "ALARM logic initilized ";
		String perm_Discrp = "PERMISSIVE logic initilized ";
		String transm_eng = "engineering unit";
		String SD_transm_eng = "";
		Compsite aux = new Compsite();

		Object[] input_L = new Object[] { SenTag, senReading, senAlmHiSP, senShutDwnHiSP, senAlmLoSP, senShutDwnLoSP,
				senAlmHiFlg, senShutDwnHiFlg, senAlmLoFlg, senShutDwnLoFlg, sensSTAT, senAlmDiscrpHi,
				senShutdwnDiscrpHi, senAlmDiscrpLo, senShutdwnDiscrpLo, senEngUnit };
		// map event input parameters to event leaf

		for (int i = 0; i < 16; i++) {
			if (i == 0) {
				transmtag = (String) input_L[i];
				// System.out.println("Transmitter Discription:" + " " + transmtag);
			}
			else if (i == 1) {
				transmreading = (int) input_L[i];
				// System.out.println("Transmitter READING" + " " +transmreading);
			}
			else if (i == 2) {
				senAlmHiSP = (int) input_L[i];
				// System.out.println("senAlmHiSP" + " " +senAlmHiSP);
			}
			else if (i == 3) {
				senShutDwnHiSP = (int) input_L[i];
				// System.out.println("senShutDwnHiSP" + " " +senShutDwnHiSP);
			} else if (i == 4) {
				senAlmLoSP = (int) input_L[i];
				// System.out.println("senAlmLoSP" + " " +senAlmLoSP);
			}
			else if (i == 5) {
				senShutDwnLoSP = (int) input_L[i];
				// System.out.println("senShutDwnLoSP" + " " +senShutDwnLoSP);
			} else if (i == 6) {
				senAlmHiFlg = (int) input_L[i];
				// System.out.println("senAlmHiFlg" + " " +senAlmHiFlg);
			}
			else if (i == 7) {
				senShutDwnHiFlg = (int) input_L[i];
				// System.out.println("senShutDwnHiFlg"+" "+senShutDwnHiFlg);
			} else if (i == 8) {
				senAlmLoFlg = (int) input_L[i];
				// System.out.println("senAlmLoFlg"+" "+senAlmLoFlg);
			} else if (i == 9) {
				senShutDwnLoFlg = (int) input_L[i];
				// System.out.println("senShutDwnLoFlg"+" "+senShutDwnLoFlg);
			}
			else if (i == 10) {
				sensSTAT = (int) input_L[i];
				// System.out.println("sensSTAT"+""+sensSTAT);
			} else if (i == 11) {
				senAlmDiscrpHi = (String) input_L[i];
				// System.out.println("senAlmDiscrpHi"+" "+senAlmDiscrpHi);
			}
			else if (i == 12) {
				senShutdwnDiscrpHi = (String) input_L[i];
				// System.out.println("senShutdwnDiscrpHi"+" "+senShutdwnDiscrpHi);
			} else if (i == 13) {
				senAlmDiscrpLo = (String) input_L[i];
				// System.out.println("senAlmDiscrpLo"+" "+senAlmDiscrpLo);
			} else if (i == 14) {
				senShutdwnDiscrpLo = (String) input_L[i];
				// System.out.println("senShutdwnDiscrpLo"+" "+senShutdwnDiscrpLo);
			}
			else if (i == 15) {
				senEngUnit = (String) input_L[i];
				// System.out.println("senEngUnit"+" "+senEngUnit);
			}
		}
		// call composite with different alarm or shutdown parameters
		int[] flagComposite = new int[4];
		
		auxcooling = new LowAlarm(transmtag, transmreading, senAlmLoSP, senAlmLoFlg, sensSTAT, senAlmDiscrpLo,senEngUnit);
		aux.addsys(auxcooling);
		int Flg = aux.detectLowAlarm();
		flagComposite[0] = Flg;

		auxcooling = new HighAlarm(transmtag, transmreading, senAlmHiSP, senAlmHiFlg, sensSTAT, senAlmDiscrpHi,senEngUnit);
		aux.addsys(auxcooling);
		senAlmHiFlg = aux.detectHighAlarm();
		flagComposite[1] = senAlmHiFlg;

		auxcooling = new Lowshutdown(transmtag, transmreading, senShutDwnLoSP, senShutDwnLoFlg, sensSTAT,senShutdwnDiscrpLo, senEngUnit);
		aux.addsys(auxcooling);
		senShutDwnLoFlg = aux.detectLowShutdown();
		flagComposite[2] = senShutDwnLoFlg;

		auxcooling = new Highshutdown(transmtag, transmreading, senShutDwnHiSP, senShutDwnHiFlg, sensSTAT,senShutdwnDiscrpHi, senEngUnit);
		aux.addsys(auxcooling);
		senShutDwnHiFlg = aux.detectHighShutdown();
		flagComposite[3] = senShutDwnHiFlg;
		
		return flagComposite;
	}
}
