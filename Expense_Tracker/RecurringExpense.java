public class RecurringExpense extends Expense {
    private String frequency; // e.g., "Monthly", "Weekly"

    public RecurringExpense(String title, double amount, ExpenseCategory category, String frequency) {
        super(title, amount, category);
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }

    @Override
    public String getSummary() {
        return String.format("[ID: %d] Recurring (%s): %s | Amount: $%.2f | Category: %s",
                getId(), frequency, getTitle(), getAmount(), getCategory().getDisplayName());
    }
}