package com.controller.sweng894;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.tools.javac.Main;

public class ComControllerTest {

//// assert vibration system alarms	
	@Test
	public void highalarmleaf() {
		// Test the vibration alarm leaf for all 3 stages

		var alarmstag1 = new HighAlarm("VT100", 1000, 500, 1, 1,"Check for high alarm", "mils");
		var alarmstag2 = new HighAlarm("VT200", 100, 500, 1, 1, "Check for high alarm", "mils");
		var alarmstag3 = new HighAlarm("VT300", 1000, 500, 1, 1,"Check for high alarm", "mils");
		alarmstag1.detectHighAlarm();
		alarmstag2.detectHighAlarm();
		alarmstag3.detectHighAlarm();

	}
	
	@Test
	public void lowalarmleaf() {
		// Test the vibration alarm leaf for all 3 stages

		var alarmstage1 = new LowAlarm("PT1100 Stage-1 low suction pressure", 100, 500, 1, 1,"Check for low alarm", "PSIG");
		alarmstage1.detectLowAlarm();
		
	}

// assert vibration system permissive 
	@Test
	public void vibpermissive() {

		// Test the vibration permissive leaf for all 3 stages.
		var auxvibStagVIB1 = new AuxVibPermissive("VT100 Stage-1 Vibration Sensor", 0, 0, 0, "Check for permissive");
		var auxvibStagVIB2 = new AuxVibPermissive("VT200 Stage-2 Vibration Sensor", 0, 0, 1, "Check for permissive");
		var auxvibStagVIB3 = new AuxVibPermissive("VT300 Stage-3 Vibration Sensor", 0, 0, 0, "Check for permissive");

		auxvibStagVIB1.detectPermssive();
		auxvibStagVIB2.detectPermssive();
		auxvibStagVIB3.detectPermssive();
	}
//=========================================== Composite Testing=======================================================//
// assert cooling system high alarms
   @Test
	public void AuxcoolingHighalarms1() {

		// Cooling test high cooling pressure test

		var compsite1 = new Compsite();

		ComAuxSys auxcooling = new HighAlarm("PT100 Compressor Cooling Pressure", 10, 500, 1, 1,"Check for high alarm", "PSIG");
		compsite1.addsys(auxcooling);
		auxcooling.detectHighAlarm();
	}

// assert oil system system high alarms
	@Test
	public void AuxOilsystemHighalarms1() {

		// Aux oil high temperature test.

		var compsite2 = new Compsite();

		ComAuxSys auxoil = new HighAlarm("TT100 Oil System Temperature", 200, 100, 1, 1, "Check for high alarm","degC");
		compsite2.addsys(auxoil);

		auxoil.detectHighAlarm();
	}

// assert compressor suction high alarms
	@Test
	public void comSuctionHighalarms1() {

		// compressor suction high alarms test.

		var compsite3 = new Compsite();

		ComAuxSys comSuction = new HighAlarm("PT500 Compressor Suction Pressure", 200, 100, 1, 1, "Check for high alarm","PSIG");
		compsite3.addsys(comSuction);
		comSuction.detectHighAlarm();
	}
	
// assert compressor suction low alarms
		@Test
		public void comSuctionLowalarms1() {

			// compressor suction high alarms test.

			var compsite4 = new Compsite();

			ComAuxSys comSuction = new LowAlarm("PT500 Compressor Suction Pressure", 50, 100, 1, 1, "Check for low alarm","PSIG");
			
			compsite4.addsys(comSuction);
			comSuction.detectLowAlarm();
		}
// assert compressor discharge high alarms
	@Test
	public void comDischargeHighalarms1() {
		// compressor discharge high alarms test.
		var compsite5 = new Compsite();
		ComAuxSys comDischarge = new HighAlarm("PT2500 Compressor Discharge Pressure", 300, 100, 1, 1,"Check for high alarm", "PSIG");
		compsite5.addsys(comDischarge);
		comDischarge.detectHighAlarm();
	}
// assert compressor discharge low alarms	
	@Test
	public void comDischargeLowalarms1() {
		// compressor discharge high alarms test.
		var compsite6 = new Compsite();
		ComAuxSys comDischarge = new LowAlarm("PT2500 Compressor Discharge Pressure", 30, 100, 1, 1,"Check for low alarm", "PSIG");
		compsite6.addsys(comDischarge);
		comDischarge.detectHighAlarm();
	}
// assert compressor cooling high shutdowns	
	@Test
	public void comCoolingPressHighshutdown() {
		// compressor discharge high alarms test.
		var compsite7 = new Compsite();
		ComAuxSys auxcooling = new Highshutdown("PT100 Compressor Cooling Pressure", 300, 100, 1, 1,"Check for high shutdown", "PSIG");
		compsite7.addsys(auxcooling);
		auxcooling.detectHighShutdown();
	}
// assert compressor cooling low shutdowns	
	@Test
	public void comCoolingPressLowshutdown() {
		
		var compsite8 = new Compsite();
		ComAuxSys auxcooling = new Lowshutdown("PT100 Compressor Cooling Pressure", 50, 100, 1, 1,"Check for low shutdown", "PSIG");
		compsite8.addsys(auxcooling);
		auxcooling.detectLowShutdown();
	}
//==============================UC-5 Compressor Drive==========//

