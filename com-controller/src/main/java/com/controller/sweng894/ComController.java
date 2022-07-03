package com.controller.sweng894;

public class ComController {

	public static void main(String[] args) {

//		System instrumentation tags "V" for vibration, "P" for pressure,  "T" for temperature, "F" for flow,// 

		// Stage-1 I/O instruments
		String VT100 = "1ST Stage Vibration Sensor";
		int VI100 = 1; // First Stage Vibration sensor reading
		int VSH100 = 5; // First Stage vibration alarm set-point
		int VSL100 = 2; //
		int VSHH100 = 10; // Shutdown high set-point
		int VAH100 = 0; // alarm high flag
		int VAL100 = 0; // alarm low flag
		int VAHH100 = 0; // shutdown high flag
		int VPH100 = 0; // 2nd Stage Vibration permissive
		int VT100_STAT = 1; // Sensor signal integrity
		String VAH100_Discrp = "Check for high alarm";
		String VAL100_Discrp_LO = "Check for low alarm";
		String VAHH100_Discrp_SD = "Check for high shutdown";
		String VPH100_Discrp = "Check for permissive*";
		String VT100_ENG = "mils";

		// Stage-2 I/O instruments
		String VT200 = "2ND Stage Vibration Sensor";
		int VI200 = 2; // Stage Vibration sensor reading
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

		// Stage-3 I/O instruments
		String VT300 = "3RD Stage Vibration Sensor";
		int VI300   = 5; // Stage Vibration sensor reading
		int VSH300  = 4; // vibration high alarm set-point
		int VSL300  = 2; //
		int VSHH300 = 6; // Shutdown high set-point
		int VAH300  = 0; // alarm high flag
		int VAL300  = 0; // alarm low flag
		int VAHH300 = 0; // shutdown high flag
		int VPH300  = 0; // 2nd Stage Vibration permissive
		int VT300_STAT = 1; // Sensor signal integrity
		String VAH300_Discrp = "Check for high alarm";
		String VAL300_Discrp_LO = "Check for low alarm";
		String VAHH300_Discrp_SD = "Check for high shutdown";
		String VPH300_Discrp = "Check for permissive*";
		String VT300_ENG = "mils";


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

		// Auxiliary Systems instrumentation tags

		String PT100 = "PT100 Compressor Cooling Pressure";
		int PI100   = 29; // Sensor Reading
		int PSH100  = 30; // Alarm High set-point
		int PSL100  = 15; // Alarm low set point
		int PSHH100 = 35; // Shutdown high set-point
		int PSLL100 = 10; // Shutdown set-point
		int PAH100  = 0; // alarm high flag
		int PAL100  = 0; // alarm low flag
		int PAHH100 = 0; // shutdown high flag
		int PALL100 = 0; // shutdown low flag
		int PT100_STAT = 1; // Sensor signal integrity
		String PAH100_Discrp = "Check for high alarm";
		String PAL100_Discrp_LO = "Check for low alarm";
		String PAHH100_Discrp_SD = "Check for high shutdown";
		String PALL100_Discrp_SD = "Check for low shutdown";
		String CoolingSystem = "Compressor Cooling System";
		String PT100_ENG = "PSIG";

		String TT100 = "TT100 Oil System Temperature";
		int TI100 = 200;
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

		String PT500 = "PT500 Compressor Suction Pressure";
		int PI500   = 41;
		int PSH500  = 40;
		int PSL500  = 30;
		int PSHH500 = 42;
		int PSLL500 = 20;
		int PAH500  = 0;
		int PAL500  = 0;
		int PAHH500 = 0;
		int PALL500 = 0;
		int PT500_STAT = 1;
		String PAH500_Discrp = "Check for high alarm";
		String PAL500_Discrp_LO = "Check for low alarm";
		String PAHH500_Discrp_SD = "Check for high shutdown";
		String PALL500_Discrp_SD = "Check for low shutdown";
		String PT500_ENG = "PSIG";
		

		String PT2500 = "PT2500 Compressor discharge Pressure";
		int PI2500   = 450;
		int PSH2500  = 400;
		int PSL2500  = 300;
		int PSHH2500 = 420;
		int PSLL2500 = 200;
		int PAH2500  = 0;
		int PAL2500  = 0;
		int PAHH2500 = 0;
		int PALL2500 = 0;
		int PT2500_STAT = 1;
		String PAH2500_Discrp = "Check for high alarm";
		String PAL2500_Discrp_LO = "Check for low alarm";
		String PAHH2500_Discrp_SD = "Check for high shutdown";
		
		String PALL2500_Discrp_SD = "Check for low shutdown";
		String DischSystem = "Compressor discharge";
		String PT2500_Discrp = " ";
		String PT2500_ENG = "PSIG";
		String CompositeTag = "    ";

//=====================Drive======================//

		int shutdownWord = 0; // overall shutdown word
		int permissWord  = 0; // overall permissive word
		int HIS500       = 0; // Compressor start/stop status 0= stopped, 1= ready to start, 2= Running
		int HIS500_STR   = 1; // Compressor start command
		int HIS500_STP   = 0; // Compressor stop command
		int HIS500_LOAD  = 0; // Compressor loading status 0= unloaded, 1 = loading, 2 = loaded, 3 unloading,
		
		String comRequest = " ";
		String driveFeedBack = " ";

//========leaf Events ( alarms, Permissive, and Shutdown)=================//

		ComLeafEvent Vibs = new ComLeafEvent();
		int[] flag = new int[4];
		flag = Vibs.leafevent(VT100, VI100, VSH100, VSHH100, VSL100, VAH100, VAHH100, VAL100, VPH100, VT100_STAT,
				HIS500, VAH100_Discrp, VAHH100_Discrp_SD, VAL100_Discrp_LO, VPH100_Discrp, VT100_ENG);
		VAL100=flag[0];
		VAH100=flag[1];
		VPH100=flag[2];
		VAHH100=flag[3];
		System.out.println("STAG-1 VIBRATION: Alarm Low     VAL100:" + VAL100);
		System.out.println("STAG-1 VIBRATION: Alarm High    VAH100:" + VAH100);
		System.out.println("STAG-1 VIBRATION: Permissive    VPH100:" + VPH100);
		System.out.println("STAG-1 VIBRATION: Shutdown High VAHH100:"+ VAHH100);
		
		System.out.println("================================");
		
		flag = Vibs.leafevent(VT200, VI200, VSH200, VSHH200, VSL200, VAH200, VAHH200, VAL200, VPH200, VT200_STAT,
				HIS500, VAH200_Discrp, VAHH200_Discrp_SD, VAL200_Discrp_LO, VPH200_Discrp, VT200_ENG);
		VAL200=flag[0];
		VAH200=flag[1];
		VPH200=flag[2];
		VAHH200=flag[3];
		System.out.println("STAG-2 VIBRATION: Alarm Low     VAL200:" + VAL200 );
		System.out.println("STAG-2 VIBRATION: ALARM High    VAH200:" + VAH200);
		System.out.println("STAG-2 VIBRATION: Permissive    VPH200:" + VPH200 );
		System.out.println("STAG-2 VIBRATION: Shutdown High VAHH200:"+ VAHH200);
		System.out.println("================================");
		flag = Vibs.leafevent(VT300, VI300, VSH300, VSHH300, VSL300, VAH300, VAHH300, VAL300, VPH300, VT300_STAT,
				HIS500, VAH300_Discrp, VAHH300_Discrp_SD, VAL300_Discrp_LO, VPH300_Discrp, VT300_ENG);
		VAL300=flag[0];
		VAH300=flag[1];
		VPH300=flag[2];
		VAHH300=flag[3];
		System.out.println("STAG-3 VIBRATION: Alarm Low     VAL300:" + VAL300);
		System.out.println("STAG-3 VIBRATION: ALARM High    VAH300:" + VAH300);
		System.out.println("STAG-3 VIBRATION: Permissive    VPH300:" + VPH300);
		System.out.println("STAG-3 VIBRATION: Shutdown High VAHH300:"+ VAHH300);
    	System.out.println("================================");
     	
//=======Composite Event( Auxiliary System Alarms and Shutdowns=============//		

		int[] flagCompsite = new int[4];
		ComCompositeEvent AuxsysEvnt = new ComCompositeEvent();

		ComAuxSys auxcooling = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
				alarm_Discrp, transm_eng);
		flagCompsite = AuxsysEvnt.compsiteEvent(PT100, PI100, PSH100, PSHH100, PSL100, PSLL100, PAH100, PAHH100, PAL100,
				PALL100, PT100_STAT, PAH100_Discrp, PAHH100_Discrp_SD, PAL100_Discrp_LO, PALL100_Discrp_SD, PT100_ENG,
				auxcooling);
		PAL100=flagCompsite[0];
		PAH100=flagCompsite[1];
		PALL100=flagCompsite[2];
		PAHH100=flagCompsite[3];
		System.out.println("Cooling Pressure Alarm    Low   PAL100:"  + PAL100);
		System.out.println("Cooling Pressure Alarm    High  PAH100:"  + PAH100);
		System.out.println("Cooling Pressure Shutdown Low   PALL100:" + PALL100);
		System.out.println("Cooling Pressure Shutdown High  PAHH100:" + PAHH100);
		System.out.println("================================");

