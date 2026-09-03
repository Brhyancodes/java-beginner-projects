import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Calculate average marks of 5 subjects
        double sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            double marks = scanner.nextDouble();

            sum += marks;
        }

        // Calculate average
        double average = sum / 5;

        // Display average
        System.out.println("Average marks: " + average);

        // Determine grade
        if (average >= 95) {
            System.out.println("Grade: A");
        } else if (average >= 85) {
            System.out.println("Grade: B");
        } else if (average >= 75) {
            System.out.println("Grade: C");
        } else if (average >= 65) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        scanner.close();
    }
}

