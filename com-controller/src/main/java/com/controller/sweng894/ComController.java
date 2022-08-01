package com.controller.sweng894;

import java.util.Scanner;

import javax.swing.JFrame;

import com.google.common.primitives.Booleans;

public class ComController {

	public static void main(String[] args) throws InterruptedException {

		// alarm disable requests
		int Stg1VibDisableReq = 0;
		int Stg2VibDisableReq = 0;
		int Stg3VibDisableReq = 0;
		int auxcoolingDisableReq = 0;
		int auxoilDisableReq = 0;
		int suctionDisableReq = 0;
		int dischargeDisableReq = 0;

		int HIS500 = 0; // Compressor start/stop status 0= stopped, 1= ready to start, 2= Running
		// overall shutdown word

		int HIS500_STR = 0; // Compressor start command
		int HIS500_STP = 0; // Compressor stop command
		int HIS500_LOAD = 0; // Compressor loading status 0= unloaded, 1 = loading, 2 = loaded, 3 unloading,
		int shutdownWord = 0;
		String comRequest = " ";
		String driveFeedBack = " ";

		//System.out.println("command=" + shutdownWord);
		// ======== User Interface start=====//
		ComFrame myframe = new ComFrame();
		Thread.sleep(0000);
		shutdownWord = myframe.Resetcommand;
		System.out.println("out of loop shutdownWord=" + shutdownWord);
		Thread.sleep(0000);
		HIS500_STR = myframe.Startcommand;
		//System.out.println("HIS500_STR=" + HIS500_STR);

		// The following 7 variables are for instruments increment readings - for
		// simulation purposes only reading simulation only
		int VT100_increment = 0;
		int VT200_increment = 0;
		int VT300_increment = 0;
		int PT100_increment = 0;
		int TT100_increment = 0;
		int PT500_increment = 0;
		int PT2500_increment = 0;

		do {
			Thread.sleep(2000);
			shutdownWord = myframe.Resetcommand;
			System.out.println("Inside loop shutdownWord=" + shutdownWord);
			HIS500_STR = myframe.Startcommand;
			System.out.println("HIS500_STR=" + myframe.Startcommand);
			HIS500_STP = myframe.Stopcommand;
			//System.out.println("HIS500_STP=" + myframe.Stopcommand);

			// Simulation values.
			VT100_increment = 3;
			VT200_increment = 0;
			VT300_increment = 0;
			PT100_increment = 0;
			TT100_increment = 0;
			PT500_increment = 0;
			PT2500_increment = 0;

			int[] TransmitterReading = new int[7]; // test inputs
			

			int permissWord = 0; // overall permissive word
			// Call the simulation class simulate the compressor variables
			ComSimulation sim = new ComSimulation();
			TransmitterReading = sim.comTransmitterSim(HIS500, VT100_increment, VT200_increment, VT300_increment,
					PT100_increment, TT100_increment, PT500_increment, PT2500_increment);

			String transmtag = "initialized";
			int transmreading = 0; // sensor reading
			int setpoint = 0; // Alarm OR Shutdown set-point
			int alarmFlag = 0; // alarm flag
			int transmitter_status = 0; // sensor signal integrity
			int c_status = 0; // compressor status
			String alarm_Discrp = "ALARM logic initilized ";
			String perm_Discrp = "PERMISSIVE logic initilized ";
			String transm_eng = "engineering unit";
			String SD_transm_eng = "";

			String VT100 = "1ST Stage Vibration Sensor";
			
			int VI100 = TransmitterReading[0]; // First Stage Vibration sensor reading
			
			int VSH100 = 5; // First Stage vibration alarm set-point
			int VSL100 = 2; //
			int VSHH100 = 10; // Shutdown high set-point
			int VAH100 = 0; // alarm high flag; 0 = cleared, 1 = alarm, 2 =disabled.
			int VAL100 = 0; // alarm low flag
			int VAHH100 = 0; // shutdown high flag
			int VPH100 = 0; // 2nd Stage Vibration permissive
			int VT100_STAT = 1; // Sensor signal integrity
			String VAH100_Discrp = "Check for high alarm";
			String VAL100_Discrp_LO = "Check for low alarm";
			String VAHH100_Discrp_SD = "Check for high shutdown";
			String VPH100_Discrp = "Check for permissive*";
			String VT100_ENG = "mils";
			myframe.VI100.setText("VT100" + "   " + VI100 + "   " + VT100_ENG);
			

			// Stage-2 I/O instruments
			String VT200 = "2ND Stage Vibration Sensor";
			int VI200 = TransmitterReading[1]; // Stage Vibration sensor reading
			int VSH200 = 6; // vibration high alarm set-point
			int VSL200 = 3; //
			int VSHH200 = 7; // Shutdown high set-point
			int VAH200 = 0; // alarm high flag
			int VAL200 = 0; // alarm low flag
			int VAHH200 = 0; // shutdown high flag
			int VPH200 = 0; // 2nd Stage Vibration permissive
			int VT200_STAT = 1; // Sensor signal integrity
			String VAH200_Discrp = "Check for high alarm";
			String VAL200_Discrp_LO = "Check for low alarm";
			String VAHH200_Discrp_SD = "Check for high shutdown";
			String VPH200_Discrp = "Check for permissive*";
			String VT200_ENG = "mils";
			myframe.VI200.setText("VT200" + "   " + VI200 + "   " + VT200_ENG);
			
			// Stage-3 I/O instruments
			String VT300 = "3RD Stage Vibration Sensor";
			int VI300 = TransmitterReading[2]; // Stage Vibration sensor reading
			int VSH300 = 4; // vibration high alarm set-point
			int VSL300 = 2; //
			int VSHH300 = 6; // Shutdown high set-point
			int VAH300 = 0; // alarm high flag
			int VAL300 = 0; // alarm low flag
			int VAHH300 = 0; // shutdown high flag
			int VPH300 = 0; // 2nd Stage Vibration permissive
			int VT300_STAT = 1; // Sensor signal integrity
			String VAH300_Discrp = "Check for high alarm";
			String VAL300_Discrp_LO = "Check for low alarm";
			String VAHH300_Discrp_SD = "Check for high shutdown";
			String VPH300_Discrp = "Check for permissive*";
			String VT300_ENG = "mils";
			myframe.VI300.setText("VT300" + "   " + VI300 + "   " + VT300_ENG);

			// Auxiliary Systems instrumentation tags

			String PT100 = "PT100 Compressor Cooling Pressure";
			int PI100 = TransmitterReading[3]; // Sensor Reading
			int PSH100 = 30; // Alarm High set-point
			int PSL100 = 15; // Alarm low set point
			int PSHH100 = 35; // Shutdown high set-point
			int PSLL100 = 10; // Shutdown set-point
			int PAH100 = 0; // alarm high flag
			int PAL100 = 0; // alarm low flag
			int PAHH100 = 0; // shutdown high flag
			int PALL100 = 0; // shutdown low flag
			int PT100_STAT = 1; // Sensor signal integrity
			String PAH100_Discrp = "Check for high alarm";
			String PAL100_Discrp_LO = "Check for low alarm";
			String PAHH100_Discrp_SD = "Check for high shutdown";
			String PALL100_Discrp_SD = "Check for low shutdown";
			String CoolingSystem = "Compressor Cooling System";
			String PT100_ENG = "PSIG";
			myframe.PI100.setText("PT100" + "   " + PI100 + "   " + PT100_ENG);

			String TT100 = "TT100 Oil System Temperature";
			int TI100 = TransmitterReading[4];
			int TSH100 = 210;
			int TSL100 = 190;
			int TSHH100 = 220;
			int TSLL100 = 180;
			int TAH100 = 0;
			int TAL100 = 0;
			int TAHH100 = 0;
			int TALL100 = 0;
			int TT100_STAT = 1;
			String TAH100_Discrp = "Check for high alarm";
			String TAL100_Discrp_LO = "Check for low alarm";
			String TAHH100_Discrp_SD = "Check for high shutdown";
			String TALL100_Discrp_SD = "Check for low shutdown";
			String TT100_ENG = "degC";
			String OilSystem = "Compressor Oil System";
			myframe.TI100.setText("TT100" + "   " + TI100 + "   " + TT100_ENG);

			String PT500 = "PT500 Compressor Suction Pressure";
			int PI500 = TransmitterReading[5];
			int PSH500 = 40;
			int PSL500 = 1;
			int PSHH500 = 42;
			int PSLL500 = 3;
			int PAH500 = 0;
			int PAL500 = 0;
			int PAHH500 = 0;
			int PALL500 = 0;
			int PT500_STAT = 1;
			String PAH500_Discrp = "Check for high alarm";
			String PAL500_Discrp_LO = "Check for low alarm";
			String PAHH500_Discrp_SD = "Check for high shutdown";
			String PALL500_Discrp_SD = "Check for low shutdown";
			String PT500_ENG = "PSIG";
			myframe.PI500.setText("PT500" + "   " + PI500 + "   " + PT500_ENG);

			String PT2500 = "PT2500 Compressor discharge Pressure";
			int PI2500 = TransmitterReading[6];
			int PSH2500 = 400;
			int PSL2500 = 300;
			int PSHH2500 = 420;
			int PSLL2500 = 5;
			int PAH2500 = 0;
			int PAL2500 = 0;
			int PAHH2500 = 0;
			int PALL2500 = 0;
			int PT2500_STAT = 1;
			String PAH2500_Discrp = "Check for high alarm";
			String PAL2500_Discrp_LO = "Check for low alarm";
			String PAHH2500_Discrp_SD = "Check for high shutdown";
			String PT2500_ENG = "PSIG";

			myframe.PI2500.setText("PT2500" + "   " + PI2500 + "   " + PT2500_ENG);

//=====================Drive======================//

//========leaf Events ( alarms, Permissive, and Shutdown)=================//
			boolean[] alarmVisablity = new boolean[16];// Over all user interface alarm visibility link.
			
			int[] AlmStatusFlags = new int[2];
			
			Stg1VibDisableReq = myframe.Stg1VibDisableReq;

			ComAlmStatusVIB alarmStatusVIB = new ComAlmStatusVIB();

			// ================stage-1=============== determine the alarm value
			ComLeafEvent Vibs = new ComLeafEvent();
			int[] flag = new int[4];
			flag = Vibs.leafevent(VT100, VI100, VSH100, VSHH100, VSL100, VAH100, VAHH100, VAL100, VPH100, VT100_STAT,
					HIS500, VAH100_Discrp, VAHH100_Discrp_SD, VAL100_Discrp_LO, VPH100_Discrp, VT100_ENG);

			if (Stg1VibDisableReq != 1) {
				VAL100 = flag[0];
				VAH100 = flag[1];
			} else if (Stg1VibDisableReq == 1) {
				int Stg1VibEnableReq = 0;
				AlmStatusFlags = alarmStatusVIB.alarmStatus(Stg1VibDisableReq, Stg1VibEnableReq, VAL100, VAH100);
				VAL100 = AlmStatusFlags[0];
				VAH100 = AlmStatusFlags[1];
			}
			if (VAL100 == 1) {
				alarmVisablity[0] = true;
			} else if (VAL100==0) {
				alarmVisablity[0] = false;
			}
			
			if (VAH100 == 1) {
				alarmVisablity[1] = true;
			}else if (VAH100 == 0) {
				alarmVisablity[1] = false;
			} 
			

			VPH100 = flag[2];
			VAHH100 = flag[3];
			
			// USER Interface Tags
			myframe.VAL100.setText("STG-1 VIBS ALARM  VAL100:" + VAL100);
			myframe.VAL100.setVisible(alarmVisablity[0]);
			
			myframe.VAH100.setText("STG-1 VIBS ALARM  VAH100:" + VAH100);
			myframe.VAH100.setVisible(alarmVisablity[1]);
			
			myframe.VPH100.setText("STG-1 PERMISSIVE  VPH100:" + VPH100);
			myframe.VAHH100.setText("STG-1 SHUTDOWN   VAHH100:" + VAHH100);

			// ===========================STAGE-2======================================================================//
		
			Stg2VibDisableReq = myframe.Stg2VibDisableReq;
			flag = Vibs.leafevent(VT200, VI200, VSH200, VSHH200, VSL200, VAH200, VAHH200, VAL200, VPH200, VT200_STAT,
					HIS500, VAH200_Discrp, VAHH200_Discrp_SD, VAL200_Discrp_LO, VPH200_Discrp, VT200_ENG);
			if (Stg2VibDisableReq != 1) {
				VAL200 = flag[0];
				VAH200 = flag[1];
			} else if (Stg2VibDisableReq == 1) {
				int Stg2VibEnableReq = 0;
				AlmStatusFlags = alarmStatusVIB.alarmStatus(Stg2VibDisableReq, Stg2VibEnableReq, VAL200, VAH200);
				VAL200 = AlmStatusFlags[0];
				VAH200 = AlmStatusFlags[1];
			}
			if (VAL200 == 1) {
				alarmVisablity[2] = true;
			} else {
				alarmVisablity[2] = false;

			}
			if (VAH200 == 1) {
				alarmVisablity[3] = true;

			} else {
				alarmVisablity[3] = false;

			}
			
			
			VPH200 = flag[2];
			VAHH200 = flag[3];
						
			myframe.VAL200.setText("STG-2 VIBS ALARM  VAL200:" + VAL200);
			myframe.VAL200.setVisible(alarmVisablity[2]);
			
			myframe.VAH200.setText("STG-2 VIBS ALARM  VAL200:" + VAH200);		
			myframe.VAH200.setVisible(alarmVisablity[3]);
			
			myframe.VPH200.setText("STG-2 PERMISSIVE  VPH200:" + VPH200);
			myframe.VAHH200.setText("STG-2 SHUTDOWN   VAHH200:" +VAHH200);
	
			// =================================STAGE-3========================================================//
			// Input 1 to disable stage-3 vibration alarms/ Input 0 to Enable Them.
			Stg3VibDisableReq = myframe.Stg3VibDisableReq;
			flag = Vibs.leafevent(VT300, VI300, VSH300, VSHH300, VSL300, VAH300, VAHH300, VAL300, VPH300, VT300_STAT,
					HIS500, VAH300_Discrp, VAHH300_Discrp_SD, VAL300_Discrp_LO, VPH300_Discrp, VT300_ENG);
			if (Stg3VibDisableReq != 1) {
				VAL300 = flag[0];
				VAH300 = flag[1];
			} else if (Stg3VibDisableReq == 1) {
				int Stg3VibEnableReq = 0;
				AlmStatusFlags = alarmStatusVIB.alarmStatus(Stg3VibDisableReq, Stg3VibEnableReq, VAL300, VAH300);
				VAL300 = AlmStatusFlags[0];
				VAH300 = AlmStatusFlags[1];
			}
			
			if (VAL300 == 1) {
				alarmVisablity[4] = true;
			} else {
				alarmVisablity[4] = false;

			}
			if (VAH300 == 1) {
				alarmVisablity[5] = true;

			} else {
				alarmVisablity[5] = false;
			}
			VPH300 = flag[2];
			VAHH300 = flag[3];
			
			myframe.VAL300.setText("STG-3 VIBS ALARM  VAL300:" + VAL300);
			myframe.VAL300.setVisible(alarmVisablity[4]);
			
			myframe.VAH300.setText("STG-3 VIBS ALARM  VAH300:" + VAH300);
			myframe.VAH300.setVisible(alarmVisablity[5]);
			
			myframe.VPH300.setText("STG-3 PERMISSIVE  VPH300:" + VPH300);
			myframe.VAHH300.setText("STG-3 SHUTDOWN   VAHH300:" +VAHH300);
			
	
//=========== auxcooling events=============================================//
			
			auxcoolingDisableReq = myframe.AuxcoolingDisableReq;
			ComAlmStatusAuxCooling auxcoolingalarmstatus = new ComAlmStatusAuxCooling();

			int[] flagCompsite = new int[4];
			ComCompositeEvent AuxsysEvnt = new ComCompositeEvent();

			ComAuxSys auxcooling = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
					alarm_Discrp, transm_eng);
			flagCompsite = AuxsysEvnt.compsiteEvent(PT100, PI100, PSH100, PSHH100, PSL100, PSLL100, PAH100, PAHH100,
					PAL100, PALL100, PT100_STAT, PAH100_Discrp, PAHH100_Discrp_SD, PAL100_Discrp_LO, PALL100_Discrp_SD,
					PT100_ENG, auxcooling);
			if (auxcoolingDisableReq != 1) {
				PAL100 = flagCompsite[0];
				PAH100 = flagCompsite[1];
			} else if (auxcoolingDisableReq == 1) {
				int auxcoolingEnableReq = 0;
				AlmStatusFlags = auxcoolingalarmstatus.alarmStatus(auxcoolingDisableReq, auxcoolingEnableReq, PAL100,
						PAH100);
				PAL100 = AlmStatusFlags[0];
				PAH100 = AlmStatusFlags[1];
			}
			
			if (PAL100 == 1) {
				alarmVisablity[6] = true;
			} else {
				alarmVisablity[6] = false;
			}
			if (PAH100 == 1) {
				alarmVisablity[7] = true;
			} else {
				alarmVisablity[7] = false;
			}
			PALL100 = flagCompsite[2];
			PAHH100 = flagCompsite[3];
			
			myframe.PAL100.setText("COOLING ALARM  LOW  PAL100:" + PAL100);
			myframe.PAL100.setVisible(alarmVisablity[6]);
			
			myframe.PAH100.setText("COOLING ALARM  HIGH PAH100:" + PAH100);
			myframe.PAH100.setVisible(alarmVisablity[7]);
			
			myframe.PAHH100.setText("COOLING SHUTDOWN   PAHH100:"+ PAHH100);
			myframe.PALL100.setText("COOLING SHUTDOWN   PALL100:"+ PALL100);
			
			
//=========== auxiliary oil system events===========================================================//
		
			auxoilDisableReq =myframe.AuxoilDisableReq;
			ComAlmStatusAuxOil auxoilalarmstatus = new ComAlmStatusAuxOil();

			ComAuxSys auxoil = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
					alarm_Discrp, transm_eng);
			flagCompsite = AuxsysEvnt.compsiteEvent(TT100, TI100, TSH100, TSHH100, TSL100, TSLL100, TAH100, TAHH100,
					TAL100, TALL100, TT100_STAT, TAH100_Discrp, TAHH100_Discrp_SD, TAL100_Discrp_LO, TALL100_Discrp_SD,
					TT100_ENG, auxoil);
			// Determine status if no disable is request is set send the alarm status to HMI
			// else sent 2 for disabled alarms.
			if (auxoilDisableReq != 1) {
				TAL100 = flagCompsite[0];
				TAH100 = flagCompsite[1];
			} else if (auxoilDisableReq == 1) {
				int auxoilEnableReq = 0;
				AlmStatusFlags = auxoilalarmstatus.alarmStatus(auxoilDisableReq, auxoilEnableReq, TAL100, TAH100);
				TAL100 = AlmStatusFlags[0];
				TAH100 = AlmStatusFlags[1];
			}
			
