import java.util.Scanner;

// class to represent a bank account
public class Account {
    private int accountNo;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNo;

    // constructor
    public Account(int accNo, String name, double bal, String mail, String phone) {
        this.accountNo = accNo;
        this.accountHolderName = name;
        this.balance = bal;
        this.email = mail;
        this.phoneNo = phone;
    }

    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited Rs " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Rs " + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance!");
        }
    }

    // show account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNo);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: Rs " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNo);
    }

    // update email and phone
    public void updateContactDetails(String mail, String phone) {
        this.email = mail;
        this.phoneNo = phone;
        System.out.println("Contact details updated!");
    }

    public int getAccountNo() {
        return accountNo;
    }

    // 🔹 Inner class for menu system
    static class BankApp {
        private Account[] accounts = new Account[200];
        private int count = 0;
        private Scanner sc = new Scanner(System.in);

        // create account
        public void createAccount() {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter initial deposit: ");
            double bal = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter email: ");
            String mail = sc.nextLine();

            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            int accNo = 1000 + count + 1;
            accounts[count] = new Account(accNo, name, bal, mail, phone);
            count++;

            System.out.println("Account created! Your A/C No: " + accNo);
        }

        private Account findAccount(int accNo) {
            for (int i = 0; i < count; i++) {
                if (accounts[i].getAccountNo() == accNo) {
                    return accounts[i];
                }
            }
            return null;
        }

        public void deposit() {
            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();
            Account acc = findAccount(accNo);
            if (acc != null) {
                System.out.print("Enter deposit amount: ");
                double amt = sc.nextDouble();
                acc.deposit(amt);
            } else {
                System.out.println("Account not found!");
            }
        }

        public void withdraw() {
            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();
            Account acc = findAccount(accNo);
            if (acc != null) {
                System.out.print("Enter withdrawal amount: ");
                double amt = sc.nextDouble();
                acc.withdraw(amt);
            } else {
                System.out.println("Account not found!");
            }
        }

        public void showAccount() {
            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();
            Account acc = findAccount(accNo);
            if (acc != null) {
                acc.displayAccountDetails();
            } else {
                System.out.println("Account not found!");
            }
        }

        public void updateContact() {
            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();
            sc.nextLine();
            Account acc = findAccount(accNo);
            if (acc != null) {
                System.out.print("Enter new email: ");
                String mail = sc.nextLine();
                System.out.print("Enter new phone: ");
                String phone = sc.nextLine();
                acc.updateContactDetails(mail, phone);
            } else {
                System.out.println("Account not found!");
            }
        }

        public void mainMenu() {
            while (true) {
                System.out.println("\n--- Banking Menu ---");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Account Details");
                System.out.println("5. Update Contact");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine();

                if (ch == 1) createAccount();
                else if (ch == 2) deposit();
                else if (ch == 3) withdraw();
                else if (ch == 4) showAccount();
                else if (ch == 5) updateContact();
                else if (ch == 6) {
                    System.out.println("Exiting... Bye!");
                    return;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        }
    }

    // main inside Account class
 public static void main(String[] args) {
        BankApp app = new BankApp();
        app.mainMenu();
    }
}



