package com.controller.sweng894;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ComAuxSys {
	// Interface to the Compressor controller -- is the client should pass sensor
	// parameters to detects alarms .

	int detectHighAlarm();

	int comDriveStartStop();

	int detectLowAlarm();

	int detectPermssive();

	int detectHighShutdown();

	int detectLowShutdown();
}

//==========compressor composite systems===============================================================//
class Compsite implements ComAuxSys {

	private List<ComAuxSys> auxsystems = new ArrayList<ComAuxSys>();

	int event_flag = 0;

	@Override
	public int detectHighAlarm() {

		for (ComAuxSys c : auxsystems) {
			// System.out.println(c);
			event_flag = c.detectHighAlarm();

		}

		return event_flag;
	}

	@Override
	public int detectLowAlarm() {
		//
		for (ComAuxSys c : auxsystems) {
			// System.out.println(c);
			event_flag = c.detectLowAlarm();

		}
		return event_flag;
	}

	@Override
	public int detectHighShutdown() {

		for (ComAuxSys c : auxsystems) {
			// System.out.println(c);
			event_flag = c.detectHighShutdown();

		}
		return event_flag;
	}

	@Override
	public int detectLowShutdown() {

		for (ComAuxSys c : auxsystems) {
			// System.out.println(c);
			event_flag = c.detectLowShutdown();

		}
		return event_flag;
	}

	// add the the aux system
	public void addsys(ComAuxSys c) {

		auxsystems.add(c);
	}

	@Override
	public int detectPermssive() {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
	public int comDriveStartStop() {
//		// TODO Auto-generated method stub
	return 0;
	}

}

//======================================Compressor High alarm leaf=======================================//
// The compressor Vibration Alarms module is considered a leaf object since it
// has no final elements
class HighAlarm implements ComAuxSys {

	private String SensorTag; // vibration sensor tag number/compressor stage
	private int Sensor; // Vibration Sensor reading
	private int Sensor_SP; // Operator alarm Set point
	private int sensor_alarm_flag; // Annunciator Alarm flag
	private int sensor_STAT; // sensor integrity status;
	private String ALM_DSCRIP; // Annunciator alarm description
	private String Sensor_eng; // Annunciator alarm description

	public HighAlarm(String SensorTag, int Sensor, int Sensor_SP, int sensor_alarm_flag, int sensor_STAT,
			String ALM_DSCRIP, String Sensor_eng) {
		this.SensorTag = SensorTag;
		this.Sensor = Sensor;
		this.Sensor_SP = Sensor_SP;
		this.sensor_alarm_flag = sensor_alarm_flag;
		this.sensor_STAT = sensor_STAT;
		this.ALM_DSCRIP = ALM_DSCRIP;
		this.Sensor_eng = Sensor_eng;
	}

	@Override
	public int detectHighAlarm() {
		System.out.println("Input data to high alarm:" + SensorTag + "  " + Sensor + " " + Sensor_eng + "  Setpoint: "
				+ Sensor_SP + " " + Sensor_eng + "  " + "Sensor integrity:" + " " + sensor_STAT + " " + ALM_DSCRIP);

		if (sensor_STAT == 1 && Sensor >= Sensor_SP) {
			ALM_DSCRIP = "High alarm detected";
			sensor_alarm_flag = 1;
		} else if (sensor_STAT != 1) {
			ALM_DSCRIP = "Sensor problem call Tech ";
		} else if (Sensor < Sensor_SP) {
			ALM_DSCRIP = "Alarm cleared";
			sensor_alarm_flag = 0;
		}

		System.out.println(SensorTag + " " + Sensor + " " + Sensor_eng);
		System.out.println(SensorTag + " " + ALM_DSCRIP);
		System.out.println("Alarm Flag:" + " " + sensor_alarm_flag);
		System.out.println("================================");
		return sensor_alarm_flag;
	}

	@Override
	public int detectPermssive() {
		return 0;
	}

