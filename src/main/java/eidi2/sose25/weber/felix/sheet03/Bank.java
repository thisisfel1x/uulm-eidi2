package eidi2.sose25.weber.felix.sheet03;

import java.util.ArrayList;
import java.util.Comparator;

public class Bank {
    private ArrayList<BankAccount> bankAccounts;

    public Bank() {
        this.bankAccounts = new ArrayList<>();
    }

    public int highestCustomerId() {
        int id = 0;
        for (BankAccount bankAccount : bankAccounts) {
            int currentCustomerId = bankAccount.getCustomerID();
            if (currentCustomerId > id) {
                id = currentCustomerId;
            }
        }
        return id;
    }

    public int test() {
        int id = 0;
        for (int i = 0; i < bankAccounts.size(); i++) {
            BankAccount bankAccount = bankAccounts.get(i);
            int currentCustomerId = bankAccount.getCustomerID();
            if (currentCustomerId > id) {
                id = currentCustomerId;
            }
        }
        return id;
    }

    public int getHighestCustomerId() {
        return this.bankAccounts.stream()
                .max(Comparator.comparingInt(BankAccount::getCustomerID))
                .map(BankAccount::getCustomerID)
                .orElse(-1);
    }

    public int createUniqueCustomerId() {
        return getHighestCustomerId() + 1;
    }

    public Customer openBankAccount() {
        int newId = createUniqueCustomerId();
        Customer newCustomer = new Customer(newId);
        BankAccount newAccount = new BankAccount(newCustomer);
        bankAccounts.add(newAccount);
        return newCustomer;
    }

    public BankAccount findBankAccountForCustomer(Customer customer) {
        for (BankAccount account : bankAccounts) {
            if (account.getCustomerID() == customer.getId()) {
                return account;
            }
        }
        return null;
    }

    public boolean internalMoneyTransfer(Customer from, Customer to, double amount) {
        BankAccount fromAccount = findBankAccountForCustomer(from);
        BankAccount toAccount = findBankAccountForCustomer(to);

        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdrawMoney(amount);
            toAccount.addBalance(amount);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankAccounts=" + bankAccounts +
                '}';
    }
}
