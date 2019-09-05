package demo;

public class RoutingWorld {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vehicleNumber = 1; // total number of vehicles working in the world
		int locationNumber = 16; // the total number of locations in the world
		int [][] world = new int [913][641];
		int depot = world[456][320];
		int l1 = world[228][0];
		int l2 = world[912][0];
		int l3 = world[0][80];
		int l4 = world[114][80];
		int l5 = world[570][160];
		int l6 = world[798][160];
		int l7 = world[342][240];
		int l8 = world[684][240];
		int l9 = world[570][400];
		int l10 = world[912][400];
		int l11= world[114][480];
		int l12= world[228][480];
		int l13= world[342][560];
		int l14= world[684][560];
		int l15= world[0][640];
		int l16= world[798][640];
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
		System.out.println(l2);
		/*for (int i =0; i<913; i++) {
			for(int j = 0; j<641; j++) {
				if(world[i][j]==l1) {
					System.out.print("|x|");
					
				}
				else {
					System.out.print("|_| ");
				}
				
			}
			System.out.println("");
		}
		*/
		 /*final int transitCallbackIndex =
			        routing.registerTransitCallback((long fromIndex, long toIndex) -> {
			          // Convert from routing variable Index to user NodeIndex.
			          int fromNode = manager.indexToNode(fromIndex);
			          int toNode = manager.indexToNode(toIndex);
			          return data.distanceMatrix[fromNode][toNode];
			        });
			    routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);*/
		
				
}
}
