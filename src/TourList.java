import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TourList {
	private ArrayList<String> stationList = new ArrayList<String>();
	private String[] list = { "Nangang", "Taipei", "Banqiao", "Taoyuan", "Hsinchu", "Miaoli", "Taichung", "Changhua",
			"Yunlin", "Chiayi", "Tainan", "Zuoying" };
	private ArrayList<Tour> tourList = new ArrayList<Tour>();
	
	
	public TourList() {
		try {
			for (String station : list) {
				stationList.add(station);
			}
			File file = new File("southtime2.txt");
			Scanner reader = new Scanner(file);
			String notuse = reader.nextLine();

			while (reader.hasNextInt()) {
				int tourNum = reader.nextInt();
				ArrayList<Time> timeList = new ArrayList<Time>();
				for (int i = 0; i < 12; i++) {
					String stationName = stationList.get(i);
					int time = reader.nextInt();
//					System.out.println(time);
					Time t = new Time(stationName, time);
					timeList.add(t);
				}
//				System.out.println(timeList);
				Tour tour = new Tour(tourNum, timeList);
				tourList.add(tour);
//				System.out.println(tour.getTimeList());
			}

//			System.out.println(tourList.get(1).getTimeList().get(2).getTime());
			reader.close();

		} catch (FileNotFoundException e1) {
			System.out.println("File cannot found");
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}
	
	public int getStationNum(String name) {
		return stationList.indexOf(name);
	}
	
	public ArrayList<String> getMatch(String start, String goal ,int startTime, int goalTime) {
		int startNum = getStationNum(start);
		int goalNum = getStationNum(goal);
		ArrayList<String> matchList = new ArrayList<String>();
		for (Tour tour : tourList) {
			if(tour.stopAt(startNum) && tour.stopAt(goalNum)) {
				if (tour.canTake(startNum, startTime) && tour.canArrive(goalNum, goalTime) ) {
					String result = String.format("%d班次 :%d發車%d抵達\n", tour.getName(), 
							tour.findTime(startNum), tour.findTime(goalNum));
					matchList.add(result);
				}
			}
		}
		return matchList;
	}
	
	
}
