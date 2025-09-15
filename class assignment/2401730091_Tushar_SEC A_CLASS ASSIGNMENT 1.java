import java.util.Scanner;

class Account {
    // attributes
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    // constructor
    public Account(int accNo, String name, double bal, String mail, String phone) {
        this.accountNumber = accNo;
        this.accountHolderName = name;
        this.balance = bal;
        this.email = mail;
        this.phoneNumber = phone;
    }

    // deposit money into account
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited Rs " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // withdraw money from account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Rs " + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance!");
        }
    }

    // display account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: Rs " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    // update email and phone
    public void updateContactDetails(String mail, String phone) {
        this.email = mail;
        this.phoneNumber = phone;
        System.out.println("Contact details updated!");
    }

    // getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }
}

// ----------- User Interface Class ------------
public class UserInterface {
    // array to store accounts
    private Account[] accounts = new Account[200];
    private int count = 0; // number of accounts created
    private Scanner sc = new Scanner(System.in);

    // method to create a new account
    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: ");
        double bal = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter email: ");
        String mail = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        // generate account number
        int accNo = 1000 + count + 1;
        accounts[count] = new Account(accNo, name, bal, mail, phone);
        count++;

        System.out.println("Account created successfully! Your Account Number: " + accNo);
    }

    // helper method to find account by account number
    private Account findAccount(int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }
        return null; // not found
    }

    // method for deposit operation
    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter deposit amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // method for withdrawal operation
    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // method to show account details
    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    // method to update contact details
    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter new email: ");
            String mail = sc.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = sc.nextLine();
            acc.updateContactDetails(mail, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    // main menu method
    public void mainMenu() {
        while (true) {
            System.out.println("\n--- Banking Application Menu ---");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                performDeposit();
            } else if (choice == 3) {
                performWithdrawal();
            } else if (choice == 4) {
                showAccountDetails();
            } else if (choice == 5) {
                updateContact();
            } else if (choice == 6) {
                System.out.println("Thank you for using the Banking Application. Goodbye!");
                return;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // main method
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
