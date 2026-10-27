
public interface Bank {
    void addAccount(BankAccount account);

    BankAccount getAccount(int id);

    void listAccounts();
}
