package com.controller.sweng894;

import java.util.ArrayList;
import java.util.List;

public interface ComAuxSys {
	// Interface to the Compressor controller -- is the client should pass sensor
	// parameters to detects alarms  .

	
		void detectHighAlarm();
		void detectLowAlarm();
		void detectPermssive();
		void detectHighShutdown();
		void detectLowShutdown();
	}
	
//==========compressor composite systems===============================================================//
	class Compsite implements ComAuxSys {
		
		
		private List<ComAuxSys> auxsystems = new ArrayList<ComAuxSys>();

		@Override
		public void detectHighAlarm() 
		{
			// 
              for(ComAuxSys c :auxsystems) {
            	  //System.out.println(c);
		        c.detectHighAlarm();
		      
				}
		}
		
		@Override
		public void detectLowAlarm() {
			// 
            for(ComAuxSys c :auxsystems) {
          	  //System.out.println(c);
		        c.detectLowAlarm();
		       
				}
		}
		
		@Override
		public void detectHighShutdown() {
			// 
            for(ComAuxSys c :auxsystems) {
          	  //System.out.println(c);
		        c.detectHighShutdown();
		       
				}
		}
		
		@Override
		public void detectLowShutdown() {
			// 
            for(ComAuxSys c :auxsystems) {
          	  //System.out.println(c);
		        c.detectLowShutdown();
		       
				}
		}


		 // add the the aux system
		public void addsys(ComAuxSys c) {
			
			auxsystems.add(c);
	   }
		
		
		@Override
		public void detectPermssive() {
	    //	TODO Auto-generated method stub
			
		}

		
		
		
}
//======================================Compressor High alarm leaf=======================================//
	//The compressor Vibration Alarms module is considered a leaf object since it has no final elements
	class HighAlarm implements ComAuxSys {
		
		private String  SensorTag;         // vibration sensor tag number/compressor stage 
		private int     Sensor;            // Vibration Sensor reading 
		private int     Sensor_SP;         // Operator alarm Set point
		private int     sensor_alarm_flag; // Annunciator Alarm flag
		private int     sensor_STAT;       // sensor integrity status;
		private String  ALM_DSCRIP;        // Annunciator alarm description
		private String  Sensor_eng;        // Annunciator alarm description 

		public HighAlarm (String SensorTag, int Sensor, int Sensor_SP, int sensor_alarm_flag, int sensor_STAT, String ALM_DSCRIP,String Sensor_eng) {
			this.SensorTag         = SensorTag;
			this.Sensor            = Sensor;
			this.Sensor_SP         = Sensor_SP;
			this.sensor_alarm_flag = sensor_alarm_flag;
			this.sensor_STAT       = sensor_STAT;
			this.ALM_DSCRIP        = ALM_DSCRIP;
			this.Sensor_eng        = Sensor_eng;
		}

		@Override
		public void detectHighAlarm( ) {
			System.out.println("Input data to high alarm:"+ SensorTag +"  "+Sensor +" "+Sensor_eng+"  Setpoint: "+ Sensor_SP+" "+Sensor_eng+"  "+"Sensor integrity:"+" "+sensor_STAT + " " + ALM_DSCRIP);

			
				if (sensor_STAT == 1 && Sensor >= Sensor_SP) {
					ALM_DSCRIP = "High alarm detected";
					sensor_alarm_flag = 1;
					}
				else if (sensor_STAT !=1) {
						ALM_DSCRIP = "Sensor problem call Tech ";}
				else if (sensor_STAT ==1 && Sensor < Sensor_SP) {
					 ALM_DSCRIP = "NO ALARM";
					}
				
				System.out.println(SensorTag+" "+Sensor+" "+Sensor_eng);
				System.out.println(SensorTag+" "+ALM_DSCRIP);
				System.out.println("Alarm Flag:"+" "+sensor_alarm_flag);
				System.out.println("================================");
				
		}
				
	
		@Override
		public void detectPermssive(){}

		@Override
		public void detectLowAlarm() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void detectHighShutdown() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void detectLowShutdown() {
			// TODO Auto-generated method stub
			
		}
	}
//================================= The Compressor low alarm leaf=======================================//
	
