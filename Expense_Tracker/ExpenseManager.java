import java.util.ArrayList;
import java.util.List;

public class ExpenseManager implements Reportable {
    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Added: " + expense.getTitle());
    }

    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    @Override
    public void printSummaryReport() {
        System.out.println("\n========== EXPENSE REPORT ==========");
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        // Polymorphism in action: calling getSummary() on abstract Expense type
        for (Expense expense : expenses) {
            System.out.println(expense.getSummary());
        }

        System.out.println("------------------------------------");
        System.out.printf("Total Spent: $%.2f\n", calculateTotal());
        System.out.println("Total Tracked Items: " + Expense.getTotalExpensesCreated());
        System.out.println("====================================\n");
    }

    public void filterByCategory(ExpenseCategory category) {
        System.out.println("\n--- Filtering by: " + category.getDisplayName() + " ---");
        for (Expense expense : expenses) {
            if (expense.getCategory() == category) {
                System.out.println(expense.getSummary());
            }
        }
    }
}