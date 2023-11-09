import java.util.Scanner;

class ATM {
    private String userId;
    private String userPin;
    private double balance;
    private TransactionHistory history;

    public ATM(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 1000.0; // Initial balance
        this.history = new TransactionHistory();
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void performOperation(int choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                history.displayTransactionHistory();
                break;
            case 2:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = input.nextDouble();
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    history.addTransaction("Withdraw", withdrawAmount);
                    System.out.println("Withdrawn $" + withdrawAmount);
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
            case 3:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = input.nextDouble();
                balance += depositAmount;
                history.addTransaction("Deposit", depositAmount);
                System.out.println("Deposited $" + depositAmount);
                break;
            case 4:
                System.out.print("Enter the recipient's user ID: ");
                String recipientUserId = input.next();
                System.out.print("Enter the amount to transfer: ");
                double transferAmount = input.nextDouble();
                if (transferAmount <= balance) {
                    balance -= transferAmount;
                    history.addTransaction("Transfer to " + recipientUserId, transferAmount);
                    System.out.println("Transferred $" + transferAmount + " to " + recipientUserId);
                } else {
                    System.out.println("Insufficient balance.");
                }
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your user ID: ");
        String inputUserId = input.next();
        System.out.print("Enter your user PIN: ");
        String inputUserPin = input.next();

        if (userId.equals(inputUserId) && userPin.equals(inputUserPin)) {
            int choice;
            while (true) {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                performOperation(choice);
            }
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
        }
    }
}

class TransactionHistory {
    private String[] transactions;
    private int count;

    public TransactionHistory() {
        transactions = new String[100];
        count = 0;
    }

    public void addTransaction(String transactionType, double amount) {
        transactions[count++] = transactionType + ": $" + amount;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < count; i++) {
            System.out.println(transactions[i]);
        }
    }
}

public class ATMMain {
    public static void main(String[] args) {
        ATM atm = new ATM("user123", "1234");
        atm.start();
    }
}
