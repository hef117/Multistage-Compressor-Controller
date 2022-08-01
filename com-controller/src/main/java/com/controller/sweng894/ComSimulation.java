package com.controller.sweng894;

public class ComSimulation {

	public static int[] comTransmitterSim(int comStatus, int VT100_increment, int VT200_increment, int VT300_increment,
			int PT100_increment, int TT100_increment, int PT500_increment, int PT2500_increment)
			throws InterruptedException {

		// assert comAlmStatus class unit test
		int[] TransmitterReading = new int[7]; // test input
		TransmitterReading[0] = TransmitterReading[0]; // milS: vib1-transmitter
		TransmitterReading[1] = 4; // milS: vib2-transmitter
		TransmitterReading[2] = 3; // milS: vib3-transmitter
		TransmitterReading[3] = 20; // Psig: coolingPress
		TransmitterReading[4] = 185; // DegC: oil temperature.
		TransmitterReading[5] = 7; // Psig: Suction
		TransmitterReading[6] = 10; // Psig: Discharge

		for (int i = 0; i <= 15; i++) {

		 if (i <= 15) {
				if (i < 5) {
					if (comStatus == 1) {
						Thread.sleep(500);
						TransmitterReading[0] = (TransmitterReading[0] + VT100_increment);
						TransmitterReading[1] = (TransmitterReading[1] + VT200_increment);
						TransmitterReading[2] = (TransmitterReading[2] + VT300_increment);

					}
				} else if (i >= 5 && i < 8) {
					if (comStatus == 1) {
						//Thread.sleep(1);
						TransmitterReading[3] = (TransmitterReading[3] + PT100_increment);
						TransmitterReading[4] = (TransmitterReading[4] + TT100_increment);
						
						//System.out.println("Simulation Cooling Pressure   : " + "PT100: " + TransmitterReading[3] + "PSIG  ");
						//System.out.println("Simulation Aux-Oil Temperature: " + "TT100: " + TransmitterReading[4] + "degC  ");
						
					} 
					
				}else if (i >= 8 && i < 13) {
						if (comStatus == 1) {
							//Thread.sleep(1000);
							TransmitterReading[5] = (TransmitterReading[5] + PT500_increment);
							//System.out.println("Simulation Suction   Pressure: " + "PT500: " + TransmitterReading[5] +  "PSIG  ");
							TransmitterReading[6] = (TransmitterReading[6] + PT2500_increment);
							//System.out.println("Simulation Discharge Pressure: " + "PT2500: " + TransmitterReading[6] + "PSIG  ");
								
						}
					}
								
			}
				
	 }
		return TransmitterReading;
  }
}


