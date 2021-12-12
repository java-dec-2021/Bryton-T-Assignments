import java.util.Random;
import java.util.ArrayList;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String account;
    public static int numOfAccounts = 0;
    public static double totalReserve = 0;

    public BankAccount(double checkingParam, double savingsParam) {
        checkingBalance = checkingParam;
        savingsBalance = savingsParam;
        totalReserve += checkingParam + savingsParam;
        numOfAccounts ++;
        account = generateAccount();
    }

    public BankAccount(double checkingParam) {
        checkingBalance = checkingParam;
        totalReserve += checkingParam;
        numOfAccounts ++;
        account = generateAccount();
    }

    public BankAccount() {
        numOfAccounts ++;
        account = generateAccount();
    }

    private char getRandomLetter(){
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
        Random letterSel = new Random();
        int letterIndex = letterSel.nextInt(36);
        return letters[letterIndex];
    }

    private String generateAccount(){
        String account = "";
        for (int i = 0; i < 10; i++) {
            account += getRandomLetter();
        }
        return account;
    }
    
    public void depositChecking(double amountParam) {
        this.checkingBalance += amountParam;
        totalReserve += amountParam;
    }

    public void depositSavings(double amountParam) {
        this.savingsBalance += amountParam;
        totalReserve += amountParam;
    }

    public void withdrawChecking(double amountParam) {
        this.checkingBalance -= amountParam;
        totalReserve -= amountParam;
    }

    public void withdrawSavings(double amountParam) {
        this.savingsBalance -= amountParam;
        totalReserve -= amountParam;
    }

    public double getChecking() {
        return checkingBalance;
    }

    public double getSavings() {
        return savingsBalance;
    }

    public String getAccount() {
        return account;
    }


    public void checkBalance() {
        System.out.println("Account number: " + this.getAccount() + " - " + "Checking Balance: " + this.getChecking() + ". Savings Balance: " + this.getSavings() + ".");
    }
}
