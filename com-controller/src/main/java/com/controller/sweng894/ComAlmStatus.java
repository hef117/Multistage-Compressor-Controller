package com.controller.sweng894;

public class ComAlmStatus {
	
	// Check if the operator would like to disable alarms set the alarm flag to 2 . 
		
	public static int[] alarmStatus (int DisabReqIn,int EnabReqIn,int AlrmLoIn,int AlrmHiIn) {
		int[] flag = new int[2];
		int DisabReq = DisabReqIn;
	    int EnabReq  = EnabReqIn;
	    int AlrmLo   = AlrmLoIn;
	    int AlrmHi   = AlrmHiIn;
				if (EnabReq==1) {			    
					AlrmLo=AlrmLoIn;
					AlrmHi=AlrmHiIn;
						}	    
					    else if (DisabReq==1 && EnabReq==0) {
					    	AlrmLo=2;
							AlrmHi=2;
					    }	
		    flag[0]=AlrmLo;
		    flag[1]=AlrmHi;	    
			return flag;		
	}
}

