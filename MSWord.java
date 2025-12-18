package M2_activity5;



public class MSWord extends Program {
	
	public MSWord(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		String message = "Opening MS Word...";
		this.setRunning(true);
		System.out.println(message);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Word...";
		this.setRunning(false);
		System.out.println(message);
	}
}