	// assert startup command
	
		@Test
		public void ComDriveStart() {
			
			var driveStart = new ComDrive("Start The Compressor", 1,0, 1, 0,0," ");
			//(String comRequest: Start The Compressor , Start command =1,Stop command=0, permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
			
			int HIS500S = driveStart.comDriveStartStop();
			assertTrue(HIS500S ==1);
		}
	
	// assert shutdown command
		@Test
		public void ComDriveStop() {
			
			var driveStart = new ComDrive("Stop The Compressor", 0,1, 1, 0,0," ");
			//(String comRequest: Start The Compressor , Start command =1,Stop command=1, permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
			
			int HIS500S = driveStart.comDriveStartStop();
			assertTrue(HIS500S ==0);
		}
		
		// assert shutdown event
		@Test
		public void ComDriveShutdown() {
			
			var driveStart = new ComDrive("Start The Compressor", 1,0, 1, 1,0," ");
			//(String comRequest: Start The Compressor , Start command =1,Stop command=1, permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
			
			int HIS500S = driveStart.comDriveStartStop();
			assertTrue(HIS500S ==0);
		}
		
		// assert permissive not okay
		@Test
		public void ComDrivePermssive() {
			
			var driveStart = new ComDrive("Start The Compressor", 1,0, 0, 0,0," ");
			//(String comRequest: Start The Compressor , Start command =1,Stop command=1, permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
			
			int HIS500S = driveStart.comDriveStartStop();
			assertTrue(HIS500S !=1);
		}
		
//==============================UC-4 Auxiliary System Tripped.==========//

// T4.2: assert overall permissive okay word for each case  for all three stage as follows: (VPH100,VPH200,VPH300)
				
		@Test
				public void ComAuxOverallPermissiveAssertion() {
			        int permissWord=0;
					var ComAuxStatusPermiss = new ComAuxStatus();
				
					//assert all 3 stages permissive okay
					permissWord = ComAuxStatusPermiss.AuxSysPermiss(1,1,1);
					assertTrue(permissWord ==1);
					//assert stage-1 permissive not okay
					permissWord = ComAuxStatusPermiss.AuxSysPermiss(0,1,1);
					assertFalse(permissWord ==1);
					//assert stage-1 okay and two not okay 
					permissWord = ComAuxStatusPermiss.AuxSysPermiss(1,0,1);
					assertFalse(permissWord ==1);
					//assert stage-1 okay and two okay, and 3 not okay 
					permissWord = ComAuxStatusPermiss.AuxSysPermiss(1,1,0);
					assertFalse(permissWord ==1);	
					//assert all three stages not okay
					permissWord = ComAuxStatusPermiss.AuxSysPermiss(0,0,0);
					assertFalse(permissWord ==1);
					
				}
	
// T4.1 Send the trip pattern to the overall shutdown ComAuxStatus shutdown and assert the return statement shutdownword.
				@Test
				public void ComAuxOverallShutdownWordAssertion() {
					int shutdownWord=0;
					var ComAuxStatusShutdown = new ComAuxStatus();
    
	// All cases should set to true the overall shutdownword except the last case- it should clear the shutdown word. 
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(1,1,1,1,1,1,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,1,1,1,1,1,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,1,1,1,1,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,1,1,1,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,1,1,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,1,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,0,1,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,0,0,1,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,0,0,0,1,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,0,0,0,0,1,1);
					assertFalse(shutdownWord ==0);
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,0,0,0,0,0,1);
					assertFalse(shutdownWord ==0);
				    shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0,0,0,0,0,0,0,0,0,0,0);
				    assertTrue(shutdownWord ==0);
				}

