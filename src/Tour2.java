import java.util.ArrayList;
public class Tour2 {

	private int name;
	private ArrayList<Time> timeList2 = new ArrayList<Time>();
	
	public Tour2(int name, ArrayList<Time> timeList) {
		this.name = name;
		this.timeList2 = timeList;
	}
	
	public int getName() {
		return name;
	}
	
	public ArrayList<Time> getTimeList2(){
		return timeList2;
	}
	
	public int findTime(int num) {
		return timeList2.get(num).getTime();
	}
	
	public Boolean stopAt(int num) {
		if(timeList2.get(num).getTime() != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean canTake(int num, int time) {
		if(timeList2.get(num).getTime() <= time) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean canArrive(int num, int time) {
		if(timeList2.get(num).getTime() >= time) {
			return true;
		}else {
			return false;
		}
	}
}


