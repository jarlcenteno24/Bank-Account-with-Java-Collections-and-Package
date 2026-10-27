public class main {
   public main() {
   }

   public static void main(String[] var0) {
      SavingsAccount var1 = new SavingsAccount("Test0");
      var1.deposit((double)1000.125F);
      var1.withdraw(599.995);
      System.out.println();
      System.out.println("Transaction history: ");
      System.out.println(var1.getTransactionHistory());
      System.out.println();
      BankAccountManager var2 = new BankAccountManager();
      var2.addAccount(new BankAccount("Test0"));
      var2.addAccount(new BankAccount("Test1"));
      System.out.println();
      var2.listAccounts();
   }
}
