
import java.util.ArrayList;

public class Tour {
	private int name;
	private ArrayList<Time> timeList = new ArrayList<Time>();
	
	public Tour(int name, ArrayList<Time> timeList) {
		this.name = name;
		this.timeList = timeList;
	}
	
	public int getName() {
		return name;
	}
	
	public ArrayList<Time> getTimeList(){
		return timeList;
	}
	
	public int findTime(int num) {
		return timeList.get(num).getTime();
	}
	
	public Boolean stopAt(int num) {
		if(timeList.get(num).getTime() != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean canTake(int num, int time) {
		if(timeList.get(num).getTime() >= time) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean canArrive(int num, int time) {
		if(timeList.get(num).getTime() <= time) {
			return true;
		}else {
			return false;
		}
	}
}
