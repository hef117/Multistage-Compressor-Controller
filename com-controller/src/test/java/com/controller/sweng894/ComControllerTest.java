package com.controller.sweng894;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.tools.javac.Main;

public class ComControllerTest {

// assert vibration system alarms	
	@Test
	public void vibalarm() {
		//Test the vibration alarm leaf for all 3 stages
	
		
		var alarmstag1= new HighAlarm("VT100", 1000, 500, 1, 1, "");
		var alarmstag2= new HighAlarm("VT200", 100, 500, 1, 1, "");
		var alarmstag3= new HighAlarm("VT300", 1000, 500, 1, 1, "");
		alarmstag1.detectHighAlarm();
		alarmstag2.detectHighAlarm();
		alarmstag3.detectHighAlarm();
		
}
// assert vibration system permissive 
	@Test
	public void vibpermissive() {

		//Test the vibration permissive leaf for all 3 stages.
		var auxvibStagVIB1= new AuxVibPermissive ("VT100",0,0, 0, "");
		var auxvibStagVIB2= new AuxVibPermissive ("VT200",0,0, 1, "");
		var auxvibStagVIB3= new AuxVibPermissive ("VT300",0,0, 0, "");
		
		auxvibStagVIB1.detectPermssive();
		auxvibStagVIB2.detectPermssive();
		auxvibStagVIB3.detectPermssive();
}
    // assert cooling system high alarms 
	@Test
		public  void AuxcoolingHighalarms1() {

			// Cooling test high cooling pressure test
			
			var compsite1 = new Compsite();
		
			ComAuxSys auxcooling     = new HighAlarm("PT100 Compressor Cooling Pressure", 1000, 500, 1, 1,"Compressor Cooling System");
			compsite1.addsys(auxcooling);
			auxcooling.detectHighAlarm();			
}
  // assert oil system system high alarms 
	@Test
		public  void AuxOilsystemHighalarms1() {

			//Auxoil high temperature test.
			
			var compsite2 = new Compsite();
		
			ComAuxSys auxoil     = new HighAlarm("TT100 Oil System Temperature",200, 100, 1, 1,"Compressor Oil System");
			compsite2.addsys(auxoil);
	
			auxoil.detectHighAlarm();			
}
		// assert compressor suction high alarms 
	@Test
		public  void comSuctionHighalarms1() {

			//compressor suction high alarms test.
			
			var compsite3 = new Compsite();
		
			ComAuxSys comSuction     = new HighAlarm("PT500 Compressor Suction Pressure",200, 100, 1, 1,"Compressor suction");
			compsite3.addsys(comSuction);
			comSuction.detectHighAlarm();
	}
	@Test
		public  void comDischargeHighalarms1() {
			//compressor discharge high alarms test.
			var compsite4 = new Compsite();
			ComAuxSys comDischarge     = new HighAlarm("PT2500 Compressor Discharge Pressure",300, 100, 1, 1,"Compressor discharge");
			compsite4.addsys(comDischarge);
			comDischarge.detectHighAlarm();		
	}		
}