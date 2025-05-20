package eidi2.sose25.weber.felix.sheet03;

public class BankAccount {
    private double balance = 100;
    private Customer owner;

    public BankAccount(Customer owner) {
        this.owner = owner;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdrawMoney(double amount) {
        balance -= amount;
    }

    public int getCustomerID() {
        return this.owner.getId();
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", owner=" + owner +
                '}';
    }
}
