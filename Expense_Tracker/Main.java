
public class Main {

    public static void main(String[] args) {

        Expense expense1 =
                new Expense("Lunch", 400, "Food");

        Expense expense2 =
                new Expense("Bus fare", 250, "Transport");

        expense1.displayExpense();

        System.out.println();

        expense2.displayExpense();
    }
}
