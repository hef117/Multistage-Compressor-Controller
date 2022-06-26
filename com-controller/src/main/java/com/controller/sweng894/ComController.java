package com.controller.sweng894;

public class ComController {

	public static void main(String[] args) {
		
//		System instrumentation tags "V" for vibration, "P" for pressure,  "T" for temperature, "F" for flow,// 
		
		//Stage-1 I/O instruments 
		String VT100 =             "1ST Stage Vibration Sensor";
		int VI100  =               3;  // First Stage Vibration sensor reading
		int VSH100 =               2; // First Stage vibration alarm set-point
		int VSL100=                2;        // 
		int VSHH100=               10;     // Shutdown high set-point
		//int VSLL100=               10;     // Shutdown set-point
		int VAH100=                0;        // alarm high flag
		int VAL100=                0;        // alarm low flag
		int VAHH100=               0;       // shutdown high flag
		int VPH100 =               1; // 2nd Stage Vibration permissive
		//int VALL100=             0;       // shutdown low flag
		int VT100_STAT =           1;  // Sensor signal integrity
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
		//int VSLL200=               1;                       // Shutdown set-point
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
		
		
		String PT2500 =            "PT2500 Compressor discharge Pressure";
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
		String CompositeTag    =    "    ";
		
//=====================Drive======================//
        
        int permissvFlag =         1;          // permissive flag
        int shutdownWord =         0;          // overall shutdown word
        int permissWord  =         0;          // overall permissive word
		int HIS500 =               10;         // Compressor  start/stop status 0= stopped, 1= ready to start, 2= Running
		int HIS500_STR=            0;          // Compressor start command
		int HIS500_STP=            1;          // Compressor stop command
		int HIS55_LOAD=            0;          // Compressor  loading status 0= unloaded, 1 = loading, 2 = loaded, 3 unloading,
		String comRequest=         " ";
		String driveFeedBack=         " ";		
                                                                                                                                 
                                                                                                                               
	                                                                                                                        	
//========leaf Events ( alarms, Permissive, and Shutdown=================//
		
		ComLeafEvent Vibs = new ComLeafEvent();
		Vibs.leafevent(VT100,VI100,VSH100,VSHH100,VSL100,VAH100,VAHH100,VAL100,VPH100,VT100_STAT,HIS500,VAH100_Discrp,VAHH100_Discrp_SD,VAL100_Discrp_LO,VPH100_Discrp,VT100_ENG);
		Vibs.leafevent(VT200,VI200,VSH200,VSHH200,VSL200,VAH200,VAHH200,VAL200,VPH200,VT200_STAT,HIS500,VAH200_Discrp,VAHH200_Discrp_SD,VAL200_Discrp_LO,VPH200_Discrp,VT200_ENG);
		Vibs.leafevent(VT300,VI300,VSH300,VSHH300,VSL300,VAH300,VAHH300,VAL300,VPH300,VT300_STAT,HIS500,VAH300_Discrp,VAHH300_Discrp_SD,VAL300_Discrp_LO,VPH300_Discrp,VT300_ENG);

	
		
//=======Composite Event( Auxiliary System Alarms and Shutdowns=============//		
		
		
		ComAuxSys auxcooling = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp,transm_eng);
		ComAuxSys auxoil = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp,transm_eng);
		ComAuxSys comSuction = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp,transm_eng);
		ComAuxSys comDischarge = new HighAlarm(transmtag, transmreading, setpoint, alarmFlag, transmitter_status,alarm_Discrp,transm_eng);
		
		ComCompositeEvent AuxsysEvnt = new ComCompositeEvent();
		AuxsysEvnt.compsiteEvent(PT100,PI100,PSH100,PSHH100,PSL100,PSLL100,PAH100,PAHH100,PAL100,PALL100,PT100_STAT,PAH100_Discrp,PAHH100_Discrp_SD,PAL100_Discrp_LO,PALL100_Discrp_SD,PT100_ENG,auxcooling);
		AuxsysEvnt.compsiteEvent(TT100,TI100,TSH100,TSHH100,TSL100,TSLL100,TAH100,TAHH100,TAL100,TALL100,TT100_STAT,TAH100_Discrp,TAHH100_Discrp_SD,TAL100_Discrp_LO,TALL100_Discrp_SD,TT100_ENG,auxoil);
		AuxsysEvnt.compsiteEvent(PT500,PI500,PSH500,PSHH500,PSL500,PSLL500,PAH500,PAHH500,PAL500,PALL500,PT500_STAT,PAH500_Discrp,PAHH500_Discrp_SD,PAL500_Discrp_LO,PALL500_Discrp_SD,PT500_ENG,comSuction);
		AuxsysEvnt.compsiteEvent(PT2500,PI2500,PSH2500,PSHH2500,PSL2500,PSLL2500,PAH2500,PAHH2500,PAL2500,PALL2500,PT2500_STAT,PAH2500_Discrp,PAHH2500_Discrp_SD,PAL2500_Discrp_LO,PALL500_Discrp_SD,PT500_ENG,comDischarge); 

//========leaf Compressor drive control=====================================//
		
		ComAuxSys drive = new ComDrive(comRequest,HIS500_STR,HIS500_STP,permissWord,shutdownWord,HIS500,driveFeedBack);
		int HIS500S = drive.comDriveStartStop();
		
		System.out.println ("Compressor Driver Status:"+HIS500S);
	
	        
	}
	
	
			
}

	

