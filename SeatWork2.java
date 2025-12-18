package seatwork2;

public class SeatWork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	whiteboard wb = new whiteboard();
	Person person = new Person();
	person.setName("Rowell");
	int sum = wb.addNumbers(5, 3);
	
	System.out.println("The total is: " + String.valueOf(sum));
	System.out.println("Name: " + person.getName());
		}
}
