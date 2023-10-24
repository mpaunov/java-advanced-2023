import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<Integer, BankAccount> bank = new HashMap<>();

        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            if (command.equals("Create")) {
                create(bank);
            } else if (command.equals("Deposit")) {
                deposit(bank, tokens);
            } else if (command.equals("SetInterest")) {
                setInterest(Double.parseDouble(tokens[1]));
            } else {
                printInterest(bank, tokens);
            }

            line = scanner.nextLine();
        }

    }

    private static void printInterest(Map<Integer, BankAccount> bank, String[] tokens) {
        int id = Integer.parseInt(tokens[1]);

        if (!checkAccountExists(bank, id)) {
            return;
        }
        BankAccount account = bank.get(id);
        int years = Integer.parseInt(tokens[2]);

        System.out.printf("%.2f%n", account.getInterest(years));
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void create(Map<Integer, BankAccount> bank) {
        BankAccount account = new BankAccount();
        bank.put(account.getId(), account);
        System.out.println("Account ID" + account.getId() + " created");
    }

    private static void deposit(Map<Integer, BankAccount> bank, String[] tokens) {
        int id = Integer.parseInt(tokens[1]);

        if(!checkAccountExists(bank, id)) {
            return;
        }

        int amount = Integer.parseInt(tokens[2]);
        BankAccount account = bank.get(id);

        account.deposit(amount);
        System.out.println("Deposited " + amount + " to ID" + id);

    }

    public static boolean checkAccountExists(Map<Integer, BankAccount> bank, int id) {
        if (!bank.containsKey(id)) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }

}