//The compressor  Alarms module is considered a leaf object since it has no other task to perform expect solve the alarm logic
	
		class LowAlarm implements ComAuxSys {
			
			private String  SensorTag;         // sensor tag number/compressor stage 
			private int     Sensor;            // Sensor reading 
			private int     Sensor_SP;         // Operator alarm Set point
			private int     sensor_alarm_flag; // Annunciator Alarm flag
			private int     sensor_STAT;       // sensor integrity status;
			private String  ALM_DSCRIP;        // Annunciator alarm description 
			private String  Sensor_eng;        // Annunciator alarm description 

			public LowAlarm (String SensorTag, int Sensor, int Sensor_SP, int sensor_alarm_flag, int sensor_STAT, String ALM_DSCRIP,String Sensor_eng) {
				this.SensorTag         = SensorTag;
				this.Sensor            = Sensor;
				this.Sensor_SP         = Sensor_SP;
				this.sensor_alarm_flag = sensor_alarm_flag;
				this.sensor_STAT       = sensor_STAT;
				this.ALM_DSCRIP        = ALM_DSCRIP;
				this.Sensor_eng        = Sensor_eng;
			}

			@Override
			public void detectLowAlarm( ) {
				
				System.out.println("Input data to low alarm:"+ SensorTag +"  "+Sensor +" "+Sensor_eng+"  Setpoint: "+ Sensor_SP+" "+Sensor_eng+"  "+"Sensor integrity:"+" "+sensor_STAT + " " + ALM_DSCRIP);
				
					if (sensor_STAT == 1 && Sensor < Sensor_SP) {
						ALM_DSCRIP = "Low alarm detected";
						sensor_alarm_flag = 1;
						}
					else if (sensor_STAT !=1) {
							ALM_DSCRIP = "Sensor problem call Tech ";}
					else if (sensor_STAT ==1 && Sensor >= Sensor_SP) {
						 ALM_DSCRIP = "NO ALARM";
						 sensor_alarm_flag = 0;
						}
					System.out.println (SensorTag+" "+Sensor+" "+Sensor_eng);
					System.out.println(SensorTag+" "+ALM_DSCRIP);
					System.out.println("Alarm Flag:"+" "+sensor_alarm_flag);
					System.out.println("================================");
			}
					
		
			@Override
			public void detectPermssive(){}

			@Override
			public void detectHighAlarm() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void detectHighShutdown() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void detectLowShutdown() {
				// TODO Auto-generated method stub
				
			}
		}

	
//=================================The compressor Vibration Permissives leaf============================//
		
		//The compressor Vibration permissive  module is considered a leaf object since it has no other elements 
		class AuxVibPermissive  implements ComAuxSys {
			
			private String   SensorTag;   // sensor tag number/compressor stage 
			private int      VPH;         // Annunciator Permissive flag
			private int      VT_STAT;     // sensor integrity status;
			private int      C_STAT;      // COMPRESSOR STATUS = 1 running, 0 stopped, 2 failed to stop
			private String   PERM_DSCRIP; // Annunciator permissive description 

			public  AuxVibPermissive (String SensorTag, int VT_STAT, int VPH, int C_STAT, String PERM_DSCRIP) {
				this.SensorTag       = SensorTag;
				this.VT_STAT         = VT_STAT;
				this.VPH             = VPH;
				this.C_STAT          = C_STAT;
				this.PERM_DSCRIP     = PERM_DSCRIP;
			}

			@Override
			public void detectPermssive () {
				// When the machine is not running, check each vibration sensors transmitter status and
				// set VPH to high to prevent the machine from starting until the sensor is fixed. 
				// Do not trip the machine if the machine is running and the sensor goes bad.
				// The alarm logic will notify the operator by setting the sensor alarm flag. 

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
				System.out.println("================================");
			}

			@Override
			public void detectHighAlarm() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void detectLowAlarm() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void detectHighShutdown() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void detectLowShutdown() {
				// TODO Auto-generated method stub
				
			}

		}

