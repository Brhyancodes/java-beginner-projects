public class OneTimeExpense extends Expense {
    private String merchant;

    public OneTimeExpense(String title, double amount, ExpenseCategory category, String merchant) {
        super(title, amount, category);
        this.merchant = merchant;
    }

    public String getMerchant() {
        return merchant;
    }

    @Override
    public String getSummary() {
        return String.format("[ID: %d] One-Time: %s | Amount: $%.2f | Category: %s | Merchant: %s",
                getId(), getTitle(), getAmount(), getCategory().getDisplayName(), merchant);
    }
}