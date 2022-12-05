

import java.util.ArrayList;
import java.util.Scanner;

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TourList tourList = new TourList();
		TourList2 tourList2 = new TourList2();
		Scanner in = new Scanner(System.in); 
		System.out.println("請選擇北上或南下：");
		String bound = in.next();
		System.out.println("請輸入起始站：");
		String start = in.next();
		System.out.println("請輸入終點站：");
		String goal = in.next();
		System.out.println("請輸入出發時間：");
		int startTime = in.nextInt();
		System.out.println("請輸入到達時間：");
		int goalTime = in.nextInt();
		
		switch(bound) {
		 case "南下":
			System.out.printf("從%s到%s符合的班次有:\n",start, goal);
			for (String match : tourList.getMatch(start, goal, startTime, goalTime)) {
				System.out.print(match);
				}
			break;
			case "北上":
			System.out.printf("從%s到%s符合的班次有:\n",start, goal);
			for (String match2 : tourList2.getMatch2(goal, start, startTime, goalTime)) {
				System.out.print(match2);
		}
			break;
			
		}
	}

}