//==================================== integrate test UC4 and UC-5===============================//				
				@Test
				public void ComDriveStartIngeration() {

					int shutdownWord = 0;
					// call to clear all shutdown
					var ComAuxStatusShutdown = new ComAuxStatus();
					shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
					assertTrue(shutdownWord == 0);

					// call to clear all permissives
					int permissWord = 0;
					var ComAuxStatusPermiss = new ComAuxStatus();
					permissWord = ComAuxStatusPermiss.AuxSysPermiss(1, 1, 1);
					assertTrue(permissWord == 1);

					// attempt to start the compressor
					var driveStart = new ComDrive("Start The Compressor", 1, 0, permissWord, shutdownWord, 0, " ");
					// (String comRequest: Start The Compressor , Start command =1,Stop command=0,
					// permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
					// Since there is no active shutdown and all permissives are cleared the
					// comporessor feedback should be on
					int HIS500S = driveStart.comDriveStartStop();
					assertTrue(HIS500S == 1);
				}
//==================================== integrate test UC4 and UC-5===============================//	
				
				@Test
				public void ComDriveStartIngerationTripAndPermissiveDetection() {

					int shutdownWord = 0;
					int permissWord = 0;

					for (int i = 0; i <= 5; i++) {
						if (i <= 1) {
							// call to clear all shutdown
							var ComAuxStatusShutdown = new ComAuxStatus();
							shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
							assertTrue(shutdownWord == 0);

							// call to clear all permissives

							var ComAuxStatusPermiss = new ComAuxStatus();
							permissWord = ComAuxStatusPermiss.AuxSysPermiss(1, 1, 1);
							assertTrue(permissWord == 1);

							// attempt to start the compressor
							var driveStart = new ComDrive("Start The Compressor", 1, 0, permissWord, shutdownWord, 0,
									" ");
							// (String comRequest: Start The Compressor , Start command =1,Stop command=0,
							// permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
							// Since there is no active shutdown and all permissives are cleared the
							// comporessor feedback should be on
							int HIS500S = driveStart.comDriveStartStop();
							assertTrue(HIS500S == 1);

						}
						if (i == 2) {
							// call to clear all shutdown but PAHH2500 last word in method call
							var ComAuxStatusShutdown = new ComAuxStatus();
							shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
							assertTrue(shutdownWord == 1);

							// attempt to start the compressor
							var driveStart = new ComDrive("Start The Compressor", 1, 0, permissWord, shutdownWord, 0," ");
							// (String comRequest: Start The Compressor , Start command =1,Stop command=0,
							// permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
							// Since there is no active shutdown and all permissives are cleared the
							// comporessor feedback should be on
							int HIS500S = driveStart.comDriveStartStop();
							assertFalse(HIS500S == 1);

						}
						if (i == 4) {
							// call to clear all shutdown
							var ComAuxStatusShutdown = new ComAuxStatus();
							shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
							assertTrue(shutdownWord == 0);

							// call to clear all permissives

							var ComAuxStatusPermiss = new ComAuxStatus();
							permissWord = ComAuxStatusPermiss.AuxSysPermiss(1, 1, 1);
							assertTrue(permissWord == 1);

							// attempt to restart the compressor
							var driveStart = new ComDrive("Start The Compressor", 1, 0, permissWord, shutdownWord, 0,
									" ");
							// (String comRequest: Start The Compressor , Start command =1,Stop command=0,
							// permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
							// Since there is no active shutdown and all permissives are cleared the
							// comporessor feedback should be on
							int HIS500S = driveStart.comDriveStartStop();
							assertTrue(HIS500S == 1);

						}
						if (i == 5) {
							// call to clear all shutdown
							var ComAuxStatusShutdown = new ComAuxStatus();
							shutdownWord = ComAuxStatusShutdown.AuxSysTrip(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
							assertTrue(shutdownWord == 0);
							
							var driveStart = new ComDrive("Start The Compressor", 1, 0, permissWord, shutdownWord, 0," ");
							int HIS500S = driveStart.comDriveStartStop();
							assertTrue(HIS500S == 1);
							// call to clear all permissives

							var ComAuxStatusPermiss = new ComAuxStatus();
							permissWord = ComAuxStatusPermiss.AuxSysPermiss(1, 1, 0);
							assertFalse(permissWord == 1);

							// attempt to start the compressor
							
							// (String comRequest: Start The Compressor , Start command =1,Stop command=0,
							// permissive Clear=1, int shutDwnClear,int C_Status,String DriverFeedBack
							// Since there is no active shutdown and all permissives are cleared the
							// comporessor feedback should be on
							//HIS500S = driveStart.comDriveStartStop();
							assertTrue(HIS500S == 1);
						}
					}				
				}
	//==============================UC-6 & UC-7 Auxiliary System Alarm disabled/ Enabling Tests==============//	
				
				// assert comAlmStatus class unit test 
				int[] alarmflagIN = new int[16]; // test inputs
				int[] alarmflagOT = new int[16]; // test outputs
				@Test
				public void ALarmDisabledReEnabled() {
					// UC-7 T7.1
					alarmflagIN[0]=1;// Disable Command
					alarmflagIN[1]=0;// Enable command
					alarmflagIN[2]=1;// alarm low flag
					alarmflagIN[3]=1;// alarm high flag 	
					// assert auxiliary system alarm disabled : disable command =1,enable command =0, alarm high is present and alarm low present 
					var alarmStatusCall = new ComAlmStatus();
					alarmflagOT = alarmStatusCall.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]); 
					assertTrue (alarmflagOT[0]==2);
					assertTrue (alarmflagOT[1]==2);
					
					// UC-6 T6.1
					// assert auxiliary system alarm disabled : disable command =0,enable command =1, alarm high is present and alarm low present 
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=1;// Enable command
					alarmflagIN[2]=1;// 
					alarmflagIN[3]=1;// 
					alarmflagOT = alarmStatusCall.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					// assert alarms are not disabled
					assertFalse (alarmflagOT[0]==2);
					assertFalse (alarmflagOT[1]==2);
					// assert the that the controller resumed forwarding the alarms values to the web portal after enable is set
					assertTrue (alarmflagOT[0]==1);
					assertTrue (alarmflagOT[1]==1);
					
					// UC-6 UC-7 T6.2 T7.2
					// assert neither disable nor enable are set, but both alarms low & high are present
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=0;// Enable command
					alarmflagIN[2]=1;// Disable Command
					alarmflagIN[3]=1;// Enable command
					 
					alarmflagOT = alarmStatusCall.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					// assert neither disable command is set nor enable command is set.
					assertFalse (alarmflagOT[0]==2);
					assertFalse (alarmflagOT[1]==2);
					// assert the controller resumed forwarding the current alarm value to the web portal
					assertTrue (alarmflagOT[0]==1);
					assertTrue (alarmflagOT[1]==1);
					
					// UC-6 UC-7 T6.3 T7.3
					// assert neither alarm disable command is set, nor alarm enable command is set; and no alarms are present
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=0;// Enable command
					alarmflagIN[2]=0;// low alarm flag
					alarmflagIN[3]=0;// high alarm flag
					 
					alarmflagOT = alarmStatusCall.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					
					assertFalse (alarmflagOT[0]==2);
					assertFalse (alarmflagOT[1]==2);
					// assert the controller resumed forwarding the current alarm value to the web portal
					assertTrue (alarmflagOT[0]==0);
					assertTrue (alarmflagOT[1]==0);
					
					// assert neither alarm disable command is set nor alarm enable command is set and an alarm low is set
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=0;// Enable command
					alarmflagIN[2]=1;// low alarm flag
					alarmflagIN[3]=0;// high alarm flag
					 
					alarmflagOT = alarmStatusCall.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					
					assertFalse (alarmflagOT[0]==2);
					assertFalse (alarmflagOT[1]==2);
					// assert the controller resumed forwarding the current alarm value to the web portal
					assertTrue (alarmflagOT[0]==1);
					assertFalse (alarmflagOT[1]==1);
				}