//========================================= Shutdown high=====================================//
		
		//The compressor Vibration Alarms module is considered a leaf object since it has no final elements
		class Highshutdown implements ComAuxSys {
			
			private String   sensorTag;               // sensor tag name. 
			private int      sensor;                  // sensor reading 
			private int      sensor_SP;               // operator alarm set-point
			private int      sensor_shutdown_flag;    // annunciator alarm flag
			private int      sensor_STAT;             // sensor integrity status;
			private String   SD_DSCRIP;               // annunciator alarm description
			private String   sensor_eng;              // sensor engineering unit. 

	    public Highshutdown 
	    (String sensorTag, int sensor, int sensor_SP, int sensor_shutdown_flag, int sensor_STAT, String SD_DSCRIP,String sensor_eng) 

			{
				this.sensorTag             = sensorTag;
				this.sensor                = sensor;
				this.sensor_SP             = sensor_SP;
				this.sensor_shutdown_flag  = sensor_shutdown_flag;
				this.sensor_STAT           = sensor_STAT;
				this.SD_DSCRIP             = SD_DSCRIP;
				this.sensor_eng            = sensor_eng;
			}

			@Override
		public void detectHighShutdown() {
		System.out.println("Input data to high shutdown:"+ sensorTag +"  "+sensor +" "+sensor_eng+"  Setpoint: "+ sensor_SP+" "+sensor_eng+"  "+"Sensor integrity:"+" "+sensor_STAT + " " + SD_DSCRIP);	

				// if the sensor reading is valid if the alarm exceeds the set point and set the alarm flag,   
					if (sensor_STAT == 1 && sensor >= sensor_SP) {
						SD_DSCRIP = "High Shutdown";
						sensor_shutdown_flag = 1;
						}
					else if (sensor_STAT !=1) {
						SD_DSCRIP = "Sensor problem call Tech ";}
					else if (sensor_STAT ==1 && sensor < sensor_SP) {
						SD_DSCRIP = "NO RESET";
						 sensor_shutdown_flag = 0;
						}
					System.out.println (sensorTag+" "+sensor+" "+sensor_eng);
					System.out.println(sensorTag+" "+SD_DSCRIP);
					System.out.println("Shutdown Flag:"+" "+sensor_shutdown_flag);
					System.out.println("================================");
					
			}
					
		
			@Override
			public void detectHighAlarm() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void detectLowAlarm() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void detectPermssive(){}

			@Override
			public void detectLowShutdown() {
				// TODO Auto-generated method stub
				
			}
		}
//========================================= Shutdown Low=====================================//
			
			//The compressor Low shutdown module.
			class Lowshutdown implements ComAuxSys {
				
				private String   sensorTag;//sensor tag number/compressor stage 
				private int      sensor; //Sensor reading 
				private int      sensor_SP; // Operator Set point
				private int      sensor_shutdown_flag; // Annunciator Alarm flag
				private int      sensor_STAT; // sensor integrity status;
				private String   SD_DSCRIP; // Annunciator alarm description
				private String   sensor_eng; // Annunciator alarm description 

		    public Lowshutdown 
		    (String sensorTag, int sensor, int sensor_SP, int sensor_shutdown_flag, int sensor_STAT, String SD_DSCRIP,String sensor_eng) 

				{
					this.sensorTag            = sensorTag;
					this.sensor               = sensor;
					this.sensor_SP            = sensor_SP;
					this.sensor_shutdown_flag = sensor_shutdown_flag;
					this.sensor_STAT          = sensor_STAT;
					this.SD_DSCRIP            = SD_DSCRIP;
					this.sensor_eng           = sensor_eng;
				}

				@Override
			public void detectLowShutdown() {
			System.out.println("Input data to lOW shutdown:"+ sensorTag +"  "+sensor +" "+sensor_eng+"  Setpoint: "+ sensor_SP+" "+sensor_eng+"  "+"Sensor integrity:"+" "+sensor_STAT + " " + SD_DSCRIP);	

					
						if (sensor_STAT == 1 && sensor <= sensor_SP) {
							SD_DSCRIP = "Low Shutdown";
							sensor_shutdown_flag = 1;
							}
						else if (sensor_STAT !=1) {
							SD_DSCRIP = "Sensor problem call Tech ";}
						else if (sensor_STAT ==1 && sensor > sensor_SP) {
							SD_DSCRIP = "NO RESET Requried";
							 sensor_shutdown_flag = 0;
							}
						System.out.println (sensorTag+" "+sensor+" "+sensor_eng);
						System.out.println(sensorTag+" "+SD_DSCRIP);
						System.out.println("Shutdown Flag:"+" "+sensor_shutdown_flag);
						System.out.println("================================");
						
				}
						
			
				@Override
				public void detectHighAlarm() {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void detectLowAlarm() {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void detectPermssive(){
					// TODO Auto-generated method stub
					
				}
				
				public void detectHighShutdown(){
					// TODO Auto-generated method stub
					
				}
				
				

}	

