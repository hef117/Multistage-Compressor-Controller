package com.controller.sweng894;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.tools.javac.Main;

public class ComControllerTest {

// assert vibration system alarms	
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

		ComAuxSys auxcooling = new HighAlarm("PT100 Compressor Cooling Pressure", 1000, 500, 1, 1,"Check for high alarm", "PSIG");
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
}