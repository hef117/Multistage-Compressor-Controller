package com.controller.sweng894;

import java.util.ArrayList;
import java.util.List;

public interface ComAuxSys {
	// Interface to the Compressor controller -- is the client should pass sensor
	// parameters to detects alarms.

	
		void detectAlarm();
		void detectPermssive();
	}
	
//==========compressor composite systems===============================================================//
	// composite implementing the compressor controller interface
	class Compsite implements ComAuxSys {

		List<ComAuxSys> auxsystems = new ArrayList<>();

		// add the the first aux system
		public void addcomponent(Compsite Auxcooling) {
			auxsystems.add(Auxcooling);

		}

		@Override
		public void detectAlarm() {

		}

		@Override
		public void detectPermssive() {
			// TODO Auto-generated method stub
			
		}            
	}
//======================================Compressor vibration alarm leaf=======================================//
	//The compressor Vibration Alarms module is considered a leaf object since it has no final elements
	class AuxVibAlarm implements ComAuxSys {
		
		private String SensorTag;// vibration sensor tag number/compressor stage 
		private int VT; // Vibration Sensor reading 
		private int VSH; // Operator alarm Set point
		private int VAH; // Annunciator Alarm flag
		private int VT_STAT; // sensor integrity status;
		private String ALM_DSCRIP; // Annunciator alarm description 

		public AuxVibAlarm (String SensorTag, int VT, int VSH, int VAH, int VT_STAT, String ALM_DSCRIP) {
			this.SensorTag = SensorTag;
			this.VT = VT;
			this.VSH = VSH;
			this.VAH = VAH;
			this.VT_STAT = VT_STAT;
			this.ALM_DSCRIP = ALM_DSCRIP;
		}

		@Override
		public void detectAlarm() {
			//System.out.println(VT + " " + VSH + " " + VAH + " " + VT_STAT + " " + ALM_DSCRIP + " ");

			{
				if (VT_STAT == 1 && VT > VSH) {
					ALM_DSCRIP = "Hi vibration alarm";
					VAH = 1;
					System.out.println(SensorTag+" "+"Hi vibration alarm detected");
					if (VT_STAT != 1) {
						ALM_DSCRIP = SensorTag+" "+("SensorTag Sensor problem ");
					}
				} else
					System.out.println("No alarm ");
			}

		}
		
		@Override
		public void detectPermssive(){}
	}
		
 
//=================================The compressor Vibration Permissives leaf============================//
		
		//The compressor Vibration Alarms module is considered a leaf object since it has no final elements
		class AuxVibPermissive  implements ComAuxSys {
			
			private String SensorTag;// vibration sensor tag number/compressor stage 
			private int VPH; // Annunciator Permissive flag
			private int VT_STAT; // sensor integrity status;
			private int C_STAT; // COMPRESSOR STATUS = 1 running, 0 stopped, 2 failed to stop
			private String PERM_DSCRIP; // Annunciator permissive description 

			public  AuxVibPermissive (String SensorTag, int VT_STAT, int VPH, int C_STAT, String PERM_DSCRIP) {
				this.SensorTag = SensorTag;
				this.VT_STAT = VT_STAT;
				this.VPH = VPH;
				this.C_STAT = C_STAT;
				this.PERM_DSCRIP = PERM_DSCRIP;
			}

			@Override
			public void detectPermssive () {
				//System.out.println(SensorTag + " " + VT_STAT + " " + VPH + " " + C_STAT + " " + PERM_DSCRIP + " ");

				{
					if (C_STAT == 0 && VT_STAT !=1 ) {
						PERM_DSCRIP = "Permissive not granted check sensor ";
						VPH = 1;
						System.out.println(SensorTag+" "+PERM_DSCRIP);
						}
					
					else
						PERM_DSCRIP = "Permissive granted";
					    System.out.println(SensorTag+" "+PERM_DSCRIP);
				}

			}

			@Override
			public void detectAlarm() {
				// TODO Auto-generated method stub
				
			}

		}