			if (TAL100 == 1) {
				alarmVisablity[8] = true;
			} else {
				alarmVisablity[8] = false;
			}
			if (TAH100 == 1) {
				alarmVisablity[9] = true;
			} else {
				alarmVisablity[9] = false;
			}
			
			TALL100 = flagCompsite[2];
			TAHH100 = flagCompsite[3];
			
			myframe.TAL100.setText("OIL TEMP ALARM  LOW  TAL100:" + TAL100);
			myframe.TAL100.setVisible(alarmVisablity[8]);
			
			myframe.TAH100.setText("OIL TEMP ALARM  HIGH TAH100:" + TAH100);
			myframe.TAH100.setVisible(alarmVisablity[9]);
			
			myframe.TAHH100.setText("OIL TEMP SHUTDOWN   TAHH100:"+ TAHH100);
			myframe.TALL100.setText("OIL TEMP SHUTDOWN   TALL100:"+ TALL100);
			
			
			
//=========== Suction pressure events=============================================//
			
			suctionDisableReq = myframe.SuctionDisableReq;
			ComAlmStatusSuction suctionalarmstatus = new ComAlmStatusSuction();

			ComAuxSys comSuction = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
					alarm_Discrp, transm_eng);
			flagCompsite = AuxsysEvnt.compsiteEvent(PT500, PI500, PSH500, PSHH500, PSL500, PSLL500, PAH500, PAHH500,
					PAL500, PALL500, PT500_STAT, PAH500_Discrp, PAHH500_Discrp_SD, PAL500_Discrp_LO, PALL500_Discrp_SD,
					PT500_ENG, comSuction);

