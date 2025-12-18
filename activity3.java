package activity3;


import java.util.Scanner;

public class activity3 {
	//sum
    public static int computeSum(int a, int b) {
        return a + b; // + 
    }

    //diff
    public static int computeDiff(int a, int b) {
        return a - b; // -
    }

    // product
    public static int computeProd(int a, int b) {
        return a * b; // *
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input 2 num
        System.out.print("Enter first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = scanner.nextInt();

        // Compute methods
        int sum = computeSum(num1, num2);
        int diff = computeDiff(num1, num2);
        int prod = computeProd(num1, num2);

        System.out.println("\nSum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + prod);

        scanner.close();
    }
}