///===================== Integrate UC-1 for the high alarm detected case with UC-7 alarm disabled==================================///				
				@Test
				public void HighAlarmTriggered_ByComController_ThenDisableCommandIssued_ByOperator() {
					
					// Call the alarm routing UC-1 with alarm parameters 1000 psig and setpoint of 500 psig.


					var compsite1 = new Compsite();

					ComAuxSys auxcooling = new HighAlarm("PT100 Compressor Cooling Pressure", 1000, 500, 1, 1,"Check for high alarm", "PSIG");
					compsite1.addsys(auxcooling);
					alarmflagIN[3]= auxcooling.detectHighAlarm();
					assertTrue (alarmflagIN[3]==1);// a high alarm should be set 
					
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=1;// Enable command
					
					//Since alarm is enable assert that the web portal will get a value of 1 for high alarm and 0 for low alarm
					var alarmsEnable = new ComAlmStatus();
					alarmflagOT = alarmsEnable.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					assertFalse (alarmflagOT[0]==1);
					assertTrue  (alarmflagOT[1]==1);
					
					alarmflagIN[0]=1;// Disable Command
					alarmflagIN[1]=0;// Enable command
					
					//Since alarm is enable assert that the web portal will get a value of 1 for high alarm and 0 for low alarm
					var Alarmsdisabled = new ComAlmStatus();
					alarmflagOT = Alarmsdisabled.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					assertTrue (alarmflagOT[0]==2);
					assertTrue  (alarmflagOT[1]==2);
					
				}
