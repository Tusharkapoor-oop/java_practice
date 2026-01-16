import java.util.Scanner;
public class Account {
    // Attributes
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;
    private static int nextAccountNumber = 1001; // To generate unique account numbers
    
    // Constructor
    public Account(String accountHolderName, double initialDeposit, String email, String phoneNumber) {
        this.accountNumber = nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    
    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Current balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("New balance: $" + balance);
        }
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("----------------------");
    }
    
    // Method to update contact details
    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully!");
    }
    
    // Getter method for account number (needed for searching)
    public int getAccountNumber() {
        return accountNumber;
    }
}
import java.util.Scanner;

public class UserInterface {
    // Attributes
    private Account[] accounts; // Array to store accounts
    private int accountCount; // Keep track of how many accounts we have
    private Scanner scanner;
    private final int MAX_ACCOUNTS = 100; // Maximum number of accounts
    
    // Constructor
    public UserInterface() {
        accounts = new Account[MAX_ACCOUNTS];
        accountCount = 0;
        scanner = new Scanner(System.in);
    }
    
    // Method to create a new account
    public void createAccount() {
        System.out.println("\n--- Create New Account ---");
        
        // Check if we can create more accounts
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Cannot create more accounts. Maximum limit reached!");
            return;
        }
        
        // Get account details from user
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline
        
        // Validate initial deposit
        if (initialDeposit < 0) {
            System.out.println("Initial deposit must be positive!");
            return;
        }
        
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        
        // Create new account and add to array
        Account newAccount = new Account(name, initialDeposit, email, phoneNumber);
        accounts[accountCount] = newAccount;
        accountCount++;
        
        System.out.println("Account created successfully with Account Number: " + 
                          newAccount.getAccountNumber());
    }
    
    // Method to find an account by account number
    private Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null; // Account not found
    }
    
    // Method to perform deposit
    public void performDeposit() {
        System.out.println("\n--- Deposit Money ---");
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        
        account.deposit(amount);
    }
    
    // Method to perform withdrawal
    public void performWithdrawal() {
        System.out.println("\n--- Withdraw Money ---");
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        account.withdraw(amount);
    }
    
    // Method to show account details
    public void showAccountDetails() {
        System.out.println("\n--- View Account Details ---");
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        account.displayAccountDetails();
    }
    
    // Method to update contact details
    public void updateContact() {
        System.out.println("\n--- Update Contact Details ---");
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the newline
        
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter new email address: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        
        account.updateContactDetails(email, phoneNumber);
    }
    
    // Main menu method
    public void mainMenu() {
        int choice;
        
        do {
            // Display menu options
            System.out.println("\n=== Welcome to the Banking Application! ===");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline
            
            // Handle user choice using switch statement
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    System.out.println("Thank you for using Banking Application!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6); // Keep running until user chooses to exit
        
        scanner.close(); // Close the scanner
    }
}
public class BankingApplication {
    public static void main(String[] args) {
        // Create UserInterface object and start the application
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}