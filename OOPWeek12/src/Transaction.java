public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    private String getTransactionTypeString(int type) {
        if (type == TYPE_DEPOSIT_CHECKING) {
            return "Nạp tiền vãng lai";
        } else if (type == TYPE_WITHDRAW_CHECKING) {
            return "Rút tiền vãng lai";
        } else if (type == TYPE_DEPOSIT_SAVINGS) {
            return "Nạp tiền tiết kiệm";
        } else {
            return "Rút tiền tiết kiệm";
        }
    }

    /**
     * get transaction info.
     * @return transaction info
     */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: "
                + getTransactionTypeString(type)
                + ". Số dư ban đầu: $"
                + String.format("%.2f", initialBalance)
                + ". Số tiền: $"
                + String.format("%.2f", amount)
                + ". Số dư cuối: $"
                + String.format("%.2f", finalBalance)
                + '.';
    }
}