//========================alarm disable function evaluation=======//			
			if (suctionDisableReq != 1) {
				PAL500 = flagCompsite[0];
				PAH500 = flagCompsite[1];
			} else if (suctionDisableReq == 1) {
				int suctionEnableReq = 0;
				AlmStatusFlags = suctionalarmstatus.alarmStatus(suctionDisableReq, suctionEnableReq, PAL500, PAH500);
				PAL500 = AlmStatusFlags[0];
				PAH500 = AlmStatusFlags[1];
			}
			
			if (PAL500 == 1) {
				alarmVisablity[10] = true;
			} else {
				alarmVisablity[10] = false;
			}
			if (PAH500 == 1) {
				alarmVisablity[11] = true;
			} else {
				alarmVisablity[11] = false;
			}
			PALL500 = flagCompsite[2];
			PAHH500 = flagCompsite[3];
			PALL500 = flagCompsite[2];
			PAHH500 = flagCompsite[3];

			myframe.PAL500.setText("SUCT PRESS  ALARM LOW  PAL500:" + PAL500);
			myframe.PAL500.setVisible(alarmVisablity[10]);
			
			myframe.PAH500.setText("SUCT PRESS  ALARM HIGH PAH500:" + PAH500);
			myframe.PAH500.setVisible(alarmVisablity[11]);
			
			myframe.PALL500.setText("SUCT PRESS SHUTDOWN   PALL500:"+ PALL500);
			myframe.PAHH500.setText("SUCT PRESS SHUTDOWN   PAHH500:"+ PAHH500);

