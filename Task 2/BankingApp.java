import java.util.Scanner;

class BankDetails {
    private String accno;
    private String name;
    private String acc_type;
    private long balance;
    Scanner sc = new Scanner(System.in);

    // method to open new account
    public void openAccount() {
        System.out.println("\nEnter Account Holder Detalis : - ");

        System.out.print("\nEnter Account No: ");
        accno = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    // method to display account details
    public void showAccount() {
        System.out.println("\nName of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    // method to deposit money
    public void deposit() {
        long amt;
        System.out.println("\nEnter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    // method to withdraw money
    public void withdrawal() {
        long amt;
        System.out.println("\nEnter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("\nBalance after withdrawal: " + balance);
        } else {
            System.out.println("\nYour balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    // method to search an account number
    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankingApp {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        // create initial accounts
        System.out.print("\nHow many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new BankDetails();
            C[i].openAccount();
        }
        // loop runs until number 5 is not pressed to exit
        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println(
                    "\n1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
            System.out.println("\nEnter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("\nEnter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nSearch failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("\nEnter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nSearch failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("\nEnter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("\nSearch failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("\nSee you soon...");
                    break;
            }
        } while (ch != 5);
    }
}