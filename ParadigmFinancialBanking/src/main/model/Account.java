public class Account {
    private int accountId;
    private int customerId;
    private String accountType;
    private int balance;

    public Account(int accountId, int customerId, String accountType, int balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    } 

    //getters
    public int getAccountId() {
        return accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountType(){
        return accountType;
    }

    public int getBalance() {
        return balance;
    }

    //setters
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
