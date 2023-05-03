public class BankAccount {
    private String code;
    private Double balance;
    private String name;
    private Boolean goldAccount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGoldAccount() {
        return goldAccount;
    }

    public void setGoldAccount(Boolean goldAccount) {
        this.goldAccount = goldAccount;
    }

    public void withdraw(Double amount) {
        if (amount > this.balance) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.balance -= amount;
    }

    public Double deposit(Double amount) {
        this.balance += amount;

        if ( this.balance >= 100000) {
            this.goldAccount = true;
        }

        return this.balance;
    }
}