//================== Compressor discharge events=============================================//
			
			dischargeDisableReq =myframe.DischargeDisableReq;
			ComAlmStatusDischarge dischargealarmstatus = new ComAlmStatusDischarge();

			ComAuxSys comDischarge = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
					alarm_Discrp, transm_eng);
			flagCompsite = AuxsysEvnt.compsiteEvent(PT2500, PI2500, PSH2500, PSHH2500, PSL2500, PSLL2500, PAH2500,
					PAHH2500, PAL2500, PALL2500, PT2500_STAT, PAH2500_Discrp, PAHH2500_Discrp_SD, PAL2500_Discrp_LO,
					PALL500_Discrp_SD, PT500_ENG, comDischarge);
//========================alarm disable function evaluation=======//

			if (dischargeDisableReq != 1) {
				PAL2500 = flagCompsite[0];
				PAH2500 = flagCompsite[1];
			} else if (dischargeDisableReq == 1) {
				int dischargeEnableReq = 0;
				System.out.println(
						"Alarm Area=" + "STG-" + dischargeDisableReq + " Compressor discharge alarms are disabled");
				AlmStatusFlags = dischargealarmstatus.alarmStatus(dischargeDisableReq, dischargeEnableReq, PAL2500,
						PAH2500);
				PAL2500 = AlmStatusFlags[0];
				PAH2500 = AlmStatusFlags[1];
			}
			if (PAL2500 == 1) {
				alarmVisablity[12] = true;
			} else {
				alarmVisablity[12] = false;
			}
			if (PAH2500 == 1) {
				alarmVisablity[13] = true;
			} else {
				alarmVisablity[13] = false;
			}
			PALL500 = flagCompsite[2];
			PAHH500 = flagCompsite[3];
			PALL2500 = flagCompsite[2];
			PAHH2500 = flagCompsite[3];
			
			myframe.PAL2500.setText("DISCH PRESS  ALARM LOW  PAL2500:" + PAL2500);
			myframe.PAL2500.setVisible(alarmVisablity[12]);
			
			myframe.PAH2500.setText("DISCH PRESS  ALARM HIGH PAH2500:" + PAH2500);
			myframe.PAH2500.setVisible(alarmVisablity[13]);
			
			myframe.PALL2500.setText("DISCH PRESS SHUTDOWN   PALL2500:"+ PALL2500);
			myframe.PAHH2500.setText("DISCH PRESS SHUTDOWN   PAHH2500:"+ PAHH2500);
			
