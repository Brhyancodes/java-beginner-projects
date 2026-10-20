public abstract class Expense {
    // Static member to auto-increment unique IDs across all instances
    private static int idCounter = 1;

    // Encapsulated instance variables
    private final int id;
    private String title;
    private double amount;
    private ExpenseCategory category;

    // Constructor using 'this'
    public Expense(String title, double amount, ExpenseCategory category) {
        this.id = idCounter++;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }

    // Abstract method (Abstraction & Polymorphism)
    public abstract String getSummary();

    // Getters and Setters (Encapsulation)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        }
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public static int getTotalExpensesCreated() {
        return idCounter - 1;
    }
}