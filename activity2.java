package Inputparse;
import java.util.Scanner;
public class Inputparse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Age: ");
        String Age = scanner.nextLine();
        
        int AgeInt = Integer.parseInt(Age);
        
        Double AgeDouble = (double) AgeInt;
        
        System.out.println("Your age as int: " + AgeInt);
        System.out.println("Your age as double: " + AgeDouble);
                
	}

}