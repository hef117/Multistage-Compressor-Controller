package com.controller.sweng894;

public class ComAutoLoad {

	public static int[] comAutoLoadPermissives(int comStatus, boolean startupPeriodDone, int shutdownWord) {
		int autoloadingPermissive = 0;
		int[] ActuatorsValues = new int[10]; // Current Ramp value
		if (shutdownWord == 0) {
			if (comStatus == 1) {
				if (startupPeriodDone == true) {
					autoloadingPermissive = 1;
				}
			} else if (shutdownWord == 1 || comStatus == 0 || startupPeriodDone == false) {
				autoloadingPermissive = 0;
			}
			ActuatorsValues[9] = autoloadingPermissive;
		}
		return ActuatorsValues;
	}

	public static int[] comAutoLoadingRamp(int comStatus, int okayToload, int PI500, int PSL500, int PI2500,
			int PSH2500, int PY500, int PYS500RamUp, int PY2500, int PYS2500RamUp, int PY100, int PYS100RamUp,
			int loadSetPoint) throws Exception {

		int[] ValvesOutput = new int[10];
		ValvesOutput[0] = PY500;
		ValvesOutput[1] = PY100;
		ValvesOutput[2] = PY2500;
		int SuctionRamRateValid = 0;
		int DischargeRamRateValid = 0;
		
		boolean PY100_DONE = false;
		boolean PY500_DONE = false;
		boolean PY2500_DONE = false;

		//

		// Determine the ramp-rate of the suction valve
		if (PYS500RamUp >= PYS100RamUp) {
			if (PYS500RamUp >= 2 * PYS100RamUp) {
				SuctionRamRateValid = 1; // suction ramp rate is valid.
			} else {
				PYS500RamUp = 10;
				PYS100RamUp = 5;
				SuctionRamRateValid = 1;
			}
		} else if (PYS500RamUp < PYS100RamUp) {
			if (PYS500RamUp < 10) {
				PYS100RamUp = PYS500RamUp * 2;
				SuctionRamRateValid = 1; // suction ramp rate is valid.
			} else {
				PYS100RamUp = PYS500RamUp * 2;
				SuctionRamRateValid = 1;
			}
		}
		ValvesOutput[9] = SuctionRamRateValid;
		
		
		for (int i = 0; i <= 50; i++) {
			Thread.sleep(00);
			boolean loadingComplete = false;
			// check if loading is done
			if (PY2500_DONE == true&&PY500_DONE == true) {
				loadingComplete=true;
			 }else {
				loadingComplete=false;
		   }
			// check loading point.
			if(PI2500 > loadSetPoint) {
				 ValvesOutput[8]=1;
		          	       }else {
		          	    	 ValvesOutput[8]=0;
		          	    }
			
			if (okayToload == 1) {
				// suction valve
				if (PY500 < 100 && PY500_DONE == false) {
					ValvesOutput[0] = (PY500 + PYS500RamUp);
				} else if (PY500 >= 100) {
					ValvesOutput[0] = 100;
				} else if (PY500 == 100) {
					PY500_DONE = true;
				}
			}
			// recirculation valve
			if (okayToload == 1&&loadingComplete==false&&ValvesOutput[8]==0) {
				if (PY100 > 0&& PY100_DONE == false) {
					ValvesOutput[1] = (PY100 - PYS100RamUp);
			    }else if (ValvesOutput[8]==1) {
					PY100_DONE = true;;
				  }
				else if (PY100 <=0) {
					ValvesOutput[1] = 0;
					PY100_DONE = true;
				   } 
			}
	  
			// discharge valve
			if (okayToload == 1&& loadingComplete==false&&ValvesOutput[8]==0) {
			   if(PY2500 < 100&& PY2500_DONE == false) {   
					     ValvesOutput[2] = (PY2500 + PYS2500RamUp);
				  }else if (ValvesOutput[8]==1) {
					PY2500_DONE = true;;
				  }else if (PY2500 >=100) {
					ValvesOutput[2] = 100;
					PY2500_DONE = true;
				  }
			}
	 }
		if (comStatus == 0) {
			ValvesOutput[0] = 0;
			ValvesOutput[1] = 100;
			ValvesOutput[2] = 0;
		 }
	return ValvesOutput;
   }
}

