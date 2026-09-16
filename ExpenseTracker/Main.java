public class Main {
    public static void main(String[] args) {
        Expense expense = new Expense("Lunch", 200, "Food");
        System.out.println("Expense: " + expense.getName());
        System.out.println("Amount: " + expense.getAmount());
        System.out.println("Category: " + expense.getCategory());
    }
}