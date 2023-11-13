package ATM;

import java.util.Scanner; //Scanner class provides various methods for reading user input.
//java.util package contains classes,interfaces etc.

class UserBankAccount { // Creating UserBankAccount class
    private double balance;

    public UserBankAccount(double initialBalance) {
        // this keyword in java is used to refer to the current object within an
        // instance or constructor
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance; // Returns the balance amount left.
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

class ATM {
    private UserBankAccount userAccount;

    public ATM(UserBankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Deposit the Amount");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                withdraw(scanner);
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Please collect your money and card.");
        } else {
            System.out.println("Withdrawal failed. Please check your balance.");
        }
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }
}

public class ATMSystem { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the user's bank account with an initial balance
        UserBankAccount userAccount = new UserBankAccount(1000.0);

        // Create an ATM instance and connect it to the user's bank account
        ATM atm = new ATM(userAccount);

        // Main loop for the ATM interface
        while (true) { // Infinite loop it keeps running untill it gets terminated
            atm.displayMenu(); // displayMenu method used to display the menu to the user
            System.out.print("Enter your choice (1-4): ");
            int option = scanner.nextInt();

            // Process the user's choice
            atm.processOption(option, scanner);
        }
    }
}
