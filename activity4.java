package activity4;

import java.util.Scanner;

public class activity4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 18) {
            System.out.println("Minor");
        } else if (age >= 18 && age <= 59) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior");
        }

        scanner.close();
    }
}

	
