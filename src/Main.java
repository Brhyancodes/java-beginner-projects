import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Variables
        double income;
        double expenses;
        double itemPrice;
        double remainingMoney;

        // Scanner object
        Scanner scanner = new Scanner(System.in);

        // Get income
        System.out.print("Enter your monthly income: ");
        income = scanner.nextDouble();

        // Get expenses
        System.out.print("Enter your monthly expenses: ");
        expenses = scanner.nextDouble();

        // Get item price
        System.out.print("Enter the price of the item: ");
        itemPrice = scanner.nextDouble();

        // Calculate remaining money
        remainingMoney = income - expenses;
        if (remainingMoney >= itemPrice) {
            System.out.println("You can afford the item.");
        } else {
            System.out.println("You cannot afford the item.");
        }

        // Display remaining money
        System.out.println("Money remaining: " + remainingMoney);
    }
}