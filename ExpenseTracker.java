import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addExpense() {
        System.out.print("Enter expense category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        expenses.add(new Expense(category, amount));

        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n--- Expense List ---");

        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);

            System.out.println(
                (i + 1) + ". " + e.category + " - Rs." + e.amount
            );
        }
    }

    public static void totalExpense() {
        double total = 0;

        for (Expense e : expenses) {
            total += e.amount;
        }

        System.out.println("Total Expense: Rs." + total);
    }

    public static void deleteExpense() {
        viewExpenses();

        if (expenses.isEmpty()) {
            return;
        }

        System.out.print("Enter expense number to delete: ");
        int number = sc.nextInt();
        sc.nextLine();

        if (number >= 1 && number <= expenses.size()) {
            expenses.remove(number - 1);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid expense number.");
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalExpense();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
