package RoutingAgents;

public class RoutingWorld {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int vehicleNumber = 1; // total number of vehicles working in the world
		int locationNumber = 16; // the total number of locations in the world
		int [][] world = new int [912][640];
		int []depot = new int[] {456,320}; // location of warehouse
		int []loc1 = new int[] {228,0}; // location 1
		int []loc2 = new int[] {912,0}; // location 2
		int []loc3 = new int[] {0,80}; // location 3
		int []loc4 = new int[] {114,80}; // location 4
		int []loc5 = new int[] {570,160}; // location 5
		int []loc6 = new int[] {798,160}; // location 6
		int []loc7 = new int[] {342,240}; // location 7
		int []loc8 = new int[] {684,240}; // location 8
		int []loc9 = new int[] {570,400}; // location 9
		int []loc10 = new int[] {912,400}; // location 10
		int []loc11 = new int[] {114,480}; // location 11
		int []loc12 = new int[] {228,480}; // location 12
		int []loc13 = new int[] {342,560}; // location 13
		int []loc14 = new int[] {684,560}; // location 14
		int []loc15 = new int[] {0,640}; // location 15
		int []loc16 = new int[] {798,640}; // location 16
		// TODO Auto-generated method stub
		final int [][] distanceMatrix = {
				// This is a multiple dimension array reflecting distances of each node from each node. The first row is the distance of everyone from the warehouse
		        {0, 548, 776, 696, 582, 274, 502, 194, 308, 194, 536, 502, 388, 354, 468, 776, 662},
		        {548, 0, 684, 308, 194, 502, 730, 354, 696, 742, 1084, 594, 480, 674, 1016, 868, 1210},
		        {776, 684, 0, 992, 878, 502, 274, 810, 468, 742, 400, 1278, 1164, 1130, 788, 1552, 754},
		        {696, 308, 992, 0, 114, 650, 878, 502, 844, 890, 1232, 514, 628, 822, 1164, 560, 1358},
		        {582, 194, 878, 114, 0, 536, 764, 388, 730, 776, 1118, 400, 514, 708, 1050, 674, 1244},
		        {274, 502, 502, 650, 536, 0, 228, 308, 194, 240, 582, 776, 662, 628, 514, 1050, 708},
		        {502, 730, 274, 878, 764, 228, 0, 536, 194, 468, 354, 1004, 890, 856, 514, 1278, 480},
		        {194, 354, 810, 502, 388, 308, 536, 0, 342, 388, 730, 468, 354, 320, 662, 742, 856},
		        {308, 696, 468, 844, 730, 194, 194, 342, 0, 274, 388, 810, 696, 662, 320, 1084, 514},
		        {194, 742, 742, 890, 776, 240, 468, 388, 274, 0, 342, 536, 422, 388, 274, 810, 468},
		        {536, 1084, 400, 1232, 1118, 582, 354, 730, 388, 342, 0, 878, 764, 730, 388, 1152, 354},
		        {502, 594, 1278, 514, 400, 776, 1004, 468, 810, 536, 878, 0, 114, 308, 650, 274, 844},
		        {388, 480, 1164, 628, 514, 662, 890, 354, 696, 422, 764, 114, 0, 194, 536, 388, 730},
		        {354, 674, 1130, 822, 708, 628, 856, 320, 662, 388, 730, 308, 194, 0, 342, 422, 536},
		        {468, 1016, 788, 1164, 1050, 514, 514, 662, 320, 274, 388, 650, 536, 342, 0, 764, 194},
		        {776, 868, 1552, 560, 674, 1050, 1278, 742, 1084, 810, 1152, 274, 388, 422, 764, 0, 798},
		        {662, 1210, 754, 1358, 1244, 708, 480, 856, 514, 468, 354, 844, 730, 536, 194, 798, 0},
		    
		

	};
		/*
		for (int i =0; i<913; i++) {
			for(int j = 0; j<641; j++) {
				//int []printer = new printer[]{i,j};
				System.out.print("|_| ");
			}
			System.out.println("");
		}
		*/
		System.out.println(distanceMatrix[0][16]);
				
}
}
