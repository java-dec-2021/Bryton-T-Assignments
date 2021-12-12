public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount joe = new BankAccount(5.94, 4.19);
        joe.checkBalance();
        BankAccount marge = new BankAccount();
        marge.depositSavings(50.4);
        marge.checkBalance();
        joe.withdrawChecking(1.4);
        joe.checkBalance();
        System.out.println(BankAccount.totalReserve);
        System.out.println(BankAccount.numOfAccounts);
    }
}
