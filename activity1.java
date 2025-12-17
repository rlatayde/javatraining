package Inputname;
import java.util.Scanner;
public class Inputname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Scanner scanner = new Scanner(System.in);

        // Ask for the user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Output greeting
        System.out.println("Hello, " + name + "!");

        scanner.close();

	}

}
