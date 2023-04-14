import java.util.Scanner;

public class ATM {
    private static int balance = 10000;
    private static String[][] users = {{"user1", "1234"}, {"user2", "5678"}, {"user3", "abcd"}};
    private static String currentUser = "";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the ATM!");
        System.out.println("Please enter your user ID:");
        String userId = scanner.nextLine();
        
        System.out.println("Please enter your PIN:");
        String pin = scanner.nextLine();
        
        if (login(userId, pin)) {
            System.out.println("Login successful. Welcome, " + currentUser + "!");
            
            boolean quit = false;
            while (!quit) {
                System.out.println("Please select an option:");
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        viewTransactions();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        transfer();
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Login failed. Please try again.");
        }
        
        scanner.close();
    }
    
    private static boolean login(String userId, String pin) {
        for (String[] user : users) {
            if (user[0].equals(userId) && user[1].equals(pin)) {
                currentUser = userId;
                return true;
            }
        }
        return false;
    }
    
    private static void viewTransactions() {
        System.out.println("Transactions History:");
        // code to display transactions history
    }
    
    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount to withdraw:");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is " + balance);
            // code to record transaction
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }
    
    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount to deposit:");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Deposit successful. Your new balance is " + balance);
        // code to record transaction
    }
    
    private static void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the user ID to transfer to:");
        String recipient = scanner.nextLine();
        System.out.println("Please enter the amount to transfer:");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Transfer successful. Your new balance is " + balance);
            // code to record transaction and update recipient's balance
        } else {
            System.out.println("Transfer failed. Insufficient balance.");
        }
    }
}
