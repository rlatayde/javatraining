package M2_activity5;

public class MSExcel extends Program {
	
	public MSExcel(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		String message = "Opening MS Excel...";
		this.setRunning(true);
   		System.out.println(message);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Excel...";
		this.setRunning(false);
  		System.out.println(message);
	}
}