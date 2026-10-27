import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class BankAccountManager implements Bank {
    private static final int MAX_ACCOUNTS = 100;

    private final Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        accounts = new LinkedHashMap<>();
        id = 0;
    }

    @Override
    public void addAccount(BankAccount account) {
        if (accounts.size() >= MAX_ACCOUNTS) {
            System.out.println("Limit reached! Cannot add more than "
                    + MAX_ACCOUNTS + " accounts.");
            return;
        }

        accounts.put(id, account);
        System.out.println("Added account with id " + id + " (" + accounts.size() + " total)");
        id++;
    }

    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    @Override
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.printf(Locale.US, "ID %d -> %s | Balance: $%.2f%n",
                    entry.getKey(), entry.getValue().getOwnerName(),
                    entry.getValue().getBalance());
        }
    }
}
