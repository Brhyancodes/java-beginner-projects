import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your savings goal amount: ");
        double savingsGoal = scanner.nextDouble();
        System.out.print("Enter your monthly savings amount: ");
        double monthlySavings = scanner.nextDouble();
        double monthsRequired = savingsGoal / monthlySavings;
        System.out.printf("You will reach your savings goal in %.2f months.%n", monthsRequired);
        scanner.close();
    }
}