package bank;

/**
 * Declare a bank which has certain number of bank accounts.
 */
public class Bank { // Total bank account number of the bank
	public final int NACCOUNTS = 10;
	// initial amount placed on the account
	public final double INITIAL_BALANCE = 1000;
	// balances
	private double[] accounts;

	private boolean condition = true;

	/**
	 * Manufacturer performing initialization statements.
	 */
	public Bank() {
		accounts = new double[NACCOUNTS];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = INITIAL_BALANCE;
	}

	/**
	 * Transfer money from one account to another. If the source account poses
	 * no money, the transfer is canceled.
	 * 
	 * @param from
	 *            the source account
	 * @param to
	 *            the target account
	 * @param amount
	 *            the amount transferred
	 */
	public synchronized void transfer(int from, int to, double amount) {

		changeCondition(true);

		if (accounts[from] >= amount) {
			while (!condition)
				try {
					wait();

				} catch (InterruptedException e) {

				}
			System.out.printf(Thread.currentThread() + " : ");
			accounts[from] = accounts[from] - amount;
			System.out.printf("%d-[%.2f�]->%d. ", from, amount, to);
			accounts[to] = accounts[to] + amount;
			System.out.printf("Solde total : %.2f�\n", getTotalBalance());
		}
	}

	/**
	 * returns the amount available in an account.
	 * 
	 * @param cpte
	 *            Account number
	 * @return the amount of the account
	 */
	public double getBalance(int cpte) {
		return accounts[cpte];
	}

	public synchronized void changeCondition(boolean nouvelleCondition) {
		condition = nouvelleCondition;
		notifyAll();
	}

	/**
	 * Calculated the sum of the amounts available in the accounts.
	 * 
	 * @return total amount
	 */
	public double getTotalBalance() {
		double sum = 0;
		for (int i = 0; i < NACCOUNTS; i++)
			sum = sum + accounts[i];
		return sum;
	}
}
