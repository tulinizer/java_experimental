package bank;

import gui.BankTable;

/**
 * Object that implements the transfer of money from one account to another in a
 * given bank.
 */
public class TransferRunnable implements Runnable { // number of transfers
	public static final int STEPS = 3000;
	// delay between two transfers
	private final int DELAY = 10;
	// bank which contains accounts
	private Bank bank;
	// maximum amount of a transfer
	private double maxAmount;
	// table showing the bank
	private BankTable table;

	/**
	 * Constructor.
	 * 
	 * @param bank
	 *            the bank in which the accounts belong to treat
	 * @param table
	 *            the table showing the bank
	 */
	public TransferRunnable(Bank bank, BankTable table) {
		this.bank = bank;
		this.table = table;
		this.maxAmount = bank.INITIAL_BALANCE;
	}

	/**
	 * Performs the transfer of money.
	 */
	public void run() {
		try {
			for (int i = 0; i < STEPS; i++) {
				int fromAccount = (int) (bank.NACCOUNTS * Math.random());
				int toAccount = (int) (bank.NACCOUNTS * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				table.repaint();
				Thread.sleep((int) (DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
		}
	}
}
