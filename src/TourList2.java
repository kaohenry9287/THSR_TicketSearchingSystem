import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class TourList2 {
	

	
		private ArrayList<String> stationList2 = new ArrayList<String>();
		private String[] list2 = { "Zuoying", "Tainan", "Chiayi", "Yunlin", "Changhua", "Taichung", "Miaoli", "Hsinchu",
				"Taoyuan", "Banqiao", "Taipei", "Ｎangang" };
		private ArrayList<Tour> tourList2 = new ArrayList<Tour>();
	
		public TourList2() {
			try {
				for (String station : list2) {
					stationList2.add(station);
				}
				File file2 = new File("northtime.txt");
				Scanner reader2 = new Scanner(file2);
				String notuse2 = reader2.nextLine();

				while (reader2.hasNextInt()) {
					int tourNum2 = reader2.nextInt();
					ArrayList<Time> timeList2 = new ArrayList<Time>();
					for (int i = 0; i <12; i++) {
						String stationName2 = stationList2.get(i);
						int time2 = reader2.nextInt();
						Time t2 = new Time(stationName2, time2);
						timeList2.add(t2);
					}
					Tour tour2 = new Tour(tourNum2, timeList2);
					tourList2.add(tour2);
				}

				reader2.close();

			} catch (FileNotFoundException e2) {
				System.out.println("File cannot found");
			} catch (NumberFormatException ex2) {
				ex2.printStackTrace();
			}
		}

		
		
		
		public int getStationNum(String name) {
			return stationList2.indexOf(name);
		}
		
		public ArrayList<String> getMatch2(String start, String goal ,int startTime, int goalTime) {
			int startNum2 = getStationNum(start);
			int goalNum2 = getStationNum(goal);
			ArrayList<String> matchList = new ArrayList<String>();
			for (Tour tour2 : tourList2) {
				if(tour2.stopAt(startNum2) && tour2.stopAt(goalNum2)) {
					if (tour2.canTake(startNum2, startTime) && tour2.canArrive(goalNum2, goalTime) ) {
						String result = String.format("%d班次 :%d發車%d抵達\n", tour2.getName(), 
								tour2.findTime(startNum2), tour2.findTime(goalNum2));
						matchList.add(result);
					}
				}
			}
			return matchList;
		}
		
		
	}


