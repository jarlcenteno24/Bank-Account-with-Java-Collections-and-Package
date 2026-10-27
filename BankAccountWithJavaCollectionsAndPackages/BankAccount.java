import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
  private double balance;
  private boolean isFrozen;
  private String ownerName;

  private List<Transaction> transactionHistory;

  public BankAccount() {
    this("Unknown");
  }

  public BankAccount(String ownerName) {
    this.ownerName = ownerName;
    balance = 0;
    isFrozen = false;
    transactionHistory = new ArrayList<>();
  }

  public String getOwnerName() {
    return ownerName;
  }

  private static double roundToTwoDecimals(double amount) {
    return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  public void deposit(double amount) {
    double roundedAmount = roundToTwoDecimals(amount);

    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    balance = roundToTwoDecimals(balance + roundedAmount);
    transactionHistory.add(new Transaction("Deposit", amount));
    System.out.println("Amount deposited: " + roundedAmount);
    System.out.println("Current balance: " + balance);
  }

  public void withdraw(double amount) {
    double roundedAmount = roundToTwoDecimals(amount);
    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    if (balance < roundedAmount) {
      System.out.println("Insufficient balance. Current balance: " + balance);
      return;
    }
    balance = roundToTwoDecimals(balance - roundedAmount);
    transactionHistory.add(new Transaction("Withdraw", amount));
    System.out.println("Amount withdrawn: " + roundedAmount);
    System.out.println("Current balance: " + balance);
  }

  public double getBalance() {
    return balance;
  }

  public void freezeAccount() {
    isFrozen = true;
  }

  public void unfreezeAccount() {
    isFrozen = false;
  }

  public boolean isFrozen() {
    return isFrozen;
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }
}
