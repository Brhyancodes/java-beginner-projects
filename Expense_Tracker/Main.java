import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ExpenseManager manager = new ExpenseManager();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("   Hey!😊Welcome to our Expense Tracker App    ");
        System.out.println("=========================================");

        while (running) {
            printMenu();
            int choice = readIntInput("Select an option: ");

            switch (choice) {
                case 1 -> addOneTimeExpense();
                case 2 -> addRecurringExpense();
                case 3 -> manager.printSummaryReport();
                case 4 -> filterExpensesByCategory();
                case 5 -> {
                    System.out.println("\nThank you for using Expense Tracker. Goodbye!");
                    running = false;
                }
                default -> System.out.println("⚠️ Invalid option. Please choose between 1 and 5.\n");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Add One-Time Expense");
        System.out.println("2. Add Recurring Expense");
        System.out.println("3. View Expense Summary Report");
        System.out.println("4. Filter Expenses by Category");
        System.out.println("5. Exit");
    }

    private static void addOneTimeExpense() {
        System.out.println("\n--- Add One-Time Expense ---");
        String title = readStringInput("Enter expense title: ");
        double amount = readDoubleInput("Enter amount ($): ");
        ExpenseCategory category = selectCategory();
        String merchant = readStringInput("Enter merchant name: ");

        Expense expense = new OneTimeExpense(title, amount, category, merchant);
        manager.addExpense(expense);
        System.out.println("✅ One-Time Expense successfully added!");
    }

    private static void addRecurringExpense() {
        System.out.println("\n--- Add Recurring Expense ---");
        String title = readStringInput("Enter expense title: ");
        double amount = readDoubleInput("Enter amount ($): ");
        ExpenseCategory category = selectCategory();
        String frequency = readStringInput("Enter frequency (e.g., Monthly, Weekly, Yearly): ");

        Expense expense = new RecurringExpense(title, amount, category, frequency);
        manager.addExpense(expense);
        System.out.println("✅ Recurring Expense successfully added!");
    }

    private static void filterExpensesByCategory() {
        System.out.println("\n--- Filter by Category ---");
        ExpenseCategory category = selectCategory();
        manager.filterByCategory(category);
    }

    private static ExpenseCategory selectCategory() {
        System.out.println("Select Category:");
        ExpenseCategory[] categories = ExpenseCategory.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%d. %s\n", i + 1, categories[i].getDisplayName());
        }

        int choice = -1;
        while (choice < 1 || choice > categories.length) {
            choice = readIntInput("Choose category (1-" + categories.length + "): ");
            if (choice < 1 || choice > categories.length) {
                System.out.println("⚠️ Invalid selection. Try again.");
            }
        }
        return categories[choice - 1];
    }

    // Helper methods for robust console input handling
    private static String readStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("⚠️ Amount cannot be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a valid decimal number.");
            }
        }
    }
}