package group3.demonGame;

public class Time {
	private long start;
	private long currentTime;
	
	public Time() {
		start = System.nanoTime();		
	}

	public long getStartTime() {
		return start;
	}
	public long getCurrentTime() {
		return currentTime;
	}

	public long elaspsedTime(long time) {
		return time - start;
	}
	
	public String stringTime(long time){
		StringBuilder timeString = new StringBuilder();
		int seconds = (int) Math.floor(time / 1000000000);
		int minutes = (int) Math.floor(seconds / 60);
		
		timeString.append(minutes);
		timeString.append(":");
		timeString.append(seconds);
		
		return timeString.toString();
		
	}
	
//	public void pauseTime() {
//		
//	}
}
