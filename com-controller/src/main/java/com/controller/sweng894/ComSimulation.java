package com.controller.sweng894;

public class ComSimulation {

	public static int[] comTransmitterSim(int comStatus, int shutdown, int HIS500_STR, int VI100, int VT100_increment,
			int VI200, int VT200_increment, int VI300, int VT300_increment, int PT100, int PT100_increment, int TT100,
			int TT100_increment, int PT500, int PT500_increment, int PT2500, int PT2500_increment,int PY500,int PY100,int PY2500)
			{

		int[] TransmitterReading = new int[7]; // test input
		//if (comStatus == 0 && shutdown == 0 || HIS500_STR == 1) {
			TransmitterReading[0] = VI100; // milS: vib1-transmitter
			TransmitterReading[1] = VI200; // milS: vib2-transmitter
			TransmitterReading[2] = VI300; // milS: vib3-transmitter
			TransmitterReading[3] = PT100; // Psig: coolingPress
			TransmitterReading[4] = TT100; // DegC: oil temperature.
			TransmitterReading[5] = PT500; // Psig: Suction
			TransmitterReading[6] = PT2500;// Discharge pressure. 
		
		for (int i = 0; i <= 7; i++) {
			if (comStatus == 1) {
				TransmitterReading[0] = (VI100 + VT100_increment);
				TransmitterReading[1] = (VI200 + VT200_increment);
				TransmitterReading[2] = (VI300 + VT300_increment);
				TransmitterReading[3] = (PT100 + +PT100_increment);
				TransmitterReading[4] = (TT100 + TT100_increment);
				TransmitterReading[5] = (PT500 + ((PY500-PY100)/50)+PT500_increment/2);
				TransmitterReading[6] = (PT2500+ PT2500_increment-(PY100+PY2500)/80);
			}	else if (comStatus==0) {
			TransmitterReading[0] = 0; // milS: vib1-transmitter
			TransmitterReading[1] = 0; // milS: vib2-transmitter
			TransmitterReading[2] = 0; // milS: vib3-transmitter
			TransmitterReading[3] = 0; // Psig: coolingPress
			TransmitterReading[4] = 0; // DegC: oil temperature.
			TransmitterReading[5] = 0; // Psig: Suction
			TransmitterReading[6] = 0;// Discharge pressure. 
			}
		}
		return TransmitterReading;
	}
}