	@Override
	public int detectLowAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectHighShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int comDriveStartStop() {
//		// TODO Auto-generated method stub
		return 0;
	}
}
//================================= The Compressor low alarm leaf=======================================//

//The compressor  Alarms module is considered a leaf object since it has no other task to perform expect solve the alarm logic

class LowAlarm implements ComAuxSys {

	private String SensorTag; // sensor tag number/compressor stage
	private int Sensor; // Sensor reading
	private int Sensor_SP; // Operator alarm Set point
	private int sensor_alarm_flag; // Annunciator Alarm flag
	private int sensor_STAT; // sensor integrity status;
	private String ALM_DSCRIP; // Annunciator alarm description
	private String Sensor_eng; // Annunciator alarm description

	public LowAlarm(String SensorTag, int Sensor, int Sensor_SP, int sensor_alarm_flag, int sensor_STAT,
			String ALM_DSCRIP, String Sensor_eng) {
		this.SensorTag = SensorTag;
		this.Sensor = Sensor;
		this.Sensor_SP = Sensor_SP;
		this.sensor_alarm_flag = sensor_alarm_flag;
		this.sensor_STAT = sensor_STAT;
		this.ALM_DSCRIP = ALM_DSCRIP;
		this.Sensor_eng = Sensor_eng;
	}

	@Override
	public int detectLowAlarm() {

		System.out.println("Input data to low alarm:" + SensorTag + "  " + Sensor + " " + Sensor_eng + "  Setpoint: "
				+ Sensor_SP + " " + Sensor_eng + "  " + "Sensor integrity:" + " " + sensor_STAT + " " + ALM_DSCRIP);

		if (sensor_STAT == 1 && Sensor < Sensor_SP) {
			ALM_DSCRIP = "Low alarm detected";
			sensor_alarm_flag = 1;
		} else if (sensor_STAT != 1) {
			ALM_DSCRIP = "Sensor problem call Tech ";
		} else if (sensor_STAT == 1 && Sensor >= Sensor_SP) {
			ALM_DSCRIP = "Alarm cleared";
			sensor_alarm_flag = 0;
		}
		System.out.println(SensorTag + " " + Sensor + " " + Sensor_eng);
		System.out.println(SensorTag + " " + ALM_DSCRIP);
		System.out.println("Alarm Flag:" + " " + sensor_alarm_flag);
		System.out.println("================================");
		return sensor_alarm_flag;
	}

	@Override
	public int detectPermssive() {
		return 0;
	}

	@Override
	public int detectHighAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectHighShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int comDriveStartStop() {
//		// TODO Auto-generated method stub
		return 0;
	}
}

//=================================The compressor Permissive leaf============================//

// The compressor permissive module is considered a leaf object since it has no
// other elements
class AuxVibPermissive implements ComAuxSys {

	private String sensorTag; // sensor tag number/compressor stage
	private int sensor_permis_flag; // Annunciator Permissive flag
	private int sensor_STAT; // sensor integrity status;
	private int C_STAT; // COMPRESSOR STATUS = 1 running, 0 stopped, 2 failed to stop
	private String PERM_DSCRIP; // Annunciator permissive description

	public AuxVibPermissive(String sensorTag, int sensor_STAT, int sensor_permis_flag, int C_STAT, String PERM_DSCRIP) {
		this.sensorTag = sensorTag;
		this.sensor_STAT = sensor_STAT;
		this.sensor_permis_flag = sensor_permis_flag;
		this.C_STAT = C_STAT;
		this.PERM_DSCRIP = PERM_DSCRIP;
	}

