package com.controller.sweng894;

public class ComAuxStatus {
// Check if all shutdown-triggers are cleared if so reset the overall shutdown trip word else set the overall word
	public static int AuxSysTrip(int auxtrp01In, int auxtrp02In, int auxtrp03In, int auxtrp11In, int auxtrp12In,
			int auxtrp21In, int auxtrp22In, int auxtrp31In, int auxtrp32In, int auxtrp41In, int auxtrp42In) {

		int auxtrp01 = auxtrp01In;
		int auxtrp02 = auxtrp02In;
		int auxtrp03 = auxtrp03In;
		int auxtrp11 = auxtrp11In;
		int auxtrp12 = auxtrp12In;
		int auxtrp21 = auxtrp21In;
		int auxtrp22 = auxtrp22In;
		int auxtrp31 = auxtrp31In;
		int auxtrp32 = auxtrp32In;
		int auxtrp41 = auxtrp41In;
		int auxtrp42 = auxtrp42In;

		int auxShutdwnoverall = 0;

// Iterate each input supplied by the compressor controller to determine if a trip is present 1= trip, 0= clear 
		int[] input_trip = new int[] { auxtrp01, auxtrp02, auxtrp03, auxtrp11, auxtrp12, auxtrp21, auxtrp22, auxtrp31,
				auxtrp32, auxtrp41, auxtrp42 };

		for (int i = 0; i <= input_trip.length; i++) {
			if (i <= 10) {
				if (input_trip[i] == 1) {
					auxShutdwnoverall = 1;
					System.out.println("system trip found" + "" + i + "" + input_trip[i]);
					if (auxShutdwnoverall != 0) {
						return auxShutdwnoverall;
					}
				} else if (input_trip[i] == 0) {
					auxShutdwnoverall = input_trip[i];
					System.out.println("system trip found" + "" + i + "" + input_trip[i]);
				}	
			}
		}
		
		return auxShutdwnoverall;
	}
// Check if every  permissive-trigger are cleared if so set the overall permissive word else reset the overall word
	public static int AuxSysPermiss(int auxperm01In, int auxperm02In, int auxperm03In) {
		int auxperm01 = auxperm01In;
		int auxperm02 = auxperm02In;
		int auxperm03 = auxperm03In;
		int auxpermoverall = 0;

// Iterate each input supplied by the compressor controller to determine if a trip is present 1= trip, 0= clear 
		int[] input_perm = new int[] { auxperm01, auxperm02, auxperm03 };

		for (int i = 0; i <= input_perm.length; i++) {
			if (i <= 2) {
				if (input_perm[i] == 1) {
					auxpermoverall = input_perm[i];
					System.out.println("system permissive granted" + " " + i + " " + input_perm[i]);
				} else if (input_perm[i] != 1) {

					auxpermoverall = input_perm[i];
					System.out.println("system permissive not granted" + " " + i + " " + input_perm[i]);
				}
			}
			if (auxpermoverall != 1) {
				return auxpermoverall;
			}
		}
		return auxpermoverall;
	}
}
