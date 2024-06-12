// Java Program to illustrate Rookie Approach
// In Banking transaction system

// Class 1
// Bank class
// Defining the banking transaction
class Bank {

	// Initial balance $100
	int total = 100;

	// Money withdrawal method. Withdraw only if
	// total money greater than or equal to the money
	// requested for withdrawal

	// Method
	// To withdraw money
	void withdrawn(String name, int withdrawal)
	{
		if (total >= withdrawal) {
			System.out.println(name + " withdrawn "
							+ withdrawal);

			total = total - withdrawal;
			System.out.println("Balance after withdrawal: "
							+ total);
			// Making the thread sleep for 1 second after
			// each withdrawal

			// Try block to check for exceptions
			try {

				// Making thread t osleep for 1 second
				Thread.sleep(1000);
			}

			// Catch block to handle the exceptions
			catch (InterruptedException e) {

				// Display the exception along with line
				// number
				// using printStacktrace() method
				e.printStackTrace();
			}
		}

		// If the money requested for withdrawal is greater
		// than the balance then deny transaction*/
		else {

			// Print statements
			System.out.println(name
							+ " you can not withdraw "
							+ withdrawal);

			System.out.println("your balance is: " + total);

			// Making the thread sleep for 1 second after
			// each transaction failure

			// Try block to check for exceptions
			try {
				Thread.sleep(1000);
			}

			catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	// Method - to deposit money
	// Accept money whenever deposited
	void deposit(String name, int deposit)
	{
		System.out.println(name + " deposited " + deposit);
		total = total + deposit;
		System.out.println("Balance after deposit: "
						+ total);
		// Making the thread sleep for 1 second after
		// each deposit
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
// Class 2
// main class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{
		// Declaring an object of Bank class and calling the
		// withdarwn and deposit methods with suitable
		// parameters

		// Creating object of class 1 inside main()
		Bank obj = new Bank();

		// Custom input - Transactions
		obj.withdrawn("Arnab", 20);
		obj.withdrawn("Monodwip", 40);
		obj.deposit("Mukta", 35);
		obj.withdrawn("Rinkel", 80);
		obj.withdrawn("Shubham", 40);
	}
}