//====================Aux System Status======================================================================//
			// send all trip flags comauxstatus class, the class determines if all trips are
			// cleared/ if not the overall trip word is set

			ComAuxStatus auxStatus = new ComAuxStatus();

			shutdownWord = auxStatus.AuxSysTrip(VAHH100, VAHH200, VAHH300, PALL100, PAHH100, TALL100, TAHH100, PALL500,
					PAHH500, PALL2500, PAHH2500);
			
			String shutdownWord_STATUS = "TRIP";
			if (shutdownWord == 1) {
				shutdownWord_STATUS = "TRIP";
				myframe.Startcommand=0;
				myframe.Resetcommand=1;
				

			} else if (shutdownWord == 0&& myframe.Resetcommand==0) {
				shutdownWord_STATUS = "RESET";
			}
			
			myframe.RESETREQU.setText(shutdownWord_STATUS);
			System.out.println("Compressor auxiliary system overall shutdown=" + " " + shutdownWord);
			System.out.println("================================");

			// send all permissives flags to comauxstatus class, the class determines if all
			// permissives are cleared/ if not the overall permissive word is set
			permissWord = auxStatus.AuxSysPermiss(VPH100, VPH200, VPH300);
			System.out.println("Compressor auxiliary system overall permissive=" + " " + permissWord);
			System.out.println("================================");

			// ========Call Leaf Compressor drive start/stop
			// control====================================//

			ComAuxSys drive = new ComDrive(comRequest, HIS500_STR, HIS500_STP, permissWord, shutdownWord, HIS500,
					driveFeedBack);

			HIS500 = drive.comDriveStartStop();

			// System.out.println("Compressor Drive Status HIS500=" + HIS500);
			// Compressor USER INTERFACE STATUS RUN STATUS
			String hON_500 = "OFF";
			String hOFF_500 = "OFF";
			if (HIS500 == 1) {
				hON_500 = "RUN";
				hOFF_500 = "OFF";

			} else if ((HIS500 == 0)) {
				hON_500 = "OFF";
				hOFF_500 = "ON";
			}
			myframe.HS500.setText(hON_500);
			myframe.HSTP500.setText(hOFF_500);
			// =============================================================================================//

		} while (true );
	}

}