		ComAuxSys auxoil = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
				alarm_Discrp, transm_eng);
		flagCompsite = AuxsysEvnt.compsiteEvent(TT100, TI100, TSH100, TSHH100, TSL100, TSLL100, TAH100, TAHH100, TAL100,
				TALL100, TT100_STAT, TAH100_Discrp, TAHH100_Discrp_SD, TAL100_Discrp_LO, TALL100_Discrp_SD, TT100_ENG,
				auxoil);
		TAL100=flagCompsite[0];
		TAH100=flagCompsite[1];
		TALL100=flagCompsite[2];
		TAHH100=flagCompsite[3];
		System.out.println("Oil Temperature Alarm Low     TAL100:"  + TAL100);
		System.out.println("Oil Temperature Alarm High    TAH100:"  + TAH100);
		System.out.println("Oil Temperature Shutdown Low  TALL100:" + TALL100);
		System.out.println("Oil Temperature Shutdown High TAHH100:" + TAHH100);
		System.out.println("================================");

		ComAuxSys comSuction = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
				alarm_Discrp, transm_eng);
		flagCompsite = AuxsysEvnt.compsiteEvent(PT500, PI500, PSH500, PSHH500, PSL500, PSLL500, PAH500, PAHH500, PAL500,
				PALL500, PT500_STAT, PAH500_Discrp, PAHH500_Discrp_SD, PAL500_Discrp_LO, PALL500_Discrp_SD, PT500_ENG,
				comSuction);
		PAL500=flagCompsite[0];
		PAH500=flagCompsite[1];
		PALL500=flagCompsite[2];
		PAHH500=flagCompsite[3];
		System.out.println("Suction Pressure Alarm    Low  PAL500:"  + PAL500);
		System.out.println("Suction Pressure ALARM    High PAH500:"  + PAH500);
		System.out.println("Suction Pressure Shutdown Low  PALL500:" + PALL500);
		System.out.println("Suction Pressure Shutdown High PAHH500:" + PAHH500);
		System.out.println("================================");

		ComAuxSys comDischarge = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,
				alarm_Discrp, transm_eng);
		flagCompsite = AuxsysEvnt.compsiteEvent(PT2500, PI2500, PSH2500, PSHH2500, PSL2500, PSLL2500, PAH2500, PAHH2500,
				PAL2500, PALL2500, PT2500_STAT, PAH2500_Discrp, PAHH2500_Discrp_SD, PAL2500_Discrp_LO,
				PALL500_Discrp_SD, PT500_ENG, comDischarge);
		PAL2500=flagCompsite[0];
		PAH2500=flagCompsite[1];
		PALL2500=flagCompsite[2];
		PAHH2500=flagCompsite[3];
		System.out.println("Discharge Pressure Alarm    Low  PAL2500:"  + PAL2500);
		System.out.println("Discharge Pressure ALARM    High PAH2500:"  + PAH2500);
		System.out.println("Discharge Pressure Shutdown Low  PALL2500:" + PALL2500);
		System.out.println("Discharge Pressure Shutdown High PAHH2500:" + PAHH2500);
		System.out.println("================================");
//====================Aux System Status======================================================================//
		// send all trip flags comauxstatus class, the class determines if all trips are cleared/ if not the overall trip word is set
		
		ComAuxStatus auxStatus = new ComAuxStatus();
		
		shutdownWord = auxStatus.AuxSysTrip(VAHH100,VAHH200,VAHH300,PALL100,PAHH100,TALL100,TAHH100,PALL500,PAHH500,PALL2500,PAHH2500);
		System.out.println("Compressor auxiliary system overall shutdown="+" "+ shutdownWord);
		System.out.println("================================");
		
		// send all permissives flags to comauxstatus class, the class determines if all permissives  are cleared/ if not the overall permissive  word is set
		permissWord = auxStatus.AuxSysPermiss(VPH100,VPH200,VPH300);
		System.out.println("Compressor auxiliary system overall permissive="+" "+ permissWord);
		System.out.println("================================");
//========Call Leaf Compressor drive start/stop control=====================================//

		ComAuxSys drive = new ComDrive(comRequest, HIS500_STR, HIS500_STP, permissWord, shutdownWord, HIS500,driveFeedBack);
	
		
		HIS500= drive.comDriveStartStop();

		System.out.println("Compressor Drive Status HIS500=" + HIS500);

	}

}
