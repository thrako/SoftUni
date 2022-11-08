package lesson06_defining_classes.lab.N03BankAccount;

class BankAccount {
    private static int accountsCount = 0;
    private final int id;
    private double balance;
    public static double interestRate = 0.02;

    public BankAccount() {
        this.id = ++accountsCount;
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
       return this.balance * BankAccount.interestRate * years;
    }
}
