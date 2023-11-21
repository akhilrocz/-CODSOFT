package ATM; //Package used to organize the code by grouping classes and interfaces

import java.util.*; //Imports all of the java package members
import java.util.Scanner; //Scanner class provides various methods for reading user input.
//java.util package contains classes,interfaces etc.

class UserBankAccount { // Creating UserBankAccount class
    private double balance;

    public UserBankAccount(double initialBalance) {
        // this keyword in java is used to refer to the current object within an
        // instance or constructor
        this.balance = initialBalance; // this object is used to refer to the current object
    }

    public double getBalance() {
        return balance; // Returns the balance amount left.
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Adds the amount to the existing balance amount
            System.out.println("Deposit successful. Updated balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Checks if the amount is in the range of 0 to balance amount
            balance -= amount; // the withdrawn amount is deducted from the existing amount
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

class ATM {
    private Map<Integer, UserBankAccount> userAccounts; // private map used to store user accounts
    private Scanner scanner; // private field "scanner" is decalred to read input from console

    public ATM(Map<Integer, UserBankAccount> userAccounts) {
        this.userAccounts = userAccounts;
        this.scanner = new Scanner(System.in); // The scanner variable is initialized with a new Scanner object that
                                               // reads input from the standard input stream (System.in).
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Deposit the Amount");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public int processOption(int option, Scanner scanner) {
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

                System.exit(0); // Succesful termination of program
                System.out.println("After exit the program wont be executed"); // This line wont be executed
            default:
                System.out.println("Invalid option. Please try again.");
                return -1;
        }
        return -1; // Abnoraml termination of program
    }

    private void withdraw(Scanner scanner) { // scanner object is passed as parameter
        try {
            System.out.print("Enter the Pin number: ");
            int customerNumber = scanner.nextInt();
            UserBankAccount userAccount = userAccounts.get(customerNumber); // retireves the customer number from the
                                                                            // userAccounts map

            if (userAccount != null) {
                System.out.print("Enter the amount to withdraw: $");
                double amount = scanner.nextDouble(); // Used to used double value from console

                // the if-else statement checks if the withdrwal is succesful or not
                if (userAccount.withdraw(amount)) {
                    System.out.println("Please collect your money and card.");
                } else {
                    System.out.println("Withdrawal failed. Please check your balance.");
                }
            } else {
                System.out.println("Customer number not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private void deposit(Scanner scanner) {
        try {
            System.out.print("Enter the pin number: ");
            int customerNumber = scanner.nextInt();
            UserBankAccount userAccount = userAccounts.get(customerNumber);

            if (userAccount != null) {
                System.out.print("Enter the amount to deposit: $");
                double amount = scanner.nextDouble();
                userAccount.deposit(amount);
            } else {
                System.out.println("Pin number not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private void checkBalance() {
        try {
            System.out.print("Enter the Pin number: ");
            int customerNumber = scanner.nextInt();

            // userAccounts Map is used to retrieve value associated with customerNumber key
            UserBankAccount userAccount = userAccounts.get(customerNumber);

            if (userAccount != null) { // Checks if the user account specified by user is null
                System.out.println("Current balance: $" + userAccount.getBalance());
            } else {
                System.out.println("Pin number not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner object is declared

        Map<Integer, UserBankAccount> userAccounts = new HashMap<>();

        // put() method is used to add new entries to "Map" object to updated the value
        // assocaited with that existing key
        userAccounts.put(123, new UserBankAccount(1000.0));
        userAccounts.put(456, new UserBankAccount(2000.0));

        ATM atm = new ATM(userAccounts);

        boolean running = true;
        do { // while loop runs inddefinitely
            atm.displayMenu(); // Displays a menu by calling the displayMenu()
            System.out.print("Enter your choice (1-4): ");

            // try-catch block is use dto hadle the case where user enters a invalid input
            try {
                int option = scanner.nextInt(); // Reads the user input using the nextInt() method of Scanner object
                                                // named scanner
                atm.processOption(option, scanner); // Displays the options that the user selects.

                // catch block prevents the progarm from crashing
            } catch (InputMismatchException e) { // catches the input mismatch exception and throws an error
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (running);
    }
}