	@Override
	public int detectPermssive() {
		// When the machine is not running, check each vibration sensors transmitter
		// status and
		// set VPH to high to prevent the machine from starting until the sensor is
		// fixed.
		// Do not trip the machine if the machine is running and the sensor goes bad.
		// The alarm logic will notify the operator by setting the sensor alarm flag.
		System.out.println("Input data permissive leaf:" + sensorTag + "Sensor integrity:" + " " + sensor_STAT + " "
				+ "Compressor Status:" + " " + C_STAT + " " + PERM_DSCRIP);
		{
			if (C_STAT == 0 && sensor_STAT != 1) {
				PERM_DSCRIP = "Permissive not granted check sensor ";
				sensor_permis_flag = 0;
			}

			else if (C_STAT == 1 || sensor_STAT == 1) {
				PERM_DSCRIP = "Permissive granted";
				sensor_permis_flag = 1;
			}
			System.out.println(sensorTag + " " + PERM_DSCRIP);
			System.out.println(sensorTag + " " + "PERMISSIVE  STATUS =" + sensor_permis_flag);
			System.out.println("================================");
			return sensor_permis_flag;
		}
	}

	@Override
	public int detectHighAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectHighShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int comDriveStartStop() {
//		// TODO Auto-generated method stub
		return 0;
	}

}

//========================================= Shutdown high=====================================//

// The compressor Vibration Alarms module is considered a leaf object since it
// has no final elements
class Highshutdown implements ComAuxSys {

	private String sensorTag; // sensor tag name.
	private int sensor; // sensor reading
	private int sensor_SP; // operator alarm set-point
	private int sensor_shutdown_flag; // annunciator alarm flag
	private int sensor_STAT; // sensor integrity status;
	private String SD_DSCRIP; // annunciator alarm description
	private String sensor_eng; // sensor engineering unit.

	public Highshutdown(String sensorTag, int sensor, int sensor_SP, int sensor_shutdown_flag, int sensor_STAT,
			String SD_DSCRIP, String sensor_eng)

	{
		this.sensorTag = sensorTag;
		this.sensor = sensor;
		this.sensor_SP = sensor_SP;
		this.sensor_shutdown_flag = sensor_shutdown_flag;
		this.sensor_STAT = sensor_STAT;
		this.SD_DSCRIP = SD_DSCRIP;
		this.sensor_eng = sensor_eng;
	}

	@Override
	public int detectHighShutdown() {
		System.out.println("Input data to high shutdown:" + sensorTag + "  " + sensor + " " + sensor_eng
				+ "  Setpoint: " + sensor_SP + " " + sensor_eng + "  " + "Sensor integrity:" + " " + sensor_STAT + " "
				+ SD_DSCRIP);

		// if the sensor reading is valid if the alarm exceeds the set point and set the
		// alarm flag,
		if (sensor_STAT == 1 && sensor >= sensor_SP) {
			SD_DSCRIP = "High Shutdown Tripped";
			sensor_shutdown_flag = 1;
		} else if (sensor_STAT != 1) {
			SD_DSCRIP = "Sensor problem call Tech ";
		} else if (sensor < sensor_SP) {
			SD_DSCRIP = "High Shutdown Reset";
			sensor_shutdown_flag = 0;
		}
		System.out.println(sensorTag + " " + sensor + " " + sensor_eng);
		System.out.println(sensorTag + " " + SD_DSCRIP);
		System.out.println("Shutdown Flag:" + " " + sensor_shutdown_flag);
		System.out.println("================================");
		return sensor_shutdown_flag;
	}

	@Override
	public int detectHighAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectPermssive() {
		return 0;
	}

	@Override
	public int detectLowShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int comDriveStartStop() {
//		// TODO Auto-generated method stub
		return 0;
	}
}
//========================================= Shutdown Low=====================================//

// The compressor Low shutdown module.
class Lowshutdown implements ComAuxSys {

	private String sensorTag;// sensor tag number/compressor stage
	private int sensor; // Sensor reading
	private int sensor_SP; // Operator Set point
	private int sensor_shutdown_flag; // Annunciator Alarm flag
	private int sensor_STAT; // sensor integrity status;
	private String SD_DSCRIP; // Annunciator alarm description
	private String sensor_eng; // Annunciator alarm description

	public Lowshutdown(String sensorTag, int sensor, int sensor_SP, int sensor_shutdown_flag, int sensor_STAT,
			String SD_DSCRIP, String sensor_eng)

