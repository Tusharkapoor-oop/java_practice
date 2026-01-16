import java.util.*;
abstract class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accno, double bal) {
        accountNumber = accno;
        balance = bal;
    }
    public abstract void calculateInterest();
    public double displayBalance() {
        System.out.println(balance +" of account number "+ accountNumber);
        return balance;
    }

};
class savingaccount extends BankAccount{
    double balance;
    public savingaccount(String accno, double bal) {
        super(accno, bal);
        balance=bal;
    }
    public void  calculateInterest(){
        double result= balance*0.04;
        balance=balance+result;
        System.out.println( "interest of savings account is "+ result);
    }
     public double displayBalance() {
        System.out.println("Savings Account Balance: "+ balance+ " Interest: " +" of account number "+ accountNumber);
        return balance;
     }

};
class currentaccount extends BankAccount{
    double balance;
    public currentaccount(String accno, double bal) {
        super(accno, bal);
        balance=bal;
    }
    public void  calculateInterest(){
        double result= balance*0.03;
        balance=balance+result;
        System.out.println( "interest of current account is "+ result);
    }
    public double displayBalance() {
        System.out.println("Current Account Balance: "+ balance+ "  of account number "+ accountNumber);
        return balance;
    }

};
public class Bankaccountmethod {
    public static void main(String args[]){
        //savingaccount sa
        //currentaccount ca
        BankAccount sa;
        BankAccount ca;
        sa=new savingaccount("sa1011", 1000000);
        ca=new currentaccount("ca1011", 1000000);
        sa.calculateInterest();
        ca.calculateInterest();
        System.out.println(sa.displayBalance());
        System.out.println(ca.displayBalance());
    }
}
