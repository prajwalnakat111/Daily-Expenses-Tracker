import java.util.*;

class Expense {
    private String name;
    private double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

class ExpenseTracker {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(String name, double amount) {
        expenses.add(new Expense(name, amount));
    }

    public void displayExpenses() {
        System.out.println("\n------ DAILY EXPENSE LIST ------");
        for (Expense e : expenses) {
            System.out.println(e.getName() + " : ₹" + e.getAmount());
        }
    }

    public double getTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public Expense getHighestExpense() {
        Expense max = expenses.get(0);
        for (Expense e : expenses) {
            if (e.getAmount() > max.getAmount()) {
                max = e;
            }
        }
        return max;
    }

    public double getAverage() {
        return getTotal() / expenses.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        System.out.print("Enter number of expenses: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter expense name: ");
            String name = sc.nextLine();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            tracker.addExpense(name, amount);
        }

        tracker.displayExpenses();

        System.out.println("\n------------------------------------");
        System.out.println("Total Expenses : ₹" + tracker.getTotal());
        System.out.println("Average Expense: ₹" + tracker.getAverage());

        Expense highest = tracker.getHighestExpense();
        System.out.println("Highest Expense : " + highest.getName() +
                           " (₹" + highest.getAmount() + ")");
    }
}