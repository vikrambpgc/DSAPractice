package com.vikrambpgc.DynamicProgramming;

public class PetrolPump {
	
	private static class PumpStation {
		int petrol;
		int nextDistance;
		
		public PumpStation(int x, int y) {
			this.petrol = x;
			this.nextDistance = y;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int startStationNumber;
		
		PumpStation[] stations = new PumpStation[4];
		stations[0] = new PumpStation(7, 5);
		stations[1] = new PumpStation(4, 6);
		stations[2] = new PumpStation(7, 3);
		stations[3] = new PumpStation(4, 9);
		
		startStationNumber = findStartStation(stations);
		if (startStationNumber == -1) {
			System.out.println("Not Possible");
			return;
		}
		System.out.println("Result:"+ "("+stations[startStationNumber].petrol + "," + stations[startStationNumber].nextDistance+")");
	}
	
	public static int findStartStation(PumpStation[] stations) {
		int start, end, currentPetrol;
		start = 0;
		end = 1;
		
		currentPetrol = stations[start].petrol - stations[start].nextDistance;
		
		while (end != start || currentPetrol < 0) {
			while (currentPetrol < 0) {
				currentPetrol = currentPetrol - stations[start].petrol + stations[start].nextDistance;
			    start = (start + 1) % stations.length;
			    if (start == 0) return -1;	
			}
			
			currentPetrol += stations[end].petrol - stations[end].nextDistance;
			end = (end + 1) % stations.length;
		}
		
		return start;
	}
}
