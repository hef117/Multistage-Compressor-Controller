package com.controller.sweng894;

import java.util.ArrayList;
import java.util.List;

public interface ComAuxSys {
	// Interface to the Compressor controller -- is the client should pass sensor
	// parameters to detects alarms  .

	
		void detectHighAlarm();
		void detectLowAlarm();
		void detectPermssive();
	}
	
//==========compressor composite systems===============================================================//
	class Compsite implements ComAuxSys {
		
		
		private List<ComAuxSys> auxsystems = new ArrayList<ComAuxSys>();

		@Override
		public void detectHighAlarm() 
		{
			// 
              for(ComAuxSys c :auxsystems) {
            	  System.out.println(c);
		        c.detectHighAlarm();
				}
		}
		// add the the aux system
		public void addsys(ComAuxSys c) {
			
			auxsystems.add(c);
		}
		
		

		
		@Override
		public void detectPermssive() {
	//		TODO Auto-generated method stub
			
		}
		@Override
		public void detectLowAlarm() {
			// TODO Auto-generated method stub
			
		}
		
		
}
//======================================Compressor High alarm leaf=======================================//
	//The compressor Vibration Alarms module is considered a leaf object since it has no final elements
	class HighAlarm implements ComAuxSys {
		
		private String SensorTag;// vibration sensor tag number/compressor stage 
		private int Sensor; // Vibration Sensor reading 
		private int Sensor_SP; // Operator alarm Set point
		private int sensor_alarm_flag; // Annunciator Alarm flag
		private int sensor_STAT; // sensor integrity status;
		private String ALM_DSCRIP; // Annunciator alarm description 

		public HighAlarm (String SensorTag, int Sensor, int Sensor_SP, int sensor_alarm_flag, int sensor_STAT, String ALM_DSCRIP) {
			this.SensorTag = SensorTag;
			this.Sensor = Sensor;
			this.Sensor_SP = Sensor_SP;
			this.sensor_alarm_flag = sensor_alarm_flag;
			this.sensor_STAT = sensor_STAT;
			this.ALM_DSCRIP = ALM_DSCRIP;
		}

		@Override
		public void detectHighAlarm( ) {
			//System.out.println(VT + " " + VSH + " " + VAH + " " + VT_STAT + " " + ALM_DSCRIP + " ");

			
				if (sensor_STAT == 1 && Sensor >= Sensor_SP) {
					ALM_DSCRIP = "High alarm";
					sensor_alarm_flag = 1;
					}
				else if (sensor_STAT !=1) {
						ALM_DSCRIP = "Sensor problem call Tech ";}
				else if (sensor_STAT ==1 && Sensor < Sensor_SP) {
					 ALM_DSCRIP = "NO ALARM";
					 sensor_alarm_flag = 0;
					}
				System.out.println(SensorTag+" "+ALM_DSCRIP);
				System.out.println (SensorTag+" "+"Alarm Status ="+sensor_alarm_flag) ;
		}
				
	
		@Override
		public void detectPermssive(){}

		@Override
		public void detectLowAlarm() {
			// TODO Auto-generated method stub
			
		}
	}
//================================= The Compressor low alarm leaf=======================================//
	
//The compressor  Alarms module is considered a leaf object since it has no other task to perform expect solve the alarm logic
	
		class LowAlarm implements ComAuxSys {
			
			private String SensorTag;// sensor tag number/compressor stage 
			private int Sensor; //  Sensor reading 
			private int Sensor_SP; // Operator alarm Set point
			private int sensor_alarm_flag; // Annunciator Alarm flag
			private int sensor_STAT; // sensor integrity status;
			private String ALM_DSCRIP; // Annunciator alarm description 

			public LowAlarm (String SensorTag, int Sensor, int Sensor_SP, int sensor_alarm_flag, int sensor_STAT, String ALM_DSCRIP) {
				this.SensorTag = SensorTag;
				this.Sensor = Sensor;
				this.Sensor_SP = Sensor_SP;
				this.sensor_alarm_flag = sensor_alarm_flag;
				this.sensor_STAT = sensor_STAT;
				this.ALM_DSCRIP = ALM_DSCRIP;
			}

			@Override
			public void detectLowAlarm( ) {
				//System.out.println(VT + " " + VSH + " " + VAH + " " + VT_STAT + " " + ALM_DSCRIP + " ");

				
					if (sensor_STAT == 1 && Sensor < Sensor_SP) {
						ALM_DSCRIP = "Low alarm";
						sensor_alarm_flag = 1;
						}
					else if (sensor_STAT !=1) {
							ALM_DSCRIP = "Sensor problem call Tech ";}
					else if (sensor_STAT ==1 && Sensor >= Sensor_SP) {
						 ALM_DSCRIP = "NO ALARM";
						 sensor_alarm_flag = 0;
						}
					System.out.println(SensorTag+" "+ALM_DSCRIP);
					System.out.println (SensorTag+" "+"Alarm Status ="+sensor_alarm_flag) ;
			}
					
		
			@Override
			public void detectPermssive(){}

			@Override
			public void detectHighAlarm() {
				// TODO Auto-generated method stub
				
			}
		}

	
//=================================The compressor Vibration Permissives leaf============================//
		
		//The compressor Vibration permissive  module is considered a leaf object since it has no other elements 
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
				// When the machine is not running, check each vibration sensors transmitter status,
				// Set VPH to high to prevent the machine from running until the sensor is fixed. 
				// Do not trip the machine if the machine is running and the sensor goes bad - the alarm logic will set the alarm. 

				{
					if (C_STAT == 0 && VT_STAT !=1 ) {
						PERM_DSCRIP = "Permissive not granted check sensor ";
						VPH = 1;
						}
					
					else
						PERM_DSCRIP = "Permissive granted";
				}
				System.out.println(SensorTag+" "+PERM_DSCRIP);
				System.out.println(SensorTag+" "+"PERMISSIVE  STATUS =" + VPH );
			}

			@Override
			public void detectHighAlarm() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void detectLowAlarm() {
				// TODO Auto-generated method stub
				
			}

		}

