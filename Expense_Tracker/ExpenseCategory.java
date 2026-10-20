public enum ExpenseCategory {
    FOOD("Food & Dining"),
    TRANSPORT("Transportation"),
    UTILITIES("Utilities & Bills"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other Expenses");

    private final String displayName;

    ExpenseCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}