///===================== Integrate UC-1 for the low alarm detected case with UC-7 alarm disabled==================================================///				
				@Test
				public void LowAlarmTriggered_ByComController_ThenDisableCommandIssued_ByOperator() {
					// Call the alarm method with low process value and high set-point to generate low alarm


					var compsite1 = new Compsite();

					ComAuxSys auxcooling = new LowAlarm("PT100 Compressor Cooling Pressure", 100, 500, 1, 1,"Check for high alarm", "PSIG");
					compsite1.addsys(auxcooling);
					alarmflagIN[2]= auxcooling.detectLowAlarm();
					assertTrue (alarmflagIN[2]==1); // low alarm flag should be set
					
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=1;// Enable command
					// Assert alarm logic for low alarm active and high alarm inactive.	
					var Alarmenabled = new ComAlmStatus();
					alarmflagOT = Alarmenabled.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					assertTrue  (alarmflagOT[0]==1);
					assertFalse (alarmflagOT[1]==1);
				
					alarmflagIN[0]=1;// Disable Command
					alarmflagIN[1]=0;// Enable command
					
					//Since alarm is enable assert that the web portal will get a value of 1 for high alarm and 0 for low alarm
					var Alarmsdisabled = new ComAlmStatus();
					alarmflagOT = Alarmsdisabled.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					assertTrue (alarmflagOT[0]==2);
					assertTrue  (alarmflagOT[1]==2);
					
					alarmflagIN[0]=0;// Disable Command
					alarmflagIN[1]=0;// Enable command
					// Assert alarm logic for low alarm active and high alarm inactive.	
					var alarmReEnabled = new ComAlmStatus();
					alarmflagOT = alarmReEnabled.alarmStatus(alarmflagIN[0],alarmflagIN[1],alarmflagIN[2],alarmflagIN[3]);
					assertTrue  (alarmflagOT[0]==1);
					assertFalse (alarmflagOT[1]==1);
				}

}