	{
		this.sensorTag = sensorTag;
		this.sensor = sensor;
		this.sensor_SP = sensor_SP;
		this.sensor_shutdown_flag = sensor_shutdown_flag;
		this.sensor_STAT = sensor_STAT;
		this.SD_DSCRIP = SD_DSCRIP;
		this.sensor_eng = sensor_eng;
	}

	@Override
	public int detectLowShutdown() {
		System.out.println("Input data to lOW shutdown:" + sensorTag + "  " + sensor + " " + sensor_eng + "  Setpoint: "
				+ sensor_SP + " " + sensor_eng + "  " + "Sensor integrity:" + " " + sensor_STAT + " " + SD_DSCRIP);

		if (sensor_STAT == 1 && sensor <= sensor_SP) {
			SD_DSCRIP = "Low Shutdown Tripped";
			sensor_shutdown_flag = 1;
		} else if (sensor_STAT != 1) {
			SD_DSCRIP = "Sensor problem call Tech ";
		} else if (sensor > sensor_SP) {
			SD_DSCRIP = "Low Shutdown RESET";
			sensor_shutdown_flag = 0;
		}
		System.out.println(sensorTag + " " + sensor + " " + sensor_eng);
		System.out.println(sensorTag + " " + SD_DSCRIP);
		System.out.println("Shutdown Flag:" + " " + sensor_shutdown_flag);
		System.out.println("================================");
		return sensor_shutdown_flag;
	}

	@Override
	public int detectHighAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectPermssive() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int detectHighShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int comDriveStartStop() {
//		// TODO Auto-generated method stub
		return 0;
	}
}

//===================================Compressor Drive=====================================//

// The compressor code for drive.
class ComDrive implements ComAuxSys {

	private String comRequest;// Command to
	private int cmdStart; // Sensor reading
	private int cmdStop; // Operator Set point
	private int permissClear; // Annunciator Alarm flag
	private int shutDwnClear; // sensor integrity status;
	private int C_Status;
	private String DriverFeedBack; // Annunciator alarm description
	private String cmdMessage; // Annunciator alarm description

	public ComDrive(String comRequest, int cmdStart, int cmdStop, int permissClear, int shutDwnClear, int C_Status,
			String DriverFeedBack)

	{
		this.comRequest = comRequest;
		this.cmdStart = cmdStart;
		this.cmdStop = cmdStop;
		this.permissClear = permissClear;
		this.shutDwnClear = shutDwnClear;
		this.C_Status = C_Status;
		// this.cmdMessage = cmdMessage;
		this.DriverFeedBack = DriverFeedBack;
	}

	@Override
	public int comDriveStartStop() {
		// if not stop command is engaged and permissives and shutdowns are cleared and the start command is issued. 

		if (cmdStop==0 && permissClear == 1 && shutDwnClear == 0 && cmdStart == 1) {
			C_Status = 1;
			cmdMessage = "Com Driver is energized";
		} 
		else if (shutDwnClear != 0) {
			C_Status = 0;
			cmdMessage = "Compressor can not be started shutdown is active";	
		} 
		else if ( shutDwnClear == 1 ) {
			C_Status = 0;
			cmdMessage = "Com Driver is de-energized - shutdown triggered";
			} 
		else if (cmdStop == 1) {
			C_Status = 0;
			cmdMessage = "Com Driver is de-energized - manual stop command";
			} 
		else if (C_Status == 0 && permissClear != 1) {
				C_Status = 0;
				cmdMessage = "Compressor can not be started permissive is not okay";
			}
		else {
			C_Status = 0;
			cmdMessage = "Compressor ready for start command";
			
		}
		DriverFeedBack=cmdMessage;
		System.out.println("Opertor Command Drive:" + " " + comRequest);
		System.out.println("Compressor Driver Status:" + cmdMessage);
		System.out.println("================================");
				

		return C_Status;
	}

	@Override
	public int detectHighAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowAlarm() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectPermssive() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int detectHighShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int detectLowShutdown() {
		// TODO Auto-generated method stub
		return 0;
	}

}

